#include <stdio.h>

int main() {
	int *p, i;
	i = 20;

	printf("%d\n", *p);
	printf("%p\n", p);
	printf("%d\n", i);
	printf("%p\n", &i);

	char arr[] = "Hello";

	for (i = 0; i < sizeof(arr); i++) {
		printf("%p\n", &arr[i]);
	}

	return 0;
}
