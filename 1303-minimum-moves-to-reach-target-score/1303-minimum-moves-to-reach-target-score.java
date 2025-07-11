class Solution {
    public int minMoves(int target, int maxDoubles) {
        int moves = 0;

        while(target> 0 && maxDoubles>0){
            if(target%2 == 0){
                target = target/2;
                maxDoubles--;
            }else{
                target -= 1;
            }
            moves++;
        }

        return moves +(target-1);
        
    }
}