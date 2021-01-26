#include <stdio.h>

int main() {
	const int n = 3;

	int first_zero_row = -1;              /* none */ 
	int i, j; 

	int A[n][n] = {
		{0,1,2},
		{0,0,0},
		{0,6,0}
	};

	/*
	for (i = 0; i < n; i++) { 
	     for (j = 0; j < n; j++) { 
	          if (A[i][j]) goto next;
	     } 
	     first_zero_row = i; 
	     break; 
	next: ; 
	}
	*/

	for (i = 0; i < n; i++) { 
	     for (j = 0; j < n; j++) { 
	          if (A[i][j] != 0)
			  break;
	     } 
	     if (j == n) {
		     first_zero_row = i;
		     break;
	     }
	}

	// print array
	for (i = 0; i < n; i++) { 
	     for (j = 0; j < n; j++) { 
		     printf("%d ", A[i][j]); fflush(stdout);
	     } 
	     printf("\n"); fflush(stdout);
	}

	printf("First zero row: %d \n", first_zero_row + 1); fflush(stdout);

	return 0;
}
