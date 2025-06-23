class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = 0;
        for(int pile : piles){
            high = Math.max(pile, high);
        }

        while(low< high){
            int mid = (low+high)/2;
            if(canFinish(mid, piles, h)){
                high = mid;
            }else{
                low= mid+1;
            }
        }
        return low;
    }

    public Boolean canFinish(int speed, int[] piles, int h){
        int hours = 0;
        for(int pile : piles){
            hours+= (pile+speed-1)/speed;
        }
        return hours<= h;
    }
}