import java.util.Arrays;
import java.util.function.Function;

class P2149 {
    public static void main(String[] args) {
        new P2149().rearrangeArray(new int[]{ 3, 1,-2, -5, 2,-4 });
    }

    // Solution 1 : Accepted solution
    public int[] rearrangeArray(int[] nums) {

        int i = 0, pIndex = 0, nIndex = 1;
        int[] arrangedNums = new int[nums.length];

        while (i < nums.length) {
            if (nums[i] >= 0) {
                arrangedNums[pIndex] = nums[i++];
                pIndex+=2;
            } else {
                arrangedNums[nIndex] = nums[i++];
                nIndex+=2;
            }
        }
        System.out.println(Arrays.toString(arrangedNums));
        return arrangedNums;
    }

/*
    // Solution 2 : Accepted solution
    public int[] rearrangeArray(int[] nums) {

        int i = 0,
                pIndex = 0,
                nIndex = 0,
                aIndex = 0;

        int[] postiveNums = new int[nums.length / 2],
                negativeNums = new int[nums.length / 2],
                arrangedNums = new int[nums.length];

        while (i < nums.length) {
            if (nums[i] >= 0) {
                postiveNums[pIndex++] = nums[i++];
            } else {
                negativeNums[nIndex++] = nums[i++];
            }
            int index = (aIndex) / 2;
            if (pIndex > index && nIndex > index) {
                arrangedNums[aIndex++] = postiveNums[index];
                arrangedNums[aIndex++] = negativeNums[index];
            }
        }
        System.out.println(Arrays.toString(arrangedNums));
        return arrangedNums;
    }
*/

/*
    // Solution 3 : Accepted solution

    public int[] rearrangeArray(int[] nums) {
        int     i = 0,
                pIndex = 0,
                nIndex = 0;

        int[]   postiveNums  = new int[nums.length/2],
                negativeNums = new int[nums.length/2],
                arrangedNums = new int[nums.length];

        while(i < nums.length) {
            if(nums[i] >= 0) {
                postiveNums[pIndex++] = nums[i++];
            } else {
                negativeNums[nIndex++] = nums[i++];
            }
        }
        i=0;
        while(i < nums.length/2) {
            arrangedNums[i*2] = postiveNums[i];
            arrangedNums[i*2 +1] = negativeNums[i];
            i++;
        }
        System.out.println(Arrays.toString(arrangedNums));
        return arrangedNums;
    }
*/

/*
    // Solution 4 : not meeting time complexity requirement

    public int[] rearrangeArray(int[] nums) {
        int i = 0, j =0;
        int conditionalFlag = 1;

        while(i < nums.length) {
            if (j < nums.length && getConditionalFunction(conditionalFlag).apply(nums[j])) {
                if(j != i) {
                    shift(nums, i, j);
                }
                i++;
                j=i;
                conditionalFlag *= -1;
            } else {
                j++;
            }
        }

        System.out.println(Arrays.toString(nums));
        return nums;
    }

    public Function<Integer, Boolean> getConditionalFunction(int flag) {
        final Function<Integer, Boolean>
                positiveCondition = n -> n >=0,
                negativeCondition = n -> n < 0;
        return switch (flag) {
            case  1 -> positiveCondition;
            case -1 -> negativeCondition;
            default -> throw new RuntimeException("Conditional function not defined");
        };
    }

    public void shift(int[] nums, int index1, int index2) {
        int i = index2;
        int temp = nums[index2];
        while (i > index1 && i > 0) {
            nums[i] = nums[i-1];
            i--;
        }
        nums[index1] = temp;
    }
*/
}
