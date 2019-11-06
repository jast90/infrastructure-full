package cn.jastz.datasource;

public class DBContextHolder {
    private static final ThreadLocal<DBTypeEnum> contextHolder = new ThreadLocal<>();

    public static void set(DBTypeEnum dbTypeEnum){
        contextHolder.set(dbTypeEnum);
    }

    public static DBTypeEnum get(){
        return contextHolder.get();
    }

    public static void master(){
        set(DBTypeEnum.MASTER);
    }

    public static void slave(){
        // TODO 扩展多个slave
        set(DBTypeEnum.SLAVE);
    }

    public static void stack(){
        set(DBTypeEnum.STACK);
    }
}
