#include <stdio.h>

extern int is_geometric(int sequence[] , int length);

int main() {

int seq[] = {0,1,2,4,8};

int result = is_geometric(seq , 5);

printf ( "Mertani sorozat? %d\n" , result ) ;

}