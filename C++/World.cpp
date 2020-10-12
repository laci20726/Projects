#include<iostream>
#include<string>

using namespace std;

int main() {
    string str2;
    cin >> str2;
    int start ;
    cin >> start;
    if (start < str2.length()){
        for (int i = start; i < str2.length(); i++)
        {
        cout << str2[i];
        }
        cout << endl;
    } else {
        cout << "invalid index" << endl;
    }
    return 0;
}