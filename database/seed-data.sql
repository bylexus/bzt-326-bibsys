INSERT INTO benutzer
(id,login, vorname, nachname, email,admin,bib_ma,passwort)
VALUES
(NEXT VALUE FOR hibernate_sequence,'alex','Alexander','Schenkel','alex@alexi.ch',false,false,'4135aa9dc1b842a653dea846903ddb95bfb8c5a10c504a7fa16e10bc31d1fdf0'),
(NEXT VALUE FOR hibernate_sequence,'ma','Bib','MA','ma@bibsys.ch',false,true,'3c44c3e1b8b7844786724ac776d3d90ee7eac452bdbcb44495b77dec2ef73cfe'),
(NEXT VALUE FOR hibernate_sequence,'admin','Admin','Admin','admin@bibsys.ch',true,false,'8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918');

