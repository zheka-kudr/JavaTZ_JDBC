--
-- File generated with SQLiteStudio v3.2.1 on Fri May 10 13:05:27 2019
--
-- Text encoding used: System
--
PRAGMA foreign_keys = off;
BEGIN TRANSACTION;

-- Table: lekarz
CREATE TABLE lekarz
(
    ID_Lekarz     integer PRIMARY KEY AUTOINCREMENT,
    Imie          STRING NOT NULL,
    Nazwisko      STRING NOT NULL,
    Specjalizacja STRING NOT NULL
);
INSERT INTO lekarz (ID_Lekarz, Imie, Nazwisko, Specjalizacja)
VALUES (1, 'Jan', 'Piotrowski', 'Dentysta');
INSERT INTO lekarz (ID_Lekarz, Imie, Nazwisko, Specjalizacja)
VALUES (3, 'Jakub', 'Gałązka', 'Chirurg');

-- Table: pacjenci
CREATE TABLE pacjenci
(
    ID_pacjent INTEGER PRIMARY KEY AUTOINCREMENT,
    Imie       STRING NOT NULL,
    Nazwisko   STRING NOT NULL
);
INSERT INTO pacjenci (ID_pacjent, Imie, Nazwisko)
VALUES (4, 'Kasia', 'Pawluś');

-- Table: wizyta
CREATE TABLE wizyta
(
    ID_Wizyta      integer PRIMARY KEY AUTOINCREMENT,
    ID_Pacjent     integer NOT NULL,
    ID_Lekarz      integer NOT NULL,
    Pokoj          integer NOT NULL,
    Czy_zakonczona integer NOT NULL,
    Czas           STRING NOT NULL,
    FOREIGN KEY (ID_pacjent) REFERENCES pacjenci (ID_pacjent),
    FOREIGN KEY (ID_Lekarz) REFERENCES lekarz (ID_Lekarz)
);
INSERT INTO wizyta (ID_Wizyta, ID_Pacjent, ID_Lekarz, Pokoj, Czy_zakonczona, Czas)
VALUES (1, 4, 1, 111, 0, '14');
INSERT INTO wizyta (ID_Wizyta, ID_Pacjent, ID_Lekarz, Pokoj, Czy_zakonczona, Czas)
VALUES (2, 4, 3, 148, 0, '8:40-9');

COMMIT TRANSACTION;
PRAGMA foreign_keys = on;
