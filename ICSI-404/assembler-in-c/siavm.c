#include <stdio.h>
#include <stdlib.h>

/**
 * Author: Marshall Grimmett
 * Course: ICSI 404
 * Prof: M. Phipps
 * Time: Tues/Thurs 8:45 am
 * 
 * Description: This is a vm for assembled SIA code. The vm allocates 10KB of memory to be used.
 * There are also 16 registers, a program counter, 2 operands, and a result.
 * The program will run until a halt command is executed or the there are no more instructions.
 * 
 * Usage: ./siavm outFile.bin
 * 
 */

#define MEM_SIZE 10000

#define HALT 0x0
#define ADD 0x1
#define AND 0x2
#define DIVIDE 0x3
#define MULTIPLY 0x4
#define SUBTRACT 0x5
#define OR 0x6
#define SHIFT 0x7
#define INTERRUPT 0x8
#define ADDIMMEDIATE 0x9
#define BRANCHIFEQUAL 0xA
#define BRANCHIFLESS 0xB
#define JUMP 0xC
#define ITERATEOVER 0xD
#define LOAD 0xE
#define STORE 0xF

unsigned char *memory;
unsigned int registers[16];
unsigned int pc = 0, op1, op2, result;
unsigned char buffer[4]; // stores current instruction
int halt = 0; // flag indicating program should terminate

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
void printRegisters() {
  for (int i = 0; i < 16; i++)
    printf("Register %d: [%d]\n", i, registers[i]);
  printf("\n");
}

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
void printAll() {
  printRegisters();
  printf("pc:[%d], op1:[%d], op2:[%d], result:[%d]\n", pc, op1, op2, result);
  printf("\n");
}

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
void printMemory() {
  for (int i = MEM_SIZE; i > 0; i--)
    printf("Memory %d: [%d]\n", i, memory[i]);
  printf("\n");
}

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// Determine whether the instruction stores 2 bytes or 4 bytes
int fetch() {
  switch (memory[pc] >> 4) {
    case HALT:
    case ADD:
    case AND:
    case DIVIDE:
    case MULTIPLY:
    case SUBTRACT:
    case OR:
    case SHIFT:
    case INTERRUPT:
    case ADDIMMEDIATE:
    case LOAD:
    case STORE:
      buffer[0] = memory[pc];
      buffer[1] = memory[pc + 1];
      return (pc + 2);
    case BRANCHIFEQUAL:
    case BRANCHIFLESS:
    case JUMP:
    case ITERATEOVER:
      buffer[0] = memory[pc];
      buffer[1] = memory[pc + 1];
      buffer[2] = memory[pc + 2];
      buffer[3] = memory[pc + 3];
      return (pc + 4);
    default: printf("error in input file."); exit(1);
  }
}

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
void dispatch() {
  switch (buffer[0] >> 4) {
    case ADD:
    case AND:
    case DIVIDE:
    case MULTIPLY:
    case SUBTRACT:
    case OR:
      op1 = registers[buffer[0] & 0x0F];
      op2 = registers[buffer[1] >> 4];
      break;
    case SHIFT:
      op1 = registers[buffer[0] & 0x0F];
      op2 = buffer[1] & 0x1F;
      break;
    case INTERRUPT:
      op1 = ((buffer[0] & 0x0F) << 8) + buffer[1];
      break;
    case ADDIMMEDIATE:
      op1 = registers[buffer[0] & 0x0F];
      op2 = buffer[1];
      break;
    case BRANCHIFEQUAL:
    case BRANCHIFLESS:
      op1 = registers[buffer[0] & 0x0F];
      op2 = registers[buffer[1] >> 4];
      break;
    case JUMP:
      op1 = ((buffer[0] & 0x0F) << 8) + buffer[1];
      op1 = (pc << 8) + buffer[2];
      op1 = (pc << 8) + buffer[3];
      break;
    case ITERATEOVER:
      op1 = buffer[1];
      op2 = (buffer[2] << 8) + buffer[3] + 4; // 4 accounts for the intruction itself
      break;
    case LOAD:
      op1 = buffer[0] & 0x0F;
      op2 = registers[buffer[1] >> 4] + (buffer[1] & 0x0F);
      break;
    case STORE:
      op1 = registers[buffer[0] & 0x0F];
      op2 = registers[buffer[1] >> 4] + (buffer[1] & 0x0F);
      break;
    default: break;
  }
}

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
void execute() {
  switch (buffer[0] >> 4) {
    case HALT:
      halt = 1;
      break;
    case ADDIMMEDIATE:
    case ADD:
      result = op1 + op2;
      break;
    case AND:
      result = op1 & op2;
      break;
    case DIVIDE:
      result = op1 / op2;
      break;
    case MULTIPLY:
      result = op1 * op2;
      break;
    case SUBTRACT:
      result = op1 - op2;
      break;
    case OR:
      result = op1 | op2;
      break;
    case SHIFT:
      if (buffer[1] & 0x20) result = op1 >> op2;
      else result = op1 << op2;
      break;
    case INTERRUPT:
      if (op1 == 0) printRegisters();
      else if(op1 == 1) printMemory();
      else printf("Invalid interrupt number.");
      break;
    case BRANCHIFEQUAL:
      if (op1 == op2) {
        op1 = ((buffer[1] & 0x0F) << 8) + buffer[2];
        op1 = (op1 << 8) + buffer[3];
        pc += op1;
      }
      break;
    case BRANCHIFLESS:
      if (op1 < op2) {
        op1 = ((buffer[1] & 0x0F) << 8) + buffer[2];
        op1 = (op1 << 8) + buffer[3];
        pc += op1;
      }
      break;
    case JUMP:
      pc = ((buffer[0] & 0x0F) << 8) + buffer[1];
      pc = (pc << 8) + buffer[2];
      pc = (pc << 8) + buffer[3];
      break;
    case ITERATEOVER:
      registers[buffer[0] & 0x0F] = registers[buffer[0] & 0x0F] + op1;
      if (memory[registers[buffer[0] & 0x0F]] != 0) pc -= op2;
      break;
    default: break;
  }
}

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
void store() {
  switch (buffer[0] >> 4) {
    case ADD:
    case AND:
    case DIVIDE:
    case MULTIPLY:
    case SUBTRACT:
    case OR:
      registers[buffer[1] & 0x0F] = result;
      break;
    case ADDIMMEDIATE:
      registers[buffer[0] & 0x0F] = result;
      break;
    case LOAD:
      registers[op1] = memory[op2];
      break;
    case STORE:
      memory[op2] = op1;
      break;
    default: break;
  }
}

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
void readFile(char *fileName) {
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
  if (argc != 2) {
    printf("invalid number of arguments.\n");
    return -1;
  }

  // allocate memory and load file into memory
  memory = (unsigned char *) malloc(sizeof(char) * MEM_SIZE);
  readFile(argv[1]);

  // Execute instructions
  while (!halt) {
    pc = fetch();
    dispatch();
    execute();
    store();
  }

  return 0;
}
