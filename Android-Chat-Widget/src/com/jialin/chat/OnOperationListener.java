package com.jialin.chat;


public interface OnOperationListener {

	public void send(String content);
	
	public void selectedFace(String content);
	
	public void selectedFuncation(int index);
	

}
