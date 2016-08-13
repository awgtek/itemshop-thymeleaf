package com.awgtek.service;

import java.util.Collection;

import com.awgtek.domain.ShopItem;

public interface ShopItemServiceInterface {

	public ShopItem saveShopItem(ShopItem emp);
	public Boolean deleteShopItem(Integer empId);
	public ShopItem editShopItem(ShopItem emp);
	public ShopItem findShopItem(Integer empId);
	public Collection<ShopItem> getAllShopItems();
	public Boolean incrementPriorityOfShopItem(Integer shopItem);
	public Boolean decrementPriorityOfShopItem(Integer shopItem);
}