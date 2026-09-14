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
            int daysOnTrip, double foodExpense, double airfare, double carRentalFees, double milesDriven, int amountOfParkingFees, double parkingFee,
            double taxiCharges, double registrationFees, double lodgingCharges) {
        Map<String, Double> expenses = new HashMap<>();
        
        expenses.put("Meals", daysOnTrip * foodExpense);
        expenses.put("Airfare", airfare);
        expenses.put("PrivateCar", milesDriven * carRentalFees);
        expenses.put("ParkingFees", amountOfParkingFees * parkingFee);
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
    
    public Map<String, Double> calculateReimbursable(
            int daysOnTrip, double airfare, double milesDriven, int amountOfParkingFees, double parkingFee,
            boolean usedTaxi, double registrationFees) {
        
        Map<String, Double> reimbursable = new HashMap<>();
        
        double idk = usedTaxi ? 1 : 0;
        double totalParking = amountOfParkingFees * parkingFee / daysOnTrip;
        
        double parkinReimbursable = totalParking > PARKING_BUDGET ? daysOnTrip * PARKING_BUDGET : totalParking;
        
        reimbursable.put("Meals", daysOnTrip * MEAL_BUDGET);
        reimbursable.put("Airfare", airfare);
        reimbursable.put("PrivateCar", milesDriven * PER_MILE);
        reimbursable.put("ParkingFees", parkinReimbursable);
        reimbursable.put("taxiCharges", idk * TAXI_BUDGET * daysOnTrip);
        reimbursable.put("registrationFees", registrationFees);
        reimbursable.put("lodgingCharges", LODGING_BUDGET * (daysOnTrip - 1));
        
        double total = 0;
        
        for (double expense: reimbursable.values()) {
            total += expense;
        }
        
        reimbursable.put("total", total);
        
        return reimbursable;
    }
    
    public double calculateTotalExpenses(
            int daysOnTrip, double foodExpense, double airfare, double carRentalFees, double milesDriven, int amountOfParkingFees, double parkingFee,
            double taxiCharges, double registrationFees, double lodgingCharges) {
        
        return daysOnTrip * foodExpense + airfare + milesDriven * carRentalFees + taxiCharges + registrationFees + lodgingCharges + amountOfParkingFees * parkingFee;
    }
    
    public double calculateTotalReimbursable(
            int daysOnTrip, double airfare, double milesDriven, int amountOfParkingFees, double parkingFee,
            boolean usedTaxi, double registrationFees) {
        double idk = usedTaxi ? 1 : 0;
        double totalParking = amountOfParkingFees * parkingFee / daysOnTrip;
        
        double parkinReimbursable = totalParking > PARKING_BUDGET ? daysOnTrip * PARKING_BUDGET : totalParking;
        
        return (daysOnTrip * MEAL_BUDGET) + airfare + (milesDriven * PER_MILE) + (idk * TAXI_BUDGET * daysOnTrip) +  registrationFees + (LODGING_BUDGET * (daysOnTrip - 1)) + parkinReimbursable;
    }
}
     
