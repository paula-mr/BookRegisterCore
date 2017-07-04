/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.bookregister.model.domain;

import java.util.Date;

/**
 *
 * @author Aluno
 */
public class Book {
    private int id;
    private String name;
    private String author;
    private int ISBN;
    private int volume;
    private Date date;
    private String editor;
    private int pageNbr;

    public Book() {
    }

    public Book(int id, String name, String author, int ISBN, int volume, Date date, String editor, int pageNbr) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.ISBN = ISBN;
        this.volume = volume;
        this.date = date;
        this.editor = editor;
        this.pageNbr = pageNbr;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public int getPageNbr() {
        return pageNbr;
    }

    public void setPageNbr(int pageNbr) {
        this.pageNbr = pageNbr;
    }
    
    
}
