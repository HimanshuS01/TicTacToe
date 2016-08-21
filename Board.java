package TicTacToe;

public class Board {
	//We make them private so that no one can change the board and players name.
	private final char[][] board;
	/*We define symbol to the board initially coz we cannot give any random symbol to the board
	and board must know the symbol of the players before the game actually starts.*/
	private char Player1Symbol;
	private char Player2Symbol;

	//Static because it will be shared or remains same for every object.
	//This is a fix value and we dont want to change it.
	//We can also use enum(enumeration) which assigns the value by default.
	public final static int Player1_Won=1;
	public final static int Player2_Won=2;
	public final static int DRAW=3;
	public final static int Not_Finished=4;

	public Board(char Player1Symbol , char Player2Symbol){
		this.Player1Symbol=Player1Symbol;
		this.Player2Symbol=Player2Symbol;
		board=new char[3][3];
		//By default board will takes zero as its entry that is why we initialize it with space character.
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				board[i][j]=' ';
			}
		}
	}
	public int getGameStatus(){
		for(int i=0;i<3;i++){
			if(board[i][0]==board[i][1] && board[i][0]==board[i][2]){
				if(board[i][0]==Player1Symbol){
					return Player1_Won;
				}
				else if(board[i][0]==Player2Symbol){
					return Player2_Won;
				}
			}
		}
		for(int i=0;i<3;i++){
			if(board[0][i]==board[1][i] && board[0][i]==board[2][i]){
				if(board[0][i]==Player1Symbol){
					return Player1_Won;
				}
				else if(board[0][i]==Player2Symbol){
					return Player2_Won;
				}
			}
		}
		if(board[0][0]==board[1][1] && board[0][0]==board[2][2]){
			if(board[0][0]==Player1Symbol){
				return Player1_Won;
			}
			else if(board[0][0]==Player2Symbol){
				return Player2_Won;
			}
		}
		if (board[2][0] == board[1][1] && board[2][0] == board[0][2]) {
			if (board[2][0] == Player1Symbol) {
				return Player1_Won;
			} else if (board[2][0] == Player2Symbol) {
				return Player2_Won;
			}
		}
		for (int i =0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] == ' ') {
					return Not_Finished;
				}
			}
		}
		return DRAW;
	}
	public void print() {
		System.out.println("-------");
		for (int i =0; i < 3; i++) {
			System.out.print("|");
			for (int j = 0; j < 3; j++) {
				System.out.print(board[i][j] + "|");
			}
			System.out.println();
			System.out.println("-------");
		}
	}
	public void makeaMove(int x, int y, char symbol) throws InvalidMoveException {

		if (x < 0 || x > 2|| y < 0 || y > 2 || board[x][y] != ' ') {
			InvalidMoveException e = new InvalidMoveException();
			throw e;
		}
		board[x][y] = symbol;
	}
}
