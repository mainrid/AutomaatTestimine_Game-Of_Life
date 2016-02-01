Iseseisev töö 1

Kirjutage rakendus, mis arvutab järgmise kaadri Game of Life mängus.

Game of Life mängu mõte on see, et esialgselt määratakse etteantud maatriksisse 
mõned rakud. Seejärel pannakse mäng käima, mis tähendab, et rakud hakkavad
oma elu elama: etteantud reeglite põhjal otsustatakse, kas rakk jääb elama,
sureb või paljuneb. Otsustamine käib üksnes selle põhjal, kui palju naabreid
konkreetsel rakul on.

Reeglid:

  Igal rakul on kuni kaheksa nabrit (üleval, all, paremal, vasakul + diagonaalid)

  Kui rakul on alla kahe naabri, siis ta sureb (alarahvastatus).
  Kui rakul on kaks või kolm naabrit, siis elab ta edasi.
  Kui rakul on üle kolme naabri, siis ta sureb (ülerahvastatus).
  Kui surnud rakul (ehk rakk puudub) on täpselt kolm naabrit, siis ta elustub (paljunemine).

Conway's Game of Life: http://en.wikipedia.org/wiki/Conway's_Game_of_Life.
Videoülevaade: http://www.youtube.com/watch?v=CgOcEZinQ2I&list=FLfJhvjUWZh8bM3O09S_e_TQ

Natuke näidiskoodi: https://bitbucket.org/mkalmo/atex/src/master/src/main/java/gol

Hindamise kriteeriumid

  1. Rõhk on testidel. Programm on lihtsalt selleks, et oleks millele teste kirjutada.
  2. Testid on kvaliteetsed (1. loeng).
     Mõelge, mis on automaattestimise eesmärk (1. loeng).
     Testime funktsionaalsust, mitte meetodeid.
     Testi nimi on olulise tähtsusega.
  3. Ei ole mõttetuid teste (iga test peab väärtust omama).


Lõpliku programmi korrektsuse kontrolliks võite allolevaid juhte kasutada.

Paikne

------ ------
--XX-- --XX--
-X--X- -X--X-
--XX-- --XX--
------ ------ jne..

Pulseerija

------ ------ ------
-XX--- -XX--- -XX---
-X---- -XX--- -X----
----X- ---XX- ----X-
---XX- ---XX- ---XX-
------ ------ ------ jne..

Liikuja

-X---- --X--- ------ ------
--XX-- ---X-- -X-X-- ---X--
-XX--- -XXX-- --XX-- -X-X--
------ ------ --X--- --XX-- jne..
