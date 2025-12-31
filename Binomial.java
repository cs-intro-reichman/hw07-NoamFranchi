/** Computes the binomial(n,k) function. */
public class Binomial {	
    public static void main(String[] args) {
		// Testing the basic binomial implementation:
    	System.out.println(binomial1(Integer.parseInt(args[0]), Integer.parseInt(args[1])));

		// Testing the optimized binomial implementation:
		System.out.println(binomial(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
	}

	// Computes the Binomial function, basic version.
	public static int binomial1(int n, int k) { 
		if (k > n) return 0;
    	if (k == 0 || n == 0) return 1;
    	return binomial1(n - 1, k) + binomial1(n - 1, k - 1);
	}

	// Computes the Binomial function, efficiently
	public static int binomial(int n, int k) {
		//// This function creates a 2D array, say memo, 
		//// and then initializes all its elements to -1.
		//// It then calls binomial(n, k, memo), which does all the heavy lifiting.
		int[][] memo = new int[n + 1][k + 1];
		fillMemo(memo, memo.length);
		return binomial(n, k, memo);
	}
	
	private static void fillMemo (int[][] memo, int numRows){
		if(numRows == 0){
			return;
		}
		fillRow(memo[numRows - 1], memo[0].length);
		fillMemo(memo, numRows - 1);
	}

	private static void fillRow (int[] row, int index){
		if(index == 0){
			return;
		}
		row[index - 1] = -1;
		fillRow(row, index - 1);
	}


	private static int binomial(int n, int k, int[][] memo) {
		if (memo[n][k] != -1) {
			return memo[n][k];
		}
		// Base case
		if ((k > n)) {
		   	memo[n][k] = 0; 
		   	return 0;
		}
		// Another base case
		if (n == 0 || k == 0) {
		   	memo[n][k] = 1; 
		   	return 1;
		}
		memo[n][k] = binomial(n - 1, k, memo) + binomial(n - 1, k - 1, memo);
		return memo[n][k];
	}
}



