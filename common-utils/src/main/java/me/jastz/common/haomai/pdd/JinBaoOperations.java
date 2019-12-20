package me.jastz.common.haomai.pdd;

import me.jastz.common.haomai.pdd.domain.PddBaoBei;
import me.jastz.common.haomai.pdd.domain.QueryForm;

import java.util.List;

/**
 * @author zhangzhiwen on 2019/12/6
 **/
public interface JinBaoOperations {
    List<PddBaoBei> page(QueryForm queryForm);
}
