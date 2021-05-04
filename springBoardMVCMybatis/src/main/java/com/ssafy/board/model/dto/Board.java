package com.ssafy.board.model.dto;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class Board implements Serializable {
	private int no;
	private String id;
	private String title;
	private String regdate;
	private String contents;
	
	/**파일 저장할 경로*/
	private String dir;
	/**upload된 파일 정보 */
	private MultipartFile[] fileup;
	/**DB에 저장된 파일 정보*/
	private List<BoardFile> files;
	
	public Board() {}

	@Override
	public String toString() {
		return "Board [no=" + no + ", id=" + id + ", title=" + title + ", regdate=" + regdate + ", contents=" + contents
				+ ", dir=" + dir + ", fileup=" + Arrays.toString(fileup) + ", files=" + files + "]";
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	public MultipartFile[] getFileup() {
		return fileup;
	}

	public void setFileup(MultipartFile[] fileup) {
		this.fileup = fileup;
	}

	public List<BoardFile> getFiles() {
		return files;
	}

	public void setFiles(List<BoardFile> files) {
		this.files = files;
	}
}





