package recursion;

//java program to print all N-bit binary 
import java.io.*;

class Recursion_5 { 
	// function to generate n digit numbers
	static void printRec(String number, int extraOnes, int remainingPlaces) {
		// if number generated
		if (0 == remainingPlaces) {
			System.out.print(number + " ");
			return;
		}

		// Append 1 at the current number and
		// reduce the remaining places by one
		printRec(number + "1", extraOnes + 1, remainingPlaces - 1);

		// If more ones than zeros, append 0 to the
		// current number and reduce the remaining
		// places by one
		if (0 < extraOnes)
			printRec(number + "0", extraOnes - 1, remainingPlaces - 1);
	}

	static void printNums(int n) {
		String str = "";
		printRec(str, 0, n);
	}

	// Driver function
	public static void main(String[] args) {
		int n = 4;
		printNums(n);

	}
}

// This code is contributed by vt_m
