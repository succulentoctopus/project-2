import java.util.ArrayList;
import java.util.List;

public class SubstitutionCipher extends Cipher {
    //private long key;

    public SubstitutionCipher(long k) {
        super(k);
    }

    public List<Character> encrypt(List<Character> cleartext) {
        List<Character> encryptedText = new ArrayList<>(cleartext.size());
        for (int i = 0; i < cleartext.size(); i++) {
            char c = cleartext.get(i);
            //do something to c
            encryptedText.set(i, c);
        }

        return encryptedText;

    }

    public List<Character> decrypt(List<Character> ciphertext) {
        List<Character> decryptedText = new ArrayList<>(ciphertext.size());
        for (int i = 0; i < ciphertext.size(); i++) {
            char c = ciphertext.get(i);
            //do something to c
            decryptedText.set(i, c);
        }

        return decryptedText;
    }


}
