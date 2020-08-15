package com.example.springjpa.domain.item.support;

import com.example.springjpa.domain.item.Item;
import com.example.springjpa.web.dto.PageDto;
import org.springframework.data.domain.Page;

public interface ItemSupport {

    Page<Item> findByAll(PageDto pageDto);

}
