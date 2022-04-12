import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class SubstitutionCipher extends Cipher {
    List<List<Character>> substKey;
    Random rand;

    public SubstitutionCipher(long k) {
        super(k);
        rand = new Random(k);
        substKey.add(new ArrayList<Character>());
        substKey.get(0).set(0, (char)0);
        substKey.get(0).set(1, (char)(rand.nextInt()*255));
        for (int i = 1; i < 255; i++) {
            substKey.add(new ArrayList<Character>());
            substKey.get(i).set(0, (char)i);
            char c = (char)(rand.nextInt()*255);
            for (int j = i - 1; j > 0; j--) {
                if (substKey.get(j).get(1) == c) {
                    c = (char) (rand.nextInt() * 255);
                    j = i;
                }
            }
            substKey.get(i).set(1, c);
            }
        }
        //first element is normal, second element is the code



    public List<Character> encrypt(List<Character> cleartext) {
        List<Character> encryptedText = new LinkedList<Character>();
        for (int i = 0; i < cleartext.size(); i++) {
            for (int j = 0; j < 255; j++) {
                if (cleartext.get(i) == substKey.get(j).get(0)) {
                    encryptedText.set(i, substKey.get(j).get(1));
                    break;
                }

            }
        }

        return encryptedText;

    }

    public List<Character> decrypt(List<Character> ciphertext) {
        List<Character> decryptedText = new ArrayList<>(ciphertext.size());
        for (int i = 0; i < ciphertext.size(); i++) {
            for (int j = 0; j < 255; j++) {
                if (ciphertext.get(i) == substKey.get(j).get(1)) {
                    decryptedText.set(i, substKey.get(j).get(0));
                    break;
                }
            }
        }

        return decryptedText;
    }

    //


}
