# Triedy

Java je celá objektovo orientovaná. Znamená to, že čokoľvek je objekt.

## Úvod do objektového myslenia
Už aj keď
vytvárame základný výpis **Hello, World!**, kde pri neobjektových jazykoch stačí
väčšinou napísať niečo v zmysle, 
```
print ("Helllo, World!")
```
tak v Jave na toto potrebuje najskôr vytvoriť objekt (obyvkle by mal aj v 
nejakom) balíčku a následne v metdóde ```main``` (hlavná metóda z celého 
balíčku alebo triedy), môžeme vypísať naše **Hello, World!**. Teda správny
zápís by mal byť:

```java HelloWorld
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

```java HelloWorld
System.out.println("Hello, " + args[0]);
``` 

Keďže polia sa indexujú od 0, znamená to, že prvá vstupná hodnota v poli je 
práve označovaná ako **index 0**.

Trieda je súhrn nejakých vlastností (premenné triedy) a metód 
(hovoro v pre programatárov v neobjektových jazykoch to môžete označovať aj
ako "funkcie", hoc je tento výraz nesprávny a neodporúčaný).

V jave rozdeľujeme premenné a metódy na 2 hlavné typy:

- Instačné metódy / premenné: Sú také, ku ktorým môžeme pristupovať iba po 
vytvorení inštancie triedy (teda objektu)
- Statické metódy / premenné : Označujú sa modifikátorom ```static```  a môžeme 
ich volať priamo bez nutnosti vytvorenia inštancie triedy. Takýmto metódam alebo
premenným sa hovorí, že patria triede a nie objektu (hoc ich môžeme volať aj 
inštancie, teda z objektu). 

Aby sme mohli pokročiť, zoberme si, že chceme vytvoriť e-shop s mobilnými
telefónmi. Sme však iba začínajú eshop a tak máme v ponuke iba zopár modelov
a 2 značky s rôznymi typmi procesorov, rôznymi konfiguráciami pamäte a uložného
priestoru (ostatné parametre telefónov a elektroniky celkovo zatiaľ nebudeme
brať do úvahy). 

Definujeme si triedu:
```java Electroshop
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

```java Electroshop
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
nemáme definovaný, Java si ho vytvorí automaticky ako  **bezparametrický
konštruktor** (t.j. nemá žiadne vstupné parametre).

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

```java Phone
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

```java Electroshop
Phone[] phones = new Phone[5];

phones[0] = new Phone(Phone.Brands.APPLE, "8");
phones[1] = new Phone(Phone.Brands.APPLE, "X[S] Max");
phones[2] = new Phone(Phone.Brands.SAMSUNG, "A50");
phones[3] = new Phone(Phone.Brands.SAMSUNG, "S20");
phones[4] = new Phone(Phone.Brands.SAMSUNG, "S10 e");   
```

Teraz sme si však pozreli telefóny bližšie (pootáčali krabice, prečítali 
hodnoty)a môžeme doplniť chýbajúce parametre:

```java Electroshop
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

```java Electroshop
System.out.println("-------------------------------------------");
for (var phone : phones) {
    System.out.println("Phone: " + phone.getBrand() + ' ' + phone.getModel());
    System.out.printf("Specifications: Processor %s, %d RAM, %d Internal storage\n",
            phone.getProcessorType(), phone.getRamSize(), phone.getRomSize());
    System.out.println("-------------------------------------------");
}
```

Ako bolo spomínané vyššie v kóde, môžeme použiť aj **var** ako kľúčové slovo pre
definíciu premennej. Java typ následne automaticky rozpozná. 

## Modifikátory v triedach premenných, tried a metód
Modifikátory prístupu k metódam alebo vlastnostiam triedy:

### Default (without modifier)
Tento modifik8tor je použiteľný iba pri definícii triedy a znamená, že trieda je
použiteľná iba v danom balíčku (package). V inom balíčku toho projektu ju už 
nemôžeme použiť. 

### Public
Verejný prístup k premennej, metóde alebo triede. Znamená to, že daná vlastnosť
je použiteľná z inštancie triedy (objektu), v zdedených triedach alebo v triede
samotnej

### Protected
Tento modifikácor ide použiť iba pre vlastnosti (premenné) alebo pre metódy. Nie
však pre triedu samostnú. Hovorí o tom, že daná vlastnosť či metóda je 
použiteľná v samotnej triede alebo v triedach ktoré túto triedu dedia.

### Private
Je najskúromnejší model prístupnosti k vlastnosti triedy. Väčšinou sa používa
pri vlastnostiach (premenných). Znamená to, že s danou vlastnosťou smie pracovať
iba trieda samotná. Nejde to zavolať z objektu ani z tried, ktoré túto triedu
dedia. Na inicializovanie nejakej vlastnosti požom používame **getters** and
**setters**. Toto nejde použiť pre triedu samostnú, iba pre jej vlastnosti
(premenné a metódy).

Príklad:
```java
class PrivateTest {
    private String model;

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }
}
```

### Final
Keď sa pozrieme na našu triedu ktorá definuje mobilné telefóny, môžeme si
všimnúť, že premenné triedy ```brand``` a ```model``` sa nastavujú už priamo
v konštruktore. Tým, že nikde inde už pre danú inštanciu nemôžeme zmeniť značku
ani model, priamo nás to nabáda k tomu, aby sme týmto premenným dali modifikátor
```final```. Ten totiž hovorí o tom, že takejto premennej sa smie hodnota 
nastaviť iba raz a nesmie sa meniť. V prípade triedy, sa táto hodnota môže 
definovať priamo pri deklarácii premennej alebo v konštruktore triedy.

Príklad použitia v metóde:
```java Electroshop
final String samsungPhoneFullName = "Samsung Galaxy A51";

