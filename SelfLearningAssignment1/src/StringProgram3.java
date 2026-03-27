class StringProgram3 {
    public static void main(String[] args) {

        // Check whether a given string ends with the contents of another string
        String str1 = "Python Exercises";
        String str2 = "Python Exercise";

        System.out.println("\"" + str1 + "\" ends with \"se\"? " + str1.endsWith("se"));
        System.out.println("\"" + str2 + "\" ends with \"se\"? " + str2.endsWith("se"));
    }
}
