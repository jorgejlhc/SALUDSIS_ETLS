package org.talend.designer.codegen.translators.data_quality;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;

public class TIntervalMatchBeginJava
{
  protected static String nl;
  public static synchronized TIntervalMatchBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TIntervalMatchBeginJava result = new TIntervalMatchBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = " " + NL + "" + NL + "        int nb_line_";
  protected final String TEXT_2 = " = 0; " + NL + "        final java.util.List<";
  protected final String TEXT_3 = "Struct> list_";
  protected final String TEXT_4 = " = new java.util.ArrayList(((java.util.Map<";
  protected final String TEXT_5 = "Struct, ";
  protected final String TEXT_6 = "Struct>) globalMap.get(\"tHash_";
  protected final String TEXT_7 = "\")).keySet());" + NL + "        java.util.Collections.sort((java.util.List<";
  protected final String TEXT_8 = "Struct>) list_";
  protected final String TEXT_9 = ", new java.util.Comparator<";
  protected final String TEXT_10 = "Struct>(){" + NL + "" + NL + "            public int compare(";
  protected final String TEXT_11 = "Struct o1, ";
  protected final String TEXT_12 = "Struct o2) {";
  protected final String TEXT_13 = NL + "                    Long o1_min = o1.";
  protected final String TEXT_14 = " == null ? null : new Long(o1.";
  protected final String TEXT_15 = ".getTime());" + NL + "                    Long o1_max = o1.";
  protected final String TEXT_16 = ".getTime());" + NL + "                    Long o2_min = o2.";
  protected final String TEXT_17 = " == null ? null : new Long(o2.";
  protected final String TEXT_18 = ".getTime());" + NL + "                    Long o2_max = o2.";
  protected final String TEXT_19 = ".getTime());";
  protected final String TEXT_20 = NL + "                    ";
  protected final String TEXT_21 = " o1_min = o1.";
  protected final String TEXT_22 = ";";
  protected final String TEXT_23 = " o1_max = o1.";
  protected final String TEXT_24 = " o2_min = o2.";
  protected final String TEXT_25 = " o2_max = o2.";
  protected final String TEXT_26 = NL + "                    String o1_min = o1.";
  protected final String TEXT_27 = " == null ? null : new String(o1.";
  protected final String TEXT_28 = ");" + NL + "                    String o1_max = o1.";
  protected final String TEXT_29 = ");" + NL + "                    String o2_min = o2.";
  protected final String TEXT_30 = " == null ? null : new String(o2.";
  protected final String TEXT_31 = ");" + NL + "                    String o2_max = o2.";
  protected final String TEXT_32 = ");";
  protected final String TEXT_33 = ";" + NL + "                    String o1_max = o1.";
  protected final String TEXT_34 = ";" + NL + "                    String o2_min = o2.";
  protected final String TEXT_35 = ";" + NL + "                    String o2_max = o2.";
  protected final String TEXT_36 = ";                    ";
  protected final String TEXT_37 = NL + "                    String o1_min = String.valueOf(o1.";
  protected final String TEXT_38 = ");" + NL + "                    String o1_max = String.valueOf(o1.";
  protected final String TEXT_39 = ");" + NL + "                    String o2_min = String.valueOf(o2.";
  protected final String TEXT_40 = ");" + NL + "                    String o2_max = String.valueOf(o2.";
  protected final String TEXT_41 = NL + "                ";
  protected final String TEXT_42 = NL + "                        if(o1_min == null && o2_min != null) {" + NL + "                            return -1;" + NL + "                        } else if(o1_min != null && o2_min == null) {" + NL + "                            return 1;" + NL + "                        } else if(o1_min != null && o2_min != null && o1_min != o2_min) {" + NL + "                            if(o1_min < o2_min) {" + NL + "                                return -1;" + NL + "                            } else {" + NL + "                                return 1;" + NL + "                            }" + NL + "                        } else {" + NL + "                            if(o1_max == null && o2_max != null) {" + NL + "                                return -1;" + NL + "                            } else if(o1_max != null && o2_max == null) {" + NL + "                                return 1;" + NL + "                            } else if(o1_max != null && o2_max != null && o1_max != o2_max) {" + NL + "                                if(o1_max < o2_max) {" + NL + "                                    return -1;" + NL + "                                } else {" + NL + "                                    return 1;" + NL + "                                }" + NL + "                            } else {" + NL + "                                return 0;" + NL + "                            }" + NL + "                        }";
  protected final String TEXT_43 = NL + "                        if(o1_min < o2_min) {" + NL + "                            return -1;" + NL + "                        } else if(o1_min > o2_min) {" + NL + "                            return 1;" + NL + "                        } else {" + NL + "                            if(o1_max < o2_max) {" + NL + "                                return -1;" + NL + "                            } else if(o1_max > o2_max) {" + NL + "                                return 1;" + NL + "                            } else {" + NL + "                                return 0;" + NL + "                            }" + NL + "                        }";
  protected final String TEXT_44 = NL + "                    if(o1_min == null && o2_min != null) {" + NL + "                        return -1;" + NL + "                    } else if(o1_min != null && o2_min == null) {" + NL + "                        return 1;" + NL + "                    } else if(o1_min != null && o2_min != null && o1_min.compareTo(o2_min) != 0) {" + NL + "                        if(o1_min.compareTo(o2_min) < 0) {" + NL + "                            return -1;" + NL + "                        } else {" + NL + "                            return 1;" + NL + "                        }" + NL + "                    } else {" + NL + "                        if(o1_max == null && o2_max != null) {" + NL + "                            return -1;" + NL + "                        } else if(o1_max != null && o2_max == null) {" + NL + "                            return 1;" + NL + "                        } else if(o1_max != null && o2_max != null && o1_max.compareTo(o2_max) != 0) {" + NL + "                            if(o1_max.compareTo(o2_max) < 0) {" + NL + "                                return -1;" + NL + "                            } else {" + NL + "                                return 1;" + NL + "                            }" + NL + "                        } else {" + NL + "                            return 0;" + NL + "                        }" + NL + "                    }                    ";
  protected final String TEXT_45 = "         \t" + NL + "            }" + NL + "\t" + NL + "        });" + NL + "" + NL + "        final ";
  protected final String TEXT_46 = "Struct[] array_";
  protected final String TEXT_47 = " = (";
  protected final String TEXT_48 = "Struct[])list_";
  protected final String TEXT_49 = ".toArray(new ";
  protected final String TEXT_50 = "Struct[list_";
  protected final String TEXT_51 = ".size()]);" + NL + "" + NL + "        class Util_";
  protected final String TEXT_52 = " {" + NL + "        " + NL + "            public ";
  protected final String TEXT_53 = " getLookup(";
  protected final String TEXT_54 = "Struct row_Main) {" + NL + "" + NL + "                int lowerBound = 0;" + NL + "                int upperBound = array_";
  protected final String TEXT_55 = ".length - 1;";
  protected final String TEXT_56 = "               " + NL + "                while(true) {" + NL + "                    int currentIndex = (lowerBound + upperBound)/2;";
  protected final String TEXT_57 = NL + "                        Long tmpMain = row_Main.";
  protected final String TEXT_58 = " == null ? null : new Long(row_Main.";
  protected final String TEXT_59 = ".getTime());" + NL + "                        Long tmpMin = array_";
  protected final String TEXT_60 = "[currentIndex].";
  protected final String TEXT_61 = " == null ? null : new Long(array_";
  protected final String TEXT_62 = ".getTime());" + NL + "                        Long tmpMax = array_";
  protected final String TEXT_63 = NL + "                        ";
  protected final String TEXT_64 = " tmpMain = row_Main.";
  protected final String TEXT_65 = " tmpMin = array_";
  protected final String TEXT_66 = " tmpMax = array_";
  protected final String TEXT_67 = NL + "                        String tmpMain = row_Main.";
  protected final String TEXT_68 = " == null ? null : new String(row_Main.";
  protected final String TEXT_69 = ");" + NL + "                        String tmpMin = array_";
  protected final String TEXT_70 = " == null ? null : new String(array_";
  protected final String TEXT_71 = ");" + NL + "                        String tmpMax = array_";
  protected final String TEXT_72 = ";" + NL + "                        String tmpMin = array_";
  protected final String TEXT_73 = ";" + NL + "                        String tmpMax = array_";
  protected final String TEXT_74 = NL + "                        String tmpMain = String.valueOf(row_Main.";
  protected final String TEXT_75 = ");" + NL + "                        String tmpMin = String.valueOf(array_";
  protected final String TEXT_76 = ");" + NL + "                        String tmpMax = String.valueOf(array_";
  protected final String TEXT_77 = NL + "                            if(tmpMain == null) {" + NL + "                                return ";
  protected final String TEXT_78 = ";" + NL + "                            }                            " + NL + "                            if((tmpMin == null && tmpMax != null && tmpMain <";
  protected final String TEXT_79 = " tmpMax) || " + NL + "                                    (tmpMin != null && tmpMax == null && tmpMain >";
  protected final String TEXT_80 = " tmpMin) || " + NL + "                                    (tmpMin != null && tmpMax != null && tmpMain >";
  protected final String TEXT_81 = " tmpMin && tmpMain <";
  protected final String TEXT_82 = " tmpMax)) {";
  protected final String TEXT_83 = NL + "                            if(tmpMain >";
  protected final String TEXT_84 = " tmpMax) {";
  protected final String TEXT_85 = NL + "                        return array_";
  protected final String TEXT_86 = NL + "                        if(tmpMain == null) {" + NL + "                            return ";
  protected final String TEXT_87 = ";" + NL + "                        }                        " + NL + "                        if((tmpMin == null && tmpMax != null && tmpMain.compareTo(tmpMax) <";
  protected final String TEXT_88 = " 0) ||" + NL + "                                (tmpMin != null && tmpMax == null && tmpMain.compareTo(tmpMin) >";
  protected final String TEXT_89 = " 0) || " + NL + "                                (tmpMin != null && tmpMax != null && tmpMain.compareTo(tmpMin) >";
  protected final String TEXT_90 = " 0 && tmpMain.compareTo(tmpMax) <";
  protected final String TEXT_91 = " 0)) {" + NL + "                            return array_";
  protected final String TEXT_92 = NL + "                    } else if (lowerBound > upperBound) {" + NL + "                        return ";
  protected final String TEXT_93 = ";" + NL + "                    } else {";
  protected final String TEXT_94 = NL + "                                if(tmpMin != null && tmpMain < tmpMin) {" + NL + "                                    upperBound = currentIndex - 1;" + NL + "                                } else if(tmpMin != null && tmpMain > tmpMin) {" + NL + "                                    lowerBound = currentIndex + 1;" + NL + "                                } else {" + NL + "                                    upperBound = currentIndex - 1;" + NL + "                                }";
  protected final String TEXT_95 = NL + "                                if(tmpMain < tmpMin) {" + NL + "                                    upperBound = currentIndex - 1;" + NL + "                                } else if(tmpMain > tmpMin) {" + NL + "                                    lowerBound = currentIndex + 1;" + NL + "                                } else {" + NL + "                                    upperBound = currentIndex - 1;" + NL + "                                }";
  protected final String TEXT_96 = NL + "                            if(tmpMin != null && tmpMain.compareTo(tmpMin) < 0) {" + NL + "                                upperBound = currentIndex - 1;" + NL + "                            } else if(tmpMin != null && tmpMain.compareTo(tmpMin) > 0) {" + NL + "                                lowerBound = currentIndex + 1;" + NL + "                            } else {" + NL + "                                upperBound = currentIndex - 1;" + NL + "                            }";
  protected final String TEXT_97 = NL + "                    }" + NL + "                }" + NL + "            }" + NL + "        }" + NL + "        " + NL + "        Util_";
  protected final String TEXT_98 = " util_";
  protected final String TEXT_99 = " = new Util_";
  protected final String TEXT_100 = "();" + NL;
  protected final String TEXT_101 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();

List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {//1
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {//2
    
        String cid = node.getUniqueName();

        //get the input Main and Lookup connection
        IConnection inMainCon = null;
        IConnection inRefCon = null;   
        List< ? extends IConnection> connsIn = node.getIncomingConnections();     
        for (IConnection conn : connsIn) {//3
        	if (conn.getLineStyle().equals(EConnectionType.FLOW_MAIN)) {
        		inMainCon = conn;
        	}
        	else if(conn.getLineStyle().equals(EConnectionType.FLOW_REF))
        	{
        		inRefCon = conn;
        	}
        }//3


        String minNameOrigi = ElementParameterParser.getValue(node, "__LOOKUP_MIN__");
        String maxNameOrigi = ElementParameterParser.getValue(node, "__LOOKUP_MAX__");
        boolean minBounds = ("true").equals(ElementParameterParser.getValue(node, "__LOOKUP_MIN_BOUNDS__"));
        boolean maxBounds = ("true").equals(ElementParameterParser.getValue(node, "__LOOKUP_MAX_BOUNDS__"));
        String mainName = ElementParameterParser.getValue(node, "__MAIN_COLUMN__");
        String minName = minNameOrigi.substring(minNameOrigi.lastIndexOf('.')+1);
        String maxName = maxNameOrigi.substring(maxNameOrigi.lastIndexOf('.')+1);
        String lookupName = ElementParameterParser.getValue(node, "__LOOKUP_COLUMN__");
        String lookupConName = inRefCon.getName();
        String mainConName = inMainCon.getName();


        String returnClassName = "Object";
        JavaType mainjavaType = JavaTypesManager.STRING;
        String mainTypeName = null;
        String mainCanonicalTypeName = null;
        List<IMetadataColumn> columns = metadata.getListColumns();
        int sizeColumns = columns.size();			
        for (int i = 0; i < sizeColumns; i++) {//5
        
        	IMetadataColumn column = columns.get(i);
        	if(("LOOKUP").equals(column.getLabel())) 
        	{
            	returnClassName = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());    	
        	}
        	
        	if(column.getLabel().equals(mainName)) 
        	{
            	mainjavaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
            	mainTypeName = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
        	}
        }//5	
        
    stringBuffer.append(TEXT_1);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_2);
    stringBuffer.append(lookupConName );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(lookupConName );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(lookupConName );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(lookupConName );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(lookupConName );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(lookupConName );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(lookupConName );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(lookupConName );
    stringBuffer.append(TEXT_12);
    
