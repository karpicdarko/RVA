DROP TABLE IF EXISTS nacionalnost CASCADE;
DROP TABLE IF EXISTS liga CASCADE;
DROP TABLE IF EXISTS tim CASCADE;
DROP TABLE IF EXISTS igrac CASCADE;

DROP SEQUENCE IF EXISTS nacionalnost_seq;
DROP SEQUENCE IF EXISTS liga_seq;
DROP SEQUENCE IF EXISTS tim_seq;
DROP SEQUENCE IF EXISTS igrac_seq;


CREATE TABLE liga(
	id integer not null,
    naziv varchar(100) not null unique,
    oznaka varchar(50) not null unique,
	constraint PK_liga primary key(id)
);

CREATE TABLE nacionalnost(
	id integer not null,
    naziv varchar(100) not null unique,
    skracenica varchar(50) not null unique,
	constraint PK_nacionalnost primary key(id)
);

CREATE TABLE tim(
	id integer not null,
    naziv varchar(100) not null unique,
    osnovan date not null,
	sediste varchar(100) not null,
	liga integer not null,
	constraint PK_tim primary key(id),
	constraint FK_tim_liga foreign key(liga) references liga(id)
	
);

CREATE TABLE igrac(
	id integer not null,
    ime varchar(50) not null,
	prezime varchar(50) not null,
	broj_reg varchar(50) not null unique,
	datum_rodjenja date not null,
	nacionalnost integer not null,
	tim integer not null,
	constraint PK_igrac primary key(id),
	constraint FK_igrac_nacionalnost foreign key(nacionalnost) references nacionalnost(id),
	constraint FK_igrac_tim foreign key(tim) references tim(id)
	
);

CREATE INDEX IDXFK_tim_liga
ON tim(liga);
CREATE INDEX IDXFK_igrac_nacionalnost
ON igrac(nacionalnost);
CREATE INDEX IDXFK_igrac_tim
ON igrac(tim);

CREATE SEQUENCE tim_seq
INCREMENT 1;
CREATE SEQUENCE liga_seq
INCREMENT 1;
CREATE SEQUENCE nacionalnost_seq
INCREMENT 1;
CREATE SEQUENCE igrac_seq
INCREMENT 1;
