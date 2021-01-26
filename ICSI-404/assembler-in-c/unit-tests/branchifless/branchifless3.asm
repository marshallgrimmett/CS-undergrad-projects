addimmediate r1 10 (91 0A)

addimmediate r2 8 (92 08)

branchifless r1 r2 600000 ; out of range error expected

interrupt 0 (8000)

R1 == 10

R2 == 8