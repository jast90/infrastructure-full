package cn.jastz.account;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.SignInAdapter;
import org.springframework.web.context.request.NativeWebRequest;

public class MySignInAdapter implements SignInAdapter {

    public MySignInAdapter() {
        System.out.println("MySignInAdapter init");
    }

    @Override
    public String signIn(String userId, Connection<?> connection, NativeWebRequest request) {
        System.out.println(userId);
        return "/";
    }
}
