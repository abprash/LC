package group.LC;

import java.util.HashMap;
import java.util.Map.Entry;

public class LRUCache {

	
	//*************************************almost worked***************
	//12/18 test cases passed
	
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
            //System.out.println("After doing GET -key:"+key+" "+cache);
            return retVal;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        maxAge++;
        if(counter < maxSize){
            //if the key is already present
            cache.put(key, new ValueObject(value, maxAge));
            //we simply insert it
            counter++;
            // for(Entry<Integer,ValueObject> e : cache.entrySet()){
            //     System.out.println("<"+key+", "+e.getValue().value+"> , age - "+e.getValue().age);
            // }
            // System.out.println("______________");
        }
        else{
            int minValue = Integer.MAX_VALUE;
            int minKey = 0;
            for(Entry<Integer,ValueObject> e : cache.entrySet()){
                if(e.getKey() == key){
                    //update that and break
                    ValueObject v = new ValueObject(value,maxAge);
                    cache.put(key,v);
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
            //System.out.println("After putting "+key);
            // for(Entry<Integer,ValueObject> e : cache.entrySet()){
            //     System.out.println("<"+key+", "+e.getValue().value+">, age - "+e.getValue().age);
            // }
            //System.out.println("______________");
            //System.out.println("in put-->"+cache.size());
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