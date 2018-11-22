package cn.jastz;

import cn.jastz.express.service.ExpressServiceApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zhiwen
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ExpressServiceApplication.class)
@ActiveProfiles("ubox")
public class ExpressApplicationTest {


    @Test
    public void test() {

    }

}
