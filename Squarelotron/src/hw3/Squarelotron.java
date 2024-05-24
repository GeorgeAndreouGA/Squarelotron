package hw3;


/**

The abstract class Squarelotron represents a Squarelotron game. This
class provides basic functionalities for managing and controlling a
Squarelotron array.
*/
public abstract class Squarelotron implements SquarelotronMethods {
	private int[][] squarelotron;

	/**
	 * Creates a new Squarelotron based on the provided integer array. This
	 * array is transformed into a square array.
	 *
	 * @param array The integer array for creating the Squarelotron.
	 */
	public Squarelotron(int[] array) {
		int plith = 0, k = 0, j = 0, n = (int) Math.sqrt(array.length);
		int[][] newSquarelotron = new int[n][n];

		for (int i = 0; i < array.length; i++) {
			newSquarelotron[k][j] = array[i];
			j++;
			plith++;

			if (plith == n) {
				k++;
				j = 0;
				plith = 0;
			}
		}

		squarelotron = new int[n][n];
		for (int i = 0; i < squarelotron.length; i++)
			for (int p = 0; p < squarelotron[i].length; p++)
				squarelotron[i][p] = newSquarelotron[i][p];

	}

	/**
	 * Creates a new Squarelotron based on the provided integer array, either as a large or small Squarelotron.
	 *
	 * @param array The integer array for creating the Squarelotron.
	 * @return A new Squarelotron according to the size of the given array.
	 * @throws IllegalArgumentException If the length of the array is invalid or if the numbers are not within the range [0, 99].
	 */
	public static Squarelotron makeSquarelotron(int[] array) {
		if ((array.length != 25) && (array.length != 16)) {
			throw new IllegalArgumentException("Wrong length");
		}
		for (int i = 0; i < array.length; i++)
			if ((array[i] < 0) || (array[i] > 99)) {
				throw new IllegalArgumentException("Give nums>=0 and nums<=99");
			}
		if (array.length == 16)
			return new SmallSquarelotron(array);
		return new LargeSquarelotron(array);
	}

	/**
	 * Returns a copy of the squarelotron array.
	 *
	 * @return A new array that is a copy of the squarelotron.
	 */
	public int[][] getArray() {
		int[][] copy = new int[this.squarelotron.length][this.squarelotron[0].length];

		for (int i = 0; i < this.squarelotron.length; i++)
			for (int j = 0; j < this.squarelotron[0].length; j++)
				copy[i][j] = this.squarelotron[i][j];
		return copy;
	}

	/**
	 * Sets the squarelotron array based on the given array.
	 *
	 * @param array The array to be copied to set the squarelotron.
	 */
	public void setArray(int[][] array) {
		for (int i = 0; i < squarelotron.length; i++)
			for (int p = 0; p < squarelotron[i].length; p++)
				squarelotron[i][p] = array[i][p];
	}

	/**
	 * Returns an array containing all the numbers of the squarelotron in order.
	 *
	 * @return An array containing all the numbers of the squarelotron in order.
	 */
	public int[] numbers() {
		int[] pin = new int[squarelotron.length * squarelotron.length];
		int k = 0;
		for (int i = 0; i < squarelotron.length; i++)
			for (int p = 0; p < squarelotron[i].length; p++) {
				pin[k] = squarelotron[i][p];
				k++;
			}
		return pin;
	}

	public abstract Squarelotron upsideDownFlip(String ring);

	public abstract Squarelotron leftRightFlip(String ring);

	public abstract Squarelotron inverseDiagonalFlip(String ring);

	public abstract Squarelotron mainDiagonalFlip(String ring);

	/**
	 * Performs a flip (reversal) of the Squarelotron along the side specified by the parameter side.
	 *
	 * @param side The side to flip (left, right, top, bottom).
	 * @return A new Squarelotron that has been flipped.
	 * @throws IllegalArgumentException If the side parameter is not one of the four allowed values.
	 */
	public Squarelotron sideFlip(String side) {

		if ((!side.equals("left")) && (!side.equals("right") && (!side.equals("top") && (!side.equals("bottom")))))
			throw new IllegalArgumentException("Give correct side");

		int[][] copyFlip = this.getArray();
		int k = 0, s = 0;

		if (side.equals("left"))
			for (int i = 0; i < this.squarelotron[0].length; i++) {
				copyFlip[k][0] = this.squarelotron[i][1];
				copyFlip[k][1] = this.squarelotron[i][0];
				k++;
			}
		else if (side.equals("right"))
			for (int i = 0; i < this.squarelotron[0].length; i++) {
				copyFlip[k][copyFlip.length - 1] = this.squarelotron[i][this.squarelotron.length - 2];
				copyFlip[k][copyFlip.length - 2] = this.squarelotron[i][this.squarelotron.length - 1];
				k++;
			}

		else if (side.equals("top"))
			for (int j = 0; j < this.squarelotron.length; j++) {
				copyFlip[0][s] = this.squarelotron[1][j];
				copyFlip[1][s] = this.squarelotron[0][j];
				s++;
			}
		else if (side.equals("bottom"))
			for (int j = 0; j < this.squarelotron.length; j++) {
				copyFlip[copyFlip.length - 1][s] = this.squarelotron[this.squarelotron.length - 2][j];
				copyFlip[copyFlip.length - 2][s] = this.squarelotron[this.squarelotron.length - 1][j];
				s++;
			}

		Squarelotron nw = makeSquarelotron(from2dto1d(copyFlip));

		return nw;

	}

