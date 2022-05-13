package mode.standard;

import javafx.scene.layout.Pane;
import mode.Function2;
import mode.standard.specials.RandInRangeMN;
import mode.standard.specials.RandInRangeN;
import operation.Operand;

import java.util.ArrayList;

public class Specials extends Operand {
    public static ArrayList <Function2> functions = new ArrayList <Function2>();

    public static RandInRangeMN randDoubleInRangeMN = new RandInRangeMN();
    public static RandInRangeN randDoubleInRangeN = new RandInRangeN();

    @Override
    public void addToAnchorPane(Pane parentPane) {

    }

    public Specials() {
        functions.add(randDoubleInRangeMN);
        functions.add(randDoubleInRangeN);
    }
}
