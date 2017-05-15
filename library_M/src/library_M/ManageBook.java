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
		
			
		/*bookList.add(new Book(1,"�����ǻ��","�Ѱ�",10000,300));
		bookList.add(new Book(2,"82��� ������","������",11000,271));
		bookList.add(new Book(3,"������åX","������åX",21500,570));
		bookList.add(new Book(4,"���̾���ȭ���Ǳ���","�����ó� ���̰�",13000,366));
		bookList.add(new Book(5,"�̽������̵�","��� �̶���",31700,442));
		bookList.add(new Book(6,"�⸰�ǳ���","�����ó� ���̰�",15120,475));
		bookList.add(new Book(7,"���޻�","������ �õ常",9720,211));*/
	}		

	
	public void searchBook(){
		
		ArrayList<Book> temp=new ArrayList<Book>();
		
		temp=manageScreen.printSearch();
		manageScreen.printBookInf(temp);
		
		System.out.println("��� �����Ͻ÷��� EnterŰ�� �����ּ���");
		pause();
		
		
	}
	
	public void viewAll(){
		manageScreen.printBookInf(bookList);
		System.out.println("��� �����Ͻ÷��� EnterŰ�� �����ּ���");
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
				System.out.print("�ݳ��ϰ� ���� ���� å��ȣ �Է� : ");
				bookNum=sc.next();
				if(bookList.get(Integer.parseInt(bookNum)-1).getBorrow()==1){
					bookList.get(Integer.parseInt(bookNum)-1).setBorrow(0);
					bookList.get(Integer.parseInt(bookNum)-1).setBorrower(null);
					bookList.get(Integer.parseInt(bookNum)-1).setBorrowTime(null);
					bookList.get(Integer.parseInt(bookNum)-1).setExtendCount(0);
					System.out.println("�ݳ��� �Ϸ� �Ǿ����ϴ�.");
					System.out.println("����Ͻ÷��� EnterŰ�� ���� �ּ���.");
					pause();
					break;
				}
				else
					throw new Exception();
				
			}catch(Exception e)
			{
				System.out.println("�߸��� å ��ȣ �Դϴ�.");
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
		
		SimpleDateFormat fm=new SimpleDateFormat("yyyy��MM��dd��");
		String time;
		Calendar cal;
		
		do{
			try{
				
				System.out.print("���� �ް� ���� ���� å��ȣ �Է� : ");
				bookNum=sc.next();
				if(bookList.get(Integer.parseInt(bookNum)-1).getBorrow()==0){
					cal=Calendar.getInstance();
					time=fm.format(cal.getTime());
					bookList.get(Integer.parseInt(bookNum)-1).setBorrowTime(time);
					bookList.get(Integer.parseInt(bookNum)-1).setBorrow(1);
					bookList.get(Integer.parseInt(bookNum)-1).setBorrower(main.getUser());
					
					System.out.println("���� �Ϸ� �Ǿ����ϴ�.");
					System.out.println("����Ͻ÷��� EnterŰ�� ���� �ּ���.");
					pause();
					break;
				}
				else
					throw new Exception();
				
			}catch(Exception e)
			{
				System.out.println("�߸��� å ��ȣ �Դϴ�.");
			}
		}while(true);
	}
	
	public void extendBorrow(){
		
		SimpleDateFormat fm=new SimpleDateFormat("yyyy��MM��dd��");
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
				System.out.println("������ �ִ� 3ȸ ���� �����մϴ�.");
				System.out.print("���� �����ϰ� ���� ���� å��ȣ �Է� : ");
				bookNum=sc.next();
				int count=bookList.get(Integer.parseInt(bookNum)-1).getExtendCount();
				if(count<=3){
					System.out.println((count+1)+"��° ������ �Ϸ� �Ǿ����ϴ�.");
					cal=Calendar.getInstance();
					time=fm.format(cal.getTime());
					bookList.get(Integer.parseInt(bookNum)-1).setBorrowTime(time);
					bookList.get(Integer.parseInt(bookNum)-1).setExtendCount(count+1);
					System.out.println("����Ͻ÷��� EnterŰ�� ���� �ּ���.");
					pause();
					break;
				}
				else
					throw new Exception();
				
			}catch(Exception e)
			{
				System.out.println("�߸��� å ��ȣ �Դϴ�.");
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
