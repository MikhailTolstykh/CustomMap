import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyMapTest {
 private MyHashMap map ;

    @Before
    public void setUp() throws Exception {
       map = new MyHashMap();
    }

    @Test
    public void put100ElementsWith10DifferentKeysThenSize10(){
        for (int i = 0; i < 100; i++) {
            int index = i % 10;
            Key key = new Key("Key " + index);
            Value value = new Value(i);
            map.put(key, value);
        }
        assertEquals(10, map.size());
    }

    @Test
    public void checkRemove() {
        for (int i = 0; i < 10; i++) {
            Key key = new Key("Key" + i);
            Value value = new Value(i);
            map.put(key, value);

        }
        // Проверяем что размер мапы соответствует количеству добавленных обьектов
        assertEquals(10, map.size());

        // Создаем ключ по которому будем удалять
        Key keyForDelete = new Key("Key1");

        assertTrue(map.remove(keyForDelete));

        //снова проверяем количество обьектов после удаления одного
        assertEquals(9, map.size());


    }
}