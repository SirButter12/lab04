/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion3.lab04;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ian
 */
public class ExpenseCalculator {
    private static final double MEAL_BUDGET = 37.0;
    private static final double PARKING_BUDGET = 10.0;
    private static final double TAXI_BUDGET = 20.0;
    private static final double LODGING_BUDGET = 95.0;
    private static final double PER_MILE = 0.27;
    
    public Map<String, Double> calculateExpenses(
            int daysOnTrip, double foodExpense, double airfare, double carRentalFees, double milesDriven,
            double taxiCharges, double registrationFees, double lodgingCharges) {
        Map<String, Double> expenses = new HashMap<>();
        
        expenses.put("Meals", daysOnTrip * foodExpense);
        expenses.put("Airfare", airfare);
        expenses.put("PrivateCar", milesDriven * carRentalFees);
        expenses.put("taxiCharges", taxiCharges);
        expenses.put("registrationFees", registrationFees);
        expenses.put("lodgingCharges", lodgingCharges);
        
        double total = 0;
        
        for (double expense: expenses.values()) {
            total += expense;
        }
        
        expenses.put("total", total);
        
        return expenses;
    }
    
    public double calculateTotalExpenses(
            int daysOnTrip, double foodExpense, double airfare, double carRentalFees, double milesDriven,
            double taxiCharges, double registrationFees, double lodgingCharges) {
        
        return daysOnTrip * foodExpense + airfare + milesDriven * carRentalFees + taxiCharges + registrationFees + lodgingCharges;
    }
    
    public double calculateTotalReimbursable(
            int daysOnTrip, double airfare, double milesDriven,
            double taxiCharges, double registrationFees, double lodgingCharges) {
        
        return daysOnTrip * MEAL_BUDGET + airfare + milesDriven * PER_MILE +  +  registrationFees + lodgingCharges;
    }
}
