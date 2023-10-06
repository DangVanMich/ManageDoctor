package view;

import model.Doctor;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Validation {

    private final static Scanner sc = new Scanner(System.in);

    public int checkInputIntLimit(int min, int max) {
        while (true) {
            try {
                int check = Integer.parseInt(sc.nextLine().trim());
                if (check < min || check > max) {
                    throw new Exception();
                } else {
                    return check;
                }
            } catch (Exception e) {
                System.out.println("Please input number in range [" + min + ", " + max + "]!");
                System.out.println("Enter again: ");
            }
        }
    }

    public String checkInputString(String name) {
        while (true) {
            System.out.println(name);
            String string = sc.nextLine().trim();
            if (string.isEmpty()) {
                System.out.println("Not allowed empty!");
                System.out.println("Enter again: ");
            } else {
                return string;
            }
        }
    }

    public String checkInputString1() {
        while (true) {
            String string = sc.nextLine();
            if (string.isEmpty()) {
                System.out.println("Not allowed empty!");
                System.out.println("Enter again: ");
            } else {
                return string;
            }
        }
    }

    public int checkInputInt(String name) {
        while (true) {
            System.out.println(name);
            try {
                int number = sc.nextInt();
                return number;
            } catch (Exception e) {
                System.err.println("Just enter number!");
                sc.nextLine();
            }
        }
    }

    public boolean checkInputYesNo() {
        while (true) {
            String result = checkInputString1();
            if (result.equalsIgnoreCase("Y")) {
                return true;
            } else if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.out.println("Please input y/Y or n/N.");
            // System.out.println("Enter again: ");
        }
    }

    public boolean checkInputUpdateDelete() {
        while (true) {
            String result = checkInputString1();
            if (result.equalsIgnoreCase("U")) {
                return true;
            } else if (result.equalsIgnoreCase("D")) {
                return false;
            }
            System.out.println("Please input y/Y or n/N.");
            System.out.println("Enter again: ");
        }
    }

    public boolean checkIdExist(ArrayList<Doctor> list, String id) {
        try {
            for (Doctor doctor : list) {
                if (doctor.getCode().equalsIgnoreCase(id)) {
                    System.out.println("Id exist in list!");
                    return true;
                }
            }
        } catch (Exception e) {
            System.err.println("Not found!!");
        }
        return false;
    }

}