                if(mainjavaType == JavaTypesManager.DATE) {
                    
    stringBuffer.append(TEXT_13);
    stringBuffer.append(minName);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(minName);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(maxName);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(maxName);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(minName);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(minName);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(maxName);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(maxName);
    stringBuffer.append(TEXT_19);
    
                } else if(mainjavaType == JavaTypesManager.BYTE || 
                        mainjavaType == JavaTypesManager.SHORT || 
                        mainjavaType == JavaTypesManager.FLOAT ||
                        mainjavaType == JavaTypesManager.DOUBLE ||
                        mainjavaType == JavaTypesManager.LONG ||
                        mainjavaType == JavaTypesManager.INTEGER){
                    
    stringBuffer.append(TEXT_20);
    stringBuffer.append(mainTypeName);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(minName);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(mainTypeName);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(maxName);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(mainTypeName);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(minName);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(mainTypeName);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(maxName);
    stringBuffer.append(TEXT_22);
    
                } else if(mainjavaType == JavaTypesManager.BYTE_ARRAY) {
                    
    stringBuffer.append(TEXT_26);
    stringBuffer.append(minName);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(minName);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(maxName);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(maxName);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(minName);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(minName);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(maxName);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(maxName);
    stringBuffer.append(TEXT_32);
    
                } else if(mainjavaType == JavaTypesManager.STRING) {
                    
    stringBuffer.append(TEXT_26);
    stringBuffer.append(minName);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(maxName);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(minName);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(maxName);
    stringBuffer.append(TEXT_36);
    
                } else {
                    
    stringBuffer.append(TEXT_37);
    stringBuffer.append(minName);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(maxName);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(minName);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(maxName);
    stringBuffer.append(TEXT_32);
    
                }
                
