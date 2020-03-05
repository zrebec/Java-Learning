# Java Basics

Rýchle poznámky k tomu čo som sa naučil v Jave. Netreba sa tu trápiť anglickým prekladom, slúži čisto pre súkromné účely

## Dátové typy v Jave

V takmer každom programovacom jazyku s tzv. silným typovaním, poznáme 2 základné dátové typy

- Hodnotové dátové typy
  - Sú to dátové typy ktoré sa ukladajú priamo do pamäte. 
  - V Jave sú to tzv. primitívne dátové typy ako napr. int, char, boolean, byte, double
- Referenčné dátové typy
  - Referenčné dátové typy sa ukladajú do tzv. haldy (ang. heap). Je to adresný priestor v pamäti. 
  - To znamená, že názov premennej (objekt) sa odkazuje na hodnotu v tejto halde. 
  - Haldu raz za čas prechádza GC a vyhadzuje veci, ktoré už neobsahujú žiadnu referenciu na seba.
