package routines;

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
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Utils {

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

	//Use TalendString.removeAccents
	
	private static final String ORIGINAL =    "ñáéíóúàèìòùãõâêîôôäëïöüçÑÁÉÍÓÚÀÈÌÒÙÃÕÂÊÎÔÛÄËÏÖÜÇ";// ÁáÉéÍíÓóÚúÑñÜü";
	private static final String REPLACEMENT = "naeiouaeiouaoaeiooaeioucNAEIOUAEIOUAOAEIOOAEIOUC"; //AaEeIiOoUuNnUu";
	
	public static String mayusculasSinAcentos(String message) {
		if (message == null) {
		    return null;
		}
		char[] array = message.toCharArray();
		for (int index = 0; index < array.length; index++) {
		    int pos = ORIGINAL.indexOf(array[index]);
		    if (pos > -1) {
		        array[index] = REPLACEMENT.charAt(pos);
		    }
		}
		return new String(array).toUpperCase();
	}
	
	
	public static Integer toInteger(String s, Boolean  Nullable) {
		Integer value = null;
	    try { 
	    	value = Integer.parseInt(s); 	    	
	    	if(value == 0 && Nullable == false ){ return null; }
	    	if(value < 0 && Nullable == true){ return null; }	    	
	    	
	    } catch(NumberFormatException e) {} 
	      catch(NullPointerException e) {}
	    return value;
	}
	
	public static Float toFloat(String s, Boolean  Nullable) {
		Float value = null;
	    try { 
	    	value = Float.parseFloat(s); 	    	
	    	if(value == 0 && Nullable == false ){ return null; }
	    	if(value < 0 && Nullable == true){ return null; }	    	
	    	
	    } catch(NumberFormatException e) {} 
	      catch(NullPointerException e) {}
	    return value;
	}
	
	public static BigDecimal toBigDecimal(int s) {
		BigDecimal value = null;
	    try { 
	    	value = new BigDecimal(s);//BigDecimal.valueOf(val) Integer.parseInt(s); 	    		    		    	    	
	    } catch(NumberFormatException e) {} 
	      catch(NullPointerException e) {}
	    return value;
	}
	
	public static boolean valCaractProducto(String caracteristicas) {
		
		if(caracteristicas != null && caracteristicas.contains("/") == true ){
			String[] parts = mayusculasSinAcentos(caracteristicas).split("/");
			Integer both = 0;
			for (int index = 0; index < parts.length; index++) {
			    if(parts[index].equals("REGULADO") == true || parts[index].equals("VIGILADO") == true )
			    { both++;}
			}
			if(both == 2) return true;
		}
		return false;
	}
	
	public static boolean  validarPorcentaje (String strPorcentaje) {
        if (!strPorcentaje.matches("^[0-9]{1,2}([,][0-9]{1,2})?")) {
            return false;
        }
        return true;
    }
	
	public static Double  validarValor (String strPrecio) {
        if (!strPrecio.matches("^[0-9]+([,][0-9]{1,2})?")) {
            return null;
        }
        strPrecio = strPrecio.replace(',', '.');
        return Double.parseDouble(strPrecio);
    }
	
	public static boolean  validarPrioridad (String strPrioridad) {
        if (!strPrioridad.matches("^[1-5]$")) {
            return false;
        }
        return true;
    }
		
    public static boolean  validarCodigoBarras (String codigoBarra) {
        if (!codigoBarra.matches("^[0-9]*")) {
            return false;
        }
        return true;
    }
    
    
    public static String[]  validarCUM (String cum) {
        if (!cum.matches("[0-9]+\\s*-\\s*[0-9]+")) {
            return null;
        }
        return cum.split("-");        
    }
    
    
    public static Integer valTDocumento(String tdocumento ){
    	String[] data = mayusculasSinAcentos(tdocumento).split(" ");    	
    	if(data.length == 3 ){
        	if(data[0].compareTo("FORMULA") == 0 && data[1].compareTo("MEDICA") == 0 && data[2].compareTo("AMBULATORIA") == 0 ) {
        		return 0;
        	}
        	if(data[0].compareTo("DESCARGUES") == 0 && data[1].compareTo("DE") == 0 && data[2].compareTo("PENDIENTES") == 0 ) {
        		return 1;
        	} 
    	}    	
    	return null;    	
    }
    
    public static boolean valHora(String hora){
    	try {
			DateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			sdf.setLenient(false);
			sdf.parse(hora);				
			return true;			
		} catch (Exception e) {}
		return false;
    }
   /* 
    * Elaborado por  : Carlos Andres Romero
    * Fecha elaboracion : 2017-01-10
    * Descripcion  : Genera mensaje personalizado sobre errores encontrados
    * Descripción de parámetros:
    * 		DescripcionCampo: Nombre del campo que presenta error
    * 		DescripcionError: Error detectado
    * 		campo:		      Valor que contiene el campo (Valor registrado en la celda)
    * 		opcion:			  Opción del medicamento (opción 1 y opción 2), en caso de ser un error general 0
    * 		respuesta:		  Concatena los errores detectados previamente (null si no ha detectado ninguno) 
    * 		nombreSegundoProducto: Es el nombre del segundo producto, utilizado para determinar si se debe guardar el error por motivo de segunda opción
    *  */
   public static String mensajeErrorGfa(String DescripcionCampo, String DescripcionError, String ValorCampo, int opcion, String respuesta, String nombreSegundoProducto){	
	   if (opcion == 0){
		   if(respuesta == null){
				 respuesta = "Error en campo: " +  DescripcionCampo + " ("+ValorCampo+") " + DescripcionError;
			}else{
				 respuesta = respuesta + " | " +   DescripcionCampo + " ("+ValorCampo+") " + DescripcionError;
			}
	   }
	   if(opcion == 1  ){
		   respuesta = ejecucionMensajeErrorGfa(DescripcionCampo, DescripcionError, ValorCampo, opcion, respuesta);	   
	   }	   
	   if(opcion == 2 && nombreSegundoProducto !=null ){
		   respuesta = ejecucionMensajeErrorGfa(DescripcionCampo, DescripcionError, ValorCampo, opcion, respuesta);
	   }
	   return respuesta;					   
   }
   
   public static String obtenerFechaString(Date miFecha){
	   if(miFecha == null){
		   return "";
	   }else{
		   return TalendDate.formatDate("dd/MM/yyyy", miFecha);		   	  
	   }	   
   }
   
   public static Date obtenerFecha(String miFecha){
	   Date fechaConvertida = new Date();	 
	   String formato = "dd/MM/yyyy";
	   SimpleDateFormat sdf = new SimpleDateFormat(formato);
	   int bandFecha = 0;
	   if (TalendDate.isDate(miFecha,formato)==true){	   
	   	try {
			fechaConvertida = sdf.parse(miFecha);
			return fechaConvertida;
		} catch (ParseException e) {}	   	
	   }
	   //-----------------
	   formato = "d/MM/yyyy";
	   if (TalendDate.isDate(miFecha,formato)==true){	   
		try {
		 sdf = new SimpleDateFormat(formato);
		 fechaConvertida = sdf.parse(miFecha);
		 return fechaConvertida;
		} catch (ParseException e) {}	   	
	   }
	 //-----------------
	   formato = "yyyy-MM-dd";
	   if (TalendDate.isDate(miFecha,formato)==true){	   
		try {
		 sdf = new SimpleDateFormat(formato);
		 fechaConvertida = sdf.parse(miFecha);
		 return fechaConvertida;
		} catch (ParseException e) {}	   	
	   }
	 //-----------------
	   formato = "yyyy/MM/d";
	   if (TalendDate.isDate(miFecha,formato)==true){	   
		try {
		 sdf = new SimpleDateFormat(formato);
		 fechaConvertida = sdf.parse(miFecha);
		 return fechaConvertida;
		} catch (ParseException e) {}	   	
	   }
	 //-----------------
	   formato = "dd/MM/yy";
	   if (TalendDate.isDate(miFecha,formato)==true){	   
		try {
		 sdf = new SimpleDateFormat(formato);
		 fechaConvertida = sdf.parse(miFecha);
		 return fechaConvertida;
		} catch (ParseException e) {}	   	
	   }
	 //-----------------
	   formato = "d/MM/yy";
	   if (TalendDate.isDate(miFecha,formato)==true){	   
		try {
		 sdf = new SimpleDateFormat(formato);
		 fechaConvertida = sdf.parse(miFecha);
		 return fechaConvertida;
		} catch (ParseException e) {}	   	
	   }
	 //-----------------
	   formato = "E MMM dd HH:mm:ss Z yyyy";
	   if (TalendDate.isDate(miFecha,formato)==true){	   
		try {
		 sdf = new SimpleDateFormat(formato,Locale.ENGLISH);
		 fechaConvertida = sdf.parse(miFecha);
		 return fechaConvertida;
		} catch (ParseException e) {}	   	
	   }
	   return null;	   	  
   }
   
   /*public static Date obtenerFecha(String miFecha){
	   Date fechaConvertida = new Date();
	   SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
	   int bandFecha = 0;
	   if (TalendDate.isDate(miFecha,"dd/MM/yy")==true){
	   	//SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yy");
	   	try {
			fechaConvertida = sdf.parse(miFecha);
		} catch (ParseException e) {
		}	   	
	   }else{	
	   	if (TalendDate.isDate(miFecha,"d/MM/yy")==true){
	   		sdf = new SimpleDateFormat("d/MM/yy");
	   		//SimpleDateFormat sdf2 = new SimpleDateFormat("d/MM/yy");
	   		try {
				fechaConvertida = sdf.parse(miFecha);
			} catch (ParseException e) {
				return null;				
			}
	   	}
	   	else{	
	   		//System.out.println("Definitivamente NOOO : " + miFecha);
	   		sdf = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy",Locale.ENGLISH);
			// http://stackoverflow.com/questions/1661325/simpledateformat-and-locale-based-format-string								
			try {
				fechaConvertida = sdf.parse(miFecha);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				return null;
			}	   		
	   	}	   	
	   }	   
	   return fechaConvertida;
   }*/
   
   public static String ejecucionMensajeErrorGfa(String DescripcionCampo, String DescripcionError, String campo, int opcion, String respuesta){	
	   if(campo.equals("") == false){
		   campo= " '" + campo + "' ";
	   }else{
		   campo= "";
	   }
			if(respuesta == null){
				respuesta = "Error en campo: " +  DescripcionCampo + "(Opción " + opcion + campo +") " + DescripcionError;
			}else{
				respuesta = respuesta + " | " +  DescripcionCampo + "(Opción " + opcion + campo +") " + DescripcionError;
			}
			return respuesta;					   
   }
   
   public static String mensajesErrorInventario(String campo, String DescripcionError, String menajeError){	
	   if(menajeError == null){
		   menajeError = "Error en campo: " +  campo + "("  + DescripcionError +")";
		}else{
			menajeError = menajeError + " | "  + campo + "("  + DescripcionError +")";
		}		
		return menajeError;					   
   }
}
