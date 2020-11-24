function matek(asd) {
    if (asd == null) {
        return 0;
    } else if (typeof asd == "string" ) {
        return 1;
    } else if(Number.isInteger(asd)) {
        if(asd % 2 === 0) {
            return asd ** asd;
        } else {
            return (asd - 1) ** (asd - 1);
        }
    } else {
        return null;
    }
}