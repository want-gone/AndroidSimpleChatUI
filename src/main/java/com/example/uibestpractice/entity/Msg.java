package com.example.uibestpractice.entity;

/**
 * 消息实体类
 * @author gaopengfei
 */
public class Msg {

	public static final int TYPE_RECEIVED = 0;
	public static final int TYPE_SENT = 1;

	private String content; // 消息内容
	private int type;		// 消息类型，可选值是上面的两个常量

	public Msg(String content, int type) {
		this.content = content;
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public int getType() {
		return type;
	}

}
