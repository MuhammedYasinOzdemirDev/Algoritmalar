package AlanZamanTakasi;

import java.util.LinkedList;

public class HashTable {
    private final static int TABLO_SIZE=128;
    private final LinkedList<Integer>[] table;

    HashTable(){
        table=new LinkedList[TABLO_SIZE];
        for(int i=0;i< table.length;i++)
            table[i]=new LinkedList<>();
    }
    public int hash(int key){
        return key%TABLO_SIZE;
    }
    public void put(int key){
        int hash=hash(key);
        table[hash].add(key);
    }
    public boolean contains(int key){
        int hash=hash(key);
        return table[hash].contains(key);
    }
    public void Delete(int key){
        int hash=hash(key);
        table[hash].remove(key);
    }
    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        hashTable.put(10);
        hashTable.put(20);
        hashTable.put(130); // 130 ve 10 aynı hash değerine sahip olacak

        System.out.println("20 tabloda var mı? " + hashTable.contains(20));
        System.out.println("130 tabloda var mı? " + hashTable.contains(130));
    }
}