// alebo

final String iPhoneFullName;
iPhoneFullName = "iPhone 11 Pro";
```

Ak by sme sa pokúšali zmeniť hodnotu pre jednu z vyššie spomínaných premenných,
kompilátor by zhylal s chybou **Error:(x, y) java: cannot assign a value to 
final variable** pričom x reprezentuje riadok, kde hodnotu znovu meníme a y 
znak v danom riadku.

```final``` v deinícii premenných triedy znamená, že hodnota (ak nie je hodnota
priradená už pri deklarácii) sa smie definovať priamo v konštruktore. 

Preto, keďže nemáme už iné **set** metódy pre značku a model a definujeme ich v
konštruktore, zmeníme ich deklaráciu nasledovne:

```java Phone
final private Brands brand;
final private String model;
``` 

Ešte je dobré spomenúť, že final nemusia byť iba premenné, ale aj metódy.
Hovorí to o tom, že metódu final nemôže prepísať žiadny potomok triedy, kde
je final metóda použitá.

Krátky príklad:

```
class Foo {
    final void printMessage() {
        System.out.println("Hello, world!");
    }
}

class Bar extends Foo {
    void printMessage() {
        System.out.println("This will not work!");
    }
}
```

Dostali by sme hlášku:

```
'printMessage()' cannot override 'printMessage()' in 'com.java.package.Foo'; overridden method is final
```

Znamená to, že táto metóda nemôže byť **"overridden"**, teda metóda nemôže
byť prepísaná. Môže však byť preťažená, teda **"overloaded"**. Ak by sme
do vnútra pozmenili inicializáciu metódy ```printMessage()``` v triede
Foo na  ```void printMessage(int n)```, náš program by prešiel kompilátorom,
pretože metódu sme preťažily (teda použily iné vstupné parametre).

Nefungoval by však "trik", že ak by metóda ```printMessage()``` vracala napr.
```int``` v triede ```Foo``` a ```string``` v triede ```Bar```, pretože sa
stále jedná iba o prepisovanie a nie preťažovanie.


### Static
Statické premenné alebo metódy sú také, ktoré patria triede a nie objektu. Ich
základnou vlastnosťou je to, že ich môžeme volať bez nutnosti vytvárať
inštanciu triedy (objekt) ale môžeme ich volať priamo z triedy. Napr. ak by sme
chceli vedieť, koľko telefónov už máme v e-shope, môžeme si statickú premennú
pridať priamo do našej triedy s telefónmi nasledovne:

```Java Phone
private static int phoneCounter = 0;
```

do konštruktora pridáme:
```java Phone
phoneCounter++; 
```

a na záver, do metód ďalej pridáme **get** metódu:

```java Phone
public static int getPhoneCounter() {
    return phoneCounter;
}
```

Po správnej implementácii a zavolaní ```Phone.getPhoneCounter()``` v našej 
```main``` metóde by sme mali dostať nasledujúci výsledok:

```java Electroshop
System.out.println("Total cell phones for sell: " + Phone.getPhoneCounter());
```  

Výsledok by mal byť **5**, v prípade, že ste nepridávali iný počet telefónov.

## Metódy v triedach
O metódach sme si už vraveli vyššie, ale skúsme si povedať niečo viac o nich.
Základná štruktúra je taká, že každá metóda musí mať minimálne návratový typ
(v prípade, že metóda nič nevracia je to ```void```) a názov metódy. Konvencia
nám káže aby sa metóda vždy začínala malým písmenom a potom každé ďalšie slovo
z názvu metódy (keďže pri definíncii názvu metódy nemôžeme používať medzery) by
malo mať už veľké písmeno na začiatku.

V našom obchode s mobilnými tefónmi máme metódu, ktorá nám nám napríklad vráti
počet telefónov, ktoré máme v katalógu. Teraz však chceme pridať funkcionalitu,
ktorá nám vypíše všetky informácie o telefóne (vstupným parametrom bude 
inštancia objektu). V reálnom prípade by to mohlo slúžiť na zápis do databázy,
ale nateraz nám musí stačiť výpis na obrazovku.

Začneme teda definínicou a telom metódy (samozrejme v triede, ktorá pracuje s
telefónmi. V našom prípade je to **Phone.java**):
```java Phone
static void  savePhoneInformation (Phone phone) {
    System.out.printf("Brand: %s\n", phone.brand);
    System.out.printf("Model: %s\n", phone.model);
    System.out.printf("Specifications: %d GB RAM, %d GB internal storage\n",
            phone.ramSize, phone.romSize);
}
```
modifikátorom ```static``` sme si definovali, že metóda bude patriť triede a nie
objektu (resp. inštancii triedy). ```void``` nám zase definoval, že táto metóda
nemá žiadnu návratovú hodnotu (ak by sme ukladali do databázy, vracali by sme
zrejme aspoň ```boolean``` **true** alebo **false** podľa toho, či sa telefón
podaril uložiť do databázy alebo nie.). Nasleduje názov metódy podľa konvencie
a následne v zátvorkách je vstupný parameter (budeme mu predávať nejakú 
inštanciu triedy ```Phone``` a pomenovali sme ju ako ```phone```). Telo metódy
už neobsahuje nič dôležité, len obyčajný výpis.

Implementácia metódy v ```main``` metóde:
```java Electroshop
Phone.savePhoneInformation(phones[2]);
```
Povedzme však, že túto metódu chceme rozšíriť a chceme aby v databáze upravila
jeden vstupný parameter (v tom prípade ho iba opať vypíšeme). Urobíme si metódu
presne s takým istým názvom ale počet vstupných parametrov bude iný.

Najskôr si však potrebujeme upraviť súbor **Phone.java** kde doplníme 
nasledovné: 
```java Phone
enum Props {BRAND, MODEL, PROCESSOR_TYPE, RAM, ROM}
```
Keďže nevieme, čo chceme z telefónu modifikovať (v tomto prípade len vypísať),
je dobré si urobiť zoznam *Properties* (vlastností), ktoré je možné modifikovať

Následne nasleduje samotná metóda:
```java Phone
static void savePhoneInformation (Phone phone, Props property) {
    switch (property) {
        case BRAND: System.out.println("Brand: " + phone.brand); break;
        case MODEL: System.out.println("Model: " + phone.model); break;
        case PROCESSOR_TYPE: System.out.println("Model: "
                + phone.processorType); break;
        case RAM: System.out.println("RAM: " + phone.ramSize); break;
        case ROM: System.out.println("Storage: " + phone.romSize); break;
    }
}
``` 

Telo funkcie je snáď jasné, switch a case sme si už vysveľovali v 
predchádzajúcich kapitolách.

>To, že môžeme mať 2 metódy s rovnakým názvom ale s rozdielnym počtom vstupných
>parametrov, to sa v objektovom programovaní navýva preťažovanie metód
>(v angličtine tzv. **Overloading**). Exsituje aj pretypovanie metód ale k tomu
>sa dostaneme ešte (anglicky **Overriding**). To je ak máme metódu v tirede
>ktorá je napríklad potomkon inej triedy s takou istou metodou a vytvarame 
>instanciu novej triedy a tam zavoláme danú metódu, tak sme pretypovali práve
>v potomkovi metódu.

Pri vstupných parametroch je dobré poznačiť, že pozor na rozdiel medzi
hodnotovými a referenčnými dátovými typmi. 

Vyskúšajme si veľmi jednoduchý príklad (mimo nášho eshopu). V našej triede
**Electroshop.java** si po main vytvoríme ešte jednu metódu a to konkrétne
```dataTypeDifference``` nasledovne:

```java ElectroShop
static void dataTypeDifference(int studentID, String studentName) {
    studentID = 2;
    studentName = "Peter";
    System.out.printf("Student with ID %d is called %s\n",
            studentID, studentName);
}
```

následne spravme implementáciu nasledovným štýlom:

```java Electroshop
int studentID = 5;
String studentName = "Martin";
System.out.printf("Student with ID %d is called %s\n",
        studentID, studentName);
