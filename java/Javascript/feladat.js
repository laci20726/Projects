function clear(tomb) {
    if(tomb == null) {
        return 0;
    } else {
        tombEredmeny = [];
        var j = 0;
        for (let i = 0; i < tomb.length; i++) {
            if(typeof(tomb[i]) === "number") {
                tombEredmeny[j] = tomb[i];
                j++;
            } else if(typeof(tomb[i]) === "string" && tomb[i] !== "" ) {
                var ez = tomb[i].toUpperCase();
                tombEredmeny[j] = ez.substring(0,2);
                j++;
            }
        }
    }

    return tombEredmeny.reverse();
}

console.log( [,3])
console.log(clear( [,3]))