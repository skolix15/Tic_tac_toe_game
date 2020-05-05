import java.util.Random;

public class PlayBoard {
	
	private char[][] board = new char[3][3];

	/*Creating a constructor. 
	 *(Creating a two-dimensional empty array).*/
	
	public PlayBoard() {
		
		for(int i=0;i<3;i++)
			for(int j=0;j<3;j++)
				board[i][j]= ' ';
	}
	
	/*Function that is entering user's choice*/
	
	public void Enter_Players_Choice(int thesi1, int thesi2) {
		
		board[thesi1][thesi2] = 'X';
	}
	
	/*Function that is printing the array*/
	
	public void Print_Board() {
		
		for(int i=0;i<3;i++) {
			System.out.println();
			for(int j=0;j<3;j++)
				System.out.print(" | " + board[i][j] + " |");
			}
		System.out.println();
	}
	
	/*Function that is checking if a winner exists.*/
	
	public boolean Check_If_Someone_Won(char ch[]) {
		
		boolean row = false;
		boolean column = false;
		boolean diag = false;
		
		for(int i=0;i<3;i++) {
			
			/*Checking the rows*/
			
			if(board[i][0] == board[i][1] && board[i][1] ==  board[i][2]) {			
				ch[0] = board[i][0];
				row = true;	
				}
			
			/*Checking the columns*/
			
			else if(board[0][i] == board[1][i] && board [1][i] == board[2][i]) {		
				ch[0] = board[0][i];
				column = true;
			}
		}
		
		/*Checking the one diagonal*/
		
		if(board[0][2] == board [1][1] && board[1][1] == board[2][0]) {				
			ch[0] = board[0][2];
			diag= true;
		}
		
		/*Checking the second diagonal*/
		
		else if(board[0][0] == board [1][1] && board[1][1] == board[2][2]) {	
			ch[0] = board[0][0];
			diag= true;
		}
		
		return ((row || column || diag) && ch[0] != ' ');
		
	}
	
	/*Function that is entering computer's choice*/
	
	public void Enter_Choice_For_Computer() {
		
		Random do_random = new Random();
		
		while(true) {
			
			int choice1_for_computer = do_random.nextInt(10)%3;
			int choice2_for_computer = do_random.nextInt(10)%3;
	
			if(board[choice1_for_computer][choice2_for_computer] == ' ') {
				board[choice1_for_computer][choice2_for_computer] = 'O';
				break;
				}
			else 
				continue;
		
		}
	}
	
	/*Function that is checking player's choice validity*/
	
	public boolean Check_If_Players_Choice_Is_Wrong(char letter, char number, int thesi1, int thesi2) {
	
		boolean correct_letter;
		boolean correct_number;
		
		correct_letter = Check.Check_If_Letter_Is_Correct(letter);
		correct_number = Check.Check_If_Number_Is_Correct(number);
		
		boolean flag = false;
		if(!correct_letter || !correct_number || board[thesi1][thesi2] != ' ') 
			flag = true;
	
		return flag;
	
	}
	
	/*Function that is checking if the game led to tie*/
	
	public boolean Check_If_Nobody_Won(boolean win) {
		
		boolean nobody_wins = false;
		boolean found_space = false;
		
		for(int i=0;i<3;i++)
			for(int j=0;j<3;j++)
				if(board[i][j] == ' ')
					found_space = true;
		if(!found_space && !win)
			nobody_wins = true;
		
		return nobody_wins;
					
				
	}
	
	
}
	
	

