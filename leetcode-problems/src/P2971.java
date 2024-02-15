import java.util.Arrays;

public class P2971 {


    public static void main(String[] args) {
        P2971 o = new P2971();
        int[] nums = new int[]{1, 12, 1, 2, 5, 50, 3};
        long sum = o.largestPerimeter(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(sum);
    }

    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        long sum = 0L;
        for (int num : nums) {
            sum += num;
        }
        int size = nums.length;
        while(size >= 3) {
            int max = nums[size - 1];
            if (max < sum - max) {
                return sum;
            } else {
                sum -= max;
                size--;
            }
        }
        return -1L;
    }

/*
    // Accepted Solution 2  : improved complexity

    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        long sum = 0L;
        for (int num : nums) {
            sum += num;
        }
        return largestPerimeter(nums, nums.length, sum);
    }

    private long largestPerimeter(int[] nums, int size, long sum) {
        if (size < 3) {
            return -1;
        }
        int max = nums[size - 1];
        if (max < sum - max) {
            return sum;
        } else {
            return largestPerimeter(nums, --size, sum - max);
        }
    }
*/
/*
    // Accepted Solution 1

    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        return largestPerimeter(nums, nums.length);
    }

    private long largestPerimeter(int[] nums, int size) {
        if(size == 3) {
            int max = nums[size-1];
            long sum = getSum(size, nums);
            if(max < sum-max) {
                return sum;
            }
        } else if(size > 3) {
            int max = nums[size-1];
            long sum = getSum(size, nums);
            if(max < sum-max) {
                return sum;
            } else {
               return largestPerimeter(nums, --size);
            }
        }
        return -1L;
    }

    private long getSum(int size, int...nums) {
        long sum = 0L;
        for(int i=0; i<size; i++) {
            sum+= nums[i];
        }
        return sum;
    }
*/
}
