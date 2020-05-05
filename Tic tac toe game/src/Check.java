
public class Check {
	
	/*Function that is converting the first character of the user's choice*/
	
	public static int Convert_First_Choice(int thesis1,char letter) {
		
		if(letter == 'A')				
			thesis1 =  0;
		else if(letter == 'B')			
			thesis1 = 1;
		else if(letter == 'C') 			
			thesis1 = 2;
		
		return thesis1;
	}
	
	/*Function that is converting the second character of the user's choice*/
	
	public static int Convert_Second_Choice(int thesis2,char number) {
		
		if(number == '1')				
			thesis2 = 0;				
		else if(number == '2')		
			thesis2 = 1;
		else if(number == '3')
			thesis2 = 2;
		
		return thesis2;
	}
	
	/*Checking the validity of the first character of the user's choice*/
	
	public static boolean Check_If_Letter_Is_Correct(char letter) {
		
		return ((letter == 'A' || letter== 'B' || letter =='C'));
	}
	
	/*Checking the validity of the second character of the user's choice*/
	
	public static boolean Check_If_Number_Is_Correct(char number) {
		
		return ((number == '1' || number == '2' || number  == '3'));
	}
	
}
