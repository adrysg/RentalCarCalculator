package com.pluralsight;
import java.security.PublicKey;
import java.util.*;

public class RentalCarCalculator {
   static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {

//given values
        double priceOfCarRentalPerDay = 29.99;
        double priceOfTollTagPerDay = 3.95;
        double priceOfGPSPerDay = 2.95;
        double priceOfRoadsideAssistancePerDay = 3.95;
        float underageSurchargePercentage = 0.30f;
        int underageSurchargeCutoffAge = 25;

//prompt user to input following info
        String pickupDate = PromptForString("When will you pick up the car? (Format: YYYY-MM-DD): ");
        short numberOfDays = PromptForShort("For how many days will you need this car?: ");
        boolean needsTollTag = PromptForYesNO("Do you need a Toll Tag?: ");
        boolean needsGPS = PromptForYesNO("Do you need a GPS?: ");
        boolean needsRoadSideAssistance = PromptForYesNO("Would you like Roadside Assistance?: ");
        byte age = PromptForByte("How old are you?: ");

//Calculating totals
        double basicCarRentalFee = numberOfDays * priceOfCarRentalPerDay;
        double tollTagCost = (needsTollTag) ? (numberOfDays * priceOfTollTagPerDay) : 0;
        double costOfGPS = (needsGPS) ? (numberOfDays * priceOfGPSPerDay) : 0;
        double roadsideAssistanceCost = (needsRoadSideAssistance) ? (numberOfDays * priceOfRoadsideAssistancePerDay) : 0;
        double optionsTotalFee = tollTagCost + costOfGPS + roadsideAssistanceCost;
        double underageSurcharge = (age < underageSurchargeCutoffAge) ? basicCarRentalFee * underageSurchargePercentage : 0;
        double totalCost = basicCarRentalFee + optionsTotalFee + underageSurcharge;

//output results
        System.out.printf("Basic Car Rental Fee:  %.2f\n", basicCarRentalFee);
        System.out.printf("Options Total Fee:     %.2f\n", optionsTotalFee);
        System.out.printf("Underage Surcharge:    %.2f\n", underageSurcharge);
        System.out.println("----------------------------");
        System.out.printf("Total Due:             %.2f\n", totalCost);

    }
    public static String PromptForString(String prompt){
        System.out.print(prompt);
        return s.nextLine();
    }
    public static short PromptForShort(String prompt){
        System.out.print(prompt);
        short userinput = s.nextShort();
        s.nextLine();
        return userinput;
    }
    public static boolean PromptForYesNO(String prompt){
        System.out.print(prompt + "(Y for Yes, N for No)? ");
        String userinput = s.nextLine();
        return userinput.equalsIgnoreCase("Y") || userinput.equalsIgnoreCase("YES");
    }
    public static byte PromptForByte(String prompt){
        System.out.print(prompt);
        byte userinput = s.nextByte();
        return userinput;
    }

}



