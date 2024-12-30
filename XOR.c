#include <stdio.h>

int main() {
    // Declare and initialize the string
    char str[] = "Hello world.";
    
    // Display the original string
    printf("Original string: %s\n", str);

    // Perform XOR operation with 0 on each character
    for (int i = 0; str[i] != '\0'; i++) {
        str[i] ^= 0; // XOR with 0 (no change occurs)
    }

    // Display the result
    printf("Resulting string after XOR with 0: %s\n", str);

    return 0;
}
