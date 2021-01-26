#include <stdio.h>

int main(void) {
	int arr[] = {7, -14};
	int *p = arr;
	int y;

	// y gets the previous value of p
	y = *(p++); printf("\n %d %d \n", y, *p);
	y = (*p)++; printf("%d %d \n\n", y, *p);

	return 0;
}
