package routines;

import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;

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
public class stylesPOI {

    /**
     * helloExample: not return value, only print "hello" + message.
     * 
     * 
     * {talendTypes} String
     * 
     * {Category} User Defined
     * 
     * {param} string("world") input: The string need to be printed.
     * 
     * {example} helloExemple("world") # hello world !.
     */
    public static void Init() {
    }
    
    public static Map<String, CellStyle> createStyles(Workbook wb) {
    	Map<String, CellStyle> styles = new HashMap<>();
        CellStyle style;
        Font titleFont = wb.createFont();
        titleFont.setFontHeightInPoints((short)14);
        //titleFont.setBold(true);
        style = wb.createCellStyle();
        style.setAlignment(CellStyle.ALIGN_LEFT);
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);        
        style.setFont(titleFont);
        //style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        //style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        
        styles.put("title", style);
        
        style = wb.createCellStyle();
        style.setAlignment(CellStyle.ALIGN_RIGHT);
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);        
        style.setFont(titleFont);
        
        styles.put("titlen", style);
                       
        
        Font headerFont = wb.createFont();
        //headerFont.setBold(true);
        
        style = createBorderedStyle(wb);
        //style.setAlignment(HorizontalAlignment.CENTER);
        //style.setFillForegroundColor(IndexedColors.LIGHT_CORNFLOWER_BLUE.getIndex());
        //style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setFont(headerFont);
        styles.put("header", style);

        Font font1 = wb.createFont();
        //font1.setBoldweight(font1.BOLDWEIGHT_BOLD);
        font1.setFontHeightInPoints((short)12);
        style = createBorderedStyle(wb);
        style.setAlignment(CellStyle.ALIGN_LEFT);
        style.setFont(font1);
        styles.put("cell_b", style);

        style = createBorderedStyle(wb);
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setFont(font1);
        styles.put("cell_b_centered", style);

        Font font2 = wb.createFont();
        //font2.setColor(IndexedColors.BLUE.getIndex());
        //font2.setBold(true);
        style = createBorderedStyle(wb);
        //style.setAlignment(HorizontalAlignment.LEFT);
        style.setFont(font2);
        styles.put("cell_bb", style);

        Font font3 = wb.createFont();
        font3.setFontHeightInPoints((short)10);
        //font3.setColor(IndexedColors.DARK_BLUE.getIndex());
        //font3.setBold(true);
        
        style = createBorderedStyle(wb);
        style.setAlignment(CellStyle.ALIGN_LEFT);
        //style.setWrapText(true);
        style.setFont(font3);
        styles.put("cell_normal", style);

        style = createBorderedStyle(wb);
        style.setAlignment(CellStyle.ALIGN_CENTER);
        //style.setWrapText(true);
        style.setFont(font3);
        styles.put("cell_normal_centered", style);

        /*style = createBorderedStyle(wb);
        //style.setAlignment(HorizontalAlignment.LEFT);
        style.setIndention((short)1);
        style.setWrapText(true);
        styles.put("cell_indented", style);*/
        
        return styles;
    }
    
    
    private static CellStyle createBorderedStyle(Workbook wb){
        BorderStyle thin = BorderStyle.THIN;
        short black = IndexedColors.BLACK.getIndex();
        
        CellStyle style = wb.createCellStyle();
        //style.setBorderRight(thin);
        style.setRightBorderColor(black);
        //style.setBorderBottom(thin);
        style.setBottomBorderColor(black);
        //style.setBorderLeft(thin);
        style.setLeftBorderColor(black);
        //style.setBorderTop(thin);
        style.setTopBorderColor(black);
        return style;
    }
    
    
    
}
