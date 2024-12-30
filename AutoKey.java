import java.util.Scanner;
public class AutoKey {
    // Function to encrypt the plaintext using AutoKey cipher
    public static String encrypt(String plaintext, String key) {
        // Convert both plaintext and key to uppercase
        plaintext = plaintext.toUpperCase();
        key = key.toUpperCase();
        StringBuilder ciphertext = new StringBuilder();
        int keyIndex = 0;
        // Encrypt the plaintext
        for (int i = 0; i < plaintext.length(); i++) {
            char p = plaintext.charAt(i);
            // Only encrypt alphabetic characters
            if (Character.isAlphabetic(p)) {
                // Get the current key letter (the key expands with the plaintext)
                char k = key.charAt(keyIndex);
                // Apply Vigenère encryption (shift based on key character)
                int shift = k - 'A';
                char c = (char) ((p - 'A' + shift) % 26 + 'A');
                ciphertext.append(c);
                // Update key with the current plaintext character (AutoKey mechanism)
                key += p;
                keyIndex++;
            } else {
                // Non-alphabet characters are added to the ciphertext without encryption
                ciphertext.append(p);
            }
        }
        return ciphertext.toString();
    }
    // Function to decrypt the ciphertext using AutoKey cipher
    public static String decrypt(String ciphertext, String key) {
        // Convert both ciphertext and key to uppercase
        ciphertext = ciphertext.toUpperCase();
        key = key.toUpperCase();   
        StringBuilder plaintext = new StringBuilder();
        int keyIndex = 0;
        // Decrypt the ciphertext
        for (int i = 0; i < ciphertext.length(); i++) {
            char c = ciphertext.charAt(i);
            // Only decrypt alphabetic characters
            if (Character.isAlphabetic(c)) {
                // Get the current key letter
                char k = key.charAt(keyIndex);                
                // Apply Vigenère decryption (reverse shift based on key character)
                int shift = k - 'A';
                char p = (char) ((c - 'A' - shift + 26) % 26 + 'A');
                plaintext.append(p);               
                // Update key with the current decrypted character (AutoKey mechanism)
                key += p;
                keyIndex++;
            } else {
                // Non-alphabet characters are added to the plaintext without decryption
                plaintext.append(c);
            }
        }
        
        return plaintext.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter plaintext: ");
        String plaintext = scanner.nextLine();
        
        System.out.print("Enter key: ");
        String key = scanner.nextLine();
        
        // Encrypt the plaintext
        String ciphertext = encrypt(plaintext, key);
        System.out.println("Ciphertext: " + ciphertext);
        
        // Decrypt the ciphertext
        String decryptedText = decrypt(ciphertext, key);
        System.out.println("Decrypted text: " + decryptedText);
    }
}

