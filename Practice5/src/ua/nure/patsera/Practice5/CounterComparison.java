package ua.nure.patsera.Practice5;

public class CounterComparison extends Thread {
/*	static int counter1 = 0;
	static int counter2 = 0;*/
	public void countersComparison() {
		while (!Thread.currentThread().isInterrupted()) {
			if (Part3.counter1 > Part3.counter2) {
				System.out.println(Part3.counter1 + " " + Part3.counter2 + " " + "Us counter1 > counter2 on " + (Part3.counter1 - Part3.counter2));
			} else if (Part3.counter1 < Part3.counter2) {
				System.out.println("Us counter2 > counter1 on " + (Part3.counter2 - Part3.counter1));
			} else {
				System.out.println("Us Both of counters are equals.");
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
