package dao;

import entity.Book;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtils;

import java.util.List;

public class BookDAO {
    static Logger log = Logger.getLogger(BookDAO.class.getName());

    Session session;
    SessionFactory factory;

    public BookDAO() {
        factory = HibernateUtils.getSessionFactory();
    }

    public Book getBookById(Long id) {
        log.info("Get book by id: " + id);
        Session session = factory.openSession();
        Book book = (session.get(Book.class, id));
        session.close();
        return book;
    }

    public void insertIntoTable(Book book) {
        session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(book);
        transaction.commit();
        session.close();
    }

    public void deleteFromTable(Long id) {
        session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(this.getBookById(id));
        transaction.commit();
        session.close();
    }

//    public void updateBook(String newAuthor, Long id) {
//        Book newBook = this.getBookById(id);
//        newBook.setAuthor(newAuthor);
//        session = factory.openSession();
//        Transaction transaction = session.beginTransaction();
//        session.update(newBook);
//        transaction.commit();
//        session.close();
//    }

    public List<Book> getAllBooks() {
        session = factory.openSession();
        final List<Book> resultList = session.createQuery("SELECT b FROM book b", Book.class).getResultList();
//        final List resultList = session.createQuery("from book").list();
        session.close();
        return resultList;
    }

}
