package routines;

public class ColumnName {

	public static boolean IsValidGenerico(String ... data) {    	    	
    	if (Utils.mayusculasSinAcentos(data[0].replaceAll("\\s","").toUpperCase()).equals("NOMBREGENERICO") == false){return false;}    	
    	if (Utils.mayusculasSinAcentos(data[1].replaceAll("\\s","").toUpperCase()).equals("CONCENTRACION") == false){return false;}
    	if (Utils.mayusculasSinAcentos(data[2].replaceAll("\\s","").toUpperCase()).equals("ATC") == false ){return false;}
    	if (Utils.mayusculasSinAcentos(data[3].replaceAll("\\s","").toUpperCase()).equals("VIAADMINTRACION") == false){return false;}
    	if (Utils.mayusculasSinAcentos(data[4].replaceAll("\\s","").toUpperCase()).equals("GRUPOFARMACOLOGICO") == false){return false;}
    	if (Utils.mayusculasSinAcentos(data[5].replaceAll("\\s","").toUpperCase()).equals("FORMAFARMACEUTICA") == false){return false;}    	
    	return true;
    }
	
	public static boolean IsValidAcuerdo(String ... data) {    	    	
    	if (Utils.mayusculasSinAcentos(data[0].replaceAll("\\s","").toUpperCase()).equals("CODIGOSSMP") == false){return false;}    	
    	if (Utils.mayusculasSinAcentos(data[1].replaceAll("\\s","").toUpperCase()).equals("NOMBREGENERICO") == false){return false;}
    	if (Utils.mayusculasSinAcentos(data[2].replaceAll("\\s","").toUpperCase()).equals("CONCENTRACION") == false){return false;}
    	if (Utils.mayusculasSinAcentos(data[3].replaceAll("\\s","").toUpperCase()).equals("FORMAFARMACEUTICA") == false){return false;}
    	if (Utils.mayusculasSinAcentos(data[4].replaceAll("\\s","").toUpperCase()).equals("VIAADMINISTRACION") == false){return false;}
    	if (Utils.mayusculasSinAcentos(data[5].replaceAll("\\s","").toUpperCase()).equals("NIVELUSO") == false){return false;}    	
    	if (Utils.mayusculasSinAcentos(data[6].replaceAll("\\s","").toUpperCase()).equals("NIVELATENCION") == false){return false;}
    	if (Utils.mayusculasSinAcentos(data[7].replaceAll("\\s","").toUpperCase()).equals("OBSERVACIONPARAELNIVELDEUSO") == false){return false;}
    	if (Utils.mayusculasSinAcentos(data[8].replaceAll("\\s","").toUpperCase()).equals("USADOPARAPREPARACIONES") == false){return false;}
    	return true;
    }
		
    public static boolean IsValidBodega(String ... data) {    	    	
    	if (Utils.mayusculasSinAcentos(data[0].replaceAll("\\s","").toUpperCase()).equals("TIPOBODEGA") == false){return false;}    	
    	if (Utils.mayusculasSinAcentos(data[1].replaceAll("\\s","").toUpperCase()).equals("CODIGO") == false){return false;}
    	if (Utils.mayusculasSinAcentos(data[2].replaceAll("\\s","").toUpperCase()).equals("NOMBREBODEGA") == false){return false;}
    	if (Utils.mayusculasSinAcentos(data[3].replaceAll("\\s","").toUpperCase()).equals("DESCRIPCION") == false) {return false;}
    	if (Utils.mayusculasSinAcentos(data[4].replaceAll("\\s","").toUpperCase()).equals("SIGLAESM") == false){return false;}
    	if (Utils.mayusculasSinAcentos(data[5].replaceAll("\\s","").toUpperCase()).equals("MODALIDAD") == false){return false;}    	
    	return true;
    }
    
