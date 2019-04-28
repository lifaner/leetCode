package leetcode.array;

/**
 * Create by lifan.
 * Date: 2018/7/18.
 * Time: 10:02.
 */
public class RemoveDuplicates {

    public static int removeDuplicates(int[] nums) {//1,1,2,3,3,3,4
        int curr = 0;
        for (int xb = 1; xb < nums.length; xb++) {
            if (nums[curr] != nums[xb]) {
                nums[curr + 1] = nums[xb];
                curr = curr + 1;
            }
        }
        return curr + 1;
    }


    public static void main(String[] args) {
        // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
        int[] nums = new int[]{1, 1, 1};
        int len = removeDuplicates(nums);

        // 在函数里修改输入数组对于调用者是可见的。
        // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }
    }
}
