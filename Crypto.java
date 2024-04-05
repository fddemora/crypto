import javax.crypto.BadPaddingException;
import symmetric.SymmetricAES;


public class Crypto {
    public static void main(String[] args) throws Exception {
        SymmetricAES aes = new SymmetricAES();
        byte[] cipher = aes.encryptPoc("this is my encrypted message.");
        aes.decryptPoc(cipher);

        aes = new SymmetricAES();

        try {
            aes.decryptPoc(cipher);
        } catch (BadPaddingException e) {
            System.out.println(e.getMessage());
        }
    }
}
