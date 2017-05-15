package library_M;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Book {
	
	private int index;
	private String title;
	private String author;
	private int price;
	private int page;
	private int borrowed; //¾Èºô·Á°¬À¸¸é 0, ºô·Á°¬À¸¸é 1
	private String borrower;
	private String borrowTime;
	private int extend;
	
	/*public Book(int index,String title,String author,int price,int page)
	{
		this.index=index;
		this.title=title;
		this.author=author;
		this.price=price;
		this.page=page;
		this.borrowed=0;
		this.extend=0;
		borrower=null;
		borrowTime=null;
	}*/


	public int getIndex(){
		return index;
	}
	
	public String getTitle(){
		return title;
	}
	
	public String getAuthor(){
		return author;
	}
	
	public String getBorrower(){
		return borrower;
	}
	
	public String getBorrowTime(){
		return borrowTime;
	}
	

	
	public int getPrice(){
		return price;
	}
	
	public int getPage(){
		return page;
	}
	
	public int getBorrow(){
		return borrowed;
	}
	
	public int getExtendCount(){
		return extend;
	}
	
	public void setAuthor(String author){
		this.author=author;
	}
	
	public void setIndex(int i){
		this.index=i;
	}
	
	public void setTitle(String title){
		this.title=title;
	}
	
	public void setPage(int i){
		this.page=i;
	}
	public void setPrice(int i){
		this.price=i;
	}
	
	
	public void setBorrow(int b){
		this.borrowed=b;
	}
	
	public void setBorrower(String man){
		this.borrower=man;
	}
	
	public void setBorrowTime(String time){
		this.borrowTime=time;
	}
	
	public void setExtendCount(int count){
		this.extend=count;
	}

	

}
