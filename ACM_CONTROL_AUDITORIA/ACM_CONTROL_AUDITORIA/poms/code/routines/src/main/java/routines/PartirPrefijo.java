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
public class PartirPrefijo {

     public static String[] PartirFactura(String Nfactura) {
    	 
    	 int numero = Nfactura.length();
    	 char caracter;
    	 String resultado = Nfactura;
    	 String prefijo = null;
    	 
    	 for (int i = numero; i > 0; i--) {
    		 caracter = Nfactura.charAt(i-1);
    		if ( !String.valueOf(caracter).matches("\\d")) {
    			int Rinferior = (numero-i);
    			resultado = Nfactura.substring(i,numero);
    			prefijo = Nfactura.substring(0,i);
    			
    			 break;
    		}
    		}
    
		return new String[] {resultado,prefijo};
       
    }
}