    public static boolean IsValidInventario(String ... data) {    	    	
    	if (Utils.mayusculasSinAcentos(data[0].replaceAll("\\s","").toUpperCase()).equals("TIPOPRODUCTO") == false){return false;}
    	if (Utils.mayusculasSinAcentos(data[1].replaceAll("\\s","").toUpperCase()).equals("CODIGOBARRAS") == false){return false;}       	    
    	if (Utils.mayusculasSinAcentos(data[2].replaceAll("\\s","").toUpperCase()).equals("CUM") == false){return false;}    	
    	if (Utils.mayusculasSinAcentos(data[3].replaceAll("\\s","").toUpperCase()).equals("REGISTROINVIMA") == false){return false;}    	    
    	if (Utils.mayusculasSinAcentos(data[4].replaceAll("\\s","").toUpperCase()).equals("CODIGOHOMIC") == false){return false;}
    	if (Utils.mayusculasSinAcentos(data[5].replaceAll("\\s","").toUpperCase()).equals("CANTIDADENVIADA") == false){return false;}
    	if (Utils.mayusculasSinAcentos(data[6].replaceAll("\\s","").toUpperCase()).equals("CANTIDADAINGRESAR") == false){return false;}
    	if (Utils.mayusculasSinAcentos(data[7].replaceAll("\\s","").toUpperCase()).equals("LOTE") == false){return false;}
    	if (Utils.mayusculasSinAcentos(data[8].replaceAll("\\s","").toUpperCase()).equals("FECHAVENCIMIENTO") == false){return false;}
    	if (Utils.mayusculasSinAcentos(data[9].replaceAll("\\s","").toUpperCase()).equals("LEYENDADERESTRICCION") == false ){return false;}
    	if (Utils.mayusculasSinAcentos(data[10].replaceAll("\\s","").toUpperCase()).equals("DEFECTOS") == false ){return false;}    	
    	if (Utils.mayusculasSinAcentos(data[11].replaceAll("\\s","").toUpperCase()).equals("TEMPERATURADERECEPCION(C°)") == false ){return false;}    	
    	if (Utils.mayusculasSinAcentos(data[12].replaceAll("\\s","").toUpperCase()).equals("NIVELDERIESGO") == false ){return false;}
    	if (Utils.mayusculasSinAcentos(data[13].replaceAll("\\s","").toUpperCase()).equals("TAMANODELAMUESTRA") == false ){return false;}
    	if (Utils.mayusculasSinAcentos(data[14].replaceAll("\\s","").toUpperCase()).equals("APROBADO") == false ){return false;}
    	if (Utils.mayusculasSinAcentos(data[15].replaceAll("\\s","").toUpperCase()).equals("NUMERODECONTRATO") == false ){return false;}
    	return true;
    }
    
