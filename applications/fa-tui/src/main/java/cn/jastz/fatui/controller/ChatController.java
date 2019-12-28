package cn.jastz.fatui.controller;

import cn.jastz.fatui.entity.Chat;
import cn.jastz.fatui.mapper.ChatMapper;
import cn.jastz.page.domain.Page;
import cn.jastz.page.domain.PageList;
import cn.jastz.page.domain.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangzhiwen on 2019/12/21
 **/
@RestController
public class ChatController {
    @Autowired
    private ChatMapper chatMapper;

    @PostMapping("/chat/page")
    public Page<Chat> page(@RequestBody PageRequest pageRequest){
        PageList<Chat> pageList = chatMapper.selectPage(pageRequest, Sort.by("create_time").descending());
        return pageList.getPage();
    }
}
