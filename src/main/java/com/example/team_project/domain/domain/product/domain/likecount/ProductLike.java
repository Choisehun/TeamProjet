package com.example.team_project.domain.domain.product.domain.likecount;

import com.example.team_project.domain.domain.product.domain.Product;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name="ProductLike")
@Getter
public class ProductLike {
    @Id
    private Long likeId;

    //product 고유번호
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product productId;

    @Column
    private String likeCount;

    public ProductLike(){

    }


}
