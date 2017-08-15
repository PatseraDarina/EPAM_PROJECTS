package ua.nure.patsera.Practice5;

public class Part4 implements Runnable {

	public static long start;

	/**
	 * Number of {@code matrix} rows.
	 */
	final static int M = 4;

	/**
	 * Number of matrix columns.
	 */
	final static int N = 100;

	/**
	 * Matrix which will be used for max element searching.
	 */
	static Integer[][] matrix = fillingMatrixRandomElements();

	static int counter = 0;

	 private static int Max = 0;

	public static int getMax() {
		return Max;
	}

	public synchronized void setMax(int elements) {
		if (Max < elements) {
			Max = elements;
		}
	}

	static Integer[][] matrix2 = matrix;

	Integer[] arrayRowFromMatrix;

	public Part4() {

	}

	public Part4(Integer[] matrix) {
		arrayRowFromMatrix = matrix;
	}

	/**
	 * @return matrix {@code M * N} that was filled random elements
	 */
	static Integer[][] fillingMatrixRandomElements() {
		int maxEl = 100;
		int minEl = 1;
		Integer[][] matrix = new Integer[M][N];

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				matrix[i][j] = (int) (Math.random() * maxEl) + minEl;
			}
		}
		return matrix;
	}

	/**
	 * Searches max element from one matrix row.
	 *
	 * @param matrix
	 * 		  matrix which will be used for max element searching
	 *
	 * @return max element from {@code matrix}
	 * @throws InterruptedException
	 */
	 int searchMaxElement(Integer[] arrayRowFromMatrix) throws InterruptedException {
		 if (counter == 0) {
			 start = System.nanoTime();
		 }
		 if (!Thread.currentThread().isInterrupted()) {
			counter++;
			for (int i = 0; i < N; i++) {
				setMax(arrayRowFromMatrix[i]);
			}
			Thread.currentThread().interrupt();
		 }
		if (counter >= M) {
			System.out.println(getMax());
			System.out.println("Time = " + (System.nanoTime() - start));
			return getMax();
		}
		return 0;
	}

	static int searchMaxElementWithoutThread( Integer[][] arrayRowFromMatrix) {
		int max = Integer.MIN_VALUE;
		long start1 = System.nanoTime();
		for (int i = 0; i < M; i++)
			for (int j = 0; j < N; j++) {
				if (arrayRowFromMatrix[i][j] > max) {
					max = arrayRowFromMatrix[i][j];
				}
				System.out.println("Time = " + (System.nanoTime() - start1));
		}
		return max;
	}

	@Override
	public void run() {
		if (!Thread.currentThread().isInterrupted())
		 try {
			searchMaxElement(arrayRowFromMatrix);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		System.out.println(searchMaxElementWithoutThread(matrix2));

		Thread t1 = new Thread(new Part4(matrix[0]));
		Thread t2 = new Thread(new Part4(matrix[1]));
		Thread t3 = new Thread(new Part4(matrix[2]));
		Thread t4 = new Thread(new Part4(matrix[3]));
		t1.start();
		t2.start();
		t3.start();
		t4.start();


	}
}
