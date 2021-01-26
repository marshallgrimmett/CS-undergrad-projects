addimmediate r1 10 (91 0A)

addimmediate r2 8 (92 08)

branchifequal r1 r2 1000 ; instruction does not exist error expected

interrupt 0 (8000)

R1 == 10

R2 == 8