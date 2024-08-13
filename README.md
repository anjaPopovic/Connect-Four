# Connect-Four
Projekat iz predmeta CS203 - Algoritmi i strukture podataka koji simulira popularnu igricu Connect Four u Java programskom jeziku.

## Uvod

Ova aplikacija predstavlja implementaciju igrice **Connect Four**. Igra je napravljena u JavaFX-u koristeći programski jezik Java u IntelliJ IDEA razvojnom okruženju.

### Postavka zadatka

**Connect Four** je klasična igrica za dva igrača koja se igra na tabli dimenzija 7 kolona i 6 redova. Igrači naizmenično postavljaju svoje žetone u kolone, s tim što se kolone popunjavaju od dna ka vrhu. Cilj je postaviti četiri žetona u nizu (vodoravno, vertikalno ili dijagonalno). Igra se završava kada jedan igrač postavi četiri žetona u nizu ili kada se tabla popuni.

### Ishodi igre

1. **Pobeda:** Ako jedan igrač postavi četiri uzastopna žetona, on pobeđuje. Igrači dobijaju mogućnost da ponovo igraju ili da se povuku.
2. **Nerešena igra:** Ako je cela tabla popunjena, a nijedan igrač nije pobedio, igra je nerešena. Takođe, igrači mogu ponovo igrati ili se povući.

### Metode igre

1. **`dropPiece(int column)`** - Postavlja žetone u krugove.
2. **`checkForWin(int row, int column)`** - Proverava da li je jedan igrač pobedio.
3. **`checkForDraw()`** - Proverava da li je igra nerešena.
4. **`showResult(String winner)`** - Prikazuje rezultat igre u pop-up prozoru i nudi opcije za ponovni početak ili izlazak iz igre.
5. **`resetGame()`** - Vraća igru na početno stanje.

## Izgled aplikacije

Početna stranica aplikacije:

![image](https://github.com/user-attachments/assets/7d3590a4-5811-4bc8-934b-66bb0f3f69a9)


## Zaključak

Implementirana igra **Connect Four** zadovoljava osnovne zahteve za projekat i pruža funkcionalno i interaktivno iskustvo igre za dva igrača.

