--liga
insert into "liga"("id","naziv","oznaka")
values(nextval('liga_seq'), 'National Basketball Association', 'NBA');
insert into "liga"("id","naziv","oznaka")
values(nextval('liga_seq'), 'Lega Basket Serie A', 'LBA');
insert into "liga"("id","naziv","oznaka")
values(nextval('liga_seq'), 'Asociacion de Clubs de Baloncesto', 'ACB');
insert into "liga"("id","naziv","oznaka")
values(nextval('liga_seq'), 'Turkish Basketball Super League', 'BSL');
insert into "liga"("id","naziv","oznaka")
values(nextval('liga_seq'), 'Basketball Bundesliga', 'BBL');

--tim
	--NBA
insert into "tim"("id", "naziv", "osnovan", "sediste", "liga")
values(nextval('tim_seq'), 'Los Angeles Clippers', to_date('01.03.1970.', 'dd.mm.yyyy.'), 'Los Angeles', 1);

insert into "tim"("id", "naziv", "osnovan", "sediste", "liga")
values(nextval('tim_seq'), 'Los Angeles Lakers', to_date('09.06.1948.', 'dd.mm.yyyy.'), 'Los Angeles', 1);

insert into "tim"("id", "naziv", "osnovan", "sediste", "liga")
values(nextval('tim_seq'), 'Golden State Wariors', to_date('11.08.1946.', 'dd.mm.yyyy.'), 'Oakland', 1);

	--LBA
insert into "tim"("id", "naziv", "osnovan", "sediste", "liga")
values(nextval('tim_seq'), 'Virtus', to_date('01.05.1927.', 'dd.mm.yyyy.'), 'Bologna', 2);

insert into "tim"("id", "naziv", "osnovan", "sediste", "liga")
values(nextval('tim_seq'), 'Guerino Vanoli', to_date('09.06.1948.', 'dd.mm.yyyy.'), 'Cremona', 2);

insert into "tim"("id", "naziv", "osnovan", "sediste", "liga")
values(nextval('tim_seq'), 'Olimpia', to_date('15.06.1999.', 'dd.mm.yyyy.'), 'Milano', 2);

	--ACB
insert into "tim"("id", "naziv", "osnovan", "sediste", "liga")
values(nextval('tim_seq'), 'Unicaja', to_date('11.09.1977.', 'dd.mm.yyyy.'), 'Malaga', 3);

insert into "tim"("id", "naziv", "osnovan", "sediste", "liga")
values(nextval('tim_seq'), 'Real Madrid', to_date('08.04.1931.', 'dd.mm.yyyy.'), 'Madrid', 3);

insert into "tim"("id", "naziv", "osnovan", "sediste", "liga")
values(nextval('tim_seq'), 'Barcelona', to_date('24.07.1926.', 'dd.mm.yyyy.'), 'Barcelona', 3);

	--BSL
insert into "tim"("id", "naziv", "osnovan", "sediste", "liga")
values(nextval('tim_seq'), 'Anadolu Efes', to_date('30.11.1976.', 'dd.mm.yyyy.'), 'Istanbul', 4);

insert into "tim"("id", "naziv", "osnovan", "sediste", "liga")
values(nextval('tim_seq'), 'Galatasaray', to_date('07.04.1911.', 'dd.mm.yyyy.'), 'Istanbul', 4);

insert into "tim"("id", "naziv", "osnovan", "sediste", "liga")
values(nextval('tim_seq'), 'Fenerbahce', to_date('24.11.1913.', 'dd.mm.yyyy.'), 'Istanbul', 4);

	--BBL
insert into "tim"("id", "naziv", "osnovan", "sediste", "liga")
values(nextval('tim_seq'), 'Alba', to_date('02.12.1991.', 'dd.mm.yyyy.'), 'Berlin', 5);

insert into "tim"("id", "naziv", "osnovan", "sediste", "liga")
values(nextval('tim_seq'), 'Bayern', to_date('08.09.1946.', 'dd.mm.yyyy.'), 'Munich', 5);

insert into "tim"("id", "naziv", "osnovan", "sediste", "liga")
values(nextval('tim_seq'), 'Brose', to_date('22.07.1955.', 'dd.mm.yyyy.'), 'Bamberg', 5);

--nacionalnost
insert into "nacionalnost"("id", "naziv", "skracenica")
values(nextval('nacionalnost_seq'), 'Spanac', 'ESP');

insert into "nacionalnost"("id", "naziv", "skracenica")
values(nextval('nacionalnost_seq'), 'Srbin', 'SRB');

insert into "nacionalnost"("id", "naziv", "skracenica")
values(nextval('nacionalnost_seq'), 'Nemac', 'DEU');

insert into "nacionalnost"("id", "naziv", "skracenica")
values(nextval('nacionalnost_seq'), 'Italijan', 'ITA');

