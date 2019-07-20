package com.zzz.service;


import com.zzz.dto.ImageHolder;
import com.zzz.dto.ShopExecution;
import com.zzz.entity.Shop;
import com.zzz.exceptions.ShopOperationExceptions;

import java.io.File;
import java.io.InputStream;

public interface ShopService {
   /*添加商铺*/
   ShopExecution addShop(Shop shop, ImageHolder imageHolder);
   /*通过Id获取商铺信息*/
   Shop getShopById(long shopId);
   /*更新店铺信息*/
   ShopExecution modifyShop(Shop shop,ImageHolder imageHolder) throws ShopOperationExceptions;
   /*分页查询*/
   public ShopExecution getShopList(Shop shopCondition ,int pageIndex ,int pageSize);

}
