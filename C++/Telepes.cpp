#include<string>
#include<iostream>
#include <algorithm>

using namespace std;

class Telepes
{
private:
string nev;
string szul_bolygo;
string bolygo;
unsigned ero;

public:
    Telepes(string nev,string szul_bolygo, string bolygo, unsigned ero) {
        this->nev = nev;
        this->szul_bolygo = szul_bolygo;
        this->bolygo = bolygo;
        this->ero = ero;
    }
    Telepes() {
        this->nev = "";
        this->szul_bolygo = "";
        this->bolygo = "";
        this->ero = 1;
    }
    Telepes(string nev, string bolygo, unsigned ero = 1) {
        this->nev = nev;
        this->bolygo = bolygo;
        szul_bolygo = bolygo;
        this->ero = ero;
        
    }

    string get_nev() {
        return nev;
    }

    void set_nev(string uj_nev) {
        nev = uj_nev;
    }

    string get_szul_bolygo() {
        return szul_bolygo;
    }

    void set_szul_bolygo(string uj_szul_bolygo) {
        szul_bolygo = uj_szul_bolygo;
    }

    string get_bolygo() {
        return bolygo;
    }

    void set_bolygo(string uj_bolygo) {
        bolygo = uj_bolygo;
    }

    unsigned get_ero() {
        return ero;
    }

    void set_ero(unsigned uj_ero) {
        ero = uj_ero;
    }

    bool kivandorlo() {
        string str = get_bolygo();
        string str2 = get_szul_bolygo();
        transform(str.begin(), str.end(), str.begin(), ::tolower);
        transform(str2.begin(), str2.end(), str2.begin(), ::tolower);
        bool strings = (str == "" && str2 == "");
        if (str == str2 || strings)
        {
            return false;
        } else
        {
            return true;
        }
    } 

    
    void dolgozik(string& munkak) {
        char* feladat = const_cast<char*>(munkak.c_str());
        string eredm = "";

        int counter = 1;
        if (munkak.length() != 1){
            for (int i = 0; i < munkak.size(); i++) {
                if (feladat[i] == ';')
                {
                    counter++;
                }
                if (counter > get_ero()) {
                    string betu = string(1,feladat[i]);
                    eredm.append(betu);
                }
            }
        } else {
            if (get_ero() < 1) {
                string betu = string(1,feladat[0]);
                eredm.append(betu);
            }
        }
        if (eredm.length()>1){
            eredm = eredm.substr(1, eredm.length());
        }

         munkak = eredm;
        
        

    }
   
};


int main() {

    return 0;
}



