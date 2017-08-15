package ua.nure.patsera.Practice6.part2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Part2 {

	/**
	 * Number of peoples in a circle.
	 */
	static int peopleNumber = 100;

	/**
	 * Number of people that will be cross of.
	 */
	static final int CROSS_OFF = 5;

	/**
	 * People from the circle stored into LinkedList {@code listCircle}
	 */
	private List<Integer> listCircle = new LinkedList<>();

	public List<Integer> getListCircle() {
		return listCircle;
	}

	public void setListCircle(List<Integer> listCircle) {
		this.listCircle = listCircle;
	}

	public List<Integer> getArrayListCircle() {
		return arrayListCircle;
	}

	public void setArrayListCircle(List<Integer> arrayListCircle) {
		this.arrayListCircle = arrayListCircle;
	}

	/**
	 * People from the circle stored into ArrayList {@code arrayListCircle}
	 */
	private List<Integer> arrayListCircle;

	 void listsInitialization() {
		for (int i = 0; i < peopleNumber; i++) {
			listCircle.add((int)(Math.random() * 100) + 1);
		}
		arrayListCircle = new ArrayList<>(listCircle);
	}

	 void crossOffLinkedList(List<Integer> list) {
		 long start2 = System.nanoTime();
		 for (int i = 0; i < peopleNumber--; i += CROSS_OFF) {
			 list.remove(i);
		 }
		 long finish2 = System.nanoTime();
		 System.out.println("Crossing off from LinkedList take: " + (finish2 - start2));
	 }

	 void crossOffArrayList(List<Integer> list) {
		 long start1 = System.nanoTime();
		 for (int i = 0; i < peopleNumber--; i += CROSS_OFF) {
			 list.remove(i);
		 }
		 long finish1 = System.nanoTime();
		 System.out.println("Crossing off from ArrayList take: " + (finish1 - start1));

	 }

	 public static void main(String[] args) {
		 Part2 p2 = new Part2();
		 p2.listsInitialization();
		 p2.crossOffArrayList(p2.getArrayListCircle());
		 p2.crossOffLinkedList(p2.getListCircle());
	}
}
