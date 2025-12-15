class LRUCache {

    class Node{
        int key;
        int value;

        Node next;
        Node prev;

        Node(int key, int value){
            this.key = key;
            this.value= value;
        }
    }

    int capacity;
    Map<Integer, Node> cache;
    Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.head = new Node(0,0);
        this.tail = new Node(0,0);

        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!cache.containsKey(key))
            return -1;
        Node curr = cache.get(key);
        remove(curr);
        addToHead(curr);
        return curr.value;
    }

    public void remove(Node node){
        Node prevNode = node.prev;
        Node nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    public void addToHead(Node node){
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next= node;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            node.value = value;

            remove(node);
            addToHead(node);
        }else{
            Node node = new Node(key, value);
            cache.put(key, node);
            addToHead(node);

            if(cache.size()> capacity){
                cache.remove(tail.prev.key);
                remove(tail.prev);
            }
        }
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */