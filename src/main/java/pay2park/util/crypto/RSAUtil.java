package pay2park.util.crypto;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.*;
import java.util.Base64;

public class RSAUtil {

    private static final KeyFactory keyFactory;
    private static final Cipher cipher;

    static {
        try {
            keyFactory = KeyFactory.getInstance("RSA");
            cipher = Cipher.getInstance("RSA");
        } catch (Exception ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * Create PublicKey from string
     *
     * @author dungpqt
     *
     * @param pubkeyStr a public key in base64 encode
     *
<<<<<<< HEAD
     * @return java.pay2park.backend.security.PublicKey
=======
     * @return java.security.PublicKey
>>>>>>> 3d43c4f092068ce8600c0d3d88caa552bd63b807
     * */
    public static PublicKey stringToPublicKey(String pubkeyStr) throws InvalidKeySpecException {
        byte[] bytesKey = Base64.getDecoder().decode(pubkeyStr.getBytes());
        return keyFactory.generatePublic(new X509EncodedKeySpec(bytesKey));
    }

    /**
     * Create PrivateKey from string
     *
     * @author dungpqt
     *
     * @param prikeyStr a private key in base64 encode
     *
<<<<<<< HEAD
     * @return java.pay2park.backend.security.PrivateKey
=======
     * @return java.security.PrivateKey
>>>>>>> 3d43c4f092068ce8600c0d3d88caa552bd63b807
     * */
    public static PrivateKey stringToPrivateKey(String prikeyStr) throws InvalidKeySpecException {
        byte[] bytesKey = Base64.getDecoder().decode(prikeyStr.getBytes());
        return keyFactory.generatePrivate(new PKCS8EncodedKeySpec(bytesKey));
    }

    public static String encrypt(PublicKey pubkey, String message)
            throws IllegalBlockSizeException, BadPaddingException, InvalidKeyException
    {
        cipher.init(Cipher.ENCRYPT_MODE, pubkey);
        return Base64.getEncoder().encodeToString(cipher.doFinal(message.getBytes()));
    }

    public static String encrypt(String pubkeyStr, String message)
            throws IllegalBlockSizeException, BadPaddingException, InvalidKeyException, InvalidKeySpecException
    {
        return encrypt(stringToPublicKey(pubkeyStr), message);
    }

    public static byte[] decrypt(PrivateKey prikey, String message)
            throws IllegalBlockSizeException, BadPaddingException, InvalidKeyException
    {
        cipher.init(Cipher.ENCRYPT_MODE, prikey);
        return cipher.doFinal(message.getBytes());
    }

    public static byte[] decrypt(String prikeyStr, String message)
            throws IllegalBlockSizeException, BadPaddingException, InvalidKeyException, InvalidKeySpecException
    {
        return decrypt(stringToPrivateKey(prikeyStr), message);
    }
}
