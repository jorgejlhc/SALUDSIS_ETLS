package org.talend.designer.codegen.translators.file.input;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;
import java.util.Map;
import org.talend.core.model.process.IProcess;

public class TFileInputDelimitedBeginJava
{
  protected static String nl;
  public static synchronized TFileInputDelimitedBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileInputDelimitedBeginJava result = new TFileInputDelimitedBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + "\t";
  protected final String TEXT_3 = NL + "\t\t\trowHelper_";
  protected final String TEXT_4 = ".valueToConn(";
  protected final String TEXT_5 = ", ";
  protected final String TEXT_6 = " ";
  protected final String TEXT_7 = ");" + NL + "\t\t";
  protected final String TEXT_8 = ".valueToConnWithD(";
  protected final String TEXT_9 = ".connToConn(";
  protected final String TEXT_10 = ",";
  protected final String TEXT_11 = NL + "\t\t\t\tclass RowHelper_";
  protected final String TEXT_12 = "{" + NL + "\t\t\t\t";
  protected final String TEXT_13 = NL + "\t\t\t\t\tpublic void valueToConn_";
  protected final String TEXT_14 = "(";
  protected final String TEXT_15 = "Struct ";
  protected final String TEXT_16 = ") throws java.lang.Exception{" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_17 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_18 = NL + "\t\t\t\t\tpublic void valueToConnWithD_";
  protected final String TEXT_19 = ", routines.system.Dynamic ";
  protected final String TEXT_20 = NL + "\t\t\t\t\tpublic void connToConn_";
  protected final String TEXT_21 = NL + "\t\t\t\t\tpublic void valueToConn(";
  protected final String TEXT_22 = ") throws java.lang.Exception{" + NL + "\t\t\t\t";
  protected final String TEXT_23 = NL + "\t\t\t\t\tpublic void valueToConnWithD(";
  protected final String TEXT_24 = NL + "\t\t\t\t\t\tvalueToConn_";
  protected final String TEXT_25 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_26 = NL + "\t\t\t\t\t\tvalueToConnWithD_";
  protected final String TEXT_27 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_28 = NL + "\t\t\t\t\tpublic void connToConn(";
  protected final String TEXT_29 = ") throws java.lang.Exception{" + NL + "\t\t\t\t\t";
  protected final String TEXT_30 = NL + "\t\t\t\t\t\tconnToConn_";
  protected final String TEXT_31 = ");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_32 = NL + "\t\t\t\t}" + NL + "\t\t\t\tRowHelper_";
  protected final String TEXT_33 = " rowHelper_";
  protected final String TEXT_34 = "  = new RowHelper_";
  protected final String TEXT_35 = "();" + NL + "\t\t\t";
  protected final String TEXT_36 = NL + "\t";
  protected final String TEXT_37 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_38 = " - Retrieving records from the datasource.\");" + NL + "\t\t\t";
  protected final String TEXT_39 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_40 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_41 = " - Retrieved records count: \"+ globalMap.get(\"";
  protected final String TEXT_42 = "_NB_LINE\") + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_43 = " - Written records count: \" + nb_line_";
  protected final String TEXT_44 = NL + "\t\t\t\tfinal StringBuffer log4jSb_";
  protected final String TEXT_45 = " = new StringBuffer();" + NL + "\t\t\t";
  protected final String TEXT_46 = " - Retrieving the record \" + (nb_line_";
  protected final String TEXT_47 = ") + \".\");" + NL + "\t\t\t";
  protected final String TEXT_48 = " - Writing the record \" + nb_line_";
  protected final String TEXT_49 = " + \" to the file.\");" + NL + "\t\t\t";
  protected final String TEXT_50 = " - Processing the record \" + nb_line_";
  protected final String TEXT_51 = " + \".\");" + NL + "\t\t\t";
  protected final String TEXT_52 = " - Processed records count: \" + nb_line_";
  protected final String TEXT_53 = NL + "                log.error(message_";
  protected final String TEXT_54 = ");";
  protected final String TEXT_55 = NL + "                System.err.println(message_";
  protected final String TEXT_56 = NL + " " + NL + "\t";
  protected final String TEXT_57 = NL + "\t\t\tif(isFirstCheckDyn_";
  protected final String TEXT_58 = "){// for the header line" + NL + "\t\t\t\t";
  protected final String TEXT_59 = NL + "\t\t\t\tdynamic_";
  protected final String TEXT_60 = " = (routines.system.Dynamic)globalMap.get(\"";
  protected final String TEXT_61 = "\");" + NL + "\t\t\t\tisFirstCheckDyn_";
  protected final String TEXT_62 = " = false;" + NL + "\t\t\t\t";
  protected final String TEXT_63 = NL + "\t\t\t\t\t\tint colsLen_";
  protected final String TEXT_64 = " = row";
  protected final String TEXT_65 = ".length;" + NL + "\t\t\t\t\t";
  protected final String TEXT_66 = " = fid_";
  protected final String TEXT_67 = ".getColumnsCountOfCurrentRow();" + NL + "\t\t\t\t\t";
  protected final String TEXT_68 = NL + "\t\t\t\t\t\tfor (int i = ";
  protected final String TEXT_69 = "; i < colsLen_";
  protected final String TEXT_70 = "-";
  protected final String TEXT_71 = "; i++) {" + NL + "\t\t\t\t\t\t\troutines.system.DynamicMetadata dynamicMetadata_";
  protected final String TEXT_72 = " = new routines.system.DynamicMetadata();" + NL + "\t\t\t\t\t\t\tif(";
  protected final String TEXT_73 = ") {" + NL + "\t\t\t\t\t\t\t\tdynamicMetadata_";
  protected final String TEXT_74 = ".setName(";
  protected final String TEXT_75 = "row";
  protected final String TEXT_76 = "[i]";
  protected final String TEXT_77 = "fid_";
  protected final String TEXT_78 = ".get(i)";
  protected final String TEXT_79 = ");" + NL + "\t\t\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t\t\tdynamicMetadata_";
  protected final String TEXT_80 = ".replaceAll(\"[ .-]+\", \"_\"));" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\tdynamicMetadata_";
  protected final String TEXT_81 = ".setDbName(dynamicMetadata_";
  protected final String TEXT_82 = ".getName());" + NL + "\t\t\t\t\t\t\tdynamicMetadata_";
  protected final String TEXT_83 = ".setType(\"id_String\");" + NL + "\t\t\t\t\t\t\tdynamicMetadata_";
  protected final String TEXT_84 = ".setDbType(\"VARCHAR\");" + NL + "\t\t\t\t\t\t\tdynamicMetadata_";
  protected final String TEXT_85 = ".setLength(";
  protected final String TEXT_86 = ");" + NL + "\t\t\t\t\t\t\tdynamicMetadata_";
  protected final String TEXT_87 = ".setPrecision(0);" + NL + "\t\t\t\t\t\t\tdynamicMetadata_";
  protected final String TEXT_88 = ".setNullable(true);" + NL + "\t\t\t\t\t\t\tdynamicMetadata_";
  protected final String TEXT_89 = ".setKey(false);" + NL + "\t\t\t\t\t\t\tdynamicMetadata_";
  protected final String TEXT_90 = ".setSourceType(routines.system.DynamicMetadata.sourceTypes.demilitedFile);" + NL + "\t\t\t\t\t\t\tdynamicMetadata_";
  protected final String TEXT_91 = ".setColumnPosition(i);" + NL + "\t\t\t\t\t\t\tdynamic_";
  protected final String TEXT_92 = ".metadatas.add(dynamicMetadata_";
  protected final String TEXT_93 = ");" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t" + NL + "\t\t\t\t\t\tisFirstCheckDyn_";
  protected final String TEXT_94 = " = false;" + NL + "\t\t\t\t\t\tcontinue;" + NL + "\t\t\t\t";
  protected final String TEXT_95 = NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_96 = NL + "\t\t\tint footer_value_";
  protected final String TEXT_97 = " = ";
  protected final String TEXT_98 = ", random_value_";
  protected final String TEXT_99 = ";" + NL + "\t\t\tif(footer_value_";
  protected final String TEXT_100 = " >0 || random_value_";
  protected final String TEXT_101 = " > 0){" + NL + "\t\t\t\tthrow new java.lang.Exception(\"When the input source is a stream,footer and random shouldn't be bigger than 0.\");\t\t\t\t" + NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_102 = " > 0){" + NL + "\t\t\t\tthrow new java.lang.Exception(\"When the input source is a stream,footer shouldn't be bigger than 0.\");" + NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_103 = NL + "\t" + NL + "\tfinal routines.system.RowState rowstate_";
  protected final String TEXT_104 = " = new routines.system.RowState();" + NL + "\t" + NL + "\t";
  protected final String TEXT_105 = NL + "\t\t\t\tint dynamic_column_count_";
  protected final String TEXT_106 = "=";
  protected final String TEXT_107 = ".getColumnCount()";
  protected final String TEXT_108 = "1";
  protected final String TEXT_109 = ";" + NL + "\t\t\t\t";
  protected final String TEXT_110 = NL + "\t\t\t\tint columnIndexWithD_";
  protected final String TEXT_111 = " = 0;" + NL + "\t\t\t\t";
  protected final String TEXT_112 = NL + "\t\t\t\t\tString temp = \"\"; " + NL + "\t\t\t\t";
  protected final String TEXT_113 = NL + "\t\t\t\t\tcolumnIndexWithD_";
  protected final String TEXT_114 = "+dynamic_column_count_";
  protected final String TEXT_115 = ";" + NL + "\t\t\t\t\t";
  protected final String TEXT_116 = NL + "\t\t\t\t\t\t\ttemp  = ";
  protected final String TEXT_117 = ".get(columnIndexWithD_";
  protected final String TEXT_118 = ")";
  protected final String TEXT_119 = ";" + NL + "\t\t\t\t\t\t\tif(temp.length() > 0){" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_120 = ".";
  protected final String TEXT_121 = " = temp;" + NL + "\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_122 = ";" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_123 = NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_124 = ";" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_125 = NL + "\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_126 = ".copyMetadata();" + NL + "\t\t\t\t\t\t" + NL + "\t\t\t\t\t\tint fieldCount = ";
  protected final String TEXT_127 = ".getColumnsCountOfCurrentRow();" + NL + "\t\t\t\t\t\tdynamic_column_count_";
  protected final String TEXT_128 = ".getColumnCount();" + NL + "\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_129 = NL + "\t\t\t\t\t\tfor (int i = 0; i < dynamic_column_count_";
  protected final String TEXT_130 = "; i++) {" + NL + "\t\t\t\t\t\t\tif ((";
  protected final String TEXT_131 = "+i) < fieldCount){" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_132 = ".addColumnValue(";
  protected final String TEXT_133 = ".get(";
  protected final String TEXT_134 = "+i)";
  protected final String TEXT_135 = ");" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\telse{" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_136 = ".addColumnValue(\"\");" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_137 = NL + "\t\t\t\t\t\tint maxColumnNumberInDynamicColumn_";
  protected final String TEXT_138 = " = fieldCount - ";
  protected final String TEXT_139 = ";" + NL + "\t\t\t\t\t\tfor (int i = 0; i < dynamic_column_count_";
  protected final String TEXT_140 = "; i++) {" + NL + "\t\t\t\t\t\t\tObject v_";
  protected final String TEXT_141 = " = null;" + NL + "\t\t\t\t\t\t\tfinal routines.system.DynamicMetadata dynamicMetadata_";
  protected final String TEXT_142 = ".getColumnMetadata(i);" + NL + "\t\t\t\t\t\t\tif ((";
  protected final String TEXT_143 = "+i) < fieldCount && i < maxColumnNumberInDynamicColumn_";
  protected final String TEXT_144 = "){";
  protected final String TEXT_145 = NL + "\t\t\t\t\t\t\t\tfinal String tempValue_";
  protected final String TEXT_146 = ";" + NL + "\t\t\t\t\t\t\t\tfinal String separator_";
  protected final String TEXT_147 = ";" + NL + "\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_148 = NL + NL + "\t\tif(!tempValue_";
  protected final String TEXT_149 = ".isEmpty()) {" + NL + "\t\t\ttry {" + NL + "\t\t\t\tswitch(dynamicMetadata_";
  protected final String TEXT_150 = ".getType()) {" + NL + "\t\t\t\t\tcase \"id_String\":" + NL + "\t\t\t\t\tcase \"id_Object\":" + NL + "\t\t\t\t\t\tv_";
  protected final String TEXT_151 = " = tempValue_";
  protected final String TEXT_152 = ";" + NL + "\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\tcase \"id_Integer\":" + NL + "\t\t\t\t\t\tif(dynamicMetadata_";
  protected final String TEXT_153 = ".isNullable()) {" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_154 = NL + "\t\t\t\t\t\t\tv_";
  protected final String TEXT_155 = " = ParserUtils.parseTo_Integer(ParserUtils.parseTo_Number(tempValue_";
  protected final String TEXT_156 = "));" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_157 = " = ParserUtils.parseTo_Integer(tempValue_";
  protected final String TEXT_158 = ");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_159 = NL + "\t\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_160 = " = ParserUtils.parseTo_int(ParserUtils.parseTo_Number(tempValue_";
  protected final String TEXT_161 = " = ParserUtils.parseTo_int(tempValue_";
  protected final String TEXT_162 = NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\tcase \"id_Long\":" + NL + "\t\t\t\t\t\tif(dynamicMetadata_";
  protected final String TEXT_163 = " = ParserUtils.parseTo_Long(ParserUtils.parseTo_Number(tempValue_";
  protected final String TEXT_164 = " = ParserUtils.parseTo_Long(tempValue_";
  protected final String TEXT_165 = " = ParserUtils.parseTo_long(ParserUtils.parseTo_Number(tempValue_";
  protected final String TEXT_166 = " = ParserUtils.parseTo_long(tempValue_";
  protected final String TEXT_167 = NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\tcase \"id_Short\":" + NL + "\t\t\t\t\t\tif(dynamicMetadata_";
  protected final String TEXT_168 = " = ParserUtils.parseTo_Short(ParserUtils.parseTo_Number(tempValue_";
  protected final String TEXT_169 = " = ParserUtils.parseTo_Short(tempValue_";
  protected final String TEXT_170 = " = ParserUtils.parseTo_short(ParserUtils.parseTo_Number(tempValue_";
  protected final String TEXT_171 = " = ParserUtils.parseTo_short(tempValue_";
  protected final String TEXT_172 = NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\tcase \"id_Byte\":" + NL + "\t\t\t\t\t\tif(dynamicMetadata_";
  protected final String TEXT_173 = " = ParserUtils.parseTo_Byte(ParserUtils.parseTo_Number(tempValue_";
  protected final String TEXT_174 = " = ParserUtils.parseTo_Byte(tempValue_";
  protected final String TEXT_175 = " = ParserUtils.parseTo_byte(ParserUtils.parseTo_Number(tempValue_";
  protected final String TEXT_176 = " = ParserUtils.parseTo_byte(tempValue_";
  protected final String TEXT_177 = NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\tcase \"id_Date\":" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_178 = NL + "\t\t\t\t\t\tv_";
  protected final String TEXT_179 = " = ParserUtils.parseTo_Date(tempValue_";
  protected final String TEXT_180 = ", dynamicMetadata_";
  protected final String TEXT_181 = ".getFormat()==null ? ";
  protected final String TEXT_182 = " : dynamicMetadata_";
  protected final String TEXT_183 = ".getFormat(), false);" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_184 = ".getFormat());" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_185 = NL + "\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\tcase \"id_List\":" + NL + "\t\t\t\t\t\tv_";
  protected final String TEXT_186 = " = ParserUtils.parseTo_List(tempValue_";
  protected final String TEXT_187 = ", separator_";
  protected final String TEXT_188 = ");" + NL + "\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\tcase \"id_BigDecimal\":" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_189 = " = ParserUtils.parseTo_BigDecimal(ParserUtils.parseTo_Number(tempValue_";
  protected final String TEXT_190 = "));" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_191 = " = ParserUtils.parseTo_BigDecimal(tempValue_";
  protected final String TEXT_192 = ");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_193 = NL + "\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\tcase \"id_Double\":" + NL + "\t\t\t\t\t\tif(dynamicMetadata_";
  protected final String TEXT_194 = " = ParserUtils.parseTo_Double(ParserUtils.parseTo_Number(tempValue_";
  protected final String TEXT_195 = " = ParserUtils.parseTo_Double(tempValue_";
  protected final String TEXT_196 = " = ParserUtils.parseTo_double(ParserUtils.parseTo_Number(tempValue_";
  protected final String TEXT_197 = " = ParserUtils.parseTo_double(tempValue_";
  protected final String TEXT_198 = NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\tcase \"id_Float\":" + NL + "\t\t\t\t\t\tif(dynamicMetadata_";
  protected final String TEXT_199 = " = ParserUtils.parseTo_Float(ParserUtils.parseTo_Number(tempValue_";
  protected final String TEXT_200 = " = ParserUtils.parseTo_Float(tempValue_";
  protected final String TEXT_201 = " = ParserUtils.parseTo_float(ParserUtils.parseTo_Number(tempValue_";
  protected final String TEXT_202 = " = ParserUtils.parseTo_float(tempValue_";
  protected final String TEXT_203 = NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\tcase \"id_Boolean\":" + NL + "\t\t\t\t\t\tif(dynamicMetadata_";
  protected final String TEXT_204 = ".isNullable()) {" + NL + "\t\t\t\t\t\t\tv_";
  protected final String TEXT_205 = " = ParserUtils.parseTo_Boolean(tempValue_";
  protected final String TEXT_206 = ");" + NL + "\t\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t\tv_";
  protected final String TEXT_207 = " = ParserUtils.parseTo_boolean(tempValue_";
  protected final String TEXT_208 = ");" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\tcase \"id_Character\":" + NL + "\t\t\t\t\t\tif(dynamicMetadata_";
  protected final String TEXT_209 = " = ParserUtils.parseTo_Character(tempValue_";
  protected final String TEXT_210 = " = ParserUtils.parseTo_char(tempValue_";
  protected final String TEXT_211 = ");" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\tcase \"id_byte[]\":" + NL + "\t\t\t\t\t\tv_";
  protected final String TEXT_212 = ".getBytes(";
  protected final String TEXT_213 = ");" + NL + "\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\tdefault:" + NL + "\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t}" + NL + "\t\t\t} catch (java.lang.Exception ex_";
  protected final String TEXT_214 = ") {" + NL + "\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_215 = "_ERROR_MESSAGE\",ex_";
  protected final String TEXT_216 = ".getMessage());" + NL + "\t\t\t\trowstate_";
  protected final String TEXT_217 = ".setException(new RuntimeException(String.format(\"Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s\"," + NL + "\t\t\t\t\t\"";
  protected final String TEXT_218 = "\", \"";
  protected final String TEXT_219 = "\", tempValue_";
  protected final String TEXT_220 = ", ex_";
  protected final String TEXT_221 = "), ex_";
  protected final String TEXT_222 = "));" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_223 = NL + "\t" + NL + "\tif((v_";
  protected final String TEXT_224 = " == null) && (rowstate_";
  protected final String TEXT_225 = ".getException()==null)) {" + NL + "\t\tswitch(dynamicMetadata_";
  protected final String TEXT_226 = ".getType()) {" + NL + "\t\t\tcase \"id_String\":" + NL + "\t\t\tcase \"id_Object\":" + NL + "\t\t\t\tv_";
  protected final String TEXT_227 = " = \"\";" + NL + "\t\t\t\tbreak;" + NL + "\t\t\tcase \"id_Integer\":" + NL + "\t\t\t\tif(!dynamicMetadata_";
  protected final String TEXT_228 = ".isNullable()) v_";
  protected final String TEXT_229 = " = Integer.valueOf(\"0\");" + NL + "\t\t\t\tbreak;" + NL + "\t\t\tcase \"id_Long\":" + NL + "\t\t\t\tif(!dynamicMetadata_";
  protected final String TEXT_230 = " = Long.valueOf(\"0\");" + NL + "\t\t\t\tbreak;" + NL + "\t\t\tcase \"id_Short\":" + NL + "\t\t\t\tif(!dynamicMetadata_";
  protected final String TEXT_231 = " = Short.valueOf(\"0\");" + NL + "\t\t\t\tbreak;" + NL + "\t\t\tcase \"id_Byte\":" + NL + "\t\t\t\tif(!dynamicMetadata_";
  protected final String TEXT_232 = " = Byte.valueOf(\"0\");" + NL + "\t\t\t\tbreak;" + NL + "\t\t\tcase \"id_Double\":" + NL + "\t\t\t\tif(!dynamicMetadata_";
  protected final String TEXT_233 = " = Double.valueOf(\"0\");" + NL + "\t\t\t\tbreak;" + NL + "\t\t\tcase \"id_Float\":" + NL + "\t\t\t\tif(!dynamicMetadata_";
  protected final String TEXT_234 = " = Float.valueOf(\"0\");" + NL + "\t\t\t\tbreak;" + NL + "\t\t\tcase \"id_Boolean\":" + NL + "\t\t\t\tif(!dynamicMetadata_";
  protected final String TEXT_235 = " = false;" + NL + "\t\t\tcase \"id_Character\":" + NL + "\t\t\t\tif(!dynamicMetadata_";
  protected final String TEXT_236 = " = ' ';" + NL + "\t\t\tdefault:" + NL + "\t\t\t\tbreak;" + NL + "\t\t}" + NL + "\t}" + NL + "\t" + NL + "\t";
  protected final String TEXT_237 = ".addColumnValue(v_";
  protected final String TEXT_238 = ");" + NL + "\t\t\t\t\t\t}" + NL + "" + NL + "\t\t\t\t\t\tdynamic_column_count_";
  protected final String TEXT_239 = " = maxColumnNumberInDynamicColumn_";
  protected final String TEXT_240 = NL + "\t\t\t\t\t";
  protected final String TEXT_241 = NL + "\t\t\t\t\t\ttemp = ";
  protected final String TEXT_242 = ";" + NL + "\t\t\t\t\t\tif(temp.length() > 0) {" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_243 = NL + "\t\t\t\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_244 = NL + "    \t\t\t\t\t\t\t\t";
  protected final String TEXT_245 = " = temp.getBytes(";
  protected final String TEXT_246 = ");" + NL + "    \t\t\t\t\t\t\t";
  protected final String TEXT_247 = NL + "                                    ";
  protected final String TEXT_248 = " = ParserUtils.parseTo_List(temp, ";
  protected final String TEXT_249 = NL + "    \t\t\t\t\t\t\t\t\t";
  protected final String TEXT_250 = " = ParserUtils.parseTo_Date(temp, ";
  protected final String TEXT_251 = ", false);" + NL + "    \t\t\t\t\t\t\t\t";
  protected final String TEXT_252 = ");" + NL + "    \t\t\t\t\t\t\t\t";
  protected final String TEXT_253 = " = ParserUtils.parseTo_";
  protected final String TEXT_254 = "(ParserUtils.parseTo_Number(temp, ";
  protected final String TEXT_255 = "));" + NL + "    \t\t\t\t\t\t\t";
  protected final String TEXT_256 = "(temp";
  protected final String TEXT_257 = "(temp);" + NL + "    \t\t\t\t\t\t\t";
  protected final String TEXT_258 = NL + "    \t\t\t\t\t\t\t} catch(java.lang.Exception ex_";
  protected final String TEXT_259 = ") {" + NL + "globalMap.put(\"";
  protected final String TEXT_260 = ".getMessage());" + NL + "\t\t\t\t\t\t\t\t\trowstate_";
  protected final String TEXT_261 = ".setException(new RuntimeException(String.format(\"Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s\"," + NL + "\t\t\t\t\t\t\t\t\t\t\"";
  protected final String TEXT_262 = "\", temp, ex_";
  protected final String TEXT_263 = "));" + NL + "\t\t\t\t\t\t\t\t}" + NL + "    \t\t\t\t\t\t\t";
  protected final String TEXT_264 = NL + "\t\t\t\t\t\t} else {\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_265 = NL + "\t\t\t\t\t\t\t\trowstate_";
  protected final String TEXT_266 = ".setException(new RuntimeException(\"Value is empty for column : '";
  protected final String TEXT_267 = "' in '";
  protected final String TEXT_268 = "' connection, value is invalid or this column should be nullable or have a default value.\"));" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_269 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_270 = NL + "\t\t\t\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_271 = ";" + NL + "\t\t\t\t\t\t\t\t} catch(java.lang.Exception ex_";
  protected final String TEXT_272 = ".setException(new RuntimeException(String.format(\"Couldn't set default value for column '%s' in '%s'. Details: %s\"," + NL + "\t\t\t\t\t\t\t\t\t\t\"";
  protected final String TEXT_273 = "\", ex_";
  protected final String TEXT_274 = "));" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_275 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_276 = ";" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_277 = NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_278 = NL + "\t\t\t\t";
  protected final String TEXT_279 = NL + "\t\t\t\t \tint filedsum = ";
  protected final String TEXT_280 = ".getColumnsCountOfCurrentRow();" + NL + "\t\t\t\t \tif(filedsum < (";
  protected final String TEXT_281 = "+ dynamic_column_count_";
  protected final String TEXT_282 = " -1";
  protected final String TEXT_283 = ")){" + NL + "\t\t\t\t\t \tthrow new RuntimeException(\"Column(s) missing\");" + NL + "\t\t\t\t\t } else if(filedsum > (";
  protected final String TEXT_284 = ")) {" + NL + "\t\t\t\t\t \tthrow new RuntimeException(\"Too many columns\");" + NL + "\t\t\t\t\t }     " + NL + "\t\t\t\t";
  protected final String TEXT_285 = NL + "    \t\t\t\t";
  protected final String TEXT_286 = NL + "\t\t\t";
  protected final String TEXT_287 = NL + "\t\t\t\t\t\t\tboolean isFirstCheckDyn_";
  protected final String TEXT_288 = " = true;" + NL + "\t\t\t\t\t\t\troutines.system.Dynamic dynamic_";
  protected final String TEXT_289 = " = new routines.system.Dynamic();" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_290 = NL + "\t\t\t\tint nb_line_";
  protected final String TEXT_291 = " = 0;" + NL + "\t\t\t\torg.talend.fileprocess.FileInputDelimited fid_";
  protected final String TEXT_292 = " = null;" + NL + "\t\t\t\tint limit_";
  protected final String TEXT_293 = ";" + NL + "\t\t\t\ttry{" + NL + "\t\t\t\t\t";
  protected final String TEXT_294 = NL + "\t\t\t\t\t\tObject filename_";
  protected final String TEXT_295 = ";\t" + NL + "\t\t\t\t\t\tjava.util.zip.ZipInputStream zis_";
  protected final String TEXT_296 = " = null;" + NL + "\t\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\t\tif(filename_";
  protected final String TEXT_297 = " instanceof java.io.InputStream){" + NL + "\t\t\t\t\t\t\t\tzis_";
  protected final String TEXT_298 = " = new java.util.zip.ZipInputStream(new java.io.BufferedInputStream((java.io.InputStream)filename_";
  protected final String TEXT_299 = "));" + NL + "\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\t\tzis_";
  protected final String TEXT_300 = " = new java.util.zip.ZipInputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(String.valueOf(filename_";
  protected final String TEXT_301 = "))));" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t} catch(java.lang.Exception e) {" + NL + "globalMap.put(\"";
  protected final String TEXT_302 = "_ERROR_MESSAGE\",e.getMessage());" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_303 = NL + "\t\t\t\t\t\t\t\tthrow e;" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_304 = NL + "\t\t\t\t\t\t\t\t\tlog.error(\"";
  protected final String TEXT_305 = " - \" +e.getMessage());" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_306 = NL + "\t\t\t\t\t\t\t\tSystem.err.println(e.getMessage());" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_307 = NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tjava.util.zip.ZipEntry entry_";
  protected final String TEXT_308 = " = null;" + NL + "\t\t" + NL + "\t\t\t\t\t\twhile (true) {" + NL + "\t\t\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\t\t\tentry_";
  protected final String TEXT_309 = " = zis_";
  protected final String TEXT_310 = ".getNextEntry();" + NL + "\t\t\t\t\t\t\t} catch(java.lang.Exception e) {" + NL + "globalMap.put(\"";
  protected final String TEXT_311 = "_ERROR_MESSAGE\",e.getMessage());" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_312 = NL + "\t\t\t\t\t\t\t\t\tthrow e;" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_313 = NL + "\t\t\t\t\t\t\t\t\t\tlog.error(\"";
  protected final String TEXT_314 = " - \" +e.getMessage());" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_315 = NL + "\t\t\t\t\t\t\t\t\tSystem.err.println(e.getMessage());" + NL + "\t\t\t\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_316 = NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\tif(entry_";
  protected final String TEXT_317 = " == null) {" + NL + "\t\t\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\tif(entry_";
  protected final String TEXT_318 = ".isDirectory()){ //directory" + NL + "\t\t\t\t\t\t\t\tcontinue;" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\t\t\tfid_";
  protected final String TEXT_319 = " = new org.talend.fileprocess.FileInputDelimited(zis_";
  protected final String TEXT_320 = "," + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_321 = NL + "\t\t\t\t\t\t\t\t\t(limit_";
  protected final String TEXT_322 = " > 0) ? limit_";
  protected final String TEXT_323 = "+1 : limit_";
  protected final String TEXT_324 = NL + "\t\t\t\t\t\t\t\t\tlimit_";
  protected final String TEXT_325 = ");" + NL + "\t\t\t\t\t\t\t} catch(java.lang.Exception e) {" + NL + "globalMap.put(\"";
  protected final String TEXT_326 = NL + "\t\t\t\t\t\t\t\t\tSystem.err.println(e.getMessage());" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_327 = NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_328 = ";" + NL + "\t\t\t\t\t\tif(filename_";
  protected final String TEXT_329 = " instanceof java.io.InputStream){" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_330 = NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\t\tfid_";
  protected final String TEXT_331 = " = new org.talend.fileprocess.FileInputDelimited(";
  protected final String TEXT_332 = ");" + NL + "\t\t\t\t\t\t} catch(java.lang.Exception e) {" + NL + "globalMap.put(\"";
  protected final String TEXT_333 = NL + "\t\t\t\t    ";
  protected final String TEXT_334 = NL + "\t\t\t\t    \tlog.info(\"";
  protected final String TEXT_335 = " - Retrieving records from the datasource.\");" + NL + "\t\t\t\t    ";
  protected final String TEXT_336 = NL + "\t\t\t\t\twhile (fid_";
  protected final String TEXT_337 = "!=null && fid_";
  protected final String TEXT_338 = ".nextRecord()) {" + NL + "\t\t\t\t\t\trowstate_";
  protected final String TEXT_339 = ".reset();" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_340 = NL + "\t\t\t    \t\t\t\t\t\t";
  protected final String TEXT_341 = " = null;\t\t\t" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_342 = "\t\t\t" + NL + "\t\t\t\t\t\t\t\t\tboolean whetherReject_";
  protected final String TEXT_343 = " = false;" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_344 = " = new ";
  protected final String TEXT_345 = "Struct();" + NL + "\t\t\t\t\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_346 = NL + "\t\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t\t\tif(rowstate_";
  protected final String TEXT_347 = ".getException()!=null) {" + NL + "\t\t\t\t\t\t\t\t\t\t\tthrow rowstate_";
  protected final String TEXT_348 = ".getException();" + NL + "\t\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_349 = " " + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_350 = " = null; " + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_351 = NL + "\t\t\t\t\t\t\t" + NL + "\t\t\t    \t\t\t\t\t} catch (java.lang.Exception e) {" + NL + "globalMap.put(\"";
  protected final String TEXT_352 = "_ERROR_MESSAGE\",e.getMessage());" + NL + "\t\t\t        \t\t\t\t\twhetherReject_";
  protected final String TEXT_353 = " = true;" + NL + "\t\t\t        \t\t\t\t\t";
  protected final String TEXT_354 = NL + "\t\t\t            \t\t\t\t\tthrow(e);" + NL + "\t\t\t            \t\t\t\t";
  protected final String TEXT_355 = NL + "\t\t\t\t\t\t\t\t\t\t\t\tlog.error(\"";
  protected final String TEXT_356 = " - \" +e.getMessage());" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_357 = "                    " + NL + "\t\t\t                    \t\t\t\t";
  protected final String TEXT_358 = "Struct();" + NL + "\t\t\t\t                \t\t\t\t";
  protected final String TEXT_359 = NL + "\t\t\t\t                \t\t\t\t";
  protected final String TEXT_360 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_361 = ";" + NL + "\t\t\t                \t\t\t\t\t";
  protected final String TEXT_362 = " = null;" + NL + "\t\t\t                \t\t\t\t";
  protected final String TEXT_363 = NL + "\t\t\t                \t\t\t\t\tSystem.err.println(e.getMessage());" + NL + "\t\t\t                \t\t\t\t\t";
  protected final String TEXT_364 = NL + "\t\t\t            \t\t\t\t\t\t";
  protected final String TEXT_365 = ";" + NL + "\t\t\t            \t\t\t\t\t";
  protected final String TEXT_366 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_367 = NL + "\t\t\t    \t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_368 = NL + "\t\t\t\t\t\t\t\t\t\t\tif(!whetherReject_";
  protected final String TEXT_369 = ") { " + NL + "\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_370 = "      " + NL + "\t\t\t             \t\t\t\tif(";
  protected final String TEXT_371 = " == null){ " + NL + "\t\t\t            \t \t\t\t\t";
  protected final String TEXT_372 = "Struct();" + NL + "\t\t\t             \t\t\t\t}\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_373 = " " + NL + "\t\t\t\t\t\t\t\t\t} " + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_374 = NL + "\t\t\tlog.debug(\"";
  protected final String TEXT_375 = " - Retrieving the record \" + fid_";
  protected final String TEXT_376 = ".getRowNumber() + \".\");" + NL + "\t\t";
  protected final String TEXT_377 = "\t\t\t\t" + NL + "\t                int dynamic_column_count_";
  protected final String TEXT_378 = NL + "\t\t\t\tchar fieldSeparator_";
  protected final String TEXT_379 = "_ListType[] = null;" + NL + "\t\t\t\t//support passing value (property: Field Separator) by 'context.fs' or 'globalMap.get(\"fs\")'. " + NL + "\t\t\t\tif ( ((String)";
  protected final String TEXT_380 = ").length() > 0 ){" + NL + "\t\t\t\t\tfieldSeparator_";
  protected final String TEXT_381 = "_ListType = ((String)";
  protected final String TEXT_382 = ").toCharArray();" + NL + "\t\t\t\t}else {\t\t\t" + NL + "\t\t\t\t\tthrow new IllegalArgumentException(\"Field Separator must be assigned a char.\"); " + NL + "\t\t\t\t}" + NL + "\t\t\t\tif(";
  protected final String TEXT_383 = ".length == 1 && (\"\\015\").equals(";
  protected final String TEXT_384 = "[0])){//empty line when row separator is '\\n'" + NL + "\t\t\t\t\t";
  protected final String TEXT_385 = NL + "    \t\t\t\t\t\t";
  protected final String TEXT_386 = ".copyMetadata();" + NL + "\t\t\t\t\t";
  protected final String TEXT_387 = NL + "\t\t\t\t}else{" + NL + "\t\t\t\t\t";
  protected final String TEXT_388 = NL + "\t\t\t\t\tfor(int i_";
  protected final String TEXT_389 = "=0;i_";
  protected final String TEXT_390 = "<";
  protected final String TEXT_391 = ".length;i_";
  protected final String TEXT_392 = "++){" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_393 = "[i_";
  protected final String TEXT_394 = "]=";
  protected final String TEXT_395 = "].trim();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_396 = NL + "\t\t\t\t\t\tString temp = \"\";" + NL + "\t\t\t\t\t";
  protected final String TEXT_397 = NL + "\t                int columnIndexWithD_";
  protected final String TEXT_398 = " = 0; //Column Index " + NL + "\t                ";
  protected final String TEXT_399 = NL + "\t\t\t\t\t\tcolumnIndexWithD_";
  protected final String TEXT_400 = " + dynamic_column_count_";
  protected final String TEXT_401 = NL + "\t\t\t\t\t\tif(columnIndexWithD_";
  protected final String TEXT_402 = " < ";
  protected final String TEXT_403 = ".length){" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_404 = NL + "\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_405 = "\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_406 = "[columnIndexWithD_";
  protected final String TEXT_407 = "].trim();\t\t\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_408 = NL + "\t\t\t\t\t\t\t\t\ttemp = ";
  protected final String TEXT_409 = "];" + NL + "\t\t\t\t\t\t\t\t\tif(temp.length() > 0){" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_410 = " = temp;" + NL + "\t\t\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_411 = ";" + NL + "\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_412 = "];" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_413 = NL + "\t\t\t\t\t\t\t\t\tif(";
  protected final String TEXT_414 = "].length() > 0) {" + NL + "\t\t\t\t\t\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_415 = NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_416 = " = ParserUtils.parseTo_Date(";
  protected final String TEXT_417 = "], ";
  protected final String TEXT_418 = ", false);" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_419 = ");" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_420 = "(ParserUtils.parseTo_Number(";
  protected final String TEXT_421 = ");" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_422 = "));" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_423 = "\t\t\t\t\t\t\t" + NL + "\t\t    \t\t\t\t\t\t\t";
  protected final String TEXT_424 = "].getBytes(";
  protected final String TEXT_425 = "                          ";
  protected final String TEXT_426 = NL + "                                        ";
  protected final String TEXT_427 = " = ParserUtils.parseTo_List(";
  protected final String TEXT_428 = "],String.valueOf(fieldSeparator_";
  protected final String TEXT_429 = "_ListType[0]));";
  protected final String TEXT_430 = "]";
  protected final String TEXT_431 = "]);" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_432 = NL + "\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t\t\t} catch(java.lang.Exception ex_";
  protected final String TEXT_433 = ".getMessage());" + NL + "\t\t\t\t\t\t\t\t\t\t\trowstate_";
  protected final String TEXT_434 = ".setException(new RuntimeException(String.format(\"Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s\"," + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\"";
  protected final String TEXT_435 = "\", ";
  protected final String TEXT_436 = "], ex_";
  protected final String TEXT_437 = "));" + NL + "\t\t\t\t\t\t\t\t\t\t}" + NL + "    \t\t\t\t\t\t\t\t}else{" + NL + "    \t\t\t\t\t\t\t\t\t";
  protected final String TEXT_438 = NL + "    \t\t\t\t\t\t\t\t\t\trowstate_";
  protected final String TEXT_439 = "' connection, value is invalid or this column should be nullable or have a default value.\"));" + NL + "    \t\t\t\t\t\t\t\t\t";
  protected final String TEXT_440 = NL + "\t\t\t\t\t\t\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_441 = ";" + NL + "\t\t\t\t\t\t\t\t\t\t\t} catch(java.lang.Exception ex_";
  protected final String TEXT_442 = ".getMessage());" + NL + "\t\t\t\t\t\t\t\t\t\t\t\trowstate_";
  protected final String TEXT_443 = ".setException(new RuntimeException(String.format(\"Couldn't set default value for column '%s' in '%s'. Details: %s\"," + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\"";
  protected final String TEXT_444 = "));" + NL + "\t\t\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_445 = NL + "\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_446 = ";" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_447 = NL + "    \t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_448 = NL + "\t\t\t\t\t\t\t\t    dynamic_column_count_";
  protected final String TEXT_449 = ".getColumnCount();" + NL + "\t\t\t\t\t\t\t\t\tif(dynamic_column_count_";
  protected final String TEXT_450 = " > 0) {" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_451 = ".copyMetadata();" + NL + "\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\tint fieldCount = ";
  protected final String TEXT_452 = ".length;" + NL + "\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_453 = NL + "\t\t\t\t\t\t\t\t\tfor (int i = 0; i < dynamic_column_count_";
  protected final String TEXT_454 = "; i++) {" + NL + "\t\t\t\t\t\t\t\t\t\tif ((";
  protected final String TEXT_455 = "+i) < fieldCount) {" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_456 = "[";
  protected final String TEXT_457 = "+i]);" + NL + "\t\t\t\t\t\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_458 = ".addColumnValue(\"\");" + NL + "\t\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_459 = NL + "\t\t\t\t\t\t\t\t\tint maxColumnNumberInDynamicColumn_";
  protected final String TEXT_460 = ";" + NL + "\t\t\t\t\t\t\t\t\tfor (int i = 0; i < dynamic_column_count_";
  protected final String TEXT_461 = "; i++) {" + NL + "\t\t\t\t\t\t\t\t\t\tObject v_";
  protected final String TEXT_462 = " = null;" + NL + "\t\t\t\t\t\t\t\t\t\tfinal routines.system.DynamicMetadata dynamicMetadata_";
  protected final String TEXT_463 = ".getColumnMetadata(i);" + NL + "\t\t\t\t\t\t\t\t\t\tif ((";
  protected final String TEXT_464 = NL + "\t\t\t\t\t\t\t\t\t\t\tfinal String tempValue_";
  protected final String TEXT_465 = "+i];" + NL + "\t\t\t\t\t\t\t\t\t\t\tfinal String separator_";
  protected final String TEXT_466 = " = String.valueOf(fieldSeparator_";
  protected final String TEXT_467 = "_ListType[0]);" + NL + "\t\t\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_468 = ");" + NL + "\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\t\t\t\t\t\t\tdynamic_column_count_";
  protected final String TEXT_469 = ";" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_470 = NL + "\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_471 = "\t" + NL + "\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_472 = NL + "\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_473 = NL + "\t\t\t\t\t\t\trowstate_";
  protected final String TEXT_474 = "' connection, value is invalid or this column should be nullable or have a default value.\"));" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_475 = NL + "\t\t\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_476 = ";" + NL + "\t\t\t\t\t\t\t} catch(java.lang.Exception ex_";
  protected final String TEXT_477 = ".getMessage());" + NL + "\t\t\t\t\t\t\t\trowstate_";
  protected final String TEXT_478 = ".setException(new RuntimeException(String.format(\"Couldn't set default value for column '%s' in '%s'. %s\"," + NL + "\t\t\t\t\t\t\t\t\t\"";
  protected final String TEXT_479 = "));" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_480 = ";" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_481 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_482 = NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_483 = NL + "\t\t\t\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_484 = NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_485 = NL + " \t\t\t\t\tint filedsum = ";
  protected final String TEXT_486 = ".length;" + NL + " \t\t\t\t\tif(filedsum < (";
  protected final String TEXT_487 = "-1";
  protected final String TEXT_488 = ")){" + NL + " \t\t\t\t\t\tthrow new java.lang.Exception(\"Column(s) missing\");" + NL + " \t\t\t\t\t} else if(filedsum > (";
  protected final String TEXT_489 = ")) {" + NL + " \t\t\t\t\t\tthrow new RuntimeException(\"Too many columns\");" + NL + " \t\t\t\t\t}     " + NL + "\t\t\t\t";
  protected final String TEXT_490 = " = 0;" + NL + "\t\t\t\tint footer_";
  protected final String TEXT_491 = ";" + NL + "\t\t\t\tint totalLine";
  protected final String TEXT_492 = " = 0;" + NL + "\t\t\t\tint limit";
  protected final String TEXT_493 = ";" + NL + "\t\t\t\tint lastLine";
  protected final String TEXT_494 = " = -1;\t" + NL + "\t\t\t\t" + NL + "\t\t\t\tchar fieldSeparator_";
  protected final String TEXT_495 = "[] = null;" + NL + "\t\t\t\t" + NL + "\t\t\t\t//support passing value (property: Field Separator) by 'context.fs' or 'globalMap.get(\"fs\")'. " + NL + "\t\t\t\tif ( ((String)";
  protected final String TEXT_496 = " = ((String)";
  protected final String TEXT_497 = ").toCharArray();" + NL + "\t\t\t\t}else {\t\t\t" + NL + "\t\t\t\t\tthrow new IllegalArgumentException(\"Field Separator must be assigned a char.\"); " + NL + "\t\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\t\tchar rowSeparator_";
  protected final String TEXT_498 = "[] = null;" + NL + "\t\t\t" + NL + "\t\t\t\t//support passing value (property: Row Separator) by 'context.rs' or 'globalMap.get(\"rs\")'. " + NL + "\t\t\t\tif ( ((String)";
  protected final String TEXT_499 = ").length() > 0 ){" + NL + "\t\t\t\t\trowSeparator_";
  protected final String TEXT_500 = ").toCharArray();" + NL + "\t\t\t\t}else {" + NL + "\t\t\t\t\tthrow new IllegalArgumentException(\"Row Separator must be assigned a char.\"); " + NL + "\t\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\t\tObject filename_";
  protected final String TEXT_501 = ";\t\t" + NL + "\t\t\t\tcom.talend.csv.CSVReader csvReader";
  protected final String TEXT_502 = " = null;" + NL + "\t" + NL + "\t\t\t\ttry{" + NL + "\t\t\t\t\t";
  protected final String TEXT_503 = NL + "\t        \t\t\tjava.util.zip.ZipInputStream zis_";
  protected final String TEXT_504 = " = null;" + NL + "\t        \t\t\ttry {" + NL + "\t\t        \t\t\tif(filename_";
  protected final String TEXT_505 = " instanceof java.io.InputStream){" + NL + "\t\t        \t\t\t\tzis_";
  protected final String TEXT_506 = "));" + NL + "\t\t        \t\t\t}else{" + NL + "\t\t        \t\t\t\tzis_";
  protected final String TEXT_507 = "))));" + NL + "\t\t        \t\t\t}" + NL + "\t        \t\t\t} catch(java.lang.Exception e) {" + NL + "globalMap.put(\"";
  protected final String TEXT_508 = "_ERROR_MESSAGE\",e.getMessage());" + NL + "\t        \t\t\t\t";
  protected final String TEXT_509 = " - \" + e.getMessage());" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_510 = NL + "\t        \t\t\t}" + NL + "\t        \t\t\tjava.util.zip.ZipEntry entry_";
  protected final String TEXT_511 = " = null;" + NL + "\t\t        " + NL + "\t\t\t\t        while (true) {" + NL + "\t\t\t        \t\ttry {" + NL + "\t        \t\t\t\t\tentry_";
  protected final String TEXT_512 = ".getNextEntry();" + NL + "\t        \t\t\t\t} catch(java.lang.Exception e) {" + NL + "globalMap.put(\"";
  protected final String TEXT_513 = "_ERROR_MESSAGE\",e.getMessage());" + NL + "\t        \t\t\t\t\t";
  protected final String TEXT_514 = " - \" + e.getMessage());" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_515 = NL + "\t        \t\t\t\t}" + NL + "\t        \t\t\t\tif(entry_";
  protected final String TEXT_516 = " == null) {" + NL + "\t\t\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\t\t\t}" + NL + "\t        \t\t\t\tif(entry_";
  protected final String TEXT_517 = ".isDirectory()){ //directory" + NL + "\t        \t\t\t\t\tcontinue;" + NL + "\t        \t\t\t\t}" + NL + "\t        \t\t\t\tString[] row";
  protected final String TEXT_518 = "=null;" + NL + "\t        \t\t\t\tint currentLine";
  protected final String TEXT_519 = " = 0;" + NL + "\t        \t\t\t\tint outputLine";
  protected final String TEXT_520 = " = 0;" + NL + "\t        \t\t\t\ttry {//TD110 begin" + NL + "\t        \t\t\t\t\tcsvReader";
  protected final String TEXT_521 = "=new com.talend.csv.CSVReader(zis_";
  protected final String TEXT_522 = ", fieldSeparator_";
  protected final String TEXT_523 = "[0], ";
  protected final String TEXT_524 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_525 = NL + "\t\t\t\t\t\tString[] row";
  protected final String TEXT_526 = "=null;" + NL + "\t\t\t\t\t\tint currentLine";
  protected final String TEXT_527 = " = 0;" + NL + "\t        \t\t\tint outputLine";
  protected final String TEXT_528 = " = 0;" + NL + "\t\t\t\t\t\ttry {//TD110 begin" + NL + "\t\t\t\t\t\t\tif(filename_";
  protected final String TEXT_529 = NL + "\t\t\t\t\t\t\t\tcsvReader";
  protected final String TEXT_530 = "=new com.talend.csv.CSVReader((java.io.InputStream)filename_";
  protected final String TEXT_531 = ");" + NL + "\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\t\tcsvReader";
  protected final String TEXT_532 = "=new com.talend.csv.CSVReader(String.valueOf(filename_";
  protected final String TEXT_533 = "),fieldSeparator_";
  protected final String TEXT_534 = ");" + NL + "\t\t        \t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_535 = NL + "\t\t\t\t\t" + NL + "\t\t\t\t\tcsvReader";
  protected final String TEXT_536 = ".setTrimWhitespace(false);" + NL + "\t\t\t\t\tif ( (rowSeparator_";
  protected final String TEXT_537 = "[0] != '\\n') && (rowSeparator_";
  protected final String TEXT_538 = "[0] != '\\r') )" + NL + "\t        \t\t\tcsvReader";
  protected final String TEXT_539 = ".setLineEnd(\"\"+rowSeparator_";
  protected final String TEXT_540 = "[0]);" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_541 = NL + "\t        \t\t\t\tcsvReader";
  protected final String TEXT_542 = ".setQuoteChar('";
  protected final String TEXT_543 = "');" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_544 = NL + "\t\t\t\t\t\t\tString textEnclosure1_";
  protected final String TEXT_545 = "; " + NL + "\t\t\t\t\t\t\tchar textEnclosure_";
  protected final String TEXT_546 = "[] = null;" + NL + "\t\t\t        " + NL + "\t    \t\t\t\t    if(((String)textEnclosure1_";
  protected final String TEXT_547 = ").length() > 0 ){ " + NL + "\t  \t\t\t\t\t\t\ttextEnclosure_";
  protected final String TEXT_548 = " = ((String)textEnclosure1_";
  protected final String TEXT_549 = ").toCharArray(); " + NL + "\t\t\t\t\t\t\t}else { " + NL + "\t            \t\t\t\tthrow new IllegalArgumentException(\"Text Enclosure must be assigned a char.\"); " + NL + "\t        \t\t\t\t}" + NL + "\t\t\t\t\t\t\tcsvReader";
  protected final String TEXT_550 = ".setQuoteChar(textEnclosure_";
  protected final String TEXT_551 = "[0]); " + NL + "\t\t\t\t\t\t";
  protected final String TEXT_552 = NL + "\t            \t\t\t\tcsvReader";
  protected final String TEXT_553 = ".setEscapeChar('\\\\');" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_554 = ".setEscapeChar(csvReader";
  protected final String TEXT_555 = ".getQuoteChar());" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_556 = NL + "\t            \t\t\t\t//?????doesn't work for other escapeChar" + NL + "\t            \t\t\t\t//the default escape mode is double escape" + NL + "\t            \t\t\t\tcsvReader";
  protected final String TEXT_557 = " " + NL + "\t\t        \t\t\tString escapeChar1_";
  protected final String TEXT_558 = ";          " + NL + "\t\t        \t\t\tchar escapeChar_";
  protected final String TEXT_559 = "[] = null;" + NL + "\t\t\t        " + NL + "\t\t\t\t\t        if(((String)escapeChar1_";
  protected final String TEXT_560 = ").length() > 0 ){ " + NL + "\t\t\t\t\t        \tescapeChar_";
  protected final String TEXT_561 = " = ((String)escapeChar1_";
  protected final String TEXT_562 = ").toCharArray(); " + NL + "\t\t\t\t\t  \t\t}else { " + NL + "\t\t        \t\t\t    throw new IllegalArgumentException(\"Escape Char must be assigned a char.\"); " + NL + "\t\t        \t\t\t}" + NL + "\t\t       \t\t\t\tif(escapeChar_";
  protected final String TEXT_563 = "[0] == '\\\\'){" + NL + "\t\t       \t\t\t\t\tcsvReader";
  protected final String TEXT_564 = ".setEscapeChar('\\\\');" + NL + "\t\t       \t\t\t\t}else if(escapeChar_";
  protected final String TEXT_565 = "[0] ==";
  protected final String TEXT_566 = "'";
  protected final String TEXT_567 = "textEnclosure_";
  protected final String TEXT_568 = "[0]";
  protected final String TEXT_569 = "){" + NL + "\t\t       \t\t\t\t\tcsvReader";
  protected final String TEXT_570 = ".getQuoteChar());" + NL + "\t\t       \t\t\t\t} else {" + NL + "\t\t       \t\t\t\t\t//the default escape mode is double escape" + NL + "\t\t       \t\t\t\t\tcsvReader";
  protected final String TEXT_571 = ".getQuoteChar());" + NL + "\t\t       \t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_572 = "      " + NL + "\t\t" + NL + "\t\t\t" + NL + "\t\t\t\t\t\tif(footer_";
  protected final String TEXT_573 = " > 0){" + NL + "\t\t\t\t\t\tfor(totalLine";
  protected final String TEXT_574 = "=0;totalLine";
  protected final String TEXT_575 = "; totalLine";
  protected final String TEXT_576 = "++){" + NL + "\t\t\t\t\t\t\tcsvReader";
  protected final String TEXT_577 = ".readNext();" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tcsvReader";
  protected final String TEXT_578 = ".setSkipEmptyRecords(";
  protected final String TEXT_579 = ");" + NL + "\t\t\t            while (csvReader";
  protected final String TEXT_580 = ".readNext()) {" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_581 = NL + "\t\t\t\t\t\t\t\trow";
  protected final String TEXT_582 = "=csvReader";
  protected final String TEXT_583 = ".getValues();" + NL + "\t\t\t\t\t\t\t\tif(!(row";
  protected final String TEXT_584 = ".length == 1 && (\"\\015\").equals(row";
  protected final String TEXT_585 = "[0]))){//empty line when row separator is '\\n'" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_586 = NL + "\t                " + NL + "\t                \t\ttotalLine";
  protected final String TEXT_587 = "++;" + NL + "\t                " + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_588 = NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_589 = NL + "\t                " + NL + "\t\t\t            }" + NL + "\t            \t\tint lastLineTemp";
  protected final String TEXT_590 = " = totalLine";
  protected final String TEXT_591 = " - footer_";
  protected final String TEXT_592 = "   < 0? 0 : totalLine";
  protected final String TEXT_593 = " ;" + NL + "\t            \t\tif(lastLine";
  protected final String TEXT_594 = " > 0){" + NL + "\t                \t\tlastLine";
  protected final String TEXT_595 = " = lastLine";
  protected final String TEXT_596 = " < lastLineTemp";
  protected final String TEXT_597 = " ? lastLine";
  protected final String TEXT_598 = " : lastLineTemp";
  protected final String TEXT_599 = "; " + NL + "\t            \t\t}else {" + NL + "\t                \t\tlastLine";
  protected final String TEXT_600 = " = lastLineTemp";
  protected final String TEXT_601 = ";" + NL + "\t            \t\t}" + NL + "\t         " + NL + "\t\t\t          \tcsvReader";
  protected final String TEXT_602 = ".close();" + NL + "\t\t\t\t        if(filename_";
  protected final String TEXT_603 = " instanceof java.io.InputStream){" + NL + "\t\t\t\t \t\t\tcsvReader";
  protected final String TEXT_604 = ");" + NL + "\t\t        \t\t}else{" + NL + "\t\t\t\t\t\t\tcsvReader";
  protected final String TEXT_605 = ");" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tcsvReader";
  protected final String TEXT_606 = ".setTrimWhitespace(false);" + NL + "\t\t\t\t\t\tif ( (rowSeparator_";
  protected final String TEXT_607 = "[0] != '\\r') )\t" + NL + "\t        \t\t\t\tcsvReader";
  protected final String TEXT_608 = NL + "\t\t\t\t\t\t\tcsvReader";
  protected final String TEXT_609 = NL + "\t        \t\t\t\t//?????doesn't work for other escapeChar" + NL + "\t        \t\t\t\t//the default escape mode is double escape" + NL + "\t        \t\t\t\tcsvReader";
  protected final String TEXT_610 = " " + NL + "\t       \t\t\t\t\tif(escapeChar_";
  protected final String TEXT_611 = "[0] == '\\\\'){" + NL + "\t       \t\t\t\t\t\tcsvReader";
  protected final String TEXT_612 = ".setEscapeChar('\\\\');" + NL + "\t       \t\t\t\t\t}else if(escapeChar_";
  protected final String TEXT_613 = "[0] == ";
  protected final String TEXT_614 = "){" + NL + "\t       \t\t\t\t\t\tcsvReader";
  protected final String TEXT_615 = ".getQuoteChar());" + NL + "\t       \t\t\t\t\t} else {" + NL + "\t       \t\t\t\t\t\t//the default escape mode is double escape" + NL + "\t        \t\t\t\t\tcsvReader";
  protected final String TEXT_616 = ".getQuoteChar());" + NL + "\t       \t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_617 = "  " + NL + "\t        \t\t}" + NL + "\t        " + NL + "\t\t\t        if(limit";
  protected final String TEXT_618 = " != 0){" + NL + "\t\t\t        \tfor(currentLine";
  protected final String TEXT_619 = "=0;currentLine";
  protected final String TEXT_620 = ";currentLine";
  protected final String TEXT_621 = "++){" + NL + "\t\t\t        \t\tcsvReader";
  protected final String TEXT_622 = ".readNext();" + NL + "\t\t\t        \t}" + NL + "\t\t\t        }" + NL + "\t\t\t        csvReader";
  protected final String TEXT_623 = ");" + NL + "\t        " + NL + "\t    \t\t} catch(java.lang.Exception e) {" + NL + "globalMap.put(\"";
  protected final String TEXT_624 = "_ERROR_MESSAGE\",e.getMessage());" + NL + "\t\t\t\t\t";
  protected final String TEXT_625 = NL + "\t\t\t\t\t\tthrow e;" + NL + "\t\t\t\t\t";
  protected final String TEXT_626 = NL + "\t\t\t\t\t\t\tlog.error(\"";
  protected final String TEXT_627 = " - \" +e.getMessage());" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_628 = NL + "\t\t\t\t\t\tSystem.err.println(e.getMessage());" + NL + "\t\t\t\t\t";
  protected final String TEXT_629 = NL + "\t    \t\t}//TD110 end" + NL + "\t        " + NL + "\t\t\t    ";
  protected final String TEXT_630 = NL + "\t\t\t    \tlog.info(\"";
  protected final String TEXT_631 = " - Retrieving records from the datasource.\");" + NL + "\t\t\t    ";
  protected final String TEXT_632 = NL + "\t        \twhile ( limit";
  protected final String TEXT_633 = " != 0 && csvReader";
  protected final String TEXT_634 = "!=null && csvReader";
  protected final String TEXT_635 = ".readNext() ) { " + NL + "\t        \t\trowstate_";
  protected final String TEXT_636 = ".reset();" + NL + "\t        " + NL + "\t\t        \trow";
  protected final String TEXT_637 = ".getValues();" + NL + "\t\t        \t" + NL + "\t\t\t\t\t";
  protected final String TEXT_638 = NL + "\t        \t\t\tif(row";
  protected final String TEXT_639 = "[0])){//empty line when row separator is '\\n'" + NL + "\t        \t\t\t\tcontinue;" + NL + "\t        \t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_640 = NL + "\t        \t" + NL + "\t        \t" + NL + "\t        \t\tcurrentLine";
  protected final String TEXT_641 = "++;" + NL + "\t            " + NL + "\t\t            if(lastLine";
  protected final String TEXT_642 = " > -1 && currentLine";
  protected final String TEXT_643 = " > lastLine";
  protected final String TEXT_644 = ") {" + NL + "\t\t                break;" + NL + "\t    \t        }" + NL + "\t        \t    outputLine";
  protected final String TEXT_645 = "++;" + NL + "\t            \tif (limit";
  protected final String TEXT_646 = " > 0 && outputLine";
  protected final String TEXT_647 = " > limit";
  protected final String TEXT_648 = ") {" + NL + "\t                \tbreak;" + NL + "\t            \t}  " + NL + "\t                                                                      " + NL + "\t\t\t\t\t";
  protected final String TEXT_649 = NL + "\t    \t\t\t\t\t\t\t";
  protected final String TEXT_650 = " = null;\t\t\t" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_651 = NL + "\t\t\t\t\t\t\t\tboolean whetherReject_";
  protected final String TEXT_652 = " = false;" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_653 = "Struct();" + NL + "\t\t\t\t\t\t\t\ttry {\t\t\t" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_654 = NL + "\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t\tif(rowstate_";
  protected final String TEXT_655 = ".getException()!=null) {" + NL + "\t\t\t\t\t\t\t\t\t\tthrow rowstate_";
  protected final String TEXT_656 = ".getException();" + NL + "\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_657 = " " + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_658 = " = null; " + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_659 = NL + "\t    \t\t\t\t\t\t} catch (java.lang.Exception e) {" + NL + "globalMap.put(\"";
  protected final String TEXT_660 = "_ERROR_MESSAGE\",e.getMessage());" + NL + "\t\t\t\t\t\t\t        whetherReject_";
  protected final String TEXT_661 = " = true;" + NL + "        \t\t\t\t\t\t\t";
  protected final String TEXT_662 = NL + "            \t\t\t\t\t\t\tthrow(e);" + NL + "            \t\t\t\t\t\t";
  protected final String TEXT_663 = NL + "\t\t\t\t\t\t\t\t\t\t\tlog.error(\"";
  protected final String TEXT_664 = " - \" +e.getMessage());" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_665 = NL + "\t\t\t\t\t\t                    ";
  protected final String TEXT_666 = "Struct();" + NL + "                \t\t\t\t\t\t\t";
  protected final String TEXT_667 = NL + "                \t\t\t\t\t\t\t";
  protected final String TEXT_668 = ";" + NL + "                \t\t\t\t\t\t\t";
  protected final String TEXT_669 = " = null;" + NL + "                \t\t\t\t\t\t";
  protected final String TEXT_670 = NL + "                \t\t\t\t\t\t\tSystem.err.println(e.getMessage());" + NL + "                \t\t\t\t\t\t\t";
  protected final String TEXT_671 = NL + "            \t\t\t\t\t\t\t\t";
  protected final String TEXT_672 = ";" + NL + "            \t\t\t\t\t\t\t";
  protected final String TEXT_673 = NL + "            \t\t\t\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_674 = "_ERROR_MESSAGE\", e.getMessage());" + NL + "            \t\t\t\t\t\t\t";
  protected final String TEXT_675 = NL + "\t    \t\t\t\t\t\t}" + NL + "\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_676 = NL + "\t\t\t\t\t\t\t\t\t\tif(!whetherReject_";
  protected final String TEXT_677 = ") { " + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_678 = "      " + NL + "\t             \t\t\t\t\tif(";
  protected final String TEXT_679 = " == null){ " + NL + "\t            \t \t\t\t\t\t";
  protected final String TEXT_680 = "Struct();" + NL + "\t             \t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_681 = " " + NL + "\t\t\t\t\t\t\t\t} " + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_682 = "+1) + \".\");" + NL + "\t\t";
  protected final String TEXT_683 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    
	class DefaultRowUtil {
		String cid = "";
		INode node;
		int schemaOptNum;
		int columnListSize;
		boolean isOptimizeCode;
		boolean isBehindDynamic;
	
		boolean useV2C = false;
		IMetadataTable V2CMetadata;
		String V2CTargetConnName;
		String V2CSourceValueClass;
		String V2CSourceValueName;
		StringBuffer parmsStr;
		StringBuffer varsStr;
		public void prepareOptimizeParam(IMetadataTable metadata,int schemaOptNum){
			this.schemaOptNum=schemaOptNum;
			this.columnListSize = metadata.getListColumns().size();
			this.isOptimizeCode = schemaOptNum < this.columnListSize;
		}
		
		public void prepareValueToConn(INode node, IMetadataTable metadata, String sourceValueClass, String sourceValueName, String targetConnName, int schemaOptNum){
			this.node = node;
			this.V2CMetadata = metadata;
			this.V2CTargetConnName = targetConnName;
			this.V2CSourceValueClass = sourceValueClass;
			this.V2CSourceValueName = sourceValueName;
			this.useV2C = true;
			prepareOptimizeParam(metadata, schemaOptNum);
		}
		public void genVarsParmsStr(Map<String,String> varsMap){
			parmsStr=new StringBuffer();
			varsStr=new StringBuffer();
			if(varsMap!=null && varsMap.size()>0){
				java.util.Set<String> vars=varsMap.keySet();
				for(String varName:vars){
					parmsStr.append(","+varsMap.get(varName)+" "+varName);
					varsStr.append(","+varName);
				}
			}
		}
		public void codeForValueToConn(INode node, IMetadataTable metadata, String sourceValueClass, String sourceValueName, String targetConnName, int start , int end){
		}
		
		public void callValueToConn(String sourceValueName, String targetConnName){
			if(isOptimizeCode){
		
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(targetConnName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append((varsStr!=null?varsStr.toString():""));
    stringBuffer.append(TEXT_7);
    
			}else{
				codeForValueToConn(node, V2CMetadata, V2CSourceValueClass, V2CSourceValueName, V2CTargetConnName, 0, columnListSize);
			}
		}
		
		boolean useV2CWithD = false;
		IMetadataTable V2CWithDMetadata;
		String V2CWithDTargetConnName;
		String V2CWithDSourceValueClass;
		String V2CWithDSourceValueName;
		String V2CWithDDynamicName;
		public void prepareValueToConnWithD(INode node, IMetadataTable metadata, String sourceValueClass, String sourceValueName, String targetConnName, String dynamicName, int schemaOptNum){
			this.node = node;
			this.V2CWithDMetadata = metadata;
			this.V2CWithDTargetConnName = targetConnName;
			this.V2CWithDSourceValueClass = sourceValueClass;
			this.V2CWithDSourceValueName = sourceValueName;
			this.V2CWithDDynamicName = dynamicName;
			this.useV2CWithD = true;
			prepareOptimizeParam(metadata, schemaOptNum);
		}
		
		public boolean codeForValueToConnWithD(INode node, IMetadataTable metadata, String sourceValueClass, String sourceValueName, String targetConnName, String dynamicName ,int start , int end){
			return false;
		}
		
		public void callValueToConnWithD(String sourceValueName, String targetConnName, String dynamicName){
			if(isOptimizeCode){
		
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(targetConnName);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(dynamicName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append((varsStr!=null?varsStr.toString():""));
    stringBuffer.append(TEXT_7);
    
			}else{
				codeForValueToConnWithD(node, V2CWithDMetadata, V2CWithDSourceValueClass, V2CWithDSourceValueName, V2CWithDTargetConnName, V2CWithDDynamicName, 0, columnListSize);
			}
		}
		
		IMetadataTable C2CMetadata;
		String C2CTargetConnName;
		String C2CSourceConnName;
		boolean useC2C = false;
		public void prepareConnToConn(IMetadataTable metadata, String sourceConnName, String targetConnName){
			this.C2CMetadata = metadata;
			this.C2CTargetConnName = targetConnName;
			this.C2CSourceConnName = sourceConnName;
			this.useC2C = true;
		}
		
		public void codeForConnToConn(INode node, IMetadataTable metadata, String sourceConnName, String targetConnName, int start ,int end){
		}
		
		public void callConnToConn(String sourceConnName, String targetConnName){
			if(isOptimizeCode){
		
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(sourceConnName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(targetConnName);
    stringBuffer.append(TEXT_7);
    
			}else{
				codeForConnToConn(node, C2CMetadata, C2CSourceConnName, C2CTargetConnName, 0, columnListSize);
			}
		}
		
		
		public void generateClass(){
		  	if(isOptimizeCode){
				cid = node.getUniqueName();
				int methodNum=(columnListSize%schemaOptNum==0?columnListSize/schemaOptNum:(columnListSize/schemaOptNum)+1);
				
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    
				int start=0;
				int end=0;
				for(int i=0;i<methodNum;i++){
					start=i*schemaOptNum;
					if(i==(methodNum-1)){
						end=columnListSize;
					}else{
						end=(i+1)*schemaOptNum;
					}
					if(useV2C){
					
    stringBuffer.append(TEXT_13);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(V2CSourceValueClass);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(V2CSourceValueName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(V2CTargetConnName);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(V2CTargetConnName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append((parmsStr!=null?parmsStr.toString():""));
    stringBuffer.append(TEXT_16);
    codeForValueToConn(node, V2CMetadata, V2CSourceValueClass, V2CSourceValueName, V2CTargetConnName, start, end);
    stringBuffer.append(TEXT_17);
    	
					}
					if(useV2CWithD){
					
    stringBuffer.append(TEXT_18);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(V2CWithDSourceValueClass);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(V2CWithDSourceValueName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(V2CWithDTargetConnName);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(V2CWithDTargetConnName);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(V2CWithDDynamicName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append((parmsStr!=null?parmsStr.toString():""));
    stringBuffer.append(TEXT_16);
    this.isBehindDynamic = codeForValueToConnWithD(node, V2CWithDMetadata, V2CWithDSourceValueClass, V2CWithDSourceValueName, V2CWithDTargetConnName, V2CWithDDynamicName, start, end);
    stringBuffer.append(TEXT_17);
    		
					}
					if(useC2C){
					
    stringBuffer.append(TEXT_20);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(C2CSourceConnName);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(C2CSourceConnName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(C2CTargetConnName);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(C2CTargetConnName);
    stringBuffer.append(TEXT_16);
    codeForConnToConn(node, C2CMetadata, C2CSourceConnName, C2CTargetConnName, start, end);
    stringBuffer.append(TEXT_17);
    
					}
				}
				if(useV2C){//Call all split methods in one method
				
    stringBuffer.append(TEXT_21);
    stringBuffer.append(V2CSourceValueClass);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(V2CSourceValueName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(V2CTargetConnName);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(V2CTargetConnName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append((parmsStr!=null?parmsStr.toString():""));
    stringBuffer.append(TEXT_22);
    	
				}
				if(useV2CWithD){
				
    stringBuffer.append(TEXT_23);
    stringBuffer.append(V2CWithDSourceValueClass);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(V2CWithDSourceValueName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(V2CWithDTargetConnName);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(V2CWithDTargetConnName);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(V2CWithDDynamicName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append((parmsStr!=null?parmsStr.toString():""));
    stringBuffer.append(TEXT_22);
    
				}
				for(int i=0;i<methodNum;i++){
					if(useV2C){
					
    stringBuffer.append(TEXT_24);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(V2CSourceValueName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(V2CTargetConnName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append((varsStr!=null?varsStr.toString():""));
    stringBuffer.append(TEXT_25);
    
					}
					if(useV2CWithD){
					
    stringBuffer.append(TEXT_26);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(V2CWithDSourceValueName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(V2CWithDTargetConnName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(V2CWithDDynamicName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append((varsStr!=null?varsStr.toString():""));
    stringBuffer.append(TEXT_25);
    
					}
				}
				if(useV2C || useV2CWithD){
				
    stringBuffer.append(TEXT_27);
    
				}
				if(useC2C){
				
    stringBuffer.append(TEXT_28);
    stringBuffer.append(C2CSourceConnName);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(C2CSourceConnName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(C2CTargetConnName);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(C2CTargetConnName);
    stringBuffer.append(TEXT_29);
    
					for(int i=0;i<methodNum;i++){
						if(useC2C){
						
    stringBuffer.append(TEXT_30);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(C2CSourceConnName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(C2CTargetConnName);
    stringBuffer.append(TEXT_31);
    
						}
					}
					
    stringBuffer.append(TEXT_27);
    
				}
				
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    
		  	}
		}
	}
	
    stringBuffer.append(TEXT_36);
    
	//this util class use by set log4j debug paramters
	class DefaultLog4jFileUtil {
	
		INode node = null;
	    String cid = null;
 		boolean isLog4jEnabled = false;
 		String label = null;
 		
 		public DefaultLog4jFileUtil(){
 		}
 		public DefaultLog4jFileUtil(INode node) {
 			this.node = node;
 			this.cid = node.getUniqueName();
 			this.label = cid;
			this.isLog4jEnabled = ("true").equals(org.talend.core.model.process.ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
 		}
 		
 		public void setCid(String cid) {
 			this.cid = cid;
 		}
 		
		//for all tFileinput* components 
		public void startRetriveDataInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_37);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_38);
    
			}
		}
		
		public void retrievedDataNumberInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_37);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    
			}
		}
		
		public void retrievedDataNumberInfoFromGlobalMap(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_37);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    
			}
		}
		
		//for all tFileinput* components 
		public void retrievedDataNumberInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_37);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    
			}
		}
		
		public void writeDataFinishInfo(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_37);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    
			}
		}
		
 		//TODO delete it and remove all log4jSb parameter from components
		public void componentStartInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node,boolean hasIncreased) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_37);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(hasIncreased?"":"+1");
    stringBuffer.append(TEXT_47);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node) {
			debugRetriveData(node,true);
		}
		
		//TODO rename or delete it
		public void debugWriteData(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_37);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    
			}
		}
		
		public void logCurrentRowNumberInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_37);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    
			}
		}
		
		public void logDataCountInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_37);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    
			}
		}

        public void logErrorMessage() {
            if(isLog4jEnabled){
            
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    
            } else {
            
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    
            }
        }
	}
	
	final DefaultLog4jFileUtil log4jFileUtil = new DefaultLog4jFileUtil((INode)(((org.talend.designer.codegen.config.CodeGeneratorArgument)argument).getArgument()));
	
    stringBuffer.append(TEXT_56);
     
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    final String cid = node.getUniqueName();	
	
	String projectName = codeGenArgument.getCurrentProjectName();
	String jobName = codeGenArgument.getJobName();
	String jobVersion = codeGenArgument.getJobVersion();
	
	String tempDir = ElementParameterParser.getValue(node, "__TEMP_DIR__");
	
	String vcid = "";
	IProcess process = node.getProcess();
	final boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(process, "__LOG4J_ACTIVATE__"));
	
	String destination = ElementParameterParser.getValue(node, "__DESTINATION__");
	if(destination!=null && !"".equals(destination)){
		vcid = destination;
	}
	int dynamic_index = -1;
	boolean hasDynamic = false;
	int dynamicColumnlength = 100;
	String dynamic = ElementParameterParser.getValue(node, "__DYNAMIC__");
	final boolean useExistingDynamic = "true".equals(ElementParameterParser.getValue(node, "__USE_EXISTING_DYNAMIC__"));
	final String useHeaderAsIs = ElementParameterParser.getValue(node, "__USE_HEADER_AS_IS__");
	final String dyn = dynamic+"_DYNAMIC";
	List<IMetadataColumn> columnList = null;
	List<IMetadataTable> metadatas = node.getMetadataList();
	IMetadataTable metadata = null;
	int sizeListColumns = 0;
	if ((metadatas!=null)&&(metadatas.size()>0)) {
		metadata = metadatas.get(0);
		if (metadata!=null) {
			columnList = metadata.getListColumns();
			sizeListColumns = columnList.size();
		}
	}
	for(int i=0; columnList!=null && i< columnList.size(); i++) {
        if(columnList.get(i).getTalendType().equals("id_Dynamic")){
            dynamic_index = i+1;
            hasDynamic = true;
            if(columnList.get(i).getLength() != null){
                dynamicColumnlength = columnList.get(i).getLength();
            }
            break;
        }
	}
	int schemaOptNum=100;
	String schemaOptNumStr=ElementParameterParser.getValue(node, "__SCHEMA_OPT_NUM__");
	if(schemaOptNumStr!=null && !"".equals(schemaOptNumStr) && !"\"\"".equals(schemaOptNumStr)){
		schemaOptNum  = Integer.parseInt(schemaOptNumStr);
	}
		
		
	class GenerateCode{
		public int dynamic_index = -1;
		public int colLen = 0; // the length of the column in the input schema
		public void generateDynamicSchemaCode(boolean isCsv,int dynamicColumnlength){
		
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    
				if(useExistingDynamic){
				
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(dyn);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    
				} else {
					if(isCsv){
					
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    
					}else{
					
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    
					}
					
    stringBuffer.append(TEXT_68);
    stringBuffer.append(dynamic_index-1);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(colLen-dynamic_index);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(useHeaderAsIs);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    if(isCsv){
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_76);
    }else{
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    }
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    if(isCsv){
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_76);
    }else{
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    }
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(dynamicColumnlength);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_94);
    
				}
				
    stringBuffer.append(TEXT_95);
    
		}
		public void checkFooterAndRandom(String footer,String random){
		
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(footer );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(random );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_101);
    
		}
		
		public void checkFooter(String footer){
		
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(footer );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    	
		}
	}
	GenerateCode generateCode = new GenerateCode();
	
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    
	if(("false").equals(ElementParameterParser.getValue(node,"__CSV_OPTION__"))) {	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		final String fieldSeparator = ElementParameterParser.getValue(node, "__FIELDSEPARATOR__");
		class RowUtil extends DefaultRowUtil{
			public void codeForValueToConn(INode node, IMetadataTable metadata, String sourceValueClass, String sourceValueName, String targetConnName, int start , int end){
				codeForValueToConnWithD(node, metadata, sourceValueClass, sourceValueName, targetConnName, null, start ,end);
			}
			public boolean codeForValueToConnWithD(INode node, IMetadataTable metadata, String sourceValueClass, String sourceValueName, String targetConnName, String dynamicName, int start , int end){
				cid = node.getUniqueName();
				String encoding = ElementParameterParser.getValue(node,"__ENCODING__");
				
				List<Map<String, String>> trimSelects = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__TRIMSELECT__");
				String isTrimAllStr = ElementParameterParser.getValue(node,"__TRIMALL__");
				boolean isTrimAll = (isTrimAllStr!=null&&!("").equals(isTrimAllStr))?("true").equals(isTrimAllStr):true;
				
				List<Map<String, String>> decodeClns = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__DECODE_COLS__");
				boolean isEnableDecode = ("true").equals(ElementParameterParser.getValue(node,"__ENABLE_DECODE__"));
				
				String checkDateStr = ElementParameterParser.getValue(node,"__CHECK_DATE__");
				boolean checkDate = (checkDateStr!=null&&!("").equals(checkDateStr))?("true").equals(checkDateStr):false;
				
				String checkNumStr = ElementParameterParser.getValue(node, "__CHECK_FIELDS_NUM__");
				boolean checkNum = (checkNumStr!=null&&!("").equals(checkNumStr))?("true").equals(checkNumStr):false; 
				
				String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
				boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
				String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
				String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER);
				
				List<IMetadataColumn> listColumns = metadata.getListColumns();
				int sizeListColumns = listColumns.size();
				boolean noStringTypeExist = false;
				int dynamic_index = -1;
				if(metadata.isDynamicSchema()){
				
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    if(this.isBehindDynamic){
    stringBuffer.append(dynamicName);
    stringBuffer.append(TEXT_107);
    }else{
    stringBuffer.append(TEXT_108);
    }
    stringBuffer.append(TEXT_109);
    
				}
				
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    
				for (int valueN=0; valueN<sizeListColumns; valueN++) {
					IMetadataColumn column = listColumns.get(valueN);
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT){
					}else{
						noStringTypeExist = true;
						break;
					}
				}
				boolean hasStringDefault = false;
				for (int valueM=0; valueM<sizeListColumns; valueM++) {
					IMetadataColumn column = listColumns.get(valueM);
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT){
						if(hasStringDefault==false && column.getDefault()!=null && column.getDefault().length() > 0 ){
							hasStringDefault = true;
							break;
						}
					}
				}
				if(noStringTypeExist || hasStringDefault){
				
    stringBuffer.append(TEXT_112);
    
				}
				String isDecodeNumber = "false";
				for (int valueN=start; valueN<end; valueN++) {
					IMetadataColumn column = listColumns.get(valueN);
					String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
					
					if (decodeClns != null && decodeClns.size() > valueN) { // to avoid the wizard doesn't initialize the table
						isDecodeNumber = ("true").equals(decodeClns.get(valueN).get("DECODE"))?"true":"false";
					}
					if(metadata.isDynamicSchema()){
					
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(valueN-1);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    
					}else{
					
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(valueN);
    stringBuffer.append(TEXT_115);
    
					}
					if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT){
						String defaultValue = column.getDefault();
						if(defaultValue!=null && defaultValue.length()>0){
						
    stringBuffer.append(TEXT_116);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(valueN).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_119);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_121);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(defaultValue );
    stringBuffer.append(TEXT_122);
    
						}else{
						
    stringBuffer.append(TEXT_123);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(valueN).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_124);
    
						}
					}else if(column.getTalendType().equals("id_Dynamic")){
						this.isBehindDynamic=true;
						dynamic_index = valueN;
					
    stringBuffer.append(TEXT_125);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(dynamicName);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(dynamicName);
    stringBuffer.append(TEXT_128);
    if(!useExistingDynamic){
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(dynamic_index);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_132);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(dynamic_index);
    stringBuffer.append(TEXT_134);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(valueN).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_135);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_136);
    } else {
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(sizeListColumns - 1);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(dynamicName);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(dynamic_index);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    //B1 start
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(dynamic_index);
    stringBuffer.append(TEXT_134);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(valueN).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append( fieldSeparator );
    stringBuffer.append(TEXT_147);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    if(advancedSeparator) {
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_5);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_156);
    } else {
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    }
    stringBuffer.append(TEXT_159);
    if(advancedSeparator) {
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_5);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_156);
    } else {
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    }
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    if(advancedSeparator) {
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_5);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_156);
    } else {
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    }
    stringBuffer.append(TEXT_159);
    if(advancedSeparator) {
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_5);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_156);
    } else {
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    }
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    if(advancedSeparator) {
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_5);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_156);
    } else {
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    }
    stringBuffer.append(TEXT_159);
    if(advancedSeparator) {
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_5);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_156);
    } else {
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    }
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    if(advancedSeparator) {
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_5);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_156);
    } else {
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    }
    stringBuffer.append(TEXT_159);
    if(advancedSeparator) {
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_5);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_156);
    } else {
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    }
    stringBuffer.append(TEXT_177);
    if(checkNum || checkDate){
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    } else {
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    }
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    if(advancedSeparator) {
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_5);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_190);
    } else {
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    }
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    if(advancedSeparator) {
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_5);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_156);
    } else {
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    }
    stringBuffer.append(TEXT_159);
    if(advancedSeparator) {
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_5);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_156);
    } else {
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    }
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    if(advancedSeparator) {
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_5);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_156);
    } else {
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    }
    stringBuffer.append(TEXT_159);
    if(advancedSeparator) {
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_5);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_156);
    } else {
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    }
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_218);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
    //B1 end
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_236);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    }
    stringBuffer.append(TEXT_240);
    
					}else{
						
					
    stringBuffer.append(TEXT_241);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(valueN).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_242);
    
							if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {
								//do nothing
							} else {
								
    stringBuffer.append(TEXT_243);
    
    							if(javaType == JavaTypesManager.BYTE_ARRAY){ 
    							
    stringBuffer.append(TEXT_244);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_245);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_246);
    
    							} else if(javaType == JavaTypesManager.LIST){ 
                                
    stringBuffer.append(TEXT_247);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_248);
    stringBuffer.append( fieldSeparator );
    stringBuffer.append(TEXT_54);
    
    							}else if(javaType == JavaTypesManager.DATE) { 
    								if(checkNum || checkDate){
    								
    stringBuffer.append(TEXT_249);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_250);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_251);
    
    								}else{
    								
    stringBuffer.append(TEXT_249);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_250);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_252);
    
    								}
    							}else if(advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable())) { 
    								if (JavaTypesManager.isNumberIntType(javaType)) {
    							
    stringBuffer.append(TEXT_244);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_253);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_254);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_5);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(isEnableDecode?","+isDecodeNumber:"");
    stringBuffer.append(TEXT_246);
    
    								} else {
    							
    stringBuffer.append(TEXT_244);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_253);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_254);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_5);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_255);
    
    								}
    							} else if (JavaTypesManager.isNumberIntType(javaType)) {
    							
    stringBuffer.append(TEXT_244);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_253);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_256);
    stringBuffer.append(isEnableDecode?","+isDecodeNumber:"");
    stringBuffer.append(TEXT_246);
    
    							} else { 
    							
    stringBuffer.append(TEXT_244);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_253);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_257);
    
    							}
    							
    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_261);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_218);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_263);
    
							}
							
    stringBuffer.append(TEXT_264);
    
							String defaultValue = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate, column.getDefault());
							boolean isJavaPrimitiveType = JavaTypesManager.isJavaPrimitiveType(javaType,column.isNullable());
							if((isJavaPrimitiveType && (column.getDefault()==null || column.getDefault().length() == 0)) || defaultValue == null) {
							
    stringBuffer.append(TEXT_265);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_266);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_267);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_268);
    
							} else {
							
    stringBuffer.append(TEXT_269);
    
								if (!JavaTypesManager.NULL.equals(defaultValue)) {
								
    stringBuffer.append(TEXT_270);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(defaultValue );
    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_272);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_218);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_274);
    
								} else {
								
    stringBuffer.append(TEXT_275);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(defaultValue );
    stringBuffer.append(TEXT_276);
    
								}
								
    stringBuffer.append(TEXT_123);
    
							}
							
    stringBuffer.append(TEXT_277);
    
					}
					
    stringBuffer.append(TEXT_278);
    }
				
    stringBuffer.append(TEXT_278);
    if(checkNum) {
    stringBuffer.append(TEXT_279);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_280);
    stringBuffer.append(metadata.getListColumns().size() );
    stringBuffer.append(TEXT_6);
    if(metadata.isDynamicSchema()){
    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_282);
    }
    stringBuffer.append(TEXT_283);
    stringBuffer.append(metadata.getListColumns().size() );
    stringBuffer.append(TEXT_6);
    if(metadata.isDynamicSchema()){
    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_282);
    }
    stringBuffer.append(TEXT_284);
    
				}
				return this.isBehindDynamic;
			}
			
			public void codeForConnToConn(INode node, IMetadataTable metadata, String sourceConnName, String targetConnName, int start , int end){
    			for(int colNum=start;colNum<end;colNum++) {
    				IMetadataColumn column=metadata.getListColumns().get(colNum);
    			
    stringBuffer.append(TEXT_285);
    stringBuffer.append(targetConnName);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_97);
    stringBuffer.append(sourceConnName);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_109);
    
				}
				
    stringBuffer.append(TEXT_286);
    
			}
		}//class defined end

		if ((metadatas!=null)&&(metadatas.size()>0)) {
			if (metadata!=null) {
				String filename = ElementParameterParser.getValue(node,"__FILENAME__");
				
				if(!("".equals(vcid))) {
					filename = "\"/"+filename.substring(1, filename.length()-1)+vcid+"_"+projectName+"_"+jobName+"_"+jobVersion+"\"";
					filename = tempDir+"+"+filename;
				}
				
		    	String encoding = ElementParameterParser.getValue(node,"__ENCODING__");
		    	String header = ElementParameterParser.getValue(node, "__HEADER__");
		    	if(("").equals(header)){
		    		header="0";
		    	}
		    	String limit = ElementParameterParser.getValue(node, "__LIMIT__");
				if(("").equals(limit)){
					limit = "-1";
				}
		    	String footer = ElementParameterParser.getValue(node, "__FOOTER__");
				boolean uncompress = ("true").equals(ElementParameterParser.getValue(node,"__UNCOMPRESS__"));
		    	if(("").equals(footer) || uncompress){
		    		footer="0";
		    	}
		    	String random = "-1";
		    	String ran = ElementParameterParser.getValue(node, "__RANDOM__");
		    	if(("true").equals(ran)){
		    		random = ElementParameterParser.getValue(node, "__NB_RANDOM__");
		    		if(("").equals(random)){
		    			random="0";
		    		}
		    	}
		    	if(uncompress){
		    		random="-1";
		    	}
				
		    	String rowSeparator = ElementParameterParser.getValue(node, "__ROWSEPARATOR__");
		    	String removeEmptyRowFlag =  ElementParameterParser.getValue(node, "__REMOVE_EMPTY_ROW__");
		    	String dieOnErrorStr = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
				boolean dieOnError = (dieOnErrorStr!=null&&!("").equals(dieOnErrorStr))?("true").equals(dieOnErrorStr):false; 
				
				String splitRecordStr = ElementParameterParser.getValue(node, "__SPLITRECORD__");
				boolean splitRecord = (splitRecordStr!=null&&!("").equals(splitRecordStr))?("true").equals(splitRecordStr):false;
				
				//find main & reject conns;
				List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
			    String rejectConnName = "";
			    List<? extends IConnection> rejectConns = node.getOutgoingConnections("REJECT");
			    if(rejectConns != null && rejectConns.size() > 0) {
			        IConnection rejectConn = rejectConns.get(0);
			        rejectConnName = rejectConn.getName();
			    }
			    List<IMetadataColumn> rejectColumnList = null;
			    IMetadataTable metadataTable = node.getMetadataFromConnector("REJECT");
			    if(metadataTable != null) {
			        rejectColumnList = metadataTable.getListColumns();      
			    }
			    String firstConnName = "";
				if (conns!=null) {
					if (conns.size()>0) {
						IConnection conn = conns.get(0);
						if(conn!=null && conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){
							firstConnName = conn.getName();
						}
					}
				}			    
				
				RowUtil rowUtil = new RowUtil(); 
				if (conns!=null) {
				    if (conns.size()>0 && firstConnName != null && firstConnName.length()>0) {
						if(hasDynamic){
							rowUtil.prepareValueToConnWithD(node, metadata, "org.talend.fileprocess.FileInputDelimited", "fid_"+cid, firstConnName, "dynamic_"+cid, schemaOptNum);
							
    stringBuffer.append(TEXT_287);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_288);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_289);
    
						}else{
							rowUtil.prepareValueToConn(node, metadata, "org.talend.fileprocess.FileInputDelimited", "fid_"+cid, firstConnName, schemaOptNum);
						}
						if(!("").equals(rejectConnName)&&!rejectConnName.equals(firstConnName)&&rejectColumnList != null && rejectColumnList.size() > 0) {
							rowUtil.prepareConnToConn(metadata, firstConnName, rejectConnName);
						}
						rowUtil.generateClass();
					}
				}
				
    stringBuffer.append(TEXT_290);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_292);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(limit);
    stringBuffer.append(TEXT_293);
    
					if(uncompress){
					
    stringBuffer.append(TEXT_294);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_295);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_296);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_297);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_298);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_299);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_300);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_301);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_302);
     if(dieOnError) {
    stringBuffer.append(TEXT_303);
     } else { 
    stringBuffer.append(TEXT_269);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_304);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_305);
    }
    stringBuffer.append(TEXT_306);
     } 
    stringBuffer.append(TEXT_307);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_308);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_309);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_310);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_311);
     if(dieOnError) {
    stringBuffer.append(TEXT_312);
     } else { 
    stringBuffer.append(TEXT_275);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_313);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_314);
    }
    stringBuffer.append(TEXT_315);
     } 
    stringBuffer.append(TEXT_316);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_317);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_318);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_319);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(fieldSeparator );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(rowSeparator );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(removeEmptyRowFlag );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(header );
    stringBuffer.append((hasDynamic&&!useExistingDynamic)?"-1":"");
    stringBuffer.append(TEXT_10);
    stringBuffer.append(footer );
    stringBuffer.append(TEXT_320);
    if(hasDynamic&&!useExistingDynamic){
    stringBuffer.append(TEXT_321);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_322);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_323);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_269);
    } else {
    stringBuffer.append(TEXT_324);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_269);
    }
    stringBuffer.append(TEXT_10);
    stringBuffer.append(random );
    stringBuffer.append(TEXT_5);
    stringBuffer.append( splitRecord);
    stringBuffer.append(TEXT_325);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_311);
     if(dieOnError) {
    stringBuffer.append(TEXT_312);
     } else { 
    stringBuffer.append(TEXT_275);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_313);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_314);
    }
    stringBuffer.append(TEXT_326);
     } 
    stringBuffer.append(TEXT_327);
    
					}else{
					
    stringBuffer.append(TEXT_294);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_328);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_329);
    
									generateCode.checkFooterAndRandom(footer,random);
							
    stringBuffer.append(TEXT_330);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_331);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(fieldSeparator );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(rowSeparator );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(removeEmptyRowFlag );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(header );
    stringBuffer.append((hasDynamic&&!useExistingDynamic)?"-1":"");
    stringBuffer.append(TEXT_10);
    stringBuffer.append(footer );
    stringBuffer.append(TEXT_10);
    if(hasDynamic&&!useExistingDynamic){
    stringBuffer.append(TEXT_321);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_322);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_323);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_269);
    } else {
    stringBuffer.append(TEXT_324);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_269);
    }
    stringBuffer.append(TEXT_10);
    stringBuffer.append(random );
    stringBuffer.append(TEXT_5);
    stringBuffer.append( splitRecord);
    stringBuffer.append(TEXT_332);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_302);
     if(dieOnError) {
    stringBuffer.append(TEXT_303);
     } else { 
    stringBuffer.append(TEXT_269);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_304);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_305);
    }
    stringBuffer.append(TEXT_306);
     } 
    stringBuffer.append(TEXT_277);
    
					}
					
    stringBuffer.append(TEXT_333);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_334);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_335);
    }
    stringBuffer.append(TEXT_336);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_337);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_338);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_339);
    
				    	if (conns!=null) {
				    		if (conns.size()>0 && firstConnName != null && firstConnName.length()>0) {
				    			for (int i=0;i<conns.size();i++) {
				    				IConnection connTemp = conns.get(i);
				    				if (connTemp.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
									
    stringBuffer.append(TEXT_340);
    stringBuffer.append(connTemp.getName() );
    stringBuffer.append(TEXT_341);
    
				    				}
				    			}
				    	
								IConnection conn = conns.get(0);
								if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
								
    stringBuffer.append(TEXT_342);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_343);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_344);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_345);
    
										if(hasDynamic){// generate the dynamic schema code
											generateCode.colLen = sizeListColumns;
											generateCode.dynamic_index = dynamic_index;
											generateCode.generateDynamicSchemaCode(false,dynamicColumnlength); //false: delimited mode
											rowUtil.callValueToConnWithD("fid_"+cid, firstConnName, "dynamic_"+cid);
										}else{
											rowUtil.callValueToConn("fid_"+cid, firstConnName);
										}
										
    stringBuffer.append(TEXT_346);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_347);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_348);
    
										
										if(rejectConnName.equals(firstConnName)) {
										
    stringBuffer.append(TEXT_349);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_350);
    
										}
										
    stringBuffer.append(TEXT_351);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_352);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_353);
    
			        					if (dieOnError) {
			            				
    stringBuffer.append(TEXT_354);
    
			        					} else {
											if(isLog4jEnabled){
    stringBuffer.append(TEXT_355);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_356);
    }
			            					if(!("").equals(rejectConnName)&&!rejectConnName.equals(firstConnName)&&rejectColumnList != null && rejectColumnList.size() > 0) {
							                
    stringBuffer.append(TEXT_357);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_344);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_358);
    rowUtil.callConnToConn(firstConnName, rejectConnName);
    stringBuffer.append(TEXT_359);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_360);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_361);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_362);
    
			            					} else if(("").equals(rejectConnName)){
			                				
    stringBuffer.append(TEXT_363);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_362);
    
			            					} else if(rejectConnName.equals(firstConnName)){
    stringBuffer.append(TEXT_364);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_360);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_365);
    
			            			} 
    stringBuffer.append(TEXT_366);
    
			        					} 
			        					
    stringBuffer.append(TEXT_367);
    
								}
							}
							if (conns.size()>0 && firstConnName != null && firstConnName.length()>0) {//no use code, we can link only one main line now.
								boolean isFirstEnter = true;
								for (int i=0;i<conns.size();i++) {
									IConnection conn = conns.get(i);
									if ((conn.getName().compareTo(firstConnName)!=0)&&(conn.getName().compareTo(rejectConnName)!=0)&&(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))) {
									
										if(isFirstEnter) {
										
    stringBuffer.append(TEXT_368);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_369);
    isFirstEnter = false; 
										}
										
    stringBuffer.append(TEXT_370);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_371);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_344);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_372);
    
						    	 		rowUtil.callConnToConn(firstConnName, conn.getName());
									}
								}
								 
								if(!isFirstEnter) {
								
    stringBuffer.append(TEXT_373);
    
								}
								
							}
				  		}
			}
		}
		if(isLog4jEnabled){
    stringBuffer.append(TEXT_374);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_375);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_376);
    }

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	}else{//the following is the tFileInputCSV component
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		final String delim1 = ElementParameterParser.getValue(node, "__FIELDSEPARATOR__");
		class RowUtil extends DefaultRowUtil{
			public void codeForValueToConn(INode node, IMetadataTable metadata, String sourceValueClass, String sourceValueName, String targetConnName, int start , int end){
				codeForValueToConnWithD(node, metadata, sourceValueClass, sourceValueName, targetConnName, null, start ,end);
			}
			public boolean codeForValueToConnWithD(INode node, IMetadataTable metadata, String sourceValueClass, String sourceValueName, String targetConnName, String dynamicName, int start , int end){
				cid = node.getUniqueName();
				String encoding = ElementParameterParser.getValue(node,"__ENCODING__");
				
				List<Map<String, String>> trimSelects = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__TRIMSELECT__");
				String isTrimAllStr = ElementParameterParser.getValue(node,"__TRIMALL__");
				boolean isTrimAll = (isTrimAllStr!=null&&!("").equals(isTrimAllStr))?("true").equals(isTrimAllStr):true;
				
				List<Map<String, String>> decodeClns = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__DECODE_COLS__");
				boolean isEnableDecode = ("true").equals(ElementParameterParser.getValue(node,"__ENABLE_DECODE__"));
				
				String checkDateStr = ElementParameterParser.getValue(node,"__CHECK_DATE__");
				boolean checkDate = (checkDateStr!=null&&!("").equals(checkDateStr))?("true").equals(checkDateStr):false;
				
				String checkNumStr = ElementParameterParser.getValue(node, "__CHECK_FIELDS_NUM__");
				boolean checkNum = (checkNumStr!=null&&!("").equals(checkNumStr))?("true").equals(checkNumStr):false; 
				
				String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
				boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
				String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
				String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER);
				
				List<IMetadataColumn> columns=metadata.getListColumns();
				int columnSize = columns.size();
				if(metadata.isDynamicSchema()){
				
    stringBuffer.append(TEXT_377);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    if(this.isBehindDynamic){
    stringBuffer.append(dynamicName);
    stringBuffer.append(TEXT_107);
    }else{
    stringBuffer.append(TEXT_108);
    }
    stringBuffer.append(TEXT_109);
    
				}
				
    stringBuffer.append(TEXT_378);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_379);
    stringBuffer.append(delim1);
    stringBuffer.append(TEXT_380);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_381);
    stringBuffer.append(delim1);
    stringBuffer.append(TEXT_382);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_383);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_384);
    
					for(int colNo=start;colNo<end;colNo++) {
						IMetadataColumn column1 =metadata.getListColumns().get(colNo);
						if("id_Dynamic".equals(column1.getTalendType())) {
					
    stringBuffer.append(TEXT_385);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(column1.getLabel() );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(dynamicName);
    stringBuffer.append(TEXT_386);
    
						} else {
					
    stringBuffer.append(TEXT_123);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(column1.getLabel() );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaIdType(column1.getTalendType(), column1.isNullable()));
    stringBuffer.append(TEXT_115);
    
						}
					}
					
    stringBuffer.append(TEXT_387);
    if(isTrimAll){
    stringBuffer.append(TEXT_388);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_389);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_390);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_391);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_392);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_393);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_394);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_393);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_395);
    
					}
					boolean hasStringDefault = false;
					for (int valueM=0; valueM<columnSize; valueM++) {
						IMetadataColumn column = columns.get(valueM);
						JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
						if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT){
							if(hasStringDefault==false && column.getDefault()!=null && column.getDefault().length() > 0 ){
								hasStringDefault = true;
								break;
							}
						}
					}
					
					if(hasStringDefault==true){
					
    stringBuffer.append(TEXT_396);
    
					}
					int dynamic_index = 1;
	                
    stringBuffer.append(TEXT_397);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_398);
    
	                String isDecodeNumber = "false";
					for (int i=start;i<end;i++) {
						IMetadataColumn column=columns.get(i);
						String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
						JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
						String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
						if (decodeClns !=null && decodeClns.size() > i) { 
							isDecodeNumber = ("true").equals(decodeClns.get(i).get("DECODE"))?"true":"false";
						}
						if(metadata.isDynamicSchema()){
						
    stringBuffer.append(TEXT_399);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(i-1 );
    stringBuffer.append(TEXT_400);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    
						}else{
						
    stringBuffer.append(TEXT_399);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_124);
    
						}
						
    stringBuffer.append(TEXT_125);
    if(!"id_Dynamic".equals(column.getTalendType())) {
    stringBuffer.append(TEXT_401);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_402);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_403);
    }
    stringBuffer.append(TEXT_404);
    if((!isTrimAll && (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))){
    stringBuffer.append(TEXT_405);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_406);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_394);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_406);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_407);
    
							}
							if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {
								String defaultValue = column.getDefault();
								if(defaultValue!=null && defaultValue.length()>0){
								
    stringBuffer.append(TEXT_408);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_406);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_409);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_410);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(defaultValue );
    stringBuffer.append(TEXT_411);
    
								}else{
								
    stringBuffer.append(TEXT_275);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_406);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_412);
    
								}
							} else {
							
    stringBuffer.append(TEXT_269);
    if(!"id_Dynamic".equals(column.getTalendType())) {
    stringBuffer.append(TEXT_413);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_406);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_414);
    
									if(javaType == JavaTypesManager.DATE) {
										if(checkNum || checkDate){
										
    stringBuffer.append(TEXT_415);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_416);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_406);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_417);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_418);
    
										}else{
										
    stringBuffer.append(TEXT_415);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_416);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_406);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_417);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_419);
    
										}
									} else if(advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable())) {
										if (JavaTypesManager.isNumberIntType(javaType)) {
									
    stringBuffer.append(TEXT_366);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_253);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_420);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_406);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_417);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_5);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(isEnableDecode?","+isDecodeNumber:"");
    stringBuffer.append(TEXT_421);
    
										} else {
									
    stringBuffer.append(TEXT_366);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_253);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_420);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_406);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_417);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_5);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_422);
    
										}
									}else if(javaType == JavaTypesManager.BYTE_ARRAY){ 
									
    stringBuffer.append(TEXT_423);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_406);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_424);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_421);
    
									}else if(javaType == JavaTypesManager.LIST){ 
                                    
    stringBuffer.append(TEXT_425);
    stringBuffer.append(TEXT_426);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_427);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_406);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_428);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_429);
    
									}else if (JavaTypesManager.isNumberIntType(javaType)) {
									
    stringBuffer.append(TEXT_366);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_253);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_406);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_430);
    stringBuffer.append(isEnableDecode?","+isDecodeNumber:"");
    stringBuffer.append(TEXT_421);
    
									}else {
									
    stringBuffer.append(TEXT_366);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_253);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_406);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_431);
    
									}
									
    stringBuffer.append(TEXT_432);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_433);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_434);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_218);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_435);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_406);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_436);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_437);
    
    									String defaultValue = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate, column.getDefault());
    									boolean isJavaPrimitiveType = JavaTypesManager.isJavaPrimitiveType(javaType,column.isNullable());
    									if((isJavaPrimitiveType && (column.getDefault()==null || column.getDefault().length() == 0))) {
    									
    stringBuffer.append(TEXT_438);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_266);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_267);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_439);
    
    									} else {
    									
    stringBuffer.append(TEXT_415);
    
											if (!JavaTypesManager.NULL.equals(defaultValue)) {
											
    stringBuffer.append(TEXT_440);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(defaultValue );
    stringBuffer.append(TEXT_441);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_442);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_443);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_218);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_444);
    
											} else {
											
    stringBuffer.append(TEXT_445);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(defaultValue );
    stringBuffer.append(TEXT_446);
    
											}
											
    stringBuffer.append(TEXT_249);
    
    									}
    									
    stringBuffer.append(TEXT_447);
    
								} else {
									this.isBehindDynamic=true;
									dynamic_index = i;
								
    stringBuffer.append(TEXT_448);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(dynamicName);
    stringBuffer.append(TEXT_449);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_450);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(dynamicName);
    stringBuffer.append(TEXT_451);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_452);
    if(!useExistingDynamic){
    stringBuffer.append(TEXT_453);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_454);
    stringBuffer.append(dynamic_index);
    stringBuffer.append(TEXT_455);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_132);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_456);
    stringBuffer.append(dynamic_index);
    stringBuffer.append(TEXT_457);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_458);
    } else {
    stringBuffer.append(TEXT_459);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(columnSize - 1);
    stringBuffer.append(TEXT_460);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_461);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_462);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(dynamicName);
    stringBuffer.append(TEXT_463);
    stringBuffer.append(dynamic_index);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    //B1 start
    stringBuffer.append(TEXT_464);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_456);
    stringBuffer.append(dynamic_index);
    stringBuffer.append(TEXT_465);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_466);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_467);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    if(advancedSeparator) {
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_5);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_156);
    } else {
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    }
    stringBuffer.append(TEXT_159);
    if(advancedSeparator) {
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_5);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_156);
    } else {
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    }
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    if(advancedSeparator) {
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_5);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_156);
    } else {
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    }
    stringBuffer.append(TEXT_159);
    if(advancedSeparator) {
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_5);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_156);
    } else {
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    }
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    if(advancedSeparator) {
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_5);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_156);
    } else {
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    }
    stringBuffer.append(TEXT_159);
    if(advancedSeparator) {
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_5);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_156);
    } else {
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    }
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    if(advancedSeparator) {
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_5);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_156);
    } else {
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    }
    stringBuffer.append(TEXT_159);
    if(advancedSeparator) {
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_5);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_156);
    } else {
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    }
    stringBuffer.append(TEXT_177);
    if(checkNum || checkDate){
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    } else {
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    }
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    if(advancedSeparator) {
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_5);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_190);
    } else {
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    }
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    if(advancedSeparator) {
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_5);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_156);
    } else {
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    }
    stringBuffer.append(TEXT_159);
    if(advancedSeparator) {
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_5);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_156);
    } else {
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    }
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    if(advancedSeparator) {
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_5);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_156);
    } else {
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    }
    stringBuffer.append(TEXT_159);
    if(advancedSeparator) {
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_5);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_156);
    } else {
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    }
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_218);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
    //B1 end
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_236);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_468);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_469);
    }
    stringBuffer.append(TEXT_470);
    
								}
							}
							
    stringBuffer.append(TEXT_471);
    if(!"id_Dynamic".equals(column.getTalendType())) {
    stringBuffer.append(TEXT_472);
    
						String defaultValue = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate, column.getDefault());
						boolean isJavaPrimitiveType = JavaTypesManager.isJavaPrimitiveType(javaType,column.isNullable());
						if((isJavaPrimitiveType && (column.getDefault()==null || column.getDefault().length() == 0))) {
						
    stringBuffer.append(TEXT_473);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_266);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_267);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_474);
    
						} else {
						
    stringBuffer.append(TEXT_123);
    
							if (!JavaTypesManager.NULL.equals(defaultValue)) {
							
    stringBuffer.append(TEXT_475);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(defaultValue );
    stringBuffer.append(TEXT_476);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_477);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_478);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_218);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_479);
    
							} else {
							
    stringBuffer.append(TEXT_269);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(defaultValue );
    stringBuffer.append(TEXT_480);
    
							}
							
    stringBuffer.append(TEXT_481);
    
						}
						
    stringBuffer.append(TEXT_482);
    }
    stringBuffer.append(TEXT_483);
    
					}
					
    stringBuffer.append(TEXT_484);
    if(checkNum) {
    stringBuffer.append(TEXT_485);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_486);
    stringBuffer.append(metadata.getListColumns().size() );
    stringBuffer.append(TEXT_6);
    if(metadata.isDynamicSchema()){
    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_487);
    }
    stringBuffer.append(TEXT_488);
    stringBuffer.append(metadata.getListColumns().size() );
    stringBuffer.append(TEXT_6);
    if(metadata.isDynamicSchema()){
    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_282);
    }
    stringBuffer.append(TEXT_489);
    
				}
				return this.isBehindDynamic;
			}
			
			public void codeForConnToConn(INode node, IMetadataTable metadata, String sourceConnName, String targetConnName, int start , int end){
    			for(int colNum=start;colNum<end;colNum++) {
    				IMetadataColumn column=metadata.getListColumns().get(colNum);
    			
    stringBuffer.append(TEXT_285);
    stringBuffer.append(targetConnName);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_97);
    stringBuffer.append(sourceConnName);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_109);
    
				}
				
    stringBuffer.append(TEXT_286);
    
			}
		}//class defined end
		
		if ((metadatas!=null)&&(metadatas.size()>0)) {
		    if (metadata!=null) {
		    
		        String filename = ElementParameterParser.getValueWithUIFieldKey(node,"__FILENAME__", "FILENAME");
		    	String encoding = ElementParameterParser.getValue(node,"__ENCODING__");
		    	String header = ElementParameterParser.getValue(node, "__HEADER__");
		    	String footer = ElementParameterParser.getValue(node, "__FOOTER__");
		    	String limit = ElementParameterParser.getValue(node, "__LIMIT__");
		    	if(("").equals(limit)){
		    		limit="-1";
		    	}
		    	  	
		    	String rowSeparator1 = ElementParameterParser.getValue(node, "__CSVROWSEPARATOR__");
		    	
		    	
		    	String escapeChar1 = ElementParameterParser.getValue(node, "__ESCAPE_CHAR__");
		    	
		    	if(("").equals(escapeChar1)){
		    		escapeChar1 = "\"\"";
		    	}
		    	String escapeChar = escapeChar1.substring(1,escapeChar1.length()-1);
		    	if(("'").equals(escapeChar)){
		    		escapeChar = "\\'";
		    	}
		    	String textEnclosure1 = ElementParameterParser.getValue(node, "__TEXT_ENCLOSURE__");
		    	if(("").equals(textEnclosure1)){
		    		textEnclosure1 = "\"\"";
		    	}
		    	String textEnclosure = textEnclosure1.substring(1,textEnclosure1.length()-1);
		    	if ("".equals(textEnclosure)) 
		    		textEnclosure = "\0";
		    	if(("'").equals(textEnclosure)){
		    		textEnclosure = "\\'";
		    	}
		    	
		    	String removeEmptyRow = ElementParameterParser.getValue(node, "__REMOVE_EMPTY_ROW__");
		    	
		    	String dieOnErrorStr = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
				boolean dieOnError = (dieOnErrorStr!=null&&!("").equals(dieOnErrorStr))?("true").equals(dieOnErrorStr):false;
				
				boolean uncompress = ("true").equals(ElementParameterParser.getValue(node,"__UNCOMPRESS__"));
				if(uncompress){
					footer = "0";
				}
				
				List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
			    String rejectConnName = "";
    			List<? extends IConnection> rejectConns = node.getOutgoingConnections("REJECT");
    			if(rejectConns != null && rejectConns.size() > 0) {
        			IConnection rejectConn = rejectConns.get(0);
        			rejectConnName = rejectConn.getName();
   				}
    			List<IMetadataColumn> rejectColumnList = null;
    			IMetadataTable metadataTable = node.getMetadataFromConnector("REJECT");
    			if(metadataTable != null) {
        			rejectColumnList = metadataTable.getListColumns();      
    			}
    			String firstConnName = "";
				if (conns!=null) {
					if (conns.size()>0) {
						IConnection conn = conns.get(0);
						if(conn!=null && conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){
							firstConnName = conn.getName();		
						}
					}
				}
				
				RowUtil rowUtil = new RowUtil(); 
				if (conns!=null) {
				    if (conns.size()>0 && firstConnName != null && firstConnName.length()>0) {
						if(hasDynamic){
							rowUtil.prepareValueToConnWithD(node, metadata, "String[]", "row"+cid, firstConnName, "dynamic_"+cid, schemaOptNum);
							
    stringBuffer.append(TEXT_287);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_288);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_289);
    
						}else{
							rowUtil.prepareValueToConn(node, metadata, "String[]", "row"+cid, firstConnName, schemaOptNum);
						}
						if(!("").equals(rejectConnName)&&!rejectConnName.equals(firstConnName)&&rejectColumnList != null && rejectColumnList.size() > 0) {
							rowUtil.prepareConnToConn(metadata, firstConnName, rejectConnName);
						}
						rowUtil.generateClass();
					}
				}	
				
    stringBuffer.append(TEXT_290);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_490);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_97);
    stringBuffer.append( footer);
    stringBuffer.append(TEXT_491);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_492);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_97);
    stringBuffer.append( limit );
    stringBuffer.append(TEXT_493);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_494);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_495);
    stringBuffer.append(delim1);
    stringBuffer.append(TEXT_380);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_496);
    stringBuffer.append(delim1);
    stringBuffer.append(TEXT_497);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_498);
    stringBuffer.append(rowSeparator1);
    stringBuffer.append(TEXT_499);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_496);
    stringBuffer.append(rowSeparator1);
    stringBuffer.append(TEXT_500);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_501);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_502);
    
					if(uncompress){
					
    stringBuffer.append(TEXT_503);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_504);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_505);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_298);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_506);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_300);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_507);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_508);
     if(dieOnError) {
    stringBuffer.append(TEXT_303);
     } else { 
    stringBuffer.append(TEXT_269);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_304);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_509);
    }
    stringBuffer.append(TEXT_306);
     } 
    stringBuffer.append(TEXT_510);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_511);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_309);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_512);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_513);
     if(dieOnError) {
    stringBuffer.append(TEXT_312);
     } else { 
    stringBuffer.append(TEXT_275);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_313);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_514);
    }
    stringBuffer.append(TEXT_315);
     } 
    stringBuffer.append(TEXT_515);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_516);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_517);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_518);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_519);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_520);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_521);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_522);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_523);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_524);
    
					}else{
					
    stringBuffer.append(TEXT_525);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_526);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_527);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_528);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_329);
    
								generateCode.checkFooter(footer);
							
    stringBuffer.append(TEXT_529);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_530);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_522);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_523);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_531);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_532);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_533);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_523);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_534);
    
					}
					
    stringBuffer.append(TEXT_535);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_536);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_537);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_538);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_539);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_540);
    
						if(("").equals(textEnclosure1) || textEnclosure1.startsWith("\"")){//normal situation
						
    stringBuffer.append(TEXT_541);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_542);
    stringBuffer.append(textEnclosure );
    stringBuffer.append(TEXT_543);
    
						}else{ //context and global variables
						
    stringBuffer.append(TEXT_544);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(textEnclosure1 );
    stringBuffer.append(TEXT_545);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_546);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_547);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_548);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_549);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_550);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_551);
    
						}
					
						if(("").equals(escapeChar1) || escapeChar1.startsWith("\"")){//normal situation
	        				if(("\\\\").equals(escapeChar)){
	        				
    stringBuffer.append(TEXT_552);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_553);
    
	        				}else if(escapeChar.equals(textEnclosure)){
	        				
    stringBuffer.append(TEXT_552);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_554);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_555);
    
	        				}else{
	        				
    stringBuffer.append(TEXT_556);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_554);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_555);
    
	        				}
	        			}else{//context and global variables
	 					
    stringBuffer.append(TEXT_557);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(escapeChar1 );
    stringBuffer.append(TEXT_558);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_559);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_560);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_561);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_562);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_563);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_564);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_565);
    if(("").equals(textEnclosure1) || textEnclosure1.startsWith("\"")){
    stringBuffer.append(TEXT_566);
    stringBuffer.append(textEnclosure );
    stringBuffer.append(TEXT_566);
    }else{
    stringBuffer.append(TEXT_567);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_568);
    }
    stringBuffer.append(TEXT_569);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_554);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_570);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_554);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_571);
    
						}
						
    stringBuffer.append(TEXT_572);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_573);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_574);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_402);
    stringBuffer.append( header );
    stringBuffer.append(TEXT_575);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_576);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_577);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_578);
    stringBuffer.append(removeEmptyRow );
    stringBuffer.append(TEXT_579);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_580);
    
						   	if(("true").equals(removeEmptyRow)){
						   	
    stringBuffer.append(TEXT_581);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_582);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_583);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_584);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_585);
    
							}
							
    stringBuffer.append(TEXT_586);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_587);
    
							if(("true").equals(removeEmptyRow)){
							
    stringBuffer.append(TEXT_588);
    
							}
							
    stringBuffer.append(TEXT_589);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_590);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_591);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_592);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_591);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_593);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_594);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_595);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_596);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_597);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_598);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_599);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_600);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_601);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_602);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_603);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_530);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_522);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_523);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_604);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_532);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_533);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_523);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_605);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_606);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_537);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_607);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_539);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_540);
    
						if(("").equals(textEnclosure1) || textEnclosure1.startsWith("\"")){//normal situation
						
    stringBuffer.append(TEXT_608);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_542);
    stringBuffer.append(textEnclosure );
    stringBuffer.append(TEXT_543);
    
						}else{
						
    stringBuffer.append(TEXT_608);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_550);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_540);
    
						}
						if(("").equals(escapeChar1) || escapeChar1.startsWith("\"")){//normal situation
	        				if(("\\\\").equals(escapeChar)){
	        				
    stringBuffer.append(TEXT_541);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_553);
    
	        				}else if(escapeChar.equals(textEnclosure)){
	        				
    stringBuffer.append(TEXT_541);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_554);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_555);
    
	        				}else{
	        				
    stringBuffer.append(TEXT_609);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_554);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_555);
    
	        				}
	        			}else{//context and global variables
						
    stringBuffer.append(TEXT_610);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_611);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_612);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_613);
    if(("").equals(textEnclosure1) || textEnclosure1.startsWith("\"")){
    stringBuffer.append(TEXT_566);
    stringBuffer.append(textEnclosure );
    stringBuffer.append(TEXT_566);
    }else{
    stringBuffer.append(TEXT_567);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_568);
    }
    stringBuffer.append(TEXT_614);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_554);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_615);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_554);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_616);
    
	        			}
	        			
    stringBuffer.append(TEXT_617);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_618);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_619);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_402);
    stringBuffer.append( header );
    stringBuffer.append((hasDynamic&&!useExistingDynamic)?"-1":"");
    stringBuffer.append(TEXT_620);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_621);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_622);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_578);
    stringBuffer.append(removeEmptyRow );
    stringBuffer.append(TEXT_623);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_624);
     if(dieOnError) {
    stringBuffer.append(TEXT_625);
     } else { 
    stringBuffer.append(TEXT_481);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_626);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_627);
    }
    stringBuffer.append(TEXT_628);
     } 
    stringBuffer.append(TEXT_629);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_630);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_631);
    }
    stringBuffer.append(TEXT_632);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_633);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_634);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_635);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_636);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_582);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_637);
    
	   				if(("true").equals(removeEmptyRow)){
	   				
    stringBuffer.append(TEXT_638);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_584);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_639);
    
					}
					
    stringBuffer.append(TEXT_640);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_641);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_642);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_643);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_644);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_645);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_646);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_647);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_648);
    
			    	if (conns!=null) {
	    				if (conns.size()>0 && firstConnName != null && firstConnName.length()>0) {
	    					for (int i=0;i<conns.size();i++) {
	    						IConnection connTemp = conns.get(i);
	    						if (connTemp.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
								
    stringBuffer.append(TEXT_649);
    stringBuffer.append(connTemp.getName() );
    stringBuffer.append(TEXT_650);
    
	    						}
	    					}
	    					
							IConnection conn = conns.get(0);
							if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
							
    stringBuffer.append(TEXT_651);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_652);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_344);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_653);
    
									List<IMetadataColumn> columns=metadata.getListColumns();
									int columnSize = columns.size();
									if(hasDynamic){// generate the dynamic schema code
										generateCode.colLen = columnSize;
										generateCode.dynamic_index = dynamic_index;
										generateCode.generateDynamicSchemaCode(true,dynamicColumnlength); //true: CSV mode
										rowUtil.callValueToConnWithD("row"+cid, firstConnName, "dynamic_"+cid);
									}else{
										rowUtil.callValueToConn("row"+cid, firstConnName);
									}
									
    stringBuffer.append(TEXT_654);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_655);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_656);
    
									if(rejectConnName.equals(firstConnName)) {
									
    stringBuffer.append(TEXT_657);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_658);
    
									}
									
    stringBuffer.append(TEXT_659);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_660);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_661);
    
        							if (dieOnError) {
            						
    stringBuffer.append(TEXT_662);
    
        							} else {
								        if(isLog4jEnabled){
    stringBuffer.append(TEXT_663);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_664);
    }
            							if(!("").equals(rejectConnName)&&!rejectConnName.equals(firstConnName)&&rejectColumnList != null && rejectColumnList.size() > 0) {
						                
    stringBuffer.append(TEXT_665);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_344);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_666);
    
                							rowUtil.callConnToConn(firstConnName, rejectConnName);
                							
    stringBuffer.append(TEXT_667);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_360);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_668);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_669);
    
            							} else if(("").equals(rejectConnName)){
                						
    stringBuffer.append(TEXT_670);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_669);
    	
            							} else if(rejectConnName.equals(firstConnName)){
            							
    stringBuffer.append(TEXT_671);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_360);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_672);
    
            							} 
    stringBuffer.append(TEXT_673);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_674);
    
        							} 
        							
    stringBuffer.append(TEXT_675);
    			
							}
						}
						if (conns.size()>0) {	
							boolean isFirstEnter = true;
							for (int i=0;i<conns.size();i++) {
								IConnection conn = conns.get(i);
								if ((conn.getName().compareTo(firstConnName)!=0)&&(conn.getName().compareTo(rejectConnName)!=0)&&(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))) {
									if(isFirstEnter) {
									
    stringBuffer.append(TEXT_676);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_677);
    isFirstEnter = false; 
									}
									
    stringBuffer.append(TEXT_678);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_679);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_344);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_680);
    
        							rowUtil.callConnToConn(firstConnName, conn.getName());
								}
							}
							if(!isFirstEnter) {
							
    stringBuffer.append(TEXT_681);
    
							}
						}
					}
			}
		}
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		if(isLog4jEnabled){
    stringBuffer.append(TEXT_374);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_682);
    }
  	}
	
    stringBuffer.append(TEXT_683);
    return stringBuffer.toString();
  }
}
