package me.jastz.common.stackoverflow;

import me.jastz.common.stackoverflow.vo.UserVo;

import java.util.List;

/**
 * @author zhiwen
 */
public interface SofUserOperations {

    List<UserVo> page(int page, String tab, String filter);
}
