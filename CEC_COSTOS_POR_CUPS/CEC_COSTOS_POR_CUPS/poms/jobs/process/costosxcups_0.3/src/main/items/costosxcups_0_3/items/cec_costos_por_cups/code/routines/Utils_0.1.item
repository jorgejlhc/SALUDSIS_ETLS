package routines;

import java.math.BigDecimal;
import java.math.RoundingMode;

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
    public static BigDecimal divide(BigDecimal dividendo, BigDecimal divisor) {
		
    	if (dividendo == null || divisor == null) {
    		return new BigDecimal(0);
		}
    	
    	if (divisor.signum() == 0) {
           return new BigDecimal(0);
        }
    	    	    	   
    	return dividendo.divide(divisor, 9, RoundingMode.HALF_DOWN);        
    }
    
    public static boolean getBase(BigDecimal base){
    	if (base == null) {
			return false;					
		}
    	    	
    	if (base.compareTo(new BigDecimal(0)) == 0) {
			return false;
		}
    	 
    	return true;
    }
    
}
