import java.util.ArrayList;

public class SplitString {

    public static String splitStr(String nospaces, ArrayList<String> dictionary)  {
        try {
            return _splitStr(nospaces, dictionary);
        } catch (Exception e){
            return "Parsing failed for: " + nospaces;
        }
    }
    public static String _splitStr(String nospaces, ArrayList<String> dictionary) throws Exception {
        if (nospaces.length() == 0) {
            return "";
        }
        for (String w : dictionary){
            if (nospaces.startsWith(w)){
                try {
                    return w + " " + _splitStr(nospaces.substring(w.length()), dictionary);
                } catch (Exception e) {
                    continue;
                }
            }
        }
        throw new Exception("Not fully parsed");
    }
    public static void main(String[] args) {
        String input = "applepiepieapple";
        ArrayList<String> dict = new ArrayList<String>();
        dict.add("pineapple");
        dict.add("pieappl");
        dict.add("pie");
        dict.add("dog");
        dict.add("apple");
        System.out.println(splitStr(input, dict));

        String input2 = "";
        dict.clear();
        dict.add("pineapple");
        System.out.println(splitStr(input2, dict));

        String input3 = "aman";
        dict.clear();
        dict.add("a");
        System.out.println(splitStr(input3, dict));
    }
}
//Expected output:
//        apple pie pie apple
//
//        Parsing failed for: aman

