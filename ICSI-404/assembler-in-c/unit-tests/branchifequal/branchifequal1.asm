addimmediate r1 10 (91 0A)

addimmediate r2 10 (92 0A)

branchifequal r1 r2 4 (A1 20 0004)

addimmediate r2 8 (92 08) ; should be skipped

interrupt 0 (8000)

R1 == 10

R2 == 10