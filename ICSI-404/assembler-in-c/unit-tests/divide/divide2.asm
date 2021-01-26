addimmediate r1 10 (91 0A)

divide r1 r2 r3 (31 23) ; cannot divide by 0 error expected

interrupt 0 (8000)

R1 == 10

R2 == 0

R3 == 0