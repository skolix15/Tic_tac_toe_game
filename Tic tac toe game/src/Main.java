import java.util.Scanner;

public class Main {

	
	public static void main(String[] args) {
		
		/*Creating two-dimensional array for the game*/
		
		PlayBoard board = new PlayBoard();
	
		/*Creating an array with one element where who won will be kept. ( 'X' or 'O' )*/
		
		char[] ch = new char[1];
		ch[0] = ' ';
		
		/*Creating scanner in order the user to write his/her choice*/
		
		Scanner scanner = new Scanner(System.in);
		
		String choice;				  		
		
		boolean check_choice;  		 		
		
		boolean win = false; 		  		
		boolean nobody_wins = false;  		
									  		
		/*Printing the empty array*/
		
		board.Print_Board();		  		
		
		while(true) {
		
			System.out.print("\nPlease enter the column (A, B or C) ");
			System.out.println("and then the row (1, 2, or 3) of your move:");
			
			/*The user is writing to the console his/her choice*/
			
			choice = scanner.nextLine();	
			
			/*Converting user's choice to uppercase letters*/
			
			choice = choice.toUpperCase();	
											
			/*The variables "letter" and "number" will be used as indexes in an array.*/
			
			char letter = choice.charAt(0);		
			char number = choice.charAt(1);
		
			/*These variables it will need to be converted in to numbers.*/
			/*So this will happen below.*/
			
			/*The letter shows the row of the array*/
			int position1 = letter;			
			
			/*The number shows the column of the array*/
			int position2 = number;			
			
			/*The type of the number that the user entered is "char".
			 *It needs to be converted to type "int".*/
			
			position1 = Check.Convert_First_Choice(position1, letter); 		// (A => 1, B => 2, C => 3 )		
																		
			position2 = Check.Convert_Second_Choice(position2, number); 		
																			
			/*Checking the validity of the user's choice.*/
			
			check_choice = board.Check_If_Players_Choice_Is_Wrong(letter, number, position1,position2);
			
			if(check_choice) { 										
				System.out.println("Wrong choice, try again.");
				continue;
			}
			
			else {
				
				/*User's choice*/
				board.Enter_Players_Choice(position1, position2);		
				
				/*Checking if the user won or if the game led to tie*/
				
				win = board.Check_If_Someone_Won(ch);
				nobody_wins = board.Check_If_Nobody_Won(win);
				
				if(win || nobody_wins)
					break;
				
				/*Computer's choice*/
				
				board.Enter_Choice_For_Computer();				
				
				/*Checking if the computer won or if the game led to tie*/
				
				win = board.Check_If_Someone_Won(ch);
				nobody_wins = board.Check_If_Nobody_Won(win);		
				
				if(win || nobody_wins)
					break;
			} 
				
				/*Printing the array*/
				board.Print_Board();								
				
		 }
		
		/*Printing the array*/
		board.Print_Board();										
		
		if(win) {
			
			/*Checking if the computer won*/
			if(ch[0] == 'O')										
				System.out.println("\nComputer won!!!");	
			
			/*Checking if the user won*/
			else if(ch[0] == 'X')									
				System.out.println("\nYou won!!!");	
			}
		
		/*Checking if the game led to tie*/
		else if(nobody_wins) 										
			System.out.println("\nNobody won!!!");		
		
		
		scanner.close();
  
	}
}
	
	

