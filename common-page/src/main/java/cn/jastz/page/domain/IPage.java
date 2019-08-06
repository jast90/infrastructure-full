package cn.jastz.page.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * @author zhiwen
 */
@JsonDeserialize(as = Page.class)
public interface IPage<T> extends Slice<T> {

    /**
     * Returns the number of total pages.
     *
     * @return the number of total pages
     */
    int getTotalPages();

    /**
     * Returns the total amount of elements.
     *
     * @return the total amount of elements
     */
    long getTotalElements();
}
