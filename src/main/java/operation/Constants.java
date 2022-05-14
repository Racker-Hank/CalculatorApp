package operation;

import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;

public class Constants {
    public static class Constant {
        public String name;
        public String symbol;
        public double value;

        public Constant() {
        }

        public Constant(String name , String symbol , double value) {
            this.name = name;
            this.symbol = symbol;
            this.value = value;
        }
    }

    public static final Constant Pi = new Constant("Pi" , "π" , Math.PI);

    public static final Constant e = new Constant("Euler's constant" , "e" , Math.E);

    //1. lightspeed
    public static final Constant c = new Constant("Lightspeed" , "c" , 299792458);

    //2. hằng số planck
    public static final Constant h = new Constant("Planck" , "h" , 6.626 * Math.pow(10 , -34));

    //3. hằng số hấp dẫn newton
    public static final Constant G = new Constant("Newton Const" , "G" , 6.672 * Math.pow(10 , -11));

    //4. avogadro
    public static final Constant Na = new Constant("Avogadro Cosnt" , "Na" , 6.0221415 * Math.pow(10 , 23));

    //5. faraday
    public static final Constant F = new Constant("Faraday Const" , "F" , 96485.3383);

    //6. khối lượng hạt proton
    public static final Constant mp = new Constant("Proton Weight" , "mp" , 1.67262171 * Math.pow(10 , -27));

    //7. điện tích của hạt proton
    public static final Constant qp = new Constant("Proton Charge" , "qp" , 1.60217653 * Math.pow(10 , -19));

    //8. Tỷ số từ hồi chuyển proton
    public static final Constant γp = new Constant("Proton gyroscope ratio" , "γp" , 2.67522205 * Math.pow(10 , 8));

    //9. momen từ proton
    public static final Constant μp = new Constant("Proton magnetic moment" , "μp)" , 1.41060671 * Math.pow(10 , -26));

    //10. hằng số landé g proton
    public static final Constant gp = new Constant("Proton's landé g const" , "gp)" , 5.585694701);

    //11. khối lượng hạt electron
    public static final Constant me = new Constant("Electron Weight" , "me" , 9.1093837015 * Math.pow(10 , -31));

    //12. điện tích của hạt electron
    public static final Constant qe = new Constant("Electron Charge" , "qe" , 1.602176634 * Math.pow(10 , -19));

    //13. momen từ electron
    public static final Constant μe = new Constant("Electron magnetic moment" , "μe" , -928.476412 * Math.pow(10 , -26));

    //14. Hằng số hồi chuyển từ electron
    public static final Constant γe = new Constant("Electron gyroscope ratio" , "γe" , 1.76085974 * Math.pow(10 , 11));

    //15. Hằng số landé g electron
    public static final Constant ge = new Constant("Electron's landé g const" , "ge" , -2.0023193043718);

    //16. khối lượng hạt neutron
    public static final Constant mn = new Constant("Neutron Weight" , "mn" , 1.67492728 * Math.pow(10 , -27));

    //17. Tỷ số từ hồi chuyển neutron
    public static final Constant γn = new Constant("Neutron gyroscope ratio" , "γn" , 1.83247183 * Math.pow(10 , 8));

    //18. momen từ neutron
    public static final Constant μn = new Constant("Neutron magnetic moment" , "μn" , -0.96623645 * Math.pow(10 , -26));

    //19. hằng số landé g neutron
    public static final Constant gn = new Constant("Neutron's landé g const" , "gn" , -3.82608546);

    //20. Khối lượng Muon
    public static final Constant mu = new Constant("Muon Weight" , "mu" , 1.88353140 * Math.pow(10 , -28));

    //21. momen từ Muon
    public static final Constant μμ = new Constant("Muon magnetic moment" , "μμ" , -4.49044799 * Math.pow(10 , -26));

    //22. hằng số landé g Muon
    public static final Constant gμ = new Constant("Muon's landé g const" , "gμ" , -2.0023318396);

    //23. bán kính bohr
    public static final Constant α0 = new Constant("Bohr Radius" , "a0" , 0.5291772108 * Math.pow(10 , -10));

    //24. áp suất chuẩn
    public static final Constant atm = new Constant("Standard Pressure" , "atm" , 101325);

    //25. hằng số rygberg R∞
    public static final Constant R8 = new Constant("Rygberg const" , "R∞" , 10973731.568525);

    //26. hằng số khí
    public static final Constant r = new Constant("Gas Constant" , "r" , 8.314472);

    //27. Thể tích phân tử của một khí lý tưởng
    public static final Constant Vm = new Constant("Molecular volume of an ideal gas" , "Vm" , 22.710981 * Math.pow(10
            , -3));

    //28. Hằng số Boltzman
    public static final Constant k = new Constant("Boltzman Const" , "k" , 1.3806505 * Math.pow(10 , -23));

    //29. khối lượng hạt alpha
    public static final Constant ma = new Constant("alpha Const" , "ma" , 6.6446565 * Math.pow(10 , -27));

    //30. khối lượng Helion
    public static final Constant mh = new Constant("Helion Weight" , "mh" , 5.00641214 * Math.pow(10 , -27));

