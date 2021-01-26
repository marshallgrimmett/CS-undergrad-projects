.SUFFIXES: .c .o

CC = gcc
CFLAGS = -g

.c.o:
	$(CC) $(CFLAGS) -c $<

all: assembler vm1

assembler: assembler.o
	$(CC) assembler.o -o assembler

siavm: siavm.o
	$(CC) siavm.o -o siavm

clean:
	rm -f *.o core
