#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main() {
  void ReadFile2(char *name);

  ReadFile2("outFile.bin");

  return 0;
}

void ReadFile2(char *name) {
  FILE *file;
	char *buffer;
	unsigned long fileLen;

	//Open file
	file = fopen(name, "rb");
	if (!file) {
		fprintf(stderr, "Unable to open file %s", name);
		return;
	}
	
	//Get file length
	fseek(file, 0, SEEK_END);
	fileLen = ftell(file);
	fseek(file, 0, SEEK_SET);

	//Allocate memory
	buffer = (char *)malloc(8);
	if (!buffer) {
		fprintf(stderr, "Memory error!");
    fclose(file);
		return;
	}

  // do stuff

  fread(buffer, sizeof(short), 1, file);
  short c = strtol(buffer, 0, 2);
  // printf("%s = %c = %d = 0x%.2X\n", buffer, c, c, c);
  printf("%x\n", *buffer);

	fclose(file);
	free(buffer);
}