package org.talend.designer.codegen.translators.processing.fields;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TExtractPositionalFieldsBeginJava
{
  protected static String nl;
  public static synchronized TExtractPositionalFieldsBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TExtractPositionalFieldsBeginJava result = new TExtractPositionalFieldsBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "int nb_line_";
  protected final String TEXT_3 = "=0;";
  protected final String TEXT_4 = NL + "int[] sizes_";
  protected final String TEXT_5 = " =new int[]{";
  protected final String TEXT_6 = NL + "\t";
  protected final String TEXT_7 = ",";
  protected final String TEXT_8 = NL + "\t};";
  protected final String TEXT_9 = NL + "\tString pattern_";
  protected final String TEXT_10 = " = ";
  protected final String TEXT_11 = ";" + NL + "\tString[] ptnSplit_";
  protected final String TEXT_12 = " = pattern_";
  protected final String TEXT_13 = ".split(\",\");" + NL + "\tint[] sizes_";
  protected final String TEXT_14 = " = new int[ptnSplit_";
  protected final String TEXT_15 = ".length];" + NL + "\tfor(int i_";
  protected final String TEXT_16 = "=0;i_";
  protected final String TEXT_17 = "<ptnSplit_";
  protected final String TEXT_18 = ".length;i_";
  protected final String TEXT_19 = "++){" + NL + "\t\tif((\"*\").equals(ptnSplit_";
  protected final String TEXT_20 = "[i_";
  protected final String TEXT_21 = "])){" + NL + "\t\t\t sizes_";
  protected final String TEXT_22 = "]=-1;" + NL + "\t \t}else{" + NL + "\t \t\t sizes_";
  protected final String TEXT_23 = "]=Integer.valueOf(ptnSplit_";
  protected final String TEXT_24 = "]);" + NL + "\t \t}" + NL + "\t}";
  protected final String TEXT_25 = NL + "int[] indexs_";
  protected final String TEXT_26 = " = new int[sizes_";
  protected final String TEXT_27 = ".length];" + NL + "for(int i_";
  protected final String TEXT_28 = "<indexs_";
  protected final String TEXT_29 = "++){" + NL + "\tif(sizes_";
  protected final String TEXT_30 = "]==-1){" + NL + "\t\tindexs_";
  protected final String TEXT_31 = "]=-1;" + NL + "\t}else{" + NL + "\t\tif(i_";
  protected final String TEXT_32 = "-1>=0){" + NL + "\t\t\tindexs_";
  protected final String TEXT_33 = "]= indexs_";
  protected final String TEXT_34 = "-1]+sizes_";
  protected final String TEXT_35 = "];" + NL + "\t\t}else{" + NL + "\t\t\tindexs_";
  protected final String TEXT_36 = "]= sizes_";
  protected final String TEXT_37 = "];" + NL + "\t\t}" + NL + "\t}" + NL + "}";
  protected final String TEXT_38 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

String pattern = ElementParameterParser.getValue(node, "__PATTERN__");
boolean advanced = ("true").equals(ElementParameterParser.getValue(node, "__ADVANCED_OPTION__"));
List<Map<String, String>> formats =
	(List<Map<String,String>>)ElementParameterParser.getObjectValue( node, "__FORMATS__");

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
if(advanced){

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
	for(int i=0;i<formats.size();i++){
		Map<String,String> tmp = formats.get(i);
		if(("*").equals(tmp.get("SIZE"))){

    stringBuffer.append(TEXT_6);
    stringBuffer.append(-1);
    
		}else{

    stringBuffer.append(TEXT_6);
    stringBuffer.append(Integer.valueOf(tmp.get("SIZE")));
    stringBuffer.append(TEXT_7);
    
		}
	}

    stringBuffer.append(TEXT_8);
    
}else{

    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(pattern);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    
}

    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(TEXT_38);
    return stringBuffer.toString();
  }
}
