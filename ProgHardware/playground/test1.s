.data
newline: .asciiz "\n"

.text
.globl main
main:
li $5, 10
jal sum
addi $6, $7, 9
move $a0, $6
li $v0, 1
syscall
la $a0, newline
li $v0, 4
syscall
li $v0, 10
syscall
            
.text
sum: bgtz $5, compute
li $7, 0
jr $31

compute:
sw $6, 0($sp)
sw $8, -4($sp)
addi $sp, $sp, -8
addi $6, $5, 1
mul $6, $6, $5
li $8, 2
div $7, $6, $8
lw $8, 4($sp)
lw $6, 8($sp)
addi $sp, $sp, 8
jr $31
