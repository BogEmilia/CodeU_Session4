import java.util.ArrayList;

import static java.util.Collections.sort;

public class ComputeChange {

    public static int makeChange(int sum, ArrayList<Integer> den) {
        if (sum == 0) {
            return 1;
        }
        for (int i = 0; i < den.size();) {
            if (sum < den.get(i) || den.get(i) <= 0) {
                den.remove(i);
            } else {
                i++;
            }
        }
        if (den.isEmpty()) {
            return 0;
        }
        sort(den);
        int[] amount = new int[den.size()]; //represents an option of change given
        for (int i = 0; i < amount.length; i++) {
            amount[i] = 0;
        }

        return countStates(den, sum, amount, 0);
    }

    public static int evaluate(int[] amount, ArrayList<Integer> den) {
        int sum = 0;
        for (int i = 0; i < den.size(); i++) {
            sum += amount[i] * den.get(i);
        }
        return sum;
    }

    public static int countStates(ArrayList<Integer> den, int sum, int[] amount, int n) {
        if (evaluate(amount, den) == sum) {
            return 1;
        }
        if (n >= amount.length) {
            return 0;
        }
        int m = (sum - evaluate(amount, den)) / (den.get(n));
        if (m == 0) {
            return 0;
        }
        int count = 0;

        for (int i = 0; i <= m; i++) {
            int[] tempam = amount.clone();
            tempam[n] = i;
            count += countStates(den, sum, tempam, n+1);
        }
        return count;
    }

    public static void main(String[] args) {
        ArrayList<Integer> den = new ArrayList<Integer>();
        den.add(2);
        den.add(3);
        den.add(5);
        System.out.println(makeChange(10, den));

        den.clear();
        den.add(4);
        den.add(2);
        System.out.println(makeChange(1, den));
    }
}
//Expected output:
//        4
//        0
