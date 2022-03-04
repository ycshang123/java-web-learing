package com.ycshang.web.brand.service;

import com.ycshang.web.brand.pojo.Brand;
import com.ycshang.web.brand.pojo.PageBean;

import java.util.List;

/**
 * @program: java-web-learning
 * @description:
 * @author: ycshang
 * @create: 2022-03-04 17:14
 **/
public interface BrandService {
    /**
     * 查询所有
     *
     * @return
     */
    List<Brand> selectAll();

    /**
     * 添加数据
     *
     * @param brand
     */
    void add(Brand brand);

    /**
     * 批量删除
     *
     * @param ids
     */
    void deleteByIds(int[] ids);

    /**
     * 分页查询
     *
     * @param currentPage
     * @param pageSize
     * @return
     */
    PageBean<Brand> selectByPage(int currentPage, int pageSize);

    /**
     * 分页条件查询
     *
     * @param currentPage
     * @param pageSize
     * @param brand
     * @return
     */
    PageBean<Brand> selectByPageAndCondition(int currentPage, int pageSize, Brand brand);
}