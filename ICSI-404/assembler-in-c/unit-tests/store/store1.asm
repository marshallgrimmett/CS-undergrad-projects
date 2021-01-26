addimmediate r1 52 (91 34)

addimmediate r2 10 (92 0A)

store r2 r1 0 (F2 10)

interrupt 0 (8000)

interrupt 1 (8001)

R1 == 52

R2 == 10

; Address in memory
52 == 10