CREATE TABLE benutzer (
  id INTEGER IDENTITY PRIMARY KEY,
  login VARCHAR(50),
  vorname VARCHAR(50),
  nachname VARCHAR(50),
  email VARCHAR(256),
  passwort VARCHAR(512),
  admin BOOLEAN,
  bib_ma BOOLEAN
);