dataTypeDifference(studentID, studentName);
System.out.printf("Student with ID %d is called %s\n",
        studentID, studentName);
```

Výstup bude nasledovný:

```
Student with ID 5 is called Martin
Student with ID 2 is called Peter
Student with ID 5 is called Martin
```

Je to z dôvodu, že ak vnútorne prepíšeme hodnotu nejakej premennej v metóde, 
platí iba pre tú danú metódu. Nebude mať vplyv na pôvodnú hodnotu.

Ak chceme, aby sa aj druhý výpis rovnal menu **Peter** a nie **Martin**, musíme
použiť ```StringBuilder```

Zmeníme našu metódu ```dataTypeDifference``` nasledovne:

```
static void dataTypeDifference(int studentID, StringBuilder studentName) {
    studentID = 2;
    studentName.replace (0, studentName.length(), "Peter");
    System.out.printf("Student with ID %d is called %s\n",
            studentID, studentName);
}
```

a implementáciu nasledovne:
```
int studentID = 5;
StringBuilder studentName = new StringBuilder("Martin");
System.out.printf("Student with ID %d is called %s\n",
        studentID, studentName);
dataTypeDifference(studentID, studentName);
System.out.printf("Student with ID %d is called %s\n",
        studentID, studentName);
```
Teraz bude výstup vyzerať nasledovne:
```
Student with ID 5 is called Martin
Student with ID 2 is called Peter
Student with ID 5 is called Peter
```
Je to kvôli tomu, že pôvodný string (v tomto prípade iba referenciu na **neho!**
sme si zmenili prostredníctvom metódy ```replace()``` v triede 
```StringBuilder``` hodnotu tohto stringu. Nevytvoril v našej metóde nový
dátový typ ```String``` ale odkázal sa (zato sa to volá referenčný dátový typ)
na pôvodnú deklaráciu ```studentName``` a tam pomcou ```replace``` zmenil
časť alebo v našom prípade celý string na inú hodnotu.  

>Teraz tento zmätok môžeme zmazať ale treba to mať na zreteli a dobre si to 
>zapamtať!

#### Miešanie static a non-static premenných

Statické premenné v triedach môžeme používať aj non-static metódach. Naopak
to však neplatí.

Teda, ak máme premennú ktorá patrí triede (je static), napr. 
```static int a;```, môžeme ju použiť aj metóde ktorá neni statická, napríklad
```void useStaticVariableInThisMethod()```.

Naopak, ak by sme chceli použiť premennú a z triedy, ktorej deklarácia 
by vyzerala nasledovne ```int a;``` v metóde 
```static void useNonStaticVariableInTHisMethod()```, tak by sme už dostali
kompilačnú chybu, že nemôžeme používať nestatické premenné v statickej metóde.

## Premenné z pohľadu deklarácie
Každá premenná musí niekomu patriť. Môžeme si to rozdeliť nasledovne:

- Deklarácia v triede (je možné ju používať v metódach) alebo aj priamo ak je
```public```, toto hoc niekedy môže prísť ako dobré riešenie, vo všeobecnosti
sa to neodporúča (používať s rozumom)
- Lokálna premenná hovorí o tom, že daná premenná bude použiteľná iba v metóde
v ktorej bola deklarovaná
- Statické premenné deklarované v triede. Spomínali sme vyššie, kde sme
slovíčku ```static``` venovali celú kapitolu. Pre zhrnutie, znamená to, že 
premenná patrí tirede. Je použiteľná iba v static metódach alebo, opäť v 
inštancii triedy (objekte) v prípade, že je ```public``` 

Premenná v tirede stačí, aby bola iba inicializovaná. Môže, ale aj nemusí jej
byť priamo priradená hodnota. V prípade, že ide o deklaráciu premennej s 
modififátorom ```final```, v takom prípade jej musí byť hodnota priradená
v konštruktore triedy.   

>Treba pamätať na to, že ak deklarujeme premennú v triede primitívneho dátového
>typu, bude mať svoju štandartnú *"defaultnú"* hodnotu. Napríklad. ak dáme
>```int a;``` budeme ju môcť v metóde použiť ale treba počítať s tým, že jej
>hodnota bude 0. Boolean bude mať hodnotu "**false**" ale ```String``` bude
>```null``` a nebude to prázdny String, pretože to nie je primitívny dátový
>typ. Neplatí do však pre deklaráciu premenenej v metóde. Viď nižšie.
 
Avšak, premenná v metóde už musí byť inicalizovaná. Iba
deklarácia nestačí. Teda ak by sme mali iba ```int a;``` v metóde by sme s ňou
chceli pracovať, nemôžeme očakávať, že bude mať hodnotu 0, tak ako to bolo, 
keď sme ju deklarovali iba v triede.

#### Zatienie premennej
V prípade, že máme nejakú premennú inicializovanú v triede a následne premennú
s takým istým menom v metóde, hovoríme o zatienení premennej. Na to aby sme
vytiahli hodnotu premennej z triedy, musíme použiť s použitím ```this``` 
alebo s názvom metódy z ktorej chceme premennú brať (```this``` ide použiť iba
v prípade, že premenná je v tej istej triede ako metóda ktorá premennú triedy
zatieňuje. Príklad:

```
class Foo {
    String s = "Hello";

