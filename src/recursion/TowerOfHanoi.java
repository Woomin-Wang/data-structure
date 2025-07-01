package recursion;

public class TowerOfHanoi {

    public static void main(String[] args) {

        int numberOfDisks = 3;
        char source = 'A';
        char destination = 'C';
        char assist = 'B';

        hanoi(numberOfDisks, source ,destination, assist);
    }

    // 옮길 원반의 개수(count), 시작 기둥(from), 보조 기둥(temp), 목표 기둥(to)
    public static void hanoi(int count, char from, char to, char temp) {
        // 1. Base Case: 원반이 없으면(count=0) 아무것도 하지 않고 함수를 끝낸다.
        if (count == 0) {
            return;
        }

        // 1. n-1개의 원반을 보조 기둥으로 옮긴다.
        hanoi(count - 1, from, temp, to);

        // 2. 가장 큰 원반을 1개의 목표 기둥으로 옮긴다.
        System.out.println("원반 " + count + "를 " + from + "에서 " + to + "으로 이동");

        // 3. n-1개의 원반을 보조 기둥에서 목표 기둥으로 옮긴다.
        hanoi(count - 1, temp, to, from);
    }
}
