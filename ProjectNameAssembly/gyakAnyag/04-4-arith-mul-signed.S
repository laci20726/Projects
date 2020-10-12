.intel_syntax noprefix

.data
formatstr:
    .asciz "0x%x:%08x\n"

.text
.global main
main:
    mov eax, 6          # eax := 6
    mov ebx, 7          # ebx := 7
    mul ebx             # edx:eax := eax * ebx (== 42 == 0x00000000:0000002a)

    push eax
    push edx
    push offset formatstr
    call printf
    add esp, 3*4

    mov eax, 0
    ret

/*
 * gcc -m32 -g 04-4-arith-mul-signed.S -o 04-4-arith-mul-signed
 * ./04-4-arith-mul-signed
 * 0x0:0000002a
 *
 * Exercise 4a: Try and multiply signed integers.
 *      Copy -6 into eax.
 *
 * Exercise 4b: Fix the signed multiplication.
 *      7 * -6 == -42 == 0xffffffff:ffffffd6 (on 64 bits). However, the program
 *      that uses mul doesn't print this expected value. This is because for
 *      multiplication it MATTERS whether the operands are signed or unsigned.
 *      The instruction for unsigned multiplication is `mul`, while the
 *      instruction for signed multiplication is `imul`.
 */
