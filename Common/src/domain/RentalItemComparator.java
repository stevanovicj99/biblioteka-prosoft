/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import domain.RentalItem;

/**
 *
 * @author Jelena
 */
public class RentalItemComparator implements java.util.Comparator<RentalItem> {

    @Override
    public int compare(RentalItem o1, RentalItem o2) {
        return o1.getOrderNumber() - o2.getOrderNumber();
    }

}
