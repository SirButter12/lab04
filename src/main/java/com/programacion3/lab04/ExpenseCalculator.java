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
    
    public static double calculateTotalExpenses(
            double daysOnTrip, double foodExpense, double airfare, double carRentalFees, double milesDriven, double amountOfParkingFees, double parkingFee,
            double taxiCharges, double registrationFees, double lodgingCharges) {
        
        return daysOnTrip * foodExpense + airfare + milesDriven * carRentalFees + taxiCharges + registrationFees + lodgingCharges + amountOfParkingFees * parkingFee;
    }
    
    public static double calculateTotalReimbursable(
        double daysOnTrip, double airfare, double milesDriven, double amountOfParkingFees, double parkingFee,
        boolean usedTaxi, double registrationFees) {
        double idk = usedTaxi ? 1 : 0;
        double totalParking = daysOnTrip == 0 ? 0 : amountOfParkingFees * parkingFee / daysOnTrip;
        double lodgingBudget = daysOnTrip == 0 ? 0: LODGING_BUDGET * (daysOnTrip - 1);
        
        double parkinReimbursable = totalParking > PARKING_BUDGET ? daysOnTrip * PARKING_BUDGET : totalParking;
        
        return (daysOnTrip * MEAL_BUDGET) + airfare + (milesDriven * PER_MILE) + (idk * TAXI_BUDGET * daysOnTrip) +  registrationFees + lodgingBudget + parkinReimbursable;
    }
}
     
