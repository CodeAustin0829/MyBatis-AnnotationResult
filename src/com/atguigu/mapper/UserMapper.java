package com.atguigu.mapper;

import com.atguigu.pojo.User;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Description
 * @Author Austin
 * @Date 2020/12/2 9:20
 */
public interface UserMapper {
    @Results({
            @Result(id=true,column = "id",property = "id"),
            @Result(id = false,column = "last_name",property = "lastName"),
            @Result(id=false,column = "sex",property = "sex")
    })
    @Select("select `id`,last_name,sex from t_user")
    List<User> selectUserAll();
}
