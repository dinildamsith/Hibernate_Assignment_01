import entity.Author;
import entity.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utill.FactoryConfiguration;

import java.util.ArrayList;

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
        author2.setAuthor_id("A002");
        author3.setAuthor_id("A003");

        author1.setAuthor_name("T.B. Jaya");
        author2.setAuthor_name("Sunil Jaysingha");
        author3.setAuthor_name("Kumara Senanayaka");

        author1.setBirth_day("1990-09-11");
        author2.setBirth_day("1789-11-29");
        author3.setBirth_day("1999-01-22");

        author1.setBook(book1);
        author2.setBook(book2);
        author3.setBook(book3);


        //////////////////////////////////////////////////////////////////////////////////////////

        book1.setBook_id("B001");
        book2.setBook_id("B002");
        book3.setBook_id("B003");

        book1.setBook_name("Ahinsakayo");
        book2.setBook_name("Nadgamkarayo");
        book3.setBook_name("Komalii");

        book1.setYear("2000");
        book2.setYear("2002");
        book3.setYear("1999");


        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        // Save

//        session.persist(author1);
//        session.persist(book1);
//        session.persist(author2);
//        session.persist(book2);
//        session.persist(author3);
//        session.persist(book3);

        Book bookUpdate =session.get(Book.class,book1.getBook_id());
        Author authorUpdate =session.get(Author.class,author2.getAuthor_id());

            authorUpdate.setAuthor_name("Nimal Jaysuriya"); //  Author Name Update
            bookUpdate.setBook_name("Gammada");            //   Book Name Update

            session.remove(author3);  //    Author Delete
            session.remove(book3);


            transaction.commit();
            session.close();

    }
}
