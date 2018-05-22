import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class decimal {
	public static void main(String[] args) {
		String pattern = "###,###.###";
		DecimalFormat decimalFormat = new DecimalFormat(pattern);

		String format = decimalFormat.format(123456789.123);
		System.out.println(format);
	}
}
