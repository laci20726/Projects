.intel_syntax noprefix

.section .data
formatstr:
    .asciz "%d %d \n"

My_Array:

    .int 40, 30, 20, 10

.text
.global main
main:

    push ebp
    mov ebp , esp

begining:
    mov ecx, 0                      # leendo counter
    mov ebx, offset My_Array       # ebx :=  My_Array kezdo pont
    mov eax, [ebx + ecx*4]          # eax  tartalmazza az elso elemet novelt ecx-el halad

    cmp eax, [ebx + ]          # elso masodik elem osszehasonlitas
    jl xchange                  # kisebb eseten ugras cserere -----> xchange
    mov eax, [ebx + 0]

    push eax
    
    xchg eax, [ebx + 8]
    push eax

    push offset formatstr
    call printf
    pop eax
    pop eax
    pop eax

    mov eax, 0

xchange:                
    xchg eax, [ebx + 4]             # elso elem csere masodik
    xchg [ebx + 0], eax
    inc ecx
    cmp ecx, 4
    je begining





    mov esp , ebp
    pop ebp

    ret
