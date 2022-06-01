package cc.tianbin.pattern.domain.support.entity;

/**
 * DDD中每一个实体都必须拥有一个id
 * @param <T>
 */
public interface Entity<T> {

    /**
     * 得到实体的唯一标识
     */
    T getUniqueId();

}
