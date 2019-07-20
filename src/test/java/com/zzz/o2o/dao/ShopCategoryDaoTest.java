package com.zzz.o2o.dao;

import com.zzz.dao.ShopCategoryDao;
import com.zzz.entity.Area;
import com.zzz.entity.ShopCategory;
import com.zzz.o2o.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ShopCategoryDaoTest extends BaseTest {
    @Autowired
    private ShopCategoryDao shopCategoryDao;
    @Test
    public void testQueryShopCategory(){
        /*ShopCategory shopCategory = new ShopCategory();
        ShopCategory shopCategory1 = null;
        ShopCategory pshopCategory = new ShopCategory();
        pshopCategory.setShopCategoryId(3L);
        shopCategory.setParent(pshopCategory);
        List<ShopCategory> shopCategoryList1 = shopCategoryDao.queryShopCategory(shopCategory1);
        List<ShopCategory> shopCategoryList2 = shopCategoryDao.queryShopCategory(pshopCategory);
        assertEquals(3,shopCategoryList1.size());
        for (ShopCategory sc:shopCategoryList1){
            System.out.println("父类别："+sc.getShopCategoryName());
        }
        assertEquals(1,shopCategoryList2.size());
        for (ShopCategory sc:shopCategoryList2){
            System.out.println("子类别:"+sc.getShopCategoryName());
        }*/



    }

}
