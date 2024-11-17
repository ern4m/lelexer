package com.example;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.example.Token.TokenType;

public class Scanner {
    private byte[] input;
    private int current;

    private static final Map<String, TokenType> keywords;

    static {
        keywords = new HashMap<>();
        keywords.put("let", TokenType.LET);
    }

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

    // Handling numbers as Token
    private Token number() {
        int start = current;
        while (Character.isDigit(peek())) {
            advance();
        }
        String n = new String(input, start, current - start);
        return new Token(TokenType.NUMBER, n);
    }

    // Handling identifiers
    private Token identifier() {
        int start = current;
        while (isAlphanumeric(peek())) {
            advance();
        }

        String id = new String(input, start, current - start);
        // Checks if the type is an given entry in the hash map
        // So in case of "let" type will have type of TokenType.LET
        TokenType type = keywords.get(id);

        if (type == null) {
            // If not in the hashmap type will be of TokenType.IDENT
            type = TokenType.IDENT;
        }

        return new Token(type, id);
    }

    // Matches if is digit or oper and returns the char at current cursor
    // in this setup it only treats unique chars tokens
    public Token nextToken() {
        skiptWhiteSpace();
        // current cursor char
        char ch = peek();

        if (isAlpha(ch, false)) {
            return identifier();
        }

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
                advance();
                return new Token(TokenType.MULT, "*");
            case '/':
                advance();
                return new Token(TokenType.DIV, "/");
            case '=':
                advance();
                return new Token(TokenType.EQ, "=");
            case ';':
                advance();
                return new Token(TokenType.SEMICOLON, ";");
            default:
                break;
        }

        throw new Error("Lexical Error");
    }

    private void skiptWhiteSpace() {
        char ch = peek();
        while (ch == ' ' || ch == '\r' || ch == '\t' || ch == '\n') {
            advance();
            ch = peek();
        }
    }

    private boolean isAlpha(char c, boolean useRegex) {

        if (useRegex) {
            // Usando regex
            String regex = "^[a-zA-Z0-9]+$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(Character.toString(c));
            return matcher.matches();
        }

        return (c >= 'a' && c <= 'z') ||
                (c >= 'A' && c <= 'Z') ||
                c == '_';
    }

    private boolean isAlphanumeric(char c) {
        return isAlpha(c, false) || Character.isDigit(c);
    }
}
