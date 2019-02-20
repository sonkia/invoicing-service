package com.finers.invoicing.common.mapper;

import com.finers.invoicing.common.entity.ProductType;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProductTypeMapper {

    /**
     * 新增
     */
    @Insert("INSERT INTO product_type " +
            "(id, name,code,description) " +
            "VALUES(" +
            "#{id}," +
            "#{name}," +
            "#{code}," +
            "#{description})")
    void add(ProductType productType);

    /**
     * 分页查询
     * @param condition
     * @param start 开始位置
     * @param offset 偏移量
     * @return 列表
     */
    @Select("<script>" +
            "select * from product_type " +
            "where " +
            "<if test='condition != null'>name like concat('%',#{condition},'%') " +
            "or code like concat('%',#{condition},'%') " +
            "</if> " +
            "limit #{start},#{offset} " +
            "</script> ")
    List<ProductType> list(@Param("condition") String condition, @Param("start") Integer start, @Param("offset") Integer offset);

    /**
     * 查询产品类型名称列表
     * @return
     */
    @Select("select name from product_type")
    List<String> getProductTypeNames();

    /**
     *
     * @param name
     * @param id
     * @return
     */
    @Select("<script>" +
            "select count(*) from product_type " +
            "where name = #{name} " +
            "<if test='id != null'> and id != #{id} " +
            "</if> " +
            "</script>")
    Integer checkNameRepeat(@Param("name")String name,@Param("id") String id);
}
