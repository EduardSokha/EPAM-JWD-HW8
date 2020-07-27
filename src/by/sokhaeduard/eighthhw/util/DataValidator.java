package by.sokhaeduard.eighthhw.util;

public class DataValidator {
    private static final int MAX_PAGES = 1500;
    private static final String REG_UID = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-" +
            "[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}";
    private static final String REG_DIGITS = "\\d+";

    private DataValidator() {
	}

	public static boolean isNumberPagesValid(String numberPages) {
        boolean result = false;
        if (isDigit(numberPages)) {
            int intNumberPages = Integer.parseInt(numberPages);
            result = intNumberPages > 0 && intNumberPages < MAX_PAGES;
        }
        return result;
    }

    public static boolean isIdValid(String id) {
        return id.matches(REG_UID);
    }
    
    private static boolean isDigit(String number) {
        return number.matches(REG_DIGITS);
    }
}
