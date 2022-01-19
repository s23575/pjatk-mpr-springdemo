insert into autor (imie, nazwisko, data_ur, data_sm) values ('Fiodor','Dostojewski',1821,1881),('Jacek','Dukaj',1974,null),('Joseph','Conrad',1857,1924),('Andrzej','Stasiuk',1960,null),('Władysław','Reymont',1867,1925),('Terry','Pratchett',1948,2015),('Herman','Melville',1819,1891),('Giuseppe','Tomasi di Lampedusa',1896,1957),('James','Joyce',1882,1941),('Michaił','Bułhakow',1891,1940),('Szczepan','Twardoch',1979,null),('Marcel','Proust',1871,1922),('Olga','Tokarczuk',1962,null),('Marek','Hłasko',1934,1969),('Samuel','Beckett',1906,1989);

insert into ksiazka (tytul, tytul_oryg) values ('Zbrodnia i kara','Priestuplenije i nakazanije'),('Bracia Karamazow','Bratya Karamazovy'),('Katedra',null),('Imperium chmur',null),('Jądro ciemności','Heart of Darkness'),('Serce ciemności','Heart of Darkness'),('Lord Jim','Lord Jim'),('Jadąc do Babadag',null),('Ziemia obiecana',null),('Kolor magii','The Colour of Magic'),('Moby Dick czyli biały wieloryb','Moby-Dick; or, The Whale'),('Gepard','Il Gattopardo'),('Ulisses','Ulysses'),('Mistrz i Małgorzata','Mastier i Margarita '),('Król',null),('Królestwo',null),('W stronę Swanna','Du côté de chez Swann'),('Księgi Jakubowe',null),('Pierwszy krok w chmurach. Opowiadania',null),('Utwory wybrane. Dramaty, słuchowiska, scenariusze',null);

insert into wydanie (rok, numer, isbn, oprawa, cena, wydawnictwo, czydostepne) values (2015,1,'978-83-777-9221-6',0,49.9,'Znak',true),(2019,null,'978-83-280-6779-0',1,24.99,'Wilga',true),(2004,1,'978-83-240-1263-3',0,65.9,'Znak',true),(2017,null,'978-83-08-07320-9',1,24.9,'Wydawnictwo Literackie',true),(2020,1,'978-83-08-07471-8',0,49.9,'Wydawnictwo Literackie',true),(2021,2,'978-83-240-6405-2',0,39.99,'Znak',true),(2017,1,'978-83-08-06417-7',0,28,'Wydawnictwo Literackie',true),(2021,2,'978-83-240-6401-4',0,49.99,'Znak',true),(2021,5,'978-83-8191-140-5',0,44.9,'Czarne',true),(2008,1,'978-83-8739-197-2',0,39,'Czarne',true),(2014,null,'978-83-6105-669-0',0,35,'Ossolineum',true),(2021,null,'978-83-8234-081-5',1,35,'Prószyński i s-ka',true),(2005,null,'978-83-7469-097-3',1,29.9,'Prószyński i s-ka',true),(2018,null,'978-83-06-03500-1',0,59,'Państwowy Instytut Wydawniczy',true),(2019,null,'978-83-950-4558-5',1,35,'Czuły Barbarzyńca',true),(2012,null,'978-83-240-1879-6',0,64.9,'Znak',true),(2021,null,'978-83-665-1142-2',0,69.9,'Officyna',true),(2018,null,'978-83-06-03527-8',0,59,'Państwowy Instytut Wydawniczy',true),(2016,1,'978-83-080-6224-1',1,44.9,'Znak',true),(2020,2,'978-83-080-7095-6',1,44.9,'Wydawnictwo Literackie',true),(2018,1,'978-83-080-6800-7',1,44.9,'Znak',true),(2018,null,'978-83-624-0979-2',0,49.9,'Officyna',true),(2021,2,'978-83-080-7328-5',0,74.9,'Wydawnictwo Literackie',true),(2019,null,'978-83-244-1027-9',1,29.9,'Iskry',true),(2017,null,'978-83-06-03406-6',0,59,'Państwowy Instytut Wydawniczy',true);

insert into tlumacz (imie, nazwisko) values ('J.P.','Zajączkowski'),('Czesław','Jastrzębiec-Kozłowski'),('Adam','Pomorski'),('Magda ','Heydel'),('Jacek','Dukaj'),('Michał','Kłobukowski'),('Piotr W.','Cholewa'),('Bronisław ','Zieliński'),('Stanisław','Kasprzysiak'),('Maciej','Słomczyński'),('Maciej','Świerkocki'),('Irena','Lewandowska'),('Witold','Dąbrowski'),('Krystyna ','Rodowska'),('Antoni','Libera');

insert into k_a (ksiazka_id, autor_id) values (1,1),(2,1),(3,2),(4,2),(5,3),(6,3),(7,3),(8,4),(9,5),(10,6),(11,7),(12,8),(13,9),(14,10),(15,11),(16,11),(17,12),(18,13),(19,14),(20,15);

insert into k_w (ksiazka_id, wydanie_id) values (1,1),(1,2),(2,3),(3,4),(4,5),(5,6),(6,7),(7,8),(8,9),(9,11),(10,12),(10,13),(11,14),(12,15),(13,16),(13,17),(14,18),(15,19),(15,20),(16,21),(17,22),(18,23),(19,24),(20,25);

insert into w_t (wydanie_id, tlumacz_id) values (1,1),(2,2),(3,3),(6,4),(7,5),(8,6),(12,7),(13,7),(14,8),(15,9),(16,10),(17,11),(18,12),(18,13),(22,14),(25,15);
