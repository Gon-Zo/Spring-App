package com.example.springjpa.service.item;

import com.example.springjpa.domain.item.Item;
import com.example.springjpa.web.dto.ItemDto;
import com.example.springjpa.web.dto.PageDto;
import org.springframework.data.domain.Page;

/**
 * Create by park031517@gmail.com on 2020-08-14, 금
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */

public interface ItemService {

    Item getToItem(long seq);

    void saveToItem(ItemDto dto);

    void updateToDiscount( long seq , Boolean isUse);

    void updateToSale( long seq , Boolean isUse);

    Page<Item> getToItems(PageDto dto);

}
