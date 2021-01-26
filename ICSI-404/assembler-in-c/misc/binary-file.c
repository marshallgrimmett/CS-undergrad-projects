#include "stdio.h"

// int main(int argc,char* argv[]) {
//     FILE *fp = fopen("path_to_file.bin","wb");
//     if(fp == NULL) {
//         printf("error creating file");
//         return -1;
//     }
//     int val = 0x1123;
//     fwrite((const void*)&val,sizeof(int),1,fp);
//     fclose(fp);
//     return 0;
// }

int main() {
  FILE *outFile;

  outFile = fopen("outFile.bin", "wb");

  // short line;
  // line = (short)0x1123;
  // fwrite((const void*)&line, sizeof(line), 1, outFile);

  int val = 0x1123;
  fwrite((const void*)&val,sizeof(int),1,outFile);
  // val = 0x2456;
  // fwrite((const void*)&val,sizeof(int),1,outFile);
  // val = 0x1c23;
  // fwrite((const void*)&val,sizeof(int),1,outFile);

	fclose(outFile);
  return 0;
}

