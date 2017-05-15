package library_M;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class LibraryUI {

	private final int NEWSPACE = 80;
	public String mode;
	private Scanner sc;
	
	public LibraryUI(){
		mode=null;
		sc = new Scanner(System.in);
		
	}
	
	public int printLogin(){
		
		do{
			try{
				System.out.println("==========�ʱ�ȭ��==========");
				System.out.println("");
				System.out.println("'�α���' �Ǵ� '���� �����'");
				System.out.println("");
				System.out.println("1 : Sign in   2 : Sign up   3 : Exit");
				System.out.print("(���ڸ� �Է�) = > ");
				mode=sc.next();
				for(int i=0;i<3;i++)
					System.out.println("");
				
				if(Integer.valueOf(mode)<=3 && Integer.valueOf(mode)>=1)
					break;
				else
					throw new Exception();
			}catch(Exception e){
				System.out.println("�߸��� �Է��Դϴ�!");
			}				
		}while(true);
		
		return Integer.valueOf(mode);
		
	}
	
	public int printMenu(){
		
		do{
			try{
				System.out.println("================����� �޴�===================");
				System.out.println("=             1. �����˻�                        =");
				System.out.println("=             2. ��ü ���� ���                  =");
				System.out.println("=             3. ���� �뿩                       =");
				System.out.println("=             4. ���� �ݳ�                       =");
				System.out.println("=             5. ���� ����                       =");
				System.out.println("=             6. ȸ�� ���� ����                  =");
				System.out.println("=             7. �α׾ƿ�                        =");
				System.out.println("=             8. ȸ�� Ż��                       =");
				System.out.println("=             9. ��� ����                       =");
				System.out.println("============================================");
				System.out.println("");
				System.out.print("���Ͻô� �޴��� �������ּ���(���ڸ� �Է�) : ");
				mode = sc.next();
				
				if(Integer.valueOf(mode)<=9 && Integer.valueOf(mode)>=1)
					break;
				else
					throw new Exception();
			}catch(Exception e){
				for(int i=0;i<NEWSPACE;i++){
					System.out.println("");
				}
				System.out.println("�߸��� �Է��Դϴ�!");
			}
		}while(true);
		
		return Integer.valueOf(mode);
		
	}
	
	public int printBookSearch(){
		do{
			try{
				System.out.println("================���� �˻�================");
				System.out.println("");
				System.out.println("�˻� ����(�Է��� �ܾ �����ϴ� ���� ���)");
				System.out.println("1. å ���� ");
				System.out.println("2. ���� ");
				System.out.println("3. ���ݴ� ");
				System.out.println("4. �ڷΰ��� ");
				System.out.println("");
				System.out.print("���ϴ� ��� ����(���ڸ� �Է�) : ");
				mode = sc.next();
				
				if(Integer.valueOf(mode)<=4 && Integer.valueOf(mode)>=1)
					break;
				else
					throw new Exception();
			}catch(Exception e){
				System.out.println("");
				System.out.println("�߸��� �Է��Դϴ�!");
				System.out.println("");
				
			}
		}while(true);
		
		return Integer.valueOf(mode);
	}
	
	
	public void printBookInf(ArrayList<Book> book){
		
		for(Book i : book){
			System.out.println("------------------------------------------------------");
			System.out.println("- å ��ȣ "+i.getIndex());
			System.out.println("");
			System.out.println("å ���� : "+i.getTitle());
			System.out.println("���� : "+i.getAuthor()+" | å ���� : "+i.getPrice()+" | ������ �� : "+i.getPage()+" |");
			if(i.getBorrow()==0){
				System.out.println("(O) ���� ���� ����");
			}else if(i.getBorrow()==1)
				System.out.println("(X) ���� �Ұ��� ����");
		}
		
		System.out.println("����Ʈ �������Դϴ�.");
		
	}
	
	
	public ArrayList<Book> printSearch(){
		int mode=this.printBookSearch();
		String name, auth;
		
		ManageBook manage=new ManageBook();
		ArrayList<Book> temp=new ArrayList<Book>();
		ArrayList<Book> book=manage.getArray();
		
		
		int chPrice=0;
		String limitChoice=null;
		
		switch(mode){
		case 1:
		{
			System.out.print("å ���� �Է� : ");
			name=sc.next();
			
			System.out.println("================���� ����Ʈ================");
			for(int i=0;i<book.size();i++){
				if(book.get(i).getTitle().contains(name)){
					temp.add(book.get(i));
				}
			}
			break;
		}
		case 2:
		{
			System.out.print("å ���� �Է� : ");
			auth=sc.next();
			System.out.println("================���� ����Ʈ================");
			
			for(int i=0;i<book.size();i++){
				if(book.get(i).getAuthor().contains(auth)){
					temp.add(book.get(i));
				}
			}
			break;
		}
		case 3:
		{
			do{
				try{
					System.out.println("1 : ���Ѽ� ����   2 : ���Ѽ� ���� ");
					System.out.print("=> ");
					limitChoice=sc.next();
					
					if(Integer.parseInt(limitChoice)==1 || Integer.parseInt(limitChoice)== 2)
						break;
					else
						throw new Exception();
				}catch(Exception e)
				{
					System.out.println("�ٽ� �Է����ֽñ� �ٶ��ϴ�");
					System.out.println("");
				}
			}while(true);
			
			System.out.print("�ݾ� �Է� : ");
			chPrice=sc.nextInt();
			System.out.println("");
			System.out.println("================���� ����Ʈ================");
			if(Integer.parseInt(limitChoice)==1){
				for(int i=0;i<book.size();i++){
					if(book.get(i).getPrice()>=chPrice){
						temp.add(book.get(i));
					}
				}
			}else if(Integer.parseInt(limitChoice)==2){
				for(int i=0;i<book.size();i++){
					if(book.get(i).getPrice()<=chPrice){
						temp.add(book.get(i));
					}
				}
				
			}	
			break;
		}
		case 4:
		{
			break;
		}
		
		}
		
		return temp;
	}
	
	
	public void printBorrowInf(ArrayList<Book> book){
		
		SimpleDateFormat fm=new SimpleDateFormat("yyyy��MM��dd��");
		String borrowTime;
		String returnTime;
		Date returnD=null;
		for(Book i : book){
			System.out.println("------------------------------------------------------");
			System.out.println("- å ��ȣ "+i.getIndex());
			System.out.println("");
			System.out.println("å ���� : "+i.getTitle());
			System.out.println("�뿩 ��¥ : "+i.getBorrowTime());
			try {
				returnD=fm.parse(i.getBorrowTime());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Calendar returnC=Calendar.getInstance();
			returnC.setTime(returnD);
			returnC.add(Calendar.DATE, 7);
			returnTime=fm.format(returnC.getTime());
			System.out.println("�ݳ� ���� : "+returnTime);
			System.out.println("���� Ƚ�� : "+i.getExtendCount());

		}
		
		
	}
	
}
