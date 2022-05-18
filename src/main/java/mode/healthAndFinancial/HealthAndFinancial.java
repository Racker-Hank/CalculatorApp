package mode.healthAndFinancial;

import mode.Mode;

public class HealthAndFinancial extends Mode {

   // public static final Function BMICalculator = new Function("BMI Calculator",CalculateBMI);

        public static final String name = "BMI Calculator";
        public static double CalculateBMI(double height, double weight) {
            double y = height; // height in cm
            double x = weight; // weight in kg

            return (weight / (height * height)) * 10000;


        }

    public static class BankInterestWithPeriod {
        public static final String name = "BankInterestWithPeriod";
        public static double BankInterestWithPeriod(double MoneyIn, double InterestByPercentage, double TimeByYear) {
            double p = MoneyIn;
            double r = InterestByPercentage;
            double t = TimeByYear;

            return ((p * r * t) / 100 );
        }
    }
    public static class BankInterestWithoutPeriod {
        public static final String name = "BankInterestWithoutPeriod";
        public static double BankInterestWithoutPeriod(double MoneyIn, double InterestByPercentage, double TimeByDay) {
            double p = MoneyIn;
            double r = InterestByPercentage;
            double t = TimeByDay;

            return ((p * r * t) /100 )/360;
        }
    }

    public static class CompoundInterest {
        public static final String name = "CompoundInterest";
        public static double CompoundInterest(double Principal, double Interestrate, double CompoundedInterestTime, double Time) {
            double p = Principal;
            double r = Interestrate;
            double n = CompoundedInterestTime;
            double t = Time;

            return (p * Math.pow(1 + ((r / n)/100), n * t)-p);
        }
    }

    public static class PrintBMICategory {

        public static void PrintBMICategory ( double height, double weight){
        double bmi = (weight / (height * height)) / 100;

        if (bmi < 18.5) {
            System.out.println("You are underweight.");
            System.out.println("https://tienphong.vn/nguoi-gay-lam-the-nao-de-tang-can-hieu-qua-trong-thoi-gian-ngan-nhat-post1234055.tpo");
        } else if (bmi < 25) {
            System.out.println("You are normal.");
        } else if (bmi < 30) {
            System.out.println("You are overweight.");
            System.out.println("https://hellobacsi.com/the-duc-the-thao/bai-tap-giam-can/giam-can-trong-1-thang/");
        } else {
            System.out.println("You are obese.");
            System.out.println("https://bcare.vn/bai-viet/cham-soc-benh-nhan-beo-phi-2138.html");

        }

    }
    }

        public static void main (String[]args){

            //System.out.println(BMICalculator.BMICalculator(170,50));
            PrintBMICategory.PrintBMICategory(170,50);
            System.out.println(BankInterestWithoutPeriod.BankInterestWithoutPeriod(2000,8,360));
            System.out.println(BankInterestWithPeriod.BankInterestWithPeriod(2000,8,1));
            System.out.println(CompoundInterest.CompoundInterest(2000,8,12,1));


        }



}