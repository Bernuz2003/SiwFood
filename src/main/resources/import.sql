insert into cuoco (id, nome, cognome, data, email, image ) VALUES (1, 'Gordon', 'Ramsay', '08-11-1966', 'gordonramsay@gmail.com', 'ramsay.png');
insert into cuoco (id, nome, cognome, data, email, image ) values(2, 'Jamie', 'Oliver', '27-05-1975', 'jamieoliver@gmail.com','oliver.png' );
insert into cuoco (id, nome, cognome, data, email, image ) values(3, 'Heston', 'Blumenthal', '27-05-1966', 'hestonblumenthal@gmail.com','blumenthal.png');
insert into cuoco (id, nome, cognome, data, email, image ) values(4, 'Nigella', 'Lawson', '06-01-1960', 'nigellalawson@gmail.com','lawson.png');
insert into cuoco (id, nome, cognome, data, email, image ) values(5, 'Marco', 'Pierre White', '11-12-1961', 'marcopierrewhite@gmail.com','white.png');
insert into cuoco (id, nome, cognome, data, email, image ) values(6, 'Alice', 'Waters', '28-04-1944', 'alicewaters@gmail.com','waters.png');
insert into cuoco (id, nome, cognome, data, email, image ) values(7, 'Wolfgang', 'Puck', '08-07-1949', 'wolfgangpuck@gmail.com','puck.png');
insert into cuoco (id, nome, cognome, data, email, image ) values(8, 'Thomas', 'Keller', '14-10-1955', 'thomaskeller@gmail.com','keller.png');
insert into cuoco (id, nome, cognome, data, email, image ) values(9, 'Julia', 'Child', '15-08-1912', 'juliachild@gmail.com','child.png');
insert into cuoco (id, nome, cognome, data, email, image ) values(10, 'Massimo', 'Bottura', '30-09-1962', 'massimobottura@gmail.com','bottura.png');


insert into ricetta (id, nome, image, cuoco_id) VALUES (1, 'Beef Wellington', 'beef_wellington.png', 1);
insert into ricetta (id, nome, image, cuoco_id) values(2, 'Spaghetti alla Carbonara', 'carbonara.png', 2);
insert into ricetta (id, nome, image, cuoco_id) values(3, 'Seafood Paella', 'paella.png', 3);
insert into ricetta (id, nome, image, cuoco_id) values(4, 'Chicken Tikka Masala', 'tikka_masala.png', 4);
insert into ricetta (id, nome, image, cuoco_id) values(5, 'Ratatouille', 'ratatouille.png', 5);
insert into ricetta (id, nome, image, cuoco_id) values(6, 'Peking Duck', 'peking_duck.png', 6);
insert into ricetta (id, nome, image, cuoco_id) values(7, 'Sushi', 'sushi.png', 7);
insert into ricetta (id, nome, image, cuoco_id) values(8, 'Tom Yum Soup', 'tom_yum.png', 8);
insert into ricetta (id, nome, image, cuoco_id) values(9, 'Moussaka', 'moussaka.png', 9);
insert into ricetta (id, nome, image, cuoco_id) values(10, 'Butter Chicken', 'butter_chicken.png', 10);
insert into ricetta (id, nome, image, cuoco_id) VALUES (11, 'Lobster Thermidor', 'lobster_thermidor.png', 1);
insert into ricetta (id, nome, image, cuoco_id) values(12, 'Pasta Primavera', 'pasta_primavera.png', 2);
insert into ricetta (id, nome, image, cuoco_id) values(13, 'Bouillabaisse', 'bouillabaisse.png', 3);
insert into ricetta (id, nome, image, cuoco_id) values(14, 'Pad Thai', 'pad_thai.png', 4);
insert into ricetta (id, nome, image, cuoco_id) values(15, 'Fajitas', 'fajitas.png', 5);
insert into ricetta (id, nome, image, cuoco_id) values(16, 'Ceviche', 'ceviche.png', 6);
insert into ricetta (id, nome, image, cuoco_id) values(17, 'Pho', 'pho.png', 7);
insert into ricetta (id, nome, image, cuoco_id) values(18, 'Beef Stroganoff', 'beef_stroganoff.png', 8);
insert into ricetta (id, nome, image, cuoco_id) values(19, 'Biryani', 'biryani.png', 9);
insert into ricetta (id, nome, image, cuoco_id) values(20, 'Pizza Margherita', 'pizza_margherita.png', 10);
insert into ricetta (id, nome, image, cuoco_id) VALUES (21, 'Ribeye Steak', 'ribeye_steak.png', 1);
insert into ricetta (id, nome, image, cuoco_id) values(22, 'Lasagna', 'lasagna.png', 2);
insert into ricetta (id, nome, image, cuoco_id) values(23, 'Gumbo', 'gumbo.png', 3);
insert into ricetta (id, nome, image, cuoco_id) values(24, 'Chicken Parmesan', 'chicken_parmesan.png', 4);
insert into ricetta (id, nome, image, cuoco_id) values(25, 'Paella', 'paella_2.png', 5);
insert into ricetta (id, nome, image, cuoco_id) values(26, 'Creme Brulee', 'creme_brulee.png', 6);
insert into ricetta (id, nome, image, cuoco_id) values(27, 'Clam Chowder', 'clam_chowder.png', 7);
insert into ricetta (id, nome, image, cuoco_id) values(28, 'Ratatouille', 'ratatouille_2.png', 8);
insert into ricetta (id, nome, image, cuoco_id) values(29, 'Tacos', 'tacos.png', 9);
insert into ricetta (id, nome, image, cuoco_id) values(30, 'Gazpacho', 'gazpacho.png', 10);


