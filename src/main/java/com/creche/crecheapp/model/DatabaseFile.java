package com.creche.crecheapp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;

@Entity

public class DatabaseFile implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3559848561869171818L;

	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")

	private String id;

	private String fileName;

	private String fileType;
	@Lob
	private byte[] data;

	// plusieur image associer a une seule post
	@JsonBackReference
	@ManyToOne(fetch = FetchType.EAGER)
	private Post post;

	public DatabaseFile() {
		super();

	}

	public DatabaseFile(String fileName, String fileType, byte[] data) {
		super();
//		this.id = id;
		this.fileName = fileName;
		this.fileType = fileType;
		this.data = data;
	}
	

	public DatabaseFile(String fileName, String fileType, byte[] data, Post post) {
		super();
//		this.id = id;
		this.fileName = fileName;
		this.fileType = fileType;
		this.data = data;
		this.post = post;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

}
