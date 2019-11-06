package cn.jastz.datasource.aop;

import cn.jastz.datasource.DBContextHolder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DataSourceAop {

    @Pointcut("execution(* cn.jastz.*.select*(..))||execution(* cn.jastz.*.query*(..))")
    public void readPointcut(){

    }

    @Pointcut("execution(* cn.jastz.*.inset*(..))||execution(* cn.jastz.*.add*(..))||execution(* cn.jastz.*.delete*(..))||execution(* cn.jastz.*.update*(..))")
    public void writePointcut(){

    }

    @Pointcut("@annotation(cn.jastz.datasource.MyDataSource)")
    public void stackWritePointcut(){

    }


    @Before("readPointcut()")
    public void read(){
        DBContextHolder.slave();
    }

    @Before("writePointcut()")
    public void write(){
        DBContextHolder.master();
    }

    @Before("stackWritePointcut()")
    public void stackWrite(){
        DBContextHolder.stack();
    }
}
