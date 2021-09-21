package com.springdocker.app.item.service;

import com.springdocker.app.item.entity.Item;

import java.util.List;

public interface IItemService {

    public List<Item> list();
    public Item find(Long id, Integer size);
}
