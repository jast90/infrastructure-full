package cn.jastz.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.SignInAdapter;
import org.springframework.web.context.request.NativeWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MySignInAdapter implements SignInAdapter {

    @Autowired
    private HttpServletRequest httpServletRequest;

    @Autowired
    private HttpServletResponse response;

    public MySignInAdapter() {
        System.out.println("MySignInAdapter init");
    }

    @Override
    public String signIn(String userId, Connection<?> connection, NativeWebRequest request) {
        System.out.println(userId);
        HttpSession session  = httpServletRequest.getSession();
        session.setAttribute("uid",userId);
        //TODO 登入成功时，做登入成功逻辑
        return "/";
    }
}
