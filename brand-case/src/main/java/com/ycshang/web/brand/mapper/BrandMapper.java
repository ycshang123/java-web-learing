package com.ycshang.web.brand.mapper;

import com.ycshang.web.brand.pojo.Brand;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author ycshang
 */
public interface BrandMapper {
    /**
     * 查询总数
     *
     * @return
     */
    @Select("SELECT * FROM tb_brand ORDER BY ordered ASC")
    List<Brand> selectAll();

    /**
     * 添加商品
     *
     * @param brand
     */
    @Insert("INSERT INTO tb_brand VALUES(NULL,#{brandName},#{companyName},#{ordered},#{description},#{status})")
    void add(Brand brand);

    /**
     * 批量删除
     *
     * @param ids
     */
    void deleteByIds(@Param("ids") int[] ids);

    /**
     * 批量查找
     *
     * @param begin
     * @param size
     * @return
     */
    @Select("SELECT * FROM tb_brand LIMIT #{begin},#{size}")
    List<Brand> selectByPages(@Param("begin") int begin, @Param("size") int size);

    /**
     * 查询总记录
     *
     * @return
     */
    @Select("SELECT COUNT(*) FROM tb_brand")
    int selectTotalCount();

    /**
     * 分页查询
     *
     * @param begin
     * @param size
     * @param brand
     * @return
     */
    List<Brand> selectByPageAndCondition(@Param("begin") int begin, @Param("size") int size, @Param("brand") Brand brand);

    /**
     * 根据添加查询总记录数
     *
     * @param brand
     * @return
     */
    int selectTotalCountByCondition(Brand brand);

}
