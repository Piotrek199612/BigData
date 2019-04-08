## Zadania projektowe

### Projekt pierwszy

20. Zaimplementuj **pierwszy z projektów** BicycleTripCount:
    _Wyznacz liczbę przejazdów wykonanych za pomocą każdego z rowerów_.

```
Na początku zaimplementuj proste rozwiązanie o budowie analogicznej do AvgSizeStations z tutorialu.
```
21. Dopiero kiedy będzie ono działało, rozbuduj je o następujące komponenty:
<ol type="a">
  <li>Zaimplementuj i wykorzystaj własną funkcję łączącą (agregator łączący)</li>
  <li>Wykorzystaj liczniki, aby znaleźć różnicę pomiędzy liczbą rekordów utworzonych w wyniku funkcji
       mapującej a liczbą wartości (nie rekordów) otrzymanych na wejściu funkcji redukującej – dzięki temu
       będziemy wiedzieli jaki wpływ na ilość przesłanych danych miała funkcja łącząca</li>
  <li>Zaimplementuj testy jednostkowe dla funkcji mapującej i redukującej</li>
  <li>Dla testowego zbioru danych (zawierającego np. 10 pierwszych wierszy z pliku trips.csv)
       zaimplementuj testy całego sterownika</li>
</ol>
22. Jeśli masz już gotową i przetestowaną implementację, wówczas:
<ol type="a">
  <li>wygeneruj plik jar,</li>
  <li>prześlij go do maszyny z klastrem Hadoop, a następnie</li>
  <li>uruchom z poziomu linii komend w ramach klastra Hadoop</li>
</ol>