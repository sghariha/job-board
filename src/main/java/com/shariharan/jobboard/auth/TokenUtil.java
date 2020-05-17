package com.shariharan.jobboard.auth;

import com.shariharan.jobboard.error_handlers.InvalidTokenException;

import org.springframework.beans.factory.annotation.Autowired;

public class TokenUtil {
    private static final int HEX_BASE = 16;

    public static String createToken(String email, String id, String userType) {
        StringBuilder userInfo = new StringBuilder();
        userInfo.append(email);
        userInfo.append(id);

        StringBuilder token = new StringBuilder();

        token.append(Integer.toHexString(email.length()) + "-");
        token.append(Integer.toHexString(id.length()) + "-");

        for (int i = 0; i < email.length(); i++) {
            char converted = email.charAt(i);
            String hexValue = Integer.toHexString(converted);
            token.append(hexValue);
        }

        for (int i = 0; i < id.length(); i++) {
            char converted = id.charAt(i);
            String hexValue = Integer.toHexString(converted);
            token.append(hexValue);
        }

        token.append(userType);

        return token.toString();
    }

    public static TokenPayload decodeToken(String token) throws InvalidTokenException {
        if (token == null || token.length() == 0) {
            System.out.println("first throws");
            throw new InvalidTokenException("Null or empty token");
        }
        int emailLength, idLength;
        String userType, email, id;
        int i = 0;

        String[] lines = token.split("-");
        System.out.println(lines.length);

        if (lines.length != 3) {
            throw new InvalidTokenException("Null or empty token");
        }

        String tokenEmailLength = lines[0];
        emailLength = Integer.parseInt(tokenEmailLength, HEX_BASE);

        String tokenPasswordLength = lines[1];
        idLength = Integer.parseInt(tokenPasswordLength, HEX_BASE);

        int emailEnd = emailLength * 2;
        int passwordEnd = emailEnd + (idLength * 2);

        StringBuilder decodedEmail = new StringBuilder();
        StringBuilder decodedPassword = new StringBuilder();

        while (i < emailEnd) {
            String toDecode = "" + lines[2].charAt(i) + lines[2].charAt(i + 1);
            char decodedChar = (char) (Integer.parseInt(toDecode, HEX_BASE));
            decodedEmail.append(decodedChar);
            i += 2;
        }

        while (i < passwordEnd) {
            String toDecode = "" + lines[2].charAt(i) + lines[2].charAt(i + 1);
            char decodedChar = (char) (Integer.parseInt(toDecode, HEX_BASE));
            decodedPassword.append(decodedChar);
            i += 2;
        }

        email = decodedEmail.toString();
        id = decodedPassword.toString();
        userType = lines[2].substring(lines[2].length() - 1);

        return new TokenPayload(email, id, userType);
    }
}