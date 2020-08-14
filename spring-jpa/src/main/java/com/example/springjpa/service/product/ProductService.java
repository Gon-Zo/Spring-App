package com.example.springjpa.service.product;

import com.example.springjpa.web.dto.ProductDto;

/**
 * Create by park031517@gmail.com on 2020-08-14, 금
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
public interface ProductService {

    void saveToProduct(ProductDto dto);

    void updateToIsDiscount( long seq , Boolean isUse);

    void updateToIsSale( long seq , Boolean isUse);

}
