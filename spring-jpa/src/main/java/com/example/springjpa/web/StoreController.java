package com.example.springjpa.web;

import com.example.springjpa.service.store.StoreService;
import com.example.springjpa.web.dto.StoreDto;
import org.springframework.web.bind.annotation.*;

/**
 * Create by park031517@gmail.com on 2020-08-15, 토
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
@RestController
@RequestMapping("/api/store")
public class StoreController {
    
    private final StoreService service;

    public StoreController(StoreService service) {
        this.service = service;
    }
    
    @GetMapping("/{seq}")
    public void showToStore(@PathVariable long seq) {
        service.getToStore(seq);
    }
    
    @PostMapping("")
    public void createToStore(@RequestBody StoreDto dto){
       service.saveToStore(dto); 
    }
    
    @PutMapping("/{seq}") 
    public void modifyToStore(@PathVariable long seq , StoreDto dto){
        service.updateToStore(seq, dto);
    }
    
    @DeleteMapping("/{seq}")
    public void removeToStore(@PathVariable long seq){
        service.deleteToStore(seq);
    }
    
}
