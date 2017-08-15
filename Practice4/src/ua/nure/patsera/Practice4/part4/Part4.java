package ua.nure.patsera.Practice4.part4;

/**
 * @author Daryna Patsera
 *
 */
public class Part4 {

	/**
	 * Path to the processed file.
	 */
	private static final String FILE_NAME = "part4.txt";

	/**
	 * The encoding which  will be used while reading the file.
	 */
	private static final String ENCODING = "Cp1251";

	/**
	 * Class constructor
	 */
	private Part4() {

	}

	public static void main(final String[] args) {
		Parser parser = new Parser(FILE_NAME, ENCODING);
		for (String str : parser) {
			System.out.println(str);
		}
	}
}
