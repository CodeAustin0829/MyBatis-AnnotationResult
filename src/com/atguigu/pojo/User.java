package com.atguigu.pojo;

/**
 * @Description
 * @Author Austin
 * @Date 2020/12/2 9:17
 */
public class User {
    private Integer id;
    private String lastName;
    private Integer sex;

    //mybatis中必须加入无参构造
    public User() {
    }

    //一定要get set,否则 结果映射不进去
    public User(Integer id) {
        this.id = id;
    }

    public User(String lastName) {
        this.lastName = lastName;
    }

    public User(Integer id, String lastName, Integer sex) {
        this.id = id;
        this.lastName = lastName;
        this.sex = sex;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", last_name='" + lastName + '\'' +
                ", sex=" + sex +
                '}';
    }
}
