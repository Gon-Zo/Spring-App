package com.example.springjpa.service.store;

import com.example.springjpa.domain.store.Store;
import com.example.springjpa.domain.store.StoreRepository;
import com.example.springjpa.web.dto.StoreDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static org.apache.commons.lang3.ObjectUtils.isNotEmpty;

/**
 * Create by park031517@gmail.com on 2020-08-15, 토
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
@Service
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;

    public StoreServiceImpl(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @Override
    @Transactional
    public void saveToStore(StoreDto dto) {
        storeRepository.save(dto.toEntity());
    }

    @Override
    @Transactional
    public void updateToStore(long seq, StoreDto dto) {

        Store store = storeRepository.getOne(seq);

        if(isNotEmpty(dto.getName())){
           store.setName(dto.getName());
        }

        if(isNotEmpty(dto.getAccountNumber())){
           store.setAccountNumber(dto.getAccountNumber());
        }

        if(isNotEmpty(dto.getUser())){
           store.setUser(dto.getUser());
        }

        storeRepository.save(store);

    }

    @Override
    @Transactional
    public void deleteToStore(long seq) {
        storeRepository.deleteById(seq);
    }

    @Override
    @Transactional(readOnly = true)
    public Store getToStore(long seq) {
        // todo : custom exception
        return storeRepository.findById(seq).orElseThrow(()-> new NullPointerException());
    }

}
