package com.zzz.dao;

import com.zzz.entity.ShopCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShopCategoryDao {
    List<ShopCategory> queryShopCategory (@Param("shopCategoryCondition") ShopCategory shopCategorycondition);
}
