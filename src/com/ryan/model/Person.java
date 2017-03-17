package com.ryan.model;

import org.bson.types.ObjectId;

/**
 * person 的实体类
 * @author ryan
 *
 */
public class Person {

	private String _id;
	private String name;
	private Double age;
	
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getAge() {
		return age;
	}
	public void setAge(Double age) {
		this.age = age;
	}
	
	
}
