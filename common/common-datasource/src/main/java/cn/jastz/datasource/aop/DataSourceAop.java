package cn.jastz.datasource.aop;

import cn.jastz.datasource.DBContextHolder;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DataSourceAop {

    @Pointcut("execution(* *.select*(..))||execution(* *.query*(..))")
    public void readPointcut(){

    }

    @Pointcut("execution(* *.inset*(..))||execution(* *.add*(..))||execution(* *.delete*(..))||execution(* *.update*(..))")
    public void writePointcut(){

    }


    @Before("readPointcut()")
    public void read(){
        DBContextHolder.slave();
    }

    @Before("writePointcut()")
    public void write(){
        DBContextHolder.master();
    }
}
