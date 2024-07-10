public class Main {
    public static void main(String[] args) {



        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put("key", 3);
        myHashMap.put("key2",45);


        System.out.println(myHashMap.get("key"));
        System.out.println(myHashMap.get("key2"));

        myHashMap.remove("key2");
        System.out.println(myHashMap.get("key2"));

        System.out.println(myHashMap.size());

    }
}
