package tictactoc_M;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.*;
import java.util.*;
import java.util.Scanner;

/* Develop by Mingun
 * [ Tic-Tac-Toe(3�� ����) ]
 * 1. ���� ����
 * 1-1. vs ��ǻ�� ����
 * 1-2. vs ���� ����
 * 1-3. ������ ������ ���鼭
 * 1-4. ������ �������� Ȯ�� �����ϵ���
 * 1-5. ���� �Ǵ��ϱ�. ���º� ����.
 * 2. ������ ����
 * 2-1. ������ ǥ�������� ����
 */

// ��� �����ϰ� ��������(�޴� 3�� ���� ����), ��õ� ���

public class MainClass {

	public final static int NEWSPACE = 80;
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 // �޴� ���ÿ�
		
		int checkTurn = 0; //�� �ְ� �ޱ��
		int checkWin = 0; // ���ڰ������
		int count=0; // ���º� ã�Ƴ����
		
		int mode = printMenu();
		
		while(true){
			switch(mode){
			case 1: //���Ϳ��� ����
				TicTacToe gameC = new TicTacToe();
		
				while(true){
					if(checkTurn == 0){
						for(int i=0;i<NEWSPACE;i++){
							System.out.println("");
						}
						gameC.printField();
						gameC.checkMyPt();
						checkTurn=1;// ���� �ְ� ������ ���� ����
					}else if(checkTurn == 1)
					{
						for(int i=0;i<NEWSPACE;i++){
							System.out.println("");
						}
						System.out.println("COMPUTER TURN!");
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						gameC.checkCompPt(1);
						checkTurn=0;
					}
					checkWin=gameC.checkWinner();
					
				    if(checkWin==1){
				    	gameC.printField();
				    	System.out.println("Player 1 Win! Congraturation!");
				    	saveResult(1,checkWin);
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						break;
				    
				    }else if(checkWin==3){
				    	gameC.printField();
				    	System.out.println("Computer Win! Your're Looser...");
				    	saveResult(1,checkWin);
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
				    }
				    
				    count++;
				    if(count==9){
				    	gameC.printField();
				    	System.out.println("You Draw!");
				    	
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				    	checkWin=2;
				    	saveResult(1,checkWin);
						break;
				    }// count�� 9�ε� �ºΰ� �ȳ����� ���º�
				    
				}
				
				count=0;
				checkTurn = 0;
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				for(int i=0;i<NEWSPACE;i++){
					System.out.println("");
				}
				
				mode = printMenu();
				
				break;
				
			case 2: // �÷��̾� 2���� ����
				TicTacToe gameP = new TicTacToe();
				while(true){
					if(checkTurn == 0){
						for(int i=0;i<NEWSPACE;i++){
							System.out.println("");
						}
						gameP.printField();
						gameP.checkMyPt();
						checkTurn=1;// ���� �ְ� ������ ���� ����
					}else if(checkTurn == 1)
					{
						for(int i=0;i<NEWSPACE;i++){
							System.out.println("");
						}
						gameP.printField();
						gameP.checkCompPt(2);
						checkTurn=0;
					}
					checkWin=gameP.checkWinner();
					
				    if(checkWin==1){
				    	gameP.printField();
				    	System.out.println("Player 1 Win! Congraturation!");
				    	
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						saveResult(2,checkWin);
						break;
				    
				    }else if(checkWin==3){
				    	gameP.printField();
				    	System.out.println("Player 2 Win! Congraturation!");
				    	
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						saveResult(2,checkWin);
						break;
				    }
				    
				    count++;
				    if(count==9){
				    	gameP.printField();
				    	System.out.println("You Draw!");
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				    	checkWin=2;
				    	saveResult(2,checkWin);
						break;
				    }// count�� 9�ε� �ºΰ� �ȳ����� ���º�
				    
				}
				
				count=0;
				checkTurn = 0;
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				for(int i=0;i<NEWSPACE;i++){
					System.out.println("");
				}
								
				mode = printMenu();
				
				
				break;
			case 3:
				for(int i=0;i<NEWSPACE;i++){
					System.out.println("");
				}
				printResult();
				
				System.out.println("����Ͻ÷��� Enter Ű�� �����ּ���.");
				
				pause();
				
				for(int i=0;i<NEWSPACE;i++){
					System.out.println("");
				}
				
				mode = printMenu();
				break;
			case 4:
				System.out.println("See you next time~!");				
				System.exit(0);
				break;
				
			}
				
		
		}


	}
	
	private static void pause() {
		// TODO Auto-generated method stub
		
		try{
			System.in.read();
			
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}

	public static int printMenu(){
		int mode;
		Scanner sc = new Scanner(System.in);
		
		do{
			try{
				System.out.println("========================================");
				System.out.println("=              1. vs COM               =");
				System.out.println("=              2. vs USER              =");
				System.out.println("=              3. SCORE                =");
				System.out.println("=              4. EXIT                 =");
				System.out.println("========================================");
				System.out.println("");
				System.out.print("Select Number : ");
				mode = sc.nextInt();
				
				if(mode<=4 && mode>=1)
					break;
				else
					throw new Exception();
			}catch(Exception e){
				for(int i=0;i<NEWSPACE;i++){
					System.out.println("");
				}
				System.out.println("Wrong Number!");
			}
		}while(true);
		
		return mode;
		
	}
	
	public static void printResult(){
		
		int[] resultC=bringResult_C();
		int[] resultP=bringResult_P();
		
		System.out.println("===========  SCORE BOARD  ============");
		System.out.println("");
		System.out.println("           Player 1 vs COM            ");
		System.out.println("   Player 1      DRAW       COM       ");
		System.out.println("         "+resultC[0]+"         "+resultC[1]+"         "+resultC[2]+"         ");
		System.out.println("");
		System.out.println("         Player 1 vs Player 2         ");
		System.out.println("   Player 1      DRAW     Player 2    ");
		System.out.println("         "+resultP[0]+"         "+resultP[1]+"         "+resultP[2]+"         ");
		System.out.println(""); 
		System.out.println("======================================");
	}
	
	public static void saveResult(int mode, int winner){// mode = 1. vs Com 2. vs Player
		
		try{
			if(mode==1){
				
				int[] resultC=bringResult_C();
				
				FileWriter writeC = new FileWriter("src/result_C.txt");
				
				resultC[winner-1]++;
				
				String temp = resultC[0]+" "+resultC[1]+" "+resultC[2];
				
				writeC.write(temp);
				
				writeC.close();
				
			}else if(mode==2){
				
				int[] resultP=bringResult_P();
				
				FileWriter writeP = new FileWriter("src/result_P.txt");
				
				resultP[winner-1]++;
				
				String temp = resultP[0]+" "+resultP[1]+" "+resultP[2];
				
				writeP.write(temp);
				
				writeP.close();
			}
		}catch(IOException e){
			e.printStackTrace();
		}

	}
	
	public static int[] bringResult_C(){
		
		int[] arr=new int[3];
		
		String s;
		
		try{
			BufferedReader in = new BufferedReader(new FileReader("src/result_C.txt"));
		
			while((s = in.readLine())!=null){
				String[] result = s.split(" ");	
				arr[0] = Integer.valueOf(result[0]); 
				arr[1] = Integer.valueOf(result[1]);
				arr[2] = Integer.valueOf(result[2]);
			}
			
			in.close();
		}catch(IOException e){
			e.printStackTrace();
		}	
		
		
		return arr;
	}
	
	public static int[] bringResult_P(){
		
		int[] arr=new int[3];
		
		String s;
		
		try{
			BufferedReader in = new BufferedReader(new FileReader("src/result_P.txt"));
		
			while((s = in.readLine())!=null){
				String[] result = s.split(" ");	
				arr[0] = Integer.valueOf(result[0]); 
				arr[1] = Integer.valueOf(result[1]);
				arr[2] = Integer.valueOf(result[2]);
			}
			
			in.close();
		}catch(IOException e){
			e.printStackTrace();
		}	
		
		
		return arr;
	}
	
	

}
