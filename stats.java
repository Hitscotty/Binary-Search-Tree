package HW6;


public class stats {
	// method to compute the average of array of long
	public static double average(long[] nums) {
		double avg = 0;

		for (int i = 0; i < nums.length; i++) {
			avg += (double) nums[i];
		}

		avg /= nums.length;

		return avg;
	}

	// method to compute the standard deviation of an array of long
	public static double standardDeviation(long[] nums) {
		double sD = 0;
		double sum = 0;

		double average = average(nums);

		for (int i = 0; i < nums.length; i++) {
			sum += Math.pow(((double) nums[i] - average), 2.0);
		}

		sum /= nums.length;

		sD = Math.sqrt(sum);

		return sD;
	}

}
