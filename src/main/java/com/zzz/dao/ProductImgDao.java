package com.zzz.dao;

import com.zzz.entity.ProductImg;

import java.util.List;

public interface ProductImgDao {
    //List<ProductImg>queryProductImgList(long productId);
    int batchInsertProductImg(List<ProductImg> productImgList);
    //int deleteProductImgByProductId( long productId);
    int deleteProductImgById(long productId);

    //
    List<ProductImg> queryProductImgList(long productId);

}
