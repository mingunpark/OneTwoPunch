package tictactoc_M;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe{
	
	private final static int COM = 1;
	private final static int PLAYER = 2;
	
	
	
	private String[] field;
	Scanner in;
	
	
	public TicTacToe(){
		field =new String[]{"①", "②", "③", "④", "⑤", "⑥", "⑦", "⑧", "⑨"};
		in = new Scanner(System.in);

	}
	
	public void printField(){
		System.out.println("---------------------------------");
		for(int i=0;i<9;i+=3){
			for(int j=0;j<3;j++){
				System.out.print("     "+field[i+j]+"     ");
			}
			System.out.println("");
		}
		System.out.println("---------------------------------");
		
		
	}
	
	
	public void checkMyPt(){

		int pick=0;
		do{
			try{
				System.out.println("Player1's Turn!");
				System.out.print("Your Pick is : ");
				pick = in.nextInt();
				if(field[pick-1]!="O" && field[pick-1]!="X")
					break;
				else
					throw new Exception();
			}catch(Exception e){
				System.out.println("");
				System.out.println(pick+" is already picked");
				System.out.println("Please Try Again!");
				System.out.print("");
				printField();
			}
		}while(true);
			
		
		field[pick-1]="O";
		
	}
	
	public void checkCompPt(int player){
		
		int pick=0;
		

		if(player==COM){
			do{
				try{
					Random rd=new Random();
					pick=rd.nextInt(8);
					
					if(field[pick]!="O" && field[pick]!="X")
						break;
					else
						throw new Exception();
				}catch(Exception e){
					System.out.println("");
					System.out.println("COMPUTER RETRY...");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}while(true);

		}else if(player==PLAYER){
			do{
				try{
					System.out.println("Player2's Turn!");
					System.out.print("Your Pick is : ");
					pick = in.nextInt();
					pick-=1;
					if(field[pick]!="O" && field[pick]!="X")
					
						break;
					else
						throw new Exception();
				}catch(Exception e){
					System.out.println("");
					System.out.println(pick+" is already picked");
					System.out.println("Please Try Again!");
					System.out.print("");
					printField();
				}
			}while(true);
		}
		
		field[pick]="X";
		
	}
	
	public int checkWinner(){
		int winner=0;
		// 1P 승 : winner =1
		// 컴터/2P 승 : winner = 3;
		for(int i=0;i<7;i+=3){
			if(field[i]=="O" && field[i+1]=="O"&&field[i+2]=="O")
				winner =1;
			else if(field[i]=="X" && field[i+1]=="X"&&field[i+2]=="X")
				winner = 3;

		}//가로 줄 비교
		for(int i=0;i<3;i++){
			if(field[i]=="O" && field[i+3]=="O"&&field[i+6]=="O")
				winner =1;
			else if(field[i]=="X" && field[i+3]=="X"&&field[i+6]=="X")
				winner = 3;

		}//세로 줄 비교
		
		if((field[0]=="O" && field[4]=="O" && field[8]=="O") || 
				(field[2]=="O" && field[4]=="O" && field[6]=="O"))
			winner=1;
		else if((field[0]=="X" && field[4]=="X" && field[8]=="X") || 
				(field[2]=="X" && field[4]=="X" && field[6]=="X"))
			winner=3;

		
		return winner;
	}
	

}
