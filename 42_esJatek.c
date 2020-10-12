#include <stdio.h>

int bekeres() {

    int szam;

    do {
        
        scanf("%d",&szam);

        if (!(szam <= 7 && szam >= 1)) {
            printf("A szam erteke nem megfelelo adj meg egy ujat!(1-7)\n");
        }

    } while (!(szam <= 7 && szam >= 1));

    return szam;
}

int check(int osszeg, char player[]) {
    if (osszeg == 42) {

        printf("A nyertes: %s", player);
        return 1;
    } else {
        return 0;
    }
}

int kor(char player[], int osszeg) {
    
    int szam;
    int ujOsszeg = osszeg;

    printf("%s kore: ",player);

    szam = bekeres();
    ujOsszeg += szam;
    
    printf("\nJelen osszeg: %d\n",ujOsszeg);

    if (check(ujOsszeg, player) == 1) {
        return -1;
    }

    return ujOsszeg;
}

int main() {

    int osszeg = 0;
    char player1[30];
    char player2[30];

    printf("A jatek kezdesehez add meg a jatekosok nevet \n");

    printf("Enter name of player1: ");
    fgets(player1, sizeof(player1), stdin);

    printf("Enter name of player2: ");
    fgets(player2, sizeof(player2), stdin);

    while (osszeg < 42)
    {
        osszeg = kor(player1,osszeg);
        if (osszeg == -1) {
            break;
        }

        osszeg = kor(player2,osszeg);
        if (osszeg == -1) {
            break;
        }
    }

    return 0;
}
