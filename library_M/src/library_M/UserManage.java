package library_M;

import java.io.Console;
import java.util.ArrayList;
import java.util.Scanner;

public class UserManage {
	
	private UserList user=new UserList();
	private Scanner sc=new Scanner(System.in);
	private String name=null,id=null,phNum=null,mail=null;
	private String passwrd;
	private final int NEWSPACE = 80;
	private Console console=System.console();
	
	public String getUser(){
		return id;
	}
	public String getPass(){
		return passwrd;
	}
	
	public UserList signUp(ArrayList<UserList> member){
		
		
		UserList temp = null;
		do{
			try{
				
				System.out.println("==========ȸ������==========");
				System.out.println("�̸� �Է�(2-10�� �̳��� �ѱ�) : ");
				name=sc.next();
				System.out.println("���̵� �Է�(4-16�� �̳�) : ");
				id=sc.next();
				System.out.println("��й�ȣ �Է�(8-16�� �̳�) : ");
				passwrd=sc.next();
				System.out.println("��ȭ��ȣ �Է�(���� => 010-####-####) : ");
				phNum=sc.next();
				System.out.println("�̸��� �Է�(���� => gusdn0563@naver.com) : ");
				mail=sc.next();
				
				if(name.length()>=2 && name.length()<=10 && id.length()>=4 && id.length()<=16
						&& passwrd.length()>=8 && passwrd.length()<=16 && phNum.matches("01[016789]-(\\d{3,4})-(\\d{4})")
						&& mail.contains("@"))
				{
					for(UserList u : member){
						if(u.getID().compareTo(id)==0){
							
							System.out.println("�̹� �����ϴ� ���̵� �Դϴ�!");
							temp=u;
							throw new Exception();
						}
					}
							
					System.out.println("ȸ�� ���� �Ϸ�.");
					try{ Thread.sleep(1000);}
					catch(Exception e){e.printStackTrace();}

										
					break;
					
				}else
					throw new Exception();
				
					
			}catch(Exception e){
				for(int i=0;i<3;i++)
					System.out.println("");
			
					
				if(name.length()<2 || name.length()>10){
					System.out.println("[ �� �� ]");
				}
				if(id.length()<4 ||  id.length()>16){
					System.out.println("[ �� �� �� ]");
				}
				if(passwrd.length()<8 || passwrd.length()>16){
					System.out.println("[ �� �� �� ȣ ]");
				}
				if(!(phNum.matches("01[016789]-(\\d{3,4})-(\\d{4})"))){
					System.out.println("[ �޴��� ��ȣ ]");
				}
				if(!mail.contains("@")){
					System.out.println("[ �� �� �� ]");
				}
				System.out.println("��Ŀ� �°� �Է����ֽñ� �ٶ��ϴ�.");
				
			}
		}while(true);
		
		user.setMail(mail);
		user.setName(name);
		user.setPass(passwrd);
		user.setPhone(phNum);
		user.setId(id);

		return user;
		
	}
	
	
	public boolean signIn(ArrayList<UserList> member){
		
		int count=0;
		int success=0;
		
		do{
			try{
				System.out.println("==========�α���==========");
				
				System.out.println("���̵� : ");
				id=sc.next();
				System.out.println("��й�ȣ : ");
				passwrd = sc.next();
				
				for(UserList i : member){
					if(i.getID().compareTo(id)==0 && i.getPass().compareTo(passwrd)==0)
					{
						System.out.println("�α��ο� �����ϼ̽��ϴ�.");
						try{ Thread.sleep(1000);}
						catch(Exception e){e.printStackTrace();}
						success=1;
						break;
						
					}
				}
				if(success==1)
					break;
				else
					throw new Exception();

				
			}catch(Exception e){
				count++;
				
				if(count==3){
					System.out.println("�α��� 3ȸ�� ���� ���α׷� ����!");
					System.exit(0);
				}
				System.out.println("");
				System.out.println("�߸��� ���̵� Ȥ�� ��й�ȣ�Դϴ�.");
				System.out.println("3ȸ Ʋ�� �� ���α׷��� ����˴ϴ�. ["+count+"/3]" );
				System.out.println("");	
			}
		}while(true);
		
		return true;
		
	}
	
	public void editUserInfo(ArrayList<UserList> userList){
		
		UserList user=new UserList();
		UserList temp=new UserList();
		String name=null,id=null,phNum=null,mail=null;
		String passwrd;
		String pasCheck1;
		int i=0;
		
		MainClass main=new MainClass();
		
		
		for(int j=0;j<userList.size();j++)
		{
			if(userList.get(j).getID().compareTo(main.getUser())==0){
				i=j;
				break;
			}			
		}
		
		System.out.print("��й�ȣ �Է� : ");
		pasCheck1=sc.next();
		
		if(userList.get(i).getPass().compareTo(pasCheck1)==0){
			
			do{
				try{
					System.out.println("================ȸ�� ���� ����================");
					System.out.println("�̸� �Է�(���� : "+userList.get(i).getName()+" ) : ");
					name=sc.next();
					System.out.println("��й�ȣ �Է�(8-16�� �̳�) : ");
					passwrd=sc.next();
					System.out.println("��ȭ��ȣ �Է�(���� : "+userList.get(i).getPhone()+" ) : ");
					phNum=sc.next();
					System.out.println("�̸��� �Է�(���� : "+userList.get(i).getMail()+" ) : ");
					mail=sc.next();
					
					
					if(name.length()>=2 && name.length()<=10 && id.length()>=4 && id.length()<=16
							&& passwrd.length()>=8 && passwrd.length()<=16 && phNum.matches("01[016789]-(\\d{3,4})-(\\d{4})")
							&& mail.contains("@"))
					{
						for(UserList u : userList){
							if(u.getID().compareTo(id)==0){
								System.out.println("�̹� �����ϴ� ���̵� �Դϴ�!");
								throw new Exception();
							}
						}
								
						System.out.println("ȸ�� ���� �Ϸ�.");
						try{ Thread.sleep(1000);}
						catch(Exception e){e.printStackTrace();}

											
						break;
						
					}else
						throw new Exception();
					
				}catch(Exception e)
				{
					
				}
				
			}while(true);
			userList.get(i).setName(name);
			userList.get(i).setPass(passwrd);
			userList.get(i).setPhone(phNum);
			userList.get(i).setMail(mail);
		}else{
			System.out.println("��й�ȣ�� �ùٸ��� �ʽ��ϴ�!");
			System.out.println("��� �����Ͻ÷��� EnterŰ�� �����ֽñ� �ٶ��ϴ�.");
			ManageBook.pause();
		}
	
		
	}
	
	public void deleteUser(ArrayList<UserList> userList){
		
		int i=0;
		MainClass main=new MainClass();
		
		for(int j=0;j<userList.size();j++)
		{
			if(userList.get(j).getID().compareTo(main.getUser())==0){
				i=j;
				break;
			}			
		}
		
		
		System.out.println(userList.get(i).getID()+" | "+main.getUser() );
		
		userList.remove(i);
	}
	




}
