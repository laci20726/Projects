#include<iostream>
#include<string>

using namespace std;

int main(int argc, char const *argv[])
{
    string longer, shorter;
    cin >> longer >> shorter;

    if(longer.length() < shorter.length()) {
        string tmp = longer;
        longer = shorter;
        shorter = tmp;
    }

    size_t result = longer.find(shorter);
    if (string::npos == result)
    {
        cerr << "not found" << endl;
        return 1;
    }
    
    cout << result << endl;
    
    return 0;
}
