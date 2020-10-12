.intel_syntax noprefix

.data
formatstr:
    .asciz "sum i=0..%d: i = %d\n"

n:  .int 100

.text
.global main
main:
    mov eax, 5050 # TODO: Replace this with computations. (See exercises below.)

    push eax
    push dword ptr n
    push offset formatstr
    call printf
    add esp, 3*4

    mov eax, 0
    ret

/*
 * gcc -m32 -g 05-2-control-sum-n.S -o 05-2-control-sum-n
 * ./05-2-control-sum-n
 * sum i=0..100: i = 5050
 *
 * Exercise 2a: Compute `sum i=0..n: i`.
 *      A possible solution is given below:
 *
 *      mov eax, 0    # eax := 0  ((eax will contain the sum))
 *      mov ebx, 0    # ebx := 0  ((ebx will be used as loop counter))
 * _loop:
 *      cmp ebx, n    # flags ~= ebx - n
 *      jg _done      # if (flags ~~ ebx > n) goto _done
 *      add eax, ebx  # eax += ebx
 *      inc ebx       # ebx++
 *      jmp _loop     # goto _loop
 * _done:
 *
 * Exercise 2b: Try and compute it as `sum i=n..0: i`.
 *      A possible solution using ecx-specific complex instructions is given
 *      below:
 *
 *      xor eax, eax  # eax ^= eax ((same as: mov eax, 0))  ((eax will contain the sum))
 *      mov ecx, n    # ecx := n                            ((ecx will be used as loop counter))
 *      jcxz _done    # if (ecx == 0) goto _done
 * _loop:
 *      add eax, ecx  # eax += ecx
 *      loop _loop    # ecx--; if (ecx != 0) goto _loop
 * _done:
 */
