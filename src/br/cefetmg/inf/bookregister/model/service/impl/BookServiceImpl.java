/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.bookregister.model.service.impl;

import br.cefetmg.inf.bookregister.model.dao.BookDAO;
import br.cefetmg.inf.bookregister.model.dao.impl.BookDAOImpl;
import br.cefetmg.inf.bookregister.model.domain.Book;
import br.cefetmg.inf.bookregister.exception.BusinessException;
import br.cefetmg.inf.bookregister.exception.PersistenceException;
import br.cefetmg.inf.bookregister.model.service.BookService;
import java.util.List;

/**
 *
 * @author Aluno
 */
public class BookServiceImpl implements BookService {
    
    private BookDAO bookDAO;

    public BookServiceImpl() {
        bookDAO = new BookDAOImpl();
    }    
    
    @Override
    public int insert(Book book) throws PersistenceException, BusinessException {
        if (book.getName() == null || book.getName().isEmpty()|| book.getDate() == null || book.getAuthor() == null ||
                book.getAuthor().isEmpty() || (Integer)book.getISBN() == null || (Integer)book.getPageNbr() == null || (Integer)book.getVolume() == null) {
            throw new BusinessException("Informe os campos");
        }
        int id = bookDAO.insert(book);
        return book.getId();
    }

    @Override
    public boolean update(Book book) throws PersistenceException, BusinessException {
        if ((Integer)book.getId() == null || book.getName() == null || book.getName().isEmpty()|| book.getDate() == null ||
                book.getAuthor() == null || book.getAuthor().isEmpty() || (Integer)book.getISBN() == null || 
                (Integer)book.getPageNbr() == null || (Integer)book.getVolume() == null) {
            throw new BusinessException("Informe os campos");
        }
        return bookDAO.update(book);
    }

    @Override
    public boolean delete(Book book) throws PersistenceException, BusinessException {
        if ((Integer)book.getId() == null) {
            throw new BusinessException("Informe os campos");
        }
        return bookDAO.delete(book);
    }

    @Override
    public List<Book> listAll() throws PersistenceException {
        List<Book> result = bookDAO.listAll();
        return result;   
    }

    @Override
    public Book searchById(int id) throws PersistenceException {
        Book result = bookDAO.searchById(id);
        return result;
    }
    
}
