package library_M;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

public class DataIO {
	
	private final String BOOKPATH = "src/bookList.txt";
	private final String USERPATH = "src/userList.txt";
	BufferedReader in;
	FileWriter out;
	String s;
	String[] result;
	
	public ArrayList<Book> bringBookInfo(){
		ArrayList<Book> temp=new ArrayList<Book>();
		
		try{
			in=new BufferedReader(new FileReader(BOOKPATH));
			int i=0;
			while(true){
				s=in.readLine();
				Book book=new Book();
				if(s!=null){
					result = s.split(",");
					book.setIndex(Integer.parseInt(result[0]));
					book.setTitle(result[1]);
					book.setAuthor(result[2]);
					book.setPrice(Integer.parseInt(result[3]));
					book.setPage(Integer.parseInt(result[4]));
					book.setBorrow(Integer.parseInt(result[5]));
					if(Integer.parseInt(result[5])==1){
						book.setBorrower(result[6]);
						book.setBorrowTime(result[7]);
						book.setExtendCount(Integer.parseInt(result[8]));
					}
					
					
				}else
					break;
				
				temp.add(i,book);
				i++;
			}
			
			
			in.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		
		
		
		return temp;
	}

	public ArrayList<UserList> bringUserInfo(){
		ArrayList<UserList> temp=new ArrayList<UserList>();
		
		try{
			in=new BufferedReader(new FileReader(USERPATH));
			int i=0;
			while(true){
				s=in.readLine();
				UserList user=new UserList();
				if(s!=null){
					result = s.split(",");
					user.setName(result[0]);
					user.setId(result[1]);
					user.setPass(result[2]);
					user.setPhone(result[3]);
					user.setMail(result[4]);
				}else
					break;
				
				temp.add(i,user);
				i++;
			}	
			in.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		return temp;
	}
	
	
	public void storeBookInfo(ArrayList<Book> book){
		String temp;
		
		try {
			out = new FileWriter(BOOKPATH);
			for(Book i : book){
				temp=i.getIndex()+","+i.getTitle()+","+i.getAuthor()+","+i.getPrice()+","+i.getPage()+","+i.getBorrow()+","+i.getBorrower()
				+","+i.getBorrowTime()+","+i.getExtendCount()+"\n";
			
				
				out.write(temp);

			}
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		

	}
	
	public void storeUserInfo(ArrayList<UserList> user){
		
		
		String temp;
		
		try {
			out = new FileWriter(USERPATH);
			for(UserList i : user){
				temp=i.getName()+","+i.getID()+","+i.getPass()+","+i.getPhone()+","+i.getMail()+"\n";
				
				
				out.write(temp);

			}
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
