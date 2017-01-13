Beispielprojekt "Bibliothekssystem" für das Modul 326
=====================================================

Ziel: Beispielhafte Implementation eines Bibliothekssystems aufgrund OO-Analys und -Design. Work in Progress.

Dieses Repository ist ein Eclipse-Java-Projekt. Alle benötigten Libraries (log4j, hibernate, hsqldb) wurden der Einfachheit halber
ins Repository aufgenommen. Besser wäre eine Maven-Lösung, dies ist an dieser Stelle aber nicht umgesetzt.

Starten der Demo-Applikation
----------------------------

`$ ./bibsys.sh`

oder:

`$ java -cp "lib/*:lib/hsqldb/lib/hsqldb.jar:lib/hibernate/*:bin/" business.Main`


Datenbank
---------

Für das Beispielsystem wird eine hsqldb angelegt. Diese ist im Verzeichnis "database" als DB "bibsys" zu finden.

Für einen minimalen Satz an Daten kann nach dem ersten Start der Applikation (DB-Schema wird beim ersten Verbinden automatisch angelegt)
das File `database/seed-data.sql` importiert werden.

Start des hsqldb-Management-UIs:

`$ ./dbManager.sh`

oder:

`java -cp lib/hsqldb/lib/hsqldb.jar org.hsqldb.util.DatabaseManagerSwing`




