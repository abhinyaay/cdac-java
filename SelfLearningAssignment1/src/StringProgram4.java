class StringProgram4 {
    public static void main(String[] args) {

        // Get the index of all the characters of the alphabet
        String str = "The quick brown fox jumps over the lazy dog.";

        // Print indices for a-j
        System.out.println("a  b c  d e  f  g h i  j");
        System.out.println("=========================");
        System.out.print(str.indexOf("a") + " ");
        System.out.print(str.indexOf("b") + " ");
        System.out.print(str.indexOf("c") + " ");
        System.out.print(str.indexOf("d") + " ");
        System.out.print(str.indexOf("e") + " ");
        System.out.print(str.indexOf("f") + " ");
        System.out.print(str.indexOf("g") + " ");
        System.out.print(str.indexOf("h") + " ");
        System.out.print(str.indexOf("i") + " ");
        System.out.println(str.indexOf("j"));

        System.out.println();

        // Print indices for k-t
        System.out.println("k  l  m  n  o  p q  r  s  t");
        System.out.println("===========================");
        System.out.print(str.indexOf("k") + " ");
        System.out.print(str.indexOf("l") + " ");
        System.out.print(str.indexOf("m") + " ");
        System.out.print(str.indexOf("n") + " ");
        System.out.print(str.indexOf("o") + " ");
        System.out.print(str.indexOf("p") + " ");
        System.out.print(str.indexOf("q") + " ");
        System.out.print(str.indexOf("r") + " ");
        System.out.print(str.indexOf("s") + " ");
        System.out.println(str.indexOf("t"));

        System.out.println();

        // Print indices for u-z
        System.out.println("u  v  w  x  y  z");
        System.out.println("================");
        System.out.print(str.indexOf("u") + " ");
        System.out.print(str.indexOf("v") + " ");
        System.out.print(str.indexOf("w") + " ");
        System.out.print(str.indexOf("x") + " ");
        System.out.print(str.indexOf("y") + " ");
        System.out.println(str.indexOf("z"));
    }
}
