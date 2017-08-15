package ua.nure.patsera.Practice5;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class Part2 {

	public static void main(String[] args) throws Exception {
		InputStream in = System.in;
		ByteArrayInputStream bais = new ByteArrayInputStream(System.lineSeparator().getBytes());
		bais.skip(System.lineSeparator().length());
		System.setIn(bais);
		Spam.main(args);
		Thread.sleep(5000);
		System.setIn(bais);
		bais.reset();
		System.setIn(in);
	}
}

