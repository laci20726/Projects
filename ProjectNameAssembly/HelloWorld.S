.intel_syntax noprefix
.section .data
formatstr:
        .asciz "%d"
.text
.global main
main:
    push ebp
    mov ebp, esp

mov edx, 500
mov ecx, 0

for:

cmp ecx, 10
je Done

mov eax, ecx
add eax, 3
sub edx, eax

inc ecx
jmp for

Done:

    
    push edx
    push offset formatstr
    call printf
    pop eax
    pop edx

    mov esp, ebp
    pop ebp
    ret
    