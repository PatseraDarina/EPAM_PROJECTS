package ua.nure.patsera.Practice4.part2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static ua.nure.patsera.Practice4.ReadWriteFile.readFile;
import static ua.nure.patsera.Practice4.ReadWriteFile.writeFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Part2Test {
	Part2 sut = new Part2();

	private final ByteArrayOutputStream out = new ByteArrayOutputStream();

	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(out));
	}

	@After
	public void cleanUpStream() {
		System.setOut(null);
	}

	@Test
	public void out() {
		System.out.print("hello");
		Assert.assertEquals("hello", out.toString());
	}
	@Test
	public void arrayShouldBeSorted() {
		//Given
		int[] arr = sut.arraySorting(sut.arrayRandomGenerating(0, 50, Part2.ARRAY_SIZE));

		//When
		int i;
		for (i = 0; i < arr.length - 1; i++) {
			if (arr[i] <= arr[i + 1]) {
				break;
			} else if (arr[i] >= arr[i + 1]) {
				break;
			}
		//Then
		assertEquals("Array doesn't sorted! ", arr.length - 1, i);
		}
	}

	@Test
	public void fileShouldBeFillingBySortedArray() throws IOException {
		sut.fillingFilesRandomAndSortindNumbers("part2.txt", "part2_sorted.txt");
	}

	@Test
	public void throwIOExceptionWhileReadFile() throws IOException {
		readFile("part2.txt");
	}

	@Test
	public void shouldBeOtputFinalResult()throws IOException  {
		sut.printResult();
	}

	@Test
	public void throwIOExceptionWhileWriteFile() throws IOException {
		writeFile("part2_sorted.txt", readFile("part2.txt"));
	}

	@Test
	public void arrayShouldBeGeneratedWithNumbersAtSpecifiedDiapason() {
		//Given
		int from = 0;
		int to = 50;
		int size = 10;
		int[] arr = sut.arrayRandomGenerating(from, to, size);

		//When
		boolean isWrongNumber = false;
		for (int i = 0; i < arr.length; i++) {
			if ((arr[i] > to) && (arr[i] < from)) {
				isWrongNumber = true;
				break;
			}
		}

		//Then
		assertFalse("Array consists a number which doesn't include in diapason!", isWrongNumber);
	}
}
