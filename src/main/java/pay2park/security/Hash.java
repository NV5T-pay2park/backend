package pay2park.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;

public class Hash {
    private static byte[] getSalt() throws NoSuchAlgorithmException, NoSuchProviderException {
        // Always use a SecureRandom generator
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG", "SUN");

        // Create array for salt
        byte[] salt = new byte[16];

        // Get a random salt
        sr.nextBytes(salt);

        // return salt
        return salt;
    }

    private static byte[] getSalt(String raw) {
        return raw.getBytes();
    }

    public static String getHash(String rawPassword) {
        String hashedPassword = null;
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-512");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        byte[] salt = getSalt("[B@42dafa95");
        md.update(salt);
        byte[] bytes = md.digest(rawPassword.getBytes());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16)
                    .substring(1));
        }
        hashedPassword = sb.toString();
        return hashedPassword;
    }

//    public static void main(String[] args) {
//        System.out.println("Hashed: " + Hash.getHash("12345678") + " len: " + Hash.getHash("12345678").length());
//    }
}
