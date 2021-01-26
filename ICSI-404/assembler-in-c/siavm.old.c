#include <stdio.h>
#include <stdlib.h>

#define MEM_SIZE 10000

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// Determine whether the instruction stores 2 bytes or 4 bytes
int fetch(unsigned char *memory, unsigned char buffer[4], unsigned int pc) {
  switch (memory[pc] >> 4) {
    case 0x0:
    case 0x1:
    case 0x2:
    case 0x3:
    case 0x4:
    case 0x5:
    case 0x6:
    case 0x7:
    case 0x8:
    case 0x9:
    case 0xE:
    case 0xF:
      buffer[0] = memory[pc];
      buffer[1] = memory[pc + 1];
      return (pc + 2);
    case 0xA:
    case 0xB:
    case 0xC:
    case 0xD:
      buffer[0] = memory[pc];
      buffer[1] = memory[pc + 1];
      buffer[2] = memory[pc + 2];
      buffer[3] = memory[pc + 3];
      return (pc + 4);
    default: printf("error in input file."); return -1;
  }
}

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// so far, only first 6 ops will use op1 and op2
void dispatch(unsigned char buffer[4], unsigned int registers[16], unsigned int *op1, unsigned int *op2) {
  switch (buffer[0] >> 4) {
    case 0x1:
    case 0x2:
    case 0x3:
    case 0x4:
    case 0x5:
    case 0x6:
      *op1 = registers[buffer[0] & 0x0F];
      *op2 = registers[buffer[1] >> 4];
      break;
    default: break;
  }
}

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
void execute(unsigned char buffer[4], unsigned int *result, unsigned int *op1, unsigned int *op2, int *halt) {
  switch (buffer[0] >> 4) {
    case 0x0:
      *halt = 1;
      break;
    case 0x1:
      *result = *op1 + *op2;
      break;
    case 0x2:
      *result = *op1 & *op2;
      break;
    case 0x3:
      *result = *op1 / *op2;
      break;
    case 0x4:
      *result = *op1 * *op2;
      break;
    case 0x5:
      *result = *op1 - *op2;
      break;
    case 0x6:
      *result = *op1 | *op2;
      break;
    default: break;
  }
}

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
void store(unsigned char buffer[4], unsigned int registers[16], unsigned int result) {
  switch (buffer[0] >> 4) {
    case 0x1:
    case 0x2:
    case 0x3:
    case 0x4:
    case 0x5:
    case 0x6:
      registers[buffer[1] & 0x0F] = result;
      break;
    default: break;
  }
}

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
void readFile(unsigned char *memory, char *fileName) {
  FILE *fp;
  long filelen;
  if ((fp = fopen(fileName, "rb")) == NULL) {
    printf("error opening file.");
    exit(1);
  }
  fseek(fp, 0, SEEK_END);
  filelen = ftell(fp);
  rewind(fp);
  fread(memory, filelen, 1, fp);
  fclose(fp);
}

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
int main(int argc, char *argv[]) {
  unsigned char *memory;
  unsigned int registers[16];
  unsigned int pc = 0, op1, op2, result;
  unsigned char buffer[4]; // stores current instruction
  int halt = 0; // flag indicating program should terminate

  if (argc != 2) {
    printf("invalid number of arguments.\n");
    return -1;
  }

  // allocate memory and load file into memory
  memory = (unsigned char *) malloc(sizeof(char) * MEM_SIZE);
  readFile(memory, argv[1]);
  // printf("%x\n", memory[0]);

  // testing
  registers[1] = 5;
  registers[2] = 4;
  registers[3] = 0;

  while (!halt) {
    // fetch
    pc = fetch(memory, buffer, pc);
    printf("%x %x\n", buffer[0], buffer[1]);
    // dispatch
    dispatch(buffer, registers, &op1, &op2);
    printf("op1:[%d] , op2:[%d]\n", op1, op2);
    // printf("%d %d\n", registers[1], registers[2]);
    // execute
    execute(buffer, &result, &op1, &op2, &halt);
    printf("result:[%d]\n", result);
    // store
    store(buffer, registers, result);
    // printf("register[3]:[%d]\n", registers[3]);
    printf("\n");
  }

  return 0;
}
