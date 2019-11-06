package cn.jastz.store;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author zhiwen
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = StoreServiceApplication.class)
public class BaseTest<T> {
    protected Logger log = LoggerFactory.getLogger(getClass());
    @Autowired
    protected T service;
    private int threadSize = Runtime.getRuntime().availableProcessors();
    protected ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(threadSize,threadSize,0,
            TimeUnit.SECONDS,new LinkedBlockingDeque<>(1000));
    protected String getAppId() {
        return "30b1b99af55f4936a6d03440b77b8cce";
    }


    {
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                log.error("thread:{},message:{},e:{}",t.getName(),e.getMessage(),e);
            }
        });
    }

}
