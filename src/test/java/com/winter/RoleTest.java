package com.winter;

import com.winter.dao.RoleDao;
import com.winter.dao.UserDao;
import com.winter.domain.Role;
import com.winter.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

//测试MyBatis的CRUD
public class RoleTest {
    private InputStream in;
    private SqlSession sqlSession;
    private RoleDao roleDao;

    @Before  //在测试方法执行前执行
    public void init() throws Exception{
        //1、读取配置文件，生成字节输入流
       in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2、获取SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3、获取SqlSession对象
        sqlSession = factory.openSession();
        //4、获取dao的代理对象
        roleDao = sqlSession.getMapper(RoleDao.class);
    }
    @After //测试方法执行后执行
    public void destroy() throws Exception{
        //提交事务
        sqlSession.commit();
        //6、释放资源
        sqlSession.close();
        in.close();
    }
    //测试查询所有
    @Test
    public void testFindAll() {
        //5、执行查询所有方法
        List<Role> roles = roleDao.findAll();
        for (Role role : roles) {
            System.out.println(role);
            System.out.println(role.getPersons());
        }
    }
}