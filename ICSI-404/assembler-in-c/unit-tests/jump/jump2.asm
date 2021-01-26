addimmediate r1 8 (91 08)

jump 1000 (C000 03E8) ; location does not exist error expected

interrupt 0 (8000)

R1 == 8