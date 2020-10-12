.intel_syntax noprefix

.section .data

a:
    .int 300
b: 
    .int 400
formatstr:
        .asciz "%d"
.text
.global main
main:

    push ebp
    mov ebp , esp
    
    mov eax, b
    mov ebx, a

    mov edx, 0

    div ebx

    push eax
    push offset formatstr
    call printf 
    pop eax
    pop eax

    mov esp , ebp
    pop ebp

    mov eax, 0
    ret