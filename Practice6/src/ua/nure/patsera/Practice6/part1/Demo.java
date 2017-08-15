package ua.nure.patsera.Practice6.part1;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class Demo {
	private static final String ENCODING = "Cp1251";

	public static void main(String[] args) throws IOException {
		System.setIn(new ByteArrayInputStream("asd asd asd 43 asdf asdf 43 asdsf 43 43 434".getBytes(ENCODING)));
		Part1.main(args);

		/*Tree<Integer> tree = new Tree<>();
		System.out.println(tree.add(3));
		System.out.println(tree.add(3));

		//tree.add(new Integer[] {1, 2, 5, 4, 6, 0});

		System.out.println("________________");
		System.out.println(tree.remove(5));
		System.out.println(tree.remove(5));*/

	}
}
