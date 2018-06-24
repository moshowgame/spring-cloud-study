package com.softdev.system.redis.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softdev.system.redis.entity.Item;

import cn.hutool.core.util.RandomUtil;

@RestController
public class RedisController {
	
	 /**
     * @Cacheable 应用到读取数据的方法上，先从缓存中读取，如果没有再从DB获取数据，然后把数据添加到缓存中
     * unless 表示条件表达式成立的话不放入缓存
     */
	@GetMapping("/item/{id}")
    @Cacheable(value = "item")
    public Item getItemById(@PathVariable int id) {
    	Item item = new Item();
    	item.setItemId(id);
    	item.setItemName("德玛西亚"+id);
        return item;
    }
	 /**
     * @Cacheable 应用到读取数据的方法上，先从缓存中读取，如果没有再从DB获取数据，然后把数据添加到缓存中
     * unless 表示条件表达式成立的话不放入缓存
     */
	@GetMapping("/item/all")
    @Cacheable(value = "item")
    public List<Item> getAllItem() {
		Item item1 = new Item();
    	item1.setItemId(666);
    	item1.setItemName("德玛西亚"+666);
    	Item item2 = new Item();
    	item2.setItemId(999);
    	item2.setItemName("德玛西亚"+999);
    	List<Item> items=new ArrayList<Item>();
    	items.add(item1);
    	items.add(item2);
        return items;
    }
	/**
     * 这个是空方法，由于缓存的原因，上面/item/all设置的值会被这个方法作为缓存拿出来
     */
	@GetMapping("/item/all2")
    @Cacheable(value = "item")
    public List<Item> getAllItem2() {
    	List<Item> items=new ArrayList<Item>();
        return items;
    }
    /**
     * @CachePut 应用到写数据的方法上，如新增/修改方法，调用方法时会自动把相应的数据放入缓存
     * @param person
     * @return
     */
    @CachePut(value = "item")
    @GetMapping("/item/{id}/update")
    public Item updateItem(@PathVariable int id) {
    	Item item = new Item();
    	item.setItemId(id);
    	item.setItemName("德玛西亚XXX"+id);
        return item;
    }
    
    /**
     * #item.itemId或者#p0.itemId是EL表达式来指定我们的key
     */
    @Cacheable(value = "item",key="#item.itemId")
    @GetMapping("/item/object")
    public Item updateItem(Item item) {
        return item;
    }
}