    stringBuffer.append(TEXT_41);
     
                if(mainjavaType == JavaTypesManager.DATE || 
                        mainjavaType == JavaTypesManager.BYTE || 
                        mainjavaType == JavaTypesManager.SHORT || 
                        mainjavaType == JavaTypesManager.FLOAT ||
                        mainjavaType == JavaTypesManager.DOUBLE ||
                        mainjavaType == JavaTypesManager.LONG ||
                        mainjavaType == JavaTypesManager.INTEGER){
                    if(("java.util.Date").equals(mainTypeName) || 
                            ("Byte").equals(mainTypeName) || 
                            ("Short").equals(mainTypeName) || 
                            ("Float").equals(mainTypeName) || 
                            ("Double").equals(mainTypeName) || 
                            ("Long").equals(mainTypeName) || 
                            ("Integer").equals(mainTypeName)) {
                        
    stringBuffer.append(TEXT_42);
    
                    } else {
                        
    stringBuffer.append(TEXT_43);
    
                    }
                } else {    
                    
    stringBuffer.append(TEXT_44);
    
                }
                
    stringBuffer.append(TEXT_45);
    stringBuffer.append(lookupConName );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(lookupConName );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(lookupConName );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(returnClassName);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(mainConName );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    
                String minEqual = minBounds ? "=" : "";
                String maxEqual = maxBounds ? "=" : "";
                
