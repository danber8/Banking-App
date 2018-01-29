/*
 * Daniel Bertak
 * 17211967
 * Project 3
 * CurrencyExchange
 */

import java.util.Scanner;
public class CurrencyExchange {

	private static double balance = 0;
	//The double variable is declared here

	//This returns the balance
	public static double getBalance() {
		return balance;
	}

	//This rounds the balance
	//It's return value is useless but we are forced to use it but it rounds the balance well
	private static boolean updateBalance(double newBalance) {

		balance = Math.round(newBalance * 100) / 100.0;
		if (balance >= 0) {
			return true;
		} else
			return false;
	}

	//Main Method
	public static void main(String[] args){
		System.out.println("Welcome to Currency Exchange 2.0");
		Scanner input = new Scanner(System.in);  //Declares a Scanner
		printConversionTable();					//Prints the conversion table

		boolean g = true;			//This creates a loop and only exits if the user
		while (g == true){			//inputs 4

			mainMenuOptionSelector(input);	//This recalls a method and takes input
			//to decide which option to take

			//if statements for mainMenuSelection to do certain things
			if (mainMenuSelection == 1){
				//Recalls the balance
				System.out.println("Your current balance is: " + getBalance());
			}
			else if(mainMenuSelection == 2){
				//This is if the user selects deposit
				currencyMenuOptionSelector(input);	//User selects a currency
				System.out.println("Please enter the deposit amount: ");
				amount = input.nextDouble();	//User enters an amount
				if(amount < 0){					//When the user enters a neg amount
					System.out.println("Logging Error");
				}
				else{
					//When amount > 0, 
					System.out.println(logTransaction(amount, currencySelection, true));
					//The logTransaction method calls the deposit method
				}
			}
			else if(mainMenuSelection == 3){	//If the user wants to withdraw
				int xx = currencyMenuOptionSelector(input);	//User selects currency
				System.out.println("Please enter the withdrawal amount: ");
				amount = input.nextDouble();	//User enters an amount
				if(amount < 0){					//When the user enters a neg amount
					System.out.println("Logging Error");
				}
				else{
					//withdraw(amount, currencySelection);
					System.out.println(logTransaction(amount, currencySelection, false));
					//This then calls the withdraw() method
				}
			}

			if(mainMenuSelection == 4){			//This ends the program
				System.out.println("Your remaining balance is " + getBalance() + " U.S. Dollars");
				System.out.println("Goodbye");
				g = false;						//Breaks out of the loop
			}
		}
	}

	//	static int currencySelection;
	//static double amountDeposit;
	//static double amountWithdraw;
	//static double amount;
	//static int mainMenuSelection;
	static String a;
	static String b;
	static String c;
	//static double x;
	static boolean y;
	static boolean z;
	//static boolean isConvertToUSD;

	//This prints the conversion table and is only called once (before the loop)
	public static void printConversionTable(){
		System.out.println("Current rates are as follows:");
		System.out.println("1 -  U.S. Dollar - 1.00");
		System.out.println("2 - Euro - 0.89");
		System.out.println("3 - British Pound - 0.78");
		System.out.println("4 - Indian Rupee - 66.53");
		System.out.println("5 - Australian Dollar - 1.31");
		System.out.println("6 - Canadian Dollar - 1.31");
		System.out.println("7 - Singapore Dollar - 1.37");
		System.out.println("8 - Swiss Franc - 0.97");
		System.out.println("9 - Malaysian Ringgit - 4.12");
		System.out.println("10 - Japanese Yen - 101.64");
		System.out.println("11 - Chinese Yuan Renminbi - 6.67");
	}

	//The user selects an option, this is called within the loop and repeats
	public static int mainMenuOptionSelector(Scanner input){
		boolean x = true;
		int mainMenuSelection = 0;
		while(x == true){
			System.out.println("Please select an option from the list below :");
			System.out.println("1. Check the balance of your account");
			System.out.println("2. Make a deposit");
			System.out.println("3. Withdraw an amount in a specific currency");
			System.out.println("4. End your session (and withdraw all remaining currency in U.S. Dollars)");
			mainMenuSelection = input.nextInt();		//Takes user input
			if(mainMenuSelection < 1 || mainMenuSelection > 4){	//Makes sure they select a valid option
				System.out.println("Input failed validation. Please try again.");
			}
			else{
				x = false;
			}
		}
		return mainMenuSelection;
	}

	//This lets the user select a currency, it appears inside the loop if the user
	//selects either deposit or withdraw
	public static int currencyMenuOptionSelector(Scanner input){
		boolean s = true;		//Declares a boolean to make the while loop 
		int currencySelection = -5;	//Declares the currency variable
		while (s == true){
			System.out.println("Please select the currency type:");
			System.out.println("1. U.S. Dollars");
			System.out.println("2. Euros");
			System.out.println("3. British Pounds");
			System.out.println("4. Indian Rupees");
			System.out.println("5. Australian Dollars");
			System.out.println("6. Canadian Dollars");
			System.out.println("7. Singapore Dollars");
			System.out.println("8. Swiss Francs");
			System.out.println("9. Malaysian Ringgits");
			System.out.println("10. Japanese Yen");
			System.out.println("11. Chinese Yuan Renminbi");
			currencySelection = input.nextInt();	//Takes user input

			//If the user enters an invalid currency option they stay in the loop
			if (currencySelection < 1 || currencySelection > 11){
				System.out.println("Input failed validation. Please try again.");
			}
			else {
				//If the user enters an valid currency option they exit the loop
				s = false;
			}
		}
		return currencySelection;	//Returns the selection which is a global variable
		//and is used in other methods
	}

