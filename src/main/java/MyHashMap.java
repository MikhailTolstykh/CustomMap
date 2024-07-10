import java.util.Arrays;


/**
 *Реализация интерфейса {@code InterfaceMap} с использованием хэш-таблицы.
 *
 *
 * @param <K> тип ключа
 * @param <V> тип значения
 */
public class MyHashMap<K,V> implements InterfaceMap<K,V> {

    private static final int CAPACITY = 16;// Начальная емкость массива
    private Entry<K,V>[] array = new Entry[CAPACITY];// Массив для хранения элементов
    private static final double LOAD_FACTOR = 0.75;// коэффициент загрузки
    private int size = 0;// текущий размер ХэшМап

    /**
     * Добавляет элемент в Мапу с определенным значением по ключу
     * @param key ключ элемента
     * @param value значение элемента
     */

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

    /**
     *  Метод для добавления элемента в указанный массив.
     * @param key ключ элемента
     * @param value значение элемента
     * @param insertArray массив для добавления элемента
     * @return {@code true},если элемент был добавлен,{@code false} если элемент не был добавлен
     */
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

    /**
     * Возвращает значение элемента по ключу.
     * Если ключ равен null, выбрасывается исключение{@code NullPointerException}.
     * @param key ключ элемента
     * @return значение элемента или {@code null}, если элемент не найден
     */
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

    /**
     * Удаляет элемент из ХэшМап по указанному ключу.
     * Если ключ равен null, выбрасывается исключение {@code NullPointerException}.
     *
     * @param key ключ элемента для удаления
     * @return {@code true}, если элемент был успешно удален, {@code false} если элемент не найден
     */
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

    /**
     * Возвращает текущий размер ХэшМап (количество элементов).
     * @return текущий размер ХэшМап
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Возвращает позицию элемента в массиве по его хэш-коду и длине массива.
     *
     * @param key ключ элемента
     * @param arrayLenght длина массива
     * @return позиция элемента в массиве
     */
    private int getElementPosition(K key, int arrayLenght) {
        return Math.abs(key.hashCode() % arrayLenght);
    }

    /**
     * Увеличивает емкость массива в два раза при достижении фактора загрузки.
     */
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

    /**
     * Возвращает текущую длину массива.
     *
     * @return текущая длина массива
     */
    @Override
    public  int getArrayLenght(){
        return array.length;
    }

    /**
     *Класс, представляющий элемент ХэшМап.
     *
     * @param <K> тип ключа
     * @param <V> тип значения
     */
    private static class Entry<K,V> {
        private K key;
        private V value;
        private Entry next;


        /**
         * Конструктор, создающий новый элемент ХэшМп с ключом, значением и ссылкой на следующий элемент.
         *
         * @param key ключ элемента
         * @param value значение элемента
         * @param next ссылка на следующий элемент в списке
         */

        public Entry(K key, V value, Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}


