package ua.nure.patsera.Practice4;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadWriteFile {

	/**
	 * Encoding for file contents.
	 */
	private static final String ENCODING = "Cp1251";

	/**
	 * Class constructor.
	 */
	private ReadWriteFile() {

	}

	 /**
	 * @param path
	 * 		  Path to file that will be reading.
	 *
	 * @return Text from read file.
	 *
	 * @throws IOException
	 */
	public static String readFile(final String path) throws IOException {
		String line;
		StringBuilder sb = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(
	            new FileInputStream(new File(path)), ENCODING))
			) {
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
		}
		return sb.toString();
	}

	/**
	 * @param path
	 * 		  Path to the file in which
	 * 		  {@text} will be written.
	 *
	 * @param text
	 * 		  Information that will be written.
	 *
	 * @throws IOException
	 */
	public static void writeFile(final String path, final String text) throws IOException {
			try (BufferedWriter bw = new BufferedWriter(
		            new FileWriter(new File(path)))
				) {
				bw.write(text);
			}
		}
}
