.intel_syntax noprefix

.data

number:
    .asciz "1322\ns"

from_radix:
    .int 14

to_radix:
    .int 3

output:
    .asciz "%d %x\n"
.text

.global main
main:

atoi:



nxchr:
    a                  # load next character in BL
    inc bl           # and advance source index
     
    cmp ecx, 48       # does character preceed '0'?
    jb  inval           # yes, it's not a numeral jb:jump below
    cmp ecx, 57       # does character follow '9'?
    ja  cxchr           # yes, it's not a numeral ja:jump above

    sub ecx, 48  
    
    imul eax, from_radix            # multiply accumulator by ten. eax * 10
    add eax, ecx      # and then add the new integer
    jmp nxchr           # go back for another numeral

cxchr:
    
    cmp ecx, 65
    jb inval
    cmp ecx, 70
    ja inval

    sub ecx, 55               #'7'         
    imul eax, from_radix           
    add eax, ecx        
    jmp nxchr

inval:


   ret