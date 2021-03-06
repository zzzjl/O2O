package com.zzz.web.frontend;

import com.zzz.dto.ProductExecution;
import com.zzz.entity.Product;
import com.zzz.entity.ProductCategory;
import com.zzz.entity.Shop;
import com.zzz.service.ProductCategoryService;
import com.zzz.service.ProductService;
import com.zzz.service.ShopService;
import com.zzz.util.HttpServletRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/frontend")
public class ShopDetailController {
    @Autowired
    private ShopService shopService;
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductCategoryService productCategoryService;
    /*
    *
    * 获取店铺信息以及店铺下面的商品列表
    *
    * */
    @RequestMapping(value ="/listshopdetailinfo" ,method = RequestMethod.GET)
    @ResponseBody
    private Map<String ,Object> listShopDetailInfo(HttpServletRequest request){
        Map<String,Object>modelMap=new HashMap<String,Object>();
        //获取前台传过来的shopId
        long shopId = HttpServletRequestUtil.getLong(request,"shopId");
        Shop shop =null;
        List<ProductCategory>productCategoryList = null;
        if(shopId!=-1){
            //获取店铺Id为shopId的店铺信息
            shop = shopService.getShopById(shopId);
            //获取店铺下面的商品类别列表
            productCategoryList = productCategoryService.getProductCategoryList(shopId);
            modelMap.put("shop",shop);
            modelMap.put("productCategoryList",productCategoryList);
            modelMap.put("success",true);
        }else {
            modelMap.put("success",false);
            modelMap.put("errMsg","empty shopId!");
        }
        return modelMap ;
    }
    /*
    *
    * 根据查询条件分页列出店铺下所有商品
    * */
    @RequestMapping(value = "/listproductsbyshop" ,method = RequestMethod.GET)
    @ResponseBody
    private Map<String,Object>listProductsByShop(HttpServletRequest request){
        Map<String,Object>modelMap = new HashMap<String,Object>();
        //获取页码
        int pageIndex = HttpServletRequestUtil.getInt(request,"pageIndex");
        //获取一页需要展示的条数
        int pageSize = HttpServletRequestUtil.getInt(request,"pageSize");
        //获取店铺Id
        long shopId = HttpServletRequestUtil.getLong(request,"shopId");
        //空值判断
        if ((shopId > -1) && (pageIndex > -1) &&(pageSize>-1)){
            //获取商品类别Id
            long productCategoryId = HttpServletRequestUtil.getLong(request,"productCategoryId");
            //获取商品名
            String productName = HttpServletRequestUtil.getString(request,"productName");
            //组合查询条件
            Product productCondition = compactProductCondition4Search(shopId,productCategoryId,productName);
            //按照传入的查询条件以及分页信息返回相应的商品列表及总数
            ProductExecution pe =productService.getProductList(productCondition,pageIndex,pageSize);
            modelMap.put("productList",pe.getProductList());
            modelMap.put("count",pe.getCount());
            modelMap.put("success",true);
        }else {
            modelMap.put("success",false);
            modelMap.put("errMsg","empty pageSize or pageIndex!");
        }
        return modelMap ;
    }
    private Product compactProductCondition4Search(long shopId,long productCategoryId,String productName){
        Product productCondition = new Product();
        Shop shop = new Shop();
        shop.setShopId(shopId);
        productCondition.setShop(shop);
        if(productCategoryId>-1){
            //查询某个商品类别下的商品列表
            ProductCategory productCategory = new ProductCategory();
            productCategory.setProductCategoryId(productCategoryId);
            productCondition.setProductCategory(productCategory);
        }
        if(productName!=null){
            //查询包含productName的商品列表
            productCondition.setProductName(productName);
        }
        productCondition.setEnableStatus(1);
        return productCondition;
    }
}
