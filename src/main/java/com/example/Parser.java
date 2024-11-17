package com.example;

import com.example.Token.TokenType;

public class Parser {
    private byte[] input;
    private int current;

    // defines Scanner and cursor
    private Scanner scan;
    private Token currentToken;

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

    // Method to match given TokenType with current TokenType
    private void match(TokenType t) {
        // Updated function to work based on the Scanner 
        if (currentToken.type == t) {
            nextToken();
        } else {
            // throw error if missmatch occurs
            throw new Error("Syntax error");
        }
    }

    // defining valid symbols in the grammar as 'functions'
    // so expr() calls digit() and oper()
    void expr() {
        number(); // this form makes obligatory that first char is an digit (?)
        oper();
    }

    // verifies if the currentToken type is of TokenType.NUMBER
    void number() {
        System.out.println("push " + currentToken.lexeme);
        match(TokenType.NUMBER);
    }

    // verifies if the currentToken is in the operators list + | - | ε
    void oper() {
        // checks if currentToken is of type +
        if (currentToken.type == TokenType.PLUS) {
            match(currentToken.type); // matches for sync
            number(); // checks for digit
            System.out.println("add"); // if no errors thrown, outs "add"
            oper(); // checks for operators again (part of the recursive implementation)
        } else if (currentToken.type == TokenType.MINUS) {
            // same as above but for '-'
            match(TokenType.MINUS);
            number();
            System.out.println("sub");
            oper();
        } else if (currentToken.type == TokenType.MULT) { // not sure if these are the best impl for multiplication and division
            // same as above but for '*'
            match(TokenType.MULT);
            number();
            System.out.println("mul");
            oper();
        } else if (currentToken.type == TokenType.DIV) {
            // same as above but for '/'
            match(TokenType.DIV);
            number();
            System.out.println("div");
            oper();
        }
    }

}
