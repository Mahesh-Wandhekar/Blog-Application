package com.nt.Binding;

import org.springframework.stereotype.Component;

import jakarta.persistence.Lob;

@Component
public class AddBlogBinding {

	private String title;
	private String shortDesc;
	@Lob
	private String description;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getShortDesc() {
		return shortDesc;
	}
	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "AddBlogBinding [title=" + title + ", shortDesc=" + shortDesc + ", description=" + description + "]";
	}
	
	
}
