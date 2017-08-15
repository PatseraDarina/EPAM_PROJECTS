package ua.nure.patsera.Practice4.part1;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ua.nure.patsera.Practice4.ReadWriteFile;

public class Part1Test {
	Part1 sut = new Part1();

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
	public void objectShouldBeCreated() throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Constructor<ReadWriteFile> ctor = ReadWriteFile.class.getDeclaredConstructor(new Class[0]);
		ctor.setAccessible(true);
		Assert.assertTrue(Modifier.isPrivate(ctor.getModifiers()));
		Object instance = ctor.newInstance(null);
	}

	@Test
	public void out() {
		System.out.print("hello");
		Assert.assertEquals("hello", out.toString());
	}

	@Test
    public void wordMoreThanThreeLettersShouldBeUppercase() throws IOException {
		//Given
		String path = "part1.txt";
		String sourceText = sut.exchangeLowerToUpper(path);
		//When
		boolean isUppercase;
		String regex = "(\b[a-z]{4,}|\b[à-ÿ]{4,}|[À-ß|A-Z](?=[à-ÿ|a-z]{3,}))";
		Pattern pattern = Pattern.compile(regex);
		Matcher match = pattern.matcher(sourceText);
		if (match.find()) {
			isUppercase = false;
		} else {
			isUppercase = true;
		}
		//Then
			assertTrue("Was found words where more than three letters in lowercase", isUppercase);
		}
}
