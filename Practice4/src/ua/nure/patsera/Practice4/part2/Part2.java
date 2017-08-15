package ua.nure.patsera.Practice4.part2;

import static ua.nure.patsera.Practice4.ReadWriteFile.readFile;
import static ua.nure.patsera.Practice4.ReadWriteFile.writeFile;

import java.io.IOException;

/**
 * @author Daryna Patsera
 *
 */
public class Part2 {

	/**
	 * Size of array.
	 */
	static final int ARRAY_SIZE = 10;

	/**
	 * Array that stores numbers for
	 * their sorting.
	 */
	static int[] array = new int[ARRAY_SIZE];

	/**
	 * Class constructor.
	 */
	Part2() {

	}

	 /**
	 * @param filePathRndNumbers
	 * 		  Path to the file that stores random numbers.
	 *
	 * @param filePathSortNumbers
	 * 		  Path to the file that stores sorted random numbers.
	 *
	 * @return array
	 * 		   Array of sorted numbers.
	 *
	 * @throws IOException
	 */
	void fillingFilesRandomAndSortindNumbers(final String filePathRndNumbers, final String filePathSortNumbers) throws IOException {
			int boundaryNumber = 50;
			String pathRnd = filePathRndNumbers;
		 	String pathSort = filePathSortNumbers;
		 	StringBuilder text = new StringBuilder();
			array = arrayRandomGenerating(0, boundaryNumber, ARRAY_SIZE);
			for (int i = 0; i < ARRAY_SIZE; i++){
				text.append(array[i] + " ");
			}
			writeFile(pathRnd, text.toString());
			text.delete(0, text.length());
			array = arraySorting(array);
			for (int i = 0; i < ARRAY_SIZE; i++){
				text.append(array[i] + " ");
			}
			writeFile(pathSort, text.toString());
	}

	/**
	 * @param from
	 *		  Start number for generation.
	 *
	 * @param to
	 * 		  End number for generation.
	 *
	 * @param size
	 * 		  Number of arrays elements.
	 *
	 * @return array
	 * 		   Array that contains randomize numbers.
	 */
	int[] arrayRandomGenerating(final int from, final int to, final int size) {
		int[] array = new int[size];
		 for (int i = 0; i < size; i++) {
			 array[i] = (int)(Math.random() * to) + from;
		 }
		 return array;
	 }

	/**
	 * @param array
	 * 		  Array that will be sorted.
	 *
	 * @return array sorted array
	 */
	int[] arraySorting(final int[] array) {
		int temp;
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - i - 1; j++) {
				if (array[j] > array[j + 1]) {
					temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
		return array;
	}

	 void printResult() throws IOException {
		fillingFilesRandomAndSortindNumbers("part2.txt", "part2_sorted.txt");
	 	StringBuilder result = new StringBuilder();
	 	result.append("input ==> ").append(readFile("part2.txt")).append('\n');
	 	result.append("output ==> ").append(readFile("part2_sorted.txt"));
	 	System.out.println(result.toString());
	}

	public static void main(final String[] args) throws IOException  {
		new Part2().printResult();
	}
}
