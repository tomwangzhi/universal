package com.universal.db.entity;

public class JobTask {
	private int id;
	private int status;
	private String content;
	private Long send_time;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getSend_time() {
		return send_time;
	}

	public void setSend_time(Long send_time) {
		this.send_time = send_time;
	}

	@Override
	public String toString() {
		return "JobTask [id=" + id + ", status=" + status + ", content=" + content + ", send_time=" + send_time + "]";
	}

}
