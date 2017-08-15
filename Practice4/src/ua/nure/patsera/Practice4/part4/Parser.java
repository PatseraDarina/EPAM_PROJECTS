package ua.nure.patsera.Practice4.part4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser implements Iterable<String> {

	/**
	 * Path to the processed file.
	 */
	private final String FILE_NAME;

	/**
	 * The encoding which  will be used while reading the file.
	 */
	private final String ENCODING;

	/**
	 * Initialization constructor.
	 *
	 * @param fileName
	 * 		  Path that passed into constructor for {@code FILE_NAME} initialization.
	 *
	 * @param encoding
	 * 		  The encoding passed into constructor for {@code ENCODING} initialization.
	 */
	public Parser(final String fileName, String encoding) {
		FILE_NAME = fileName;
		ENCODING = encoding;
	}

	/* (non-Javadoc)
	 * @see java.lang.Iterable#iterator()
	 */
	@Override
	public Iterator<String> iterator() {
			return new FileIterator();
	}

	 class FileIterator implements Iterator<String> {

		/**
		 * Contains all sentences from the file named {@FILE_NAME}.
		 */
		public List<String> listOfSentences = new LinkedList<>();

		/**
		 * Pattern that extracts sentences from file contents.
		 * Sentence starts from uppercase and ends with a dot.
		 */
		static final String PATTERN = "\\b[A-ZÀ-ß¨][a-zA-ZÀ-ß¨à-ÿ¸\\s\\d,-]*";

		/**
		 * Constructor that reads file and puts all sentences
		 * by special {@code PATTERN} into {@codelistOfSentences}.
		 */
		public FileIterator() {
			StringBuilder sourceText = readFile(FILE_NAME);
			Pattern p = Pattern.compile(PATTERN, Pattern.UNICODE_CHARACTER_CLASS);
 			Matcher m = p.matcher(sourceText);
			while (m.find()) {
				listOfSentences.add(m.group());
			}
		}

		/**
		 * @param path
		 * 		  Path to the current file.
		 *
		 * @return file contents
		 */
		StringBuilder readFile(final String path) {
			StringBuilder sourceText = new StringBuilder();
			String line;
			try (BufferedReader in = new BufferedReader(new InputStreamReader(
					new FileInputStream(new File(path)),ENCODING))) {
				while ((line = in.readLine()) != null) {
					sourceText.append(line);
				}
			} catch(IOException ex) {
				System.err.println(ex);
			}
			return sourceText;
		}

		/**
		 * @return first sentence from list and deletes it
		 */
		public String cutReturnedSentence() {
			return listOfSentences.remove(0);
		}

		/**
		 * Checks out that list contains sentences.
		 */
		@Override
		public boolean hasNext() {
			return !listOfSentences.isEmpty();
		}

		/**
		 * @return sentence from list if {@code listOfSentences} does not empty
		 */
		@Override
		public String next() {
			if (hasNext()) {
				return cutReturnedSentence();
			} else {
				return null;
			}
		}

		/* (non-Javadoc)
		 * @see java.util.Iterator#remove()
		 */
		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
}
