package java_csv_dataHandling;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.*;
import java.util.Base64;

public class EncryptDecryptCSV {
    private static final String ALGORITHM = "AES";

    public static void main(String[] args) throws Exception {
        SecretKey secretKey = generateKey();

        // Encrypt and write to CSV
        String csvFilePath = "encrypted_employees.csv";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFilePath))) {
            writer.write("Name,Email,Salary");

            writer.newLine();
            writer.write(encrypt("John Doe", secretKey) + "," + encrypt("john.doe@example.com", secretKey) + "," + encrypt("75000", secretKey));
            writer.newLine();
        }

        // Decrypt and read from CSV
        try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) {
            String line = reader.readLine(); // Skip header
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                System.out.println("Name: " + decrypt(values[0], secretKey));
                System.out.println("Email: " + decrypt(values[1], secretKey));
                System.out.println("Salary: " + decrypt(values[2], secretKey));
            }
        }
    }

    private static SecretKey generateKey() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance(ALGORITHM);
        keyGen.init(128);
        return keyGen.generateKey();
    }

    private static String encrypt(String data, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedData = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encryptedData);
    }

    private static String decrypt(String encryptedData, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedData = cipher.doFinal(Base64.getDecoder().decode(encryptedData));
        return new String(decryptedData);
    }
}