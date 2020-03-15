# Triedy
Java je celá objektovo orientovaná. Znamená to, že čokoľvek je objekt. Už aj keď
vytvárame základný výpis **Hello, World!**, kde pri neobjektových jazykoch stačí
väčšinou napísať niečo v zmysle, 
```
print ("Helllo, World!")
```
tak v Jave na toto potrebuje najskôr vytvoriť objekt (obyvkle by mal aj v 
nejakom) balíčku a následne v metdóde ```main``` (hlavná metóda z celého 
balíčku alebo triedy), môžeme vypísať naše **Hello, World!**. Teda správny
zápís by mal byť:

```
package com.example.javalearning.classes;

class HelloWorld {

    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }

}
```

Prvý riadok určuje teda balíček v ktorom sa naša trieda nachádza. Následne
prichádza deklarácia triedy (je dobré dodržiavať štábnu konvenciu, kde názov
triedy začíname veľkým písmenom a každé slovo ktoré určuje názov triedy je tiež
veľkým písmenom), v našom prípade teda ```HelloWorld``` a následne prichádza
deklarácia metódy našej triedy. Keďže chceme iba vypísať **Hello, World!**,
stačí nám metóda main, ktorá však musí byť ```public```, ```static``` (pojmy 
vysvetlíme neskôr) a nevracia žiadnu hodnotu (to je to označenie ```void```).
Následne v zátvorkách určujeme vstupné parametre. Metóda main má vstupné 
argumenty pole textových reťazcov, ktoré uvádzame pri štarte programu. Ak, by
sme chceli vypísať nie, **Hello, World!**, ale iný text, ktorý určime ako 
vstupný parameter metódy, tak by sme našu triedu upravili iba minimálne. 
Konkrétne riadok výpisu by sme zmenili na

```
System.out.println("Hello, " + args[0]);
``` 

Keďže polia sa indexujú od 0, znamená to, že prvá vstupná hodnota v poli je 
práve označovaná ako **index 0**.

Trieda je súhrn nejakých vlastností (premenné triedy) a metód 
(hovoro v pre programatárov v neobjektových jazykoch to môžete označovať aj
ako "funkcie", hoc je tento výraz nesprávny a neodporúčaný).

Aby sme mohli pokročiť, zoberme si, že chceme vytvoriť e-shop s mobilnými
telefónmi. Sme však iba začínajú eshop a tak máme v ponuke iba zopár modelov
a 2 značky s rôznymi typmi procesorov, rôznymi konfiguráciami pamäte a uložného
priestoru (ostatné parametre telefónov a elektroniky celkovo zatiaľ nebudeme
brať do úvahy). 

Definujeme si triedu:
```
package com.electroshop;

class Phone {

    enum Brands {APPLE, SAMSUNG}
    enum ProcessorTypes {BIONIC, EXYNOS, QUALCOMM}

    private Brands brand;
    private String model;
    private ProcessorTypes processorType;
    private int ramSize;
    private int romSize;

}
```

Ak sa pozrieme na riadky vyššie, tak tam máme **kľúčové slovo** (anglicky
keyword) ```class```, ktoré nám definuje že ideme vytvárať triedu (môže mať
rôzne modifikátory, ale o tých neskôr). Následne má svoje premenné ako
značka ```brand```, konkrétny model, typ procesoru, veľkosť pamäte a úložiska.

To čo je  ```enum``` sme si už vysvetľovali v základoch Javy. Je to 
hodnotový dátový typ s konštatnými hodnotami. Ďalšie dátové typy sú už určite
zrejmé (ako ```int``` či ```String```).

Všimnime si, že pred každou premennou je ešte použitý moditikátor ```private```.
Tento modifikátor zabezpečuje to, že len samotná trieda smie pristupovať k týmto
premenným. Preto, ak by sme si vytvorili novú inštanciu triedy, nemohli by sme 
v nej nič nastaviť (zatiaľ). 

Novú inštanciu triedy (to sa volá v sktučonosti objekt) vytvoríme pomocou
(ideálne v samostatnom súbore):

```
Phone phone = new Phone();

/*
 Od JDK 10, môžeme používať aj var (kvôli čitateľnosti). Java si aj napriek
 použitiu var zachováva vlastnoť, že je je typovo silná, a že každá premenná,
 musí mať definovaný typ. Ale JDK 10 a vyššie vie automaticky vyčítať, že 
 new Phone() bude premenná typu Phone. A preto ju môžeme deklarovať ako var,
 napr.

 var phone = new Phone();
*/

```

Ako si môžeme, všimnúť, metódu z názvom ```Phone()``` vôbec v našej triede 
```Phone``` nemáme. Táto metóda sa nazýva **konštruktor**. Ak ho však v triede
nemáme definovaný, Java si ho vytvorí automaticky. Tomuto sa hovorí 
**bezparametrický konštruktor**.

S týmto však veľa nezmôžeme, takže si poďme našu triedu ```Phone()``` rozšíriť
tak, aby sme mohli nastaviť jednotlivé parametre. K tomuto existujú obecne 2
prístupy. Jeden spôsob bude cez **konštruktor** (tým pádom to už nebude ďalej
trieda s bezparametrickým konštruktorom) alebo cez tzv. *gettery* a *settery*.
Je to nespisovný výraz, avšak neviem ho ani správne preložiť. 

V tomto prípade poďme cestou, že si niektoré vlastnosti nastavíme cez 
konštruktor a niektoré zase práve cez **get** a **set** metódy.

