package com.example;

public class Parser {
    private byte[] input;
    private int current;

    // Setting Parser input as the given byte array
    public Parser(byte[] input) {
        this.input = input;
    }

    // Parsing method
    public void parse() {
        expr();
    }

    // Method to get current char on byte array
    private char peek() {
        if (current < input.length) {
            // return the byte value at the current position casted as char
            return (char) input[current];
        }
        // return ASCII for Null
        return '\0';
    }

    // Method to match given char with curr char on bytearray
    private void match(char c) {
        if (c == peek()) {
            // increases the 'pointer' to our bytearray
            current++;
        } else {
            // throw error if missmatch occurs
            throw new Error("Custom syntax error");
        }
    }

    // defining valid symbols in the grammar as 'functions'
    // so expr() calls digit() and oper()
    void expr() {
        digit(); // this form makes obligatory that first char is an digit (?)
        oper();
    }

    // verifies if the peek() isDigit
    void digit() {
        // checks if peek() isDigit
        if (Character.isDigit(peek())) {
            System.out.println("push " + peek());
            match(peek());
        } else {
            // throw some error if fails
            throw new Error("Custom syntax error");
        }
    }

    // verifies if the peek() is in the operators list + | - | ε
    void oper() {
        // checks if peek() is +
        if (peek() == '+') {
            match('+'); // matches for sync
            digit(); // checks for digit
            System.out.println("add"); // if no errors thrown, outs "add"
            oper(); // checks for operators again (part of the recursive implementation)
        } else if (peek() == '-') {
            // same as above but for '-'
            match('-');
            digit();
            System.out.println("sub");
            oper();
        } else if (peek() == '*') { // not sure if these are the best impl for multiplication and division
            // same as above but for '*'
            match('*');
            digit();
            System.out.println("mul");
            oper();
        } else if (peek() == '/') {
            // same as above but for '/'
            match('/');
            digit();
            System.out.println("div");
            oper();
        }
    }
}
