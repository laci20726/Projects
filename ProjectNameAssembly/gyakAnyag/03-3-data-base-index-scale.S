.intel_syntax noprefix

.data
formatstr:
    .asciz "0x%x %d\n"

myarr:
    .int 40, 41, 42, 43

.text
.global main
main:
    mov ebx, offset myarr       # ebx := &myarr
    mov eax, [ebx + 0]          # eax := *(ebx + 0) (== 40)

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
 * gcc -m32 -g 03-3-data-base-index-scale.S -o 03-3-data-base-index-scale
 * ./03-3-data-base-index-scale
 * 0x28 40
 *
 * Exercise 3a: Load the 2nd element of the array into eax.
 *      The ints are 4 bytes on x86/linux, so the 2nd element is 2*4 bytes
 *      "away" from the start of the label (pointed to by the `myarr` label).
 *      (Assuming 0-based indexing, i.e., the example array has 0th, 1st, 2nd,
 *      and 3rd elements.) So, `[ebx + 8]` addresses the 2nd element.
 *
 * Exercise 3b: Don't be afraid to make mistakes.
 *      It is easy to forget that all memory addressing is byte-based in
 *      assembly (unlike in C, where array addressing or pointer arithmetics
 *      automatically work in base type units). So, see what happens if you
 *      load `[ebx + 2]` into eax. (Of course, it will NOT load the 2nd element
 *      of the array. It will load 32 bits starting from the 2nd BYTE of the
 *      array).
 *
 * Exercise 3c: Use register for indexing.
 *      On x86, two registers can be used at the same time for addressing data.
 *      So, `mov esi, 8; mov eax, [ebx + esi]` can also be used to load the 2nd
 *      element of myarr into eax.
 *
 * Exercise 3d: Use scaling to work with logical indexes instead of byte
 *      offsets.
 *      On x86, one of the registers used for addressing can be scaled (i.e.,
 *      multiplied) by a constant small power of two (1, 2, 4, or 8). So, if
 *      element size of an array is known at compilation time and it is small
 *      enough then it is enough if the index register stores the "logical"
 *      index only, and the correspoinding byte offset will be calculated by
 *      the addressing. In the example, `mov esi, 2; mov eax, [ebx + 4 * esi]`
 *      will load the 2nd element into eax.
 */
