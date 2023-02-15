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
    }
}