1)
 import java.util.Scanner;


class Vehicle {
    private String name;
    private String type;
    private String size;


    public Vehicle(String name, String type, String size) {
        this.name = name;
        this.type = type;
        this.size = size;
    }


    public String getType() {
        return type;
    }


    public String getSize() {
        return size;
    }
}


class Parking {
    private int levels;
    private int slots;
    private int[][] park;
    private int[][] slotSize;


    public Parking(int levels, int slots) {
        this.levels = levels;
        this.slots = slots;
        this.park = new int[levels][slots];
        this.slotSize = new int[levels][slots];
        initializeSlotSizes();
    }


    private void initializeSlotSizes() {
        for (int i = 0; i < levels; i++) {
            for (int j = 0; j < slots; j++) {
                if (i == 0) {
                    slotSize[i][j] = 0;
                } else if (i == 1) {
                    slotSize[i][j] = 1;
                } else {
                    slotSize[i][j] = 2;
                }
            }
        }
    }






    private String getSizeDescription(int size) {
        switch (size) {
            case 0: return "small";
            case 1: return "medium";
            case 2: return "large";
            default: return "unknown";
        }
    }


    public boolean parkVehicle(Vehicle vehicle) {
        int requiredSize = getSizeIndex(vehicle.getSize());
        for (int i = 0; i < levels; i++) {
            for (int j = 0; j < slots; j++) {
                if (park[i][j] == 0 && slotSize[i][j] >= requiredSize) {
                    park[i][j] = 1;
                    System.out.println("The " + vehicle.getType() + " has been parked at level " + i + " and slot " + j);
                    return true;
                }
            }
        }
        System.out.println("No parking slots available for the vehicle size: " + vehicle.getSize());
        return false;
    }


    private int getSizeIndex(String size) {
        switch (size.toLowerCase()) {
            case "small": return 0;
            case "medium": return 1;
            case "large": return 2;
            default: return -1;
        }
    }
}


public class Tan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       
        Parking parkingLot = new Parking(3, 10);
       
        parkingLot.displayAvailableSlots();
       
        System.out.print("Enter vehicle name: ");
        String name = sc.nextLine();
        System.out.print("Enter vehicle type (e.g., car, truck): ");
        String type = sc.nextLine();
        System.out.print("Enter vehicle size (small, medium, large): ");
        String size = sc.nextLine();
       
   
        Vehicle vehicle = new Vehicle(name, type, size);
        parkingLot.parkVehicle(vehicle);


       
        sc.close();
    }
}


 