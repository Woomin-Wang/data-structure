package list;

public class ArrayListMain {
    public static void main(String[] args) {

        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("왕우민");
        arrayList.add("오준택");

        System.out.println("arrayList = " + arrayList);

        String getResult = arrayList.get(1);
        System.out.println("getResult = " + getResult);

        arrayList.add(1, "유재영");
        System.out.println("arrayList = " + arrayList);

        arrayList.remove(0);
        System.out.println("arrayList = " + arrayList);

        arrayList.set(1, "강은현");
        System.out.println("arrayList = " + arrayList);

        int index = arrayList.indexOf("유재영");
        System.out.println("유재영의 index = " + index);
    }
}