    stringBuffer.append(TEXT_56);
    
                    if(mainjavaType == JavaTypesManager.DATE) {
                        
    stringBuffer.append(TEXT_57);
    stringBuffer.append(mainName);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(mainName);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(minName);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(minName);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(maxName);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(maxName);
    stringBuffer.append(TEXT_19);
    
                    } else if(mainjavaType == JavaTypesManager.BYTE || 
                            mainjavaType == JavaTypesManager.SHORT || 
                            mainjavaType == JavaTypesManager.FLOAT ||
                            
                            mainjavaType == JavaTypesManager.DOUBLE ||
                            mainjavaType == JavaTypesManager.LONG ||
                            mainjavaType == JavaTypesManager.INTEGER) {
                        
    stringBuffer.append(TEXT_63);
    stringBuffer.append(mainTypeName);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(mainName);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(mainTypeName);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(minName);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(mainTypeName);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(maxName);
    stringBuffer.append(TEXT_22);
    
                    } else if(mainjavaType == JavaTypesManager.BYTE_ARRAY) {
                        
    stringBuffer.append(TEXT_67);
    stringBuffer.append(mainName);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(mainName);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(minName);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(minName);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(maxName);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(maxName);
    stringBuffer.append(TEXT_32);
    
                    } else if(mainjavaType == JavaTypesManager.STRING) {
                        
    stringBuffer.append(TEXT_67);
    stringBuffer.append(mainName);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(minName);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(maxName);
    stringBuffer.append(TEXT_22);
    
                    } else {
                        
    stringBuffer.append(TEXT_74);
    stringBuffer.append(mainName);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(minName);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(maxName);
    stringBuffer.append(TEXT_32);
    
                    }
                    
