package com.ycshang.web.exercise.mapper;

import com.ycshang.web.exercise.entity.Brand;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author ycshang
 */
public interface BrandMapper {
    /**
     * 查询所有商品
     *
     * @return
     */
    @Select("SELECT * FROM tb_brand ORDER BY ordered")
    List<Brand> selectAll();

    /**
     * 新增商品
     *
     * @param brand
     */
    @Insert("INSERT INTO tb_brand VALUES (null,#{brandName},#{companyName},#{ordered},#{description},#{status}) ")
    void add(Brand brand);

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @Select("SELECT * FROM tb_brand WHERE id=#{id}")
    Brand selectById(int id);

    /**
     * 修改商品信息
     *
     * @param brand
     */
    @Update("UPDATE tb_brand SET brand_name = #{brandName},company_name = #{companyName},ordered = #{ordered},description = #{description},status = #{status} WHERE id = #{id} ")
    void update(Brand brand);

    /**
     * 删除商品
     *
     * @param id
     */
    @Delete("DELETE FROM tb_brand WHERE id=#{id}")
    void deleteById(int id);
}
