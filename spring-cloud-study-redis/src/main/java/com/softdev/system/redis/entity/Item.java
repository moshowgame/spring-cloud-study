package com.softdev.system.redis.entity;

import java.io.Serializable;

public class Item  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int itemId;
    private String itemName;
    private String itemIcon;
    private String itemDesc;
    private String itemStatus;
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemIcon() {
		return itemIcon;
	}
	public void setItemIcon(String itemIcon) {
		this.itemIcon = itemIcon;
	}
	public String getItemDesc() {
		return itemDesc;
	}
	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}
	public String getItemStatus() {
		return itemStatus;
	}
	public void setItemStatus(String itemStatus) {
		this.itemStatus = itemStatus;
	}

}
