addimmediate r1 10 (91 0A)

addimmediate r2 8 (92 08)

multiply r1 r2 r3 (41 23)

interrupt 0 (8000)

R1 == 10

R2 == 8

R3 == 80