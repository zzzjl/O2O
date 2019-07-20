package com.zzz.o2o.dao;

import com.zzz.dao.ProductImgDao;
import com.zzz.entity.ProductImg;
import com.zzz.o2o.BaseTest;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductImgDaoTest extends BaseTest {
    @Autowired
    private ProductImgDao productImgDao;

    @Test
    public void atestBatchInsertProductImg(){
        ProductImg productImg1=new ProductImg();
        productImg1.setImgAddr("图片1");
        productImg1.setImgDesc("测试图片1");
        productImg1.setPrority(1);
        productImg1.setCreateTime(new Date());
        productImg1.setProductId(1L);
        ProductImg productImg2=new ProductImg();
        productImg2.setImgAddr("图片2");
        productImg2.setImgDesc("测试图片2");
        productImg2.setPrority(2);
        productImg2.setCreateTime(new Date());
        productImg2.setProductId(1L);
        List<ProductImg> productImgList=new ArrayList<ProductImg>();
        productImgList.add(productImg1);
        productImgList.add(productImg2);
        int effNum=productImgDao.batchInsertProductImg(productImgList);
        //assertEquals(2,effNum);

    }
    @Test
    public void btestdeleteProductImgById(){
       long productId = 1;
       int effnum = productImgDao.deleteProductImgById(productId);
        assertEquals(2,effnum);

    }
    @Test
    public void testQueryProuctList(){
        long ProductId =5;
        List<ProductImg> productImgLIst = productImgDao.queryProductImgList(ProductId);
        for (ProductImg ProImg:productImgLIst){
            System.out.println(ProImg.getProductId());
        }
        //assertEquals(3,productImgLIst.size());

    }
}
