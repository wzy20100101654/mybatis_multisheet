package com.winter;

import com.winter.dao.PersonDao;
import com.winter.dao.RoleDao;
import com.winter.domain.Person;
import com.winter.domain.Role;
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
public class PersonTest {
    private InputStream in;
    private SqlSession sqlSession;
    private PersonDao personDao;

    @Before  //在测试方法执行前执行
    public void init() throws Exception{
        //1、读取配置文件，生成字节输入流
       in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2、获取SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3、获取SqlSession对象
        sqlSession = factory.openSession();
        //4、获取dao的代理对象
        personDao = sqlSession.getMapper(PersonDao.class);
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
        List<Person> persons = personDao.findAll();
        for (Person person : persons) {
            System.out.println(person);
            System.out.println(person.getRoles());
        }
    }
}