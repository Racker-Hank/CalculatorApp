package mode.equation;

import mode.Mode;
import operation.Fraction;

import java.util.ArrayList;

public class Degree extends Mode {
    public ArrayList<Fraction> solutions = new ArrayList<>();

    public String solutionString;

    public static ArrayList<String> operators = new ArrayList <String>() {
        {
            add("=");
            add(">");
            add("<");
            add("≥");
            add("≤");
        }
    };

}
