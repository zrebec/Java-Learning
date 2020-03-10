# Java Basics

Rýchle poznámky k tomu čo som sa naučil v Jave. Netreba sa tu trápiť anglickým prekladom, slúži čisto pre súkromné účely

## Dátové typy v Jave

V takmer každom programovacom jazyku s tzv. silným typovaním, poznáme 2 základné dátové typy

- Hodnotové dátové typy
  - Sú to dátové typy ktoré sa ukladajú priamo do pamäte. 
  - V Jave sú to tzv. primitívne dátové typy ako napr. int, char, boolean, byte, double či enum
- Referenčné dátové typy
  - Referenčné dátové typy sa ukladajú do tzv. haldy (ang. heap). Je to adresný priestor v pamäti. 
  - To znamená, že názov premennej (objekt) sa odkazuje na hodnotu v tejto halde. 
  - Haldu raz za čas prechádza GC a vyhadzuje veci, ktoré už neobsahujú žiadnu referenciu na seba.
  
### Zhrnutie
Základný rozdieľ je teda v tom, že zatiaľ čo hodnoty u hodnotových dátových typov sú uložené v priamo v pamäti (na nejakej špecifickej adrese), tak v referenčných dátových typoch je to tak, že hodnota je v halde a do pamäte sa ukadá iba referencia na hodnotu v tejto halde.  

####Enum
Pre zaujímavosť treba spomenúť hodnotový dátový typ enum. Tento nesmie byť použitý vo vnútri metódy.
Sám je definovaný ako trieda. Teda môže sa použiť akokeby samostatná trieda (v samostatnom súbore kľudne)
alebo sa smie definovať vo vnútri existujúcej triedy (nie však metóde!), napr.:

```
class Foo {

	enum Severity {LOW, MEDIUM, HIGH}

	public static void main(String[] args) {
		logSeverity(Severity.MEDIUM);
	}

	public static void logSeverity(Severity s) {

		switch (s) {
			case LOW:
				System.out.println("Low severity problem");
				break;
			case MEDIUM:
				System.out.println("Medium severity problem");
				break;
			case HIGH:
				System.out.println("High severity problem");
				break;
			default:
				System.out.println("Problem has not severity");
				break; // Break is not necessary here but it's recommended
		}

	}
}
```
Keby sme definovali **Severity** vo vnútri metódy main, nefungovalo by to  
Ešte jedna zaujímavosť, nemusí byť *dvojbodka* ```;``` 

## Operátori

### Inkrementácia, Decrementácia
- ```i++``` Vráti najskôr hodnotu i a potom priráta 1
- ```++i``` Najskôr priráta 1 následne vráti hodnotu i
- ```i--``` Vráti hodnotu i následne odráta 1
- ```--i``` Odráta 1 a následne vráti hodnotu i
- ```i += 4``` K súčasnej hodnote i priráta 4 a následne výsledok priradí do premennej i (znamená to vlastne i = i + 4)
- ```i -= 2``` Od súčasnej hodnoty i odráta 2 a následne výsledok priradí do premenneji i (znamená to vlastne i = i -2)

### Ščítanie, násobenie, reálne celočíselné delenie, modulo (zvyšok po celočíslenom delení)
- ```2+4``` Pripočíta 4 (výsledok bude 6)
- ```2-4``` Odpočíta 4 (výsledok bude -2)
- ```2*4``` Vynásobí štyrmi (výsledok bude 8)
- ```4/2``` Vydelí dvoma (výsledok bude 2)
- ```6%3``` Výsledok bude 0 pretože, 6/3 = 2 a zvyšok je 0
- ```5%3``` Výsledok bude zvyšok po delení (nie však ako na kalkulačke - zistiť prečo)

### Termárny operátor
Ide o operátor kde po vyhodnotení podmienky ako true sa vykoná niečo za otázníkom, a pri false za dvojbodkou (toto je operátor a nie je potrebné ho podmieňovať podmienkou if)

```System.out.println( "Number " + i + ( (i % 2 == 0) ? " is even" : " is odd" ) );```

