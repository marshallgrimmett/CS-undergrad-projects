addimmediate r1 8 (91 08)

addimmediate r2 10 (92 0A)

branchifless r1 r2 4 (B1 20 0004)

addimmediate r2 8 (92 08) ; should be skipped

interrupt 0 (8000)

R1 == 8

R2 == 10