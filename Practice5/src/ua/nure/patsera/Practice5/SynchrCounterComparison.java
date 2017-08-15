package ua.nure.patsera.Practice5;

public class SynchrCounterComparison extends Thread {
	public synchronized void countersComparison() {
		while (!Thread.currentThread().isInterrupted()) {
			if (Part3.counter1 > Part3.counter2) {
				System.out.println("Synchro counter1 > counter2 on " + (Part3.counter1 - Part3.counter1));
			} else if (Part3.counter1 < Part3.counter2) {
				System.out.println("Synchro counter2 > counter1 on " + (Part3.counter2 - Part3.counter1));
			} else {
				System.out.println("Synchro Both of counters are equals.");
			}
			countersIncrement();
			if (Part3.counter1 > 20) {
				this.interrupt();
			}
		}
	}

	public void countersIncrement() {
		Part3.counter1++;
		try {
			Thread.sleep(10);
		} catch (InterruptedException ex) {
			System.err.println(ex);
		}
		Part3.counter2++;
	}

	@Override
	public void run() {
		countersComparison();
	}
}
