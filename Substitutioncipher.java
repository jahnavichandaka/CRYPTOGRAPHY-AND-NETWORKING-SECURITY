import java.util.Scanner;

public class substitution {
    // Define the substitution key
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String SUBSTITUTION_KEY = "QWERTYUIOPASDFGHJKLZXCVBNM";

    public static String encrypt(String plaintext) {
        StringBuilder ciphertext = new StringBuilder();
        
        // Loop through each character in the plaintext
        for (char ch : plaintext.toUpperCase().toCharArray()) {
            if (Character.isLetter(ch)) {
                int index = ALPHABET.indexOf(ch);
                ciphertext.append(SUBSTITUTION_KEY.charAt(index));
            } else {
                ciphertext.append(ch); // Leave non-alphabet characters unchanged
            }
        }
        return ciphertext.toString();
    }

    public static String decrypt(String ciphertext) {
        StringBuilder plaintext = new StringBuilder();
        
        // Loop through each character in the ciphertext
        for (char ch : ciphertext.toUpperCase().toCharArray()) {
            if (Character.isLetter(ch)) {
                int index = SUBSTITUTION_KEY.indexOf(ch);
                plaintext.append(ALPHABET.charAt(index));
            } else {
                plaintext.append(ch); // Leave non-alphabet characters unchanged
            }
        }
        return plaintext.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input plaintext from user
        System.out.println("Enter the plaintext: ");
        String plaintext = scanner.nextLine();

        // Encrypt the plaintext
        String encryptedText = encrypt(plaintext);
        System.out.println("Encrypted text: " + encryptedText);

        // Decrypt the ciphertext
        String decryptedText = decrypt(encryptedText);
        System.out.println("Decrypted text: " + decryptedText);

        scanner.close();
    }
}
