package com.zzz.o2o.dao;

import com.zzz.dao.ProductCategoryDao;
import com.zzz.entity.ProductCategory;
import com.zzz.entity.Shop;
import com.zzz.o2o.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ProductCategoryDaoTest  extends BaseTest {
    @Autowired
    private ProductCategoryDao productCategoryDao;
    @Test
    public void TestQueryProductCategory(){
        long shopId=1;
        List<ProductCategory> productCategoryList=productCategoryDao.queryProductCategoryList(shopId);
        assertEquals(2,productCategoryList.size());

    }
    @Test
    public void testBatchTnsertProductCategory(){
        ProductCategory productCategory1 = new ProductCategory();
        productCategory1.setProductCategoryName("商品类别1");
        productCategory1.setCreateTime(new Date());
        productCategory1.setPriority( 1);
        productCategory1.setShopId(1L);
        ProductCategory productCategory2 = new ProductCategory();
        productCategory2.setProductCategoryName("商品类别2");
        productCategory2.setCreateTime(new Date());
        productCategory2.setPriority(2);
        productCategory2.setShopId(2L);
        List<ProductCategory> list = new ArrayList<ProductCategory>();
        list.add(productCategory1);
        list.add(productCategory2);
        int effectNum = productCategoryDao.batchInsertProductCategory(list);
        assertEquals(2,effectNum);

    }
    @Test
    public void testDeleteProductCategory(){
        int effectNum= productCategoryDao.deleteProductCategory(6L,1L);
        assertEquals(1,effectNum);
    }


}
