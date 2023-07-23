DROP DATABASE IF EXISTS ArtMarketOnline;
CREATE DATABASE IF NOT EXISTS ArtMarketOnline;
USE ArtMarketOnline;

DROP USER IF EXISTS 'ArtMarketOnlineManager'@'localhost';
CREATE USER 'ArtMarketOnlineManager'@'localhost' IDENTIFIED BY 'Prodotti';
GRANT ALL ON ArtMarketOnline.* TO 'ArtMarketOnlineManager'@'localhost';


CREATE TABLE Utente (
Nome VARCHAR(20) NOT NULL PRIMARY KEY,
Password VARCHAR(50) NOT NULL,
Admin BOOLEAN DEFAULT FALSE
);

CREATE TABLE MetodoPagamento(
ID CHAR(15) NOT NULL PRIMARY KEY,
Utente VARCHAR(20) NOT NULL,
FOREIGN KEY (Utente) REFERENCES Utente(Nome)
);

CREATE TABLE Ordine(
CodiceOrdine INT UNSIGNED AUTO_INCREMENT NOT NULL PRIMARY KEY,
Utente VARCHAR(20) NOT NULL,
DataOrdine DATETIME DEFAULT CURRENT_TIMESTAMP ,
Prezzo DECIMAL(5,2),
Descrizione VARCHAR(256) DEFAULT "",
FOREIGN KEY (Utente) REFERENCES Utente(Nome)
);

CREATE TABLE Opera(
Codice INT UNSIGNED AUTO_INCREMENT NOT NULL PRIMARY KEY,
Titolo VARCHAR(20),
Autore VARCHAR(20),
UrlImmagine VARCHAR(256),
FOREIGN KEY (Autore) REFERENCES Utente(Nome)
);

CREATE TABLE Formato(
Nome VARCHAR(30) NOT NULL PRIMARY KEY,
Dimensioni VARCHAR(10) NOT NULL,
Materiale VARCHAR(15) NOT NULL
);

CREATE TABLE Prodotto(
Codice INT UNSIGNED NOT NULL PRIMARY KEY auto_increment,
Opera INT UNSIGNED NOT NULL,
Formato VARCHAR(30) NOT NULL,
Prezzo DECIMAL(5,2),
FOREIGN KEY (Opera) REFERENCES Opera(Codice),
FOREIGN KEY (Formato) REFERENCES Formato(Nome)
);

-- Attributo di Prodotto

CREATE TABLE Tag(
Opera INT UNSIGNED AUTO_INCREMENT,
Categoria VARCHAR(20), 
PRIMARY KEY (Opera,Categoria)
);

CREATE TABLE Include(
Ordine INT UNSIGNED,
Prodotto INT UNSIGNED,
FOREIGN KEY (Ordine) REFERENCES Ordine(CodiceOrdine)
ON DELETE CASCADE,
FOREIGN KEY (Prodotto) REFERENCES Prodotto(Codice),
PRIMARY KEY (Ordine,Prodotto)
);
INSERT INTO Utente(Nome,Password) VALUES ("Tizio","Test");
INSERT INTO Utente(Nome,Password) VALUES ("Caio","Toast");
INSERT INTO Utente(Nome,Password,Admin) VALUES ("Boss","Big",true);

INSERT INTO Formato VALUES ("TelaGrande", "80x60", "Tela");
INSERT INTO Formato VALUES ("TelaPiccola", "40x30", "Tela");
INSERT INTO Formato VALUES ("PosterPiccolo", "20x30", "Poster");
INSERT INTO Formato VALUES ("PosterGrande", "40x30", "Poster");
INSERT INTO Formato VALUES ("PlaccaPiccola", "40x30", "Metallo");


