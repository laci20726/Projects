#include<string>
#include<iostream>

using namespace std;

int count_mM() {
    string str;
    cin >> str;
    int mM = 0;
    for (int i = 0; i < str.size(); i++)
    {
        if (str[i] == 'm' || str[i] == 'M')
        {
            mM++; 
        }
    }
    return mM;
}

string repeater() {
    int szor;
    string szo;
    cin >> szor >> szo;
    if (szor < 0)
    {
        return "hiba";
    }
    
    string szo_eredmeny;
    for (int i = 0; i < szor; i++)
    {
        szo_eredmeny += szo;
    }
    return szo_eredmeny;
}

string multiplier(unsigned szam) {
    return to_string(szam * 3);
}

float strmin(string s1, string s2) {
    int errors = 0;
    int which = 0;
    try {
        float one = stof(s1);
    }
    catch(const invalid_argument& e_inv) {
        errors++;  
        which = 1; 
    }
    try {
        float two = stof(s2);
    }
    catch(const invalid_argument& e) {
        errors++;
        which = 2;
    }

    if (errors == 2) {
        return -999;
    } else if (errors == 1 && which == 1) 
    {

        return stof(s2);
    } else if (errors == 1 && which == 2) 
    {
        return stof(s1);
    } else
    {
        if(stof(s1) < stof(s2)) {
            return stof(s1);
        } else {
            return stof(s2);
        }
    }
    
    
    
    
    
}

int main(int argc, char const *argv[])
{
    cout << repeater();
    return 0;
}