    void printHelloWorld() {
        String s = "World";
        System.out.println(this.s + ", " + s + "!");
    }
    
}
```

Následne by sme si kdesi v metóde ```main``` vytvorili inštanciu triedy 
```Foo``` a zavolali metódu ```printHelloWorld()```.

>Treba mať na pamäti, že this ide použiť iba non-static premenných! V prípade,
>že by sme dali ```String s``` ako static, nemohli by sme ju použiť v kontexte
>```this.s```!

Ak by sme tento príklad chceli prerobiť na to, aby sme použili statickú premennú
a statickä metódu (aby si nebolo treba vytvárať obekt), tak by ho upravili 
nasledovne:
```
class Foo {
    static String s = "Hello";

    static void printHelloWorld() {
        String s = "World";
        System.out.println(Foo.s + ", " + s + "!");
    }

}
```
Trik je v tom, že pri výpise sa neodkazuje cez ```this``` ale priamo cez názov
metódy, z ktorej premennú berieme. Tá musí byť tiež statického kontextu. 
Následne by ```main()``` stačilo použiť ```Foo.printHelloWorld();``` a výsledok
by bol tototný.

>Hlavne treba pamätať na to, že nemôžeme miešťať static a non-static premenné
>a metódy ako sa nám zachce! Teda ak dostaneme hlášku typu: 
>**non-static variable s cannot be referenced from a static context**, tak už
>budeme vedieť kde asi hľadať chybu.



Zásadný rozdieľ je v tom, že cez ```this``` sa vždy odkazujeme na premennú
triedy (ďalej to budeme nazývať už vlastnosť triedy) zatiaľ čo ak zatienime
premennú v metóde (či už formou vstupného parametra alebo vo vnútri metódy),
tak bez použitia ```this``` sa odkazujeme na premennú toho najmenšieho lokálneho
bloku (nemusí to byť len premenná v rámci metódy, môže to byť premenná v rámci
podmienky alebo cyklu).

Opäť toto najlepšie pochopíme na príklade:

```
class Car {
    int color;
    String brand = "Audi";

