.intel_syntax noprefix

.data
formatstr:
    .asciz "min = %d, max = %d\n"

a:  .int -7
b:  .int -42

.text
.global main
main:
    mov eax, a      # eax := a
    mov ebx, b      # ebx := b

    # TODO: Add code here. (See exercise below.)

    push ebx
    push eax
    push offset formatstr
    call printf
    add esp, 3*4

    mov eax, 0
    ret

/*
 * gcc -m32 -g 05-1-control-minmax-ab.S -o 05-1-control-minmax-ab
 * ./05-1-control-minmax-ab
 * min = -7, max = -42
 *
 * Exercise 1: Compute `min(a,b)` in eax and `max(a,b)` in ebx.
 *      A possible solution is given below:
 *
 *      cmp eax, ebx    # flags ~= eax - ebx
 *      jle _ok         # if (flags ~~ eax <= ebx) goto _ok
 *      xchg eax, ebx   # temp := eax; eax := ebx; ebx := temp
 *  _ok:                # ((eax == min(a, b); ebx == max(a, b)))
 */
