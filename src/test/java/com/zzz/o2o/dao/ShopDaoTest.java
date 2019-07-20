package com.zzz.o2o.dao;

import com.zzz.dao.ShopDao;
import com.zzz.entity.Area;
import com.zzz.entity.PersonInfo;
import com.zzz.entity.Shop;
import com.zzz.entity.ShopCategory;
import com.zzz.o2o.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class ShopDaoTest extends BaseTest {
    @Autowired
    private ShopDao shopDao;
    @Test
    public void  testQueryShopList(){
        Shop shopCondition = new Shop();
        ShopCategory shopCategory = new ShopCategory();
        ShopCategory parentsc = new ShopCategory();
        parentsc.setShopCategoryId(3L);
        shopCategory.setParent(parentsc);
        PersonInfo owner = new PersonInfo();
        owner.setUserId(1L);
        shopCondition.setOwner(owner);
        shopCondition.setShopCategory(shopCategory);
        shopCondition.setShopName("www");
        List<Shop> shopList = shopDao.queryShopList(shopCondition,0,5);
        for(Shop shop :shopList ) {
            System.out.println(shop.getShopName());
        }

    }

    @Test
    public void  testQueryShopCount(){
        Shop shopCondition = new Shop();
        PersonInfo owner = new PersonInfo();
        owner.setUserId(1L);
        shopCondition.setOwner(owner);
        int count = shopDao.queryShopCount(shopCondition);
        System.out.println(count);

    }
    @Test
    public void testQueryShopById(){
        long shopId = 1;
        Shop shop = shopDao.quaryShopById(shopId);
        System.out.println(shop.getArea().getAreaName() +"   :"+shop.getArea().getAreaId());

    }
    @Test
    public void testInsertShop()  {
        Shop shop = new Shop();
        PersonInfo owner = new PersonInfo();
        Area area = new Area();
        ShopCategory shopCategory = new ShopCategory();
        owner.setUserId(1L);
        area.setAreaId(2);
        shopCategory.setShopCategoryId(1L);
        shop.setOwner(owner);
        shop.setArea(area);
        shop.setShopCategory(shopCategory);
        shop.setShopName("测试店铺");
        shop.setShopDesc("TEST");
        shop.setShopAddr("TEST");
        shop.setPhone("121111");
        shop.setShopImg("TEST");
        shop.setCreateTime(new Date());
        shop.setEnableStatus(1);
        shop.setAdvice("审核中");
        int effectedNum = shopDao.insertShop(shop);
        assertEquals(1,effectedNum);


    }
    @Test
    public void testUpdateShop()  {
        Shop shop = new Shop();
        shop.setShopId(1L);
        ShopCategory shopCategory = new ShopCategory();
        shopCategory.setShopCategoryId(1L);
        shop.setShopCategory(shopCategory);
        shop.setShopName("我的店铺");
        shop.setShopDesc("描述2");
        shop.setShopAddr("地址2");
        shop.setPhone("1311");
        shop.setShopImg("TEST2");
        shop.setLastEditTime(new Date());
        shop.setAdvice("审核后");
        int effectedNum = shopDao.updateShop(shop);
        assertEquals(1,effectedNum);


    }

}
