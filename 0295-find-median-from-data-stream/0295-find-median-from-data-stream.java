class MedianFinder {

    private PriorityQueue<Integer> left;
    private PriorityQueue<Integer> right;

    public MedianFinder() {
        this.left = new PriorityQueue<>(Collections.reverseOrder());
        this.right= new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        left.offer(num);
        right.offer(left.poll());
        if(left.size() < right.size()){
            left.offer(right.poll());
        }
    }
    
    public double findMedian() {
        if(left.size()==right.size()){
            return (left.peek()+right.peek())*0.5;
        }else{
            return left.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */