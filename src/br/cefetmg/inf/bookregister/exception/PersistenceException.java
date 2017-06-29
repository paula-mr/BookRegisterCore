/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.bookregister.exception;

/**
 *
 * @author Aluno
 */
public class PersistenceException extends Exception {
    private String msg;

    public PersistenceException() {
        msg = "Persistence Exception";
    }

    public PersistenceException(String msg) {
        this.msg = msg;
    }
    
}
