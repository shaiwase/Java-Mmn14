/**
 * 
 * @author karine 
 * MMN 14 Computer sciences Java 20441
 * 
 */
public class Ex14 {


	//**************************************************************************************************************
	// Question 1 Efficiency of the program O(n^1.5)
	//**************************************************************************************************************
 
	/**
	 * This method checks if the amount of divisors of a and b is equal to the sum of divisors of b equals a . (a and b are 2 numbers
	 * Smaller than n      O(n^1.5) Efficiency
	 * @param number n given by the method countFriends.
	 * @return The sum of the numbers that can be divided 
	 */ 
	private static int calculateSum(int n)
	{
		int sum = 1;   
		for (int i = 2; i <= n/2; i++)
		{
			if (n % i == 0)
			{
				sum += i;
			}
		}
		return sum;
	}
	/**
	 * 
	 * @param n
	 * @return  The number of  number couples (of numbers) smaller than "n" 
	 */
	public static int countFriends(int n)
	{
		int friends = 0;
		int other;
		for (int i = 0; i < n; i++) //Runs on all the numbers smaller than the input number n
		{
			other = calculateSum(i); //calls the Private calculate method 
			if (i != calculateSum(i) && other > i)
			{
				if (calculateSum(other) == i) //find the number of friends
				{
					friends++;
				}
			}
		}
		return friends;
	}

	//***********************************************************************************************************
	// Question 2 
	// Binary search - O(Logn)
	//***********************************************************************************************************
	//
	/**
	 * This Method will return the number of time the number as input appears in the array. Search is based on binary search, 
	 * Efficiancy is 	 * O(Logn)
	 * @param a
	 * @param x
	 * @return the number of sequences of this number in the array
	 */
	public static int count (int [] a, int x)  
	{
		//Creates 2 variables start and end of the array
		int start = 0;
		int stop = a.length -1;

		while ( start < stop)
		{
			//divide the array in 2
			int middleIndex = start + (stop - start) /2; 

			if (a[middleIndex] < x) 
				start = middleIndex + 1; //First occurrence will come after the index of the middle of the array 

			else if 

			(a[middleIndex] > x ) //First occurrence will come before the index of the middle of the array 
				stop = middleIndex - 1;

			else 
				stop = middleIndex; // Found an occurrence

		}

		if (stop < start || a[start] != x) //No occurrence found
			return 0;

		int first = start; //Creates a variable for the first occurrence
		stop = a.length -1; //Set the last occurrence between low and length -1 included

		while (start < stop)
		{
			int middleIndex = start + (stop + 1 - start) /2;

			if (a[middleIndex] > x) //Last occurrence will be before the middle of the array
				stop = middleIndex - 1;
			else
				start = middleIndex;
		}

		return (stop - first + 1); //return the number of occurrences for the number

	}

	//*************************************************************************************************************************
	//Question 3
	//*************************************************************************************************************************

	/**
	 * Method who calls the recursive method fib
	 * @param n  Size of the boad - Column number
	 * @param m  Size of the boad - keep it 2 for multidimentional board
	 * @return the number of possibilities to cover the board of a multidimentional (m) board with n columns
	 */
	public static int domino(int n, int m) 
	{

		return fib((n * m) / 2);
	}

	/**
	 * Fibonacci method 
	 * @param n - int from the domino method for board size given in input
	 * @return the fibonnacci sequence for n number
	 */
	public static int fib(int n)
	{
		if( n < 2)
			return 1;
		else
			return fib(n - 1) + fib(n - 2);
	}


	//*************************************************************************************************************************
	// Question 4
	//*************************************************************************************************************************
	/**
	 * This method calls the recursive method findPassword
	 * @param solution
	 * @param length
	 * @return The cracked password
	 */
	public static String findPassword(Password p,  int length)
	{
		return findPassword( p, length); //Calls the recursion
	}

	/**
	 * Recursive method called in order to find the password 
	 * @param p
	 * @param length
	 * @param pass
	 * @param alphabetIndex
	 * @return The password generated
	 */
	public static String findPassword(Password p,int length, String pass, int alphabetIndex )
	{
		String alphabet = "abcdefghijklmnopqrstuvwxyz";

		if (pass.length() == length) //Stop case
		{
			if (p.equals(pass))
				return pass;
			return "";
		}

		if (alphabetIndex < alphabet.length()) //keep on binding the password if password lenght not reached. 
		{
			String found = findPassword(p, length, pass + alphabet.charAt(alphabetIndex), 0);

			if (found.length() == 0)
			{
				return findPassword(p, length, pass, alphabetIndex + 1);
			}

			return found; //Return the found password.
		}

		return "";
	}



}


