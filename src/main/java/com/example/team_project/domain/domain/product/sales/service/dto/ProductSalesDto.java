package com.example.team_project.domain.domain.product.sales.service.dto;

import com.example.team_project.domain.domain.product.product.domain.Product;
import lombok.Getter;

@Getter
public class ProductSalesDto {

    //product 고유번호
    private Product productId;
    //판매량
    private int productSales;

}