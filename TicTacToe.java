package TicTacToe;

import java.util.Scanner;

//It is a kind of manager class which manages the board class and player class...
public class TicTacToe {

	//We can also make that function static but for that we have to create an object and than call the function.
	public static Player getPlayer(int playerNumber){
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the player"+playerNumber+"name");
		String name=s.nextLine();
		char symbol=' ';
		System.out.println("Enter the player"+playerNumber+"symbol");
		symbol=s.nextLine().charAt(0);//i.e First character of that String.
		return new Player(name,symbol);

	}
	public static void start(){
		Player p1=getPlayer(1);
		boolean done =false;
		Player p2=null;
		while(!done){
			p2=getPlayer(2);
			if(p1.symbol != p2.symbol){
				done=true;
			}
			else{
				System.out.println("Two players cannot have same symbol!");
			}
		}
		Board b=new Board(p1.symbol,p2.symbol);

		boolean isPlayer1Turn=true;
		b.print();

		while(b.getGameStatus()==Board.Not_Finished){
			Player currentPlayer=null;
			if(isPlayer1Turn){
				currentPlayer=p1;
			}
			else{
				currentPlayer=p2;
			}

			System.out.println(currentPlayer.name + "'s turn");
			Scanner s=new Scanner(System.in);
			System.out.println("Enter  x coordinate:");
			int x=s.nextInt();
			System.out.println("Enter  y coordinate:");
			int y=s.nextInt();
			try{
				b.makeaMove(x,y,currentPlayer.symbol);
				isPlayer1Turn=!isPlayer1Turn;
			}
			catch(InvalidMoveException e ){
				System.out.println("Invalid move Try again!");
			}				
			b.print();
		}
		int result=b.getGameStatus();

		if(result==Board.Player1_Won){
			System.out.println(p1.name + "Won!");
		}
		else if(result==Board.Player2_Won){
			System.out.println(p2.name + "Won!");
		}
		else{
			System.out.println("Draw!");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		start();
	}
}
