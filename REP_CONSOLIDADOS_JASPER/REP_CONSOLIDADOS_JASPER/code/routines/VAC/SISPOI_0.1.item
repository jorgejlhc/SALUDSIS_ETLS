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
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SISPOI {

	public static String fileName;
	public static String pathStorage;
	public static String tipoEsquema;
	private static File archivo;	
	private static Workbook workBook;
	private static Sheet sheetEsquema;
	private static Row deptoRow;
	private static Row añoRow;
	private static Row mesRow;
	private  Row mcpioRow;
	private  Row mcpioRow2;
	private static Row itemRow;
	private static String departamento;
	private static String codDepartamento;
	private static String anio;
	private static String mes;
	private static String nivel1;
	private Cell catCell;
	public static int totalDatosBasicos;
	private static Row headerColumns;
	private static Sheet sheetAnswer;
	private static int rowCounterA;
	//private static Row headerColumns;

	private static Map<String, CellStyle> styles;

	public static void initialize(){
		initialize(pathStorage,fileName,tipoEsquema);
	}

	public static void initialize(String _path,String _name, String _esquema){

		// Creamos el directorio 
		boolean dir = new File(_path).mkdirs();

		System.out.println("mkdirs: " + dir);
		System.out.println("_path: " + _path);
		System.out.println("_name: " + _name);
		System.out.println("_esquema: " + _esquema);

		// Creamos el archivo donde almacenaremos las respuestas de la encuesta 
		archivo = new File(_path + "\\" + _name + ".xlsx");

		// Creamos el libro de trabajo de Excel formato OOXML
		workBook = new XSSFWorkbook(); 

		// Creamos los estilos 
		//styles = stylesSIS.createStyles(workBook);**********************************************************************************

		// Creamos las hojas donde pondremos los datos
		sheetEsquema = workBook.createSheet("datos");                             
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
		//stylesSIS.setCellColor(deptoCell, "#F0768A");**********************************************************************************		
		sheetEsquema.addMergedRegion(CellRangeAddress.valueOf("$A$1:$C$1"));

		
		Cell deptoCellValue = deptoRow.createCell(3);
		deptoCellValue.setCellValue(departamento );
		sheetEsquema.addMergedRegion(CellRangeAddress.valueOf("$D$1:$D$1"));
		//fInicialCell.setCellStyle(styles.get("titlen"));    


		Cell cdeptoCell = deptoRow.createCell(4);
		cdeptoCell.setCellValue("CODIGO DEPARTAMENTO:" );
		cdeptoCell.setCellStyle(styles.get("header_1"));    
		sheetEsquema.addMergedRegion(CellRangeAddress.valueOf("$E$1:$G$1"));


		Cell cdeptoCellValue = deptoRow.createCell(7);
		cdeptoCellValue.setCellValue(codDepartamento );
		//fInicialCell.setCellStyle(styles.get("titlen"));    


		/////////////////////////////////////////
		//New Row
		/////////////////////////////////////////
		Row añoRow = sheetEsquema.createRow(1);
		añoRow.setHeightInPoints(20);

		Cell añoCell = añoRow.createCell(0);
		añoCell.setCellValue("AÑO:" );
		añoCell.setCellStyle(styles.get("header_1"));       
		sheetEsquema.addMergedRegion(CellRangeAddress.valueOf("$A$2:$C$2"));


		Cell añoCellValue = añoRow.createCell(3);
		añoCellValue.setCellValue(anio);
		//fInicialCell.setCellStyle(styles.get("titlen"));    
		sheetEsquema.addMergedRegion(CellRangeAddress.valueOf("$D$2:$D$2"));

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
		sheetEsquema.addMergedRegion(CellRangeAddress.valueOf("$D$3:$D$3"));  

	}

	public static void Header_Dinamic(String nivel1,String color){


		String [] colums = nivel1.split("¬");
		String [] colors = color.split("¬");

		Row row = sheetEsquema.createRow(5);
		row.setHeightInPoints(35);

		Cell itemCell = row.createCell(0);
		itemCell.setCellValue("Nº Cons" );
		itemCell.setCellStyle(styles.get("title")); 

		//     itemCell.setCellStyle(styles.get("header_2")); 

		Cell codmpioCell = row.createCell(1);
		codmpioCell.setCellValue("COD DANE\nMPIO" );
		codmpioCell.setCellStyle(styles.get("title")); 

		//    codmpioCell.setCellStyle(styles.get("header_1"));

		Cell nommpioCell = row.createCell(2);
		nommpioCell.setCellValue("NOMBRE MUNICIPIO/\nIPS" );
		nommpioCell.setCellStyle(styles.get("title"));

		//     nommpioCell.setCellStyle(styles.get("header_1"));



		for(int i = 4, j= 1; j <= colums.length; i++, j++) {  
			Cell CellFor = row.createCell(i);
			CellFor.setCellValue(colums[j-1]);
			//stylesSIS.setCellColor(CellFor, colors[j-1]);**********************************************************************************
			//row.createCell(i).setCellValue(colums[j-1]);
			sheetEsquema.autoSizeColumn(i);
			

		}   


	}

	public static void Header_Dinamic_nivel2(String nivel1, String nivel2, String cantidades, String color){

		String [] nivelInf = nivel1.split("¬");
		String [] nivel = nivel2.split("¬");
		String [] positions = cantidades.split("¬");
		String [] colors = color.split("¬");
		
		Row row = sheetEsquema.createRow(4);
		row.setHeightInPoints(35);

		for(int i = 4, j = 1, k = 4, l = 1; j <= positions.length; i++, j++) {   
			int po2 = Integer.parseInt(positions[j-1]);
			Cell CellFor2 = row.createCell(k);
			CellFor2.setCellValue(nivel[j-1]);
			//stylesSIS.setCellColor(CellFor2, colors[j-1]);**********************************************************************************

			if (nivel[j-1].equals(nivelInf[l-1])){
				sheetEsquema.addMergedRegion(new CellRangeAddress(4,5,k,k+(po2-1)));				
			}
			else {
				sheetEsquema.addMergedRegion(new CellRangeAddress(4,4,k,k+(po2-1)));				
			}

			k= k+po2;
			l=l+po2;
			
			sheetEsquema.autoSizeColumn(j-1);
		}   
	}

	public static void Header_Dinamic_nivel3(String nivel3, String cantidades, String color){
		String [] nivel = nivel3.split("¬");
		String [] positions = cantidades.split("¬");
		String [] colors = color.split("¬");
		
		Row row = sheetEsquema.createRow(3);
		row.setHeightInPoints(35);
		Cell mcpioCell = row.createCell(0);
		mcpioCell.setCellValue("MUNICIPIO" );   
		mcpioCell.setCellStyle(styles.get("title"));

		sheetEsquema.addMergedRegion(new CellRangeAddress(3,4,0,2));

		Cell catCell = row.createCell(3);
		sheetEsquema.addMergedRegion(CellRangeAddress.valueOf("$D$4:$D$6"));
		catCell.setCellValue("REGIMEN / \nGRUPO ETNICO" );
		catCell.setCellStyle(styles.get("title"));

		for(int i = 4, j= 1, k= 4; j <= positions.length; i++, j++) {   
			int po2 = Integer.parseInt(positions[j-1]);
			
			Cell CellFor3 = row.createCell(k);
			CellFor3.setCellValue(nivel[j-1]);
			CellFor3.setCellStyle(styles.get("cell_b_centered"));
			//stylesSIS.setCellColor(CellFor3, colors[j-1]);**********************************************************************************   	
			
			sheetEsquema.addMergedRegion(new CellRangeAddress(3,3,k,k+(po2-1)));
			sheetEsquema.autoSizeColumn(i);
			k = k + po2;
		}

		for(int i = 0; i < 20; i++) {
			sheetEsquema.autoSizeColumn(i);
		}
	}
	
	public static void Data(String listaDatos, int contador, int seccion ){

		String [] datos = listaDatos.split("¬");
		Row row = sheetEsquema.createRow(6+contador);
		
		// Datos SIS 
		if (seccion == 1){
			for(int i = 0 ; i <= datos.length-1; i++) { 
				// Escribe el número consecutivo
				if (i == 0){
					// Obtiene el consecutivo
					Double valor = (Math.floor(contador/20)+1);				

					// Crea la celda en la 1ra posición
					Cell cell = row.createCell(i);
					cell.setCellValue(valor.intValue());
					cell.setCellStyle(styles.get("cell_normal"));
				}
				
				// Escribe el valor de las celas siguientes
				Cell cell = row.createCell(i+1);
				cell.setCellValue(datos[i]);
				cell.setCellStyle(styles.get("cell_normal"));
				
				// Agrupa cada 20 posiciones
				if ( (contador+1) % 20 == 0) {
					sheetEsquema.addMergedRegion(new CellRangeAddress((6+contador)-19,6+contador,0,0));
					sheetEsquema.addMergedRegion(new CellRangeAddress((6+contador)-19,6+contador,1,1));
					sheetEsquema.addMergedRegion(new CellRangeAddress((6+contador)-19,6+contador,2,2));
				}			
			}
		}
		else 
		{
			// Datos TOTAL
			for(int i = 0 , j = 2; i <= datos.length-1; i++, j++) { 
				// Primer dato es "Total"
				if ( i==0 ){ 					
					Cell cell = row.createCell(i);
					cell.setCellValue(datos[i]);
					cell.setCellStyle(styles.get("cell_b_centered"));
					continue;
				}
				
				// Desde la 3ra posición
				row.createCell(j).setCellValue(datos[i]);
				sheetEsquema.autoSizeColumn(i);
				
				// Agrupa cada 20 posiciones
				if ( (contador+1) % 20 == 0) {
					sheetEsquema.addMergedRegion(new CellRangeAddress((6+contador)-19,6+contador,0,2));
				}							
			}
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
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
}
