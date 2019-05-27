package com.baiyu.hello.pojo;

import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProductMapper {
    @Select("SELECT * FROM product WHERE cid = #{cid}")
    public List<Product> list(int cid);
}
