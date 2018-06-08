package cn.jastz.open.mapper;

import cn.jastz.open.entity.App;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zhiwen
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppMapperTest {

    @Autowired
    public AppMapper appMapper;

    @Test
    public void addAccount() {
        addApp("account", "www.jastz.cn/account");
    }

    private void addApp(String account, String s) {
        App app = new App();
        app.setAppId(account);
        app.setAppSecret(account);
        app.setDomain(s);
        int i = appMapper.insert(app);
        Assert.assertTrue(i > 0);
    }

    @Test
    public void addPayment() {
        addApp("payment", "www.jastz.cn/payment");
    }
}
