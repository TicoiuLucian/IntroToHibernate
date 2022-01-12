package app;

import com.github.javafaker.Faker;
import dao.BookDAO;
import dao.TitleDAO;
import entity.*;
import org.apache.log4j.Logger;

public class App {

    static Logger log = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {

        log.info("---------------------------------------------");
        log.info("----------------OneToOne title---------------");
        log.info("----------------OneToMany volumes------------");
        log.info("----------------ManyToMany authors-----------");
        log.info("---------------------------------------------");

        Faker faker = new Faker();
        BookDAO bookDAO = new BookDAO();

        Book bookManyToMany1 = new Book();
        bookManyToMany1.setTitle(new Title(faker.book().title(), EncodingType.UTF8));
        final Author author = new Author(faker.name().firstName(), faker.name().lastName());
        bookManyToMany1.addAuthorToBook(author);
        bookManyToMany1.addAuthorToBook(new Author(faker.name().firstName(), faker.name().lastName()));
        bookManyToMany1.addAuthorToBook(new Author(faker.name().firstName(), faker.name().lastName()));
        bookManyToMany1.addAuthorToBook(new Author(faker.name().firstName(), faker.name().lastName()));

        bookManyToMany1.addVolumeToBook(new Volume(faker.number().numberBetween(1, 100), faker.name().fullName()));
        bookManyToMany1.addVolumeToBook(new Volume(faker.number().numberBetween(1, 100), faker.name().fullName()));
        bookManyToMany1.addVolumeToBook(new Volume(faker.number().numberBetween(1, 100), faker.name().fullName()));
        bookManyToMany1.addVolumeToBook(new Volume(faker.number().numberBetween(1, 100), faker.name().fullName()));
        bookDAO.insertIntoTable(bookManyToMany1);


        Book bookManyToMany2 = new Book();
        bookManyToMany2.setTitle(new Title(faker.book().title(), EncodingType.UTF8));
        bookManyToMany2.addAuthorToBook(new Author(faker.name().firstName(), faker.name().lastName()));
        bookManyToMany2.addAuthorToBook(new Author(faker.name().firstName(), faker.name().lastName()));
        bookManyToMany2.addAuthorToBook(new Author(faker.name().firstName(), faker.name().lastName()));
        bookManyToMany2.addAuthorToBook(new Author(faker.name().firstName(), faker.name().lastName()));
        bookManyToMany2.addAuthorToBook(author);
        bookManyToMany2.addVolumeToBook(new Volume(faker.number().numberBetween(1, 100), faker.name().fullName()));
        bookManyToMany2.addVolumeToBook(new Volume(faker.number().numberBetween(1, 100), faker.name().fullName()));
        bookManyToMany2.addVolumeToBook(new Volume(faker.number().numberBetween(1, 100), faker.name().fullName()));
        bookManyToMany2.addVolumeToBook(new Volume(faker.number().numberBetween(1, 100), faker.name().fullName()));
        bookDAO.insertIntoTable(bookManyToMany2);

        Book bookManyToMany3 = new Book();
        bookManyToMany3.setTitle(new Title(faker.book().title(), EncodingType.UTF8));
        bookManyToMany3.addAuthorToBook(new Author(faker.name().firstName(), faker.name().lastName()));
        bookManyToMany3.addAuthorToBook(new Author(faker.name().firstName(), faker.name().lastName()));
        bookManyToMany3.addAuthorToBook(author);
        bookManyToMany3.addVolumeToBook(new Volume(faker.number().numberBetween(1, 100), faker.name().fullName()));
        bookManyToMany3.addVolumeToBook(new Volume(faker.number().numberBetween(1, 100), faker.name().fullName()));
        bookManyToMany3.addVolumeToBook(new Volume(faker.number().numberBetween(1, 100), faker.name().fullName()));
        bookManyToMany3.addVolumeToBook(new Volume(faker.number().numberBetween(1, 100), faker.name().fullName()));
        bookDAO.insertIntoTable(bookManyToMany3);

//        log.trace("Trace Message!");
//        log.debug("Debug Message!");
//        log.info("Info Message!");
//        log.warn("Warn Message!");
//        log.error("Error Message!");
//        log.fatal("Fatal Message!");
    }
}
