package symmetric;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

public class SymmetricAES {

    public SymmetricAES() throws Exception {
        // Generate AES key
        keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(256);
        key = keyGenerator.generateKey();
        cipher = Cipher.getInstance("AES");
    }

    public byte[] encryptPoc(String arg) throws Exception {
        
        byte[] msg = arg.getBytes();
        
        // Configure cipher
        cipher.init(Cipher.ENCRYPT_MODE, key);

        // Generate & output ciphertext
        byte[] cipherTxt = cipher.doFinal(msg);
        String encrypted = new String(cipherTxt, "UTF8");
        System.out.println("Encryption: " + encrypted);

        return cipherTxt;
    }

    public byte[] decryptPoc(byte[] arg) throws Exception {


       // Decrypt Cipher
        cipher.init(Cipher.DECRYPT_MODE, key);
       byte[] msg;

        msg = cipher.doFinal(arg);
    
       String decrypt = new String(msg, "UTF8");
       System.out.println("Decrypted: " + decrypt);  
       return msg;   
    }

    private KeyGenerator keyGenerator;
    private Key key;
    private Cipher cipher;
}