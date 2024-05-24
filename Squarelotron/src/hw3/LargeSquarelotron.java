package hw3;

/**
 * Represents a large Squarelotron, which is a square array with dimensions 5x5.
 * It inherits from the Squarelotron class.
 */
public class LargeSquarelotron extends Squarelotron {
	/**
	 * Creates a new LargeSquarelotron based on the provided integer array.
	 *
	 * @param array The integer array used for creating the LargeSquarelotron.
	 */
	public LargeSquarelotron(int[] array) {
		super(array);
	}

	/**
	 * Reverses the LargeSquarelotron by 180 degrees along the inner or outer ring.
	 *
	 * @param ring The ring to be reversed. It can be "inner" or "outer".
	 * @return A new LargeSquarelotron containing the reversed ring.
	 * @throws IllegalArgumentException If an invalid ring is provided.
	 */
	public Squarelotron upsideDownFlip(String ring) {
		if ((!ring.equals("inner")) && (!ring.equals("outer")))
			throw new IllegalArgumentException("Give inner or outer");

		int[][] copyThisArray = this.getArray();
		int[] upsideDownFlipArray1d = new int[copyThisArray.length * copyThisArray.length];
		LargeSquarelotron upsideDownFlipArray = new LargeSquarelotron(upsideDownFlipArray1d);
		int[][] copyUpsideDownFlipArray = upsideDownFlipArray.getArray();
		int k = 0, s = 0;
		if (ring.equals("outer")) {

			for (int i = copyThisArray.length - 1; i >= 0; i--) {
				for (int j = 0; j < copyThisArray[i].length; j++) {
					if (i == 0 || i == 4)
						copyUpsideDownFlipArray[k][s] = copyThisArray[i][j];
					else if ((i == 3) && (j == 1 || j == 2 || j == 3))
						copyUpsideDownFlipArray[k][s] = copyThisArray[i - 2][j];

					else if ((i == 1) && (j == 1 || j == 2 || j == 3))
						copyUpsideDownFlipArray[k][s] = copyThisArray[i + 2][j];
					else
						copyUpsideDownFlipArray[k][s] = copyThisArray[i][j];
					s++;
				}
				k++;
				s = 0;
			}
		} else if (ring.equals("inner")) {
			for (int i = 0; i < copyThisArray.length; i++) {
				for (int j = 0; j < copyThisArray[i].length; j++) {
					if (i == 0 || i == 4)
						copyUpsideDownFlipArray[k][s] = copyThisArray[i][j];
					else if ((i == 3) && (j == 1 || j == 2 || j == 3))
						copyUpsideDownFlipArray[k][s] = copyThisArray[i - 2][j];

					else if ((i == 1) && (j == 1 || j == 2 || j == 3))
						copyUpsideDownFlipArray[k][s] = copyThisArray[i + 2][j];
					else
						copyUpsideDownFlipArray[k][s] = copyThisArray[i][j];
					s++;
				}
				k++;
				s = 0;
			}

		}
		upsideDownFlipArray.setArray(copyUpsideDownFlipArray);
		
		return upsideDownFlipArray;
	}

