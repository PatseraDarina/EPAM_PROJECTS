package ua.nure.patsera.Practice4.part4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.nio.file.Files;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Part4Test {

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
	public void constructorShouldBeInvoked() throws NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Constructor<Part4> ctor = Part4.class.getDeclaredConstructor(new Class[0]);
		ctor.setAccessible(true);
		Object instance = ctor.newInstance(null);
		Assert.assertTrue(Modifier.isPrivate(ctor.getModifiers()));
	}

	@Test
	public void methodShouldBeWorkedCorrect() {
		Part4.main(null);
	}

	@Test
	public void out() {
		System.out.print("hello");
		Assert.assertEquals("hello", out.toString());
	}

	Parser sutParser = new Parser("part4", "Cp1251");
	String path = "part4.txt";
	Parser.FileIterator sutIterator = new Parser(path, "Cp1251").new FileIterator();
	private static File dir;

	@BeforeClass
	public static void creatingTempFile() throws IOException {
		dir = Files.createTempDirectory(null).toFile();
	}

	@AfterClass
	public static void deletingTempFile() throws IOException {
		if (dir == null) {
			return;
		}
		Files.deleteIfExists(dir.toPath());
	}

	@Test
	public void removedSentenceFromListShouldBeReturned() {
		//Given
		List<String> list = sutIterator.listOfSentences;

		//When
		String removedSent = list.get(0);

		//Then
		assertEquals(removedSent, sutIterator.cutReturnedSentence());
	}

	@Test
	public void readingFile() {
		sutIterator.readFile(path);
	}

	@Test
	public void listShouldContainsOnlySentences() {
		//Given
		List<String> list = sutIterator.listOfSentences;

		//When
		boolean isNotMatch = false;
		Matcher m;
		String pattern = "\\b[A-ZÀ-ß¨][a-zA-ZÀ-ß¨à-ÿ¸\\s\\d,-]*";
		Pattern p = Pattern.compile(pattern);
		for (String s : list) {
			m = p.matcher(s);
			if (!m.matches()) {
				isNotMatch = true;
				break;
			}
		}

		//Then
		assertFalse(isNotMatch);
	}

	@Test
	public void shouldBeReturnsFalseIfListIsEmpty() {
		//Given
		sutIterator.listOfSentences.clear();

		//Then
		assertFalse(sutIterator.hasNext());
	}

	@Test
	public void shouldBeReturnsTrueIfListIsNotEmpty() {
		assertFalse(!sutIterator.hasNext());
	}

	@Test(expected = UnsupportedOperationException.class)
	public void methodShouldThrowException() {
		sutIterator.remove();
	}

	@Test
	public void methodShouldReturnSentences() {

		//When
		String sent = sutIterator.next();

		//Then
		Assert.assertNotEquals(null, sent);
	}

	@Test
	public void methodShouldNotReturnSentences() {
		//When
		sutIterator.listOfSentences.clear();
		String sent = sutIterator.next();

		//Then
		Assert.assertEquals(null, sent);
	}
}
