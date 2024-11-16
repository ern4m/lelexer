package com.example;

public class Scanner {
    private byte[] input;
    private int current;

    public Scanner(byte[] input) {
        this.input = input;
    }

    // from Parser
    // Get current char on byte array
    private char peek() {
        if (current < input.length) {
            // return the byte value at the current position casted as char
            return (char) input[current];
        }
        // return ASCII for Null
        return '\0';
    }

    // Increases the cursor value
    private void advance() {
        char ch = peek();
        if(ch != '\0') {
            current++;
        }
    }

    // Matches if is digit or oper and returns the char at current cursor
    // in this setup it only treats unique chars tokens
    public char nextToken() {
        // current cursor char
        char ch = peek();

        // digit handling
        if(Character.isDigit(ch)) {
            advance();
            return ch;
        }

        // oper handling
        switch(ch) {
            case '+':
            case '-':
                advance();
                return ch;
            case '*':
                break;
            case '/':
                break;
            default:
                break;
        }

        return '\0';
    }
}
