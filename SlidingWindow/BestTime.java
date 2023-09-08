// 121. Best Time to Buy and Sell Stock
// 
// You are given an array prices where prices[i] is the price of a given stock on the ith day.
// You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
// Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
package SlidingWindow;

class BestTime {
    public static void main(String[] args) {
        int[] arr = { 7, 1, 5, 3, 6, 4 };
        System.out.println(maxProfit(arr));
    }

    public static int maxProfit(int[] prices) {
        // This is sliding window type problem.
        // Set the left pointer as zero and right pointer as one for initial value.
        // Prepare maxProfit to store the maximum profit.
        int leftPointer = 0;
        int rightPointer = 1;
        int maxProfit = 0;

        // Move forward the right pointer to the end of prices array.
        while (rightPointer < prices.length) {

            // Compare the value of left pointer with the value of right pointer.
            // If the value of left pointer is smaller than or equal to the right pointer,
            // save the difference value into the maxProfit and move forward the right
            // pointer.
            if (prices[leftPointer] <= prices[rightPointer]) {
                // Maintain the maxProfit as maximum value when it has to be updated.
                maxProfit = Math.max(maxProfit, prices[rightPointer] - prices[leftPointer]);
                rightPointer++;
                // If the value of left pointer is larger than the right pointer,
                // stick the leftpointer to the right pointer, after that move forward the right
                // pointer without any action.
            } else {
                leftPointer = rightPointer;
                rightPointer++;
            }

        }
        return maxProfit;
    }

    // Time complexity is O(N) where N is the length of array
    // Space complexity is O(1)

}