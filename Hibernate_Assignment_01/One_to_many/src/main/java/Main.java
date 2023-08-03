import entity.Author;
import entity.Book;
import jakarta.persistence.PersistenceException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utill.FactoryConfiguration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        Author author1 = new Author();
        Book book1 = new Book();

        Author author2 = new Author();
        Book book2 = new Book();

        Author author3 = new Author();
        Book book3 = new Book();

//////////////////////////////////////////////////////////////////////////////////////////////////
        author1.setAuthor_id("A001");
        author1.setAuthor_name("Jaysuruiya");

        book1.setBook_id("B001");
        book1.setBook_name("Palud Dupatha");
        book1.setYear("1999");
        book1.setAuthors(author1);

        author2.setAuthor_id("A002");
        author2.setAuthor_name("Wethsingha");

        book2.setBook_id("B002");
        book2.setBook_name("New Colombo Part 1");
        book2.setYear("2022");
        book2.setAuthors(author2);

        author3.setAuthor_id("A003");
        author3.setAuthor_name("Wimalasiri");

        book3.setBook_id("B003");
        book3.setBook_name("Komalii");
        book3.setYear("2002");
        book3.setAuthors(author2);

        List<Book> bookList = new ArrayList<>();
        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);



        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Author authorUpdate = session.get(Author.class,author2.getAuthor_id());
        Book bookUpdate = session.get(Book.class,book1.getBook_id());

//        session.persist(author1);
//        session.persist(author2);
//        session.persist(author3);
//        session.persist(book1);
//        session.persist(book2);
//        session.persist(book3);

        authorUpdate.setAuthor_name("J.L.Nimal Periis");
        bookUpdate.setYear("2010");

        session.remove(book3);
        session.remove(author3);


            transaction.commit();
            session.close();

    }
}
