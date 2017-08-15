package ua.nure.patsera.Practice4.part1;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ua.nure.patsera.Practice4.ReadWriteFile;


public class Part1 {

	/**
	 * Class constructor.
	 */
	Part1() {

	}

	 /**
	 * @return sourceText
	 * 		   Text in which words where number of
	 * 		   letter more than four convert to uppercase.
	 *
	 * @param path
	 * 		  Path to the source file.
	 *
	 * @throws IOException
	 */
	public String exchangeLowerToUpper(final String path) throws IOException  {
		String sourceText = ReadWriteFile.readFile(path);
		String regex = "(\\w{4,})|([Р-пр-џ]{4,})";
		Pattern pattern = Pattern.compile(regex);
		Matcher match = pattern.matcher(sourceText);
		while (match.find()) {
			sourceText = sourceText.replaceAll(match.group(), match.group().toUpperCase());
		}
		return sourceText;
	}


	 public static void main(String[] args) throws IOException {
		 System.out.println(new Part1().exchangeLowerToUpper("part1.txt"));
	}
}
