package com.example;

public class Token {

    public enum TokenType {
        PLUS,
        MINUS,
        MULT,
        DIV,
        EQ,
        SEMICOLON,
        // Literals
        NUMBER,
        IDENT,
        LET,
        PRINT,
        EOF,
    }

    final TokenType type;
    final String lexeme;

    public Token(TokenType type, String lexeme) {
        this.type = type;
        this.lexeme = lexeme;
    }

    public String toString() {
        return "<" + type + ">" + lexeme + "</" + type + ">";
    }
}
