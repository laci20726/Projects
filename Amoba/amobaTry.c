#include <stdio.h>
#include <stdlib.h>

typedef struct Coordinate
{
    int row, column;
} Coordinate;


char** createPlayGround( int n)
{
    char* values = calloc(n*n, sizeof(char));
    char** rows = malloc(n*sizeof(char*));
    for (int i=0; i<n; ++i)
    {
        rows[i] = values + i*n;
    }
    for(int i = 0; i < n; i++) {

        for(int j = 0; j < n; j++) {
            rows[i][j] = '_';
        }
    }
    return rows;
}

void destroyArray(char** arr)
{
    free(*arr);
    free(arr);
}


void playGroundFence(int a) {

    for(int i = 0; i <= 2 * a; i++) {
        printf("#");
    }
    printf("\n");
}

void clrscr()
{
    system("clear");
}

void drawPlayGround(char** playGround, int n) {

    clrscr();
    playGroundFence(n);
    for(int i = 0; i < n; i++) {

        for(int j = 0; j < n; j++) {

            if (j == 0) {
                printf("#%c",playGround[i][j]);
            } else if (j == n - 1) {
                printf(" %c#", playGround[i][j]);
            } else {
                printf(" %c",playGround[i][j]);
            }
        }
        printf("\n");
    }
    playGroundFence(n);
}

// Use coordinate
int checkCrossLeft(int meret, int type, Coordinate start, char** playGround) {
        
    int counter = 1;
    int prediction;
    char winner = playGround[start.row][start.column];

    for (int k = 1; k < type; k++) {

        if(start.row + k < meret && start.column - k >= 0){     

            if ( winner == playGround[start.row + k][start.column - k] && winner != '_') {

                counter++;
                if (counter == type) {
                    break;
                }
            } else {
                counter = 1;
            }
        }  
    }

    if (counter == type && winner == 'X'){
        prediction =  1;
    } else if(counter == type && winner == 'O') {
        prediction = 2;
    } else {
        prediction = 0;
    }

    return prediction;
}

// Use coordinate
int checkCrossRight(int meret, int type, int i, int j, char** playGround) {
        
    int counter = 1;
    int prediction;
    char winner = playGround[i][j];

    for (int k = 1; k < type; k++) {

        if(i + k < meret && j + k < meret){     

            if ( winner == playGround[i + k][j + k] && winner!= '_') {

                counter++;
                if (counter == type) {
                    break;
                }
            } else {
                counter = 1;
            }
        }  
    }

    if (counter == type && winner == 'X'){
        prediction =  1;
    } else if(counter == type && winner == 'O') {
        prediction = 2;
    } else {
        prediction = 0;
    }

    return prediction;
}

int CheckManRow(char** playGround, int meret, int type) {
    
    int counter = 1;
    int prediction;
    char winner;

    for (int i = 0; i < meret;i++) {
        for (int j = 0; j < meret - 1; j++) {

            if ( playGround[i][j] == playGround[i][j+1] && playGround[i][j] != '_') {
                counter++;

                if (counter == type) {
                    winner = playGround[i][j];
                    break;
                }
            } else {
                 counter = 1;
            }
        }

        if (counter == type) {
            break;

        } else {
            counter = 1;
        }

    }
    
    if (counter == type && winner == 'X'){
        prediction =  1;
    } else if(counter == type && winner == 'O') {
        prediction = 2;
    } else {
        prediction = 0;
    }

    return prediction;
}

int CheckManColumn(char** playGround, int meret, int type) {
   
    int counter = 1;
    int prediction;
    char winner;

    for (int j = 0; j < meret;j++) {
        for (int i = 0; i < meret - 1; i++) {

            if ( playGround[i][j] == playGround[i+1][j] && playGround[i][j] != '_') {
                counter++;

                if (counter == type) {
                    winner = playGround[i][j];
                    break;
                }
            } else {
                 counter = 1;
            }
        }

        if (counter == type) {
            break;

        } else {
            counter = 1;
        }

    }
    
     
    if (counter == type && winner == 'X'){
        prediction =  1;
    } else if(counter == type && winner == 'O') {
        prediction = 2;
    } else {
        prediction = 0;
    }


    return prediction;
}

int CheckManCross(char** playGround, int meret, int type) {
    
    int counter = 1;
    int prediction = 0;
    char winner;

    for (int i = 0; i < meret; i++) {
        for(int j = 0; j < meret; j++) {

            Coordinate startCoord = { .row = i, .column = j};

            prediction = checkCrossLeft(meret,type, startCoord, playGround);

            if(prediction == 1) {
                return prediction;
            } else if(prediction == 2) {
               return prediction;
            }

            prediction = checkCrossRight(meret,type,i,j,playGround);

            if(prediction == 1) {
                return prediction;
            } else if(prediction == 2) {
               return prediction;
            }
        }
    }
    return prediction;
}
int checkTable(char** playGround, int meret){

    for(int i = 0; i < meret;i++) {
        for(int j = 0; j < meret;j++){
            if(playGround[i][j] == '_') {
                return 0;
            }
        }
    }
    return -1;
}
int checkMan(char** playGround, int meret, int type) {

    if(CheckManRow(playGround,meret,type) == 1 || CheckManColumn(playGround,meret,type) == 1 || CheckManCross(playGround,meret,type) == 1) {
        return 1;
    } else if (CheckManRow(playGround,meret,type) == 2 || CheckManColumn(playGround,meret,type) == 2 || CheckManCross(playGround,meret,type) == 2) {
        return 2;
    } else if(checkTable(playGround,meret) == -1) {
        return 3;
    } else {
        return 0;
    }
}

void makeRound(char** playGround,int meret, int round) {
    int a, b;
    int isValidA;
    int isValidB;

    do {

        printf("Add meg a koordinátákat: ");
        scanf("%d %d", &a, &b);
        
        isValidA = a > 0 && a <= meret;
        isValidB = b > 0 && b <= meret;

        if (isValidA && isValidB) {

            if (playGround[a - 1][b - 1] == '_') {
                if (round % 2 == 0) {
                    playGround[a - 1][b - 1] = 'X';
                } else if (round % 2 == 1) {
                    playGround[a - 1][b - 1] = 'O';
                }
            } else {
                printf(" a mező már foglalt\n");
                isValidB = !isValidB;
            }
        }
    } while (!isValidA || !isValidB);
}

int main() {
    
    int a;
    int b;
    int i = 0;

    printf("Add meg a palya meretet: ");
    scanf("%d", &a);
    printf("Add meg a jatektipusat(3, 4, 5): ");
    scanf("%d", &b);

    char** playGround = createPlayGround(a);

    while (1)
    {
        drawPlayGround(playGround,a);
        makeRound(playGround,a,i);
 
        putchar('\n');
        i++;
        if (checkMan(playGround,a,b) != 0)
        {
            break;
        }
        
    }
    drawPlayGround(playGround,a);
    if(checkMan(playGround,a,b) == 1) {
        printf(" X a nyertes\n");
    }else if (checkMan(playGround,a,b) == 2) {
        printf(" O a nyertes\n");
    } else {
        printf("Döntetlen\n");
    }

    destroyArray(playGround);


    return 0;
}

