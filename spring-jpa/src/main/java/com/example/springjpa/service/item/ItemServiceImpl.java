package com.example.springjpa.service.item;

import com.example.springjpa.core.exception.ErrorCode;
import com.example.springjpa.core.exception.WebException;
import com.example.springjpa.domain.item.Item;
import com.example.springjpa.domain.item.ItemRepository;
import com.example.springjpa.domain.item.support.ItemSupport;
import com.example.springjpa.web.dto.ItemDto;
import com.example.springjpa.web.dto.PageDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Create by park031517@gmail.com on 2020-08-15, 토
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
@Service
public class ItemServiceImpl implements ItemService {

    private ItemRepository itemRepository;

    private ItemSupport itemSupport;

    @Override
    @Transactional(readOnly = true)
    public Item getToItem(long seq) {
        return itemRepository.findById(seq)
                .orElseThrow(()-> new WebException(ErrorCode.NOT_FOUND_ITEM));
    }

    @Override
    @Transactional
    public void saveToItem(ItemDto dto) {
        itemRepository.save(dto.toEntity());
    }

    @Override
    @Transactional
    public void updateToDiscount(long seq, Boolean isUse) {
        Item item = itemRepository.getOne(seq);
        item.setIsDiscount(isUse);
        itemRepository.save(item);
    }

    @Override
    @Transactional
    public void updateToSale(long seq, Boolean isUse) {
        Item item = itemRepository.getOne(seq);
        item.setIsSale(isUse);
        itemRepository.save(item);
    }

    @Override
    public Page<Item> getToItems(PageDto dto) {
        return itemSupport.findByAll(dto) ;
    }

}
