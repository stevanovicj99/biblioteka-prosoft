/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package communication;

import java.io.Serializable;

/**
 *
 * @author Jelena
 */
public enum Operation implements Serializable {
    LOGIN,
    LOGOFF,
    
    GET_ALL_MEMBER_TYPE,
    
    GET_ALL_AUTHOR,
    ADD_AUTHOR,
    DELETE_AUTHOR,
    EDIT_AUTHOR,
    
    GET_ALL_BOOKS,
    ADD_BOOK,
    DELETE_BOOK,
    EDIT_BOOK,
    
    GET_ALL_MEMBERS,
    ADD_MEMBER,
    DELETE_MEMBER,
    EDIT_MEMBER,
    
    GET_ALL_RENTALS,
    ADD_RENTAL,
    GET_ALL_RENTALS_BY_MEMBER,
    EDIT_RENTAL,
}
