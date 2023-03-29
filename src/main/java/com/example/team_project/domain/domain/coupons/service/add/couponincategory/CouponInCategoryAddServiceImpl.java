package com.example.team_project.domain.domain.coupons.service.add.couponincategory;

import com.example.team_project.domain.domain.coupons.domain.CouponInCategory;
import com.example.team_project.domain.domain.coupons.domain.CouponInCategoryRepository;
import com.example.team_project.domain.domain.coupons.domain.CouponKinds;
import com.example.team_project.domain.domain.coupons.domain.CouponKindsRepository;
import com.example.team_project.domain.domain.product.domain.category.ProductCategory;
import com.example.team_project.domain.domain.product.domain.category.ProductCategoryRepository;
import com.example.team_project.exception.NotFoundCouponException;
import com.example.team_project.exception.NotMatchCouponCategoryException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CouponInCategoryAddServiceImpl implements CouponInCategoryAddService {
    private final CouponKindsRepository couponKindsRepository;
    private final ProductCategoryRepository productCategoryRepository;
    private final CouponInCategoryRepository couponInCategoryRepository;

    /**
     * 컨트롤단에서 쿠폰 종류의 이름, 물건카테고리의 아이디를 받아와서 추가해야함.
     */
    @Override
    public void add(String couponKindsName, Long productCategoryId) {
        CouponInCategory couponInCategory = new CouponInCategory(
                getCouponKinds(couponKindsName),
                getProductCategory(productCategoryId)
        );
        couponInCategoryRepository.save(couponInCategory);
    }

    private CouponKinds getCouponKinds(String couponKindsName) {
        return couponKindsRepository.findById(couponKindsName).orElseThrow(
                NotFoundCouponException::new
        );
    }

    private ProductCategory getProductCategory(Long productCategoryId) {
        return productCategoryRepository.findById(productCategoryId).orElseThrow(
                NotMatchCouponCategoryException::new
        );
    }
}