                    if (mainjavaType == JavaTypesManager.DATE || 
                            mainjavaType == JavaTypesManager.BYTE || 
                            mainjavaType == JavaTypesManager.SHORT || 
                            mainjavaType == JavaTypesManager.FLOAT ||
                            mainjavaType == JavaTypesManager.DOUBLE ||
                            mainjavaType == JavaTypesManager.LONG ||
                            mainjavaType == JavaTypesManager.INTEGER) {
                        if(("java.util.Date").equals(mainTypeName) || 
                                ("Byte").equals(mainTypeName) || 
                                ("Short").equals(mainTypeName) || 
                                ("Float").equals(mainTypeName) || 
                                ("Double").equals(mainTypeName) || 
                                ("Long").equals(mainTypeName) || 
                                ("Integer").equals(mainTypeName)) {
                            
    stringBuffer.append(TEXT_77);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(returnClassName));
    stringBuffer.append(TEXT_78);
    stringBuffer.append(maxEqual);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(minEqual);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(minEqual);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(maxEqual);
    stringBuffer.append(TEXT_82);
    
                        } else {
                            
    stringBuffer.append(TEXT_83);
    stringBuffer.append(minEqual);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(maxEqual);
    stringBuffer.append(TEXT_84);
    
                        }
                        
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(lookupName );
    stringBuffer.append(TEXT_22);
    
                    } else {
                        
    stringBuffer.append(TEXT_86);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(returnClassName));
    stringBuffer.append(TEXT_87);
    stringBuffer.append(maxEqual);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(minEqual);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(minEqual);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(maxEqual);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(lookupName );
    stringBuffer.append(TEXT_22);
    
                    }
                    
    stringBuffer.append(TEXT_92);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(returnClassName));
    stringBuffer.append(TEXT_93);
    
                        if (mainjavaType == JavaTypesManager.DATE || 
                                mainjavaType == JavaTypesManager.BYTE || 
                                mainjavaType == JavaTypesManager.SHORT || 
                                mainjavaType == JavaTypesManager.FLOAT ||
                                mainjavaType == JavaTypesManager.DOUBLE ||
                                mainjavaType == JavaTypesManager.LONG ||
                                mainjavaType == JavaTypesManager.INTEGER) {
                            if(("java.util.Date").equals(mainTypeName) || 
                                    ("Byte").equals(mainTypeName) || 
                                    ("Short").equals(mainTypeName) || 
                                    ("Float").equals(mainTypeName) || 
                                    ("Double").equals(mainTypeName) || 
                                    ("Long").equals(mainTypeName) || 
                                    ("Integer").equals(mainTypeName)) {
                                
    stringBuffer.append(TEXT_94);
    
                            } else {
                                
    stringBuffer.append(TEXT_95);
    
                            }
                        } else {
                            
    stringBuffer.append(TEXT_96);
    
                        }
                        
    stringBuffer.append(TEXT_97);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_98);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_99);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_100);
    
    }//2
}//1

    stringBuffer.append(TEXT_101);
    return stringBuffer.toString();
  }
}
