class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>(); // incies
        int[] result = new int[temperatures.length];
        for(int i=0; i<temperatures.length; i++){
            while(!stack.isEmpty() && temperatures[i]> temperatures[stack.peek()]){
                int prevs = stack.pop();
                result[prevs] = i- prevs;
            }
            stack.push(i);
        }
        return result;
    }
}