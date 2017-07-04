/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.bookregister.model.service;

import br.cefetmg.inf.bookregister.model.domain.Book;
import br.cefetmg.inf.bookregister.exception.BusinessException;
import br.cefetmg.inf.bookregister.exception.PersistenceException;
import java.util.List;

/**
 *
 * @author Aluno
 */
public interface BookService {
    public int insert(Book book) throws PersistenceException, BusinessException;
    public boolean update(Book book) throws PersistenceException, BusinessException;
    public boolean delete(Book book) throws PersistenceException, BusinessException;
    public List<Book> listAll() throws PersistenceException;
    public Book searchById(int id) throws PersistenceException;    
}
