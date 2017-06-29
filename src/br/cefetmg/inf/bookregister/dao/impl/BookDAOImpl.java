/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.bookregister.dao.impl;

import br.cefetmg.inf.bookregister.dao.BookDAO;
import br.cefetmg.inf.bookregister.domain.Book;
import br.cefetmg.inf.bookregister.exception.PersistenceException;
import br.cefetmg.inf.util.db.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aluno
 */
public class BookDAOImpl implements BookDAO {

    @Override
    public int insert(Book book) throws PersistenceException {
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();
            
            String sql = "INSERT INTO book (TXT_name, TXT_author, NUM_ISBN, NUM_volume, DAT_date, TXT_editor, NUM_pages) VALUES(?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, book.getName());
            pstmt.setString(2, book.getAuthor());
            pstmt.setInt(3, book.getISBN());
            pstmt.setInt(4, book.getVolume());
            pstmt.setDate(5, new java.sql.Date(book.getDate().getTime()));
            pstmt.setString(6, book.getEditor());
            pstmt.setInt(7, book.getPageNbr());
            ResultSet rs = pstmt.executeQuery();

            int id;
            if (rs.next()) {
                id = rs.getInt("COD_id");
                book.setId(id);
            }

            rs.close();
            pstmt.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(BookDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return book.getId();
    }

    @Override
    public boolean update(Book book) throws PersistenceException {
        try {

            Connection connection = ConnectionManager.getInstance().getConnection();
            
            String sql = "UPDATE book " +
                           " SET TXT_name = ?, " +
                           "     TXT_author = ?, " +  
                           "     NUM_ISBN = ?, " +
                           "     NUM_volume = ?, " +
                           "     DAT_date = ?, " +
                           "     TXT_editor = ?, " +
                           "     NUM_pages = ? " +
                         " WHERE id = ?";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, book.getName());
            pstmt.setString(2, book.getAuthor());
            pstmt.setInt(3, book.getISBN());
            pstmt.setInt(4, book.getVolume());
            pstmt.setDate(5, new java.sql.Date(book.getDate().getTime()));
            pstmt.setString(6, book.getEditor());
            pstmt.setInt(7, book.getPageNbr());
            pstmt.setInt(8, book.getId());
            pstmt.executeUpdate();
            
            pstmt.close();
            connection.close();
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenceException(); 
        }
    }

    @Override
    public boolean delete(Book book) throws PersistenceException {
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "DELETE FROM book WHERE id = ?";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, book.getId());
            pstmt.executeUpdate();
            
            pstmt.close();
            connection.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenceException(); 
        }
        
    }

    @Override
    public ArrayList<Book> listAll() throws PersistenceException {
        try {    
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM book ORDER BY TXT_name";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            ArrayList<Book> listAll = null;
            BookDAO bookDAO = new BookDAOImpl();
            if (rs.next()) {
                listAll = new ArrayList<>();
                do {
                    Book book = new Book();
                    book.setId(rs.getInt("COD_id"));
                    book.setName(rs.getString("TXT_name"));
                    book.setAuthor(rs.getString("TXT_author"));
                    book.setISBN(rs.getInt("NUM_ISBN"));
                    book.setVolume(rs.getInt("NUM_volume"));
                    book.setDate(rs.getDate("DAT_date"));
                    book.setEditor(rs.getString("TXT_editor"));
                    book.setPageNbr(rs.getInt("NUM_pages"));
                    listAll.add(book);
                } while (rs.next());
            }
            
            rs.close();
            pstmt.close();
            connection.close();

            return listAll;
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenceException();
        }
    }

    @Override
    public Book searchById(int id) throws PersistenceException {
         try {
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM book WHERE id = ?";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            Book book = null;
            if (rs.next()) {
                book = new Book();
                book.setId(rs.getInt("COD_id"));
                book.setName(rs.getString("TXT_name"));
                book.setAuthor(rs.getString("TXT_author"));
                book.setISBN(rs.getInt("NUM_ISBN"));
                book.setVolume(rs.getInt("NUM_volume"));
                book.setDate(rs.getDate("DAT_date"));
                book.setEditor(rs.getString("TXT_editor"));
                book.setPageNbr(rs.getInt("NUM_pages"));
            }

            rs.close();
            pstmt.close();
            connection.close();

            return book;
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenceException();
        }
    }
    
}
