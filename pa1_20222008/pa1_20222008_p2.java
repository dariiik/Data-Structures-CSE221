import java.util.Arrays;

public class pa1_20222008_p2 {

    public static boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }
        return canPartitionRecursive(nums, 0, 0, sum / 2);
    }

    public static boolean canPartitionRecursive(int[] nums, int index, int sum, int target) {
        if (sum == target) {
            return true;
        }
        if (index >= nums.length || sum > target) {
            return false;
        }

        // Include the current element in the subset
        if (canPartitionRecursive(nums, index + 1, sum + nums[index], target)) {
            return true;
        }

        // Exclude the current element from the subset
        return canPartitionRecursive(nums, index + 1, sum, target);
    }

    public static void main(String[] args) {
        int[] nums = {1, 7, 1, 5}; //your own input
        System.out.println("20222008 pa1 p2 " + canPartition(nums));
    }
}
