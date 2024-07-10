import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertThrows;

public class MyMapTest {
    private MyHashMap<String,Integer> map;

    @Before
    public void setUp() throws Exception {
        map = new MyHashMap<>();
    }

    @Test
    public void put100ElementsWith10DifferentKeysThenSize10() {
        for (int i = 0; i < 100; i++) {
            int index = i % 10;
          String key =  ("Key " + index);
            Integer value = (i);
            map.put(key, value);
        }
        assertEquals(10, map.size());
    }

    @Test
    public void checkRemove() {
        for (int i = 0; i < 10; i++) {
            String key =  ("Key" + i);
            Integer value = (i);
            map.put(key, value);
        }
        // Проверяем что размер мапы соответствует количеству добавленных обьектов
        assertEquals(10, map.size());

        // Создаем ключ по которому будем удалять
       String keyForDelete ="Key1";

        assertTrue(map.remove(keyForDelete));

        //снова проверяем количество обьектов после удаления одного
        assertEquals(9, map.size());

    }

    @Test
    public void testPutNullKey() {
        try {
            map.put(null, 100);

        } catch (NullPointerException e) {
            assertEquals("Невозможно использовать null вместо ключа", e.getMessage());
        }
    }

    @Test
    public void testRemoveNonExistentKey() {
        map.put("key1", 1);

        assertFalse(map.remove("nonexistent"));
        assertEquals(1, map.size());
    }
    @Test
    public void testPutAndGetNullValue() {
        map.put("key", null);

        assertNull(map.get("key"));
    }

}





