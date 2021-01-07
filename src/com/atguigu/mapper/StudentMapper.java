package com.atguigu.mapper;

import com.atguigu.pojo.Student;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

/**
 * @Description
 * @Author Austin
 * @Date 2020/12/2 9:22
 */
public interface StudentMapper {
    @Results({
            @Result(id = true,column = "sid",property = "id"),
            @Result(id = false,column = "sname",property = "name"),
            @Result(id = false,column = "tname",property = "teacher.name"),
            @Result(id = false,column = "tid",property = "teacher.id")
    })
    @Select("SELECT\n" +
            "\tstu.id as sid,\n" +
            "\tstu.NAME as sname,\n" +
            "\ttea.`name` as tname, \n" +
            "\ttea.`id` as tid \n" +
            "FROM\n" +
            "\tt_student stu\n" +
            "\tLEFT JOIN t_teacher tea ON stu.teacher_id = tea.id \n" +
            "WHERE\n" +
            "\tstu.id = #{id};")
    Student selectStuAndTea(Integer id);

    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(id = false,column = "name",property = "name"),
            @Result(id=false,column = "teacher_id",property = "teacher",
                    one = @One(select = "com.atguigu.mapper.TeacherMapper.selectTeaById",fetchType = FetchType.LAZY))
    })
    //property = "teacher"，是将teacher_id封装到teacher类中
    //property = "teacher.id"，是将teacher_id封装到teacher类的id中
    @Select("select `id`,name,teacher_id from t_student where id = #{id}")
    Student selectStuAndTeaTwo(Integer id);

}
