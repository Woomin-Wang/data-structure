package list;

public class DoublyLinkedListMain {
    public static void main(String[] args) {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();

        list.add("왕우민");
        list.add("강은현");
        list.add("오준택");
        System.out.println(list);

        System.out.println(list.get(0));

        list.set(1, "유재영");
        System.out.println(list);

        list.remove(2);
        System.out.println(list);
    }
}
