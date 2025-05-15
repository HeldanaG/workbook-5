package com.pluralsight;

public class Vehicle extends Asset{

    private String makeModel;
    private int year;
    private int odometer;

    public Vehicle(String description, String dateAcquired, double originalCost, String makeModel, int odometer, int year) {
        super(description, dateAcquired, originalCost);
        this.makeModel = makeModel;
        this.odometer = odometer;
        this.year = year;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public double getValue() {
        int currentYear = java.time.Year.now().getValue();
        int age = currentYear - year;
        double value;


        if (age <= 3) {
            value = originalCost * Math.pow(0.97, age); // 3% per year
        } else if (age <= 6) {
            value = originalCost * Math.pow(0.94, age - 3) * Math.pow(0.97, 3); // 3% for first 3 years, 6% after
        } else if (age <= 10) {
            value = originalCost * Math.pow(0.94, 3) * Math.pow(0.92, age - 6) * Math.pow(0.97, 3);
        } else {
            value = 1000.00;
        }

        // Apply mileage reduction unless Honda or Toyota
        String makeLower = makeModel.toLowerCase();
        if ( odometer > 100000 && !(makeLower.contains("honda") || makeLower.contains("toyota"))) {
            value *= 0.75; // reduce by 25%
        }

        return value;
    }
    @Override
    public String toString() {
        return super.toString() +
                "\nMake/Model: " + makeModel +
                "\nYear: " + year +
                "\nOdometer: " + odometer + " miles" +
                "\nCurrent Value: $" + String.format("%.2f", getValue());
    }

}
