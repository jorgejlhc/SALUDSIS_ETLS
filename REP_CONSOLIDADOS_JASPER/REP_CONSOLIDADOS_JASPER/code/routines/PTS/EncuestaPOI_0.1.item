package routines;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



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


public class EncuestaPOI {

	public static int totalPreguntas;
	public static int totalDatosBasicos;
	private static int rowCounterQ;
	private static int rowCounterA;
	
	public static String fileName;
	public static String pathStorage;
	private static File archivo;
	
	private static Workbook workBook;
	private static Sheet sheetAnswer;
	private static Sheet sheetQuestion;
	private static Row headerColumns;
	
	private static Map<String, CellStyle> styles;
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
    public static void helloExample(String message) {
        if (message == null) {
            message = "World"; //$NON-NLS-1$
        }
        System.out.println("Hello " + message + " !"); //$NON-NLS-1$ //$NON-NLS-2$
    }
        
    public static void initialize(){
    	initialize(pathStorage,fileName);
    }
        
    public static void initialize(String _path,String _name){
    	
    	totalPreguntas = 0;
    	rowCounterA = 8;
    	rowCounterQ = 2;
    	
    	boolean dir = new File(_path).mkdirs();
    	
    	// Creamos el archivo donde almacenaremos las respuestas de la encuesta 
        archivo = new File(_path + "\\" + _name + ".xlsx");
    	
        // Creamos el libro de trabajo de Excel formato OOXML
        workBook = new XSSFWorkbook(); 
        
        // Creamos los estilos 
        styles = stylesPOI.createStyles(workBook);
        
        // Creamos las hojas donde pondremos los datos
        sheetAnswer = workBook.createSheet("Encuesta");
        sheetQuestion = workBook.createSheet("Diccionario");
       
    }
    
   
	public static void createFilters(String _encuesta,String _esm, String _fuerza, String _fechaInicial, String _fechaFinal){
    	
				
		Row fInicialRow = sheetAnswer.createRow(1);
        fInicialRow.setHeightInPoints(20);
        Cell fInicialCell = fInicialRow.createCell(1);
        fInicialCell.setCellValue("FECHA INICIAL: " );
        fInicialCell.setCellStyle(styles.get("titlen"));        
        fInicialCell = fInicialRow.createCell(2);
        fInicialCell.setCellValue(_fechaInicial);
        fInicialCell.setCellStyle(styles.get("title"));        
        sheetAnswer.addMergedRegion(CellRangeAddress.valueOf("$C$2:$R$2"));
                
        Row fFinalRow = sheetAnswer.createRow(2);
        fFinalRow.setHeightInPoints(20);
        Cell fFinalCell = fFinalRow.createCell(1);
        fFinalCell.setCellValue("FECHA FINAL: " );
        fFinalCell.setCellStyle(styles.get("titlen"));
        fFinalCell = fFinalRow.createCell(2);
        fFinalCell.setCellValue(_fechaFinal);
        fFinalCell.setCellStyle(styles.get("title"));
        sheetAnswer.addMergedRegion(CellRangeAddress.valueOf("$C$3:$R$3"));
        
        Row esmRow = sheetAnswer.createRow(3);
        fInicialRow.setHeightInPoints(20);
        Cell esmCell = esmRow.createCell(1);
        esmCell.setCellValue("ESM DE ATENCIÓN: " );
        esmCell.setCellStyle(styles.get("titlen"));        
        esmCell = esmRow.createCell(2);
        esmCell.setCellValue(_esm);
        esmCell.setCellStyle(styles.get("title"));        
        sheetAnswer.addMergedRegion(CellRangeAddress.valueOf("$C$4:$R$4"));
                
        Row fuerzaRow = sheetAnswer.createRow(4);
        fuerzaRow.setHeightInPoints(20);
        Cell fuerzaCell = fuerzaRow.createCell(1);
        fuerzaCell.setCellValue("FUERZA: " );
        fuerzaCell.setCellStyle(styles.get("titlen"));
        fuerzaCell = fuerzaRow.createCell(2);
        fuerzaCell.setCellValue(_fuerza);
        fuerzaCell.setCellStyle(styles.get("title"));
        sheetAnswer.addMergedRegion(CellRangeAddress.valueOf("$C$5:$R$5"));
                
    	Row encuestaRow = sheetAnswer.createRow(5);
    	encuestaRow.setHeightInPoints(20);
        Cell encuestaCell = encuestaRow.createCell(1);
        encuestaCell.setCellValue("ENCUESTA: ");
        encuestaCell.setCellStyle(styles.get("titlen"));
        encuestaCell = encuestaRow.createCell(2);
        encuestaCell.setCellValue(_encuesta);
        encuestaCell.setCellStyle(styles.get("title"));
        sheetAnswer.addMergedRegion(CellRangeAddress.valueOf("$C$6:$R$6"));

    }
	
