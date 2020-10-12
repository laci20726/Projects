.intel_syntax noprefix

.data
formatstr:
    .asciz "%x %d\n"

.text
.global main
main:
    mov eax, 6          # eax := 6
    mov ebx, 7          # ebx := 7
    add eax, ebx        # eax += ebx

    push eax
    push eax
    push offset formatstr
    call printf
    add esp, 3*4

    mov eax, 0
    ret
