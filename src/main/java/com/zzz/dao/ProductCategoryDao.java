package com.zzz.dao;


import com.zzz.entity.ProductCategory;
import com.zzz.entity.Shop;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductCategoryDao {
    List<ProductCategory> queryProductCategoryList(@Param("shopId") Long shopId);

    /*
    * 批量添加商品类别
    * */
    int batchInsertProductCategory(List<ProductCategory>productCategoryList);
    /*
    * 删除商品类别*/
    int deleteProductCategory(@Param("productCategoryId") Long productCategoryId,@Param("shopId") Long shopId);
}
