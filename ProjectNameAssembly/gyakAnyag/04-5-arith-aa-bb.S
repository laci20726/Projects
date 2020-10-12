.intel_syntax noprefix

.data
formatstr:
    .asciz  "%d\n"

a:  .int 2
b:  .int 3

.text
.global main
main:
    mov eax, -5         # TODO: Replace this with arithmetic computations. (See exercises below.)

    push eax
    push offset formatstr
    call printf
    add esp, 2*4

    mov eax, 0
    ret

/*
 * gcc -m32 -g 04-5-arith-aa-bb.S -o 04-5-arith-aa-bb
 * ./04-5-arith-aa-bb
 * -5
 *
 * Exercise 5a: Compute `a*a - b*b`.
 *      A possible solution is given below:
 *
 *      mov eax, a      # eax := a              ((eax == a))
 *      imul eax        # edx:eax := eax * eax  ((eax == a * a))  ((here, we do not care about edx))
 *
 *      mov ebx, b      # ebx := b              ((ebx == b))
 *      imul ebx, ebx   # ebx *= b              ((ebx == b * b))  ((this imul variant does not write its result into a register pair!))
 *
 *      sub eax, ebx    # eax -= ebx            ((eax == a * a - b * b))
 *
 * Exercise 5b: Try and compute it as `(a+b) * (a-b)`.
 *      A possible solution is given below:
 *
 *      mov eax, a      # eax := a              ((eax == a))
 *      add eax, b      # eax += b              ((eax == a + b))
 *
 *      mov ecx, a      # ecx := a              ((ecx == a))
 *      sub ecx, b      # ecx -= b              ((ecx == a - b))
 *
 *      imul ecx        # edx:eax := eax * ecx  ((eax == (a + b) * (a - b)))
 *
 *      Alternatively:
 *
 *      mov eax, a      # eax := a              ((eax == a))
 *      mov ecx, eax    # ecx := eax            ((ecx == a))
 *      mov ebx, b      # ebx := b              ((ebx == b))
 *
 *      add eax, ebx    # eax += ebx            ((eax == a + b))
 *      sub ecx, ebx    # ecx -= ebx            ((ecx == a - b))
 *      imul ecx        # edx:eax := eax * ecx  ((eax == (a + b) * (a - b)))  ((here, we do not care about edx))
 *
 * Exercise 5c: Investigate which solution is the smallest.
 *      Try `gcc -m32 -g -c 04-5-arith-aa-bb.S` and
 *      `objdump -d -M intel 04-5-arith-aa-bb.o` with each possible solution
 *      and check how many bytes the assembled machine code will be.
 */
