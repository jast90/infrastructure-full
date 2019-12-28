package cn.jastz.fatui.service;

import cn.jastz.fatui.entity.Store;
import cn.jastz.fatui.mapper.StoreMapper;
import cn.jastz.page.domain.Page;
import cn.jastz.page.domain.PageList;
import cn.jastz.page.domain.PageRequest;
import me.jastz.common.json.result.IResult;
import me.jastz.common.json.result.SampleResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * @author zhangzhiwen on 2019/12/21
 **/
@Service
public class StoreService {
    @Autowired
    private StoreMapper storeMapper;

    public IResult add(Store store) {
        if(storeMapper.insert(store)>0){
            return SampleResult.SUCCESS;
        }
        return SampleResult.FAIL;
    }

    public Page<Store> page(PageRequest pageRequest, Sort sort){
        PageList<Store> list =  storeMapper.selectPage(pageRequest,sort);
        return list.getPage();
    }
}
