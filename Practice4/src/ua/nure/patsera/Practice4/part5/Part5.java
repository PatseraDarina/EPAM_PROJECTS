package ua.nure.patsera.Practice4.part5;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class Part5 {

	/**
	 * Common name of properties file.
	 */
	private static final String BASE_NAME = "resources";

	/**
	 * Encoding for file contents.
	 */
	private static final String ENCODING = "Cp1251";

	/**
	 * Class constructor
	 */
	private Part5() {

	}

	/**
	 * Read and load properties file contents.
	 *
	 * @param path
	 * 		  Path to the properties file
	 *
	 * @param key
	 * 		  String by which will be extracts values.
	 *
	 * @return
	 * 		  Values that corresponds {@code key}.
	 *
	 * @throws IOException
	 */
	public static String readProperties(final String path, final String key) throws IOException {
		FileInputStream ins = new FileInputStream(path);
		Properties prop = new Properties();

		prop.load(ins);
		return prop.getProperty(key);
	}

	/**
	 * @return all values that correspond the {@code key}.
	 *
	 * @throws IOException
	 */
	public static String getValueByKey() throws IOException {
		Scanner in = new Scanner(System.in, ENCODING);
		String[] inputString = {};
		StringBuilder result = new StringBuilder();
		while(in.hasNext()) {
			inputString = in.nextLine().split("\\s");
			if (inputString[0].equals("stop")) {
				break;
			} else {
				result.append(readProperties(BASE_NAME + "_" + inputString[1] + ".properties", inputString[0])).append(System.lineSeparator());
			}
		}
		in.close();
		return result.toString();
	}


	public static void main(final String[] args) throws IOException {
		System.out.println(getValueByKey());
	}
}
