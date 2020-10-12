#include<iostream>
#include<string>

using namespace std;

int main(int argc, char const *argv[])
{
    string longer;
    cin >> longer;

    size_t result = longer.find_last_of("b");

    cout << result + 1;

    return 0;
}