INSERT INTO Opera(Titolo, UrlImmagine,Autore) VALUES ("Fantasy", "/ArtMarket/images/img1.png","Tizio");
INSERT INTO Opera(Titolo, UrlImmagine) VALUES ("Japan", "/ArtMarket/images/img2.png");
INSERT INTO Opera(Titolo, UrlImmagine) VALUES ("Lions", "/ArtMarket/images/img3.png");
INSERT INTO Opera(Titolo, UrlImmagine,Autore) VALUES ("BigApple", "/ArtMarket/images/img4.png","Tizio");
INSERT INTO Opera(Titolo,UrlImmagine) VALUES ("Saiyan", "/ArtMarket/images/img5.png");
INSERT INTO Opera(Titolo, UrlImmagine) VALUES ("Winter", "/ArtMarket/images/img6.png");
INSERT INTO Opera(Titolo, UrlImmagine) VALUES ("Magic", "/ArtMarket/images/img7.png");
INSERT INTO Opera(Titolo, UrlImmagine) VALUES ("Ocean", "/ArtMarket/images/img8.png");

INSERT INTO Tag(Opera,Categoria) VALUES (1,"Fantasy");
INSERT INTO Tag(Opera,Categoria) VALUES (2,"Fantasy");
INSERT INTO Tag(Opera,Categoria) VALUES (4,"Fantasy");
INSERT INTO Tag(Opera,Categoria) VALUES (8,"Fantasy");

INSERT INTO Tag(Opera,Categoria) VALUES (5,"PopCulture");
INSERT INTO Tag(Opera,Categoria) VALUES (6,"Nature");
INSERT INTO Tag(Opera,Categoria) VALUES (8,"Nature");
INSERT INTO Tag(Opera,Categoria) VALUES (3,"Animals");
INSERT INTO Tag(Opera,Categoria) VALUES (2,"World");
INSERT INTO Tag(Opera,Categoria) VALUES (4,"World");


INSERT INTO Prodotto(Opera,Prezzo,Formato) VALUES (1, 10.00,"TelaPiccola");
INSERT INTO Prodotto(Opera,Prezzo,Formato) VALUES (1, 30.00,"TelaGrande");

INSERT INTO Prodotto(Opera,Prezzo,Formato) VALUES (2, 50.00,"TelaGrande");
INSERT INTO Prodotto(Opera,Prezzo,Formato) VALUES (2, 10.00,"PosterPiccolo");

INSERT INTO Prodotto(Opera,Prezzo,Formato) VALUES (3, 15.00,"PosterPiccolo");
INSERT INTO Prodotto(Opera,Prezzo,Formato) VALUES (3, 45.00,"TelaGrande");

INSERT INTO Prodotto(Opera,Prezzo,Formato) VALUES (3, 40.00,"PosterGrande");
INSERT INTO Prodotto(Opera,Prezzo,Formato) VALUES (3, 10.00,"PosterPiccolo");

INSERT INTO Prodotto(Opera,Prezzo,Formato) VALUES (4, 30.00,"PosterGrande");
INSERT INTO Prodotto(Opera,Prezzo,Formato) VALUES (4, 15.00,"PosterPiccolo");

INSERT INTO Prodotto(Opera,Prezzo,Formato) VALUES (5, 35.00,"TelaGrande");
INSERT INTO Prodotto(Opera,Prezzo,Formato) VALUES (5, 10.00,"PosterPiccolo");

INSERT INTO Prodotto(Opera,Prezzo,Formato) VALUES (6, 45.00,"TelaGrande");
INSERT INTO Prodotto(Opera,Prezzo,Formato) VALUES (6, 15.00,"PosterPiccolo");

INSERT INTO Prodotto(Opera,Prezzo,Formato) VALUES (7, 40.00,"TelaGrande");
INSERT INTO Prodotto(Opera,Prezzo,Formato) VALUES (7, 20.00,"PosterPiccolo");


INSERT INTO Ordine(Utente,Prezzo) VALUES ("Tizio",69.00);
INSERT INTO Include(Ordine,Prodotto) VALUES (LAST_INSERT_ID(),13);
INSERT INTO Include(Ordine,Prodotto) VALUES (LAST_INSERT_ID(),9);

INSERT INTO Ordine(Utente,Prezzo) VALUES ("Tizio",35.00);
INSERT INTO Include(Ordine,Prodotto) VALUES (LAST_INSERT_ID(),10);
