package routines;
import java.util.Date;
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
public class RestarFechas {

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
	public static Date diferenciafecha(Date fecha1, Date fecha2) {
		try{ 
		final long constante = 1/(24*30);
		final Date salida;
		final long MIN_PER_DAY = 24 * 60; //Milisegundos al día 
		java.util.Date fechaIni = fecha1; //Fecha de hoy 
		java.util.Date fechaFin = fecha2; //Fecha de hoy
		
		if (fechaIni!=null && fechaFin!=null){		
		
		long diferencia = ( fechaIni.getTime() - fechaFin.getTime() )/MIN_PER_DAY; 
		System.out.println(diferencia); 
		if (Math.abs(diferencia) < constante) {
		salida = fechaFin;

		}else {
		salida = fechaIni;
		};
		}
		else{salida=new Date();};
		return salida;
		}catch(Exception err){
		err.printStackTrace();return fecha1;
		}
		}
		
	/*public static long fechas(Date fecha1, Date fecha2) {
		try{ 
		final long constante = 1/(24*30);
		final long salidas;
		final long MIN_PER_DAY = 24 * 60; //Milisegundos al día 
		java.util.Date fechaIni = fecha1; //Fecha de hoy 
		java.util.Date fechaFin = fecha2; //Fecha de hoy

		long diferencia = ( fechaIni.getTime() - fechaFin.getTime() )/MIN_PER_DAY; 
		System.out.println(diferencia); 
		if (Math.abs(diferencia) = constante) {
		salidas = 0;

		}else {
		salidas = 1;
		};

		return salidas;
		}catch(Exception err){
		err.printStackTrace();return 0;
		}
		}*/
	
}
