package routines;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
	static long milisegundos_hora = 60 * 60 * 1000;
    public static double difmis (Date fechaI, Date fechaF) {
    	double  result = 0;
    	
    	try {  
    		
    		result = fechaF.getTime() - fechaI.getTime(); // milisegundos_hora);
    		//result = new BigDecimal(dif);
    		//result = new BigDecimal(fechaF.getTime() - fechaI.getTime()); //.divide(new BigDecimal(milisegundos_hora));
    		//System.out.print(result);
    		//System.out.print("\n\r");
    		//double div = (diff.intValue()/milisegundos_hora); 
    	//	result = new BigDecimal("0");
    	} catch (Exception ex) { /*System.out.print(ex.getMessage());*/  }
    	return result;
    }
    
    public static BigDecimal truncateDecimal(double x,int numberofDecimals)
    {
        if ( x > 0) {
            return new BigDecimal(String.valueOf(x)).setScale(numberofDecimals, BigDecimal.ROUND_FLOOR);
        } else {
            return new BigDecimal(String.valueOf(x)).setScale(numberofDecimals, BigDecimal.ROUND_CEILING);
        }
    }
    
    public static BigDecimal tmuerto_cita(Date FInicial, Date FFinal, Date FPInicial, Date FPFinal, String Estado )
    {
    	/*new BigDecimal((age_utils.difmis(row18.CITA_FECHAI,row18.CITA_FECHAF)- age_utils.difmis(row18.PRO_FINICIAL,row18.PRO_FFINAL) )/60000) 
    	Var._tmuerto.compareTo(new BigDecimal(0)) == -1 ? new BigDecimal(0) : Var._tmuerto*/
    	
    	double tiempo_cita =  difmis(FInicial,FFinal);
    	double tiempo_atencion = difmis(FPInicial,FPFinal);
    	BigDecimal tiempo_muerto = new BigDecimal( (tiempo_cita-tiempo_atencion) / 60000);
    	
    	if(Estado.compareTo("Confirmada") == 0 || Estado.compareTo("En proceso") == 0 || Estado.compareTo("Asignada") == 0  ) {
    		return null;
    	}
    	else {
	    	if(tiempo_muerto.compareTo(new BigDecimal(0)) == -1 ){    		
	    		return new BigDecimal(0);
	    	}    
    	}
        return tiempo_muerto;        
    }
    
}
