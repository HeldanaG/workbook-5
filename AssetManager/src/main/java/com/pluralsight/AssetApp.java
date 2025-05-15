package com.pluralsight;

import java.util.ArrayList;

public class AssetApp {
    public static void main(String[] args) {
        // Create an ArrayList to hold Asset objects
        ArrayList<Asset> assets = new ArrayList<>();

        // Add Houses
        assets.add(new House("My House", "2015-04-01", 250000, "123 Main St", 2, 5000, 2000));
        assets.add(new House("Vacation Home", "2018-06-20", 180000, "456 Lake View", 1, 3000, 1500));

        // Add Vehicles
        assets.add(new Vehicle("Tom's Truck", "2020-01-10", 40000, "Ford F-150", 85000, 2019));
        assets.add(new Vehicle("My Car", "2019-08-12", 25000, "Toyota Camry", 120000, 2015));

        // Loop through the list and print information
        for (Asset asset : assets) {
            System.out.println("\n-------------- Asset Info -------------------");
            System.out.println("Description: " + asset.getDescription());
            System.out.println("Date Acquired: " + asset.getDateAcquired());
            System.out.printf("Original Cost: $%.2f%n", asset.getOriginalCost());
            System.out.printf("Current Value: $%.2f%n", asset.getValue());

            // Type-specific info
            if (asset instanceof House) {
                House house = (House) asset; // downcast
                System.out.println("Address: " + house.getAddress());
            } else if (asset instanceof Vehicle) {
                Vehicle vehicle = (Vehicle) asset; // downcast
                System.out.println("Year: " + vehicle.getYear());
                System.out.println("Make/Model: " + vehicle.getMakeModel());
            }
        }
    }
}