    public static boolean IsValidProducto(String ... data) {    	    	
    	
    	if (Utils.mayusculasSinAcentos(data[0].replaceAll("\\s","").toUpperCase()).equals("CODIGOBARRAS") == false){return false;}     	
    	if (Utils.mayusculasSinAcentos(data[1].replaceAll("\\s","").toUpperCase()).equals("NOMBRECOMERCIAL") == false){return false;}    	    	
    	if (Utils.mayusculasSinAcentos(data[2].replaceAll("\\s","").toUpperCase()).equals("PRESENTACIONCOMERCIAL") == false ){return false;}
    	if (Utils.mayusculasSinAcentos(data[3].replaceAll("\\s","").toUpperCase()).equals("VIADEADMINISTRACION") == false){return false;}    	
    	if (Utils.mayusculasSinAcentos(data[4].replaceAll("\\s","").toUpperCase()).equals("FORMAFARMACEUTICA") == false){return false;}
    	if (Utils.mayusculasSinAcentos(data[5].replaceAll("\\s","").toUpperCase()).equals("NOMBREGENERICO") == false){return false;}    	    	
    	if (Utils.mayusculasSinAcentos(data[6].replaceAll("\\s","").toUpperCase()).equals("CONCENTRACION") == false){return false;}    	
    	if (Utils.mayusculasSinAcentos(data[7].replaceAll("\\s","").toUpperCase()).equals("UNIDOSIS") == false){return false;}    	
    	if (Utils.mayusculasSinAcentos(data[8].replaceAll("\\s","").toUpperCase()).equals("UNIDADMEDIDA") == false){return false;}
    	if (Utils.mayusculasSinAcentos(data[9].replaceAll("\\s","").toUpperCase()).equals("CANTIDADUNIDADMEDIDA") == false){return false;}
    	if (Utils.mayusculasSinAcentos(data[10].replaceAll("\\s","").toUpperCase()).equals("CANTIDADMINIMA") == false){return false;}   	    	
    	if (Utils.mayusculasSinAcentos(data[11].replaceAll("\\s","").toUpperCase()).equals("REGISTROINVIMA") == false){return false;}
    	if (Utils.mayusculasSinAcentos(data[12].replaceAll("\\s","").toUpperCase()).equals("FECHAEXPEDICIONREG.INVIMA") == false){return false;}    	
    	if (Utils.mayusculasSinAcentos(data[13].replaceAll("\\s","").toUpperCase()).equals("FECHAVENCIMIENTOREGINVIMA") == false){return false;}
    	if (Utils.mayusculasSinAcentos(data[14].replaceAll("\\s","").toUpperCase()).equals("FECHAACTIVOCUM") == false){return false;}
    	if (Utils.mayusculasSinAcentos(data[15].replaceAll("\\s","").toUpperCase()).equals("FECHAINACTIVOCUM") == false){return false;}   	    	
    	if (Utils.mayusculasSinAcentos(data[16].replaceAll("\\s","").toUpperCase()).equals("CUM") == false){return false;}
    	if (Utils.mayusculasSinAcentos(data[17].replaceAll("\\s","").toUpperCase()).equals("LUGARDEORIGEN") == false){return false;}
    	if (Utils.mayusculasSinAcentos(data[18].replaceAll("\\s","").toUpperCase()).equals("CARACTERISTICAS") == false){return false;}
    	if (Utils.mayusculasSinAcentos(data[19].replaceAll("\\s","").toUpperCase()).equals("CONTRAINDICACIONES") == false){return false;}    	    
    	if (Utils.mayusculasSinAcentos(data[20].replaceAll("\\s","").toUpperCase()).equals("EFECTOSPOSTERIOR") == false){return false;}
    	if (Utils.mayusculasSinAcentos(data[21].replaceAll("\\s","").toUpperCase()).equals("RIESGOSASOCIADOS") == false){return false;}
    	if (Utils.mayusculasSinAcentos(data[22].replaceAll("\\s","").toUpperCase()).equals("DOSISPARAAPLICACION") == false){return false;}    	   
    	if (Utils.mayusculasSinAcentos(data[23].replaceAll("\\s","").toUpperCase()).equals("NITFABRICANTE") == false){return false;}
    	if (Utils.mayusculasSinAcentos(data[24].replaceAll("\\s","").toUpperCase()).equals("FABRICANTE") == false){return false;}
    	if (Utils.mayusculasSinAcentos(data[25].replaceAll("\\s","").toUpperCase()).equals("NITIMPORTADOR") == false){return false;}
    	if (Utils.mayusculasSinAcentos(data[26].replaceAll("\\s","").toUpperCase()).equals("IMPORTADOR") == false){return false;}    	
    	return true;
    }
    

    public static boolean IsValidProxContrato(String ... data) {    	    	
    	
    	
    	if (Utils.mayusculasSinAcentos(data[0].replaceAll("\\s","").toUpperCase()).equals("ITEMNO.") == false){return false;}
    	if (Utils.mayusculasSinAcentos(data[1].replaceAll("\\s","").toUpperCase()).equals("CODIGOBARRAS") == false ){return false;}    	    	
    	if (Utils.mayusculasSinAcentos(data[2].replaceAll("\\s","").toUpperCase()).equals("CODIGOSSMP") == false){return false;}
    	if (Utils.mayusculasSinAcentos(data[3].replaceAll("\\s","").toUpperCase()).equals("CODIGOPROVISIONAL") == false){return false;}
    	if (Utils.mayusculasSinAcentos(data[4].replaceAll("\\s","").toUpperCase()).equals("CODIGOPRODUCTO") == false){return false;}    	
    	if (Utils.mayusculasSinAcentos(data[5].replaceAll("\\s","").toUpperCase()).equals("VALORUNITARIO") == false){return false;}
    	if (Utils.mayusculasSinAcentos(data[6].replaceAll("\\s","").toUpperCase()).equals("IVA") == false){return false;}   	
    	if (Utils.mayusculasSinAcentos(data[7].replaceAll("\\s","").toUpperCase()).equals("VALORSERVICIOOPLSUMINISTRO4,75%") == false){return false;}
    	if (Utils.mayusculasSinAcentos(data[8].replaceAll("\\s","").toUpperCase()).equals("VALORIVAALSERVICIOOPLSUM16%") == false){return false;}
    	if (Utils.mayusculasSinAcentos(data[9].replaceAll("\\s","").toUpperCase()).equals("VALORSERVICIOOPLDISPENSACION11,75%") == false){return false;}
    	if (Utils.mayusculasSinAcentos(data[10].replaceAll("\\s´","").toUpperCase()).equals("VALORIVAALSERVICIOOPLDIS16%") == false){return false;}
    	if (Utils.mayusculasSinAcentos(data[11].replaceAll("\\s","").toUpperCase()).equals("OPCION") == false){return false;}
    	if (Utils.mayusculasSinAcentos(data[12].replaceAll("\\s","").toUpperCase()).equals("CARACTERISTICA") == false){return false;}
    	return true;
    } 
    
