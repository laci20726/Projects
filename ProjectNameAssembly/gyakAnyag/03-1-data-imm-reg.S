.intel_syntax noprefix

.data
formatstr:
    .asciz "0x%x %d\n"

.text
.global main
main:
    push 42                     # push 42 onto the stack (42 is an immediate constant operand, which is encoded into the push instruction)
    push 42
    push offset formatstr       # the address of formatstr is also an immediate constant operand of push
    call printf                 # printf(formatstr, 42, 42)
    pop eax
    pop eax
    pop eax

    mov eax, 0
    ret

/*
 * gcc -m32 -g 03-1-data-imm-reg.S -o 03-1-data-imm-reg
 * ./03-1-data-imm-reg
 * 0x2a 42
 *
 * Exercise 1: Move all immediate operands of the push instructions into
 *      registers first.
 *      `mov eax, 42; push eax; push eax` is a potential rewrite of the first
 *      two push instructions, and `mov eax, offset formatstr; push eax` is a
 *      potential rewrite of the third push.
 *      NOTE: After the rewrite, all push instructions use "register
 *      addressing". The first operands of the mov instructions also use
 *      "register addressing", and the second operands use "immediate
 *      addressing".
 */
