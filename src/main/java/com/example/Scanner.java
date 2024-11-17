package com.example;

import com.example.Token.TokenType;

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
            return (char) (input[current]);
        }
        // return ASCII for Null
        return '\0';
    }

    // Increases the cursor value
    private void advance() {
        char ch = peek();
        if (ch != '\0') {
            current++;
        }
    }

    // Number token 'type'
    // Travel over the input and creates an string in the interval that it keeps
    // catching digits
    private String _number() {
        int start = current;
        while (Character.isDigit(peek())) {
            advance();
        }
        String n = new String(input, start, current - start);
        return n;
    }

    // Handling numbers as Token
    private Token number() {
        int start = current;
        while (Character.isDigit(peek())) {
            advance();
        }
        String n = new String(input, start, current - start);
        return new Token(TokenType.NUMBER, n);
    }

    // Matches if is digit or oper and returns the char at current cursor
    // in this setup it only treats unique chars tokens
    public Token nextToken() {
        // current cursor char
        char ch = peek();

        // digit handling
        if (ch == '0') {
            advance();
            return new Token(TokenType.NUMBER, Character.toString(ch));
        } else if (Character.isDigit(ch)) {
            return number();
        }

        // oper handling
        switch (ch) {
            case '+':
                advance();
                return new Token(TokenType.PLUS, "+");
            case '-':
                advance();
                return new Token(TokenType.MINUS, "-");
            case '\0':
                advance();
                return new Token(TokenType.EOF, "EOF");
            case '*':
                break;
            case '/':
                break;
            default:
                break;
        }

        throw new Error("Lexical Error");
    }
}
