package com.jpa.exp3.dao;

import com.jpa.exp3.entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

/**
 * @description：
 * @author: chenfl
 * @Date: 2019/11/17 16:26
 */
public class BookService {
    private EntityManagerFactory emf;
    private EntityManager em;

    public BookService(){
        emf = Persistence.createEntityManagerFactory("booktestPU");
        em = emf.createEntityManager();
    }

    public void addBook(){
        for (int i=0;i<10;i++){
            Book book = new Book();
            book.setBookid("979852551520"+i);
            book.setBookname("教材" + i);
            book.setPress("出版社" + i);
            book.setAuthor("作者" + i);
            book.setPrice((double)45 + i);
            em.getTransaction().begin();
            em.persist(book);
            em.getTransaction().commit();
        }
    }

    public List<Book> bookList(){
        String sql = "select b from Book b";
        Query query = em.createQuery(sql);
        return query.getResultList();
    }

    public void closeEntityManager(){
        if (em != null) {
            em.close();
        }
    }

    public static void main(String[] args){
        BookService bs = new BookService();
        bs.addBook();
        List<Book> books = bs.bookList();
        System.out.println("现有图书列表：");
        for (Book b:books){
            System.out.println(b.getBookid());
            System.out.println("," + b.getBookname());
            System.out.println(", ￥" + b.getPrice());
            System.out.println("," + b.getAuthor());
            System.out.println("," + b.getPress());
        }
        bs.closeEntityManager();
    }
}














