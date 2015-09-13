
public class UglyNum {

    public static int findUgly(int k) {
        int pos = 0;
        int i = 1;
        int temp = 0;
        while (k != pos) {
            temp = i;
            temp = reduce(temp, 2);
            temp = reduce(temp, 3);
            temp = reduce(temp, 5);
            if (temp == 1) {
                pos++;
            }
            i++;
        }
        return i-1;
    }

    public static int reduce(int i, int n) {
        if (i % n == 0) {
            return reduce(i/n, n);
        } else {
            return i;
        }
    }

    public static void main(String[] args) {
        for (int i=1; i<16; i++) {
            System.out.println(findUgly(i));
        }
    }
}
//Potential improvement: save numbers that were already found into ArrayList and return from there. (better if needs to search many times)
//  Expected output:
//        1
//        2
//        3
//        4
//        5
//        6
//        8
//        9
//        10
//        12
//        15
//        16
//        18
//        20
//        24
