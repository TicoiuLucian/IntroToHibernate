package dao;

import entity.Book;
import entity.Title;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtils;

import java.util.List;

public class TitleDAO {


    static Logger log = Logger.getLogger(TitleDAO.class.getName());

    Session session;
    SessionFactory factory;

    public TitleDAO() {
        factory = HibernateUtils.getSessionFactory();
    }

    public List<Title> getAlltitles() {
        session = factory.openSession();
        final List<Title> resultList = session.createQuery("SELECT t FROM Title t", Title.class).getResultList();
        session.close();
        return resultList;
    }

    public void insertIntoTable(Title title) {
        session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(title);
        transaction.commit();
        session.close();
    }

    public Title getTitleById(Long id) {
        log.info("Get Title by id: " + id);
        Session session = factory.openSession();
        Title title = (session.get(Title.class, id));
        session.close();
        return title;
    }
}
