import java.util.Scanner;
public class affinecipher {

    // Function to encrypt a plaintext character
    public static String encrypt(String plaintext, int a, int b) {
        plaintext = plaintext.toUpperCase().replaceAll("[^A-Z]", ""); // Normalize input
        StringBuilder ciphertext = new StringBuilder();

        for (char ch : plaintext.toCharArray()) {
            int x = ch - 'A'; // Convert char to index (0-25)
            int c = (a * x + b) % 26; // Apply affine cipher formula
            ciphertext.append((char) (c + 'A')); // Convert back to char
        }

        return ciphertext.toString();
    }

    // Function to decrypt a ciphertext character
    public static String decrypt(String ciphertext, int a, int b) {
        ciphertext = ciphertext.toUpperCase().replaceAll("[^A-Z]", ""); // Normalize input
        StringBuilder plaintext = new StringBuilder();

        int aInverse = modularInverse(a, 26); // Calculate modular inverse of a
        for (char ch : ciphertext.toCharArray()) {
            int c = ch - 'A'; // Convert char to index (0-25)
            int x = (aInverse * (c - b + 26)) % 26; // Apply decryption formula
            plaintext.append((char) (x + 'A')); // Convert back to char
        }

        return plaintext.toString();
    }

    // Function to find modular inverse of a under mod m using extended Euclidean algorithm
    public static int modularInverse(int a, int m) {
        a = a % m;
        for (int x = 1; x < m; x++) {
            if ((a * x) % m == 1) {
                return x;
            }
        }
        throw new IllegalArgumentException("No modular inverse exists for the given 'a'.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Define parameters for the affine cipher
        int a = 3; // Multiplier
        int b = 12; // Additive constant

        // Get plaintext input
        System.out.println("Enter the plaintext: ");
        String plaintext = scanner.nextLine();

        // Encrypt the plaintext
        String encryptedText = encrypt(plaintext, a, b);
        System.out.println("Encrypted text: " + encryptedText);

        // Decrypt the ciphertext
        String decryptedText = decrypt(encryptedText, a, b);
        System.out.println("Decrypted text: " + decryptedText);

        scanner.close();
    }
}
