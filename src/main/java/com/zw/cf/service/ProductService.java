package com.zw.cf.service;

import com.zw.cf.model.Product;
import com.zw.cf.vo.ProductListFind;
import com.zw.plug.Response;

import java.util.List;

/**
 * Created by zhaowei on 2017/8/17.
 */
public interface ProductService {
    Response add(Product product);
    Response addList(List<Product> list);
    Response list(Integer pageNum, Integer pageSize, ProductListFind productListFind);
    Response getById(String id);
    Response update(Product product);
    Response del(String id);
}