	/**
	 * Reverses the LargeSquarelotron by 180 degrees along the width of the inner or outer ring.
	 *
	 * @param ring The ring to be reversed. It can be "inner" or "outer".
	 * @return A new LargeSquarelotron containing the reversed ring.
	 * @throws IllegalArgumentException If an invalid ring is provided.
	 */
	public Squarelotron leftRightFlip(String ring) {
		if ((!ring.equals("inner")) && (!ring.equals("outer")))
			throw new IllegalArgumentException("Give inner or outer");

		int[][] copyThisArray = this.getArray();
		int[] leftRight1d = new int[copyThisArray.length * copyThisArray.length];
		LargeSquarelotron leftRight = new LargeSquarelotron(leftRight1d);
		int[][] copyleftRight = leftRight.getArray();
		int k = 0, s = 0;

		if (ring.equals("outer")) {
			for (int i = 0; i < copyThisArray.length; i++) {
				for (int j = copyThisArray[i].length - 1; j >= 0; j--) {
					if (i == 0 || i == 4)
						copyleftRight[k][s] = copyThisArray[i][j];
					else if ((i == 2) && (j == 3))
						copyleftRight[k][s + 2] = copyThisArray[i][j];
					else if ((i == 2) && (j == 1))
						copyleftRight[k][s - 2] = copyThisArray[i][j];
					else if ((i == 1) && (j == 3))
						copyleftRight[k][s + 2] = copyThisArray[i][j];
					else if ((i == 1) && (j == 1))
						copyleftRight[k][s - 2] = copyThisArray[i][j];
					else if ((i == 3) && (j == 3))
						copyleftRight[k][s + 2] = copyThisArray[i][j];
					else if ((i == 3) && (j == 1))
						copyleftRight[k][s - 2] = copyThisArray[i][j];
					else
						copyleftRight[k][s] = copyThisArray[i][j];
					s++;
				}
				k++;
				s = 0;
			}
		} else if (ring.equals("inner")) {
			for (int i = 0; i < copyThisArray.length; i++) {
				for (int j = 0; j < copyThisArray[i].length; j++) {
					if (i == 0 || i == 4)
						copyleftRight[k][s] = copyThisArray[i][j];
					else if ((i == 2) && (j == 3))
						copyleftRight[k][s - 2] = copyThisArray[i][j];
					else if ((i == 2) && (j == 1))
						copyleftRight[k][s + 2] = copyThisArray[i][j];
					else if ((i == 1) && (j == 3))
						copyleftRight[k][s - 2] = copyThisArray[i][j];
					else if ((i == 1) && (j == 1))
						copyleftRight[k][s + 2] = copyThisArray[i][j];
					else if ((i == 3) && (j == 3))
						copyleftRight[k][s - 2] = copyThisArray[i][j];
					else if ((i == 3) && (j == 1))
						copyleftRight[k][s + 2] = copyThisArray[i][j];
					else
						copyleftRight[k][s] = copyThisArray[i][j];
					s++;
				}
				k++;
				s = 0;
			}
		}

		leftRight.setArray(copyleftRight);
		
		return leftRight;
	}

	/**
	 * Reverses the LargeSquarelotron diagonally along the inner or outer ring.
	 *
	 * @param ring The ring to be reversed. It can be "inner" or "outer".
	 * @return A new LargeSquarelotron containing the reversed ring.
	 * @throws IllegalArgumentException If an invalid ring is provided.
	 */
	public Squarelotron inverseDiagonalFlip(String ring) {
		if ((!ring.equals("inner")) && (!ring.equals("outer")))
			throw new IllegalArgumentException("Give inner or outer");

		int[][] copyThisArray = this.getArray();
		int[] inverse1d = new int[copyThisArray.length * copyThisArray.length];
		LargeSquarelotron inverse = new LargeSquarelotron(inverse1d);
		int[][] copyInverse = inverse.getArray();
		int k = 0, s = 0;
		if (ring.equals("outer")) {

			for (int i = copyThisArray.length - 1; i >= 0; i--) {
				for (int j = copyThisArray[i].length - 1; j >= 0; j--) {
					if ((i + j >= copyThisArray.length) && ((i == 2) && (i + j == copyThisArray.length)))
						copyInverse[k + 1][s + 1] = copyThisArray[i][j];

					else if ((i + j >= copyThisArray.length) && ((i == 3) && (i + j == copyThisArray.length + 1)))
						copyInverse[k + 2][s + 2] = copyThisArray[i][j];

					else if ((i + j >= copyThisArray.length) && ((i == 3) && (i + j == copyThisArray.length)))
						copyInverse[k + 1][s + 1] = copyThisArray[i][j];

					else if (i + j >= copyThisArray.length)
						copyInverse[k][s] = copyThisArray[i][j];

					else if ((i + j < copyThisArray.length - 1) && ((i == 1) && (i + j == copyThisArray.length - 3)))
						copyInverse[k - 2][s - 2] = copyThisArray[i][j];

					else if ((i + j < copyThisArray.length - 1) && (i == 1) && (i + j == copyThisArray.length - 2))
						copyInverse[k - 1][s - 1] = copyThisArray[i][j];

					else if ((i + j < copyThisArray.length - 1) && (i == 2) && (i + j == copyThisArray.length - 2))
						copyInverse[k - 1][s - 1] = copyThisArray[i][j];

					else if (i + j < copyThisArray.length - 1)
						copyInverse[k][s] = copyThisArray[i][j];

					else if (i + j == copyThisArray.length - 1)
						copyInverse[k][s] = copyThisArray[i][j];
					k++;
				}
				k = 0;
				s++;
			}

		} else if (ring.equals("inner")) {
			for (int i = 0; i < copyThisArray.length; i++) {
				for (int j = 0; j < copyThisArray[i].length; j++) {
					if (i == 1 && j == 1)
						copyInverse[k + 2][s + 2] = copyThisArray[i][j];
					else if (i == 3 && j == 3)
						copyInverse[k - 2][s - 2] = copyThisArray[i][j];
					else if (i == 2 && j == 1)
						copyInverse[k + 1][s + 1] = copyThisArray[i][j];
					else if (i == 3 && j == 2)
						copyInverse[k - 1][s - 1] = copyThisArray[i][j];
					else if (i == 1 && j == 2)
						copyInverse[k + 1][s + 1] = copyThisArray[i][j];
					else if (i == 2 && j == 3)
						copyInverse[k - 1][s - 1] = copyThisArray[i][j];
					else
						copyInverse[k][s] = copyThisArray[i][j];
					s++;
				}
				s = 0;
				k++;
			}
		}
		inverse.setArray(copyInverse);
	
		return inverse;
	}

