public interface InterfaceMap< K,V> {
    void put(K key, V value);

    V get(K key);

    boolean remove(K key);


    public int size();



}
