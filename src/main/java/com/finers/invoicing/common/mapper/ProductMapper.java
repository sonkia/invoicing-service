package com.finers.invoicing.common.mapper;

import com.finers.invoicing.common.entity.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductMapper {

    /**
     * 新增
     */
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

    /**
     * 更新
     */
    @Update("<script>" +
            "update product set " +
            "<if test='name != null'>name = #{name}, </if> " +
            "<if test='code != null'>code = #{code}, </if> " +
            "<if test='description != null'>description = #{description}, </if> " +
            "<if test='productType != null'>product_type = #{productType}, </if> " +
            "<if test='unitCount != null'>unit_count = #{unitCount}, </if> " +
            "id = id " +
            "where id = #{id} " +
            "</script> ")
    void update(Product product);

    /**
     * 删除
     */
    @Delete("delete from product where id = #{id}")
    void delete(String id);


    /**
     * 分页查询
     * @param condition
     * @param start 开始位置
     * @param offset 偏移量
     * @return 列表
     */
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

    /**
     *
     * @param code
     * @param id
     * @return
     */
    @Select("<script>" +
            "select count(*) from product " +
            "where code = #{code} " +
            "<if test='id != null'> and id != #{id} " +
            "</if> " +
            "</script>")
    Integer checkCodeRepeat(@Param("code")String code,@Param("id") String id);
}