## Statements
V jave máme 3 druhy statements (declaration, expression a control flow statements)

### Declaration statements
Vznikajú pri deklarácii premennej. 

- ```int i;``` Iba sme deklarovali premennú i ale nepriradili sme jej žiadnu hodnotu. Napr. aby sme mohli pripočítať k nej 5, musíme jej nejakú hodnotu priradiť. Ak nie v deklarácii tak potom ako expression statement
- ```int i = 5, j = 4;``` Deklarovali sme premenné i a j typu integer a priradili sme im hodnoty 5 a 4 (toto sa dá použiť napr. aj vo for cykle aj keď sa to neodporúča kvôli čitateľnosti kódu)

### Expression statements
Vznikajú po deklarácií alebo formou nejakej matematickej operácie už s nejakou inou existujúcou premennou

- ```i = 5;``` Pridali sme hodntu 5 do premnejj i ktorú už ale pred tým máme deklarovanú
- ```j = 4*i + 10;``` Do premennej j (tiež už musela byť deklarovaná) vložíme hodnotu kde premennú i vynásobíme štyrmi a následne pripočítame 10 (pozor, dodržuje sa poradie počtových výkonov!)
- ```animal = new Animal();``` Do premennej animal (už musela byť deklarovaná) sme vložili novú inštanciu triedy Animal

### Control Flow statements
To sú bežné príkazy pre riadenie cyklu aplikácie (programu). if, else, while, for, try, return, switch

#### For cyklus
For cyklus môžeme zapísať viacerými spôsobmi, napr. 
```for( ; ; ) ``` vytvorí nekonečný cyklus (vždy sa dá zrušiť cez ```break```)

Je však možné napísať aj dve či viac premených do ktorejkoľvek časti cyklu ```for```:
```
for(int i=0, j = 0; i <= 5 && j < 4; i++, j++) {
    System.out.printf("i = %d, j = %d\n", i, j);
}
```

Toto sa však neodporúča kvôli čitateľnosti kódu

Ak chceme premennú z cyklu používať aj po ukončení cyklu, je potrebné ju deklarovať mimo cyklu ```for```
a následne ju môžeme používať ďalej. Viď nasledujúci príklad:
```
int i = 0;
for( ; i <= 5; ++i ) {
    System.out.println(i);
}

System.out.printf("Final result outer of cycle is %d\n", i);
System.out.printf("Note! The cycle ends when condition is filled. That's the reason " +
        "why \"i\" will be 6!\n");
```

#### Switch

Switch sa používa pri vyhodnocovaní podmienky vo "**vetvách**". Na rozdiel od ```if```
má napr. tú výhodu, že ľahšie dokážeme zadefinovať "**or**" (v Jave ```||```), 
tým že dáme jeden blok pod viac vetiev a (viď príklad nižšie) alebo, to, že
ak nepoužíjeme ```break```, vykoná sa všetko ostatné vo switch za tou našou vyhovujúcou
vetvou (Áno, niekedy je toto žiadúce ale požíva sa to iba veľmi zriedka a osobne sa nestretol s takýmto
prípadom, ani som ho sám neriešil).

Platí niekoľko základných pravidiel:   

- Switch môže mať ako vstupné hodnoty buď hodnotový dátový typ **int**, **byte**, **short**, **char** či **enum**.  
- Od JDK >= 7 to môže byť aj referečný dátotý typ **String**  
- Nesmie to byť hodnota typu **long**, **float**, **double**
- Default vetva nemusí byť povinná ale je "mnou odporúčaná". 
- Rovnako break v poslednej vetve (spravidla default) nemusí obsahovať break, ale je to všeobecne odporúčané.

Ak chceme vykonať jeden logický block pre viac ```Case``` vetiev, napíšeme ich pod seba
  ako napríklad (vyhovie ak i bude 1 alebo 2):
  ```
  switch (i) {
      case 1:
      case 2:
         // Do something
         break;
  }
  ```    

Príklad **"switch"** (práve s použitím enum) je možné vidieť vyššie pri dátových typoch.