insert into "nacionalnost"("id", "naziv", "skracenica")
values(nextval('nacionalnost_seq'), 'Amerikanac', 'USA');

select * from nacionalnost;
select * from tim;
--igrac
	--Clippers
insert into "igrac"("id", "ime", "prezime", "broj_reg", "datum_rodjenja", "nacionalnost", "tim")
values (nextval('igrac_seq'), 'Kawhi', 'Leonard', 'KL-002-USA', to_date('29.06.1991.', 'dd.mm.yyyy.'), 5, 1);

insert into "igrac"("id", "ime", "prezime", "broj_reg", "datum_rodjenja", "nacionalnost", "tim")
values (nextval('igrac_seq'), 'Paul', 'George', 'PG-013-USA', to_date('02.05.1990.', 'dd.mm.yyyy.'), 5, 1);

	--Lakers
insert into "igrac"("id", "ime", "prezime", "broj_reg", "datum_rodjenja", "nacionalnost", "tim")
values (nextval('igrac_seq'), 'LeBron', 'James', 'LB-006-USA', to_date('30.12.1984.', 'dd.mm.yyyy.'), 5, 2);

insert into "igrac"("id", "ime", "prezime", "broj_reg", "datum_rodjenja", "nacionalnost", "tim")
values (nextval('igrac_seq'), 'Anthony', 'Davis', 'AD-023-USA', to_date('11.04.1993.', 'dd.mm.yyyy.'), 5, 2);

	--GSW
insert into "igrac"("id", "ime", "prezime", "broj_reg", "datum_rodjenja", "nacionalnost", "tim")
values (nextval('igrac_seq'), 'Stephen', 'Cury', 'SC-030-USA', to_date('14.04.1988.', 'dd.mm.yyyy.'), 5, 3);

insert into "igrac"("id", "ime", "prezime", "broj_reg", "datum_rodjenja", "nacionalnost", "tim")
values (nextval('igrac_seq'), 'Alen', 'Smailagic', 'AS-006-SRB', to_date('18.08.2000.', 'dd.mm.yyyy.'), 2, 3);

	--Virtus
insert into "igrac"("id", "ime", "prezime", "broj_reg", "datum_rodjenja", "nacionalnost", "tim")
values (nextval('igrac_seq'), 'Milos', 'Teodosic', 'MT-006-SRB', to_date('19.04.1987.', 'dd.mm.yyyy.'), 2, 4);

insert into "igrac"("id", "ime", "prezime", "broj_reg", "datum_rodjenja", "nacionalnost", "tim")
values (nextval('igrac_seq'), 'Amedeo', 'Tessitori', 'AT-023-USA', to_date('07.10.1994.', 'dd.mm.yyyy.'), 4, 4);

	--Guerino Vanoli
insert into "igrac"("id", "ime", "prezime", "broj_reg", "datum_rodjenja", "nacionalnost", "tim")
values (nextval('igrac_seq'), 'Vojislav', 'Stojanovic', 'VS-023-SRB', to_date('14.04.1997.', 'dd.mm.yyyy.'), 2, 5);

insert into "igrac"("id", "ime", "prezime", "broj_reg", "datum_rodjenja", "nacionalnost", "tim")
values (nextval('igrac_seq'), 'Travis', 'Diener', 'TD-007-ITA', to_date('01.03.1982.', 'dd.mm.yyyy.'), 4, 5);

	--Olimpia
insert into "igrac"("id", "ime", "prezime", "broj_reg", "datum_rodjenja", "nacionalnost", "tim")
values (nextval('igrac_seq'), 'Andrea', 'Cinciarini', 'AC-020-ITA', to_date('14.04.1986.', 'dd.mm.yyyy.'), 4, 6);

insert into "igrac"("id", "ime", "prezime", "broj_reg", "datum_rodjenja", "nacionalnost", "tim")
values (nextval('igrac_seq'), 'Nemanja', 'Nedovic', 'NN-016-SRB', to_date('01.03.1991.', 'dd.mm.yyyy.'), 2, 6);

	--Unicaja
insert into "igrac"("id", "ime", "prezime", "broj_reg", "datum_rodjenja", "nacionalnost", "tim")
values (nextval('igrac_seq'), 'Jaime', 'Fernandez', 'JF-003-SPA', to_date('04.06.1993.', 'dd.mm.yyyy.'), 1, 7);

insert into "igrac"("id", "ime", "prezime", "broj_reg", "datum_rodjenja", "nacionalnost", "tim")
values (nextval('igrac_seq'), 'Dragan', 'Milosavljevic', 'DM-012-SRB', to_date('11.05.1989.', 'dd.mm.yyyy.'), 2, 7);

	--Real Madrid
insert into "igrac"("id", "ime", "prezime", "broj_reg", "datum_rodjenja", "nacionalnost", "tim")
values (nextval('igrac_seq'), 'Felipe', 'Reyes', 'FR-009-SPA', to_date('16.03.1980.', 'dd.mm.yyyy.'), 1, 8);

