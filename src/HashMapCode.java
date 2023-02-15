import java.util.ArrayList;
import java.util.LinkedList;

public class HashMapCode {
    static class HashMap<K,V>{ // generics
        private class Node{
            K key;
            V value;
            Node(K key, V value){
                this.key=key;
                this.value=value;
            }
        }

        private  int n;// total number of nodes
        private int N; // total number of buckets or index or length of a array
        //private int array[]
        private LinkedList<Node> buckets[]; // actually it is a hash map its a bucket of array


        public  HashMap(){
            this.N=4;
            this.buckets=new LinkedList[4];
            for (int i=0; i<4; i++){
                this.buckets[i]=new LinkedList<>();
            }
        }
        private int hashFunction(K key){
            int bi=key.hashCode();
             return Math.abs(bi)%N; // 0 n-1;
        }

        private int searchInAll(K key, int bi) {
            LinkedList<Node> ll = buckets[bi];

            for(int i=0; i<ll.size(); i++) {
                if(ll.get(i).key == key) {
                    return i; //di
                }
            }

            return -1;
        }
        public void put(K key, V value){
int bi=hashFunction(key);
int di=searchInAll(  key, bi); // bi=1 di does not exit
            if (di==-1){ // key does not exit
buckets[bi] .add(new Node(key, value));
n++;
            }else { // key exit
 Node data=buckets[bi].get(di);
 data.value=value;

 double lambda=(double) n/N;
 if (lambda>2.0){
     // rehashing
 }
            }
        }
        public boolean containKey(K key){
            return false;
        }

        public V remove(K key){
            return null;
        }

        public V get(K key){
            return  null;
        }
        public ArrayList<K> KeySet(){
            return null;
        }

        public  boolean isEmpty(){
            return false;
        }
     }
}