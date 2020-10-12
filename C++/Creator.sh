#!/bin/bash
read Nev
echo "#include<string>" >> $Nev'.cpp' 
echo "#include<iostream>" >> $Nev'.cpp'
echo "" >> $Nev'.cpp'
echo "using namespace std;" >> $Nev'.cpp'
echo "" >> $Nev'.cpp'
echo "class $Nev" >> $Nev'.cpp'
echo "{" >> $Nev'.cpp'
echo "" >> $Nev'.cpp'
echo "private:" >> $Nev'.cpp'
echo "" >> $Nev'.cpp'
echo "public:" >> $Nev'.cpp'
echo "};" >> $Nev'.cpp'
