#include <iostream>

using namespace std;

class Virus
{
private:
    string nev;
    int tamadas; 
public:
    Virus(string nev,int tamadas = 10) {
        this->nev = nev;
        this->tamadas = tamadas;
    }
    int get_tamadas() {
        return tamadas;
    }
    string get_nev() {
        return nev;
    }
    
};


class Immunrendszer 
{

private:
    int vedelem;
    int tamadas;

public:
    Immunrendszer(int vedelem = 10, int tamadas = 10)
    {
        this->tamadas = tamadas;
        this->vedelem = vedelem;
    }

    int get_vedelem() {
        return vedelem;
    }
    int get_tamadas() {
        return tamadas;
    }
    void set_tamadas(int uj_tamadas) {
        tamadas = uj_tamadas;
    }
    void set_vedelem(int uj_vedelem) {
        vedelem = uj_vedelem;
    }

    void tamadast_elszenved(Virus corona) {
        if(corona.get_tamadas() > vedelem && vedelem > 0) {
            set_vedelem(vedelem - 1);
            cout << vedelem << endl;
        }
        if(vedelem == 0) {
            cout << "a " << corona.get_nev() << " gyozott" << endl;
        }
    }
};

void operator<< (Immunrendszer& immnun, Virus virus) {
    immnun.tamadast_elszenved(virus);
}

int main()
{

    Immunrendszer uj(0,2);
    Virus corona("covid", 100);
    uj.tamadast_elszenved(corona);
    uj << corona;
    cout << uj.get_tamadas() << endl << uj.get_vedelem();
}
