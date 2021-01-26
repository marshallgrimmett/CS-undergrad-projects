#include <stdio.h>

int main(void) {
	
	char str[100];
	char comment[100];
	int flag = 0;
	int i = 0;
	int j = 0;

	printf("Enter your line of code: \n");
	scanf("%s", str);

	// main loop reads characters until we find '/'
	for (i = 0; i < sizeof(str); i++) {
		if (str[i] == '*' && str[i+1] == '/' && flag == 1)
			break;

		if (flag == 1) {
			comment[j] = str[i];
			j++;
		}

		if (str[i] == '/' && str[i+1] == '*' && flag != 1) {
			flag = 1;
			i++;
		}

	}

	printf("%s \n", comment);

	return 0;
}
