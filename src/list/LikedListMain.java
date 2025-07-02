package list;

public class LikedListMain {
    public static void main(String[] args) {

        LinkedList<String> list = new LinkedList<>();

        list.add("왕우민");
        list.add("오준택");

        System.out.println("arrayList = " + list);

        String getResult = list.get(1);
        System.out.println("getResult = " + getResult);

        list.add(1, "유재영");
        System.out.println("arrayList = " + list);

        list.remove(0);
        System.out.println("arrayList = " + list);

        list.set(1, "강은현");
        System.out.println("arrayList = " + list);

        int index = list.indexOf("유재영");
        System.out.println("유재영의 index = " + index);

    }
}
