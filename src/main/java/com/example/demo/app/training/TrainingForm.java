package com.example.demo.app.training;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;


//htmlの入力値を一括で受け取るFormクラス。
public class TrainingForm {

	//フィールド
	@NotNull (message = "未入力です。")
	private String part;
	private String menu;
	@NotNull (message = "期限を設定してください。")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private LocalDateTime datetime;

	//デフォルトコンストラクタ
	public TrainingForm() {
	}

	//getterとsetter
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
