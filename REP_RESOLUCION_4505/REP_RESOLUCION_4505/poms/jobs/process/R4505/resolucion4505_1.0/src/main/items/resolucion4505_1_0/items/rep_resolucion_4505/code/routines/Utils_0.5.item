package routines;

import java.math.BigDecimal;
//import java.math.RoundingMode;
//import java.text.DateFormat;
import java.util.Date;
//import java.util.GregorianCalendar;
//import java.text.DateFormat;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
import java.util.Calendar;
//import java.util.Date;
//import java.util.GregorianCalendar;

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
    
    public static int[] restar_fecha(String fechaInicio ,String fechaFinal) {       
        
    	int dias = 0;
        int años = 0;
        int meses = 0;
            	
    	//creo unas fecahas para ejemplo 
    	Calendar dateI = Calendar.getInstance(); 
    	Calendar dateF = Calendar.getInstance(); 

    	String[] fechaI = fechaInicio.split("/");        
        String[] fechaF = fechaFinal.split("/");    
        
        //System.out.println(fechaFinal);
        //System.out.println(TalendDate.getDate("DD"));
    	//pongo una fecha de compraracion 
    	dateI.set(Integer.parseInt(fechaI[2]), Integer.parseInt(fechaI[1]), Integer.parseInt(fechaI[0])); 
    	dateF.set(Integer.parseInt(fechaF[2]), Integer.parseInt(fechaF[1]), Integer.parseInt(fechaF[0])); 
    	//dateF.set(Integer.parseInt(TalendDate.getDate("YYYY")), Integer.parseInt(TalendDate.getDate("MM")), Integer.parseInt(TalendDate.getDate("DD")));
    	Calendar aux = Calendar.getInstance(); 

    	//resto las fechas(la mayor de la menor o como sea tu caso) 
    	aux.setTimeInMillis(dateF.getTimeInMillis() - dateI.getTimeInMillis()); 

    	//imprimo los datos 
    	//System.out.println("" + date1.get(Calendar.YEAR) + " " + date1.get(Calendar.MONTH) + " " + 
    	//date1.get(Calendar.DAY_OF_MONTH)); 
    	//System.out.println("" + date2.get(Calendar.YEAR) + " " + date2.get(Calendar.MONTH) + " " + 
    	//date2.get(Calendar.DAY_OF_MONTH)); 

    	//A tomar en cuenta que el año minimo es 1970 por eso le resto esa cantidad     	
    	años = (aux.get(Calendar.YEAR) - 1970);
    	meses = aux.get(Calendar.MONTH);
        dias = aux.get(Calendar.DAY_OF_MONTH);
        
        //System.out.println(fechaFinal + " " + fechaInicio + " " + años);
        if(años < 0){ 
        	años=0; 
        	meses=0;
        	dias=0;        	
        }
        
    	//System.out.println("" + (aux.get(Calendar.YEAR) - 1970) + " " + aux.get(Calendar.MONTH) + " " + aux.get(Calendar.DAY_OF_MONTH)); 
    	
    	    	
    	/*             
        Date date = new Date();
        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
        fechaFinal = df.format(date);
        String[] aFechaIng = fechaInicio.split("/");
        Integer diaInicio = Integer.parseInt(aFechaIng[0]);
        Integer mesInicio = Integer.parseInt(aFechaIng[1]);
        Integer anioInicio = Integer.parseInt(aFechaIng[2]);

        String[] aFecha = fechaFinal.split("/");
        Integer diaActual = Integer.parseInt(aFecha[0]);
        Integer mesActual = Integer.parseInt(aFecha[1]);
        Integer anioActual = Integer.parseInt(aFecha[2]);

        //System.out.println(diaActual);
        //System.out.println(mesActual);
        //System.out.println(anioActual);
        
        int b = 0;
        int dias = 0;
        int mes = 0;
        int anios = 0;
        int meses = 0;
        mes = mesInicio - 1;
        if (mes == 2) {
            if ((anioActual % 4 == 0) && ((anioActual % 100 != 0) || (anioActual % 400 == 0))) {
                b = 29;
            } else {
                b = 28;
            }
        } else if (mes <= 7) {
            if (mes == 0) {
                b = 31;
            } else if (mes % 2 == 0) {
                b = 30;
            } else {
                b = 31;
            }
        } else if (mes > 7) {
            if (mes % 2 == 0) {
                b = 31;
            } else {
                b = 30;
            }
        }
        if ((anioInicio > anioActual) || (anioInicio == anioActual && mesInicio > mesActual)
                || (anioInicio == anioActual && mesInicio == mesActual && diaInicio > diaActual)) {
            //System.out.println("La fecha de inicio debe ser anterior a la fecha Actual");
        } else {
            if (mesInicio <= mesActual) {
                anios = anioActual - anioInicio;
                if (diaInicio <= diaActual) {
                    meses = mesActual - mesInicio;
                    dias = b - (diaInicio - diaActual);
                } else {
                    if (mesActual == mesInicio) {
                        anios = anios - 1;
                    }
                    meses = (mesActual - mesInicio - 1 + 12) % 12;
                    dias = b - (diaInicio - diaActual);
                }
            } else {
                anios = anioActual - anioInicio - 1;
                //System.out.println(anios);
                if (diaInicio > diaActual) {
                    meses = mesActual - mesInicio - 1 + 12;
                    dias = b - (diaInicio - diaActual);
                } else {
                    meses = mesActual - mesInicio + 12;
                    dias = diaActual - diaInicio;
                }
            }
        }

        //System.out.println("Años: " + anios);
        //System.out.println("Meses: " + meses);
        //System.out.println("Días: " + dias);
        */
        
        int[] fecha = {dias,meses,años};        
        return  fecha;
    }
    

    
}
