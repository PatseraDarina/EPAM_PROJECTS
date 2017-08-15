package ua.nure.patsera.Practice5;

/**
 * @author Daryna Patsera
 *
 */
class FirstThread extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ex) {
				System.err.println(ex);
			}
		}
	}
}
