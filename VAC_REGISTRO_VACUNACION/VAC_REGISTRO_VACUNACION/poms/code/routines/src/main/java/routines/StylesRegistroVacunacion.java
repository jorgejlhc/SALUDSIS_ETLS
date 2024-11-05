package routines;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;


public class StylesRegistroVacunacion {

	
	public static Map<String, CellStyle> createStyles(Workbook wb) {

		Map<String, CellStyle> styles = new HashMap<>();
		CellStyle style;

		Font header1Font = wb.createFont();
		header1Font.setFontHeightInPoints((short)10);
		header1Font.setFontName ("Arial");    
		header1Font.setBold(true);		

		style  = wb.createCellStyle();
		style.setAlignment(HorizontalAlignment.CENTER);
		style.setVerticalAlignment(VerticalAlignment.CENTER);  		
		style.setFont(header1Font);
		styles.put("header_1", style);

		Font header2Font = wb.createFont();
		header2Font.setFontHeightInPoints((short)10);
		header2Font.setFontName ("Arial");    
		header2Font.setBold(true);

		style = wb.createCellStyle();
		style.setAlignment(HorizontalAlignment.CENTER);
		style.setVerticalAlignment(VerticalAlignment.CENTER);         
		style.setFont(header2Font);
		styles.put("header_2", style);

		Font titleFont = wb.createFont();
		titleFont.setFontHeightInPoints((short)8);
		titleFont.setBold(true);
		titleFont.setFontName("Arial");
		
		// title
		style = wb.createCellStyle();
		style.setAlignment(HorizontalAlignment.CENTER);
		style.setVerticalAlignment(VerticalAlignment.CENTER);  
		style.setBorderTop(BorderStyle.THIN);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        style.setWrapText(true);
		style.setFont(titleFont);
		styles.put("title", style);
		
		// title_rotate
		style = wb.createCellStyle();;
        style.setAlignment(HorizontalAlignment.CENTER);               
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setRotation((short)90);
        style.setBorderTop(BorderStyle.THIN);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        style.setWrapText(true);
        style.setFont(titleFont);
        styles.put("title_rotate", style);
		
        
    	Font titleCell = wb.createFont();
		titleCell.setFontHeightInPoints((short)10);
		titleCell.setFontName("Arial");
		
		// title
		style = wb.createCellStyle();
		style.setAlignment(HorizontalAlignment.CENTER);
		style.setVerticalAlignment(VerticalAlignment.CENTER);  
        style.setWrapText(true);
		style.setFont(titleCell);
		styles.put("cell", style);
		
		Font filtrosCell = wb.createFont();
		filtrosCell.setFontHeightInPoints((short)12);
		filtrosCell.setFontName("Calibri");
		
		// title
		style = wb.createCellStyle();
		style.setAlignment(HorizontalAlignment.LEFT);
		style.setVerticalAlignment(VerticalAlignment.CENTER);          
		style.setFont(filtrosCell);
		styles.put("filtros", style);
        
		return styles;
	}

	public static void setCellColor(Cell cell, String color){		
		// obtiene el estilo actual
		XSSFCellStyle style = (XSSFCellStyle)cell.getCellStyle();
		
		// crea nuevo estilo a partir del actual
		XSSFCellStyle newStyle = (XSSFCellStyle)style.clone();
				
		// establece patron para colorear
		newStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		// establece el color
		newStyle.setFillForegroundColor(new XSSFColor(Color.decode(color)));
		
		// actualiza el estilo
		cell.setCellStyle(newStyle);				
	}
}
