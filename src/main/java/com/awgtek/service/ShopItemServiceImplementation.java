package com.awgtek.service;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.awgtek.domain.ShopItem;
import com.awgtek.repository.ShopItemRepository;

@Service
@Transactional
public class ShopItemServiceImplementation implements ShopItemServiceInterface{

	@Autowired
	protected ShopItemRepository ShopItemRepository;

	@Override
	public ShopItem saveShopItem(ShopItem emp) {
		// TODO Auto-generated method stub
		return ShopItemRepository.save(emp);
	}

	@Override
	public Boolean deleteShopItem(Integer empId) {
		// TODO Auto-generated method stub
		ShopItem temp = ShopItemRepository.findOne(empId);
		if(temp!=null){
			 ShopItemRepository.delete(temp);
			 return true;
		}
		return false;
	}

	@Override
	public ShopItem editShopItem(ShopItem emp) {
		// TODO Auto-generated method stub
		return ShopItemRepository.save(emp);
	}

	@Override
	public Collection<ShopItem> getAllShopItems() {
		// TODO Auto-generated method stub
		Iterable<ShopItem> itr = ShopItemRepository.findAllByOrderByItemPriorityDescItemNameAsc();//.findAll();
		return (Collection<ShopItem>)itr;
	}

	@Override
	public ShopItem findShopItem(Integer empId) {
		// TODO Auto-generated method stub
		return ShopItemRepository.findOne(empId);
	}

	@Override
	public Boolean incrementPriorityOfShopItem(Integer shopItem) {
		int change = 1;
		return changePriorityOfShopItem(shopItem, change);
	}

	private Boolean changePriorityOfShopItem(Integer shopItem, int change) {
		ShopItem temp = ShopItemRepository.findOne(shopItem);
		if(temp!=null){
			int priority = temp.getItemPriority();
			temp.setItemPriority(priority + change);
			return ShopItemRepository.save(temp) != null;
		}
		return false;
	}

	@Override
	public Boolean decrementPriorityOfShopItem(Integer shopItem) {
		int change = -1;
		return changePriorityOfShopItem(shopItem, change);
	}
	

}
