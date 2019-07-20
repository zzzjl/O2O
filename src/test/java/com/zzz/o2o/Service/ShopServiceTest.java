package com.zzz.o2o.Service;

import com.zzz.dto.ImageHolder;
import com.zzz.dto.ShopExecution;
import com.zzz.entity.Area;
import com.zzz.entity.PersonInfo;
import com.zzz.entity.Shop;
import com.zzz.entity.ShopCategory;
import com.zzz.enums.ShopStateEnum;
import com.zzz.exceptions.ShopOperationExceptions;
import com.zzz.o2o.BaseTest;
import com.zzz.service.ShopService;import com.zzz.service.impl.ShopServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ShopServiceTest extends BaseTest {
    @Autowired
    private ShopService shopService;
    @Test
    public void testgetShopList() {
        Shop shopCondition = new Shop();
        PersonInfo owner = new PersonInfo();
        owner.setUserId(1L);
        shopCondition.setOwner(owner);
        ShopExecution shopExecution = shopService.getShopList(shopCondition, 0, 5);
        List<Shop> shopList = shopExecution.getShopList();
        for (Shop s :shopList) {
            System.out.println(s.getShopName());
        }
    }
    @Test
    public void testMoidfyShop() throws ShopOperationExceptions,FileNotFoundException{
        Shop shop=shopService.getShopById(1L);
        System.out.println("name:"+shop.getShopName());
        shop.setShopName("修改之后");
        File shopImg = new File("I:/zzz/pic/milktea.jpg");
        InputStream inputStream = new FileInputStream(shopImg);
        ImageHolder imageHolder = new ImageHolder("milktea.jpg",inputStream);
        ShopExecution shopExecution = shopService.modifyShop(shop,imageHolder);


    }
    @Test
    public void testAddShop() throws Exception{
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
        shop.setShopName("测试店铺www");
        shop.setShopDesc("TESTwww");
        shop.setShopAddr("TESTwww");
        shop.setPhone("2311");
        shop.setCreateTime(new Date());
        shop.setEnableStatus(ShopStateEnum.CHECK.getState());
        shop.setAdvice("审核中");
        File img = new File("I:/zzz/pic/starbucks.jpg");
       /* File file= new File("I:/zzz/pic/haha/starbucks.jpg");
        file.delete();*/
        InputStream is = new FileInputStream(img);
        ImageHolder imageHolder = new ImageHolder(img.getName(),is);
        ShopExecution se = shopService.addShop(shop,imageHolder);
        assertEquals(ShopStateEnum.CHECK.getState(),se.getState());
    }

}
