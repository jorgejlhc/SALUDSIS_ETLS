package routines;

import org.apache.commons.lang3.StringUtils;

/*
 * user specification: the function's comment should contain keys as follows: 1. write about the function's comment.but
 * it must be before the "{talendTypes}" key.
 * 
 * 2. {talendTypes} 's value must be talend Type, it is required . its value should be one of: String, char | Character,
 * long | Long, int | Integer, boolean | Boolean, byte | Byte, Date, double | Double, float | Float, Object, short |
 * Short
 * 
 * 3. {Category} define a category for the Function. it is required. its value is user-defined .
 * 
 * 4. {param} 's format is: {param} <type>[(<default value or closed list values>)] <name>[ : <comment>]
 * 
 * <type> 's value should be one of: string, int, list, double, object, boolean, long, char, date. <name>'s value is the
 * Function's parameter name. the {param} is optional. so if you the Function without the parameters. the {param} don't
 * added. you can have many parameters for the Function.
 * 
 * 5. {example} gives a example for the Function. it is optional.
 */
public class Utils {
	public static final short EXCEL_COLUMN_WIDTH_FACTOR = 256; 
	public static final short EXCEL_ROW_HEIGHT_FACTOR = 20; 
	public static final int UNIT_OFFSET_LENGTH = 7; 
	public static final int[] UNIT_OFFSET_MAP = new int[] { 0, 36, 73, 109, 146, 182, 219 };

	public static short pixel2WidthUnits(int pxs) {
		short widthUnits = (short) (EXCEL_COLUMN_WIDTH_FACTOR * (pxs / UNIT_OFFSET_LENGTH)); 
		widthUnits += UNIT_OFFSET_MAP[(pxs % UNIT_OFFSET_LENGTH)];  
		return widthUnits; 
	}

	public static int widthUnits2Pixel(short widthUnits) {
		int pixels = (widthUnits / EXCEL_COLUMN_WIDTH_FACTOR) * UNIT_OFFSET_LENGTH; 
		int offsetWidthUnits = widthUnits % EXCEL_COLUMN_WIDTH_FACTOR; 
		pixels += Math.floor((float) offsetWidthUnits / ((float) EXCEL_COLUMN_WIDTH_FACTOR / UNIT_OFFSET_LENGTH));   
		return pixels; 
	}

	public static int heightUnits2Pixel(short heightUnits) {
		int pixels = (heightUnits / EXCEL_ROW_HEIGHT_FACTOR); 
		int offsetWidthUnits = heightUnits % EXCEL_ROW_HEIGHT_FACTOR; 
		pixels += Math.floor((float) offsetWidthUnits / ((float) EXCEL_ROW_HEIGHT_FACTOR / UNIT_OFFSET_LENGTH));   
		return pixels; 
	}

	public static boolean empty( final String s ) {
		// Null-safe, short-circuit evaluation.	
		return s == null || s.trim().isEmpty();
	}
		
	public static String changeStr(String oldStr, String regex, String replacement, int maxLength) {
		if (oldStr == null || regex == null || replacement == null) {
			return oldStr;
		}

		String newStr = oldStr.trim().toUpperCase();

		if (!newStr.isEmpty()) {
			if (newStr.length() > maxLength) {
				newStr = newStr.substring(0, maxLength - 1);
			}
			newStr = StringUtils.stripAccents(newStr);
			newStr = newStr.replaceAll(regex, replacement);
		}

		return newStr;
	}

	public static String changeStr(String oldStr, String regex, String replacement) {
		if (oldStr == null || regex == null || replacement == null) {
			return oldStr;
		}

		String newStr = oldStr.trim().toUpperCase();

		if (!newStr.isEmpty()) {
			newStr = StringUtils.stripAccents(newStr);
			newStr = newStr.replaceAll(regex, replacement);
		}

		return newStr;
	}

	public static String limitStr(String oldStr, int maxLength) {
		if (oldStr == null) {
			return oldStr;
		}

		String newStr = oldStr.trim().toUpperCase();

		if (!newStr.isEmpty()) {
			if (newStr.length() > maxLength) {
				newStr = newStr.substring(0, maxLength - 1);
			}
			newStr = StringUtils.stripAccents(newStr);
		}

		return newStr;
	}
}