	/**
	 * Rotates the LargeSquarelotron by 90 degrees around the main diagonal, either for the inner or outer ring.
	 *
	 * @param ring The ring to be rotated. It can be "inner" or "outer".
	 * @return A new LargeSquarelotron containing the rotated ring.
	 * @throws IllegalArgumentException If an invalid ring is provided.
	 */
	public Squarelotron mainDiagonalFlip(String ring) {
		if ((!ring.equals("inner")) && (!ring.equals("outer")))
			throw new IllegalArgumentException("Give inner or outer");

		int[][] copyThisArray = this.getArray();
		int[] inverse1d = new int[copyThisArray.length * copyThisArray.length];
		LargeSquarelotron inverse = new LargeSquarelotron(inverse1d);
		int[][] copyInverse = inverse.getArray();
		if (ring.equals("outer")) {

			int k = 0, s = copyThisArray[0].length - 1;

			for (int i = copyThisArray.length - 1; i >= 0; i--) {
				for (int j = 0; j < copyThisArray.length; j++) {
					if ((i > j) && ((i == 3) && i + j == copyThisArray.length - 1))
						copyInverse[k + 2][s - 2] = copyThisArray[i][j];

					else if ((i < j) && ((i == 1) && i + j == copyThisArray.length - 1))
						copyInverse[k - 2][s + 2] = copyThisArray[i][j];

					else if ((i > j) && ((i == 2) && i + j == copyThisArray.length - 2))
						copyInverse[k + 1][s - 1] = copyThisArray[i][j];

					else if ((i < j) && ((i == 1) && i + j == copyThisArray.length - 2))
						copyInverse[k - 1][s + 1] = copyThisArray[i][j];

					else if ((i > j) && ((i == 3) && i + j == copyThisArray.length))
						copyInverse[k + 1][s - 1] = copyThisArray[i][j];

					else if ((i < j) && ((i == 2) && i + j == copyThisArray.length))
						copyInverse[k - 1][s + 1] = copyThisArray[i][j];

					else if (i > j)
						copyInverse[k][s] = copyThisArray[i][j];

					else if (i < j)
						copyInverse[k][s] = copyThisArray[i][j];

					else if (i == j)
						copyInverse[k][s] = copyThisArray[i][j];
					k++;
				}
				k = 0;
				s--;
			}

		} else if (ring.equals("inner")) {
			int k = 0, s = 0;
			for (int i = 0; i < copyThisArray.length; i++) {
				for (int j = 0; j < copyThisArray[i].length; j++) {
					if (i == 1 && j == 2)
						copyInverse[k + 1][s - 1] = copyThisArray[i][j];
					else if (i == 2 && j == 1)
						copyInverse[k - 1][s + 1] = copyThisArray[i][j];

					else if (i == 3 && j == 1)
						copyInverse[k - 2][s + 2] = copyThisArray[i][j];

					else if (i == 1 && j == 3)
						copyInverse[k + 2][s - 2] = copyThisArray[i][j];

					else if (i == 3 && j == 2)
						copyInverse[k - 1][s + 1] = copyThisArray[i][j];

					else if (i == 2 && j == 3)
						copyInverse[k + 1][s - 1] = copyThisArray[i][j];

					else
						copyInverse[k][s] = copyThisArray[i][j];
					s++;
				}
				s = 0;
				k++;
			}
		}
		inverse.setArray(copyInverse);
	
		return inverse;
	}

	public boolean equals(Object object) {
		return super.equals(object);
	}

	public String toString() {
		return super.toString();
	}

}
