package com.rhl.mybatis_1.mapper;

import com.rhl.mybatis_1.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestUserMapper {

    /**
     * 查询所有
     */
    @Test
    public void selAllUser(){
        /*
            1、读取mybatis-config.xml的配置文件
             InputStream in = Resources.getResourceAsStream("mybatis-config.xml");

            2、根据文件创建SqlSessionFactory对象，获取sql会话对象
            SqlSessionFactory ssf =new SqlSessionFactoryBuilder().build(in);

            3、由sql会话对象执行sql
            SqlSession ss = ssf.openSession();
            List<User> users = ss.selectList("mapper.UserMapper.selAllUser");
         */
        try{
            InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory ssf =new SqlSessionFactoryBuilder().build(in);
            SqlSession ss = ssf.openSession();
            List<User> users = ss.selectList("mapper.UserMapper.selectAllUser");
            for (User user : users){
                System.out.println(user);
            }

            //提交事务
            ss.commit();

            //关闭SqlSession
            ss.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * 添加
     */
    @Test
    public void addUser(){

        try {
            //1、读取mybatis-config.xml的配置文件
            InputStream in = Resources.getResourceAsStream("mybatis-config.xml");

            //2、根据文件创建SqlSessionFactory对象，获取sql会话对象
            SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(in);

            //3、由sql会话对象执行sql
            SqlSession ss = ssf.openSession();
            User user = new User();
//            user.setUserId(1111);
            user.setUserName("赵云");
            user.setPassword("admin");

            System.out.println("u1"+user);
            int add = ss.insert("mapper.UserMapper.addUser",user);
            System.out.println(add);

            ss.commit();

            ss.close();

            System.out.println("u2"+user);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * 根据名字查询（多条）
     */
    @Test
    public void selectByName(){
        try {
            InputStream in = Resources.getResourceAsStream("mybatis-config.xml");

            SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(in);

            SqlSession ss = ssf.openSession();
            User u = new User();
            List<User> user = ss.selectList("mapper.UserMapper.selectByName","赵云");
            for(User us : user){
                System.out.println(us);
            }

            ss.commit();

            ss.close();
        }catch (IOException e){

        }
    }

    /**
     * 删除
     */
    @Test
    public void delUser(){
        try {
            InputStream in = Resources.getResourceAsStream("mybatis-config.xml");

            SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(in);

            SqlSession ss = ssf.openSession();

            int rs = 0;

            rs = ss.delete("mapper.UserMapper.delUser", 1011);

            System.out.println(rs);

            ss.commit();

            ss.close();
        }catch (IOException e){

        }

    }



}
