package routines;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class SISPOI {

	public static String fileName;
	public static String pathStorage;
	public static String tipoEsquema;
	private static File archivo;	
	private static Workbook workBook;
	private static Sheet sheetEsquema;
	public static int totalDatosBasicos;
	private static Map<String, CellStyle> styles;

	public static void initialize(String _path, String _name, String _tipoVacuna){
		// Creamos el archivo donde almacenaremos las respuestas de la encuesta 
		archivo = new File(_path + "\\" + _name);

		// Creamos el libro de trabajo de Excel formato OOXML
		workBook = new XSSFWorkbook(); 

		// Creamos los estilos 
		styles = stylesSIS.createStyles(workBook);

		// Creamos las hojas donde pondremos los datos
		sheetEsquema = workBook.createSheet(_tipoVacuna);                             
	}

	public static void Header_Satic(String departamento, String codDepartamento,String anio, String mes){    
		/////////////////////////////////////////
		//New Row 
		/////////////////////////////////////////
		Row deptoRow = sheetEsquema.createRow(0);
		deptoRow.setHeightInPoints(20);      

		Cell deptoCell = deptoRow.createCell(0);
		deptoCell.setCellValue("NOMBRE DEPARTAMENTO:" );				
		deptoCell.setCellStyle(styles.get("header_1")); 			
		
		sheetEsquema.addMergedRegion(CellRangeAddress.valueOf("$A$1:$C$1"));

		
		Cell deptoCellValue = deptoRow.createCell(3);
		deptoCellValue.setCellValue(departamento);
		// sheetEsquema.addMergedRegion(CellRangeAddress.valueOf("$D$1:$D$1"));
		//fInicialCell.setCellStyle(styles.get("titlen"));    


		Cell cdeptoCell = deptoRow.createCell(4);
		cdeptoCell.setCellValue("CODIGO DEPARTAMENTO:" );
		cdeptoCell.setCellStyle(styles.get("header_1"));    
		//sheetEsquema.addMergedRegion(CellRangeAddress.valueOf("$E$1:$G$1"));


		Cell cdeptoCellValue = deptoRow.createCell(7);
		cdeptoCellValue.setCellValue(codDepartamento );
		//fInicialCell.setCellStyle(styles.get("titlen"));    


		/////////////////////////////////////////
		//New Row
		/////////////////////////////////////////
		Row anioRow = sheetEsquema.createRow(1);
		anioRow.setHeightInPoints(20);

		Cell anioCell = anioRow.createCell(0);
		anioCell.setCellValue("AÑO:" );
		anioCell.setCellStyle(styles.get("header_1"));       
		sheetEsquema.addMergedRegion(CellRangeAddress.valueOf("$A$2:$C$2"));


		Cell anioCellValue = anioRow.createCell(3);
		anioCellValue.setCellStyle(styles.get("header_1")); 
		anioCellValue.setCellValue(anio);
		//fInicialCell.setCellStyle(styles.get("titlen"));    
		//sheetEsquema.addMergedRegion(CellRangeAddress.valueOf("$D$2:$D$2"));

		/////////////////////////////////////////
		//New Row
		/////////////////////////////////////////
		Row mesRow = sheetEsquema.createRow(2);
		mesRow.setHeightInPoints(20);
		
		
		Cell mesCell = mesRow.createCell(0);
		mesCell.setCellValue("MES DE REPORTE:" );
		mesCell.setCellStyle(styles.get("header_1"));   
		sheetEsquema.addMergedRegion(CellRangeAddress.valueOf("$A$3:$C$3"));  



		Cell mesCellValue = mesRow.createCell(3);
		mesCellValue.setCellValue(mes);
		mesCellValue.setCellStyle(styles.get("header_1")); 
		//sheetEsquema.addMergedRegion(CellRangeAddress.valueOf("$D$3:$D$3")); 
		
		sheetEsquema.setColumnWidth(3, Utils.pixel2WidthUnits(150));

	}

	// Nivel 1 - DOSIS
	public static void Header_Dinamic(String nivel1, String color){
		String [] colums = nivel1.split("¬");
		String [] colors = color.split("¬");

		Row row = sheetEsquema.createRow(5);
		row.setHeightInPoints(55);

		Cell itemCell = row.createCell(0);
		itemCell.setCellValue("Nº Cons" );
		itemCell.setCellStyle(styles.get("title")); 
		//itemCell.setCellStyle(styles.get("header_2")); 

		Cell codmpioCell = row.createCell(1);
		codmpioCell.setCellValue("COD DANE\nMPIO" );
		codmpioCell.setCellStyle(styles.get("title")); 
		//codmpioCell.setCellStyle(styles.get("header_1"));
		sheetEsquema.setColumnWidth(1, Utils.pixel2WidthUnits(80));

		Cell nommpioCell = row.createCell(2);
		nommpioCell.setCellValue("NOMBRE MUNICIPIO/\nIPS" );
		nommpioCell.setCellStyle(styles.get("title"));
		sheetEsquema.setColumnWidth(2, Utils.pixel2WidthUnits(80));
		//nommpioCell.setCellStyle(styles.get("header_1"));

		for(int i = 4, j= 1; j <= colums.length; i++, j++) {  
			Cell CellFor = row.createCell(i);
			CellFor.setCellValue(colums[j-1]);						
			CellFor.setCellStyle(styles.get("title"));
			stylesSIS.setCellColor(CellFor, colors[j-1]);

			//sheetEsquema.autoSizeColumn(i);
			sheetEsquema.setColumnWidth(i, Utils.pixel2WidthUnits(100));
		} 
		
		Cell totalCell = row.createCell(colums.length + 4);
		totalCell.setCellValue("TOTAL" );
		totalCell.setCellStyle(styles.get("title"));
	}

	// Nivel 2 - CATEGORIAS
	public static void Header_Dinamic_nivel2(String nivel1List, String nivel2List, String cantidadesList, String colorList){
		String [] nivel1 = nivel1List.split("¬");
		String [] nivel2 = nivel2List.split("¬");
		String [] cantidades = cantidadesList.split("¬");
		String [] colores = colorList.split("¬");
		
		Row row = sheetEsquema.createRow(4);
		row.setHeightInPoints(55);

		for(int j = 1, k = 4, l = 1; j <= nivel2.length; j++) {   
			int cantidad = Integer.parseInt(cantidades[j-1]);
			
			Cell CellFor2 = row.createCell(k);
			CellFor2.setCellValue(nivel2[j-1]);
			CellFor2.setCellStyle(styles.get("title"));
			stylesSIS.setCellColor(CellFor2, colores[j-1]);
			
			if(cantidad > 1){
				sheetEsquema.addMergedRegion(new CellRangeAddress(4,4,k,k+(cantidad-1)));			
			}
			
			// VALIDAR
			if (nivel2[j-1].equals(nivel1[l-1])){									
				sheetEsquema.addMergedRegion(new CellRangeAddress(4,5,k,k+(cantidad-1)));														
			}

			k = k + cantidad;
			l = l + cantidad;					
		}   
	}

	// Nivel 3 - BIOLOGICOS
	public static void Header_Dinamic_nivel3(String nivel3List, String cantidadesList, String colorList){
		String [] nivel3 = nivel3List.split("¬");
		String [] cantidades = cantidadesList.split("¬");
		String [] colores = colorList.split("¬");
		
		Row row = sheetEsquema.createRow(3);
		row.setHeightInPoints(55);
		Cell mcpioCell = row.createCell(0);
		mcpioCell.setCellValue("MUNICIPIO" );   
		mcpioCell.setCellStyle(styles.get("title"));
		sheetEsquema.addMergedRegion(new CellRangeAddress(3,4,0,2));

		Cell catCell = row.createCell(3);
		sheetEsquema.addMergedRegion(CellRangeAddress.valueOf("$D$4:$D$6"));
		catCell.setCellValue("REGIMEN / \nGRUPO ETNICO" );
		catCell.setCellStyle(styles.get("title"));

		for(int i = 4, j = 1, k = 4; j <= nivel3.length; i++, j++) {   
			int cantidad = Integer.parseInt(cantidades[j-1]);
			
			Cell CellFor3 = row.createCell(k);
			CellFor3.setCellValue(nivel3[j-1]);
			CellFor3.setCellStyle(styles.get("title"));
			stylesSIS.setCellColor(CellFor3, colores[j-1]);   	
								
			if(cantidad > 1){
				sheetEsquema.addMergedRegion(new CellRangeAddress(3,3,k,k+(cantidad-1)));
			}
											
			//sheetEsquema.autoSizeColumn(i);
			k = k + cantidad;
		}

		for(int i = 0; i < 20; i++) {
			//sheetEsquema.autoSizeColumn(i);
		}
	}
	
	public static void Data(String datosList, int contador, int seccion, String color, int totalGrupo){

		String [] datos = datosList.split("¬");
		Row row = sheetEsquema.createRow(6+contador);
		double rowSubTotal = 0.0;
		
		// Datos SIS 
		if (seccion == 0){					
			for(int i = 0 ; i < datos.length; i++) { 
				// Escribe el número consecutivo
				if (i == 0){
					// Obtiene el consecutivo
					Double valor = Math.floor(contador/20) + 1;				

					// Crea la celda en la 1ra posición
					Cell cell = row.createCell(i);
					cell.setCellValue(valor.intValue());					
					cell.setCellStyle(styles.get("cell_normal_centered"));
				}	
				
				// Escribe el valor de las celdas siguientes
				Cell cell = row.createCell(i+1);
				cell.setCellStyle(styles.get("cell_normal_centered"));

				// cambia el color
				if (i == 2 || (totalGrupo == 1 && i > 2)) {
					stylesSIS.setCellColor(cell, color);
				}
							
				// Valida los primeros string
				if (i > 2) {
					// valor actual del dato
					double value = Double.parseDouble(datos[i]);
					
					// suma al subtotal de la fila
					rowSubTotal += value;					
					cell.setCellValue(value);
															  
				} else {					
					cell.setCellValue(datos[i]);									
				}			
			}
		
			// Agrupa cada 20 posiciones
			if ( (contador+1) % 20 == 0) {				
				sheetEsquema.addMergedRegion(new CellRangeAddress((6+contador)-19,6+contador,0,0));					
				sheetEsquema.addMergedRegion(new CellRangeAddress((6+contador)-19,6+contador,1,1));
				sheetEsquema.addMergedRegion(new CellRangeAddress((6+contador)-19,6+contador,2,2));
			}
			
			// Crea la celda para el subtotal
			Cell cell = row.createCell(datos.length + 1);
			cell.setCellValue(rowSubTotal);					
			cell.setCellStyle(styles.get("cell_normal_centered"));
		}
		else if (seccion == 1){					
			for(int i = 0 , j = 2; i < datos.length; i++, j++) { 							
				// Primer dato es la palabra "Total"
				if (i == 0){ 					
					Cell cell = row.createCell(i);
					cell.setCellValue(datos[i]);				
					cell.setCellStyle(styles.get("cell_b_centered"));
					continue;
				}
				
				// Escribe el valor de las celdas siguientes
				Cell cell = row.createCell(j);
				cell.setCellStyle(styles.get("cell_normal_centered"));	
				
				// cambia el color
				if (i == 1 || (totalGrupo == 1 && i > 1)) {
					stylesSIS.setCellColor(cell, color);
				}
				
				// Valida los primeros string
				if (i > 1) {
					// valor actual del dato
					double value = Double.parseDouble(datos[i]);
					
					// suma al subtotal de la fila
					rowSubTotal += value;
								
					cell.setCellValue(value);
				} else {
					cell.setCellValue(datos[i]);													
				}								
				
				// sheetEsquema.autoSizeColumn(i, true);	
			}
			
			// Agrupa cada 20 posiciones
			if ((contador+1) % 20 == 0) {
				sheetEsquema.addMergedRegion(new CellRangeAddress((6+contador)-19,6+contador,0,2));
			}
			
			// Crea la celda para el subtotal
			Cell cell = row.createCell(datos.length + 2);
			cell.setCellValue(rowSubTotal);					
			cell.setCellStyle(styles.get("cell_normal_centered"));
		}			
	} 

	public static void Finalize(){
		// Ahora guardaremos el archivo
		try {
			// Creamos el flujo de salida de datos, apuntando al archivo donde queremos almacenar el libro de Excel
			FileOutputStream fileOut = new FileOutputStream(archivo);

			// Almacenamos el libro de Excel via ese flujo de datos
			workBook.write(fileOut);

			// Cerramos el libro para concluir operaciones
			fileOut.close();

		} catch (FileNotFoundException ex) {
			System.out.println(ex.getMessage());
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
}