insert into "igrac"("id", "ime", "prezime", "broj_reg", "datum_rodjenja", "nacionalnost", "tim")
values (nextval('igrac_seq'), 'Sergio', 'Llull', 'SL-023-SPA', to_date('15.11.1987.', 'dd.mm.yyyy.'), 1, 8);

	--Barcelona
insert into "igrac"("id", "ime", "prezime", "broj_reg", "datum_rodjenja", "nacionalnost", "tim")
values (nextval('igrac_seq'), 'Pierre', 'Oriola', 'PO-018-SPA', to_date('25.10.1991.', 'dd.mm.yyyy.'), 1, 9);

insert into "igrac"("id", "ime", "prezime", "broj_reg", "datum_rodjenja", "nacionalnost", "tim")
values (nextval('igrac_seq'), 'Nikola', 'Mirotic', 'NM-033-SPA', to_date('11.02.1991.', 'dd.mm.yyyy.'), 1, 9);

	--Anadolu Efes
insert into "igrac"("id", "ime", "prezime", "broj_reg", "datum_rodjenja", "nacionalnost", "tim")
values (nextval('igrac_seq'), 'Vasilije', 'Micic', 'VM-022-SRB', to_date('04.06.1995.', 'dd.mm.yyyy.'), 2, 10);

insert into "igrac"("id", "ime", "prezime", "broj_reg", "datum_rodjenja", "nacionalnost", "tim")
values (nextval('igrac_seq'), 'Tibor', 'Pleiss', 'TP-021-DEU', to_date('02.11.1989.', 'dd.mm.yyyy.'), 3, 10);

	--Galatasaray
insert into "igrac"("id", "ime", "prezime", "broj_reg", "datum_rodjenja", "nacionalnost", "tim")
values (nextval('igrac_seq'), 'Tai', 'Webster', 'TW-000-USA', to_date('04.06.1995.', 'dd.mm.yyyy.'), 5, 11);

insert into "igrac"("id", "ime", "prezime", "broj_reg", "datum_rodjenja", "nacionalnost", "tim")
values (nextval('igrac_seq'), 'Aaron', 'Harrison', 'AH-002-USA', to_date('11.05.1994.', 'dd.mm.yyyy.'), 5, 11);

	--Fenerbahce
insert into "igrac"("id", "ime", "prezime", "broj_reg", "datum_rodjenja", "nacionalnost", "tim")
values (nextval('igrac_seq'), 'Danilo', 'Barthel', 'DB-022-DEU', to_date('04.06.1993.', 'dd.mm.yyyy.'), 3, 12);

insert into "igrac"("id", "ime", "prezime", "broj_reg", "datum_rodjenja", "nacionalnost", "tim")
values (nextval('igrac_seq'), 'Lorenzo', 'Brown', 'LB-012-USA', to_date('11.05.1990.', 'dd.mm.yyyy.'), 1, 12);

	--Alba
insert into "igrac"("id", "ime", "prezime", "broj_reg", "datum_rodjenja", "nacionalnost", "tim")
values (nextval('igrac_seq'), 'Simone', 'Fontecchio', 'SF-003-ITA', to_date('04.06.1991.', 'dd.mm.yyyy.'), 4, 13);

insert into "igrac"("id", "ime", "prezime", "broj_reg", "datum_rodjenja", "nacionalnost", "tim")
values (nextval('igrac_seq'), 'Johannes', 'Thiemann', 'JT-012-DEU', to_date('11.05.1987.', 'dd.mm.yyyy.'), 3, 13);

	--Bayern
insert into "igrac"("id", "ime", "prezime", "broj_reg", "datum_rodjenja", "nacionalnost", "tim")
values (nextval('igrac_seq'), 'Paul', 'Zipser', 'PZ-016-DEU', to_date('04.06.1994.', 'dd.mm.yyyy.'), 3, 14);

insert into "igrac"("id", "ime", "prezime", "broj_reg", "datum_rodjenja", "nacionalnost", "tim")
values (nextval('igrac_seq'), 'Vladimir', 'Lucic', 'VL-011-SRB', to_date('11.05.1989.', 'dd.mm.yyyy.'), 2, 14);

	--Brose
insert into "igrac"("id", "ime", "prezime", "broj_reg", "datum_rodjenja", "nacionalnost", "tim")
values (nextval('igrac_seq'), 'Daniel', 'Hackett', 'DH-000-ITA', to_date('04.06.1987.', 'dd.mm.yyyy.'), 4, 15);

insert into "igrac"("id", "ime", "prezime", "broj_reg", "datum_rodjenja", "nacionalnost", "tim")
values (nextval('igrac_seq'), 'Lucca', 'Staiger', 'LS-008-DEU', to_date('11.05.1988.', 'dd.mm.yyyy.'), 3, 15);
