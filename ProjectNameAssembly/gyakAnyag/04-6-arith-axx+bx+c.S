.intel_syntax noprefix

.data
formatstr:
    .asciz  "%d\n"

a:  .int 2
b:  .int 3
c:  .int 4
x:  .int 5

.text
.global main
main:
    mov eax, 69         # TODO: Replace this with arithmetic computations. (See exercises below.)

    push eax
    push offset formatstr
    call printf
    add esp, 2*4

    mov eax, 0
    ret

/*
 * gcc -m32 -g 04-6-arith-axx+bx+c.S -o 04-6-arith-axx+bx+c
 * ./04-6-arith-axx+bx+c
 * 69
 *
 * Exercise 6a: Compute `a*x*x + b*x + c`.
 *      A possible solution is given below:
 *
 *      mov ecx, x      # ecx := x
 *
 *      mov eax, a      # eax := a              ((eax == a))
 *      imul ecx        # edx:eax := eax * ecx  ((eax == a*x))  ((here, we do not care about edx))
 *      imul ecx        # edx:eax := eax * ecx  ((eax == a*x*x))  ((here, we do not care about edx))
 *
 *      mov ebx, b      # ebx := b              ((ebx == b))
 *      imul ebx, ecx   # ebx *= ecx            ((ebx == b*x))  ((this imul variant does not write its result into a register pair!))
 *
 *      add eax, ebx    # eax += ebx            ((eax == a*x*x + b*x))
 *      add eax, c      # eax += c              ((eax == a*x*x + b*x + c))
 *
 * Exercise 6b: Try and compute it as `(a*x + b)*x + c`.
 *      A possible solution is given below:
 *
 *      mov ecx, x      # ecx := x
 *
 *      mov eax, a      # eax := a              ((eax == a))
 *      imul ecx        # edx:eax := eax * ecx  ((eax == a*x))  ((here, we do not care about edx))
 *      add eax, b      # eax += b              ((eax == a*x + b))
 *      imul ecx        # edx:eax := eax * ecx  ((eax == (a*x + b)*x))  ((here, we do not care about edx))
 *      add eax, c      # eax += c              ((eax == (a*x + b)*x + c))
 */
