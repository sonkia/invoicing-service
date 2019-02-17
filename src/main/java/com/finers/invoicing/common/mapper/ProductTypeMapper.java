package com.finers.invoicing.common.mapper;

import com.finers.invoicing.common.entity.ProductType;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProductTypeMapper {

    @Insert("INSERT INTO product_type " +
            "(id, name,code,description) " +
            "VALUES(" +
            "#{id}," +
            "#{name}," +
            "#{code}," +
            "#{description})")
    void add(ProductType productType);

    @Select("<script>" +
            "select * from product_type " +
            "where " +
            "<if test='condition != null'>name like concat('%',#{condition},'%') " +
            "or code like concat('%',#{condition},'%') " +
            "</if> " +
            "limit #{start},#{offset} " +
            "</script> ")
    List<ProductType> list(@Param("condition") String condition, @Param("start") Integer start, @Param("offset") Integer offset);

    @Select("select name from product_type")
    List<String> getProductTypeNames();

    @Select("<script>" +
            "select count(*) from product_type " +
            "where name = #{name} " +
            "<if test='id != null'> and id != #{id} " +
            "</if> " +
            "</script>")
    Integer checkNameRepeat(@Param("name")String name,@Param("id") String id);
}
