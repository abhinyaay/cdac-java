class StringProgram7 {
    public static void main(String[] args) {

        // Reverse a string
        String str = "The quick brown fox jumps";

        System.out.println("The given string is: " + str);

        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed = reversed + str.charAt(i);
        }

        System.out.println("The string in reverse order is:");
        System.out.println(reversed);
    }
}