    public static boolean IsValidAnexoTecnico(String ... data) {   
    	if (Utils.mayusculasSinAcentos(data[0].replaceAll("\\s","").toUpperCase()).equals("CONTRATO") == false){return false;}     	
    	if (Utils.mayusculasSinAcentos(data[1].replaceAll("\\s","").toUpperCase()).equals("TIPOLOGIA") == false){return false;}    	    	
    	if (Utils.mayusculasSinAcentos(data[2].replaceAll("\\s","").toUpperCase()).equals("TIPOPRODUCTO") == false ){return false;}
    	if (Utils.mayusculasSinAcentos(data[3].replaceAll("\\s","").toUpperCase()).equals("ITEMNO.") == false){return false;}    	
    	if (Utils.mayusculasSinAcentos(data[4].replaceAll("\\s","").toUpperCase()).equals("CODIGOSSMP") == false){return false;}    	
    	if (Utils.mayusculasSinAcentos(data[5].replaceAll("\\s","").toUpperCase()).equals("NOMBREGENERICO") == false){return false;}    	
    	if (Utils.mayusculasSinAcentos(data[6].replaceAll("\\s","").toUpperCase()).equals("PRESENTACION") == false){return false;}
    	if (Utils.mayusculasSinAcentos(data[7].replaceAll("\\s","").toUpperCase()).equals("CONCENTRACION") == false){return false;}    	    	    	
    	if (Utils.mayusculasSinAcentos(data[8].replaceAll("\\s","").toUpperCase()).equals("VIAADMINISTRACION") == false){return false;}    	
    	if (Utils.mayusculasSinAcentos(data[9].replaceAll("\\s","").toUpperCase()).equals("UNIDADDEMEDIDA") == false){return false;}    	
    	if (Utils.mayusculasSinAcentos(data[10].replaceAll("\\s","").toUpperCase()).equals("ATC") == false){return false;}   	    	
    	if (Utils.mayusculasSinAcentos(data[11].replaceAll("\\s","").toUpperCase()).equals("GRUPOFARMACOLOGICO") == false){return false;}    	
    	if (Utils.mayusculasSinAcentos(data[12].replaceAll("\\s","").toUpperCase()).equals("CADENAFRIO") == false){return false;}      	
    	if (Utils.mayusculasSinAcentos(data[13].replaceAll("\\s","").toUpperCase()).equals("CODIGOHOMIC") == false){return false;}    	
    	if (Utils.mayusculasSinAcentos(data[14].replaceAll("\\s","").toUpperCase()).equals("NOMBRECOMERCIALPRODUCTOMARCA") == false){return false;}    	
    	if (Utils.mayusculasSinAcentos(data[15].replaceAll("\\s","").toUpperCase()).equals("LABORATORIOFABRICANTE") == false){return false;}    	
    	if (Utils.mayusculasSinAcentos(data[16].replaceAll("\\s","").toUpperCase()).equals("NOREGISTROSANITARIO") == false){return false;}    	
    	if (Utils.mayusculasSinAcentos(data[17].replaceAll("\\s","").toUpperCase()).equals("IMPORTADORTITULAR") == false){return false;}    	
    	if (Utils.mayusculasSinAcentos(data[18].replaceAll("\\s","").toUpperCase()).equals("CUM") == false){return false;}    	
    	if (Utils.mayusculasSinAcentos(data[19].replaceAll("\\s","").toUpperCase()).equals("PRECIO") == false){return false;}   
    	if (Utils.mayusculasSinAcentos(data[20].replaceAll("\\s","").toUpperCase()).equals("OPCION") == false){return false;} 	
    	if (Utils.mayusculasSinAcentos(data[21].replaceAll("\\s","").toUpperCase()).equals("TIENEIVA?") == false){return false;}    	
    	if (Utils.mayusculasSinAcentos(data[22].replaceAll("\\s","").toUpperCase()).equals("CODIGOBARRAS") == false){return false;}    	
    	if (Utils.mayusculasSinAcentos(data[23].replaceAll("\\s","").toUpperCase()).equals("FORMAFARMACEUTICA") == false){return false;}    	
    	if (Utils.mayusculasSinAcentos(data[24].replaceAll("\\s","").toUpperCase()).equals("UNIDOSIS") == false){return false;}    	
    	if (Utils.mayusculasSinAcentos(data[25].replaceAll("\\s","").toUpperCase()).equals("UNIDADMEDIDA") == false){return false;}    	
    	if (Utils.mayusculasSinAcentos(data[26].replaceAll("\\s","").toUpperCase()).equals("CANTIDADUNIDADMEDIDA") == false){return false;}    	
    	if (Utils.mayusculasSinAcentos(data[27].replaceAll("\\s","").toUpperCase()).equals("CANTIDADMINIMA") == false){return false;}
    	if (Utils.mayusculasSinAcentos(data[28].replaceAll("\\s","").toUpperCase()).equals("CANTIDADMAXIMA") == false){return false;}    	
    	if (Utils.mayusculasSinAcentos(data[29].replaceAll("\\s","").toUpperCase()).equals("FECHAEXPEDICIONREG.INVIMA") == false){return false;}    	
    	if (Utils.mayusculasSinAcentos(data[30].replaceAll("\\s","").toUpperCase()).equals("FECHAVENCIMIENTOREGINVIMA") == false){return false;}
    	if (Utils.mayusculasSinAcentos(data[31].replaceAll("\\s","").toUpperCase()).equals("FECHAACTIVOCUM") == false){return false;}
    	if (Utils.mayusculasSinAcentos(data[32].replaceAll("\\s","").toUpperCase()).equals("FECHAINACTIVOCUM") == false){return false;}
    	if (Utils.mayusculasSinAcentos(data[33].replaceAll("\\s","").toUpperCase()).equals("LUGARDEORIGEN") == false){return false;}
    	if (Utils.mayusculasSinAcentos(data[34].replaceAll("\\s","").toUpperCase()).equals("CARACTERISTICAS") == false){return false;}
    	if (Utils.mayusculasSinAcentos(data[35].replaceAll("\\s","").toUpperCase()).equals("CONTRAINDICACIONES") == false){return false;}
    	if (Utils.mayusculasSinAcentos(data[36].replaceAll("\\s","").toUpperCase()).equals("EFECTOSPOSTERIOR") == false){return false;}
    	if (Utils.mayusculasSinAcentos(data[37].replaceAll("\\s","").toUpperCase()).equals("RIESGOSASOCIADOS") == false){return false;}
    	if (Utils.mayusculasSinAcentos(data[38].replaceAll("\\s","").toUpperCase()).equals("DOSISPARAAPLICACION") == false){return false;}
    	if (Utils.mayusculasSinAcentos(data[39].replaceAll("\\s","").toUpperCase()).equals("NITFABRICANTE") == false){return false;}
    	if (Utils.mayusculasSinAcentos(data[40].replaceAll("\\s","").toUpperCase()).equals("NITIMPORTADOR") == false){return false;}
    	if (Utils.mayusculasSinAcentos(data[41].replaceAll("\\s","").toUpperCase()).equals("CODIGOOPERADOR") == false){return false;}
    	if (Utils.mayusculasSinAcentos(data[42].replaceAll("\\s","").toUpperCase()).equals("CODIGOPROVISIONALDECOMITE") == false){return false;}
    	
    	
    	return true;
    }

}
