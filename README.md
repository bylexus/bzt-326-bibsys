Beispielprojekt "Bibliothekssystem" für das Modul 326
=====================================================

Ziel: Beispielhafte Implementation eines Bibliothekssystems aufgrund OO-Analys und -Design. Work in Progress.

Dieses Repository ist ein Eclipse-Java-Projekt. Alle benötigten Libraries wurden der Einfachheit halber
ins Repository aufgenommen. Besser wäre eine Maven-Lösung, dies ist an dieser Stelle aber nicht umgesetzt.

Starten der Demo-Applikation
----------------------------

`$ ./bibsys.sh`

oder:

`$ java -cp "bin/" business.Main`


Datenbank
---------

Dieses Projekt verwendet KEINE Datenbank: Dies ist nicht das Ziel des Moduls, und die Einführung
einer Datenbank / ORM / SQL wäre zu komplex.

Die Datenhaltung passiert ganz simpel in einem globalen DataContainer, und wird via Objektserialisierung
beim Start geladen / beim Beenden gespeichert.

