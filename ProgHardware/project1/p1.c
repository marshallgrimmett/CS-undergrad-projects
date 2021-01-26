/*
Name: Marshall Grimmett
Unix ID: MG475621
Lab Instructor: Vaidyanathan Subramanian
Lab Day/Time: Wednesday 4:15pm

Description: This program converts an integer from decimal to
	base 2 all the way up to base 16.
Input: 2 integer values, the first being the 
	value to be converted and the second being
	the radix, or the base it will convert into.
Output: An array of characters representing the value
	converted into the base equivalent to the radix. 
Assumptions: The value is a nonnegative decimal integer.
	and the radix is an integer from 2 to 16.
*/

#include <stdio.h>

// The maximum size for an integer converted to base 2
#define MAX 32

/* printResult
Prints the resulting char array in reverse order since the 
values are stored in reverse by the algorithm
Parameters:
char a[] - stores the result to be printed
int i - stores the position of the first element
*/
void printResult(char a[], int i);

/* convertToChar
Returns a decimal value converted to it's representation in
Hexadecimal. (still applies to bases below 16)
Parameters:
int a - the value to be converted
*/
char convertToChar(int a);

int main(void) {
	// The decimal value, radix, and a temporary placeholder for modulus 
	unsigned int val, rad, temp;

	// The result in an array of chars
	char result[MAX] = "0";

	// keeps track of the first position in the array
	int i = 0;

	// Read in user input for val and rad
	printf("Enter two integers: "); fflush (stdout);
	scanf("%d %d", &val, &rad);

	// Loop to perform the conversion one char at a time
	// Gets the remainder of each division by the radix
	// And converts it to base 16, stops when we hit 0
	// i keeps track of the position in the array
	do {
		temp = val % rad;
		result[i] = convertToChar(temp);
		val /= rad;
		i++;
	} while (val != 0);

	// prints the array in reverse order
	printResult(result, i);

	return 0;
}

void printResult(char a[], int i) {
	printf("Answer = "); fflush (stdout);

	// starts at the last position and prints back to front
	for (i = i; i > 0; i--)
		printf("%c", a[i - 1]); fflush (stdout); 

	printf("\n"); fflush (stdout);
}

char convertToChar(int a) {
	char result;	// stores the converted char value

	// switch to determine base 16 representation
	switch (a) {
		case 0: result = '0'; break;
		case 1: result = '1'; break;
		case 2: result = '2'; break;
		case 3: result = '3'; break;
		case 4: result = '4'; break;
		case 5: result = '5'; break;
		case 6: result = '6'; break;
		case 7: result = '7'; break;
		case 8: result = '8'; break;
		case 9: result = '9'; break;
		case 10: result = 'A'; break;
		case 11: result = 'B'; break;
		case 12: result = 'C'; break;
		case 13: result = 'D'; break;
		case 14: result = 'E'; break;
		case 15: result = 'F'; break;
		defalut: break;
	}
	
	return result;
}
