package com.awgtek.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="items")
public class ShopItem {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="item_name", length=45, nullable=true)
	private String itemName;
	
	@Column(name="item_priority", nullable=true)
	private int itemPriority;
	
	@Column
	private String notes;
	public ShopItem(int id, String itemName, int itemPriority, String notes) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.itemPriority = itemPriority;
		this.notes = notes;
	}
	public ShopItem() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getItemPriority() {
		return itemPriority;
	}
	public void setItemPriority(int itemPriority) {
		this.itemPriority = itemPriority;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	@Override
	public String toString() {
		return "ShopItem [id=" + id + ", itemName=" + itemName + ", itemPriority=" + itemPriority + ", notes=" + notes
				+ "]";
	}
	
}