	/**
	 * Converts a two-dimensional array to a one-dimensional array.
	 *
	 * @param array The two-dimensional array to be converted.
	 * @return A one-dimensional array derived from the two-dimensional array.
	 */
	private static int[] from2dto1d(int[][] array) {
		int[] array1d = new int[(int) Math.pow(array.length, 2)];
		int k = 0;
		for (int i = 0; i < array.length; i++)
			for (int j = 0; j < array[i].length; j++) {
				array1d[k] = array[i][j];
				k++;
			}
		return array1d;
	}

	/**
	 * Rotates the Squarelotron clockwise by the number of turns specified by the numberOfTurns parameter.
	 *
	 * @param numberOfTurns The number of rotations to perform. Positive number for clockwise rotation, negative number for counterclockwise rotation.
	 */
	public void rotateRight(int numberOfTurns) {
		int[][] copyThisArray2 = this.getArray();

		if (numberOfTurns < 0)

			for (int o = 0; o < Math.abs(numberOfTurns); o++) {

				for (int i = 0; i < this.squarelotron.length; i++)
					for (int j = 0; j < this.squarelotron[i].length; j++)
						copyThisArray2[this.squarelotron.length - 1 - j][i] = this.squarelotron[i][j];

				this.setArray(copyThisArray2);
			}
		else if (numberOfTurns > 0)
			for (int o = 0; o < numberOfTurns; o++) {

				for (int i = 0; i < this.squarelotron.length; i++)
					for (int j = 0; j < this.squarelotron[i].length; j++)
						copyThisArray2[j][this.squarelotron.length - 1 - i] = this.squarelotron[i][j];

				this.setArray(copyThisArray2);

			}
	}

	/**
	 * Checks if the Squarelotron is equal to another object.
	 *
	 * @param object The object to compare with the Squarelotron.
	 * @return true if the Squarelotron is equal to the other object, otherwise false.
	 */
	public boolean equals(Object object) {
		if (object == null)
			return false;
		if (this.getClass() != object.getClass())
			return false;

		Squarelotron other = (Squarelotron) object;

		if (this.squarelotron.length != other.squarelotron.length)
			return false;

		for (int i = 0; i < 5; i++) {
			boolean arraysSame = true;

			if (i == 0)
				other.rotateRight(0);
			else
				other.rotateRight(1);

			for (int k = 0; k < this.squarelotron.length; k++) {
				for (int j = 0; j < this.squarelotron[k].length; j++)
					if (this.squarelotron[k][j] != other.squarelotron[k][j]) {
						arraysSame = false;
						break;
					}
				if (arraysSame == false)
					break;
			}
			if (arraysSame)
				return true;

		}
		return false;
	}

	/**
	 * Returns a string representation of the Squarelotron.
	 *
	 * @return A string representing the Squarelotron.
	 */
	public String toString() {
		String word = "";

		word += "*******************************\n";

		for (int i = 0; i < squarelotron.length; i++) {
			for (int p = 0; p < squarelotron.length; p++) {
				word += "+-----";
				if (p == squarelotron.length - 1)
					word += "+";
			}
			word += "\n";

			for (int j = 0; j < squarelotron[i].length; j++) {
				if (squarelotron[i][j] >= 0 && squarelotron[i][j] <= 9)
					word += "!  " + squarelotron[i][j] + "  ";
				else if (squarelotron[i][j] >= 10 && squarelotron[i][j] <= 99)
					word += "! " + squarelotron[i][j] + "  ";

				if (j == squarelotron.length - 1)
					word += "!\n";
			}
		}

		for (int p = 0; p < squarelotron.length; p++) {
			word += "+-----";
			if (p == squarelotron.length - 1)
				word += "+\n";
		}
		return word;
	}

}
