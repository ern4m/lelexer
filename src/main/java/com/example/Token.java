package com.example;

public class Token {

    public enum TokenType {
        PLUS,
        MINUS,
        //Literals
        NUMBER,
        EOF,
    }

    final TokenType type;
    final String lexeme;

    public Token(TokenType type, String lexeme) {
        this.type = type;
        this.lexeme = lexeme;
    }

    public String toString() {
        return "<" +  type + ">" + lexeme + "</" +  type + ">";
    }
}