Ak ideme predávať mobilný telefón, je dobré aby sme vedeli aspoň jedho značku
a o aký model ide. Preto tieto 2 vlastnosti nastavíme cez konštruktor. Ostatné
vlastnosti ako typ procesoru, veľkosť pamäte a veľkosť úložiska nastavíme cez
settery.

Upravená trieda teda bude vyzerať nasledovne:

```
package com.electroshop;

class Phone {

    enum Brands {APPLE, SAMSUNG}
    enum ProcessorTypes {BIONIC, EXYNOS, QUALCOMM}

    private Brands brand;
    private String model;
    private ProcessorTypes processorType;
    private int ramSize;
    private int romSize;

    public Phone(Brands brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public void setProcessorType(ProcessorTypes processorType) {
        this.processorType = processorType;
    }

    public void setRamSize(int ramSize) {
        this.ramSize = ramSize;
    }

    public void setRomSize(int romSize) {
        this.romSize = romSize;
    }

    public Brands getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public ProcessorTypes getProcessorType() {
        return processorType;
    }

    public int getRamSize() {
        return ramSize;
    }

    public int getRomSize() {
        return romSize;
    }
} 
```

Aj keď sa to môže zdať na prvý pohľad zmätočné, hneď si to vysvetlíme. Vytvorili
sme pe triedu konštruktor kde očakávame značku telefónu a konkrétny model.

Ďalej sú už iba **set** metódy pre procesor, veľkost pamäte a úložiska. Tomuto
sa hovorí nespisovne *setteri*, alebo teda aliclicky *setters*. Ostatné metódy
sú už len **get** metódy, aby sme si z každého typu telefónu vedeli tieto
jeho vlastnosti vytiahnuť (keďže samotné vlastnosti sú private a zvonku, teda
z inštancie by sme k nim nemali prístup). To je aj dôvod, preto sú **get** a 
**set** metódy public (aby sme k nim vedeli pristupovať z inštancie).

Spravidla sa snažme vždy dávat vlastnosti triedy ako **private** alebo 
**protected** (o tom si povieme neskôr).

Práve nám prišlo na sklad 5 telefónov a my sme iba otvorili veľkú krabicu s 
tovarom a v nej sú krabice telefónov. Na nich vidíme iba značku a typ. Ostatné
parametre zatiaľ nie. Chceme však čo najrýchlejšie tieto telefóny dostať do 
obehu a tak ich rýchlo nahodíme do nášho e-shopu (súbor, kde sme vytvárali) 
inštanciu objektu, zmeníne nasledovne):

```
Phone[] phones = new Phone[5];

phones[0] = new Phone(Phone.Brands.APPLE, "8");
phones[1] = new Phone(Phone.Brands.APPLE, "X[S] Max");
phones[2] = new Phone(Phone.Brands.SAMSUNG, "A50");
phones[3] = new Phone(Phone.Brands.SAMSUNG, "S20");
phones[4] = new Phone(Phone.Brands.SAMSUNG, "S10 e");   
```

Teraz sme si však pozreli telefóny bližšie (pootáčali krabice, prečítali 
hodnoty)a môžeme doplniť chýbajúce parametre:

```
// iPhone 8 (Bionic, 2GB RAM, 64GB internal storage)
phones[0].setProcessorType(Phone.ProcessorTypes.BIONIC);
phones[0].setRamSize(2);
phones[0].setRomSize(64);

// iPhone XS Max (Bionic, 2GB RAM, 64GB internal storage)
phones[1].setProcessorType(Phone.ProcessorTypes.BIONIC);
phones[1].setRamSize(4);
phones[1].setRomSize(256);

// Samsung A50 (Exynos)
phones[2].setProcessorType(Phone.ProcessorTypes.EXYNOS);
phones[2].setRamSize(6);
phones[2].setRomSize(128);

// Samsung S20 (Exynos)
phones[3].setProcessorType(Phone.ProcessorTypes.EXYNOS);
phones[3].setRamSize(16);
phones[3].setRomSize(512);

// Samsung S10e (Exynos)
phones[4].setProcessorType(Phone.ProcessorTypes.QUALCOMM);
phones[4].setRamSize(64);
phones[4].setRomSize(128);
```

A práve tu sa dostávame k vyššie spomínaným *setterom*, teda **set** metódam. 

Samozrejme, tento prípad by sme v reálnom svete rieišli cez databázu a podobne,
ale nateraz to stačí (neskôr budeme všetko rozšírovať ešte). Takže poďme si
pozrieť ako by sme mohli jednotlivé telefóny vylistovať na výstup (teraz iba
na konzolu, ale rovnaký spôsob použitia pre výber parametrov by bol aj pre
webovú stránku či ktorýkoľvek iný výstup):

```
System.out.println("-------------------------------------------");
for (var phone : phones) {
    System.out.println("Phone: " +
           String.valueOf(phone.getBrand()) +
            ' ' + String.valueOf(phone.getModel()));
    System.out.printf("Specifications: Processor %s, %d RAM, %d Internal storage\n",
            phone.getProcessorType(), phone.getRamSize(), phone.getRomSize());
    System.out.println("-------------------------------------------");
}
```

Ako bolo spomínané vyššie v kóde, môžeme použiť aj **var** ako kľúčové slovo pre
definíciu premennej. Java typ následne automaticky rozpozná. 