package com.publish.entity;

import java.util.Arrays;

public class User {
	private String id;
	private String name;
	private String[] addresses;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String id, String name, String[] addresses) {
		super();
		this.id = id;
		this.name = name;
		this.addresses = addresses;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getAddresses() {
		return addresses;
	}

	public void setAddresses(String[] addresses) {
		this.addresses = addresses;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", addresses=" + Arrays.toString(addresses) + "]";
	}

}
