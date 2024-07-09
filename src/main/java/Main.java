public class Main {
    public static void main(String[] args) {
        Key key = new Key("Misha");
        Key key2 = new Key("Sasha");


        Value value = new Value(37);
        Value value2 = new Value(78);


        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(key, value);
        myHashMap.put(key2, value2);


        System.out.println(myHashMap.get(key));
        System.out.println(myHashMap.get(key2));

        myHashMap.remove(key2);
        System.out.println(myHashMap.get(key2));

        System.out.println(myHashMap.size());

    }
}
