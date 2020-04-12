INSERT INTO public.genre (id, name) VALUES (14, 'Thriller');
INSERT INTO public.genre (id, name) VALUES (7, 'Documentary');
INSERT INTO public.genre (id, name) VALUES (1, 'Action');
INSERT INTO public.genre (id, name) VALUES (8, 'Drama');
INSERT INTO public.genre (id, name) VALUES (9, 'History');
INSERT INTO public.genre (id, name) VALUES (2, 'Adventure');
INSERT INTO public.genre (id, name) VALUES (10, 'Horror');
INSERT INTO public.genre (id, name) VALUES (3, 'Animation');
INSERT INTO public.genre (id, name) VALUES (11, 'Mystery');
INSERT INTO public.genre (id, name) VALUES (4, 'Biography');
INSERT INTO public.genre (id, name) VALUES (12, 'Romance');
INSERT INTO public.genre (id, name) VALUES (5, 'Comedy');
INSERT INTO public.genre (id, name) VALUES (13, 'Sci-fi');
INSERT INTO public.genre (id, name) VALUES (6, 'Crime');

INSERT INTO public.application_user (id, admin, password, username, first_name, last_name) VALUES (17, true, '$2a$10$otA2u22CA7Wyyaa2J3jUlOaiUxY7yhh0FYmgPm877wd8bJ7JP2jSy', 'admin@admin.com', 'Admin', 'Admin');
INSERT INTO public.application_user (id, admin, password, username, first_name, last_name) VALUES (18, false, '$2a$10$PUbK5bLgf86OL7rHgM/hn.YJj24q9p0gcFQoUDs6KqLa6HVhOD2dS', 'user@user.com', 'User', 'User');

INSERT INTO public.person (id, bio, date_of_birth, image_url, name, place_of_birth) VALUES (1, 'Tamara Kotevska was born on August 9, 1993 in Prilep, Macedonia. She is a director and writer, known for Honeyland (2019), Games (2014) and Man vs. Flock', '1993-08-09 02:00:00.000000', 'https://thumbor.forbes.com/thumbor/fit-in/416x416/filters%3Aformat%28jpg%29/https%3A%2F%2Fspecials-images.forbesimg.com%2Fimageserve%2F5e6c2d2daa5428000759d58a%2F0x0.jpg%3Fbackground%3D000000%26cropX1%3D0%26cropX2%3D3024%26cropY1%3D121%26cropY2%3D3145', 'Tamara Kotevska', 'Prilep, Macedonia');
INSERT INTO public.person (id, bio, date_of_birth, image_url, name, place_of_birth) VALUES (6, 'Hatidze lives in a village that is close to her brother relatives. She wanted to live in the nearby village so she could still tend to her bees and have a warm place to live during the winter.', '1970-08-25 01:00:00.000000', 'https://ssl-gfx.filmweb.pl/ph/61/04/816104/848113_1.2.jpg', 'Hatidze Muratova', 'Lozovo, Macedonia');
INSERT INTO public.person (id, bio, date_of_birth, image_url, name, place_of_birth) VALUES (4, 'American actor and producer Matthew David McConaughey was born in Uvalde, Texas. His mother, Mary Kathleen (McCabe), is a substitute school teacher originally from New Jersey. His father, James Donald McConaughey, was a gas station owner.', '1969-11-04 01:00:00.000000', 'https://media1.popsugar-assets.com/files/thumbor/HEI3loXbY_sNF2lagUNfcimrJog/fit-in/500x500/filters:format_auto-!!-:strip_icc-!!-/2018/07/16/728/n/1922398/6784fc375b4cc7eda67221.06772866_/i/Matthew-McConaughey.jpg', 'Matthew McConaughey', 'Uvalde, USA');
INSERT INTO public.person (id, bio, date_of_birth, image_url, name, place_of_birth) VALUES (5, 'Todd Phillips was born on December 20, 1970 in Brooklyn, New York City, New York, USA as Todd Bunzl. He is a producer and director, known for Joker (2019), Old School (2003) and Due Date (2010).', '1970-12-04 01:00:00.000000', 'https://peoplepill.com/media/people/thumbs/T/todd-phillips-1.jpg', 'Todd Phillips', 'New York, USA');
INSERT INTO public.person (id, bio, date_of_birth, image_url, name, place_of_birth) VALUES (2, 'Joaquin Phoenix was born Joaquin Rafael Bottom in San Juan, Puerto Rico, to Arlyn (Dunetz) and John Bottom, and is the middle child in a brood of five. His parents, from the continental United States, were then serving as Children of God missionaries.', '1974-10-28 01:00:00.000000', 'https://www.biography.com/.image/t_share/MTIwNjA4NjMzNjYxMjYxMzI0/joaquin-phoenix-358254-1-402.jpg', 'Joaquin Phoenix', 'San Juan, Puerto Rico');
INSERT INTO public.person (id, bio, date_of_birth, image_url, name, place_of_birth) VALUES (3, 'After watching Butch Cassidy and the Sundance Kid (1969) as a child, Guy realized that what he wanted to do was make films. He never attended film school, saying that the work of film school graduates was boring and unwatchable.', '1968-09-10 01:00:00.000000', 'https://resize-parismatch.lanmedia.fr/img/var/news/storage/images/paris-match/people-a-z/guy-ritchie/6038292-8-fre-FR/Guy-Ritchie.jpg', 'Guy Ritchie', 'Hertfordshire, UK');

