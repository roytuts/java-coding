package com.roytuts.java.misc;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Base64;

public class EncodeDecodeData {

	public static void main(String[] args) {
		BankPaymentData paymentData = new BankPaymentData();
		paymentData.setAmount(BigDecimal.valueOf(0.01));
		paymentData.setDate(LocalDate.parse("2020-10-15"));
		paymentData.setDebtorIban("EE909609601200921004");
		paymentData.setCreditorIban("EE129609601200951799");
		paymentData.setCreditorName("Sven Meimer");
		paymentData.setPaymentNumber("1952574");
		paymentData.setPurpose("testing the payment of 11 cents");

		String encoded = encodeNordeaPayment(paymentData);
		BankPaymentData decoded = decodeNordeaPayment(encoded);

		System.out.println(encoded);

		System.out.println(decoded);
	}

	private static String encodeNordeaPayment(BankPaymentData paymentData) {
		String toHash = String.format("%s#%s#%s#%s#%s#%s#%s", encodeString(paymentData.getPaymentNumber()),
				encodeString(paymentData.getDate().toString()), encodeString(paymentData.getDebtorIban()),
				encodeString(paymentData.getCreditorName()), encodeString(paymentData.getCreditorIban()),
				encodeString(paymentData.getAmount().toString()), encodeString(paymentData.getPurpose()));
		return Base64.getEncoder().encodeToString(toHash.getBytes());
	}

	private static BankPaymentData decodeNordeaPayment(String encodedString) {
		try {
			String decoded = decodeString(encodedString);
			String[] arrayOfData = decoded.split("#");
			BankPaymentData bankPaymentData = new BankPaymentData();
			bankPaymentData.setPaymentNumber(decodeString(arrayOfData[0]));
			bankPaymentData.setDate(LocalDate.parse(decodeString(arrayOfData[1])));
			bankPaymentData.setDebtorIban(decodeString(arrayOfData[2]));
			bankPaymentData.setCreditorName(decodeString(arrayOfData[3]));
			bankPaymentData.setCreditorIban(decodeString(arrayOfData[4]));
			bankPaymentData.setAmount(BigDecimalUtil.stringToBigDecimal(decodeString(arrayOfData[5])));
			bankPaymentData.setPurpose(decodeString(arrayOfData[6]));

			return bankPaymentData;
		} catch (Exception e) {
			throw new RuntimeException("Invalid Payment Id");
		}
	}

	public static String encodeString(String toEncode) {
		return Base64.getEncoder().encodeToString(toEncode.getBytes());
	}

	public static String decodeString(String toDecode) {
		return new String(Base64.getDecoder().decode(toDecode));
	}

}
