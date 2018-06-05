package cn.jastz.open.mapper;

import cn.jastz.open.entity.App;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

/**
 * @author zhiwen
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppMapperTest {

    @Autowired
    public AppMapper appMapper;

    @Test
    public void add() {
        App app = new App();
        app.setAppId(UUID.randomUUID().toString().replace("-", ""));
        app.setAppSecret(UUID.randomUUID().toString().replace("-", ""));
        app.setDomain("www.jastz.cn");
        int i = appMapper.insert(app);
        Assert.assertTrue(i > 0);
    }
}
