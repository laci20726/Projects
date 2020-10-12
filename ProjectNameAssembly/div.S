.intel_syntax noprefix

.section .data

a:
    .int 300
b: 
    .int 400
formatstr:
        .asciz "%d \n"
.text
.global main
main:

    push ebp
    mov ebp , esp

    mov ax, 5
    mov bx, 0
    xor ax, bx

    push ax
    push offset formatstr
    call printf 
    pop eax
    pop ax

    mov ax, 0x0000
    inc ax
    
    push ax
    push offset formatstr
    call printf 
    pop eax
    pop ax

    mov esp , ebp
    pop ebp

    mov eax, 0
    ret