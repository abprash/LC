package group.LC;

public class LRUCache {

    HashMap<Integer, ValueObject> cache = new HashMap<>();
    //to track each new entry
    int counter = 0;
    //to limit the cache size
    int maxSize = 0;
    //to track the max age
    int maxAge = 0;
    public LRUCache(int capacity) {
        maxSize = capacity;
    }
    
    public int get(int key) {
        //System.out.println("Before doing GET - key:"+key+" "+cache);
        //we have to simply retrieve the key
        if(cache.containsKey(key)){
            maxAge++;
            int retVal = cache.get(key).value;
            cache.remove(key);
            cache.put(key, new ValueObject(retVal,maxAge));
            //System.out.println("After doing GET -key:"+key+" "+cache);
            return retVal;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        maxAge = value;
        if(counter < maxSize){
            //if the key is already present
            cache.put(key, new ValueObject(value, maxAge));
            //we simply insert it
            counter++;
        }
        else{
            int minValue = Integer.MAX_VALUE;
            int minKey = 0;
            for(Entry<Integer,ValueObject> e : cache.entrySet()){
                if(e.getValue().age < minValue){
                    minValue = e.getValue().age;
                    minKey = e.getKey();
                }
            }
            cache.remove(minKey);
            ValueObject v = new ValueObject(value,maxAge);
            cache.put(key,v);
            //now we have to replace something
            //scan the map for the one with the least age
            //remove it
            //insert it now
            //size is maintained
        }
        //we have to iterate over the values
        //if it already exists - 
            //we increment the priority level to maxPriority
    }
}

class ValueObject{
    int age;
    int value;
    
    public ValueObject(int value, int age){
        super();
        this.age = age;
        this.value = value;
    }
}