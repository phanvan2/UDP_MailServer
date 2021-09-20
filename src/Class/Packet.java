package Class;

import java.io.Serializable;

public class Packet implements Serializable {
	private int define_require; 
	private String name; 
	private String title ; 
	private String date ; 
	private String content; 
	private String File ; 
	private String FileImage;
	public Packet() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Packet(String name, String title, String date, String content, String file, String fileImage) {
		super();
		this.name = name;
		this.title = title;
		this.date = date;
		this.content = content;
		File = file;
		FileImage = fileImage;
	}
	public Packet(int define_require, String name, String title, String date, String content, String file, String fileImage) {
		super();
		this.define_require = define_require; 
		this.name = name;
		this.title = title;
		this.date = date;
		this.content = content;
		File = file;
		FileImage = fileImage;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getFile() {
		return File;
	}
	public void setFile(String file) {
		File = file;
	}
	public String getFileImage() {
		return FileImage;
	}
	public void setFileImage(String fileImage) {
		FileImage = fileImage;
	}
	public int getDefine_require() {
		return define_require;
	}
	public void setDefine_require(int define_require) {
		this.define_require = define_require;
	} 
	
}
