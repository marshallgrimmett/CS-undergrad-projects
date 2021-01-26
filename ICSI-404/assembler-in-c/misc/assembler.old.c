#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int parseOp(char *op, unsigned long fileLen, FILE *file);
int addOp(char *buffer, unsigned long fileLen, FILE *file);
int subtractOp(char *buffer, unsigned long fileLen, FILE *file);
int convertRegister(char *str);

int main(int argc, char *argv[]) {
  FILE *file;
  FILE *outFile;
	char *buffer;
	unsigned long fileLen;

  // open outfile
  outFile = fopen("outFile.txt", "w");

	//Open file
	file = fopen(argv[1], "r");
	if (!file) {
		fprintf(stderr, "Unable to open file %s", argv[1]);
		return 0;
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
		return 0;
	}

  while (!feof(file)) {
    getdelim(&buffer, &fileLen, ' ', file);
    fprintf(outFile, "%x", parseOp(buffer, fileLen, file));
  }


	fclose(outFile);
  fclose(file);

  return 0;
}

// NOTE: case dependent
int parseOp(char *op, unsigned long fileLen, FILE *file) {
  if (strcmp(op, "add ") == 0) {
    return addOp(op, fileLen, file);
  } 
  else if (strcmp(op, "addimmediate ") == 0) {
    return 0;
  }
  else if (strcmp(op, "and ") == 0) {
    return 0;
  }
  else if (strcmp(op, "branchifequal ") == 0) {
    return 0;
  }
  else if (strcmp(op, "branchifless ") == 0) {
    return 0;
  }
  else if (strcmp(op, "divide ") == 0) {
    return 0;
  }
  else if (strcmp(op, "halt ") == 0) {
    return 0;
  }
  else if (strcmp(op, "interrupt ") == 0) {
    return 0;
  }
  else if (strcmp(op, "iterateover ") == 0) {
    return 0;
  }
  else if (strcmp(op, "jump ") == 0) {
    return 0;
  }
  else if (strcmp(op, "leftshift ") == 0) {
    return 0;
  }
  else if (strcmp(op, "load ") == 0) {
    return 0;
  }
  else if (strcmp(op, "multiply ") == 0) {
    return 0;
  }
  else if (strcmp(op, "or ") == 0) {
    return 0;
  }
  else if (strcmp(op, "rightshift ") == 0) {
    return 0;
  }
  else if (strcmp(op, "store ") == 0) {
    return 0;
  }
  else if (strcmp(op, "\nsubtract ") == 0) {
    return subtractOp(op, fileLen, file);
  }
  else {
    printf("Invalid operation.\n");
    return -1;
  }
}

int addOp(char *buffer, unsigned long fileLen, FILE *file) {
  int assembled = 0x1000;
  
  getdelim(&buffer, &fileLen, ' ', file);
  assembled = assembled | (convertRegister(buffer) << 8);

  getdelim(&buffer, &fileLen, ' ', file);
  assembled = assembled | (convertRegister(buffer) << 4);

  getdelim(&buffer, &fileLen, ' ', file);
  assembled = assembled | convertRegister(buffer);

  return assembled;
}

int subtractOp(char *buffer, unsigned long fileLen, FILE *file) {
  int assembled = 0x2000;
  
  getdelim(&buffer, &fileLen, ' ', file);
  assembled = assembled | (convertRegister(buffer) << 8);

  getdelim(&buffer, &fileLen, ' ', file);
  assembled = assembled | (convertRegister(buffer) << 4);

  getdelim(&buffer, &fileLen, ' ', file);
  assembled = assembled | convertRegister(buffer);

  return assembled;
}

// only converts r0 to r9
int convertRegister(char *str) {
  if (*str != 'r') {
    return -1;
  }

  str++;

  return ((int)*str - 48);
}