    //31. Momen từ chắn helion
    public static final Constant μh = new Constant("Helion shield magnetic moment" , "μh" , -1.074553024 * Math.pow(10 ,
            -26));

    //32. Độ từ thẩm chân ko
    public static final Constant μ0 = new Constant("Vacuum permeability" , "μ0" , 4 * Pi.value * Math.pow(10 , -7));

    //33. Trở kháng đặc trưng của chân ko
    public static final Constant Z0 = new Constant("Characteristic impedance of vacuum" , "Z0" , 376.730313461);

    //34. Lượng tử từ thông
    public static final Constant φ0 = new Constant("Magnetic flux quantum" , "φ0" , 2.06783372 * Math.pow(10 , -15));

    //35. Magneto hạt nhân
    public static final Constant μN = new Constant("Nuclear Magneto" , "μN" , 5.05078343 * Math.pow(10 , 27));

    //36. Hằng số planck phân tử
    public static final Constant Nah = new Constant("Molecular Planck's constant" , "Nah" , 3.990312716 * Math.pow(10 ,
            -10));

    //37. Bước sóng Compton Proton
    public static final Constant λCp = new Constant("Compton Proton Wavelength" , "λCp" , 1.3214098555 * Math.pow(10 ,
            -15));

    //38. Bước sóng Compton Neuton
    public static final Constant λCn = new Constant("Compton Neutron Wavelength" , "λCn" , 1.3195909067 * Math.pow(10 ,
            -15));

    //39. Bước sóng Compton Muon
    public static final Constant λCμ = new Constant("Compton Muon Wavelength" , "λCμ" , 11.73444105 * Math.pow(10 , -15));

    //40. Bước sóng Compton Electron
    public static final Constant λC = new Constant("Compton Electron Wavelength" , "λC" , 2.42631023 * Math.pow(10 , -12));

    //40. Hằng số Stefan-Boltzmann
    public static final Constant σ = new Constant("Stefan-Boltzmann Const" , "σ" , 2.42631023 * Math.pow(10 , -12));

    //41. Hằng số định luật chuyển Wien
    public static final Constant b = new Constant("Wien's displacement law" , "b)" , 2.8977685 * Math.pow(10 , -3));

    //42. Lượng tử độ dẫn điện
    public static final Constant G0 = new Constant("Conductance quantum" , "G0" , 7.748091733 * Math.pow(10 , -5));

    //43. Bohr magneton
    public static final Constant μB = new Constant("Bohr magneton" , "μB" , 927.400949 * Math.pow(10 , -26));

    //44. Hằng số dirac
    public static final Constant h1 = new Constant("Dirac Const" , "h1" , 1.05457168 * Math.pow(10 , -34));

    //45. Hằng số cấu trúc tinh tế
    public static final Constant α = new Constant("Fine-structure constant" , "a" , 7.297352568 * Math.pow(10 , -3));

    //46. Hằng số bức xạ bậc 1
    public static final Constant c1 = new Constant("Radiation constant of order 1" , "c1" , 3.74177138 * Math.pow(10 , -16));

    //47. Hằng số bức xạ bậc 2
    public static final Constant c2 = new Constant("Radiation constant of order 2" , "c2" , 1.4387752 * Math.pow(10 , -2));

    //48. Độ điện thẩm chân ko
    public static final Constant ε0 = new Constant("Vacuum Permittivity" , "ε0" , 8.854187817 * Math.pow(10 , -12));

    //49. Gia tốc hấp dẫn chuẩn
    public static final Constant g = new Constant("Standard gravitational acceleration" , "g" , 9.80665);

    //50. Hằng số nguyên tử lượng
    public static final Constant υ = new Constant("(Unified atomic mass unit" , "u" , 1.66053886 * Math.pow(10 , -27));

    //51. Bán kính cổ điển electron
    public static final Constant Re = new Constant("Electron Classic Radius" , "Re" , 2.817940325 * Math.pow(10 , -15));

    public static ArrayList <Constant> constants = new ArrayList <Constant>() {
        {
            add(Pi);
            add(e);
            add(c);
            add(h);
            add(G);
            add(Na);
            add(F);
            add(mp);
            add(γe);
            add(ge);
            add(mn);
            add(γn);
            add(μn);
            add(gn);
            add(mu);
            add(μμ);
            add(gμ);
            add(α0);
            add(atm);
            add(R8);
            add(r);
            add(Vm);
            add(k);
            add(ma);
            add(mh);
            add(μh);
            add(μ0);
            add(Z0);
            add(φ0);
            add(μN);
            add(Nah);
            add(λCp);
            add(λCn);
            add(λCμ);
            add(λC);
            add(σ);
            add(b);
            add(G0);
            add(μB);
            add(h1);
            add(α);
            add(c1);
            add(c2);
            add(ε0);
            add(g);
            add(υ);
            add(Re);
        }
    };

//    public static TextArea inputTextArea;
//    public static TextArea outputTextArea;
//
//    public static class BottomRightPane extends AnchorPane {
//
//    }

    public static void main(String[] args) {
        System.out.println(Re.value);
    }
}
