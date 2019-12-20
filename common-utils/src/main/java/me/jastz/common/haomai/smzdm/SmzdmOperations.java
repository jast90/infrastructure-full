package me.jastz.common.haomai.smzdm;

import me.jastz.common.haomai.smzdm.domain.Category;

import java.io.IOException;
import java.util.List;

/**
 * @author zhangzhiwen on 2019/12/6
 **/
public interface SmzdmOperations {

    /**
     * 获取什么值得买的分类
     *
     * @return
     */
    List<Category> getCategories() throws IOException;

}