    void setColor(int color) {
        this.color = color;
    } 

    void setBrand(String band) {
        this.brand = brand;
    }
}
```

Keď nastavujeme farbu auta cez ```setColor```, všetko je v poriadku. 
```this.color``` nám poukazuje na vlastnosť triedy a ```color``` nám hovorí, 
že takéto číslo priradíme.

Pri ```setBrand``` je už situácia iná. Všimnime si hlášky (vo väčšide Java IDE)
*Variable 'brand' is assigned to itself*. Nie je to kompilačná chyba, program
by nám zbehol, ale je blbosť aby sa hodnota nejakej vlastnosti triedy odkazovala
na seba samú. A to z dôvodu, že vo vstupnom parametri máme ```String band```,
teda asi preklep. 

Tomuto sa hovorí tvz. logické chyby. Pozor na ne! Program sa skompiluje a všetko
bude fungovať akurát, nikdy vždy budeme dostávať značku auta "Audi", aj keby sme
nastavili "Škoda". Pozrime sa na implementáciu:

```java Car
Car c = new Car();
System.out.println("Default color: " + c.color );
System.out.println("Default brand: " + c.brand );
c.setColor(4);
c.setBrand("Skoda");
System.out.println("New color: " + c.color );
System.out.println("New color: " + c.brand );
```

dostaneme nasledovný výstup:

```output
Default color: 0
Default brand: Audi
New color: 4
New color: Audi
```

A to preto, že štandartná hodnota pre ```int``` je 0 ak je to ako vlastnosť 
triedy, to už vieme. Ale zmenili sme to cez ```setColor()``` metódu. Vlastnosti
triedy sa cez ```this.color``` nastavila premenná ```color``` ktorá je použitá
ako vstupný parameter metódy ```setColor```. Ale značku auta sme nezmenili 
kvôli preklepu a aj keď vnútro metódy bolo napísané správne, vstupný parameter
obsahoval preklep.

A teraz ideme rozširovať náš obchod