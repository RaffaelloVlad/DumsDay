package org.example.dumsday;


import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DumsDayApplication {

    public static  void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        DumsDayApplication app = new DumsDayApplication();

        System.out.print("Enter dd.mm.yyyy: ");
        String input = scanner.next();

        while (!app.IsValid(input)) {
            System.out.print("Error! ");
            System.out.println("try again ");
            System.out.print("Enter dd.mm.yyyy: ");

            input = scanner.next();
        }

        int[] DDate = app.DecompileDate(input);
        app.logick(DDate[0],DDate[1],DDate[2]);

    }

    public boolean IsValid(String date){

        return CheckDate(date) != null;

    }

    public int[] DecompileDate(String date) {

        int[] datearrp = new int[3];
        String[] parts = date.split("\\.");
        datearrp[0] = Integer.parseInt(parts[0]);
        datearrp[1] = Integer.parseInt(parts[1]);
        datearrp[2] = Integer.parseInt(parts[2]);
        return datearrp;
    }
    public int[] CheckDate(String date){

        int[] datearrp = DecompileDate(date);

        if (datearrp.length != 3) return null;




        int tempday = datearrp[0];
        if (tempday>31 || tempday<0) return null;
        int tempmounth = datearrp[1];
        int tempyear = datearrp[2];
        switch(tempmounth) {
            case 1:
                if (tempday > 31) {
                    return null;
                }
                break;
            case 2:
                if ((IsYearLeap(tempyear) && tempday > 29) || (!IsYearLeap(tempyear) && tempday > 28)) {
                    return null;
                }
                break;
            case 3:
                if (tempday > 31) {
                    return null;
                }
                break;
            case 4:
                if (tempday > 30) {
                    return null;
                }
                break;
            case 5:
                if (tempday > 31) {
                    return null;
                }
                break;
            case 6:
                if (tempday > 30) {
                    return null;
                }
                break;
            case 7:
                if (tempday > 31) {
                    return null;
                }
                break;
            case 8:
                if (tempday > 31) {
                    return null;
                }
                break;
            case 9:
                if (tempday > 30) {
                    return null;
                }
                break;
            case 10:
                if (tempday > 31) {
                    return null;
                }
                break;
            case 11:
                if (tempday > 30) {
                    return null;
                }
                break;
            case 12:
                if (tempday > 31) {
                    return null;
                }
                break;
            default:
                return null;
        }

        return datearrp;
    }


    public void logick (int day, int month, int year) {
        System.out.println("Dums Day is the " + DumsDay(day,month, year));
        System.out.println("The leap year?: "+(IsYearLeap(year) ? "yes" : "no"));
        System.out.println("Witch Ashorn: "+(GetAshornAllYear(month , year)));
        System.out.println("This Year Ashorn: "+(GetDayName(GetAshornThisYear(year))));
    }

    public boolean IsYearLeap (int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
    public int GetAshornAllYear (int month,int year) {

        switch(month) {
            case 1:
                if (IsYearLeap(year)){
                    return 4;
                }else{
                    return 3;
                }
            case 2:
                if (IsYearLeap(year)){
                    return 29;
                }else{
                    return 28;
                }
            case 3:
                return 0;
            case 4:
                return 4;
            case 5:
                return 9;
            case 6:
                return 6;
            case 7:
                return 11;
            case 8:
                return 8;
            case 9:
                return 5;
            case 10:
                return 10;
            case 11:
                return 7;
            case 12:
                return 12;
            default:
                return 0;
        }
    }
    public int CentIndex(int year){
        return ((5*((year/100)%4)+2)%7) ;
    }
    public int YearIndex(int year){
        return ((((year%100)/12)+((year%100)%12)+(((year%100)%12)/4))%7) ;
    }

    public int GetAshornThisYear (int year){
        return ((CentIndex(year)+YearIndex(year))%7);
    }

    public String DumsDay(int day,int month,int year) {
        int temp = (day-GetAshornAllYear(month,year))%7;
        if (temp<0) {temp+=7;}
        return GetDayName((GetAshornThisYear(year)+(temp))%7);
    }

    public String GetDayName(int day){
        switch(day) {
            case 0:
                return "Sunday";
            case 1:
                return "Monday";
            case 2:
                return "Tuesday";
            case 3:
                return "Wednesday";
            case 4:
                return "Thursday";
            case 5:
                return "Friday";
            case 6:
                return "Saturday";
            default:
                return "May Day";
        }

    }

}
