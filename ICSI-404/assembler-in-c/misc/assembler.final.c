#include <stdio.h>
#include <string.h>
#include <stdlib.h>

char *ltrim(char *s) {
	while (*s == ' ' || *s == '\t') s++;
	return s;
}

char getRegister(char *text) {
  if (text == NULL) {
    return 0;
  }
	if (*text == 'r' || *text=='R') text++;
	return atoi(text);
}

int getAddress(char *text) {
  int address = atoi(text);
  if (address > 524286 || address < -524286) {
    printf("address exceeded range.\n");
    exit(-1);
  }
  else {
    return (address & 1048575);
  }
}

void threeR(int opcode, unsigned char* bytes) {
  bytes[0] = opcode;
  bytes[0] |= getRegister(strtok(NULL," "));
  bytes[1] = getRegister(strtok(NULL," ")) << 4 | getRegister(strtok(NULL," "));
  bytes[2] = 0;
  bytes[3] = 0;
}

void ai(int opcode, unsigned char* bytes) {
  bytes[0] = opcode;
  bytes[0] |= getRegister(strtok(NULL," "));
  int imm = atoi(strtok(NULL," "));
  if (imm > 127 || imm < -127) {
    printf("immediate value too large.\n");
    exit(-1);
  }
  bytes[1] = imm;
  bytes[2] = 0;
  bytes[3] = 0;
}

void br(int opcode, unsigned char* bytes) {
  bytes[0] = opcode;
  bytes[0] |= getRegister(strtok(NULL," "));
  bytes[1] = getRegister(strtok(NULL," ")) << 4;
  int addr = getAddress(strtok(NULL," "));
  bytes[1] |= addr >> 16;
  bytes[2] = addr >> 8;
  bytes[3] = addr;
}

void inter(int opcode, unsigned char* bytes) {
  bytes[0] = opcode;
  int num = atoi(strtok(NULL," "));
  if (num > 127 || num < -127) {
    printf("interrupt number too large.\n");
    exit(-1);
  }
  bytes[1] = num;
  bytes[2] = 0;
  bytes[3] = 0;
}

void jmp(int opcode, unsigned char* bytes) {
  bytes[0] = opcode;
  int num = atoi(strtok(NULL," "));
  if (num > 268435455 || num < 0) { // doc says max = 536870911, but only 28 bits available
    printf("jump address out of range.\n");
    exit(-1);
  }
  bytes[0] |= num >> 24;
  bytes[1] = num >> 16;
  bytes[2] = num >> 8;
  bytes[3] = num;
}

void iter(int opcode, unsigned char* bytes) {
  bytes[0] = opcode;
  bytes[0] |= getRegister(strtok(NULL," "));
  int num = atoi(strtok(NULL," "));
  if (num > 255 || num < 0) {
    printf("offset out of range.\n");
    exit(-1);
  }
  bytes[1] = num;
  num = atoi(strtok(NULL," "));
  if (num > 65535 || num < 0) {
    printf("jump address out of range.\n");
    exit(-1);
  }
  bytes[2] = num >> 8;
  bytes[3] = num;
}

void ls(int opcode, unsigned char* bytes) {
  bytes[0] = opcode;
  bytes[0] |= getRegister(strtok(NULL," "));
  bytes[1] = getRegister(strtok(NULL," ")) << 4;
  int num = atoi(strtok(NULL," "));
  if (num > 7 || num < -7) {
    printf("offset out of range.\n");
    exit(-1);
  }
  bytes[1] |= (num & 15);
  bytes[2] = 0;
  bytes[3] = 0;
}

void sft(int opcode, unsigned char* bytes, int isRtSft) {
  bytes[0] = opcode;
  bytes[0] |= getRegister(strtok(NULL," "));
  if (isRtSft) {bytes[1] = 0x20;}
  else {bytes[1] = 0;}
  int num = atoi(strtok(NULL," "));
  if (num > 15 || num < -15) {
    printf("shift amount out of range.\n");
    exit(-1);
  }
  num &= 31;
  bytes[1] |= num;
  bytes[2] = 0;
  bytes[3] = 0;
}

int assembleLine(char *text, unsigned char* bytes) {
	// text = ltrim(text);
	char *keyWord = strtok(text," \n\r\t");
  // printf("'%s'\n", text);
	if (strcmp(keyWord, "add") == 0) {
    threeR(0x10, bytes);
		return 2;
	}
  else if (strcmp(keyWord, "addimmediate") == 0) {
    ai(0x90, bytes);
    return 2;
  }
  else if (strcmp(keyWord, "and") == 0) {
    threeR(0x20, bytes);
    return 2;
  }
  else if (strcmp(keyWord, "branchifequal") == 0) {
    br(0xA0, bytes);
    return 4;
  }
  else if (strcmp(keyWord, "branchifless") == 0) {
    br(0xB0, bytes);
    return 4;
  }
  else if (strcmp(keyWord, "divide") == 0) {
    threeR(0x30, bytes);
    return 2;
  }
  else if (strcmp(keyWord, "halt") == 0) {
    threeR(0x00, bytes);
    return 2;
  }
  else if (strcmp(keyWord, "interrupt") == 0) {
    inter(0x80, bytes);
    return 2;
  }
  else if (strcmp(keyWord, "iterateover") == 0) {
    iter(0xD0, bytes);
    return 4;
  }
  else if (strcmp(keyWord, "jump") == 0) {
    jmp(0xC0, bytes);
    return 4;
  }
  else if (strcmp(keyWord, "leftshift") == 0) {
    sft(0x70, bytes, 0);
    return 2;
  }
  else if (strcmp(keyWord, "load") == 0) {
    ls(0xE0, bytes);
    return 2;
  }
  else if (strcmp(keyWord, "multiply") == 0) {
    threeR(0x40, bytes);
    return 2;
  }
  else if (strcmp(keyWord, "or") == 0) {
    threeR(0x60, bytes);
    return 2;
  }
  else if (strcmp(keyWord, "rightshift") == 0) {
    sft(0x70, bytes, 1);
    return 2;
  }
  else if (strcmp(keyWord, "store") == 0) {
    ls(0xF0, bytes);
    return 2;
  }
  else if (strcmp(keyWord, "subtract") == 0) {
    threeR(0x50, bytes);
    return 2;
  }
  else {
    printf("Invalid operation.\n");
    exit(-1);
  }
}

int main(int argc, char **argv) {
	FILE *src = fopen(argv[1],"r");
	FILE *dst = fopen(argv[2],"w");
	while (!feof(src)) {
		unsigned char bytes[4];
		char line[1000];
    // char *line;
    // size_t lineLen = 1000;
		// printf("\nabout to read\n");
    // if (getline(&line, &lineLen, src) != -1) {
		if (NULL != fgets(line, 1000, src)) {
			printf("\nread: %s",line);
			int byteCount = assembleLine(line,bytes);
			fwrite(bytes,byteCount,1,dst);
      printf("assembled line: %x %x %x %x\n", bytes[0], bytes[1], bytes[2], bytes[3]);
		}
	}
	fclose(src);
	fclose(dst);
	return 0;
}