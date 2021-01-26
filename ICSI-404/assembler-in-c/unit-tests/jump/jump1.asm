addimmediate r1 8 (91 08)

jump 3 (C000 0003)

addimmediate r1 8 (91 08) ; should be skipped

interrupt 0 (8000)

R1 == 8