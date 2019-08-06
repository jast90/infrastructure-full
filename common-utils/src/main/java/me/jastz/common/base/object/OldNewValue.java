package me.jastz.common.base.object;

/**
 * Created by zhiwen on 2017/3/29.
 */
public class OldNewValue<T> {
    private T oldValue;
    private T newValue;

    public OldNewValue(T oldValue, T newValue) {
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

    public T getOldValue() {
        return oldValue;
    }

    public void setOldValue(T oldValue) {
        this.oldValue = oldValue;
    }

    public T getNewValue() {
        return newValue;
    }

    public void setNewValue(T newValue) {
        this.newValue = newValue;
    }

    @Override
    public String toString() {
        return "{\"_class\":\"OldNewValue\", " +
                "\"oldValue\":" + (oldValue == null ? "null" : oldValue) + ", " +
                "\"newValue\":" + (newValue == null ? "null" : newValue) +
                "}";
    }
}
