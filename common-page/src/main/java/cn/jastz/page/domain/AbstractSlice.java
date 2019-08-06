package cn.jastz.page.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhiwen
 */
public abstract class AbstractSlice<T> implements Slice<T> {

    private final List<T> content = new ArrayList<>();
    private Pageable pageable;

    public AbstractSlice(List<T> content, Pageable pageable) {
        if (content == null) {
            throw new IllegalArgumentException("Content can not null.");
        }
        if (pageable == null) {
            throw new IllegalArgumentException("Pageable can not null.");
        }
        this.pageable = pageable;
        this.content.addAll(content);
    }

    @Override
    public int getNumber() {
        return pageable.getPageNumber();
    }

    @Override
    public int getSize() {
        return pageable.getPageSize();
    }

    @Override
    public int getNumberOfElements() {
        return content.size();
    }

    @Override
    public List<T> getContent() {
        return content;
    }

    @Override
    public boolean hasContent() {
        return content.isEmpty() == false;
    }

    @Override
    public boolean isFirst() {
        return pageable.getPageNumber() == 0;
    }

    @Override
    public boolean isLast() {
        return !hasNext();
    }

}
