package com.example.springjpa.web;

import com.example.springjpa.domain.item.Item;
import com.example.springjpa.service.item.ItemService;
import com.example.springjpa.web.dto.ItemDto;
import com.example.springjpa.web.dto.PageDto;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * Create by park031517@gmail.com on 2020-08-15, 토
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
@RestController
@RequestMapping("/api/app/item")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping("")
    public void createToItem(ItemDto dto){
       itemService.saveToItem(dto);
    }

    @GetMapping("")
    public Page<Item> showToItems(PageDto dto){
        return itemService.getToItems(dto);
    }

    @GetMapping("/{seq}")
    public Item showToItem(@PathVariable  long seq){
       return itemService.getToItem(seq);
    }

    @PostMapping("/discount/{seq]")
    public void modifyToDiscount(@PathVariable long seq , @RequestBody  Boolean isUse){
       itemService.updateToDiscount(seq, isUse);
    }

    @PutMapping("/sale/{seq}")
    public void modifyToSale(@PathVariable long seq , @RequestBody Boolean isUse){
       itemService.updateToSale(seq, isUse);
    }

}
