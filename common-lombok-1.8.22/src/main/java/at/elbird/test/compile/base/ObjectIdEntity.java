package at.elbird.test.compile.base;

public interface ObjectIdEntity<T> extends BaseIdEntity {
    T getId();
    void setId(T id);
}
