/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.bookregister.dao;

import br.cefetmg.inf.bookregister.domain.Book;
import br.cefetmg.inf.bookregister.exception.PersistenceException;
import java.util.ArrayList;

/**
 *
 * @author Aluno
 */
public interface BookDAO {
    int insert(Book book) throws PersistenceException;
    boolean update(Book book) throws PersistenceException;
    boolean delete(Book book) throws PersistenceException;
    ArrayList<Book> listAll() throws PersistenceException;
    Book searchById(int id) throws PersistenceException;
}