	public static void createHeader(){
		createHeader(totalPreguntas);
    }

	public static void createHeader(String _datosBasicos){
		
		if ( _datosBasicos == null ) {
			headerColumns = sheetAnswer.createRow(rowCounterA-1);
		} else {
			String [] colums = _datosBasicos.split("¬");
			
			totalDatosBasicos = colums.length;
			headerColumns = sheetAnswer.createRow(rowCounterA-1);
	        
	        // Create cells
	        for(int i = 1; i <= totalDatosBasicos; i++) {
	            Cell cell = headerColumns.createCell(i);
	            cell.setCellValue(colums[i-1]);
	            cell.setCellStyle(styles.get("cell_b_centered"));
	        }
        }
    }

	public static void createHeader(int _totalPreguntas ){
		// Create a Row
        //Row headerRow = repuestas.createRow(0);
               
        // Create cells
        for(int i = 0; i < _totalPreguntas; i++) {
            Cell cell = headerColumns.createCell(i+totalDatosBasicos);
            cell.setCellValue("P"+(i+1));
            cell.setCellStyle(styles.get("cell_b_centered"));
        }
        
        Cell cell = headerColumns.createCell(_totalPreguntas+totalDatosBasicos);
        cell.setCellValue("NIVEL DE SATISFACCIÓN");
        cell.setCellStyle(styles.get("cell_b_centered"));
        
        
        Row headerRow2 = sheetQuestion.createRow(1);
        Cell cell2 = headerRow2.createCell(1);
        cell2.setCellValue("NUMERO DE LA PREGUNTA");
        cell2.setCellStyle(styles.get("cell_b_centered"));
        
        Cell cell3 = headerRow2.createCell(2);
        cell3.setCellValue("PREGUNTA");
        cell3.setCellStyle(styles.get("cell_b_centered"));
        
    }

    
    public static void createAnswer(String _datosBasicos, String _respuestas, String _nSatisfaccion){
    	
    	String[] _dat = _datosBasicos.split("¬");
    	String[] _res = _respuestas.split("¬");
    	    	
        Row row = sheetAnswer.createRow(rowCounterA);
                   
        for(int i = 1; i <= _dat.length; i++) {        	 
       	 row.createCell(i).setCellValue(_dat[i-1]);
        }        
        
        for(int i = 0; i < _res.length; i++) {        	 
       	 row.createCell(i+totalDatosBasicos).setCellValue(_res[i]);
        }
        
        Cell cell1 = row.createCell(_res.length+totalDatosBasicos);
        cell1.setCellValue(_nSatisfaccion+"%");
        cell1.setCellStyle(styles.get("cell_normal_centered"));
		 
        rowCounterA++;
    }

    
    public static void createQuestion(String _pregunta){
    	String [] colums = _pregunta.split("¬");
		
		 Row row = sheetQuestion.createRow(rowCounterQ);
		 
		 
		 Cell cell1 = row.createCell(1);
		 Cell cell2 = row.createCell(2);
		 
		 cell1.setCellValue(colums[0]);
		 cell2.setCellValue(colums[1]);
		 
		 cell1.setCellStyle(styles.get("cell_normal_centered"));
		 cell2.setCellStyle(styles.get("cell_normal"));
		 
		 rowCounterQ++;
    }

    
    public static void Finalize(){
    	
    	for(int i = 1; i <= totalPreguntas+totalDatosBasicos+1; i++) {
    		sheetAnswer.autoSizeColumn(i,true);
        }
    	
    	sheetQuestion.autoSizeColumn(1,true);
    	sheetQuestion.autoSizeColumn(2,true);
    	
    	// Ahora guardaremos el archivo
        try {
            // Creamos el flujo de salida de datos, apuntando al archivo donde queremos almacenar el libro de Excel
            FileOutputStream fileOut = new FileOutputStream(archivo);
            
            // Almacenamos el libro de Excel via ese flujo de datos
            workBook.write(fileOut);
            
            // Cerramos el libro para concluir operaciones
            fileOut.close();
                    
            // Cerramos el libro para concluir operaciones
            //workbook.close();

            
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        	System.out.println(ex.getMessage());
        }
    }
    
}


