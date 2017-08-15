package ua.nure.patsera.Practice4.part3;

import static ua.nure.patsera.Practice4.ReadWriteFile.readFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part3 {

	/**
	 * Array of the patterns of the type char, int, String, double regex.
	 */
	static final List<String> TYPE_REGEX = new ArrayList<>();

	/**
	 * Path to the processed file.
	 */
	static final String PATH = "part3.txt";

	static {
		TYPE_REGEX.add("\\d+");
		TYPE_REGEX.add("\\d*\\.\\d+");
		TYPE_REGEX.add("[A-Za-z]{1}");
		TYPE_REGEX.add("[A-Za-z]{2,}");
		TYPE_REGEX.add("[À-ß¨à-ÿ¸]{2,}");
		TYPE_REGEX.add("[À-ß¨à-ÿ¸]{1}");
	}

	/**
	 * Class constructor.
	 */
	Part3() {

	}


	/**
	 * Gets pattern of input string and prints in
	 * values from file that matches special pattern.
	 *
	 * @return strings that have the
	 * 		   same pattern with input string.
	 *
	 * @throws IOException
	 */
	public static StringBuilder inputProcessing() throws IOException {
		StringBuilder result = new StringBuilder();
		Pattern p;
		Matcher m;
		String inputText = "";
		Scanner in = new Scanner(System.in, "Cp1251");
		while (in.hasNext()) {
				inputText = in.nextLine();
				if (inputText.equals("stop")) {
					break;
				} else {
					for (String s : TYPE_REGEX) {
						p = Pattern.compile(s);
						m = p.matcher(inputText);
						if (m.matches()) {
							result.append(mathcesPattern(p)).append(System.lineSeparator());
							break;
						}
					}
				}
			}
		in.close();
		return result;
}

	/**
	 * Gets strings from file that match
	 * source pattern.
	 *
	 * @param regex
	 * 		  Pattern according to which gets string.
	 * @return strings that match the current pattern.
	 *
	 * @throws IOException
	 */
	public static String mathcesPattern(final Pattern regex) throws IOException {
		StringBuilder result = new StringBuilder();
		String[] input = readFile(PATH).split("\\s");
		Pattern p = regex;
		for (String s : input) {
			Matcher m = p.matcher(s);
			if (m.matches()) {
				result.append(s).append(" ");
			}
		}
		return result.toString();
	}

	public static void main(final String[] args) throws IOException {
		System.out.println(inputProcessing());
	}

}
