package com.awgtek.repository;

import com.awgtek.domain.ShopItem;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ShopItemRepository extends JpaRepository<ShopItem, Integer> {

	public List<ShopItem> findAllByOrderByItemPriorityDescItemNameAsc();
}
