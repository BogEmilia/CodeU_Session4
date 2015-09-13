
public class PalindromeStr {

    public static class PalOutput {
        private int startind;
        private int len;

        public PalOutput(int startind, int len) {
            this.startind = startind;
            this.len = len;
        }

        public int getLen() {
            return len;
        }

        public int getStartind() {
            return startind;
        }
        public String toString(){
            return "Start index is: " + startind + " \nLength is: " + len;
        }
    }

    public static PalOutput palStr(String input) {
        int maxstart = 0;
        int maxlen = 0;
        char[] inarr = input.toCharArray();
        for (int i = 0 ; i < inarr.length-maxlen; i++) {
            for (int j = i+maxlen ; j < inarr.length; j++) {
                if (isPal(inarr, i, j)){
                    maxlen = j-i+1;
                    maxstart = i;
                }
            }
        }
        return new PalOutput(maxstart, maxlen);
    }

    private static boolean isPal(char[] inarr, int start, int end) {
        for (int i = start, j = end ; i < j; i++, j--) {
            if (inarr[i] != inarr[j]) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String input = "12111122221212121";
        System.out.println(palStr(input));

        String input2 = "";
        System.out.println(palStr(input2));
    }
}
//    Expected output:
//        Start index is: 9
//        Length is: 7
//        Start index is: 0
//        Length is: 0
