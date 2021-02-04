package mk.ukim.finki.seminarska.Initializer;

import mk.ukim.finki.seminarska.model.*;
import mk.ukim.finki.seminarska.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DataLoader implements ApplicationRunner {

    public static final List<ApplicationUser> users = new ArrayList<ApplicationUser>();
    public static final List<Movie> movies = new ArrayList<Movie>();
    public static final List<Genre> genres = new ArrayList<Genre>();
    public static final List<Comment> comments = new ArrayList<Comment>();
    public static final List<Person> people = new ArrayList<Person>();
    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    private final ApplicationUserRepository userRepository;
    private final CommentRepository commentRepository;
    private final GenreRepository genreRepository;
    private final MovieRepository movieRepository;
    private final PersonRepository personRepository;

    @Autowired
    public DataLoader(ApplicationUserRepository userRepository, CommentRepository commentRepository, GenreRepository genreRepository, MovieRepository movieRepository, PersonRepository personRepository) {
        this.userRepository = userRepository;
        this.commentRepository = commentRepository;
        this.genreRepository = genreRepository;
        this.movieRepository = movieRepository;
        this.personRepository = personRepository;

    }


    @Override
    public void run(ApplicationArguments args) throws Exception {

        if ((movieRepository.findAll().isEmpty())) {
            Genre Action = new Genre("Action", Collections.emptyList());
            genres.add(Action);
            Genre Adventure = new Genre("Adventure", Collections.emptyList());
            genres.add(Adventure);
            Genre Animation = new Genre("Animation", Collections.emptyList());
            genres.add(Animation);
            Genre Biography = new Genre("Biography", Collections.emptyList());
            genres.add(Biography);
            Genre Comedy = new Genre("Comedy", Collections.emptyList());
            genres.add(Comedy);
            Genre Crime = new Genre("Crime", Collections.emptyList());
            genres.add(Crime);
            Genre Documentary = new Genre("Documentary", Collections.emptyList());
            genres.add(Documentary);
            Genre Drama = new Genre("Drama", Collections.emptyList());
            genres.add(Drama);
            Genre History = new Genre("History", Collections.emptyList());
            genres.add(History);
            Genre Horror = new Genre("Horror", Collections.emptyList());
            genres.add(Horror);
            Genre Mystery = new Genre("Mystery", Collections.emptyList());
            genres.add(Mystery);
            Genre Romance = new Genre("Romance", Collections.emptyList());
            genres.add(Romance);
            Genre SciFi = new Genre("Sci-fi", Collections.emptyList());
            genres.add(SciFi);
            Genre Thriller = new Genre("Thriller", Collections.emptyList());
            genres.add(Thriller);

            genreRepository.saveAll(genres);

            Person TamaraKotevska = new Person("Tamara Kotevska", "Tamara Kotevska was born on August 9, 1993 in Prilep, Macedonia. She is a director and writer, known for Honeyland (2019), Games (2014) and Man vs. Flock", Date.from(Instant.parse("1993-08-09T00:00:00.000Z")), "Prilep, Macedonia", "https://thumbor.forbes.com/thumbor/fit-in/416x416/filters%3Aformat%28jpg%29/https%3A%2F%2Fspecials-images.forbesimg.com%2Fimageserve%2F5e6c2d2daa5428000759d58a%2F0x0.jpg%3Fbackground%3D000000%26cropX1%3D0%26cropX2%3D3024%26cropY1%3D121%26cropY2%3D3145");
            Person JoaquinPhoenix = new Person("Joaquin Phoenix", "Joaquin Phoenix was born Joaquin Rafael Bottom in San Juan, Puerto Rico, to Arlyn (Dunetz) and John Bottom, and is the middle child in a brood of five. His parents, from the continental United States, were then serving as Children of God missionaries.", Date.from(Instant.parse("1974-10-28T00:00:00.000Z")), "San Juan, Puerto Rico", "https://www.biography.com/.image/t_share/MTIwNjA4NjMzNjYxMjYxMzI0/joaquin-phoenix-358254-1-402.jpg");
            Person GuyRitchie = new Person("Guy Ritchie", "After watching Butch Cassidy and the Sundance Kid (1969) as a child, Guy realized that what he wanted to do was make films. He never attended film school, saying that the work of film school graduates was boring and unwatchable.", Date.from(Instant.parse("1968-09-10T00:00:00.000Z")), "Hertfordshire, UK", "https://resize-parismatch.lanmedia.fr/img/var/news/storage/images/paris-match/people-a-z/guy-ritchie/6038292-8-fre-FR/Guy-Ritchie.jpg");
            Person McConaughey = new Person("Matthew McConaughey", "American actor and producer Matthew David McConaughey was born in Uvalde, Texas. His mother, Mary Kathleen (McCabe), is a substitute school teacher originally from New Jersey. His father, James Donald McConaughey, was a gas station owner.", Date.from(Instant.parse("1969-11-04T00:00:00.000Z")), "Uvalde, USA", "https://media1.popsugar-assets.com/files/thumbor/HEI3loXbY_sNF2lagUNfcimrJog/fit-in/500x500/filters:format_auto-!!-:strip_icc-!!-/2018/07/16/728/n/1922398/6784fc375b4cc7eda67221.06772866_/i/Matthew-McConaughey.jpg");
            Person ToddPhillips = new Person("Todd Phillips", "Todd Phillips was born on December 20, 1970 in Brooklyn, New York City, New York, USA as Todd Bunzl. He is a producer and director, known for Joker (2019), Old School (2003) and Due Date (2010).", Date.from(Instant.parse("1970-12-04T00:00:00.000Z")), "New York, USA", "https://peoplepill.com/media/people/thumbs/T/todd-phillips-1.jpg");
            Person HatidzeMuratova = new Person("Hatidze Muratova", "Hatidze lives in a village that is close to her brother relatives. She wanted to live in the nearby village so she could still tend to her bees and have a warm place to live during the winter.", Date.from(Instant.parse("1970-08-25T00:00:00.000Z")), "Lozovo, Macedonia", "https://ssl-gfx.filmweb.pl/ph/61/04/816104/848113_1.2.jpg");

            people.add(TamaraKotevska);
            people.add(JoaquinPhoenix);
            people.add(GuyRitchie);
            people.add(McConaughey);
            people.add(ToddPhillips);
            people.add(HatidzeMuratova);

            personRepository.saveAll(people);

            ApplicationUser admin = new ApplicationUser();
            admin.setAdmin(true);
            admin.setUsername("admin@admin.com");
            admin.setPassword(bCryptPasswordEncoder.encode("12345"));
            admin.getUserDetails().setFirstName("Admin");
            admin.getUserDetails().setLastName("Admin");
            admin.setComments(new ArrayList<>());
            users.add(admin);

            ApplicationUser user = new ApplicationUser();
            user.setAdmin(false);
            user.setUsername("user@user.com");
            user.setPassword(bCryptPasswordEncoder.encode("12345"));
            user.getUserDetails().setFirstName("User");
            user.getUserDetails().setLastName("User");
            user.setComments(new ArrayList<>());
            users.add(user);


            userRepository.saveAll(users);


            List<Genre> genresHoneyland = new ArrayList<>();
            genresHoneyland.add(Documentary);
            List<Person> starsHoneyland = new ArrayList<>();
            starsHoneyland.add(HatidzeMuratova);
            List<Person> directorsHoneyland =  new ArrayList<>();
            directorsHoneyland.add(TamaraKotevska);
            List<Person> writersHoneyland =  new ArrayList<>();
            writersHoneyland.add(TamaraKotevska);
            List<String> languagesHoneyland = new ArrayList<>();
            languagesHoneyland.add("Turkish");
            languagesHoneyland.add("Macedonian");
            Movie Honeyland = new Movie("Honeyland", 2019, "The last female bee-hunter in Europe must save the bees and return the natural balance in Honeyland, when a family of nomadic beekeepers invade her land and threaten her livelihood.", 8.0, genresHoneyland, directorsHoneyland, starsHoneyland, writersHoneyland, null, "Macedonia", "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcR3yg_5VHrhmIjArOd9SliEOQl6K0xEKGUwYnxFrZPSjifGi8IG", 86, "https://www.youtube.com/embed/B27ORUHlp6E", "https://www.imdb.com/title/tt8991268/", languagesHoneyland);
            movies.add(Honeyland);

            List<Genre> genresJoker = genres.stream().filter(g -> g.getName().equalsIgnoreCase("Crime") || g.getName().equalsIgnoreCase("Thriller") || g.getName().equalsIgnoreCase("Drama")).collect(Collectors.toList());
            List<Person> starsJoker = people.stream().filter(p -> p.getName().equalsIgnoreCase("Joaquin Phoenix")).collect(Collectors.toList());
            List<Person> directorsJoker = people.stream().filter(p -> p.getName().equalsIgnoreCase("Todd Phillips")).collect(Collectors.toList());
            List<Person> writersJoker = people.stream().filter(p -> p.getName().equalsIgnoreCase("Todd Phillips") || p.getName().equalsIgnoreCase("Joaquin Phoenix")).collect(Collectors.toList());
            List<String> languagesJoker = new ArrayList<>();
            languagesJoker.add("English");
            Movie Joker = new Movie("Joker", 2019, "In Gotham City, mentally troubled comedian Arthur Fleck is disregarded and mistreated by society. He then embarks on a downward spiral of revolution and bloody crime. This path brings him face-to-face with his alter-ego: the Joker.", 8.5, genresJoker, directorsJoker, starsJoker, writersJoker, null, "USA", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSJKLiEyyz1Q9RC8EBYl3ijr3nuGeyO2ETmwy6Kdq0AQtD0elWD", 122, "https://www.youtube.com/embed/zAGVQLHvwOY", "https://www.imdb.com/title/tt7286456/", languagesJoker);
            movies.add(Joker);

            List<Genre> genresGentlemen = genres.stream().filter(g -> g.getName().equalsIgnoreCase("Crime") || g.getName().equalsIgnoreCase("Comedy") || g.getName().equalsIgnoreCase("Action")).collect(Collectors.toList());
            List<Person> starsGentlemen = people.stream().filter(p -> p.getName().equalsIgnoreCase("Matthew McConaughey")).collect(Collectors.toList());
            List<Person> directorsGentlemen = people.stream().filter(p -> p.getName().equalsIgnoreCase("Guy Ritchie")).collect(Collectors.toList());
            List<Person> writersGentlemen = people.stream().filter(p -> p.getName().equalsIgnoreCase("Guy Ritchie")).collect(Collectors.toList());
            List<String> languagesGentlemen = new ArrayList<>();
            languagesGentlemen.add("English");
            Movie Gentlemen = new Movie("The Gentlemen", 2020, "An American expat tries to sell off his highly profitable marijuana empire in London, triggering plots, schemes, bribery and blackmail in an attempt to steal his domain out from under him.", 8.0, genresGentlemen, directorsGentlemen, starsGentlemen, writersGentlemen, null, "USA", "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcRubFp5zFZxMxjaZN88iqFJTsDM9jwXnVAP4cfZ9T1Ah2rKPp3y", 113, "https://www.youtube.com/embed/Ify9S7hj480", "https://www.imdb.com/title/tt8367814/", languagesGentlemen);
            movies.add(Gentlemen);


            List<String> languagesBadBoys = new ArrayList<>();
            languagesBadBoys.add("English");
            List<Genre> genresBadBoys = new ArrayList<>();
            genresBadBoys.add(Action);
            genresBadBoys.add(Comedy);
            genresBadBoys.add(Crime);
            movies.add(new Movie("Bad Boys for Life", 2020, "Miami detectives Mike Lowrey and Marcus Burnett must face off against a mother-and-son pair of drug lords who wreak vengeful havoc on their city.", 6.9, genresBadBoys, null, null, null, null, "USA", "https://m.media-amazon.com/images/M/MV5BMWU0MGYwZWQtMzcwYS00NWVhLTlkZTAtYWVjOTYwZTBhZTBiXkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_.jpg", 124, "https://www.youtube.com/embed/jKCj3XuPG8M", "https://www.imdb.com/title/tt1502397/", languagesBadBoys));
            movieRepository.saveAll(movies);


            Comment commentOne = new Comment("Amazing", "Loved it!!!", Honeyland, 10.0, user);
            Comment commentTwo = new Comment("Great one!", "Hatidze was exceptional.", Honeyland, 10.0, user);
            Comment commentThree = new Comment("NO", "I didn't like this!", Joker, 2.0, admin);
            Comment commentFour = new Comment("Good", "Average movie", Gentlemen, 5.0, user);
            Comment commentFive = new Comment("Not bad", "ok", Gentlemen, 7.3, admin);
            Comment commentSix = new Comment("G R E A T ", "Love it", Joker, 10.0, user);
            comments.add(commentOne);
            comments.add(commentTwo);
            comments.add(commentThree);
            comments.add(commentFour);
            comments.add(commentFive);
            comments.add(commentSix);
            commentRepository.saveAll(comments);


        }
    }
}
