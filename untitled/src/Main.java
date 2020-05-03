import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args){
        double hej = 0.1341342;
        String df = new DecimalFormat("#.##").format(hej);
        System.out.println(df);
    }
}
