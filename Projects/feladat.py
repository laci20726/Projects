class Palack(object):
    def __init__(self, ital = 1, max_urtartalom = 1, jelenlegi_urtartalom = 1):
        self.ital = ital
        self.max_urtartalom = max_urtartalom
        self._jelenlegi_urtartalom = jelenlegi_urtartalom

    @property
    def jelenlegi_urtartalom(self):
        return int(self._jelenlegi_urtartalom)

    @jelenlegi_urtartalom.setter
    def jelenlegi_urtartalom(self, ertek):
        if ertek > self.max_urtartalom:
           self._jelenlegi_urtartalom = self.max_urtartalom
        elif ertek == 0:
           self.ital = None
        else:
           self._jelenlegi_urtartalom = ertek

    def suly(self):
        return self.max_urtartalom / 35 + self._jelenlegi_urtartalom

    def __str__(self):                      
        return "Palack, benne levo ital: " + self.ital + ", jelenleg " + str(self._jelenlegi_urtartalom) + " ml van benne, maximum " + str(self.max_urtartalom) + " ml fer bele."

    def __eq__(self, masik_palack):
        if type(self) == type(masik_palack):
            return str(self.ital) == str(masik_palack.ital) and str(self.max_urtartalom) == str(masik_palack.max_urtartalom) and str(self.jelenlegi_urtartalom) == str(masik_palack.jelenlegi_urtartalom)
        else:
            return False

    def __iadd__(self, masik_palack):
        if(type(self) == type(masik_palack)):
            osszeg = masik_palack.jelenlegi_urtartalom + self._jelenlegi_urtartalom
            if (self.ital == masik_palack.ital) :
                self.ital = self.ital
                self.jelenlegi_urtartalom = osszeg
                return self
            elif (self._jelenlegi_urtartalom == 0 or self.ital == None):
                self.ital = masik_palack.ital
                self.jelenlegi_urtartalom = osszeg
                return self
            else:
                self.ital = "keverek"
                self.jelenlegi_urtartalom = osszeg
                return self
        else:
            return self

class VisszavalthatoPalack(Palack):
    def __init__(self, ital, max_urtartalom = 1, jelenlegi_urtartalom = 1, palackdij = 25):
        super().__init__(ital,max_urtartalom,jelenlegi_urtartalom)
        self.palackdij = palackdij
    def __str__(self):                      
        return "VisszavalthatoPalack, benne levo ital: " + self.ital + ", jelenleg " + str(self.jelenlegi_urtartalom) + " ml van benne, maximum " + str(self.max_urtartalom) + " ml fer bele."

class Rekesz(object):
    def __init__(self, max_teherbiras):
        self.max_teherbiras = max_teherbiras
        self.palackok = list()

    def suly(self):
        summ = 0
        for palack in self.palackok:
            summ += palack.suly()
        return summ

    def uj_palack(self, palack):
        if  (self.suly() + palack.suly()) <= self.max_teherbiras:
            self.palackok.append(palack)

    def osszes_penz(self):
        summ = 0
        for palack in self.palackok:
            if(type(palack) == VisszavalthatoPalack):
                summ += palack.palackdij
        return summ
