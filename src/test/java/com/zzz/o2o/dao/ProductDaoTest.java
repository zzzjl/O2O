package com.zzz.o2o.dao;

import com.zzz.dao.ProductDao;
import com.zzz.entity.Product;
import com.zzz.entity.ProductCategory;
import com.zzz.entity.Shop;
import com.zzz.o2o.BaseTest;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductDaoTest extends BaseTest {
    @Autowired
    private ProductDao productDao;

    @Test
    public void aTestInsertProduct() {
        Product product = new Product();
        product.setProductName("奶茶");
        product.setEnableStatus(1);
        product.setProductDesc("haha");
        product.setImgAddr("sasa");
        product.setNormalPrice("11");
        product.setPromotionPrice("13");
        product.setCreateTime(new Date());
        product.setLastEditTime(new Date());
        Shop shop = new Shop();
        shop.setShopId(1L);
        product.setShop(shop);
        product.setPriority(1);
        product.setProductCategory(new ProductCategory());
        int effNum = productDao.insertProduct(product);
        assertEquals(1, effNum);

    }

    @Test
    public void bqueryProductById() {
        long productId = 1;
        Product product = productDao.queryProductById(productId);
        System.out.println(product.getProductId() + "   :" + product.getProductName());

    }


    @Test
    public void cupdateProduct() {
        Product product = new Product();
        product.setProductId(9L);
        // product.setProductName("奶茶new");
        product.setEnableStatus(0);
        //product.setProductDesc("haha111");
        //product.setImgAddr("sasa111");
        // product.setNormalPrice("11000");
        // product.setPromotionPrice("13000");
        product.setCreateTime(new Date());
        product.setLastEditTime(new Date());
        Shop shop = new Shop();
        shop.setShopId(1L);
        product.setShop(shop);
        //product.setPriority(2);
        //product.setProductCategory(new ProductCategory());
        int effNum = productDao.updateProduct(product);
        assertEquals(1, effNum);
    }

    @Test
    public void testQueryProductList() {
        Product product = new Product();
        Shop shop = new Shop();
        shop.setShopId(1L);
        product.setShop(shop);
        ProductCategory productCategory = new ProductCategory();
        productCategory.setProductCategoryId(1L);
        product.setProductCategory(productCategory);
        //product.setProductName("nam");
        List<Product> productList = productDao.queryProductList(product, 1, 2);
        for (Product pr : productList) {
            System.out.println("---" + pr.getProductName());
        }
        //assertEquals(4, productList.size());
    }

    @Test
    public void testQueryProductCount() {
        Product product = new Product();
        Shop shop = new Shop();
        shop.setShopId(1L);
        product.setShop(shop);
        product.setProductName("name");
        int ListNum = productDao.queryProductCount(product);

        assertEquals(1, ListNum);
    }

    @Test
    public void testupdateProductCategoryToNull() {
        int effectNum = productDao.updateProductCategoryToNull(2L);
        assertEquals(1, effectNum);

    }
}
