package ua.nure.patsera.Practice4.part3;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Part3Test {

	Part3 sut = new Part3();

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
	public void inputDateShouldMatchPattern() {
		//Given
		String pattern = "\\d+";
		Pattern p = Pattern.compile(pattern);

		//When
		String[] result = {};
		boolean isMatch = true;
		int digit = 10;
		try {
			result = Part3.mathcesPattern(p).split("\\s");
		} catch (IOException e) {
			e.printStackTrace();
		}

		//When
		for (String s : result) {
			if (!p.matcher(s).matches()) {
				isMatch = false;
				break;
			}
		}

		//Then
		Assert.assertTrue(isMatch);
	}

	@Test
	public void allOfWordShouldMatchPattern() throws UnsupportedEncodingException {
		//Given
		List<String> TYPE_REGEX = new ArrayList<>();

		TYPE_REGEX.add("\\d+");
		TYPE_REGEX.add("\\d*\\.\\d+");
		TYPE_REGEX.add("[A-Za-z]{1}");
		TYPE_REGEX.add("[A-Za-z]{2,}");
		TYPE_REGEX.add("[À-ß¨à-ÿ¸]{2,}");
		TYPE_REGEX.add("[À-ß¨à-ÿ¸]{1}");

		//When
		System.setIn(new ByteArrayInputStream("d\ndfd\n3\n3.45\nî\nëä".getBytes("Cp1251")));
		Pattern p;

		boolean isMatch = true;
		String result = "";
		try {
			result = Part3.inputProcessing().toString();
		} catch (IOException e) {
		}
			for (int i = 0; i < TYPE_REGEX.size(); i++) {
				p = Pattern.compile(TYPE_REGEX.get(i));
				if (!p.matcher(result).find()) {
					isMatch = false;
					break;
				}
			}

		//Then
		Assert.assertTrue(isMatch);
	}
}
