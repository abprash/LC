package group.LC2;




//Actual good code..................

class LRUCache {

    //lets have a map and a doubly linked list
    Node head, tail;
    Map<Integer, Node> map;
    int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        //the rest of the two pointers will be null by default
    }
    
    //the main logic is, we will have maintain a map and a doubly linked list simultaneously
    public int get(int key) {
        Node n = map.get(key);
        if(n == null){
            //we do not have the value, return -1
            return -1;
        }
        //we do have the node
        //update the node in the DLL, so that its now in the front
        update(n);
        return n.val;
    }
    
    public void put(int key, int value) {
        //lets see if this k,v is in the map
        Node n = map.get(key);
        if(n == null){
            n = new Node(key, value);
            add(n);
            map.put(key, n);
        }
        else{
            n.val = value;
            update(n);
        }
        if(map.size() > this.capacity ){
            //we need to remove a stale node now
            Node removeNode = tail.prev;
            remove(removeNode);
            map.remove(removeNode.key);
            return;
        }
        return;
    }
    
    public void remove(Node n){
        //just remove the node before the tail node
        Node before = n.prev, after = n.next;
        before.next = after;
        after.prev = before;
    }
    
    public void update(Node n){
        remove(n);
        add(n);
    }
    
    public void add(Node n){
        //we need to add this node in the DLL
        Node after = head.next;
        head.next = n;
        n.next = after;
        n.prev = head;
        after.prev = n;
        return;
    }
}

class Node{
    int key, val;
    Node prev, next;
    
    public Node(int k, int v){
        this.key = k;
        this.val = v;
    }
    public Node(){
        this(0,0);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

//A VERY LAZY IMPLEMENTATION..........................
//But good to know that such a thing exists internally too..............


public class LRUCache {

    Map<Integer, Integer> map;
    int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true){
            //now override the removeEldestEntry method
            public boolean removeEldestEntry(Map.Entry entry){
                return size() > capacity;
            }
        };
        
    }
    
    public int get(int key) {
        return map.getOrDefault(key,-1);
    }
    
    public void put(int key, int value) {
        map.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */