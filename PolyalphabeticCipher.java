import java.util.Scanner;
public class PolyalphabeticCipher {
    // Method to encrypt plaintext using the Vigenère Cipher
    public static String encrypt(String plaintext, String key) {
        StringBuilder encryptedText = new StringBuilder();
        key = key.toUpperCase();
        int keyIndex = 0;
        for (char c : plaintext.toCharArray()) {
            if (Character.isLetter(c)) {
                boolean isUpperCase = Character.isUpperCase(c);
                char base = isUpperCase ? 'A' : 'a';
                int shift = key.charAt(keyIndex) - 'A';
                char encryptedChar = (char) ((c - base + shift) % 26 + base);
                encryptedText.append(encryptedChar);
                // Move to the next key character
                keyIndex = (keyIndex + 1) % key.length();
            } else {
                // Keep non-alphabetic characters unchanged
                encryptedText.append(c);
            }
        }
        return encryptedText.toString();
    }
    // Method to decrypt ciphertext using the Vigenère Cipher
    public static String decrypt(String ciphertext, String key) {
        StringBuilder decryptedText = new StringBuilder();
        key = key.toUpperCase();
        int keyIndex = 0;
        for (char c : ciphertext.toCharArray()) {
            if (Character.isLetter(c)) {
                boolean isUpperCase = Character.isUpperCase(c);
                char base = isUpperCase ? 'A' : 'a';
                int shift = key.charAt(keyIndex) - 'A';
                char decryptedChar = (char) ((c - base - shift + 26) % 26 + base);
                decryptedText.append(decryptedChar);
                // Move to the next key character
                keyIndex = (keyIndex + 1) % key.length();
            } else {
                // Keep non-alphabetic characters unchanged
                decryptedText.append(c);
            }
        }
        return decryptedText.toString();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Input plaintext and key
        System.out.print("Enter plaintext: ");
        String plaintext = scanner.nextLine();
        System.out.print("Enter key: ");
        String key = scanner.nextLine();
        // Encrypt plaintext
        String encryptedText = encrypt(plaintext, key);
        System.out.println("Encrypted Text: " + encryptedText);
        // Decrypt ciphertext
        String decryptedText = decrypt(encryptedText, key);
        System.out.println("Decrypted Text: " + decryptedText);
    }
}
