package cn.jastz.page.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * 分页的具体实现
 *
 * @author zhiwen
 */
public class Page<T> extends AbstractSlice<T> implements IPage<T> {

    private long total;
    private Pageable pageable;

    public Page(Pageable pageable, long total) {
        super(Lists.newArrayList(), pageable);
        this.pageable = pageable;
        this.total = total;
    }

    public Page() {
        this(Lists.newArrayList(), PageRequest.of(1, 15), 0);
    }

    public Page(List<T> content, Pageable pageable, long total) {
        super(content, pageable);
        this.pageable = pageable;
        //TODO 计算总记录数逻辑完善
        this.total = total;
    }

    @JsonCreator
    public Page(@JsonProperty("content") List<T> content, @JsonProperty("number") int number
            , @JsonProperty("size") int size, @JsonProperty("total") long total) {
        super(content, PageRequest.of(number, size));
        this.total = total;
        this.pageable = PageRequest.of(number, size);
    }

    @JsonProperty("totalPages")
    @Override
    public int getTotalPages() {
        return getSize() == 0 ? 1 : (int) Math.ceil((double) total / (double) getSize());
    }

    @JsonProperty("totalElements")
    @Override
    public long getTotalElements() {
        return total;
    }

    @Override
    public boolean hasNext() {
        return getNumber() + 1 < getTotalPages();
    }

    @Override
    public boolean isLast() {
        return !hasNext();
    }

    @Override
    public boolean hasPrevious() {
        return getNumber() - 1 != 0;
    }

    @Override
    public String toString() {
        return "{\"_class\":\"Page\", " +
                "\"total\":\"" + total + "\"" + ", " +
                "\"pageable\":" + (pageable == null ? "null" : pageable) +
                "}";
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
