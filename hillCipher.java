import java.util.Scanner;

public class hillCipher {

    // Function to encrypt plaintext using Hill Cipher
    public static String encrypt(String plaintext, int[][] keyMatrix) {
        plaintext = plaintext.toUpperCase().replaceAll("[^A-Z]", ""); // Normalize plaintext
        int blockSize = keyMatrix.length;
        int padding = (blockSize - (plaintext.length() % blockSize)) % blockSize;

        // Padding with 'X' to make the plaintext length a multiple of block size
        plaintext += "X".repeat(padding);

        StringBuilder ciphertext = new StringBuilder();
        for (int i = 0; i < plaintext.length(); i += blockSize) {
            int[] block = new int[blockSize];
            for (int j = 0; j < blockSize; j++) {
                block[j] = plaintext.charAt(i + j) - 'A';
            }
            int[] encryptedBlock = multiplyMatrix(block, keyMatrix);
            for (int val : encryptedBlock) {
                ciphertext.append((char) (val + 'A'));
            }
        }
        return ciphertext.toString();
    }

    // Function to decrypt ciphertext using Hill Cipher
    public static String decrypt(String ciphertext, int[][] inverseKeyMatrix) {
        int blockSize = inverseKeyMatrix.length;

        StringBuilder plaintext = new StringBuilder();
        for (int i = 0; i < ciphertext.length(); i += blockSize) {
            int[] block = new int[blockSize];
            for (int j = 0; j < blockSize; j++) {
                block[j] = ciphertext.charAt(i + j) - 'A';
            }
            int[] decryptedBlock = multiplyMatrix(block, inverseKeyMatrix);
            for (int val : decryptedBlock) {
                plaintext.append((char) ((val + 26) % 26 + 'A'));
            }
        }
        return plaintext.toString();
    }

    // Function to multiply vector by matrix modulo 26
    public static int[] multiplyMatrix(int[] vector, int[][] matrix) {
        int[] result = new int[vector.length];
        for (int i = 0; i < vector.length; i++) {
            result[i] = 0;
            for (int j = 0; j < vector.length; j++) {
                result[i] += vector[j] * matrix[i][j];
            }
            result[i] %= 26;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input plaintext
        System.out.println("Enter the plaintext: ");
        String plaintext = scanner.nextLine();

        // Define a 2x2 key matrix (example: [3, 3], [2, 5])
        int[][] keyMatrix = {
            {3, 3},
            {2, 5}
        };

        // Inverse of the key matrix modulo 26
        int[][] inverseKeyMatrix = {
            {15, 17},
            {20, 9}
        };

        // Encrypt the plaintext
        String encryptedText = encrypt(plaintext, keyMatrix);
        System.out.println("Encrypted text: " + encryptedText);

        // Decrypt the ciphertext
        String decryptedText = decrypt(encryptedText, inverseKeyMatrix);
        System.out.println("Decrypted text: " + decryptedText);

        scanner.close();
    }
}
