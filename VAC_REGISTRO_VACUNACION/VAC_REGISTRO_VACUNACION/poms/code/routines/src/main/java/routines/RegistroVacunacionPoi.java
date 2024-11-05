package routines;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class RegistroVacunacionPoi {

	private final static int FIRST_ROW = 0;
	private final static int FIRST_COLUMN = 0;
	private final static String COLOR_PAI = "#D3D3D3";
	private final static String COLOR_NO_PAI = "#6495ED";
	private final static String COLOR_ACTUALIZACION = "#ADD8E6";
	private final static String COLOR_NO_ACTUALIZACION = "#DDA0DD";
	private static final String[] VACUNA_PARAMS = new String[] { "DOSIS",
		"LOTE VACUNA", "CALIBRE JERINGA", "LOTE JERINGA", "LOTE DILUYENTE"};
	private static final int VACUNA_PARAMS_LENGHT = VACUNA_PARAMS.length;

	private static int nextRow = 0;
	private static int nextCol = 0;
	private static File archivo;
	private static Workbook workBook;
	private static Sheet sheetEsquema;
	private static Map<String, CellStyle> styles;

	public static void initialize(String path, String name) {
		// Creamos el archivo donde almacenaremos las respuestas de la encuesta
		archivo = new File(path + "//" + name);

		// Creamos el libro de trabajo de Excel formato OOXML
		workBook = new XSSFWorkbook();

		// Creamos los estilos
		styles = StylesRegistroVacunacion.createStyles(workBook);

		// Creamos las hojas donde pondremos los datos
		sheetEsquema = workBook.createSheet("datos");		
	}

	public static void crearFiltros(String nombreReporte, String fuerza,
			String establecimiento, String tipoVacuna, String esActualizacion,
			String fechaInicial, String fechaFinal, String usuario, boolean esWebService) {

		System.out.println("Filtros del reporte");

		int row = FIRST_ROW, col = FIRST_COLUMN;

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
		String fechaGeneracion = sdf.format(new Date());

		Row dummyRow = sheetEsquema.createRow(row);
		Cell dummyCell = dummyRow.createCell(col);
		dummyCell.setCellValue(nombreReporte);
		dummyCell.setCellStyle(styles.get("filtros"));
		row += 2;

		dummyRow = sheetEsquema.createRow(row);
		dummyCell = dummyRow.createCell(col);
		dummyCell.setCellValue("Fecha y hora de generacón: " + fechaGeneracion);
		dummyCell.setCellStyle(styles.get("filtros"));
		row += 2;

		dummyRow = sheetEsquema.createRow(row);
		dummyCell = dummyRow.createCell(col);
		dummyCell.setCellValue("Filtros:");
		dummyCell.setCellStyle(styles.get("filtros"));
		row++;

		dummyRow = sheetEsquema.createRow(row);
		dummyCell = dummyRow.createCell(col);
		dummyCell.setCellValue("Fuerza: "
				+ (!Utils.empty(fuerza) ? fuerza : ""));
		dummyCell.setCellStyle(styles.get("filtros"));
		row++;

		dummyRow = sheetEsquema.createRow(row);
		dummyCell = dummyRow.createCell(col);
		dummyCell.setCellValue("ESM: "
				+ (!Utils.empty(establecimiento) ? establecimiento : ""));
		dummyCell.setCellStyle(styles.get("filtros"));
		row++;

		dummyRow = sheetEsquema.createRow(row);
		dummyCell = dummyRow.createCell(col);
		dummyCell.setCellValue("Tipo de esquema: "
				+ (!Utils.empty(tipoVacuna) ? tipoVacuna : ""));
		dummyCell.setCellStyle(styles.get("filtros"));
		row++;

		dummyRow = sheetEsquema.createRow(row);
		dummyCell = dummyRow.createCell(col);
		
		
		String[] listTipoRegistro = esActualizacion.split(",");
		
		if (listTipoRegistro.length > 1) {
			dummyCell.setCellValue("Tipo de registro: Vacunas aplicadas y actualizadas");
		} else if (listTipoRegistro.length == 1){
			dummyCell.setCellValue("Tipo de registro: " + (listTipoRegistro[0].equals("1") ? "Vacunas actualizadas" :  "Vacunas aplicadas"));				
		}
		
		dummyCell.setCellStyle(styles.get("filtros"));
		row++;
		
		if (esWebService){
			dummyRow = sheetEsquema.createRow(row);
			dummyCell = dummyRow.createCell(col);
			dummyCell.setCellValue("Fecha: " + fechaInicial);
			dummyCell.setCellStyle(styles.get("filtros"));
			row++;
		} else{
			dummyRow = sheetEsquema.createRow(row);
			dummyCell = dummyRow.createCell(col);
			dummyCell.setCellValue("Fecha inicial: " + fechaInicial);
			dummyCell.setCellStyle(styles.get("filtros"));
			row++;

			dummyRow = sheetEsquema.createRow(row);
			dummyCell = dummyRow.createCell(col);
			dummyCell.setCellValue("Fecha final: " + fechaFinal);
			dummyCell.setCellStyle(styles.get("filtros"));
			row++;
		}
		
		dummyRow = sheetEsquema.createRow(row);
		dummyCell = dummyRow.createCell(col);
		dummyCell.setCellValue("Usuario solicita: "
				+ (!Utils.empty(usuario) ? usuario : ""));
		dummyCell.setCellStyle(styles.get("filtros"));
		row++;
		
		// Convención colores
		dummyRow = sheetEsquema.createRow(row);
		dummyCell = dummyRow.createCell(col + 9);
		dummyCell.setCellValue("CONVENCIONES");
		dummyCell.setCellStyle(styles.get("title"));
		dummyCell = dummyRow.createCell(col + 10);		
		dummyCell.setCellStyle(styles.get("title"));		
		sheetEsquema.addMergedRegion(new CellRangeAddress(row,row,col + 9,col + 10));
		row++;
						
		dummyRow = sheetEsquema.createRow(row);
		dummyCell = dummyRow.createCell(col + 9);
		dummyCell.setCellValue("ACTUALIZACIÓN");
		dummyCell.setCellStyle(styles.get("title"));
		StylesRegistroVacunacion.setCellColor(dummyCell, COLOR_ACTUALIZACION);
		
		dummyCell = dummyRow.createCell(col + 10);
		dummyCell.setCellValue("APLICACIÓN");
		dummyCell.setCellStyle(styles.get("title"));
		StylesRegistroVacunacion.setCellColor(dummyCell, COLOR_NO_ACTUALIZACION);
		
		row += 4;
		nextRow = row;
		nextCol = col;
	}

	public static void headerStatic() {
		System.out.println("Header estático");

		int row = nextRow, col = nextCol;

		Row headerRow = sheetEsquema.createRow(row - 1);
		Cell headerCell = headerRow.createCell(col);
		headerCell.setCellValue("IDENTIFICACIÓN DEL VACUNADO");
		headerCell.setCellStyle(styles.get("header_1"));

		Row mainRow = sheetEsquema.createRow(row);
		mainRow.setHeightInPoints(200);

		Cell dummyCell = mainRow.createCell(col);
		dummyCell.setCellValue("CONSECUTIVO");
		dummyCell.setCellStyle(styles.get("title_rotate"));
		sheetEsquema.setColumnWidth(col, Utils.pixel2WidthUnits(40));
		col++;

		dummyCell = mainRow.createCell(col);
		dummyCell.setCellValue("FECHA REGISTRO");
		dummyCell.setCellStyle(styles.get("title"));
		sheetEsquema.setColumnWidth(col, Utils.pixel2WidthUnits(90));
		col++;
		
		dummyCell = mainRow.createCell(col);
		dummyCell.setCellValue("FECHA APLICACIÓN");
		dummyCell.setCellStyle(styles.get("title"));
		sheetEsquema.setColumnWidth(col, Utils.pixel2WidthUnits(90));
		col++;

		dummyCell = mainRow.createCell(col);
		dummyCell.setCellValue("TIPO DE DOCUMENTO");
		dummyCell.setCellStyle(styles.get("title"));
		sheetEsquema.setColumnWidth(col, Utils.pixel2WidthUnits(110));
		col++;

		dummyCell = mainRow.createCell(col);
		dummyCell.setCellValue("NÚMERO DE DOCUMENTO");
		dummyCell.setCellStyle(styles.get("title"));
		sheetEsquema.setColumnWidth(col, Utils.pixel2WidthUnits(95));
		col++;

		dummyCell = mainRow.createCell(col);
		dummyCell.setCellValue("FECHA DE NACIMIENTO");
		dummyCell.setCellStyle(styles.get("title"));
		sheetEsquema.setColumnWidth(col, Utils.pixel2WidthUnits(90));
		col++;

		dummyCell = mainRow.createCell(col);
		dummyCell.setCellValue("TIPO EDAD");
		dummyCell.setCellStyle(styles.get("title"));
		sheetEsquema.setColumnWidth(col, Utils.pixel2WidthUnits(100));
		col++;

		dummyCell = mainRow.createCell(col);
		dummyCell.setCellValue("EDAD");
		dummyCell.setCellStyle(styles.get("title"));
		sheetEsquema.setColumnWidth(col, Utils.pixel2WidthUnits(40));
		col++;

		dummyCell = mainRow.createCell(col);
		dummyCell.setCellValue("SEXO");
		dummyCell.setCellStyle(styles.get("title"));
		sheetEsquema.setColumnWidth(col, Utils.pixel2WidthUnits(75));
		col++;

		dummyCell = mainRow.createCell(col);
		dummyCell.setCellValue("PRIMER NOMBRE");
		dummyCell.setCellStyle(styles.get("title"));
		sheetEsquema.setColumnWidth(col, Utils.pixel2WidthUnits(100));
		col++;

		dummyCell = mainRow.createCell(col);
		dummyCell.setCellValue("SEGUNDO NOMBRE");
		dummyCell.setCellStyle(styles.get("title"));
		sheetEsquema.setColumnWidth(col, Utils.pixel2WidthUnits(100));
		col++;

		dummyCell = mainRow.createCell(col);
		dummyCell.setCellValue("PRIMER APELLIDO");
		dummyCell.setCellStyle(styles.get("title"));
		sheetEsquema.setColumnWidth(col, Utils.pixel2WidthUnits(100));
		col++;

		dummyCell = mainRow.createCell(col);
		dummyCell.setCellValue("SEGUNDO APELLIDO");
		dummyCell.setCellStyle(styles.get("title"));
		sheetEsquema.setColumnWidth(col, Utils.pixel2WidthUnits(100));
		col++;

		dummyCell = mainRow.createCell(col);
		dummyCell.setCellValue("RÉGIMEN");
		dummyCell.setCellStyle(styles.get("title"));
		sheetEsquema.setColumnWidth(col, Utils.pixel2WidthUnits(100));
		col++;
		
		dummyCell = mainRow.createCell(col);
		dummyCell.setCellValue("ASEGURADORA");
		dummyCell.setCellStyle(styles.get("title"));
		sheetEsquema.setColumnWidth(col, Utils.pixel2WidthUnits(350));
		col++;
		
		dummyCell = mainRow.createCell(col);
		dummyCell.setCellValue("GRADO");
		dummyCell.setCellStyle(styles.get("title"));
		sheetEsquema.setColumnWidth(col, Utils.pixel2WidthUnits(100));
		col++;

		dummyCell = mainRow.createCell(col);
		dummyCell.setCellValue("TIPO AFILIACIÓN");
		dummyCell.setCellStyle(styles.get("title"));
		sheetEsquema.setColumnWidth(col, Utils.pixel2WidthUnits(100));
		col++;

		dummyCell = mainRow.createCell(col);
		dummyCell.setCellValue("FUERZA ADSCRIPCIÓN");
		dummyCell.setCellStyle(styles.get("title"));
		sheetEsquema.setColumnWidth(col, Utils.pixel2WidthUnits(230));
		col++;

		dummyCell = mainRow.createCell(col);
		dummyCell.setCellValue("ESM ADSCRIPCIÓN");
		dummyCell.setCellStyle(styles.get("title"));
		sheetEsquema.setColumnWidth(col, Utils.pixel2WidthUnits(350));
		col++;

		dummyCell = mainRow.createCell(col);
		dummyCell.setCellValue("FUERZA DEL ESM QUE REGISTRA");
		dummyCell.setCellStyle(styles.get("title"));
		sheetEsquema.setColumnWidth(col, Utils.pixel2WidthUnits(230));
		col++;
		
		dummyCell = mainRow.createCell(col);
		dummyCell.setCellValue("ESM QUE REGISTRA");
		dummyCell.setCellStyle(styles.get("title"));
		sheetEsquema.setColumnWidth(col, Utils.pixel2WidthUnits(350));
		col++;
		
		dummyCell = mainRow.createCell(col);
		dummyCell.setCellValue("USUARIO QUE REGISTRA");
		dummyCell.setCellStyle(styles.get("title"));
		sheetEsquema.setColumnWidth(col, Utils.pixel2WidthUnits(250));
		col++;
		
		dummyCell = mainRow.createCell(col);
		dummyCell.setCellValue("PUNTO VACUNADOR");
		dummyCell.setCellStyle(styles.get("title"));
		sheetEsquema.setColumnWidth(col, Utils.pixel2WidthUnits(350));
		col++;

		dummyCell = mainRow.createCell(col);
		dummyCell.setCellValue("NOMBRE VACUNADOR");
		dummyCell.setCellStyle(styles.get("title"));
		sheetEsquema.setColumnWidth(col, Utils.pixel2WidthUnits(250));
		col++;

		dummyCell = mainRow.createCell(col);
		dummyCell.setCellValue("DEPARTAMENTO RESIDENCIA");
		dummyCell.setCellStyle(styles.get("title"));
		sheetEsquema.setColumnWidth(col, Utils.pixel2WidthUnits(150));
		col++;

		dummyCell = mainRow.createCell(col);
		dummyCell.setCellValue("MUNICIPIO RESIDENCIA");
		dummyCell.setCellStyle(styles.get("title"));
		sheetEsquema.setColumnWidth(col, Utils.pixel2WidthUnits(100));
		col++;

		dummyCell = mainRow.createCell(col);
		dummyCell.setCellValue("BARRIO");
		dummyCell.setCellStyle(styles.get("title"));
		sheetEsquema.setColumnWidth(col, Utils.pixel2WidthUnits(100));
		col++;

		dummyCell = mainRow.createCell(col);
		dummyCell.setCellValue("DIRECCIÓN");
		dummyCell.setCellStyle(styles.get("title"));
		sheetEsquema.setColumnWidth(col, Utils.pixel2WidthUnits(150));
		col++;

		dummyCell = mainRow.createCell(col);
		dummyCell.setCellValue("TELEFONO");
		dummyCell.setCellStyle(styles.get("title"));
		sheetEsquema.setColumnWidth(col, Utils.pixel2WidthUnits(100));
		col++;

		dummyCell = mainRow.createCell(col);
		dummyCell.setCellValue("GRUPO ÉTNICO");
		dummyCell.setCellStyle(styles.get("title"));
		sheetEsquema.setColumnWidth(col, Utils.pixel2WidthUnits(100));
		col++;
		
		dummyCell = mainRow.createCell(col);
		dummyCell.setCellValue("DESPLAZADA");
		dummyCell.setCellStyle(styles.get("title"));
		sheetEsquema.setColumnWidth(col, Utils.pixel2WidthUnits(100));
		col++;
		
		dummyCell = mainRow.createCell(col);
		dummyCell.setCellValue("DISCAPACITADA");
		dummyCell.setCellStyle(styles.get("title"));
		sheetEsquema.setColumnWidth(col, Utils.pixel2WidthUnits(100));
		col++;
		
		dummyCell = mainRow.createCell(col);
		dummyCell.setCellValue("VÍCTIMA DEL CONFLICTO ARMADO");
		dummyCell.setCellStyle(styles.get("title"));
		sheetEsquema.setColumnWidth(col, Utils.pixel2WidthUnits(120));
		col++;
		
		dummyCell = mainRow.createCell(col);
		dummyCell.setCellValue("ZONA VEREDAL (ZVTN)");
		dummyCell.setCellStyle(styles.get("title"));
		sheetEsquema.setColumnWidth(col, Utils.pixel2WidthUnits(100));
		col++;
		
		dummyCell = mainRow.createCell(col);
		dummyCell.setCellValue("PARENTESCO CON EL COTIZANTE");
		dummyCell.setCellStyle(styles.get("title"));
		sheetEsquema.setColumnWidth(col, Utils.pixel2WidthUnits(100));
		col++;

		dummyCell = mainRow.createCell(col);
		dummyCell.setCellValue("TIPO DOCUMENTO COTIZANTE");
		dummyCell.setCellStyle(styles.get("title"));
		sheetEsquema.setColumnWidth(col, Utils.pixel2WidthUnits(110));
		col++;

		dummyCell = mainRow.createCell(col);
		dummyCell.setCellValue("NÚMERO DOCUMENTO COTIZANTE");
		dummyCell.setCellStyle(styles.get("title"));
		sheetEsquema.setColumnWidth(col, Utils.pixel2WidthUnits(95));
		col++;

		dummyCell = mainRow.createCell(col);
		dummyCell.setCellValue("PRIMER NOMBRE COTIZANTE");
		dummyCell.setCellStyle(styles.get("title"));
		sheetEsquema.setColumnWidth(col, Utils.pixel2WidthUnits(100));
		col++;

		dummyCell = mainRow.createCell(col);
		dummyCell.setCellValue("SEGUNDO NOMBRE COTIZANTE");
		dummyCell.setCellStyle(styles.get("title"));
		sheetEsquema.setColumnWidth(col, Utils.pixel2WidthUnits(100));
		col++;

		dummyCell = mainRow.createCell(col);
		dummyCell.setCellValue("PRIMER APELLIDO COTIZANTE");
		dummyCell.setCellStyle(styles.get("title"));
		sheetEsquema.setColumnWidth(col, Utils.pixel2WidthUnits(100));
		col++;

		dummyCell = mainRow.createCell(col);
		dummyCell.setCellValue("SEGUNDO APELLIDO COTIZANTE");
		dummyCell.setCellStyle(styles.get("title"));
		sheetEsquema.setColumnWidth(col, Utils.pixel2WidthUnits(100));
		col++;

		dummyCell = mainRow.createCell(col);
		dummyCell.setCellValue("GRADO COTIZANTE");
		dummyCell.setCellStyle(styles.get("title"));
		sheetEsquema.setColumnWidth(col, Utils.pixel2WidthUnits(100));
		col++;

		dummyCell = mainRow.createCell(col);
		dummyCell.setCellValue("TIPO DOCUMENTO CUIDADOR");
		dummyCell.setCellStyle(styles.get("title"));
		sheetEsquema.setColumnWidth(col, Utils.pixel2WidthUnits(110));
		col++;

		dummyCell = mainRow.createCell(col);
		dummyCell.setCellValue("NÚMERO DOCUMENTO CUIDADOR");
		dummyCell.setCellStyle(styles.get("title"));
		sheetEsquema.setColumnWidth(col, Utils.pixel2WidthUnits(95));
		col++;

		dummyCell = mainRow.createCell(col);
		dummyCell.setCellValue("PRIMER NOMBRE CUIDADOR");
		dummyCell.setCellStyle(styles.get("title"));
		sheetEsquema.setColumnWidth(col, Utils.pixel2WidthUnits(100));
		col++;

		dummyCell = mainRow.createCell(col);
		dummyCell.setCellValue("SEGUNDO NOMBRE CUIDADOR");
		dummyCell.setCellStyle(styles.get("title"));
		sheetEsquema.setColumnWidth(col, Utils.pixel2WidthUnits(100));
		col++;

		dummyCell = mainRow.createCell(col);
		dummyCell.setCellValue("PRIMER APELLIDO CUIDADOR");
		dummyCell.setCellStyle(styles.get("title"));
		sheetEsquema.setColumnWidth(col, Utils.pixel2WidthUnits(100));
		col++;

		dummyCell = mainRow.createCell(col);
		dummyCell.setCellValue("SEGUNDO APELLIDO CUIDADOR");
		dummyCell.setCellStyle(styles.get("title"));
		sheetEsquema.setColumnWidth(col, Utils.pixel2WidthUnits(100));
		col++;
		
		dummyCell = mainRow.createCell(col);
		dummyCell.setCellValue("PARENTESCO CUIDADOR");
		dummyCell.setCellStyle(styles.get("title"));
		sheetEsquema.setColumnWidth(col, Utils.pixel2WidthUnits(100));
		col++;
		
		dummyCell = mainRow.createCell(col);
		dummyCell.setCellValue("TELEFONO CUIDADOR");
		dummyCell.setCellStyle(styles.get("title"));
		sheetEsquema.setColumnWidth(col, Utils.pixel2WidthUnits(100));
		col++;
		
		dummyCell = mainRow.createCell(col);
		dummyCell.setCellValue("CORREO CUIDADOR");
		dummyCell.setCellStyle(styles.get("title"));
		sheetEsquema.setColumnWidth(col, Utils.pixel2WidthUnits(300));
		col++;

		sheetEsquema.addMergedRegion(new CellRangeAddress(row - 1, row - 1,
				nextCol, col - 1));

		nextRow = row;
		nextCol = col;
	}

	public static void headerDynamic(List<String> listaVacunas,
			List<String> listaEsquemas) {
		System.out.println("Header dinámico");

		int startRow = nextRow;
		int startCol = nextCol;

		Row row1 = sheetEsquema.createRow(startRow - 3); // ESQUEMA DE VACUNACIÓN
		Row row2 = sheetEsquema.createRow(startRow - 2); // [PAI, NO PAI]
		Row row3 = sheetEsquema.getRow(startRow - 1); // VACUNAS..
		Row row4 = sheetEsquema.getRow(startRow); // [DOSIS, LOTE BIOLÓGICO, CALIBRE JERINGA, LOTE JERINGA]

		// ESQUEMA DE VACUNACIÓN
		Cell cell1 = row1.createCell(startCol);
		cell1.setCellValue("ESQUEMA DE VACUNACIÓN");
		cell1.setCellStyle(styles.get("header_1"));
		sheetEsquema.addMergedRegion(new CellRangeAddress(startRow - 3,
				startRow - 3, startCol, startCol + listaVacunas.size()
				* VACUNA_PARAMS_LENGHT));

		// contadores para el tipo de vacuna
		int paiCount = 0;
		int noPaiCount = 0;

		for (int i = 0, col = startCol; i < listaVacunas.size(); i++, col += VACUNA_PARAMS_LENGHT) {
			String vacuna = listaVacunas.get(i);
			String esquema = listaEsquemas.get(i);

			Cell cell2 = row2.createCell(col);
			Cell cell3 = row3.createCell(col);
			Cell cell4 = row4.createCell(col);
			Cell cell5 = row4.createCell(col + 1);
			Cell cell6 = row4.createCell(col + 2);
			Cell cell7 = row4.createCell(col + 3);
			Cell cell8 = row4.createCell(col + 4);

			cell2.setCellValue(esquema);
			cell3.setCellValue(vacuna);

			cell4.setCellValue(VACUNA_PARAMS[0]);
			cell5.setCellValue(VACUNA_PARAMS[1]);
			cell6.setCellValue(VACUNA_PARAMS[2]);
			cell7.setCellValue(VACUNA_PARAMS[3]);
			cell8.setCellValue(VACUNA_PARAMS[4]);

			cell2.setCellStyle(styles.get("header_2"));
			cell3.setCellStyle(styles.get("header_2"));
			cell4.setCellStyle(styles.get("title_rotate"));
			cell5.setCellStyle(styles.get("title_rotate"));
			cell6.setCellStyle(styles.get("title_rotate"));
			cell7.setCellStyle(styles.get("title_rotate"));
			cell8.setCellStyle(styles.get("title_rotate"));

			if (esquema.equals("PAI")) {
				StylesRegistroVacunacion.setCellColor(cell2, COLOR_PAI);
				StylesRegistroVacunacion.setCellColor(cell3, COLOR_PAI);
				StylesRegistroVacunacion.setCellColor(cell4, COLOR_PAI);
				StylesRegistroVacunacion.setCellColor(cell5, COLOR_PAI);
				StylesRegistroVacunacion.setCellColor(cell6, COLOR_PAI);
				StylesRegistroVacunacion.setCellColor(cell7, COLOR_PAI);
				StylesRegistroVacunacion.setCellColor(cell8, COLOR_PAI);
				paiCount++;

			} else {
				StylesRegistroVacunacion.setCellColor(cell2, COLOR_NO_PAI);
				StylesRegistroVacunacion.setCellColor(cell3, COLOR_NO_PAI);
				StylesRegistroVacunacion.setCellColor(cell4, COLOR_NO_PAI);
				StylesRegistroVacunacion.setCellColor(cell5, COLOR_NO_PAI);
				StylesRegistroVacunacion.setCellColor(cell6, COLOR_NO_PAI);
				StylesRegistroVacunacion.setCellColor(cell7, COLOR_NO_PAI);
				StylesRegistroVacunacion.setCellColor(cell8, COLOR_NO_PAI);
				noPaiCount++;
			}

			// Combina las vacunas
			sheetEsquema.addMergedRegion(new CellRangeAddress(startRow - 1, startRow - 1, col, col + 4));

			sheetEsquema.setColumnWidth(col, Utils.pixel2WidthUnits(85));
			sheetEsquema.setColumnWidth(col + 1, Utils.pixel2WidthUnits(85));
			sheetEsquema.setColumnWidth(col + 2, Utils.pixel2WidthUnits(85));
			sheetEsquema.setColumnWidth(col + 3, Utils.pixel2WidthUnits(85));
			sheetEsquema.setColumnWidth(col + 4, Utils.pixel2WidthUnits(85));
		}

		// [PAI, NO PAI]
		sheetEsquema.addMergedRegion(new CellRangeAddress(startRow - 2,
				startRow - 2, startCol, startCol + paiCount
				* VACUNA_PARAMS_LENGHT - 1));
		sheetEsquema.addMergedRegion(new CellRangeAddress(startRow - 2,
				startRow - 2, startCol + paiCount * VACUNA_PARAMS_LENGHT,
				startCol + paiCount * VACUNA_PARAMS_LENGHT + noPaiCount
				* VACUNA_PARAMS_LENGHT - 1));
	}

	public static void personaData(String datos, int row) {
		String[] listaDatos = datos.split("\\|");
		Row dataRow = sheetEsquema.createRow(nextRow + row);

		for (int i = 0, col = FIRST_COLUMN; i < listaDatos.length; i++, col++) {
			String string = listaDatos[i].trim();
			String dato  =  string.equals("null") ? "" : string;
			
			//System.out.println(dato);
			Cell cell = dataRow.createCell(col);
			cell.setCellValue(dato);
			cell.setCellStyle(styles.get("cell"));
		}
		
		
	}

	public static void vacunasData(String datos, int row, int col, int isUpdate) {
		String[] listaDatos = datos.split("\\|");

		Row dataRow = sheetEsquema.getRow(nextRow + row);
		int initalCol = nextCol + col * VACUNA_PARAMS_LENGHT;

		for (int i = 0, column = initalCol; i < listaDatos.length; i++, column++) {
			String string = listaDatos[i];

			Cell cell = dataRow.createCell(column);
			cell.setCellValue(string);
			cell.setCellStyle(styles.get("cell"));

			if (isUpdate == 1) {
				StylesRegistroVacunacion.setCellColor(cell, COLOR_ACTUALIZACION);
			} else if (isUpdate == 2) {
				StylesRegistroVacunacion.setCellColor(cell, COLOR_NO_ACTUALIZACION);
			}
		}
	}

	public static void Finalize() {
		// Ahora guardaremos el archivo
		try {
			// Creamos el flujo de salida de datos, apuntando al archivo donde
			// queremos almacenar el libro de Excel
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
