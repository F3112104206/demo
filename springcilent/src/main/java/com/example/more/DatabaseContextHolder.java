package com.example.more;


/**
 * 保存一个线程安全的DatabaseType容器
 */
public class DatabaseContextHolder {

    private static final ThreadLocal<DataSourceType> contextHolder = new ThreadLocal<>();

    public static void setDatabaseType(DataSourceType type){
        contextHolder.set(type);
    }

    public static DataSourceType getDatabaseType(){
        return contextHolder.get();
    }
}
