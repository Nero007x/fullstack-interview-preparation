class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights.length == 0 || heights == null) return 0;

        int n = heights.length;
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i<=n; i++){
           int currentHeight= (i!=n) ? heights[i] : 0;

           while(!stack.isEmpty() && currentHeight < heights[stack.peek()]){
            int topIndex = stack.pop();
            int topHeight = heights[topIndex];

            int width = stack.isEmpty()? i : (i-stack.peek()-1);
            int area = topHeight*width;
            maxArea = Math.max(area, maxArea);
           }

           stack.push(i);

        }

        return maxArea;
        
    }
}