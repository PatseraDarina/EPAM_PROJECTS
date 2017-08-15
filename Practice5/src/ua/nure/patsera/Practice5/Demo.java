package ua.nure.patsera.Practice5;

public class Demo {
	public static void main(String[] args) {
		Part1 p = new Part1();
		p.callWithThread();
		p.callWithRunnable();
		Part3 p3 = new Part3();
		p3.synchronizedMethods();
	}

}
