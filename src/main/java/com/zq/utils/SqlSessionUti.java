package com.zq.utils;/**
 * @Author: YourName
 * @Date: Created in 2020/11/7 19:34
 * @Description: TODO
 * @Version: 1.0
 */


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 *@author LZQ
 *@date 2020/11/7 19:34
 */
public class SqlSessionUti {
    private static SqlSessionFactory factory = null;
    static String config = "mybatis-config.xml";
    static InputStream in;
    static {
        try {
            in = Resources.getResourceAsStream(config);
        } catch (IOException e) {
            e.printStackTrace();
        }
        factory = new SqlSessionFactoryBuilder().build(in);
    }


    public static org.apache.ibatis.session.SqlSession getSqlSession(){
        if(factory != null){
            return factory.openSession(true);
        }
        return null;
    }


}
