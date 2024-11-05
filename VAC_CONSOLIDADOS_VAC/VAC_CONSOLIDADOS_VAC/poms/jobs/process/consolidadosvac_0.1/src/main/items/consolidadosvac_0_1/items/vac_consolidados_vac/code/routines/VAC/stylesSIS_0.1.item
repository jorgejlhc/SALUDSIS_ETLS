package routines;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;


public class stylesSIS {

	public static Map<String, CellStyle> createStyles(Workbook wb) {
		Map<String, CellStyle> styles = new HashMap<>();
		CellStyle style;

		Font title = wb.createFont();
		title.setFontHeightInPoints((short)10);
		title.setFontName ("Arial");    
		title.setBoldweight(Font.BOLDWEIGHT_BOLD );


		style  = wb.createCellStyle();
		style.setAlignment(CellStyle.ALIGN_LEFT);
		style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);  

		style.setFont(title);

		styles.put("header_1", style);

		Font header_Font1 = wb.createFont();
		header_Font1.setFontHeightInPoints((short)8);
		header_Font1.setFontName ("Arial");    
		//header_Font1.setBoldweight(Font.BOLDWEIGHT_BOLD );

		style = wb.createCellStyle();
		style.setAlignment(CellStyle.ALIGN_CENTER);
		style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);      
		style.setRotation((short) 90);
		style.setFont(header_Font1);
		styles.put("header_2", style);



		Font titleFont = wb.createFont();
		titleFont.setFontHeightInPoints((short)8);
		titleFont.setBoldweight(Font.BOLDWEIGHT_BOLD );
		titleFont.setFontName("Arial");
		style = createBorderedStyle(wb);		
		style.setAlignment(CellStyle.ALIGN_CENTER);
		style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);  
		style.setWrapText(true);
		style.setFont(titleFont);


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
		style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		style.setFont(font1);
		style.setWrapText(true);
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
		font3.setFontName("Arial");
		//font3.setColor(IndexedColors.DARK_BLUE.getIndex());
		//font3.setBold(true);

		style = createBorderedStyle(wb);
		style.setAlignment(CellStyle.ALIGN_LEFT);
		style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		//style.setWrapText(true);
		style.setFont(font3);
		styles.put("cell_normal", style);

		style = createBorderedStyle(wb);
		style.setAlignment(CellStyle.ALIGN_CENTER);
		style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		style.setWrapText(true);
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
		style.setBorderRight(thin);
		style.setRightBorderColor(black);
		style.setBorderBottom(thin);
		style.setBottomBorderColor(black);
		style.setBorderLeft(thin);
		style.setLeftBorderColor(black);
		style.setBorderTop(thin);
		style.setTopBorderColor(black);
		return style;
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
