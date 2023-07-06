import java.util.Random;
import java.util.Scanner;

public class Array {
	private static int arrayIndex = 0;
	private static int minValue = 61;
	private static int maxValue = 80;
	private static int number = 0;

	private static boolean isMin() {
		if (number <= minValue) {
			number = minValue + 1;
			return true;
		}
		return false;
	}

	private static boolean isMax() {
		if (number >= maxValue) {
			number = maxValue - 1;
			return true;
		}
		return false;
	}

	private static int changeNumber() {
		Random number = new Random();
		if (number.nextInt(2) != 0)
			return 1;
		return -1;
	}

	private static int generateNumber(int oldValue) {
		number = oldValue;
		if (!(isMax()) && !(isMin())) {
			number = number + changeNumber();
		}
		return number;
	}

	private static int findIndex(int[] array, int scanValue) {
		int minAbsolute  = 0;

		if (arrayIndex >= 100) 
			return -1;

		minAbsolute = Math.abs(array[arrayIndex] - scanValue);
		System.out.println("Index -> " + arrayIndex + " <- Min Uzaklik [" + minAbsolute + "] Value [" + array[arrayIndex] + "]");
		if (minAbsolute != 0) { 
			arrayIndex = arrayIndex + minAbsolute;
			findIndex(array, scanValue);
		}
		return arrayIndex;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] array = new int[100]; 
		Random random = new Random();
		int firstData = random.nextInt((maxValue - minValue) + 1) + minValue; 

		array[0] = firstData; 
		for (arrayIndex = 1; arrayIndex < 100; arrayIndex++) {
			array[arrayIndex] = generateNumber(array[arrayIndex - 1]);
		}

		for (int k = 0; k < array.length; k++) { //
			System.out.print("[" + array[k] + "] ");
			if ((k + 1) % 10 == 0) {
				System.out.println();
			}
		}

		System.out.print("Enter a value : ");
		int scanValue = scanner.nextInt(); 

		arrayIndex = 0;
		if (findIndex(array, scanValue) == -1)
			System.out.println("The value not found..");
		else
			System.out.println("The value found. Index value :[" + arrayIndex + "]");
	}
}