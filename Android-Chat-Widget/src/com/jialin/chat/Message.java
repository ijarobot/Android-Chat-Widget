package com.jialin.chat;

import java.util.Date;

public class Message {
	public final static int MSG_TYPE_TEXT 	= 0;
	public final static int MSG_TYPE_PHOTO 	= 1;
	public final static int MSG_TYPE_FACE 	= 2;
	
	public final static int MSG_STATE_SENDING 	= 0;
	public final static int MSG_STATE_SUCCESS 	= 1;
	public final static int MSG_STATE_FAIL 		= 2;
	
	private Long id;
	private Integer type;		// 0-text | 1-photo | 2-face | more type ... TODO://
	private Integer state; 		// 0-sending | 1-success | 2-fail
	private String fromUserName;
	private String fromUserAvatar;
	private String toUserName;
	private String toUserAvatar;
	private String content;

	private Boolean isSend;
	private Boolean sendSucces;
	private Date time;

	public Message(Integer type, Integer state, String fromUserName,
			String fromUserAvatar, String toUserName, String toUserAvatar,
			String content, Boolean isSend, Boolean sendSucces, Date time) {
		super();
		this.type = type;
		this.state = state;
		this.fromUserName = fromUserName;
		this.fromUserAvatar = fromUserAvatar;
		this.toUserName = toUserName;
		this.toUserAvatar = toUserAvatar;
		this.content = content;
		this.isSend = isSend;
		this.sendSucces = sendSucces;
		this.time = time;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getFromUserName() {
		return fromUserName;
	}

	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}

	public String getFromUserAvatar() {
		return fromUserAvatar;
	}

	public void setFromUserAvatar(String fromUserAvatar) {
		this.fromUserAvatar = fromUserAvatar;
	}

	public String getToUserName() {
		return toUserName;
	}

	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}

	public String getToUserAvatar() {
		return toUserAvatar;
	}

	public void setToUserAvatar(String toUserAvatar) {
		this.toUserAvatar = toUserAvatar;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Boolean getIsSend() {
		return isSend;
	}

	public void setIsSend(Boolean isSend) {
		this.isSend = isSend;
	}

	public Boolean getSendSucces() {
		return sendSucces;
	}

	public void setSendSucces(Boolean sendSucces) {
		this.sendSucces = sendSucces;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

}
