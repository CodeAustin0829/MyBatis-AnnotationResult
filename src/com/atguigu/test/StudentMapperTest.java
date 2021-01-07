package com.atguigu.test;

import com.atguigu.mapper.StudentMapper;
import com.atguigu.pojo.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Description
 * @Author Austin
 * @Date 2020/12/2 9:27
 */
public class StudentMapperTest {
    InputStream inputStream = null;
    SqlSessionFactory sessionFactory = null;
    SqlSession sqlSession = null;
    StudentMapper studentMapper = null;

    @Before
    public void init() throws IOException {
        inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sessionFactory.openSession(true);
        studentMapper = sqlSession.getMapper(StudentMapper.class);
    }

    @After
    public void destory() {
        sqlSession.close();
    }


    @Test
    public void testSelectStuAndTea() {
        Student student = studentMapper.selectStuAndTea(2);
        System.err.println(student);
    }

    @Test
    public void testSelectStuAndTeaTwo() {
        Student student = studentMapper.selectStuAndTeaTwo(2);
        System.err.println(student.getName());
        System.err.println("===============");
        System.err.println(student.getTeacher().getName());
    }

}
