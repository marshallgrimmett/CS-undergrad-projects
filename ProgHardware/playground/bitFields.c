#include <stdio.h>

int main() {
	struct device {
		unsigned int a1 : 1;
		unsigned int a2 : 1;
		unsigned int a3 : 1;
		unsigned int a4 : 1;
		unsigned int : 2;
		unsigned int a6 : 1;
	} code;

	printf("%d\n", (int)sizeof(code));

	return 0;
}
