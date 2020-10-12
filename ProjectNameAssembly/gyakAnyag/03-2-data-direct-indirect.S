.intel_syntax noprefix

.data
formatstr:
    .asciz "0x%x %d\n"

myint:
    .int 42

.text
.global main
main:
    mov eax, myint              # load 32 bits (4 bytes) from myint into eax (eax := myint)

    push eax
    push eax
    push offset formatstr
    call printf                 # printf(formatstr, eax, eax)
    pop eax
    pop eax
    pop eax

    mov eax, 0
    ret

/*
 * gcc -m32 -g 03-2-data-direct-indirect.S -o 03-2-data-direct-indirect
 * ./03-2-data-direct-indirect
 * 0x2a 42
 *
 * Exercise 2a: Use an alternative form of direct memory addressing.
 *      `mov eax, myint` and `mov eax, [myint]` are equivalent alternative
 *      syntaxes of "direct memory addressing".
 *
 * Exercise 2b: Rewrite direct memory addressing to indirect memory addressing.
 *      `mov eax, offset myint; mov eax, [eax]` puts the address of myint into
 *      eax and then loads 4 bytes from the address pointed to by eax into eax.
 *      It is similar to a C-like `a = &myint; a = *a;` program.
 *      NOTE: Such a program would not be valid C. In C, variables are typed:
 *      they are either an int or a pointer to an int, but cannot be both. In
 *      assembly, types don't exist, the registers only have size (expressed in
 *      number of bits). This is why they can store both values and addresses.
 */