insert into ingrediente (id, nome, quantità) VALUES (1,'Manzo', '600');
insert into ingrediente (id, nome, quantità) values(2, 'Pasta sfoglia', '200');
insert into ingrediente (id, nome, quantità) values(3, 'Funghi', '100');
insert into ingrediente (id, nome, quantità) values(4, 'Aglio', null);
insert into ingrediente (id, nome, quantità) values(5, 'Olio oliva', null);
insert into ingrediente (id, nome, quantità) values(6, 'Sale', null);
insert into ingrediente (id, nome, quantità) values(7, 'Pepe', null);
insert into ingrediente (id, nome, quantità) values(8, 'Burro', '50');
insert into ingrediente (id, nome, quantità) values(9, 'Riso', '240');
insert into ingrediente (id, nome, quantità) values(10, 'Uova', '4');
insert into ingrediente (id, nome, quantità) values(11, 'Parmigiano', '50');
insert into ingrediente (id, nome, quantità) values(12, 'Pancetta', '100');
insert into ingrediente (id, nome, quantità) values(13, 'Scalogno', null);
insert into ingrediente (id, nome, quantità) values(14, 'Pomodori', '600');
insert into ingrediente (id, nome, quantità) values(15, 'Cipolla', '1');
insert into ingrediente (id, nome, quantità) values(16, 'Vino bianco', '200');
insert into ingrediente (id, nome, quantità) values(17, 'Gamberi', '300');
insert into ingrediente (id, nome, quantità) values(18, 'Calamari', '200');
insert into ingrediente (id, nome, quantità) values(19, 'Zafferano', '1');
insert into ingrediente (id, nome, quantità) values(20, 'Petto di pollo', '500');
insert into ingrediente (id, nome, quantità) values(21, 'Yogurt', '200');
insert into ingrediente (id, nome, quantità) values(22, 'Garam masala', '2');
insert into ingrediente (id, nome, quantità) values(23, 'Pomodori pelati', '400');
insert into ingrediente (id, nome, quantità) values(24, 'Basilico', null);
insert into ingrediente (id, nome, quantità) values(25, 'Melanzane', '600');
insert into ingrediente (id, nome, quantità) values(26, 'Zucchine', '200');
insert into ingrediente (id, nome, quantità) values(27, 'Peperoni', '300');
insert into ingrediente (id, nome, quantità) values(28, 'Vino rosso', '500');
insert into ingrediente (id, nome, quantità) values(29, 'Susine', '32');
insert into ingrediente (id, nome, quantità) values(30, 'Pane', '300');


-- Associazioni per la ricetta 1
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (1, 1);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (2, 1);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (3, 1);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (4, 1);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (5, 1);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (6, 1);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (7, 1);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (8, 1);

-- Associazioni per la ricetta 2
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (9, 2);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (10, 2);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (11, 2);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (12, 2);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (13, 2);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (6, 2);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (7, 2);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (8, 2);

-- Associazioni per la ricetta 3
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (14, 3);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (15, 3);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (16, 3);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (17, 3);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (18, 3);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (19, 3);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (20, 3);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (6, 3);

-- Associazioni per la ricetta 4
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (20, 4);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (21, 4);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (22, 4);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (23, 4);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (24, 4);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (6, 4);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (7, 4);

-- Associazioni per la ricetta 5
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (25, 5);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (26, 5);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (27, 5);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (24, 5);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (6, 5);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (7, 5);

-- Associazioni per la ricetta 6
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (28, 6);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (29, 6);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (16, 6);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (15, 6);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (6, 6);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (7, 6);

-- Associazioni per la ricetta 7
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (30, 7);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (17, 7);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (18, 7);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (19, 7);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (20, 7);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (6, 7);

-- Associazioni per la ricetta 8
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (21, 8);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (22, 8);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (23, 8);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (24, 8);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (25, 8);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (26, 8);

-- Associazioni per la ricetta 9
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (27, 9);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (28, 9);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (29, 9);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (30, 9);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (14, 9);

-- Associazioni per la ricetta 10
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (1, 10);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (2, 10);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (3, 10);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (4, 10);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (5, 10);

-- Associazioni per la ricetta 11
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (6, 11);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (7, 11);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (8, 11);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (9, 11);

-- Associazioni per la ricetta 12
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (10, 12);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (11, 12);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (12, 12);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (13, 12);

-- Associazioni per la ricetta 13
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (14, 13);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (15, 13);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (16, 13);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (17, 13);

-- Associazioni per la ricetta 14
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (18, 14);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (19, 14);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (20, 14);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (21, 14);

-- Associazioni per la ricetta 15
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (22, 15);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (23, 15);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (24, 15);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (25, 15);

-- Associazioni per la ricetta 16
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (26, 16);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (27, 16);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (28, 16);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (29, 16);

-- Associazioni per la ricetta 17
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (30, 17);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (1, 17);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (2, 17);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (3, 17);

-- Associazioni per la ricetta 18
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (4, 18);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (5, 18);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (6, 18);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (7, 18);

-- Associazioni per la ricetta 19
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (8, 19);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (9, 19);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (10, 19);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (11, 19);

-- Associazioni per la ricetta 20
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (12, 20);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (13, 20);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (14, 20);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (15, 20);

-- Associazioni per la ricetta 21
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (16, 21);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (17, 21);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (18, 21);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (19, 21);

-- Associazioni per la ricetta 22
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (20, 22);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (21, 22);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (22, 22);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (23, 22);

-- Associazioni per la ricetta 23
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (24, 23);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (25, 23);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (26, 23);
INSERT INTO ricetta_ingredienti (ingredienti_id, ricette_id) VALUES (27, 23);