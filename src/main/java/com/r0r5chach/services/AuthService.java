package com.r0r5chach.services;

import static org.bson.Document.parse;

import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.bson.Document;

import com.mongodb.client.MongoCollection;

import spark.Request;
import spark.Response;

public class AuthService extends DBService {
    protected static String post(Request req, Response res) {
        Document query = parse(req.body());
        MongoCollection<Document> col = client.getCollection("users");
        if (col.countDocuments(query) < 0) {
            String token = "";
            do {
                token = generateToken();
                if (token.equals("")) {
                    res.status(500);
                    return "{\"response\":\"Generation failed\"}";
                }
            }while (tokenExists(token));
            
            Document update = new Document().append("token", token);
            col.updateOne(query, update);

            res.status(200);
            return token;
        }
        else {
            res.status(401);
            return "{\"response\":\"Incorrect username or password\"}";
        }
    }

    public static String options(Request req, Response res) {
        //TODO: return options availabe for auth service
        return "";
    }

    public static boolean tokenExists(String token) {
        Document query = new Document().append("token", token);
        if (client.getCollection("users").countDocuments(query) > 0) {
            return true;
        }
        else {
            return false;
        }
    }

    private static String generateToken() {
        String token = encodeHexString(generateBytes());
        if (token.equals("")) {
            return "";
        }
        else {
            return token;
        }
    }

    private static byte[] generateBytes() {
        try {
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(256);
            SecretKey secretKey = keyGen.generateKey();
            return secretKey.getEncoded();
        }
        catch (NoSuchAlgorithmException e) {
            System.out.println(e);
            return null;
        }
        
    }

    private static String byteToHex(byte num) {
        char[] hexDigits = new char[2];
        hexDigits[0] = Character.forDigit((num >> 4) & 0xF, 16);
        hexDigits[1] = Character.forDigit((num & 0xF), 16);
        return new String(hexDigits);
    }

    private static String encodeHexString(byte[] byteArray) {
        if (byteArray == null) {
            return "";
        }
        StringBuffer hexStringBuffer = new StringBuffer();
        for (int i = 0; i < byteArray.length; i++) {
            hexStringBuffer.append(byteToHex(byteArray[i]));
        }
        return hexStringBuffer.toString();
    }
}
