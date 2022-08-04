package com.poc.resful.jersey.services;

import com.poc.resful.jersey.dao.ItemDao;
import com.poc.resful.jersey.entities.Item;

public class ItemService {
	
	ItemDao itemDao = new ItemDao();

	public Item addItem(Item item) {	
		return itemDao.addItem(item);	
	}

	public Item updateItem(Item item, long itemId) {
		return itemDao.updateItemById(itemId, item);
	}

	public void deleteItem(String itemId) {
		itemDao.deleteItemById(itemId);
	}

	public Item getItemByIdOrName(String itemId, String name) {	
		return itemDao.findByItemIdOrName(itemId, name);	
	}

}
