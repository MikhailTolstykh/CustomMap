import java.util.Arrays;

public class MyHashMap<K,V> implements InterfaceMap<K,V> {

    private static final int CAPACITY = 16;
    private Entry<K,V>[] array = new Entry[CAPACITY];
    private static final double LOAD_FACTOR = 0.75;
    private int size = 0;

    @Override
    public void put(K key, V value) {
        if (key == null) {
            throw new NullPointerException("Невозможно использовать null вместо ключа");
        }
        if (size >= (array.length * LOAD_FACTOR)) {
            doubleArray();
        }
        if (put(key, value, array)) {
            size++;
        }
    }

    private boolean put(K key, V value, Entry<K,V>[]insertArray ) {
        int position = getElementPosition(key, insertArray.length);
        Entry existedElement = insertArray[position];
        if (existedElement == null) {
            Entry entry = new Entry(key, value, null);
            insertArray[position] = entry;
            return true;
        } else {
            while (true) {
                if (existedElement.key.equals(key)) {
                    existedElement.value = value;
                    return false;
                }
                if (existedElement.next == null) {
                    existedElement.next = new Entry(key, value, null);
                    return true;
                }
                existedElement = existedElement.next;
            }
        }
    }

    @Override
    public V get(K key) {
        if (key == null) {
            throw new NullPointerException("Невозможно использовать null вместо ключа");
        }
        int position = getElementPosition(key, array.length);
        Entry<K,V> existedElement = array[position];
        while (existedElement != null) {
            if (existedElement.key.equals(key)) {
                return existedElement.value;

            }
            existedElement = existedElement.next;

        }
        return null;
    }

    @Override
    public boolean remove(K key) {
        if (key == null) {
            throw new NullPointerException("Невозможно использовать null вместо ключа");
        }
        int position = getElementPosition(key, array.length);
        Entry existenElement = array[position];
        if (existenElement != null && existenElement.key.equals(key)) {
            array[position] = existenElement.next;
            size--;
            return true;
        } else {
            while (existenElement != null) {
                Entry nextElement = existenElement.next;
                if (nextElement == null) {
                    return false;
                }
                if (nextElement.key.equals(key)) {
                    existenElement.next = nextElement.next;
                    size--;
                    return true;
                }
                existenElement = nextElement;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }


    private int getElementPosition(K key, int arrayLenght) {
        return Math.abs(key.hashCode() % arrayLenght);
    }

    public void doubleArray() {
        Entry<K,V>[] newArray = new Entry[array.length * 2];
        for (Entry element : array) {
            Entry <K,V>existElement = element;
            while (existElement != null) {
                put(existElement.key, existElement.value, newArray);
                existElement=existElement.next;
            }
        }
        array = newArray;
    }


    @Override
    public  int getArrayLenght(){
        return array.length;
    }

    private static class Entry<K,V> {
        private K key;
        private V value;
        private Entry next;

        public Entry(K key, V value, Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}


