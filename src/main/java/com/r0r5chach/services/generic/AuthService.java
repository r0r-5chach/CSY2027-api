package com.r0r5chach.services.generic;

import static org.bson.Document.parse;
import static spark.Spark.halt;

import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.bson.Document;

import com.mongodb.client.MongoCollection;

import spark.Request;
import spark.Response;

public class AuthService extends DBService {
    public String post(Request req, Response res) { 
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

    public String options(Request req, Response res) {
        //TODO: return options available for auth service
        return "";
    }

    private static boolean tokenExists(String token) {
        Document query = new Document().append("token", token);
        if (client.getCollection("users").countDocuments(query) > 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public static Access tokenAccess(String token) {
        Document doc = new Document().append("token", token);
        doc = client.getCollection("users").find(doc).first();
        return Access.valueOf(doc.getString("access"));
        //TODO: return the access level of the apitoken
    }

    private String generateToken() {
        String token = encodeHexString(generateBytes());
        if (token.equals("")) {
            return "";
        }
        else {
            return token;
        }
    }

    private byte[] generateBytes() {
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

    private String byteToHex(byte num) {
        char[] hexDigits = new char[2];
        hexDigits[0] = Character.forDigit((num >> 4) & 0xF, 16);
        hexDigits[1] = Character.forDigit((num & 0xF), 16);
        return new String(hexDigits);
    }

    private String encodeHexString(byte[] byteArray) {
        if (byteArray == null) {
            return "";
        }
        StringBuffer hexStringBuffer = new StringBuffer();
        for (int i = 0; i < byteArray.length; i++) {
            hexStringBuffer.append(byteToHex(byteArray[i]));
        }
        return hexStringBuffer.toString();
    }

    public static void tokenAuth(Request req, Response res) {
        String token = req.queryMap().get("token").value();
        if (!tokenExists(token)) {
            halt(401, "Unauthorized");
        }
    }

    public static void adminAuth(Request req, Response res) {
        String token = req.queryMap().get("token").value();
        if (tokenAccess(token) != Access.ADMIN) {
            halt(401, "Unauthorized");
        }
    }

    public static void staffAuth(Request req, Response res) {
        String token = req.queryMap().get("token").value();
        if (tokenAccess(token) != Access.STAFF) {
            halt(401, "Unauthorized");
        }
    }

    public static void studentAuth(Request req, Response res) {
        String token = req.queryMap().get("token").value();
        if (tokenAccess(token) != Access.STUDENT) {
            halt(401, "Unauthorized");
        }
    }
}