class StringProgram5 {
    public static void main(String[] args) {

        // Replace each substring that matches the given regular expression
        String str = "The quick brown fox jumps over the lazy dog.";

        System.out.println("Original string: " + str);

        String newStr = str.replaceAll("fox", "cat");

        System.out.println("New String: " + newStr);
    }
}
