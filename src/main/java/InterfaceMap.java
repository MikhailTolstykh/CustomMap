/**
 *Интерфейс для пользовательской реализации Map.
 *
 * @param <K> тип ключа
 * @param <V> тип значения
 */
public interface InterfaceMap< K,V> {

    /**
     * Добавляет пару ключ-значение в мапу.
     *
     * @param key   ключ
     * @param value значение
     */

    void put(K key, V value);

    /**
     * Возвращает значение, соответствующее указанному ключу.
     *
     * @param key ключ
     * @return значение или null, если ключ не найден
     */
    V get(K key);
    /**
     * Удаляет элемент по указанному ключу.
     *
     * @param key ключ
     * @return true, если элемент был успешно удален, false, если элемент не найден
     */
    boolean remove(K key);

    /**
     * Возвращает количество элементов в мапе.
     *
     * @return количество элементов
     */
    public int size();
    /**
     * Возвращает длину внутреннего массива.
     *
     * @return длина массива
     */
    public  int getArrayLenght();

}
