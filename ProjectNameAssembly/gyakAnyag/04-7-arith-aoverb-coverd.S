.intel_syntax noprefix

.data
formatstr:
    .asciz  "%d\n"

a:  .int 128
b:  .int 3
c:  .int 4
d:  .int 6

.text
.global main
main:
    mov eax, 42                 # TODO: Replace this with arithmetic computations. (See exercise below.)

    push eax
    push offset formatstr
    call printf
    add esp, 2*4

    mov eax, 0
    ret

/*
 * gcc -m32 -g 04-7-arith-aoverb-coverd.S -o 04-7-arith-aoverb-coverd
 * ./04-7-arith-aoverb-coverd
 * 42
 *
 * Exercise 7: Compute `a/b - c/d`.
 *      A possible solution is given below:
 *
 *      mov eax, b              # eax := b              ((eax == b))
 *      imul dword ptr d        # edx:eax := eax * d    ((eax == b * d))  ((here, we do not care about edx))
 *      mov esi, eax            # esi := eax            ((esi == b * d))
 *
 *      mov eax, a              # eax := a              ((eax == a))
 *      imul dword ptr d        # edx:eax := eax * d    ((edx:eax == a * d))  ((here, we DO care about edx))
 *      mov ebx, eax            # ecx:ebx := edx:eax
 *      mov ecx, edx            #                       ((ecx:ebx == a * d))
 *
 *      mov eax, c              # eax := c              ((eax == c))
 *      imul dword ptr b        # edx:eax := eax * b    ((edx:eax == c * b))  ((here, we DO care about edx))
 *
 *      sub eax, ebx            # edx:eax -= ecx:ebx
 *      sbb edx, ecx            #                       ((edx:eax == c*b - a*d))
 *
 *      neg esi                 # esi := -esi           ((esi == -b*d))
 *      idiv esi                # eax := edx:eax / esi  ((eax == (c*b - a*d) / -b*d))
 *
 *      NOTE: Because the operands are integers, the formula is computed as
 *      `(a*d - c*b) / b*d`, which gives less rounding error.
 *      NOTE: The solution above actually computes the negate of both the
 *      dividend and the divisor, because it takes less instructions that way.
 *
 *      Alternatively:
 *
 *      mov eax, a              # eax := a              ((eax == a))
 *      imul eax, d             # edx:eax := eax * d    ((eax == a * d))  ((here, we do not care about edx))
 *
 *      mov ecx, c              # ecx := c              ((ecx == c))
 *      imul ecx, b             # ecx *= b              ((ecx == c * b))
 *
 *      mov ebx, b              # ebx := b              ((ebx == b))
 *      imul ebx, d             # ebx *= d              ((ebx == b * d))
 *
 *      sub eax, ecx            # eax -= ecx            ((eax == a*d - c*b))
 *      cdq                     # edx:eax := eax        ((edx:eax == a*d - c*b))
 *      idiv ebx                # eax := edx:eax / ebx  ((eax == (a*d - c*b) / b*d))
 *
 *      NOTE: This approach may give incorrect results if `a` and `c` are
 *      "large", because `a*d` and `c*b` are computed on 32 bits only (unlike
 *      the above approach, which computes the dividend on 64 bits).
 *      NOTE: The divisor is computed on 32 bits in both solutions.
 */
