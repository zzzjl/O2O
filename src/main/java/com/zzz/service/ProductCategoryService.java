package com.zzz.service;


import com.zzz.dto.ProductCategoryExecution;
import com.zzz.entity.ProductCategory;
import com.zzz.exceptions.ProductCategoryOperationException;

import java.util.List;

public interface ProductCategoryService {
    List<ProductCategory> getProductCategoryList(Long shopId);
    ProductCategoryExecution batchAddProductCategory(List<ProductCategory> productCategoryList) throws ProductCategoryOperationException;
    ProductCategoryExecution deletePorductCategory(Long productCategoryId,Long shopId) throws ProductCategoryOperationException;
}
