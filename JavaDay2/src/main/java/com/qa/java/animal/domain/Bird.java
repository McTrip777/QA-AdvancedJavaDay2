package com.qa.java.animal.domain;

import javax.persistence.Entity;

@Entity
public class Bird extends Animal{

	private int wings = 2;
	private String type;
	private boolean canFly;
	
	public Bird() {
	}
	
	public Bird(int wings, String type, boolean canFly) {
		super();
		this.wings = wings;
		this.type = type;
		this.canFly = canFly;
	}

	public int getWings() {
		return wings;
	}

	public void setWings(int wings) {
		this.wings = wings;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isCanFly() {
		return canFly;
	}

	public void setCanFly(boolean canFly) {
		this.canFly = canFly;
	}

	@Override
	public String toString() {
		return "Bird wings=" + wings + ", type=" + type + ", canFly= " + canFly + " " + super.toString();
	}
	
	
	
}
