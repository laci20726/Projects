.intel_syntax noprefix

.data
formatstr:
    .asciz "0x%x %d\n"

.text
.global main
main:
    mov al, 0xff        # ax := 0x1ff (== 511)
    mov ah, 0x01
    mov bl, 0xff        # bx := 0x1ff (== 511)
    mov bh, 0x01

    add al, bl          # ax += bx ( ??? )
    add ah, bh

    movzx eax, ax       # eax := (unsigned) ax

    push eax
    push eax
    push offset formatstr
    call printf
    add esp, 3*4

    mov eax, 0
    ret

/*
 * gcc -m32 -g 04-2-arith-add-carry.S -o 04-2-arith-add-carry
 * ./04-2-arith-add-carry
 * 0x2fe 766
 *
 * Exercise 2a: Fix the two-step addition (addition of 16 bit values in 8 bit
 *      units).
 *      The program prints 766, which is not the expected result
 *      (511 + 511 = 1022). It is because the carry from the addition of the
 *      lower 8 bits (from al + bl) is not taken into account when adding the
 *      higher 8 bits (ah + bh). The second step has to use the add with carry
 *      (adc) instruction.
 *
 * Exercise 2b: Simplify the code to perform the addition in a single step.
 *      In this example, the addition can be performed with a single
 *      `add ax, bx`. (Moreover, the first 4 instructions can also be
 *      simplified in various ways, e.g., by replacing it with two
 *      instructions: `mov ax, 0x1ff; mov bx, 0x1ff`.)
 *
 * Exercise 2c: Experiment with multiple-step additions of various bit lengths.
 *      The rule of thumb is that the first step must be an `add` and all the
 *      rest must be `adc`.
 */
