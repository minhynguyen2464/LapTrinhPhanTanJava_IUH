package baitap;

import java.io.Serializable;

public class MyDictionary implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int word_key;
	private String english;
	private String vietnamese;
	
	public MyDictionary(int word_key, String english, String vietnamese) {
		this.word_key = word_key;
		this.english = english;
		this.vietnamese = vietnamese;
	}
	
	public int getWord_key() {
		return word_key;
	}
	public void setWord_key(int word_key) {
		this.word_key = word_key;
	}
	public String getEnglish() {
		return english;
	}
	public void setEnglish(String english) {
		this.english = english;
	}
	public String getVietnamese() {
		return vietnamese;
	}
	public void setVietnamese(String vietnamese) {
		this.vietnamese = vietnamese;
	}
}
