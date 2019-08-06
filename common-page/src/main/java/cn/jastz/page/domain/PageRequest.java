package cn.jastz.page.domain;

/**
 * 分页请求参数（暴露页码、每页个数）
 *
 * @author zhiwen
 */
public class PageRequest extends AbstractPageRequest {

    public PageRequest() {
        super(0, 15);
    }

    public PageRequest(int page, int size) {
        super(page, size);
    }

    public static PageRequest of(int page, int size) {
        return new PageRequest(page, size);
    }

    @Override
    public Pageable next() {
        return new PageRequest(getPageNumber() + 1, getPageSize());
    }

    @Override
    public Pageable previousOrFirst() {
        return getPageNumber() == 0 ? this : new PageRequest(getPageNumber() - 1, getPageSize());
    }

    @Override
    public Pageable first() {
        return new PageRequest(0, getPageSize());
    }

}
