package com.example;

public class Main {
    public static void main(String[] args) throws Exception {
        String input = "8+5-7+9"; // can be parsed
        // String input = "45+89-876"; // can't be parsed (double digits are breaking the parser)
        Parser p = new Parser(input.getBytes());
        p.parse();
    }
}