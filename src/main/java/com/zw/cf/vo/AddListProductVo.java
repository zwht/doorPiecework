package com.zw.cf.vo;
import com.zw.cf.model.Product;
import java.util.List;

/**
 * Created by zhaowei on 2018/1/29.
 */
public class AddListProductVo {
    private List<Product> products;
    private String ticketId;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }
}
