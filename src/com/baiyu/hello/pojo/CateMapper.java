package com.baiyu.hello.pojo;

import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CateMapper {
    @Insert("INSERT INTO cate(name) VALUES(#{name})")
    public int add(Cate cate);
    @Delete("DELETE FROM cate WHERE id = #{id}")
    public void del(int id);
    @Update("UPDATE cate SET name = #{name} WHERE id = #{id}")
    public void edit(Cate cate);
    @Select("SELECT * FROM cate WHERE id = #{id}")
    public Cate get(int id);
    @Select("SELECT * FROM cate")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "products", javaType = List.class, column = "id", many = @Many(select = "com.baiyu.hello.pojo.ProductMapper.list"))
    })
    public List<Cate> list();
    @Select("SELECT * FROM cate LIMIT #{start},#{count}")
    public List<Cate> page(@Param("start") int start, @Param("count") int count);
}
