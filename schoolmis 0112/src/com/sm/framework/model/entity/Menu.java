package com.sm.framework.model.entity;

public class Menu {
	private String menuId = null;
	private String menuName = null;
	private String menuMemo = null;
	private String welcomePage = null;
	
	public Menu() {
		// TODO Auto-generated constructor stub
	}

	public Menu(String menuId, String menuName, String menuMemo,
			String welcomePage) {
		super();
		this.menuId = menuId;
		this.menuName = menuName;
		this.menuMemo = menuMemo;
		this.welcomePage = welcomePage;
	}

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuMemo() {
		return menuMemo;
	}

	public void setMenuMemo(String menuMemo) {
		this.menuMemo = menuMemo;
	}

	public String getWelcomePage() {
		return welcomePage;
	}

	public void setWelcomePage(String welcomePage) {
		this.welcomePage = welcomePage;
	}

	@Override
	public String toString() {
		return "Menu [menuId=" + menuId + ", menuName=" + menuName
				+ ", menuMemo=" + menuMemo + ", welcomePage=" + welcomePage
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((menuId == null) ? 0 : menuId.hashCode());
		result = prime * result
				+ ((menuMemo == null) ? 0 : menuMemo.hashCode());
		result = prime * result
				+ ((menuName == null) ? 0 : menuName.hashCode());
		result = prime * result
				+ ((welcomePage == null) ? 0 : welcomePage.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Menu other = (Menu) obj;
		if (menuId == null) {
			if (other.menuId != null)
				return false;
		} else if (!menuId.equals(other.menuId))
			return false;
		if (menuMemo == null) {
			if (other.menuMemo != null)
				return false;
		} else if (!menuMemo.equals(other.menuMemo))
			return false;
		if (menuName == null) {
			if (other.menuName != null)
				return false;
		} else if (!menuName.equals(other.menuName))
			return false;
		if (welcomePage == null) {
			if (other.welcomePage != null)
				return false;
		} else if (!welcomePage.equals(other.welcomePage))
			return false;
		return true;
	}
	
	

}