INSERT INTO public.movie (id, country, description, details_url, image_url, movie_length, rating, title, video_url, year_of_release) VALUES (4, 'USA', 'Miami detectives Mike Lowrey and Marcus Burnett must face off against a mother-and-son pair of drug lords who wreak vengeful havoc on their city.', 'https://www.imdb.com/title/tt1502397/', 'https://m.media-amazon.com/images/M/MV5BMWU0MGYwZWQtMzcwYS00NWVhLTlkZTAtYWVjOTYwZTBhZTBiXkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_.jpg', 124, 6.9, 'Bad Boys for Life', 'https://www.youtube.com/embed/jKCj3XuPG8M', 2020);
INSERT INTO public.movie (id, country, description, details_url, image_url, movie_length, rating, title, video_url, year_of_release) VALUES (2, 'USA', 'In Gotham City, mentally troubled comedian Arthur Fleck is disregarded and mistreated by society. He then embarks on a downward spiral of revolution and bloody crime. This path brings him face-to-face with his alter-ego: the Joker.', 'https://www.imdb.com/title/tt7286456/', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSJKLiEyyz1Q9RC8EBYl3ijr3nuGeyO2ETmwy6Kdq0AQtD0elWD', 122, 8.5, 'Joker', 'https://www.youtube.com/embed/zAGVQLHvwOY', 2019);
INSERT INTO public.movie (id, country, description, details_url, image_url, movie_length, rating, title, video_url, year_of_release) VALUES (1, 'Macedonia', 'The last female bee-hunter in Europe must save the bees and return the natural balance in Honeyland, when a family of nomadic beekeepers invade her land and threaten her livelihood.', 'https://www.imdb.com/title/tt8991268/', 'https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcR3yg_5VHrhmIjArOd9SliEOQl6K0xEKGUwYnxFrZPSjifGi8IG', 86, 8, 'Honeyland', 'https://www.youtube.com/embed/B27ORUHlp6E', 2019);
INSERT INTO public.movie (id, country, description, details_url, image_url, movie_length, rating, title, video_url, year_of_release) VALUES (3, 'USA', 'An American expat tries to sell off his highly profitable marijuana empire in London, triggering plots, schemes, bribery and blackmail in an attempt to steal his domain out from under him.', 'https://www.imdb.com/title/tt8367814/', 'https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcRubFp5zFZxMxjaZN88iqFJTsDM9jwXnVAP4cfZ9T1Ah2rKPp3y', 113, 8, 'The Gentlemen', 'https://www.youtube.com/embed/Ify9S7hj480', 2020);

INSERT INTO public.movie_directors (movies_directed_id, directors_id) VALUES (1, 1);
INSERT INTO public.movie_directors (movies_directed_id, directors_id) VALUES (2, 5);
INSERT INTO public.movie_directors (movies_directed_id, directors_id) VALUES (2, 2);
INSERT INTO public.movie_directors (movies_directed_id, directors_id) VALUES (3, 3);

INSERT INTO public.movie_stars (movies_starred_id, stars_id) VALUES (2, 2);
INSERT INTO public.movie_stars (movies_starred_id, stars_id) VALUES (3, 4);
INSERT INTO public.movie_stars (movies_starred_id, stars_id) VALUES (1, 6);

INSERT INTO public.movie_writers (movies_written_id, writers_id) VALUES (1, 1);
INSERT INTO public.movie_writers (movies_written_id, writers_id) VALUES (2, 5);
INSERT INTO public.movie_writers (movies_written_id, writers_id) VALUES (3, 3);

INSERT INTO public.application_user_favorites_ids (application_user_id, favorites_ids) VALUES (18, 2);

INSERT INTO public.movie_languages (movie_id, languages) VALUES (1, 'Macedonian');
INSERT INTO public.movie_languages (movie_id, languages) VALUES (1, 'Turkish');
INSERT INTO public.movie_languages (movie_id, languages) VALUES (2, 'English');
INSERT INTO public.movie_languages (movie_id, languages) VALUES (3, 'English');
INSERT INTO public.movie_languages (movie_id, languages) VALUES (4, 'English');

INSERT INTO public.movie_genres (movies_id, genres_id) VALUES (1, 7);
INSERT INTO public.movie_genres (movies_id, genres_id) VALUES (2, 8);
INSERT INTO public.movie_genres (movies_id, genres_id) VALUES (2, 6);
INSERT INTO public.movie_genres (movies_id, genres_id) VALUES (2, 14);
INSERT INTO public.movie_genres (movies_id, genres_id) VALUES (3, 1);
INSERT INTO public.movie_genres (movies_id, genres_id) VALUES (3, 5);
INSERT INTO public.movie_genres (movies_id, genres_id) VALUES (3, 6);
INSERT INTO public.movie_genres (movies_id, genres_id) VALUES (4, 1);
INSERT INTO public.movie_genres (movies_id, genres_id) VALUES (4, 5);
INSERT INTO public.movie_genres (movies_id, genres_id) VALUES (4, 6);

INSERT INTO public.comment (id, content, created_at, stars, title, movie_id, application_user_id) VALUES (127, 'Hatidzhe was amazing!!', '2020-04-11 23:40:37.061464', 10, 'LOVED IT!', 1, 18);
INSERT INTO public.comment (id, content, created_at, stars, title, movie_id, application_user_id) VALUES (126, 'Okay', '2020-04-11 23:39:19.979369', 6, 'Not bad', 3, 17);
INSERT INTO public.comment (id, content, created_at, stars, title, movie_id, application_user_id) VALUES (125, 'GREAT', '2020-04-11 23:39:11.505683', 10, 'Loved it!', null, null);
INSERT INTO public.comment (id, content, created_at, stars, title, movie_id, application_user_id) VALUES (128, 'Hatidze was great!!!', '2020-04-11 23:53:50.808458', 10, 'Amazing!!!', 1, 17);
INSERT INTO public.comment (id, content, created_at, stars, title, movie_id, application_user_id) VALUES (129, 'Nice!', '2020-04-11 23:54:03.249996', 8.5, 'Good one', 2, 17);
INSERT INTO public.comment (id, content, created_at, stars, title, movie_id, application_user_id) VALUES (130, 'WOW', '2020-04-12 00:06:14.344483', 10, 'EXCEPTIONAL!', 1, 18);
INSERT INTO public.comment (id, content, created_at, stars, title, movie_id, application_user_id) VALUES (131, 'Expected more.', '2020-04-12 00:06:26.895430', 6.2, 'Hmm', 4, 18);