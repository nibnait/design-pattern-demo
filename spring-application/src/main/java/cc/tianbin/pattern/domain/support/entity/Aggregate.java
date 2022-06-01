package cc.tianbin.pattern.domain.support.entity;

import lombok.Data;

/**
 * 聚合
 * @param <E> 聚合根Id
 * @param <T> 聚合根
 */
@Data
public class Aggregate<E, T extends Entity<E>> {

    private T aggregateRoot;

    public E getAggregateId() {
        return aggregateRoot.getUniqueId();
    }

}
