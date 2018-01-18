package group.LC2;

public class SparseMatrixMult {

	public int[][] multiply(int[][] A, int[][] B) {
		// lets just try a simple matrix mult
		if (A == null || B == null)
			return null;
		int m = A.length, n = B[0].length;
		int[][] C = new int[m][n];
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
				// this is the most crucial part - this is a huge time
				// saver!!!!!!!!!!
				// ***
				if (A[i][j] != 0) {
					// ***
					for (int k = 0; k < B[0].length; k++) {
						if (B[j][k] != 0)// this is a small check
							C[i][k] += A[i][j] * B[j][k];
					}
				}
			}
		}
		return C;
	}
}