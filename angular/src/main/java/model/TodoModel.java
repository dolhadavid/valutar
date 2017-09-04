package model;

public class TodoModel {

	private Integer id;
	private String text;

	public TodoModel() {
	}

	public TodoModel(String text) {
		this.text = text;
	}

	public TodoModel(Integer id, String text) {
		this.id = id;
		this.text = text;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
