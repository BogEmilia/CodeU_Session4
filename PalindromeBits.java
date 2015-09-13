import java.lang.*;
import static java.lang.Integer.toBinaryString;

//  The idea is to analyse the entropy of different length palindromes as the only freely changable digits are the second to the middle one.
// Using this we can calculate the length of the required palindrome and from there the palindrome as well.

public class PalindromeBits {
    public static int binaryPal(int k) {
        if (k == 1) {
            return 1;
        } else if (k == 2){
            return 3;
        } else {
            int d = 0;
            double logk = Math.log(k+2)/Math.log(2);    // log2(k+2)
            d = (int) (Math.floor(logk)*2 - 2);
            if (Math.ceil(logk) == Math.floor(logk)) {  // is int
                return (int) (Math.pow(2, d) - 1);
            } else if (k <= (Math.pow(2, Math.floor(logk)) - 2 + Math.pow(2, Math.floor(logk) - 1))) {
                d += 1;
                int innervalue = k - ((int) Math.pow(2, Math.floor(logk)) - 2) - 1;
                String toBinaryStr = toBinary(innervalue, (int) Math.ceil((d/2.0) - 1));
                if (toBinaryStr == null) {
                    return -1;
                }
                for (int i = toBinaryStr.length() - 2 ; i >= 0; i--) {
                    toBinaryStr += toBinaryStr.substring(i, i+1);
                }
                return binaryToInt("1" + toBinaryStr + "1");
            } else {
                d += 2;
                int innervalue = (k - ((int) Math.pow(2, Math.floor(logk)) - 2 + (int) Math.pow(2, Math.floor(logk) - 1 ))) - 1;
                String toBinaryStr = toBinary(innervalue, (int) Math.ceil((d/2.0) - 1));
                if (toBinaryStr == null) {
                    return -1;
                }
                for (int i = toBinaryStr.length() - 1 ; i >= 0; i--) {
                    toBinaryStr += toBinaryStr.substring(i, i+1);
                }
                return binaryToInt("1" + toBinaryStr + "1");
            }
        }
    }

    public static int binaryToInt(String binary) {
        int ans = 0;
        for (int i = binary.length() - 1, j = 0; i >= 0; i--, j++) {
            if (binary.charAt(i) == '1') {
                ans += (int) Math.pow(2, j);
            }
        }
        return ans;
    }

    public static String toBinary(int dec, int len) {
        String bs = toBinaryString(dec);
        if (len < bs.length()) {
            return null;
        } else {
            String z = "";
            for (int i=bs.length(); i < len; i++){
                z += "0";
            }
            return z + bs;
        }
    }

    public static void main(String[] args) {
        for (int i=1; i<20; i++) {
            System.out.println(PalindromeBits.binaryPal(i));
        }
    }
}


