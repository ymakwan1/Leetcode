import java.util.Stack;

class Solution {
    public long subArrayRanges(int[] nums) {
        return sumSubarrayMaxs(nums) - sumSubarrayMins(nums);
    }

    private long sumSubarrayMaxs(int[] arr) {
        int[] nle = findNLE(arr); 
        int[] ple = findPLE(arr); 
        int n = arr.length;
        long total = 0;

        for (int i = 0; i < n; i++) {
            long left = i - ple[i];
            long right = nle[i] - i;
            total += left * right * arr[i];
        }

        return total;
    }

    private int[] findNLE(int[] arr) {
        int n = arr.length;
        int[] nle = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            nle[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        return nle;
    }

    private int[] findPLE(int[] arr) {
        int n = arr.length;
        int[] ple = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                stack.pop();
            }
            ple[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        return ple;
    }

    private long sumSubarrayMins(int[] arr) {
        int[] nse = findNSE(arr); // Nearest Smaller Element
        int[] pse = findPSE(arr); // Previous Smaller Element
        int n = arr.length;
        long total = 0;

        for (int i = 0; i < n; i++) {
            long left = i - pse[i];
            long right = nse[i] - i;
            total += left * right * arr[i];
        }

        return total;
    }

    private int[] findNSE(int[] arr) {
        int n = arr.length;
        int[] nse = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            nse[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        return nse;
    }

    private int[] findPSE(int[] arr) {
        int n = arr.length;
        int[] pse = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            pse[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        return pse;
    }
}
