#include <stdio.h>

int main() {

	// C is static and weak typed

	// Weak typing in C
	int num;
	num = 7;
	num = num + "Hello";
	printf("%d \n", num);

	// Prints: 103935913

	return 0;
}
