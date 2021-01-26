addimmediate r1 52 (91 34) ; set r1 to the start address of the linked list

addimmediate r2 1 (91 01) ; load the linked list with values

store r2 r1 0 (F2 10)

addimmediate r2 2 (91 02)

store r2 r1 4 (F2 14)

addimmediate r2 3 (91 03)

store r2 r1 8 (F2 18)

load r2 r1 0 ; load r2's with the value pointed to by r1

interrupt 0 (8000)

iterateover r1 4 20 (D1 04 0014) ; location out of range error expected

interrupt 1 (8001)

; At each iteration
R1 == 1
R1 == 2
R1 == 3

; Address in memory
52 == 1
56 == 2
60 == 3