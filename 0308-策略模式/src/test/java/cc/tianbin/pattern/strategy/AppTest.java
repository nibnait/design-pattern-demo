package cc.tianbin.pattern.strategy;

import cc.tianbin.pattern.strategy.bo.ItemsSku;
import cc.tianbin.pattern.strategy.bo.ItemsType;
import cc.tianbin.pattern.strategy.impl.LastRewardPMCalc;
import cc.tianbin.pattern.strategy.impl.LuckyBagPMCalc;
import cc.tianbin.pattern.strategy.impl.MagicRewardPMCalc;
import cc.tianbin.pattern.strategy.impl.NormalPMCalc;
import com.google.common.collect.Lists;
import io.github.nibnait.common.utils.DataUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.List;

/**
 * Created by nibnait on 2022/05/31
 */
@Slf4j
public class AppTest {

    @Test
    public void test() {
        List<ItemsSku> itemsSkuList = getItemsSkuPriceBOList();

        log.info("计算利润率前 itemsSkuList: {}", DataUtils.toJsonStringArray(itemsSkuList));

        for (ItemsSku itemsSku : itemsSkuList) {
            ItemsType itemsType = ItemsType.getByCode(itemsSku.getType());
            switch (itemsType) {
                case LAST_REWARD:
                    LastRewardPMCalc lastRewardPMCalc = new LastRewardPMCalc(itemsSku);
                    itemsSku.setPmRate(lastRewardPMCalc.calc());
                    break;
                case LUCKY_BAT:
                    LuckyBagPMCalc luckyBagPMCalc = new LuckyBagPMCalc(itemsSku);
                    itemsSku.setPmRate(luckyBagPMCalc.calc());
                    break;
                case MAGIC_REWARD:
                    MagicRewardPMCalc magicRewardPMCalc = new MagicRewardPMCalc(itemsSku);
                    itemsSku.setPmRate(magicRewardPMCalc.calc());
                    break;
                default:
                    NormalPMCalc normalPMCalc = new NormalPMCalc(itemsSku);
                    itemsSku.setPmRate(normalPMCalc.calc());
                    break;
            }
        }

        log.info("计算利润率后 itemsSkuList: {}", DataUtils.toJsonStringArray(itemsSkuList));
    }

    private List<ItemsSku> getItemsSkuPriceBOList() {
        ItemsSku lastReward = new ItemsSku(1);
        ItemsSku luckyBag = new ItemsSku(2);
        ItemsSku magicReward = new ItemsSku(3);
        ItemsSku normal = new ItemsSku(4);

        return Lists.newArrayList(lastReward, luckyBag, magicReward, normal);
    }
}
