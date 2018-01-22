package pers.zhy.model;

public class Order {

	private int id;
	private String sender;
	private String sender_tel;
	private String sender_address;
	private String receiver;
	private String re_tel;
	private String re_address;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getSender_tel() {
		return sender_tel;
	}

	public void setSender_tel(String sender_tel) {
		this.sender_tel = sender_tel;
	}

	public String getSender_address() {
		return sender_address;
	}

	public void setSender_address(String sender_address) {
		this.sender_address = sender_address;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getRe_tel() {
		return re_tel;
	}

	public void setRe_tel(String re_tel) {
		this.re_tel = re_tel;
	}

	public String getRe_address() {
		return re_address;
	}

	public void setRe_address(String re_address) {
		this.re_address = re_address;
	}
}
