package library_M;

import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {
	
	public final static int NEWSPACE = 80;
	private static String nowUser;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		UserManage login = new UserManage(); // ȸ�� ���� �� �α��� �� ȸ�� ������ �����ϴ� class
		LibraryUI screen = new LibraryUI(); // �α��� ȭ�� �� ����ȭ�� ���� ȭ���� ǥ���ϴ� class
		boolean successLogin=false;//true�̸� �α��� ����
		ManageBook manager=new ManageBook();//�������� ȭ�鿡���� ����
		DataIO dataIO=new DataIO();
		
		ArrayList<UserList> u_inform=dataIO.bringUserInfo();//ȸ�������� ��� ���� Arraylist
		
		
		int loginMenu=0; // �α��� ȭ�鿡���� �޴� ����
		int mainMenu=0;
		
		do{
			loginMenu=screen.printLogin();
			
			if(loginMenu==1)
			{//�α���
				newScreen();
				
				successLogin=login.signIn(u_inform);
			
				while(successLogin){
					nowUser=login.getUser();
					mainMenu=screen.printMenu();
					switch(mainMenu){
					case 1: //�����˻�
						newScreen();
						manager.searchBook();
						break;
					case 2: //��ü ���� ���
						newScreen();
						manager.viewAll();
						break;
					case 3: //���� �뿩
						newScreen();
						manager.borrowBook();
						break;
					case 4: //���� �ݳ�
						newScreen();
						manager.returnBook();
						break;
					case 5: //���� ����
						newScreen();
						manager.extendBorrow();
						break;
					case 6: //ȸ�� ���� ����
						newScreen();
						login.editUserInfo(u_inform);
						break;
					case 7: //�α׾ƿ�
						newScreen();
						successLogin=false;
						break;
					case 8: //ȸ�� Ż��
						newScreen();
						login.deleteUser(u_inform);
						successLogin=false;
						break;
					case 9: // �ý��� ����
						System.out.println("�ý����� ���� �ϰڽ��ϴ�.");
						dataIO.storeUserInfo(u_inform);
						dataIO.storeBookInfo(manager.getArray());
						System.exit(0);
					}
	
				}
				
			}
			else if(loginMenu==2)//ȸ������
			{
				newScreen();
				u_inform.add(login.signUp(u_inform));
				
				try{
					Thread.sleep(1000);
				}catch(Exception e){
					e.printStackTrace();
				}
				
			}
			else if(loginMenu==3){ //�ý��� ����
				System.out.println("�ý����� ���� �ϰڽ��ϴ�.");
				dataIO.storeUserInfo(u_inform);
				dataIO.storeBookInfo(manager.getArray());
				System.exit(0);
			}
		
		}while(true);
		
	}
	
	public static void newScreen(){
		for(int i=0;i<NEWSPACE;i++){
			System.out.println("");
		}
	}
	
	public String getUser(){
		return nowUser;
	}
	


}


