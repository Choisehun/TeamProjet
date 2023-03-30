package com.example.team_project.domain.domain.shop.shop.service.delete;


import com.example.team_project.domain.domain.shop.seller.domain.Seller;
import com.example.team_project.domain.domain.shop.seller.domain.SellerRepository;
import com.example.team_project.domain.domain.shop.shop.domain.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional
public class ShopDeleteService {

    private final ShopRepository shopRepository;
    private final SellerRepository sellerRepository;
    private final PasswordEncoder passwordEncoder;


    public void delete(Long shopId, String ownerId, String password) {
        Seller seller = sellerRepository.validateSeller(ownerId);

        if (!seller.isValidPassword(passwordEncoder, password)) {
            throw new BadCredentialsException("Invalid password");
        }


        shopRepository.deleteById(shopId);

    }

}