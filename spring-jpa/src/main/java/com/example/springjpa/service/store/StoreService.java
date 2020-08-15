package com.example.springjpa.service.store;

import com.example.springjpa.domain.store.Store;
import com.example.springjpa.web.dto.StoreDto;

/**
 * Create by park031517@gmail.com on 2020-08-15, 토
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
public interface StoreService {

    void saveToStore(StoreDto dto);

    void updateToStore(long seq , StoreDto dto);

    void deleteToStore(long seq );

    Store getToStore(long seq);

}
