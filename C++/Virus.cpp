#include<string>
#include<iostream>
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

int main(int argc, char const *argv[])
{
    Virus corona("corona",5);
    cout << corona.get_nev() << " " <<corona.get_tamadas();
    return 0;
}