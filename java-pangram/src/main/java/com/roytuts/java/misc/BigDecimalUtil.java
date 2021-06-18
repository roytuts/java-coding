package com.roytuts.java.misc;

import java.math.BigDecimal;

/**
 * {@code BigDecimal} utils.
 */
public class BigDecimalUtil {
	private BigDecimalUtil() {
		throw new IllegalStateException("Utility class");
	}

	/**
	 * Parse different string formats to BigDecimal
	 *
	 * @param number input string
	 * @return BigDecimal from input string
	 */
	public static BigDecimal stringToBigDecimal(String number) {
		boolean negate = false;
		if (!number.contains(".") && !number.contains(",")) {
			return new BigDecimal(number);
		}
		number = number.replace(",", "").replace(".", "");
		if (number.endsWith("+")) {
			number = number.replace("+", "");
		} else if (number.endsWith("-")) {
			number = number.replace("-", "");
			negate = true;
		}
		number = number.substring(0, number.length() - 2) + "." + number.substring(number.length() - 2);
		if (negate) {
			return new BigDecimal(number).negate();
		} else {
			return new BigDecimal(number);
		}
	}
}