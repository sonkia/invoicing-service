package com.finers.invoicing.common.mapper;

import com.finers.invoicing.common.entity.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProductMapper {

    @Insert("INSERT INTO product " +
            "(id, name,code,product_type,description,unit_count) " +
            "VALUES(" +
            "#{id}," +
            "#{name}," +
            "#{code}," +
            "#{productType}," +
            "#{description}," +
            "#{unitCount})")
    void add(Product product);

    @Select("<script>" +
            "SELECT * from product " +
            "where " +
            "<if test='condition != null'>name like concat('%',#{condition},'%') " +
            "or code like concat('%',#{condition},'%') " +
            "or product_type like concat('%',#{condition},'%') " +
            "</if> " +
            "limit #{start},#{offset} " +
            "</script> ")
    List<Product> list(@Param("condition") String condition, @Param("start") Integer start, @Param("offset") Integer offset);

    @Select("<script>" +
            "select count(*) from product " +
            "where name = #{name} " +
            "<if test='id != null'> and id != #{id} " +
            "</if> " +
            "</script>")
    Integer checkNameRepeat(@Param("name")String name,@Param("id") String id);
}
