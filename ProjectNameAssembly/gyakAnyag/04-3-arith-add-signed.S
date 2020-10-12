.intel_syntax noprefix

.data
formatstr:
    .asciz "0x%x %d\n"

.text
.global main
main:
    mov eax, 6          # eax := 6
    mov ebx, 7          # ebx := 7
    add eax, ebx        # eax += ebx

    push eax
    push eax
    push offset formatstr
    call printf
    add esp, 3*4

    mov eax, 0
    ret

/*
 * gcc -m32 -g 04-3-arith-add-signed.S -o 04-3-arith-add-signed
 * ./04-3-arith-add-signed
 * 0xd 13
 *
 * Exercise 3: Try and add signed integers.
 *      Copy -6 into eax and -7 into ebx. The registers will contain the two's
 *      complement of these values. The add instruction works properly anyway.
 *      (It doesn't matter for add whether its operands are signed or
 *      unsigned).
 */
