package com.zzz.o2o.Service;

import com.zzz.entity.Area;
import com.zzz.entity.Shop;
import com.zzz.entity.ShopCategory;
import com.zzz.o2o.BaseTest;
import com.zzz.service.AreaService;
import com.zzz.service.ShopCategoryService;
import org.apache.ibatis.jdbc.Null;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;


public class ShopCategoryServiceTest extends BaseTest {
    @Autowired
    private ShopCategoryService shopCategoryService;
    @Test
    public void testGetShopCategoryList(){
        /*List<ShopCategory> shopCategoryList =shopCategoryService.getShopCategoryList(new ShopCategory());
        //System.out.println(areaList.toString());
        assertEquals(2,shopCategoryList.size());*/

        List<ShopCategory>shopCategoryList = null;
        ShopCategory shopCategoryCondition = new ShopCategory();
        ShopCategory parent = new ShopCategory();
        parent.setShopCategoryId(3L);
        shopCategoryCondition.setParent(parent);
        shopCategoryList = shopCategoryService.getShopCategoryList(shopCategoryCondition);
        for(ShopCategory shopCategory:shopCategoryList){
            System.out.println(shopCategory.getShopCategoryName());
        }

    }


}
