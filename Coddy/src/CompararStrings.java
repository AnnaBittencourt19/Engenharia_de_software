public class CompararStrings {
    public static void main(String[] args) {
        String str1 = "hello";
        String str2 = "hello";
        String str3 = "Hello";

        boolean result1 = str1.equals(str2);  // true
        boolean result2 = str1.equals(str3);  // false (diferencia maiúsculas de minúsculas)
        System.out.println(result1);
    }
}