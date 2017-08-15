package ua.nure.patsera.Practice5;

public class Part1 {

	/**
	 * Creating a stream with class
	 * extension <code>Thread</code>
	 */
	public void callWithThread() {
		FirstThread fs = new FirstThread();
		fs.start();
	}

	/**
	 * Creating a stream with interface
	 * implementation <code>Runnable</code>
	 */
	public void callWithRunnable() {
		Thread t = new Thread(new SecondThread(), "Thread1");
		t.start();
	}
}
