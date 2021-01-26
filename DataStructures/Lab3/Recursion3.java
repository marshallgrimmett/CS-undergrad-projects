public class Recursion3 {
	public static int rangeSum(int[] array, int start, int end) {
		if(start > end) {
			return 0;
		} else {
			return array[start] + rangeSum(array, start+1, end);
		}
	}

	public static void main(String[] args) {
		int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		int sum;
		sum = rangeSum(numbers, 3, 7);
		System.out.println(sum);
	}
}