	//converts the amount entered by the user to dollars so that it can be added or 
	//subtracted from the balance
	public static double convertCurrency(double amount, int currencyType, boolean isConvertToUSD){
		double x = 0;
		if(isConvertToUSD == true){			//If the user selects
			if (currencyType == 1){			//either deposit or
				x =  amount;					//withdraw
			}
			else if(currencyType == 2){
				x = (amount/0.89);					
			}								//x is the amount in dollars
			else if(currencyType == 3){
				x = (amount/0.78);
			}
			else if(currencyType == 4){		//This method will be called before affecting the balance
				x = (amount/66.53);			
			}
			else if(currencyType == 5){
				x = (amount/1.31);
			}
			else if(currencyType == 6){
				x = (amount/1.31);
			}
			else if(currencyType == 7){
				x = (amount/1.37);
			}
			else if(currencyType == 8){
				x = (amount/0.97);
			}
			else if(currencyType == 9){
				x = (amount/4.12);
			}
			else if(currencyType == 10){
				x = (amount/101.64);
			}
			else if(currencyType == 11){
				x = (amount/6.67);
			}
		}
		else if(isConvertToUSD == false){		//converts from USD
			if (currencyType == 1){								
				x = amount;										
			}
			else if(currencyType == 2){	
				x = (amount * 0.89);					
			}													
			else if(currencyType == 3){
				x = (amount * 0.78);
			}
			else if(currencyType == 4){		
				x = (amount * 66.53);			
			}
			else if(currencyType == 5){
				x = (amount * 1.31);
			}
			else if(currencyType == 6){
				x = (amount * 1.31);
			}
			else if(currencyType == 7){
				x = (amount * 1.37);
			}
			else if(currencyType == 8){
				x = (amount * 0.97);
			}
			else if(currencyType == 9){
				x = (amount * 4.12);
			}
			else if(currencyType == 10){
				x = (amount * 101.64);
			}
			else if(currencyType == 11){
				x = (amount * 6.67);
			}
		}
		return x;
	}

	//This is the deposit method
	//It takes the amount and currencyType
	public static boolean deposit(double amount, int currencyType){
		if(amount > 0 && currencyType > 0 && currencyType < 12)  {
			balance = getBalance() + convertCurrency(amount,currencyType,true);
			return true;
		}
		else{
			return false;
		}
	}

	public static boolean withdraw(double amount, int currencyType){
		if(amount > 0 && currencyType == 1 && balance - amount > 0){	//If the user selects USD, there is no need to convert currency
			balance = getBalance() - amount;
			return true;
		}
		else if(amount > 0 && currencyType > 0 && currencyType < 12 && balance - (convertCurrency(amount,currencyType,true)*1.005) > 0){
			//convertCurrency(amount, currencyType, true);
			balance = getBalance() - (convertCurrency(amount,currencyType,true)*1.005);
			return true;
		}
		else{
			return false;
		}
	}

	//public static boolean subtractBalance()
	public static String logTransaction(double amount, int currencyType, boolean isDeposit){
		a = "faf";			//The string variables are initialized
		b = "asgdf";
		c = "sg";
		if(amount == 0){
			deposit(amount, currencyMenuOptionSelector(currencySelection));
			a = "";		//If amount is 0, the user gets an error message
			b = "";		//The strings are blank because the error message is in the deposit method
			c = "";
		}
		else if(isDeposit == true){		//If the user selects deposit and enters a valid amount
			deposit(amount, currencySelection);
			a = "You successfully deposited ";
			b = Double.toString(amount);
			c = currencyForLog(currencySelection);
		}
		else{	//The logTransaction is invoked in the case of either deposit or withdraw, if they didn't deposit then they withdrew
			withdraw(amount, currencySelection);
			if( z == false || amount == 0){	//This is when the user wants to withdraw more money than is in the account or when they want to withraw 0
				a = "";
				b = "";		//The error message comes from the withdraw method, therefore the strings here are blank
				c = "";
			}else{
				a = "You successfully withdrew ";		//The user gave valid imputs for withdraw
				b = Double.toString(amount);
				c = currencyForLog(currencySelection);
			}
		}

		return a + b + c;
	}
	public static String currencyForLog(int currencySelection){
		if(currencySelection == 1){
			c = " U.S. Dollars";		// This gives the currency that the user withdraws 
		}								//in and is called in the logTransaction method
		else if(currencySelection == 2){
			c = " Euros";
		}
		else if(currencySelection == 3){
			c = " British Pounds";
		}
		else if(currencySelection == 4){
			c = " Indian Rupees";
		}
		else if(currencySelection == 5){
			c = " Australian Dollars";
		}
		else if(currencySelection == 6){
			c = " Canadian Dollars";
		}
		else if(currencySelection == 7){
			c = " Singapore Dollars";
		}
		else if(currencySelection == 8){
			c = " Swiss Francs";
		}
		else if(currencySelection == 9){
			c = " Malaysian Ringgits";
		}
		else if(currencySelection == 10){
			c = " Japanese Yen";
		}
		else if(currencySelection == 11){
			c = " Chinese Yuan Renminbi";
		}
		return c;
	}
}
