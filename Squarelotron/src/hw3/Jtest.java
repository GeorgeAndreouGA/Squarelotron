package hw3;

import static org.junit.Assert.*;

import org.junit.Test;

public class Jtest {

	@Test
	public void testMakeSquarelotronWithSmallArra() {


		int[] smallArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };
		Squarelotron squarelotron = Squarelotron.makeSquarelotron(smallArray);
		assertTrue(squarelotron instanceof SmallSquarelotron);

	}

	@Test
	public void testMakeSquarelotronWithLargeArray() {
		int[] largeArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24,
				25 };
		Squarelotron squarelotron = Squarelotron.makeSquarelotron(largeArray);
		assertTrue(squarelotron instanceof LargeSquarelotron);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testMakeSquarelotronWithInvalidLength() {
		int[] invalidArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Squarelotron.makeSquarelotron(invalidArray);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testMakeSquarelotronWithInvalidNumbers() {
		int[] invalidArray = { 101, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };
		Squarelotron.makeSquarelotron(invalidArray);
	}

	@Test
	public void testGetArray() {
		int[] originalArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 33, 41, 12, 35,
				65 };
		Squarelotron squarelotron = Squarelotron.makeSquarelotron(originalArray);

		int[][] copyArray = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 },
				{ 33, 41, 12, 35, 65 } };
		assertArrayEquals(copyArray, squarelotron.getArray());
	}

	@Test
	public void testGetArray1() {
		int[] originalArray = { 11, 2, 3, 4, 32, 6, 7, 34, 9, 43, 22, 14, 56, 55, 43, 33 };
		Squarelotron squarelotron = Squarelotron.makeSquarelotron(originalArray);

		int[][] copyArray = { { 11, 2, 3, 4 }, { 32, 6, 7, 34 }, { 9, 43, 22, 14 }, { 56, 55, 43, 33 } };
		assertArrayEquals(copyArray, squarelotron.getArray());
	}

	@Test
	public void testSetArray_Length16() {
		int[] originalArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };
		Squarelotron squarelotron = Squarelotron.makeSquarelotron(originalArray);

		int[][] newArray = { { 16, 15, 14, 13 }, { 12, 11, 10, 9 }, { 8, 7, 6, 5 }, { 4, 3, 2, 1 } };

		squarelotron.setArray(newArray);

		assertArrayEquals(newArray, squarelotron.getArray());
	}

	@Test
	public void testSetArray_Length25() {
		int[] originalArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24,
				25 };
		Squarelotron squarelotron = Squarelotron.makeSquarelotron(originalArray);

		int[][] newArray = { { 25, 24, 23, 22, 21 }, { 20, 19, 18, 17, 16 }, { 15, 14, 13, 12, 11 }, { 10, 9, 8, 7, 6 },
				{ 5, 4, 3, 2, 1 } };

		squarelotron.setArray(newArray);

		assertArrayEquals(newArray, squarelotron.getArray());
	}

	@Test
	public void testNumbers() {
		int[] originalArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };
		Squarelotron squarelotron = Squarelotron.makeSquarelotron(originalArray);

		int[] expectedNumbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };
		assertArrayEquals(expectedNumbers, squarelotron.numbers());

		int[] originalArray1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };
		Squarelotron squarelotron1 = Squarelotron.makeSquarelotron(originalArray1);
		int[] expectedNumbers1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };
		assertArrayEquals(expectedNumbers1, squarelotron1.numbers());

		int[] originalArray2 = { 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		Squarelotron squarelotron2 = Squarelotron.makeSquarelotron(originalArray2);
		int[] expectedNumbers2 = { 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		assertArrayEquals(expectedNumbers2, squarelotron2.numbers());

		int[] originalArray3 = { 5, 8, 12, 4, 9, 7, 11, 1, 3, 6, 15, 14, 10, 2, 13, 16 };
		Squarelotron squarelotron3 = Squarelotron.makeSquarelotron(originalArray3);
		int[] expectedNumbers3 = { 5, 8, 12, 4, 9, 7, 11, 1, 3, 6, 15, 14, 10, 2, 13, 16 };
		assertArrayEquals(expectedNumbers3, squarelotron3.numbers());
	}

	@Test
	public void testUpsideDownFlip_OuterRing_4x4() {
		int[] originalArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };
		Squarelotron squarelotron = Squarelotron.makeSquarelotron(originalArray);
		Squarelotron flippedSquarelotron = squarelotron.upsideDownFlip("outer");

		int[][] expectedArray = { { 13, 14, 15, 16 }, { 9, 6, 7, 12 }, { 5, 10, 11, 8 }, { 1, 2, 3, 4 } };

		assertArrayEquals(expectedArray, flippedSquarelotron.getArray());
	}

	@Test
	public void testUpsideDownFlip_InnerRing_4x4() {
		int[] originalArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };
		Squarelotron squarelotron = Squarelotron.makeSquarelotron(originalArray);
		Squarelotron flippedSquarelotron = squarelotron.upsideDownFlip("inner");

		int[][] expectedArray = { { 1, 2, 3, 4 }, { 5, 10, 11, 8 }, { 9, 6, 7, 12 }, { 13, 14, 15, 16 } };

		assertArrayEquals(expectedArray, flippedSquarelotron.getArray());
	}

	@Test
	public void testUpsideDownFlip_OuterRing_5x5() {
		int[] originalArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24,
				25 };
		Squarelotron squarelotron = Squarelotron.makeSquarelotron(originalArray);
		Squarelotron flippedSquarelotron = squarelotron.upsideDownFlip("outer");

		int[][] expectedArray = { { 21, 22, 23, 24, 25 }, { 16, 7, 8, 9, 20 }, { 11, 12, 13, 14, 15 },
				{ 6, 17, 18, 19, 10 }, { 1, 2, 3, 4, 5 } };

		assertArrayEquals(expectedArray, flippedSquarelotron.getArray());
	}

	@Test
	public void testUpsideDownFlip_InnerRing_5x5() {
		int[] originalArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24,
				25 };
		Squarelotron squarelotron = Squarelotron.makeSquarelotron(originalArray);
		Squarelotron flippedSquarelotron = squarelotron.upsideDownFlip("inner");

		int[][] expectedArray = { { 1, 2, 3, 4, 5 }, { 6, 17, 18, 19, 10 }, { 11, 12, 13, 14, 15 }, { 16, 7, 8, 9, 20 },
				{ 21, 22, 23, 24, 25 } };

		assertArrayEquals(expectedArray, flippedSquarelotron.getArray());
	}

	@Test
	public void testLeftRightFlip_OuterRing_4x4() {
		int[] originalArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };
		Squarelotron squarelotron = Squarelotron.makeSquarelotron(originalArray);
		Squarelotron flippedSquarelotron = squarelotron.leftRightFlip("outer");

		int[][] expectedArray = { { 4, 3, 2, 1 }, { 8, 6, 7, 5 }, { 12, 10, 11, 9 }, { 16, 15, 14, 13 } };

		assertArrayEquals(expectedArray, flippedSquarelotron.getArray());
	}

	@Test
	public void testLeftRightFlip_InnerRing_4x4() {
		int[] originalArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };
		Squarelotron squarelotron = Squarelotron.makeSquarelotron(originalArray);
		Squarelotron flippedSquarelotron = squarelotron.leftRightFlip("inner");

		int[][] expectedArray = { { 1, 2, 3, 4 }, { 5, 7, 6, 8 }, { 9, 11, 10, 12 }, { 13, 14, 15, 16 } };

		assertArrayEquals(expectedArray, flippedSquarelotron.getArray());
	}

	@Test
	public void testLeftRightFlip_OuterRing_5x5() {
		int[] originalArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24,
				25 };
		Squarelotron squarelotron = Squarelotron.makeSquarelotron(originalArray);
		Squarelotron flippedSquarelotron = squarelotron.leftRightFlip("outer");

		int[][] expectedArray = { { 5, 4, 3, 2, 1 }, { 10, 7, 8, 9, 6 }, { 15, 12, 13, 14, 11 }, { 20, 17, 18, 19, 16 },
				{ 25, 24, 23, 22, 21 } };

		assertArrayEquals(expectedArray, flippedSquarelotron.getArray());
	}

	@Test
	public void testLeftRightFlip_InnerRing_5x5() {
		int[] originalArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24,
				25 };
		Squarelotron squarelotron = Squarelotron.makeSquarelotron(originalArray);
		Squarelotron flippedSquarelotron = squarelotron.leftRightFlip("inner");

		int[][] expectedArray = { { 1, 2, 3, 4, 5 }, { 6, 9, 8, 7, 10 }, { 11, 14, 13, 12, 15 }, { 16, 19, 18, 17, 20 },
				{ 21, 22, 23, 24, 25 } };

		assertArrayEquals(expectedArray, flippedSquarelotron.getArray());
	}

	@Test
	public void testMainInverseDiagonalFlip_4x4() {
		int[] originalArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };
		Squarelotron squarelotron = Squarelotron.makeSquarelotron(originalArray);
		Squarelotron flippedSquarelotron = squarelotron.inverseDiagonalFlip("inner");

		int[][] expectedArray = { { 1, 2, 3, 4 }, { 5, 11, 7, 8 }, { 9, 10, 6, 12 }, { 13, 14, 15, 16 } };

		assertArrayEquals(expectedArray, flippedSquarelotron.getArray());
	}

	@Test
	public void testMainInverseDiagonalFlip_OuterRing_4x4() {
		int[] originalArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };
		Squarelotron squarelotron = Squarelotron.makeSquarelotron(originalArray);
		Squarelotron flippedSquarelotron = squarelotron.inverseDiagonalFlip("outer");

		int[][] expectedArray = { { 16, 12, 8, 4 }, { 15, 6, 7, 3 }, { 14, 10, 11, 2 }, { 13, 9, 5, 1 } };
		squarelotron.inverseDiagonalFlip("outer");
		assertArrayEquals(expectedArray, flippedSquarelotron.getArray());
	}

	@Test
	public void testMainInverseDiagonalFlip_OuterRing_5x5() {
		int[] originalArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24,
				25 };
		Squarelotron squarelotron = Squarelotron.makeSquarelotron(originalArray);
		Squarelotron flippedSquarelotron = squarelotron.inverseDiagonalFlip("outer");

		int[][] expectedArray = { { 25, 20, 15, 10, 5 }, { 24, 7, 8, 9, 4 }, { 23, 12, 13, 14, 3 },
				{ 22, 17, 18, 19, 2 }, { 21, 16, 11, 6, 1 } };

		assertArrayEquals(expectedArray, flippedSquarelotron.getArray());
	}

	@Test
	public void testMainInverseDiagonalFlip_InnerRing_5x5() {
		int[] originalArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24,
				25 };
		Squarelotron squarelotron = Squarelotron.makeSquarelotron(originalArray);
		Squarelotron flippedSquarelotron = squarelotron.inverseDiagonalFlip("inner");

		int[][] expectedArray = { { 1, 2, 3, 4, 5 }, { 6, 19, 14, 9, 10 }, { 11, 18, 13, 8, 15 }, { 16, 17, 12, 7, 20 },
				{ 21, 22, 23, 24, 25 } };

		assertArrayEquals(expectedArray, flippedSquarelotron.getArray());
	}

	@Test
	public void testMainDiagonalFlip_InnerRing_4x4() {
		int[] originalArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };
		Squarelotron squarelotron = Squarelotron.makeSquarelotron(originalArray);
		Squarelotron flippedSquarelotron = squarelotron.mainDiagonalFlip("inner");

		int[][] expectedArray = { { 1, 2, 3, 4 }, { 5, 6, 10, 8 }, { 9, 7, 11, 12 }, { 13, 14, 15, 16 } };

		assertArrayEquals(expectedArray, flippedSquarelotron.getArray());
	}

	@Test
	public void testMainDiagonalFlip_OuterRing_4x4() {
		int[] originalArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };
		Squarelotron squarelotron = Squarelotron.makeSquarelotron(originalArray);
		Squarelotron flippedSquarelotron = squarelotron.mainDiagonalFlip("outer");

		int[][] expectedArray = { { 1, 5, 9, 13 }, { 2, 6, 7, 14 }, { 3, 10, 11, 15 }, { 4, 8, 12, 16 } };
		assertArrayEquals(expectedArray, flippedSquarelotron.getArray());
	}

	@Test
	public void testMainDiagonalFlip_InnerRing_5x5() {
		int[] originalArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24,
				25 };
		Squarelotron squarelotron = Squarelotron.makeSquarelotron(originalArray);
		Squarelotron flippedSquarelotron = squarelotron.mainDiagonalFlip("inner");

		int[][] expectedArray = { { 1, 2, 3, 4, 5 }, { 6, 7, 12, 17, 10 }, { 11, 8, 13, 18, 15 }, { 16, 9, 14, 19, 20 },
				{ 21, 22, 23, 24, 25 } };

		assertArrayEquals(expectedArray, flippedSquarelotron.getArray());
	}

	@Test
	public void testMainDiagonalFlip_OuterRing_5x5() {
		int[] originalArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24,
				25 };
		Squarelotron squarelotron = Squarelotron.makeSquarelotron(originalArray);
		Squarelotron flippedSquarelotron = squarelotron.mainDiagonalFlip("outer");
		int[][] expectedArray = { { 1, 6, 11, 16, 21 }, { 2, 7, 8, 9, 22 }, { 3, 12, 13, 14, 23 },
				{ 4, 17, 18, 19, 24 }, { 5, 10, 15, 20, 25 } };

		assertArrayEquals(expectedArray, flippedSquarelotron.getArray());
	}

	@Test
	public void testSideFlip_Left_4x4() {
		int[] originalArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };
		Squarelotron squarelotron = Squarelotron.makeSquarelotron(originalArray);
		Squarelotron flippedSquarelotron = squarelotron.sideFlip("left");

		int[][] expectedArray = { { 2, 1, 3, 4 }, { 6, 5, 7, 8 }, { 10, 9, 11, 12 }, { 14, 13, 15, 16 } };

		assertArrayEquals(expectedArray, flippedSquarelotron.getArray());
	}

	@Test
	public void testSideFlip_Right_4x4() {
		int[] originalArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };
		Squarelotron squarelotron = Squarelotron.makeSquarelotron(originalArray);
		Squarelotron flippedSquarelotron = squarelotron.sideFlip("right");

		int[][] expectedArray = { { 1, 2, 4, 3 }, { 5, 6, 8, 7 }, { 9, 10, 12, 11 }, { 13, 14, 16, 15 } };

		assertArrayEquals(expectedArray, flippedSquarelotron.getArray());
	}

	@Test
	public void testSideFlip_Top_4x4() {
		int[] originalArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };
		Squarelotron squarelotron = Squarelotron.makeSquarelotron(originalArray);
		Squarelotron flippedSquarelotron = squarelotron.sideFlip("top");

		int[][] expectedArray = { { 5, 6, 7, 8 }, { 1, 2, 3, 4 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

		assertArrayEquals(expectedArray, flippedSquarelotron.getArray());
	}

	@Test
	public void testSideFlip_Bottom_4x4() {
		int[] originalArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };
		Squarelotron squarelotron = Squarelotron.makeSquarelotron(originalArray);
		Squarelotron flippedSquarelotron = squarelotron.sideFlip("bottom");

		int[][] expectedArray = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 13, 14, 15, 16 }, { 9, 10, 11, 12 } };

		assertArrayEquals(expectedArray, flippedSquarelotron.getArray());
	}

	@Test
	public void testBottomFlip_5x5() {
		int[] originalArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24,
				25 };
		Squarelotron squarelotron = Squarelotron.makeSquarelotron(originalArray);
		Squarelotron flippedSquarelotron = squarelotron.sideFlip("bottom");

		int[][] expectedArray = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 }, { 21, 22, 23, 24, 25 },
				{ 16, 17, 18, 19, 20 } };

		assertArrayEquals(expectedArray, flippedSquarelotron.getArray());
	}

	@Test
	public void testTopFlip_5x5() {
		int[] originalArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24,
				25 };
		Squarelotron squarelotron = Squarelotron.makeSquarelotron(originalArray);
		Squarelotron flippedSquarelotron = squarelotron.sideFlip("top");

		int[][] expectedArray = { { 6, 7, 8, 9, 10 }, { 1, 2, 3, 4, 5 }, { 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 },
				{ 21, 22, 23, 24, 25 } };

		assertArrayEquals(expectedArray, flippedSquarelotron.getArray());
	}

	@Test
	public void testRightFlip_5x5() {
		int[] originalArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24,
				25 };
		Squarelotron squarelotron = Squarelotron.makeSquarelotron(originalArray);
		Squarelotron flippedSquarelotron = squarelotron.sideFlip("right");

		int[][] expectedArray = { { 1, 2, 3, 5, 4 }, { 6, 7, 8, 10, 9 }, { 11, 12, 13, 15, 14 }, { 16, 17, 18, 20, 19 },
				{ 21, 22, 23, 25, 24 } };

		assertArrayEquals(expectedArray, flippedSquarelotron.getArray());
	}

	@Test
	public void testLeftFlip_5x5() {
		int[] originalArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24,
				25 };
		Squarelotron squarelotron = Squarelotron.makeSquarelotron(originalArray);
		Squarelotron flippedSquarelotron = squarelotron.sideFlip("left");

		int[][] expectedArray = { { 2, 1, 3, 4, 5 }, { 7, 6, 8, 9, 10 }, { 12, 11, 13, 14, 15 }, { 17, 16, 18, 19, 20 },
				{ 22, 21, 23, 24, 25 } };

		assertArrayEquals(expectedArray, flippedSquarelotron.getArray());
	}

	@Test
	public void testRotateRight_4x4() {

		int[] originalArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };
		Squarelotron squarelotron = Squarelotron.makeSquarelotron(originalArray);

		squarelotron.rotateRight(1231);

		int[][] expectedArray = { { 4, 8, 12, 16 }, { 3, 7, 11, 15 }, { 2, 6, 10, 14 }, { 1, 5, 9, 13 } };

		assertArrayEquals(expectedArray, squarelotron.getArray());
	}

	@Test
	public void testRotateRight_4x4for2() {
		int[] originalArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };
		Squarelotron squarelotron = Squarelotron.makeSquarelotron(originalArray);

		squarelotron.rotateRight(2);

		int[][] expectedArray = { { 16, 15, 14, 13 }, { 12, 11, 10, 9 }, { 8, 7, 6, 5 }, { 4, 3, 2, 1 } };
		assertArrayEquals(expectedArray, squarelotron.getArray());
	}

	public void testRotateRight_4x4for65() {
		int[] originalArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };
		Squarelotron squarelotron = Squarelotron.makeSquarelotron(originalArray);

		squarelotron.rotateRight(-65);
		int[][] expectedArray = { { 4, 8, 12, 16 }, { 3, 7, 11, 15 }, { 2, 6, 10, 14 }, { 1, 5, 9, 13 } };

		assertArrayEquals(expectedArray, squarelotron.getArray());
	}

	@Test
	public void testRotateLeft_5x5() {

		int[] originalArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24,
				25 };
		Squarelotron squarelotron = Squarelotron.makeSquarelotron(originalArray);

		squarelotron.rotateRight(0);

		int[][] expectedArray = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 },
				{ 21, 22, 23, 24, 25 } };

		assertArrayEquals(expectedArray, squarelotron.getArray());
	}

	public void testRotateLeft_5x5for54() {

		int[] originalArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24,
				25 };
		Squarelotron squarelotron = Squarelotron.makeSquarelotron(originalArray);

		squarelotron.rotateRight(54);

		int[][] expectedArray = { { 25, 24, 23, 22, 21 }, { 20, 19, 18, 17, 16 }, { 15, 14, 13, 12, 11 },
				{ 10, 9, 8, 7, 6 }, { 5, 4, 3, 2, 1 } };

		assertArrayEquals(expectedArray, squarelotron.getArray());
	}

	@Test
	public void testRotateRight_5x5_Negative9Times() {

		int[] originalArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24,
				25 };
		Squarelotron squarelotron = Squarelotron.makeSquarelotron(originalArray);

		squarelotron.rotateRight(-9);

		int[][] expectedArray = { { 5, 10, 15, 20, 25 }, { 4, 9, 14, 19, 24 }, { 3, 8, 13, 18, 23 },
				{ 2, 7, 12, 17, 22 }, { 1, 6, 11, 16, 21 } };

		assertArrayEquals(expectedArray, squarelotron.getArray());
	}

	@Test
	public void testEquals_SameSquarelotron() {
		int[] array1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };
		int[] array2 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };

		Squarelotron squarelotron1 = Squarelotron.makeSquarelotron(array1);
		Squarelotron squarelotron2 = Squarelotron.makeSquarelotron(array2);

		assertTrue(squarelotron1.equals(squarelotron2));
	}

	@Test
	public void testEquals_RotatedSquarelotron() {
		int[] array1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };
		int[] array2 = { 13, 9, 5, 1, 14, 10, 6, 2, 15, 11, 7, 3, 16, 12, 8, 4 };

		Squarelotron squarelotron1 = Squarelotron.makeSquarelotron(array1);
		Squarelotron squarelotron2 = Squarelotron.makeSquarelotron(array2);

		assertTrue(squarelotron1.equals(squarelotron2));
	}

	@Test
	public void testEquals_DifferentSquarelotron() {
		int[] array1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };
		int[] array2 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 17 }; // Different last element

		Squarelotron squarelotron1 = Squarelotron.makeSquarelotron(array1);
		Squarelotron squarelotron2 = Squarelotron.makeSquarelotron(array2);

		assertFalse(squarelotron1.equals(squarelotron2));
	}

	@Test
	public void testEquals_RotatedSquarelotron1() {
		int[] array1 = { 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26 };
		int[] array2 = { 23, 18, 13, 8, 3, 24, 19, 14, 9, 4, 25, 20, 15, 10, 5, 26 };

		Squarelotron squarelotron1 = Squarelotron.makeSquarelotron(array1);
		Squarelotron squarelotron2 = Squarelotron.makeSquarelotron(array2);

		assertFalse(squarelotron1.equals(squarelotron2));
	}

	@Test
	public void testEquals_NullObject1() {
		int[] array1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };

		Squarelotron squarelotron1 = Squarelotron.makeSquarelotron(array1);

		assertFalse(squarelotron1.equals(null));
	}

	@Test
	public void testEquals_DifferentTypeObject1() {
		int[] array1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };
		String otherObject = "not a Squarelotron";

		Squarelotron squarelotron1 = Squarelotron.makeSquarelotron(array1);

		assertFalse(squarelotron1.equals(otherObject));
	}

	@Test
	public void testEquals_SameSquarelotron1() {
		int[] array1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25 };
		Squarelotron squarelotron1 = Squarelotron.makeSquarelotron(array1);
		Squarelotron squarelotron2 = Squarelotron.makeSquarelotron(array1);
		assertTrue(squarelotron1.equals(squarelotron2));
	}

	@Test
	public void testEquals_RotatedSquarelotron2() {
		int[] array1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25 };
		int[] array2 = { 21, 16, 11, 6, 1, 22, 17, 12, 7, 2, 23, 18, 13, 8, 3, 24, 19, 14, 9, 4, 25, 20, 15, 10, 5 };
		Squarelotron squarelotron1 = Squarelotron.makeSquarelotron(array1);
		Squarelotron squarelotron2 = Squarelotron.makeSquarelotron(array2);
		assertTrue(squarelotron1.equals(squarelotron2));
	}

	@Test
	public void testEquals_DifferentSquarelotron1() {
		int[] array1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25 };
		int[] array2 = { 25, 24, 23, 22, 21, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		Squarelotron squarelotron1 = Squarelotron.makeSquarelotron(array1);
		Squarelotron squarelotron2 = Squarelotron.makeSquarelotron(array2);
		assertTrue(squarelotron1.equals(squarelotron2));
	}

	@Test
	public void testEquals_NullObject() {
		int[] array1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25 };
		Squarelotron squarelotron1 = Squarelotron.makeSquarelotron(array1);
		assertFalse(squarelotron1.equals(null));
	}

	@Test
	public void testEquals_DifferentTypeObject() {
		int[] array1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25 };
		Squarelotron squarelotron1 = Squarelotron.makeSquarelotron(array1);
		assertFalse(squarelotron1.equals("not a Squarelotron"));
	}

	@Test
	public void testToString_4x4() {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };

		Squarelotron squarelotron = Squarelotron.makeSquarelotron(array);
		String expected = "*******************************\n" + "+-----+-----+-----+-----+\n"
				+ "!  1  !  2  !  3  !  4  !\n" + "+-----+-----+-----+-----+\n" + "!  5  !  6  !  7  !  8  !\n"
				+ "+-----+-----+-----+-----+\n" + "!  9  ! 10  ! 11  ! 12  !\n" + "+-----+-----+-----+-----+\n"
				+ "! 13  ! 14  ! 15  ! 16  !\n" + "+-----+-----+-----+-----+\n";
		assertEquals(expected, squarelotron.toString());
	}

	@Test
	public void testToString_5x5() {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25 };

		Squarelotron squarelotron = Squarelotron.makeSquarelotron(array);
		String expected = "*******************************\n" + "+-----+-----+-----+-----+-----+\n"
				+ "!  1  !  2  !  3  !  4  !  5  !\n" + "+-----+-----+-----+-----+-----+\n"
				+ "!  6  !  7  !  8  !  9  ! 10  !\n" + "+-----+-----+-----+-----+-----+\n"
				+ "! 11  ! 12  ! 13  ! 14  ! 15  !\n" + "+-----+-----+-----+-----+-----+\n"
				+ "! 16  ! 17  ! 18  ! 19  ! 20  !\n" + "+-----+-----+-----+-----+-----+\n"
				+ "! 21  ! 22  ! 23  ! 24  ! 25  !\n" + "+-----+-----+-----+-----+-----+\n";
		assertEquals(expected, squarelotron.toString());
	}
}
