import main.java.fung.model.MyMap;

public class Main {
    public static void main(String[] args) {
        MyMap<Integer, String> myMap = new MyMap<>();
        myMap.put(1, "A");
        myMap.put(2, "B");
        myMap.put(3, "C");
        myMap.put(4, "D");
        myMap.put(5, "E");
        myMap.put(2, "T");
        System.out.println(myMap.replace(3, "T"));
        System.out.println(myMap.get(3));
        System.out.println(myMap.get(2));
    }
}
