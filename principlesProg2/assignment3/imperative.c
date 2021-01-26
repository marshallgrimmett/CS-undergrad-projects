#include <stdio.h>

// This simple program counts zeros in a list of integers
// Outputs the number of zeros to the screen

int main() {
	int list[] = {0,1,4,6,0,2,0,0,5,5,4,0,3};    // List of integers
	size_t size = sizeof list / sizeof list[0];  // Size of the list
	int i;					     // For loop counter
	int count = 0;				     // Counts the number of zeros

	// Loops through list and counts all zeros
	for (i = 0; i < size; i++) {
		if (list[i] == 0)
			count++;
	}

	printf("Number of zeros: %d \n", count);

	return 0;
}
