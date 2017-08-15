package ua.nure.patsera.Practice4.part5;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Part5Test {
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
	public void privateConstructorShouldBeInvoked() throws ReflectiveOperationException {
		Constructor<Part5> ctor = Part5.class.getDeclaredConstructor(new Class[0]);
		ctor.setAccessible(true);
		Object instance = ctor.newInstance(null);
		Assert.assertTrue(Modifier.isPrivate(ctor.getModifiers()));
	}

	@Test
	public void readProperties() throws IOException {
		Part5.readProperties("resources_en.properties", "apple");
	}

	@Test
	public void methodShouldReturnsAppropriateValues() throws IOException {
		//Given
		String array = "table" + System.lineSeparator() + "€блоко" +
		System.lineSeparator() + "стол" + System.lineSeparator();

		//When
		System.setIn(new ByteArrayInputStream("table en\napple ru\ntable ru\nstop\napple en".getBytes("Cp1251")));

		//Then
		Assert.assertEquals(array, Part5.getValueByKey());
	}
}
