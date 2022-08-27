// this is a workspace

import java.util.Arrays;

class Solution {

    public int trap(int[] height) {
        if (height.length <= 2) {
            return 0;
        }
        else if (height.length == 3) {
            if (height[1] >= Math.min(height[0], height[2])) {
                return 0;
            }
            else {
                return Math.min(height[0], height[2]) - height[1];
            }
        }
        else {
            int leftMax = height[0];
            int leftMaxIndex = 0;
            int rightMax = height[height.length - 1];
            int rightMaxIndex = height.length - 1;
            int i = leftMaxIndex + 1;
            int j = rightMaxIndex - 1;
            int fill = 0;
            while ((i < rightMaxIndex) || (j > leftMaxIndex)) {
                while (i < rightMaxIndex) {
                    if (height[i] <= leftMax) {
                        i++;
                    }
                    else {
                        for (int k = leftMaxIndex + 1; k < i; k++) {
                            fill += (Math.min(leftMax, height[i]) - height[k]);
                        }
                        leftMax = height[i];
                        leftMaxIndex = i;
                        i++;
                        break;
                    }
                }
                while (leftMaxIndex < j) {
                    if (height[j] <= rightMax) {
                        j--;
                    }
                    else {
                        for (int k = j + 1; k < rightMaxIndex; k++) {
                            fill += (Math.min(height[j], rightMax) - height[k]);
                        }
                        rightMax = height[j];
                        rightMaxIndex = j;
                        j--;
                        break;
                    }
                }
            }
            for (int k = leftMaxIndex + 1; k < rightMaxIndex; k++) {
                fill += (Math.min(leftMax, rightMax) - height[k]);
            }
            return fill;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {0,1,2,0,3,0,1,2,0,0,4,2,1,2,5,0,1,2,0,2};
        System.out.println(solution.trap(arr));
    }

}