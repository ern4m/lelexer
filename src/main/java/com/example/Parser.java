package com.example;

public class Parser {
    private byte[] input;
    private int current;

    // defines Scanner and cursor
    private Scanner scan;
    private char currentToken;

    // Setting Parser input as the given byte array
    public Parser(byte[] input) {
        // instatiante a new Scan
        // so our parser will be using a Scanner 
        // instead of it's own previously implemented parsing
        scan = new Scanner(input);
        currentToken = scan.nextToken();
        this.input = input;
    }

    // Updates the currentToken
    private void nextToken() {
        currentToken = scan.nextToken();
    }

    // Parsing method
    public void parse() {
        expr();
    }

    // Method to match given char with curr char on bytearray
    private void match(char t) {
        // Updated function to work based on the Scanner 
        if (currentToken == t) {
            nextToken();
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

    // verifies if the currentToken isDigit
    void digit() {
        // checks if currentToken isDigit
        if (Character.isDigit(currentToken)) {
            System.out.println("push " + currentToken);
            match(currentToken);
        } else {
            // throw some error if fails
            throw new Error("Custom syntax error");
        }
    }

    // verifies if the currentToken is in the operators list + | - | ε
    void oper() {
        // checks if currentToken is +
        if (currentToken == '+') {
            match('+'); // matches for sync
            digit(); // checks for digit
            System.out.println("add"); // if no errors thrown, outs "add"
            oper(); // checks for operators again (part of the recursive implementation)
        } else if (currentToken == '-') {
            // same as above but for '-'
            match('-');
            digit();
            System.out.println("sub");
            oper();
        } else if (currentToken == '*') { // not sure if these are the best impl for multiplication and division
            // same as above but for '*'
            match('*');
            digit();
            System.out.println("mul");
            oper();
        } else if (currentToken == '/') {
            // same as above but for '/'
            match('/');
            digit();
            System.out.println("div");
            oper();
        }
    }

}
