 import java.util.Scanner;
public class CaesarCipher {
public static String encrypt(String text, int shift) {
StringBuilder result = new StringBuilder();
shift = shift % 26; 
for (char character : text.toCharArray()) {
if (Character.isLetter(character)) {
char base = Character.isUpperCase(character) ? 'A' : 'a';
char encryptedChar = (char) ((character - base + shift + 26) % 26 + base);
result.append(encryptedChar);
} else {
result.append(character); 
}
}
return result.toString();
}public static String decrypt(String text, int shift) {
return encrypt(text, 26 - (shift % 26)); 
}
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
System.out.println("Caesar Cipher Implementation");
System.out.print("Enter the text to encrypt: ");
String plaintext = scanner.nextLine();
System.out.print("Enter the shift key (integer): ");
int shift = scanner.nextInt();
scanner.nextLine(); 
String encryptedText = encrypt(plaintext, shift);
System.out.println("Encrypted Text: " + encryptedText);
String decryptedText = decrypt(encryptedText, shift);
System.out.println("Decrypted Text: " + decryptedText);
scanner.close();
}
}
