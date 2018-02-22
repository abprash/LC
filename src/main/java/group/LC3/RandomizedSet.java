package group.LC;

//**********************************  better than 8%

class RandomizedSet2 {
    Set<Integer> randomSet;
    List<Integer> list;
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
        super();
        list = new LinkedList<>();
        randomSet = new HashSet<Integer>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(randomSet.contains(val))
            return false;
        else{
            randomSet.add(val);
            list.add(val);
        }
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(randomSet.contains(val)){
            randomSet.remove(val);
            list.remove((Integer) val);
            return true;
        }
        else
            return false;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        //first we get the size of the set
        int setSize = randomSet.size();
        //then we generate the random number
        int random = (int) (Math.random() * list.size());
        return list.get(random);
        //return (int) randomSet.toArray()[random];
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */






//*****************************better than 2%
public class RandomizedSet {
    Set<Integer> randomSet;
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
        super();
        randomSet = new HashSet<Integer>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(randomSet.contains(val))
            return false;
        else
            randomSet.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(randomSet.contains(val)){
            randomSet.remove(val);
            return true;
        }
        else
            return false;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        //first we get the size of the set
        int setSize = randomSet.size();
        //then we generate the random number
        int random = (int) (Math.random() * setSize);
        return (int) randomSet.toArray()[random];
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */