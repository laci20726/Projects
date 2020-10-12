.intel_syntax noprefix

.section .data
formatstr:
    .asciz "%d %d   ed = %d \n"
formatstr1:
    .asciz "in first %d %d\n"
formatstrEAX:
    .asciz "Eax = %d\n"
formatFail:
    .asciz "fail\n"
formatsuc:
    .asciz "suc\n"
My_Array:

    .int 1 , 2 , 4 , 8 , 16

length: 
    .int 5

.text
first:
    mov edx, 0      # nullázás osztáshoz (edx maradékot tárol)
    cdq
    idiv ebx        # eax tartalmának osztása ebx-el végeredmény egész része eax-ben tárolódik

    cmp eax, 0      # eax összehasonlítása 0-ával hogy megtudjuk nő vagy csökken a sorozat
    je beforebackWard   # ha eax 0 akkor aaz első szám kisebb volt ha nem akkor nagyobb egyenlőség esetén ugurnk ahhoz a részhez ahol háturól járjuk be
    cmp edx, 0          # edx vizsgálata ha nem nulla a maradék akkor fail mivel a q feltehetően nem egész
    jne failed
    push eax        # eax értékét stackre mentem későbbi vizsgálathoz vagyis tárolom a q-t

    inc ecx         # növelem az i-met mivel elvégeztem az első lépést
    jmp forward     # ugrok a feladathoz és folytatom a 2. 3. szám vizsgálattal

firstBackward:      # funkciója lényegében mint az előbbi csak itt kimarad az ugratás mivel ez már a s
    mov edx, 0
    cdq
    idiv ebx

    cmp edx, 0          # edx vizsgálata ha nem nulla a maradék akkor fail mivel a q feltehetően nem egész
    jne failed

    push eax        # eltárolom a q hányados értékét

    dec ecx         # az i értékét csökkentem 1-el mivel hátulról megyek előre
    jmp backWard    # ugrok ahhoz a részhez ahol visszafelé vizsgálom

.global main
main:

    push ebp                    # prologús
    mov ebp , esp

    mov eax, length

    cmp eax, 2 
    je succes
    cmp eax, 1
    je succes
    cmp eax, 0 
    jle failed

    mov edi, offset My_Array    # kezdo pont a tombben
    mov ecx, 0                  # leendo i

forward:
    mov eax, length
    dec eax
    cmp ecx, eax 
    je succes

    mov eax, [edi + (ecx + 0)*4]      # i-edik elem
    mov ebx, [edi + (ecx + 1)*4]      # i+1-dik elem

    cmp eax, 0
    je failed
    cmp ebx, 0
    je failed    # két elem vizsgálat hogy 0-a e valamelyik elem ha igen akkor fail

    cmp ecx, 0   # vizsgálat hogy első eset-e ha igen akkor jump first ahol kiszámolom a q-t valamint eldől a bejárás iránya (1 -szer futhat csak le)
    je first

    mov edx, 0   # 0-ázom edx-et az osztáshoz(edx tárolja a maradékot ha nincs nullázva floating point exception)
    cdq
    idiv ebx     # osztás eax:ebx egészrész--> eax maradék --> edx
    pop edx      # edx felülírása a korábban kitárolt q érték ide mozgatása vizsgálathoz

    cmp eax, edx       # eax amiben az adott hányados vagyis jelenlegi q értéke van compare edx amibe az 1. q értéket mentettük
    jne failed         # ha nem egyenlőek akkor fail
    push edx           # edx vagyis 1. q érték visszamentése stackre


    mov eax, 0                      # eax nullázás előkészítés következő használatra

    inc ecx                         # i érték növelése(léptetés)

    cmp ecx,  length                      # feltétel hátul tesztelése hogy i <= length - 1 
    je succes
    jl forward                     # ha igaz akkor ugrik az elejére

    jmp succes                      # ha eljutott erre a pontra akkor minden esetben egyenlő volt a q vagyis sikeres volt a teszt
beforebackWard:

    mov eax, length
    dec eax
    mov ecx, eax                          # hátulról előre bejárás kezdete az i értékét belövöm length - 1 (ez mutat a tömb utolsó elemére 5-ös length esetén tomb[4])
    mov eax, 0

backWard:

    mov eax, [edi + (ecx - 0)*4]          # i-edik elem léptetés iránya fordult
    mov ebx, [edi + (ecx - 1)*4]          # elvileg i-1-dik elem

    mov edx, length
    dec edx
    cmp ecx, edx                         # compare a length-1 -el mert ha egyenlő az i a length-1 el akkor ez az első elem
    je firstBackward                      # ha az az első elem akkor ugrik fel q-t belőni 


    cmp eax, 0
    je failed
    cmp ebx, 0
    je failed                             # két elem vizsgálat hogy 0-a e valamelyik elem ha igen akkor fail

    mov edx, 0          # osztás előkészítés 0-zom a maradék helyét
    cdq
    idiv ebx            # osztás eax:ebx egészrész--> eax maradék --> edx
    pop edx             # edx felülírása a korábban kitárolt q érték ide mozgatása vizsgálathoz

    cmp eax, edx        # eax amiben az adott hányados vagyis jelenlegi q értéke van compare edx amibe az 1. q értéket mentettük
    jne failed          # ha nem egyenlőek akkor fail
    push edx            # edx vagyis 1. q érték visszamentése stackre


    mov eax, 0                      # eax nullázás előkészítés következő használatra

    dec ecx                         # i érték csökkentése(léptetés)

    cmp ecx, 0                      # feltétel hátul tesztelése hogy i >= 1 mivel i-t és i - 1-et vizsgálok így nem lesz túlindexelés
    jg backWard                   # ha igaz akkor ugrik az elejére

    jmp succes                      # ha eljutott erre a pontra akkor minden esetben egyenlő volt a q vagyis sikeres volt a teszt

failed:

    push offset formatFail
    call printf                     # ez a 3 sor ellenörző kiírás
    pop eax

    mov eax, 0                      # eax a return regiszter vagyis ami ebben van az tér vissza (itt a return érték visszaállítás)

    mov esp , ebp                   # epilógus lényegében a stack pointer visszaállítás
    pop ebp

    ret                             # return
succes:

    push offset formatsuc           # ugyan az mint a fail csak 1 a return érték 0 helyett.
    call printf 
    pop eax
    
    mov eax, 1

    mov esp , ebp
    pop ebp

    ret

