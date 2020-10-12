.intel_syntax noprefix

.data
formatstr:
    .asciz "0x%x %d\n"

.text
.global main
main:
    mov eax, 42

    push eax
    push eax
    push offset formatstr
    call printf
    pop eax
    pop eax
    pop eax

    mov eax, 0
    ret

/*
 * gcc -m32 -g 04-1-arith-add-esp.S -o 04-1-arith-add-esp
 * ./04-1-arith-add-esp
 * 0x2a 42
 *
 * Exercise 1: Replace the 3 pop instructions with `add esp, 3*4`.
 *      A `pop eax` instruction is equivalent to `mov eax, [esp]; add esp, 4`.
 *      But actually, we are not interested in the values that are on the
 *      stack, we just have to "clean" the stack after the printf call. So, we
 *      only need the `add esp, 4` part of the pops. There are 3 pops, which
 *      can then be replaced by a single `add esp, 12`.
 */