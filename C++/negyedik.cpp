#include<iostream>
#include<string>

using namespace std;

int main(int argc, char const *argv[])
{
    for(int i = -100; i < 100; i++ ) {
        string number = to_string(i);
        if(i == number.size()) {
            cout << i << endl;
        }
    }

    return 0;
}

