package com.revature.util;

public class MyHashMap<K, V> {
	
	private int capacity = 16; //Initial default capacity
    private MyEntry<K, V>[] table; //Array of Entry object

    public MyHashMap(){
        table = new MyEntry[capacity];
    }

    public MyHashMap(int capacity){
        this.capacity = capacity;
        table = new MyEntry[capacity];
    }

    /**
     * Creates and Adds the given <Key,Value> Entry to the mapping.
     * @param key
     * @param value
     */
    public void put(K key, V value){
    	int index = index(key);
    	MyEntry<K, V> newEntry = new MyEntry<K, V>(key, value, null);
        if(table[index] == null){
            table[index] = newEntry;
        }else {
        	MyEntry<K, V> previousNode = null;
        	MyEntry<K, V> currentNode = table[index];
            while(currentNode != null){
                if(currentNode.getKey().equals(key)){
                    currentNode.setValue(value);
                    break;
                }
                previousNode = currentNode;
                currentNode = currentNode.getNext();
            }
            if(previousNode != null)
                previousNode.setNext(newEntry);
            }        
    }

    /**
     * Returns the Value of the given Key.
     * @param key
     * @return Value
     */
    public V get(K key){
    	 V value = null;
         int index = index(key);
         MyEntry<K, V> entry = table[index];
         while (entry != null){
             if(entry.getKey().equals(key)) {
                 value = entry.getValue();
                 break;
             }
             entry = entry.getNext();
         }
         return value;      
    }

    /**
     * Removes the <Key,Value> entry from the mapping by the given Key.
     * @param key
     */
    public void remove(K key){
    	int index = index(key);
    	MyEntry<K, V> previous = null;
    	MyEntry<K, V> entry = table[index];
        while (entry != null){
            if(entry.getKey().equals(key)){
                if(previous == null){
                    entry = entry.getNext();
                    table[index] = entry;
                    return;
                }else {
                    previous.setNext(entry.getNext());
                    return;
                }
            }
            previous = entry;
            entry = entry.getNext();
        }        
    }
    
    /**
     * Returns the size length of the mapping, hence the last key.
     * @return
     */
    public int size() {
    	int lastKey = 0;
    	
    	for(int i = 0; i < capacity; i++){
            if(table[i] != null){
            	MyEntry<K, V> currentNode = table[i];
                while (currentNode != null){
                    if((Integer)currentNode.getKey() > lastKey) {
                    	lastKey = (Integer)currentNode.getKey();
                    }
                    currentNode = currentNode.getNext();
                }
            }
        }
    	
    	return lastKey;
    }

    /**
     * Print out Key -> Value mapping to the console.
     */
    public void display(){
        for(int i = 0; i < capacity; i++){
            if(table[i] != null){
            	MyEntry<K, V> currentNode = table[i];
                while (currentNode != null){
                    System.out.println(String.format("Key: %s --> Value: %s", currentNode.getKey(), currentNode.getValue()));
                    currentNode = currentNode.getNext();
                }
            }
        }
    }

    /**
     * index method to return human readable hashed value of a key.
     * @param key
     * @return
     */
    private int index(K key){
        if(key == null){
            return 0;
        }
        return Math.abs(key.hashCode() % capacity);
    }
}
