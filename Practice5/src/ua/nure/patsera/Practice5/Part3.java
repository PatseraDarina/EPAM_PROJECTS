package ua.nure.patsera.Practice5;

public class Part3 extends Thread {
	static int counter1 = 0;
	static int counter2 = 0;

	public static void synchronizedMethods() {
		SynchrCounterComparison s = new SynchrCounterComparison();
		s.start();
	}

	public static void unsynchronizedMethods() {
		CounterComparison c = new CounterComparison();
		c.start();
	}

	public static void main(String[] args) {
		synchronizedMethods();
		unsynchronizedMethods();

	}
}
