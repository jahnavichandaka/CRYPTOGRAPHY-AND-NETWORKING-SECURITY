#include <stdio.h>
int main() {
    // Declare and initialize the string
    char str[] = "Hello world.";
    // Display the original string
    printf("Original string: %s\n", str);
    // Perform XOR operation with 127 on each character
    printf("String after XOR with 127: ");
    for (int i = 0; str[i] != '\0'; i++) {
        char xor_char = str[i] ^ 127;
        printf("%c", xor_char);
    }
    printf("\n");
    // Perform AND operation with 127 on each character
    printf("String after AND with 127: ");
    for (int i = 0; str[i] != '\0'; i++) {
        char and_char = str[i] & 127;
        printf("%c", and_char);
    }
    printf("\n");
    return 0;
}
