package me.jastz.common.haomai.pdd;

import com.google.common.collect.Maps;
import me.jastz.common.haomai.pdd.domain.PddBaoBei;
import me.jastz.common.haomai.pdd.domain.QueryForm;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

/**
 * @author zhangzhiwen on 2019/12/6
 **/
public class JinBaoOperationsImpl implements JinBaoOperations{

    private RestTemplate restTemplate;

    public JinBaoOperationsImpl() {
        restTemplate = new RestTemplate();
    }

    public JinBaoOperationsImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<PddBaoBei> page(QueryForm queryForm){
        Map<String,Object> param = Maps.newHashMap();
        param.put("categoryId",queryForm.getCategoryId());
       restTemplate.postForEntity(PddJinBaoURLs.bao_bei_url.getUrl(),queryForm,PddBaoBei.class);
        return null;
    }
}
