INSERT INTO benutzer
(id,login, vorname, nachname, email,admin,bib_ma)
VALUES
(NEXT VALUE FOR hibernate_sequence,'alex','Alexander','Schenkel','alex@alexi.ch',false,false),
(NEXT VALUE FOR hibernate_sequence,'ma','Bib','MA','ma@bibsys.ch',false,true),
(NEXT VALUE FOR hibernate_sequence,'admin','Admin','Admin','admin@bibsys.ch',true,false);
