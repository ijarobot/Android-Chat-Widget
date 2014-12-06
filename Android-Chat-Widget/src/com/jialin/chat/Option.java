package com.jialin.chat;

import android.content.Context;
import android.graphics.drawable.Drawable;

public class Option {
	
	private String name;
	private Drawable iconDrawable;
	
	
	
	public Option(String name, Drawable iconDrawable) {
		super();
		this.name = name;
		this.iconDrawable = iconDrawable;
	}
	
	public Option(Context context, String name, int iconResId) {
		super();
		this.name = name;
		this.iconDrawable = context.getResources().getDrawable(iconResId);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Drawable getIconDrawable() {
		return iconDrawable;
	}
	public void setIconDrawable(Drawable iconDrawable) {
		this.iconDrawable = iconDrawable;
	}
	
	
}
