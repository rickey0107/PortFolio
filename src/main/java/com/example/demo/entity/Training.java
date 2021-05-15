package com.example.demo.entity;

import java.time.LocalDateTime;

public class Training {

	//フィールド
	private int           id;
	private String        part;
	private String        menu;
	private LocalDateTime datetime;

	//デフォルトコンストラクタ
	public Training() {
	}

	//getterとsetter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPart() {
		return part;
	}

	public void setPart(String part) {
		this.part = part;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public LocalDateTime getDatetime() {
		return datetime;
	}

	public void setDatetime(LocalDateTime datetime) {
		this.datetime = datetime;
	}

}
