package com.zzz.o2o.Service;

import com.zzz.dto.ImageHolder;
import com.zzz.dto.ProductExecution;
import com.zzz.entity.Product;
import com.zzz.entity.ProductCategory;
import com.zzz.entity.Shop;
import com.zzz.enums.ProductStateEnum;
import com.zzz.exceptions.ProductOperationException;
import com.zzz.exceptions.ShopOperationExceptions;
import com.zzz.o2o.BaseTest;
import com.zzz.service.ProductService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ProductServiceTest extends BaseTest {
    @Autowired
    private ProductService productService ;
    @Test
    public void testAddProduct()throws ProductOperationException,FileNotFoundException{
        //创建shopId为1且productCategoryId为1的商品实例并给成员变量赋值
        Product product = new Product();
        Shop shop =new Shop();
        shop.setShopId(1L);
        ProductCategory pc =new ProductCategory();
        pc.setProductCategoryId(1L);
        product.setShop(shop);
        product.setProductCategory(pc);
        product.setProductName("测试商品1");
        product.setProductDesc("测试商品1");
        product.setPriority(1);
        product.setCreateTime(new Date());
        product.setEnableStatus(ProductStateEnum.SUCCESS.getState());
        //创建缩略图文件流
        File thumbnailFile = new File("I:/zzz/pic/milktea.jpg");
        InputStream is = new FileInputStream(thumbnailFile);
        ImageHolder thumbnail = new ImageHolder(thumbnailFile.getName(),is);
        //创建两个商品详情图文件流并添加到详情图列表中
        File productImg1 = new File("I:/zzz/pic/detail1.jpg");
        InputStream is1 = new FileInputStream(productImg1);
        File productImg2 = new File("I:/zzz/pic/detail2.jpg");
        InputStream is2 = new FileInputStream(productImg2);
        List<ImageHolder> productImgList = new ArrayList<ImageHolder>();
        productImgList.add(new ImageHolder(productImg1.getName(),is1));
        productImgList.add(new ImageHolder(productImg2.getName(),is2));
        //添加商品并验证
        ProductExecution pe =productService.addProduct(product,thumbnail,productImgList);
        assertEquals(ProductStateEnum.SUCCESS.getState(),pe.getState());


    }
    @Test
    public void testMoidfyProduct() throws ShopOperationExceptions,FileNotFoundException{
        //创建SHOPID为1且productCategoryId为1的商品实例并给成员变量赋值
        Product product = new Product();
        product.setProductId(9L);
        product.setEnableStatus(0);
        Shop shop = new Shop();
        shop.setShopId(1L);
        product.setShop(shop);
        ImageHolder thumbnail =null;
        List<ImageHolder> productImgList =null;
        /*Shop shop = new Shop();
        shop.setShopId(1L);
        ProductCategory pc = new ProductCategory();
        pc.setProductCategoryId(1L);
        product.setProductId(30L);
        product.setShop(shop);
        product.setProductCategory(pc);
        product.setProductName("修改后的商品名称");
        product.setProductDesc("修改后的商品描述");
        //创建缩略图文件流
        File thumbnailFile = new File("I:/zzz/pic/bir.jpg");
        InputStream is = new FileInputStream(thumbnailFile);
        ImageHolder thumbnail = new ImageHolder(thumbnailFile.getName(),is);
        //创建两个商品详情图文件流并添加到详情图列表中
        File productImg1 = new File("I:/zzz/pic/brdetail2.jpg");
        InputStream is1 = new FileInputStream(productImg1);
        File productImg2 = new File("I:/zzz/pic/brdetail1.jpg");
        InputStream is2 = new FileInputStream(productImg2);
        List<ImageHolder> productImgList = new ArrayList<ImageHolder>();
        productImgList.add(new ImageHolder(productImg1.getName(),is1));
        productImgList.add(new ImageHolder(productImg2.getName(),is2));*/
        //添加商品并验证
        //ImageUtil.deleteFileOrPath("I:/zzz/pic/topic/1/2018111810315222576.jpg");
        ProductExecution pe = productService.modifyProduct(product,thumbnail,productImgList);

    }

}
