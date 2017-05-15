package library_M;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class ManageBook {
	
	public ArrayList<Book> bookList;
	public LibraryUI manageScreen;
	Scanner sc;
	int index,price,page,borrowed;
	String title,author,borrower;
	
	
	public ManageBook(){
		
		DataIO bookData=new DataIO();
		bookList=bookData.bringBookInfo();
		manageScreen=new LibraryUI();
		sc=new Scanner(System.in);
		
			
		/*bookList.add(new Book(1,"여수의사랑","한강",10000,300));
		bookList.add(new Book(2,"82년생 김지영","조남주",11000,271));
		bookList.add(new Book(3,"마음산책X","마음산책X",21500,570));
		bookList.add(new Book(4,"나미야잡화점의기적","히가시노 게이고",13000,366));
		bookList.add(new Book(5,"미스터하이든","사샤 이랑고",31700,442));
		bookList.add(new Book(6,"기린의날개","히가시노 게이고",15120,475));
		bookList.add(new Book(7,"동급생","프레드 올드만",9720,211));*/
	}		

	
	public void searchBook(){
		
		ArrayList<Book> temp=new ArrayList<Book>();
		
		temp=manageScreen.printSearch();
		manageScreen.printBookInf(temp);
		
		System.out.println("계속 진행하시려면 Enter키를 눌러주세요");
		pause();
		
		
	}
	
	public void viewAll(){
		manageScreen.printBookInf(bookList);
		System.out.println("계속 진행하시려면 Enter키를 눌러주세요");
		pause();
	}
	
	public void returnBook(){
		
		ArrayList<Book> posReturn=new ArrayList<Book>();
		String bookNum;
		MainClass main=new MainClass();
	
		
		for(Book i : bookList){
			if(i.getBorrow()==1 && i.getBorrower()==main.getUser()){
				posReturn.add(i);
			}	
		}
		manageScreen.printBorrowInf(posReturn);
		
		do{
			try{
				System.out.print("반납하고 싶은 도서 책번호 입력 : ");
				bookNum=sc.next();
				if(bookList.get(Integer.parseInt(bookNum)-1).getBorrow()==1){
					bookList.get(Integer.parseInt(bookNum)-1).setBorrow(0);
					bookList.get(Integer.parseInt(bookNum)-1).setBorrower(null);
					bookList.get(Integer.parseInt(bookNum)-1).setBorrowTime(null);
					bookList.get(Integer.parseInt(bookNum)-1).setExtendCount(0);
					System.out.println("반납이 완료 되었습니다.");
					System.out.println("계속하시려면 Enter키를 눌러 주세요.");
					pause();
					break;
				}
				else
					throw new Exception();
				
			}catch(Exception e)
			{
				System.out.println("잘못된 책 번호 입니다.");
			}
		}while(true);
		
		
	}
	
	public void borrowBook(){

		ArrayList<Book> posBorrow=new ArrayList<Book>();
		String bookNum;
		MainClass main=new MainClass();
		ArrayList<Book> temp=new ArrayList<Book>();
		
		temp=manageScreen.printSearch();
		
		for(Book i : bookList){
			for(Book j : temp){
				if(i.getBorrow()==0 && i.getTitle().compareTo(j.getTitle())==0){
					posBorrow.add(i);
				}	
				}
		}
		manageScreen.printBookInf(posBorrow);
		
		SimpleDateFormat fm=new SimpleDateFormat("yyyy년MM월dd일");
		String time;
		Calendar cal;
		
		do{
			try{
				
				System.out.print("대출 받고 싶은 도서 책번호 입력 : ");
				bookNum=sc.next();
				if(bookList.get(Integer.parseInt(bookNum)-1).getBorrow()==0){
					cal=Calendar.getInstance();
					time=fm.format(cal.getTime());
					bookList.get(Integer.parseInt(bookNum)-1).setBorrowTime(time);
					bookList.get(Integer.parseInt(bookNum)-1).setBorrow(1);
					bookList.get(Integer.parseInt(bookNum)-1).setBorrower(main.getUser());
					
					System.out.println("대출 완료 되었습니다.");
					System.out.println("계속하시려면 Enter키를 눌러 주세요.");
					pause();
					break;
				}
				else
					throw new Exception();
				
			}catch(Exception e)
			{
				System.out.println("잘못된 책 번호 입니다.");
			}
		}while(true);
	}
	
	public void extendBorrow(){
		
		SimpleDateFormat fm=new SimpleDateFormat("yyyy년MM월dd일");
		String time;
		Calendar cal;
		ArrayList<Book> posReturn=new ArrayList<Book>();
		String bookNum;
		MainClass main=new MainClass();
	
		
		for(Book i : bookList){
			if(i.getBorrow()==1 && i.getBorrower()==main.getUser()){
				posReturn.add(i);
			}	
		}
		manageScreen.printBorrowInf(posReturn);
		
		do{
			try{
				System.out.println("연장은 최대 3회 까지 가능합니다.");
				System.out.print("대출 연장하고 싶은 도서 책번호 입력 : ");
				bookNum=sc.next();
				int count=bookList.get(Integer.parseInt(bookNum)-1).getExtendCount();
				if(count<=3){
					System.out.println((count+1)+"번째 연장이 완료 되었습니다.");
					cal=Calendar.getInstance();
					time=fm.format(cal.getTime());
					bookList.get(Integer.parseInt(bookNum)-1).setBorrowTime(time);
					bookList.get(Integer.parseInt(bookNum)-1).setExtendCount(count+1);
					System.out.println("계속하시려면 Enter키를 눌러 주세요.");
					pause();
					break;
				}
				else
					throw new Exception();
				
			}catch(Exception e)
			{
				System.out.println("잘못된 책 번호 입니다.");
			}
		}while(true);
				
	}
	
	static void pause() {
		// TODO Auto-generated method stub
		
		try{
			System.in.read();
			
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<Book> getArray(){
		return bookList;
	}
	

}
