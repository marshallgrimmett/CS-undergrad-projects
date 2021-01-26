#include <stdio.h>

int main() {
	FILE* file1;
	FILE* file2;
	char buff[255];
	int i = 0;

	file1 = fopen("file1.txt", "w");
	file2 = fopen("file2.txt", "w");

	fprintf(file1, "Hello. This is an example program.");
	fclose(file1);
	file1 = fopen("file1.txt", "r");
	
	fgets(buff, 255, (FILE*)file1);

	printf("%s \n", buff);
	fprintf(file2, "%s", buff);

	fseek(file2, 15, SEEK_SET);

	fclose(file1);	
	fclose(file2);	

	return 0;
}
