package hw3;

/**
 * Represents a small Squarelotron, which is a square array with dimensions 4x4.
 * It inherits from the Squarelotron class.
 */
public class SmallSquarelotron extends Squarelotron {
	/**
	 * Creates a new SmallSquarelotron based on the provided integer array.
	 *
	 * @param array The integer array used for creating the SmallSquarelotron.
	 */
	public SmallSquarelotron(int[] array) {
		super(array);
	}

	/**
	 * Reverses the SmallSquarelotron by 180 degrees along the inner or outer ring.
	 *
	 * @param ring The ring to be reversed. It can be "inner" or "outer".
	 * @return A new SmallSquarelotron containing the reversed ring.
	 * @throws IllegalArgumentException If an invalid ring is provided.
	 */
	public Squarelotron upsideDownFlip(String ring) {
		if ((!ring.equals("inner")) && (!ring.equals("outer")))
			throw new IllegalArgumentException("Give inner or outer");

		int[][] copyThisArray = this.getArray();
		int[] upsideDownFlipArray1d = new int[copyThisArray.length * copyThisArray.length];
		SmallSquarelotron upsideDownFlipArray = new SmallSquarelotron(upsideDownFlipArray1d);
		int[][] copyUpsideDownFlipArray = upsideDownFlipArray.getArray();
		int k = 0, s = 0;
		if (ring.equals("outer")) {

			for (int i = copyThisArray.length - 1; i >= 0; i--) {
				for (int j = 0; j < copyThisArray[i].length; j++) {
					if (i == 0 || i == 3)
						copyUpsideDownFlipArray[k][s] = copyThisArray[i][j];
					else if ((i == 2) && (j == 1 || j == 2))
						copyUpsideDownFlipArray[k][s] = copyThisArray[i - 1][j];

					else if ((i == 1) && (j == 1 || j == 2))
						copyUpsideDownFlipArray[k][s] = copyThisArray[i + 1][j];
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
					if (i == 0 || i == 3)
						copyUpsideDownFlipArray[k][s] = copyThisArray[i][j];
					else if ((i == 2) && (j == 1 || j == 2))
						copyUpsideDownFlipArray[k][s] = copyThisArray[i - 1][j];

					else if ((i == 1) && (j == 1 || j == 2))
						copyUpsideDownFlipArray[k][s] = copyThisArray[i + 1][j];
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
	 * Reverses the SmallSquarelotron by 180 degrees along the width of the inner or outer ring.
	 *
	 * @param ring The ring to be reversed. It can be "inner" or "outer".
	 * @return A new SmallSquarelotron containing the reversed ring.
	 * @throws IllegalArgumentException If an invalid ring is provided.
	 */
	public Squarelotron leftRightFlip(String ring) {
		if ((!ring.equals("inner")) && (!ring.equals("outer")))
			throw new IllegalArgumentException("Give inner or outer");

		int[][] copyThisArray = this.getArray();
		int[] leftRightFlip1d = new int[copyThisArray.length * copyThisArray.length];
		SmallSquarelotron leftRightFlip = new SmallSquarelotron(leftRightFlip1d);
		int[][] copyLeftRightFlip = leftRightFlip.getArray();
		int k = 0, s = 0;

		if (ring.equals("outer")) {
			for (int i = 0; i < copyThisArray.length; i++) {
				for (int j = copyThisArray[i].length - 1; j >= 0; j--) {
					if (i == 0 || i == 3)
						copyLeftRightFlip[k][s] = copyThisArray[i][j];
					else if ((i == 2) && (j == 2))
						copyLeftRightFlip[k][s + 1] = copyThisArray[i][j];
					else if ((i == 2) && (j == 1))
						copyLeftRightFlip[k][s - 1] = copyThisArray[i][j];
					else if ((i == 1) && (j == 2))
						copyLeftRightFlip[k][s + 1] = copyThisArray[i][j];
					else if ((i == 1) && (j == 1))
						copyLeftRightFlip[k][s - 1] = copyThisArray[i][j];
					else
						copyLeftRightFlip[k][s] = copyThisArray[i][j];
					s++;
				}
				k++;
				s = 0;
			}
		} else if (ring.equals("inner")) {
			for (int i = 0; i < copyThisArray.length; i++) {
				for (int j = 0; j < copyThisArray[i].length; j++) {
					if (i == 0 || i == 3)
						copyLeftRightFlip[k][s] = copyThisArray[i][j];
					else if ((i == 2) && (j == 2))
						copyLeftRightFlip[k][s - 1] = copyThisArray[i][j];
					else if ((i == 2) && (j == 1))
						copyLeftRightFlip[k][s + 1] = copyThisArray[i][j];
					else if ((i == 1) && (j == 2))
						copyLeftRightFlip[k][s - 1] = copyThisArray[i][j];
					else if ((i == 1) && (j == 1))
						copyLeftRightFlip[k][s + 1] = copyThisArray[i][j];
					else
						copyLeftRightFlip[k][s] = copyThisArray[i][j];
					s++;
				}
				k++;
				s = 0;
			}
		}

		leftRightFlip.setArray(copyLeftRightFlip);
		
		return leftRightFlip;
	}

	/**
	 * Reverses the SmallSquarelotron along the opposite diagonal of the inner or outer ring.
	 *
	 * @param ring The ring to be reversed. It can be "inner" or "outer".
	 * @return A new SmallSquarelotron containing the reversed ring.
	 * @throws IllegalArgumentException If an invalid ring is provided.
	 */
	public Squarelotron inverseDiagonalFlip(String ring) {
		if ((!ring.equals("inner")) && (!ring.equals("outer")))
			throw new IllegalArgumentException("Give inner or outer");

		int[][] copyThisArray = this.getArray();
		int[] inverse1d = new int[copyThisArray.length * copyThisArray.length];
		SmallSquarelotron inverse = new SmallSquarelotron(inverse1d);
		int[][] copyInverse = inverse.getArray();
		int k = 0, s = 0;
		if (ring.equals("outer")) {

			for (int i = copyThisArray.length - 1; i >= 0; i--) {
				for (int j = copyThisArray[i].length - 1; j >= 0; j--) {
					if ((i + j >= copyThisArray.length) && ((i == 2) && (i + j == copyThisArray.length)))
						copyInverse[k + 1][s + 1] = copyThisArray[i][j];

					else if (i + j >= copyThisArray.length)
						copyInverse[k][s] = copyThisArray[i][j];

					else if ((i + j < copyThisArray.length - 1) && ((i == 1) && (i + j == copyThisArray.length - 2)))
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
						copyInverse[k + 1][s + 1] = copyThisArray[i][j];
					else if (i == 2 && j == 2)
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
	 * Reverses the SmallSquarelotron along the main diagonal of the inner or outer ring.
	 *
	 * @param ring The ring to be reversed. It can be "inner" or "outer".
	 * @return A new SmallSquarelotron containing the reversed ring.
	 * @throws IllegalArgumentException If an invalid ring is provided.
	 */
	public Squarelotron mainDiagonalFlip(String ring) {
		if ((!ring.equals("inner")) && (!ring.equals("outer")))
			throw new IllegalArgumentException("Give inner or outer");

		int[][] copyThisArray = this.getArray();
		int[] inverse1d = new int[copyThisArray.length * copyThisArray.length];
		SmallSquarelotron inverse = new SmallSquarelotron(inverse1d);
		int[][] copyInverse = inverse.getArray();
		if (ring.equals("outer")) {
			int k = 0, s = copyThisArray[0].length - 1;

			for (int i = copyThisArray.length - 1; i >= 0; i--) {
				for (int j = 0; j < copyThisArray.length; j++) {
					if ((i > j) && ((i == 2) && (i + j == copyThisArray.length - 1)))
						copyInverse[k + 1][s - 1] = copyThisArray[i][j];

					else if (i > j)
						copyInverse[k][s] = copyThisArray[i][j];

					else if ((j > i) && ((i == 1) && (i + j == copyThisArray.length - 1)))
						copyInverse[k - 1][s + 1] = copyThisArray[i][j];

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
