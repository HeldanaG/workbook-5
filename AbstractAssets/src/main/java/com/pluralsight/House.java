package com.pluralsight;

public class House extends Asset{

    private String address;
    private int squareFoot;
    private int lotSize;
    private int condition;

    public House(String description, String dateAcquired, double originalCost, String address, int condition, int lotSize, int squareFoot) {
        super(description, dateAcquired, originalCost);
        this.address = address;
        this.condition = condition;
        this.lotSize = lotSize;
        this.squareFoot = squareFoot;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    public int getLotSize() {
        return lotSize;
    }

    public void setLotSize(int lotSize) {
        this.lotSize = lotSize;
    }

    public int getSquareFoot() {
        return squareFoot;
    }

    public void setSquareFoot(int squareFoot) {
        this.squareFoot = squareFoot;
    }

    @Override
    public double getValue() {
        double ratePerSqFt;

        // Determine base rate by condition
        switch (condition) {
            case 1:
                ratePerSqFt = 180.00;
                break;
            case 2:
                ratePerSqFt = 130.00;
                break;
            case 3:
                ratePerSqFt = 90.00;
                break;
            case 4:
                ratePerSqFt = 80.00;
                break;
            default:
                ratePerSqFt = 0; // Unknown condition
        }

        // Base value from square footage
        double baseValue = ratePerSqFt * this.squareFoot;

        // Lot bonus (25 cents per sq ft of lot)
        double lotBonus = 0.25 * this.lotSize;

        return baseValue + lotBonus;
    }
    @Override
    public String toString() {
        return super.toString() +
                "\nSquare Footage: " + squareFoot + " sq ft" +
                "\nLot Size: " + lotSize + " sq ft" +
                "\nCondition: " + condition +
                "\nCurrent Value: $" + String.format("%.2f", getValue());
    }
}
