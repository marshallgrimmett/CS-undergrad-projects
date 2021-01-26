#include <stdio.h>
#include <stdlib.h>
#include <string.h>

short parseLine(char *buffer);
short addOp(char *buffer);
short subtractOp(char *buffer);
short convertRegister(char *str);

int main(int argc, char *argv[]) {
  FILE *file;
  FILE *outFile;
	char *buffer;
	unsigned long fileLen;

  // open outfile
  outFile = fopen("outFile.bin", "wb");

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

  // get each line from input file
  short line;
  while (getline(&buffer, &fileLen, file) != -1) {
    // fprintf(outFile, "%x", (short int)parseLine(buffer)); // parse the line and print to output file
    line = (short)parseLine(buffer);
    fwrite((const void*)&line, sizeof(line), 1, outFile);
  }

  /*
  112324561c23
  DC1 # $ V FS #
  */

  // close files and free buffer
	fclose(outFile);
  fclose(file);
  free(buffer);

  return 0;
}

short parseLine(char *buffer) {
  char *token = strtok(buffer, " \n");
  
  if (strcmp(token, "add") == 0) {
    return addOp(token);
  } 
  else if (strcmp(token, "addimmediate ") == 0) {
    return 0;
  }
  else if (strcmp(token, "and ") == 0) {
    return 0;
  }
  else if (strcmp(token, "branchifequal ") == 0) {
    return 0;
  }
  else if (strcmp(token, "branchifless ") == 0) {
    return 0;
  }
  else if (strcmp(token, "divide ") == 0) {
    return 0;
  }
  else if (strcmp(token, "halt ") == 0) {
    return 0;
  }
  else if (strcmp(token, "interrupt ") == 0) {
    return 0;
  }
  else if (strcmp(token, "iterateover ") == 0) {
    return 0;
  }
  else if (strcmp(token, "jump ") == 0) {
    return 0;
  }
  else if (strcmp(token, "leftshift ") == 0) {
    return 0;
  }
  else if (strcmp(token, "load ") == 0) {
    return 0;
  }
  else if (strcmp(token, "multiply ") == 0) {
    return 0;
  }
  else if (strcmp(token, "or ") == 0) {
    return 0;
  }
  else if (strcmp(token, "rightshift ") == 0) {
    return 0;
  }
  else if (strcmp(token, "store ") == 0) {
    return 0;
  }
  else if (strcmp(token, "subtract") == 0) {
    return subtractOp(token);
  }
  else {
    printf("Invalid operation.\n");
    return -1;
  }
}

short addOp(char *token) {
  short assembled = 0x1000;
  short i = 8;

  token = strtok(NULL, " \n");
  while(token != NULL) {
    assembled = assembled | convertRegister(token) << i;
    token = strtok(NULL, " \n");
    i -= 4;
  }

  return assembled;
}

short subtractOp(char *token) {
  short assembled = 0x2000;
  short i = 8;

  token = strtok(NULL, " \n");
  while(token != NULL) {
    assembled = assembled | convertRegister(token) << i;
    token = strtok(NULL, " \n");
    i -= 4;
  }

  return assembled;
}

// need to check if register is between 0 and 16
short convertRegister(char *str) {
  if (*str != 'r') {
    return -1;
  }
  str++;
  return (short)strtol(str, 0, 10);
}
