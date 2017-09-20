package group.LC;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;
class LRUCache {

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
        //System.out.println("in get-->"+cache.size());
        //System.out.println("Before doing GET - key:"+key+" "+cache);
        //we have to simply retrieve the key
        if(cache.containsKey(key)){
            maxAge++;
            int retVal = cache.get(key).value;
            //update the age
            cache.remove(key);
            cache.put(key, new ValueObject(retVal,maxAge));
            // System.out.println("After GET:"+key+"");
            // System.out.println("Cache size :"+LRUCache.counter+", max size:"+LRUCache.maxSize);
            // System.out.println(cache.toString()+"\n-----------");
            return retVal;
        }
        // System.out.println("After GET:"+key+"");
        // System.out.println("Cache size :"+LRUCache.counter+", max size:"+LRUCache.maxSize);
        // System.out.println(cache.toString()+"\n-----------");
        return -1;
    }
    
    public void put(int key, int value) {
        maxAge++;
        if(counter < maxSize){
            //if the key is already present
            //we simply insert it
            if(cache.containsKey(key))
                cache.put(key, new ValueObject(value, maxAge));
            else{
                cache.put(key, new ValueObject(value, maxAge));
                counter++;
            }
        }
        else{
            int minValue = Integer.MAX_VALUE;
            int minKey = 0;
            for(Entry<Integer,ValueObject> e : cache.entrySet()){
                if(e.getKey() == key){
                    //update that and break
                    ValueObject v = new ValueObject(value,maxAge);
                    cache.put(key,v);
                    // System.out.println("After PUT :"+key+",value :"+value);
                    // System.out.println("Cache size :"+LRUCache.counter+", max size:"+LRUCache.maxSize);
                    // System.out.println(cache.toString()+"\n-----------");
                    return;
                }
                
            }
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
        //System.out.println("After PUT:"+key+",value:"+value);
        //System.out.println("Cache size :"+LRUCache.counter+", max size:"+LRUCache.maxSize);
        //System.out.println(cache.toString()+"\n-----------");
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
    
    @Override
    public String toString(){
        return "Value:"+value+",age:"+age;
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */