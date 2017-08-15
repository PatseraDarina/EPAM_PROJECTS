package ua.nure.patsera.Practice5;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
class Spam extends Thread {

	/**
	 * Contains messages with intervals
	 */
	static final Map<Integer, String> MESSAGE = new LinkedHashMap<Integer, String>();

	static {
		MESSAGE.put(500, "500 ms passed");
		MESSAGE.put(1000, "1000 ms passed");
		MESSAGE.put(2000, "2000 ms passed");
		MESSAGE.put(3000, "3000 ms passed");
		MESSAGE.put(200, "200 ms passed");
		MESSAGE.put(5000, "5000 ms passed");
	}

/**
 * Runs thread that prints messages after certain period
 */
@Override
public void run() {
	try {
		for (Map.Entry<Integer, String> entry : MESSAGE.entrySet()) {
			Thread.sleep(entry.getKey());
			System.out.println(entry.getValue());
		}
	} catch (InterruptedException ex) {
		ex.printStackTrace();
	}
}

public static void main(String[] args) throws Exception {
	Spam t = new Spam();
	t.setDaemon(true);
	t.start();
	new Thread() {
		@Override
		public void run() {
		byte[] buffer = new byte[10];
		int count;
		try {
			do {
				while ((count = System.in.read(buffer)) == -1);
			} while (!System.lineSeparator().equals(new String(buffer, 0, count)));
		} catch (IOException ex) {
		ex.printStackTrace();
		}
	System.out.println("ENTER has been obtained");
		}
	}.start();
  }

}