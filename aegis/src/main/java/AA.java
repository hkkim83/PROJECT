import java.text.DecimalFormat;


public class AA {
	public static void main(String args[]) {
		int abc = 123545;
		DecimalFormat df = new DecimalFormat("#,##0");
		System.out.println(df.format(abc));
	}
}
