package com.show.DTO;

public class ShowDTO {
	// 필드
	private String title;
	private String contents; // 내용설명
	private String category; // 프로그램 종류
	private String director;
	private String actor;
	private boolean netflix;
	private boolean tVing;
	private boolean disney;

	// 생성자

	// 메서드
	public String getTitle() {
		return title;
	}

	public String getContents() {
		return contents;
	}

	public String getCategory() {
		return category;
	}

	public String getDirector() {
		return director;
	}

	public String getActor() {
		return actor;
	}

	public boolean isNetflix() {
		return netflix;
	}

	public boolean istVing() {
		return tVing;
	}

	public boolean isdisney() {
		return disney;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public void setNetflix(boolean netflix) {
		this.netflix = netflix;
	}

	public void settVing(boolean tVing) {
		this.tVing = tVing;
	}

	public void setdisney(boolean disney) {
		this.disney = disney;
	}

	

}
