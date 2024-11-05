package org.talend.designer.codegen.translators.file.output;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IProcess;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.utils.NodeUtil;
import java.util.List;
import java.util.Map;

public class TFileOutputPositionalBeginJava
{
  protected static String nl;
  public static synchronized TFileOutputPositionalBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileOutputPositionalBeginJava result = new TFileOutputPositionalBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "        if (";
  protected final String TEXT_3 = ") {" + NL + "            throw new RuntimeException(\"tFileOutputPositional doesn't support to work with tSetDynamicSchema when 'Guess schema from file' option is activated\");" + NL + "        }";
  protected final String TEXT_4 = NL + "\t\t\troutines.system.Dynamic dynamic_";
  protected final String TEXT_5 = " = (routines.system.Dynamic)globalMap.get(\"";
  protected final String TEXT_6 = "\");" + NL + "\t\t\tint maxColumnCount_";
  protected final String TEXT_7 = " = dynamic_";
  protected final String TEXT_8 = ".getColumnCount();" + NL + "\t\t\tdynamic_";
  protected final String TEXT_9 = ".clearColumnValues();";
  protected final String TEXT_10 = NL + "\t\tint nb_line_";
  protected final String TEXT_11 = " = 0;" + NL + "\t\tresourceMap.put(\"nb_line_";
  protected final String TEXT_12 = "\", nb_line_";
  protected final String TEXT_13 = ");" + NL + "\t\t";
  protected final String TEXT_14 = NL + "class Arrays_";
  protected final String TEXT_15 = "{" + NL + "    public byte[] copyOfRange(byte[] original, int from, int to) {" + NL + "        int newLength = to - from;" + NL + "        if (newLength < 0)" + NL + "            throw new IllegalArgumentException(from + \" > \" + to);" + NL + "        byte[] copy = new byte[newLength];" + NL + "        System.arraycopy(original, from, copy, 0," + NL + "                         Math.min(original.length - from, newLength));" + NL + "        return copy;" + NL + "    }" + NL + "}" + NL + "byte[] byteArray_";
  protected final String TEXT_16 = " = new byte[0];" + NL + "Arrays_";
  protected final String TEXT_17 = " arrays_";
  protected final String TEXT_18 = " = new Arrays_";
  protected final String TEXT_19 = "();";
  protected final String TEXT_20 = "\t\t" + NL + "\t\tclass PositionUtil_";
  protected final String TEXT_21 = "{" + NL + "\t\t";
  protected final String TEXT_22 = NL + "              void writeHeader_";
  protected final String TEXT_23 = "(String tempStringB";
  protected final String TEXT_24 = ",int tempLengthB";
  protected final String TEXT_25 = ",final ";
  protected final String TEXT_26 = " out";
  protected final String TEXT_27 = ",byte[] byteArray_";
  protected final String TEXT_28 = ",Arrays_";
  protected final String TEXT_29 = ")throws IOException,java.io.UnsupportedEncodingException{" + NL + "              " + NL + "                 int tempLengthM";
  protected final String TEXT_30 = "= 0;";
  protected final String TEXT_31 = NL + "    \t\t\t//get  and format output String begin";
  protected final String TEXT_32 = NL + "\t\t\t\t\t\troutines.system.Dynamic dynamic_";
  protected final String TEXT_33 = "\");" + NL + "\t\t\t\t\t\tint maxColumnCount_";
  protected final String TEXT_34 = ".getColumnCount();" + NL + "\t\t\t\t\t\tfor (int i=0;i<maxColumnCount_";
  protected final String TEXT_35 = ";i++) {" + NL + "\t\t\t\t\t\t\troutines.system.DynamicMetadata dynamicMetadataColumn_";
  protected final String TEXT_36 = ".getColumnMetadata(i);" + NL + "\t\t\t\t\t\t\tint currentFieldLength_";
  protected final String TEXT_37 = " = dynamicMetadataColumn_";
  protected final String TEXT_38 = ".getLength();" + NL + "\t\t\t\t\t\t\ttempStringB";
  protected final String TEXT_39 = ".getName();";
  protected final String TEXT_40 = NL + "    \t\t\t\t\t\t\ttempLengthB";
  protected final String TEXT_41 = " = tempStringB";
  protected final String TEXT_42 = ".getBytes(";
  protected final String TEXT_43 = ").length;";
  protected final String TEXT_44 = ".length();";
  protected final String TEXT_45 = NL + "\t    \t\t\t\t\tif(tempLengthB";
  protected final String TEXT_46 = "<currentFieldLength_";
  protected final String TEXT_47 = "){";
  protected final String TEXT_48 = NL + "\t\t\t    \t\t\t\t\tfor(int j=0;j<currentFieldLength_";
  protected final String TEXT_49 = "-tempLengthB";
  protected final String TEXT_50 = ";j++){" + NL + "\t\t\t    \t\t\t\t\t\ttempStringB";
  protected final String TEXT_51 = "= tempStringB";
  protected final String TEXT_52 = " + ";
  protected final String TEXT_53 = ";" + NL + "\t\t\t    \t\t\t\t\t}";
  protected final String TEXT_54 = NL + "\t\t\t\t\t\t\t\t\tfor(int j=0;j<currentFieldLength_";
  protected final String TEXT_55 = "= ";
  protected final String TEXT_56 = " + tempStringB";
  protected final String TEXT_57 = NL + "\t\t\t\t\t\t\t\t\tint temp_";
  protected final String TEXT_58 = " = currentFieldLength_";
  protected final String TEXT_59 = ";" + NL + "\t\t\t\t\t\t\t\t\tfor(int j=0;j<temp_";
  protected final String TEXT_60 = "/2;j++){" + NL + "\t\t\t    \t\t\t\t\t\ttempStringB";
  protected final String TEXT_61 = ";" + NL + "\t\t\t    \t\t\t\t\t}" + NL + "\t\t\t    \t\t\t\t\tif(temp_";
  protected final String TEXT_62 = "%2==1){" + NL + "\t\t\t    \t\t\t\t\t\ttempStringB";
  protected final String TEXT_63 = NL + "\t\t\t\t\t\t\t}else if(tempLengthB";
  protected final String TEXT_64 = " > currentFieldLength_";
  protected final String TEXT_65 = NL + "                    \t\t\t\t\tbyteArray_";
  protected final String TEXT_66 = "=arrays_";
  protected final String TEXT_67 = ".copyOfRange(tempStringB";
  protected final String TEXT_68 = "),tempLengthB";
  protected final String TEXT_69 = " - currentFieldLength_";
  protected final String TEXT_70 = ",tempLengthB";
  protected final String TEXT_71 = ");" + NL + "\t                    \t\t\t\ttempStringB";
  protected final String TEXT_72 = " = new String(byteArray_";
  protected final String TEXT_73 = ",";
  protected final String TEXT_74 = ");";
  protected final String TEXT_75 = NL + "\t\t\t\t\t\t\t\t\t\ttempStringB";
  protected final String TEXT_76 = ".substring(tempLengthB";
  protected final String TEXT_77 = "-currentFieldLength_";
  protected final String TEXT_78 = NL + "\t\t\t\t\t\t\t\t\tint begin";
  protected final String TEXT_79 = "=(tempLengthB";
  protected final String TEXT_80 = ")/2;";
  protected final String TEXT_81 = NL + "\t\t\t\t\t\t\t\t\t\tbyteArray_";
  protected final String TEXT_82 = "),begin";
  protected final String TEXT_83 = ",begin";
  protected final String TEXT_84 = " + currentFieldLength_";
  protected final String TEXT_85 = ");" + NL + "\t\t                    \t\t\ttempStringB";
  protected final String TEXT_86 = NL + "    \t                    \t\t\ttempStringB";
  protected final String TEXT_87 = ".substring(begin";
  protected final String TEXT_88 = ", begin";
  protected final String TEXT_89 = "+currentFieldLength_";
  protected final String TEXT_90 = NL + "\t                    \t\t\t\tbyteArray_";
  protected final String TEXT_91 = "),0,currentFieldLength_";
  protected final String TEXT_92 = ");" + NL + "                    \t\t\t\t\ttempStringB";
  protected final String TEXT_93 = NL + "                    \t\t\t\t\ttempStringB";
  protected final String TEXT_94 = ".substring(0, currentFieldLength_";
  protected final String TEXT_95 = NL + "\t\t\t\t\t\t\t}" + NL + "\t    \t\t\t\t\tout";
  protected final String TEXT_96 = ".write(tempStringB";
  protected final String TEXT_97 = ");" + NL + "\t\t\t\t\t\t}";
  protected final String TEXT_98 = "\t\t\t\t" + NL + "    \t\t\ttempStringB";
  protected final String TEXT_99 = "=\"";
  protected final String TEXT_100 = "\";" + NL + "    \t\t\t";
  protected final String TEXT_101 = NL + "    \t\t\ttempLengthB";
  protected final String TEXT_102 = "=tempStringB";
  protected final String TEXT_103 = ").length;" + NL + "    \t\t\t";
  protected final String TEXT_104 = ".length();" + NL + "    \t\t\t";
  protected final String TEXT_105 = NL + "    \t\t\t" + NL + "            \tif (tempLengthB";
  protected final String TEXT_106 = " > ";
  protected final String TEXT_107 = ") {";
  protected final String TEXT_108 = NL + "                    \t\tbyteArray_";
  protected final String TEXT_109 = " - ";
  protected final String TEXT_110 = ");" + NL + "\t                    \ttempStringB";
  protected final String TEXT_111 = NL + "\t                        tempStringB";
  protected final String TEXT_112 = "-";
  protected final String TEXT_113 = NL + "                        int begin";
  protected final String TEXT_114 = NL + "\t\t\t\t\t\t\tbyteArray_";
  protected final String TEXT_115 = ");" + NL + "\t\t                    tempStringB";
  protected final String TEXT_116 = NL + "    \t                    tempStringB";
  protected final String TEXT_117 = "+";
  protected final String TEXT_118 = NL + "\t                    \tbyteArray_";
  protected final String TEXT_119 = "),0,";
  protected final String TEXT_120 = ");" + NL + "                    \t\ttempStringB";
  protected final String TEXT_121 = NL + "                    \t\ttempStringB";
  protected final String TEXT_122 = ".substring(0, ";
  protected final String TEXT_123 = NL + "                }else if(tempLengthB";
  protected final String TEXT_124 = "<";
  protected final String TEXT_125 = "){" + NL + "                    StringBuilder result";
  protected final String TEXT_126 = " = new StringBuilder();";
  protected final String TEXT_127 = NL + "                        result";
  protected final String TEXT_128 = ".append(tempStringB";
  protected final String TEXT_129 = ");" + NL + "                        for(int i";
  protected final String TEXT_130 = "=0; i";
  protected final String TEXT_131 = "< ";
  protected final String TEXT_132 = "; i";
  protected final String TEXT_133 = "++){" + NL + "                            result";
  protected final String TEXT_134 = ".append(";
  protected final String TEXT_135 = ");" + NL + "                        }" + NL + "                        tempStringB";
  protected final String TEXT_136 = " = result";
  protected final String TEXT_137 = ".toString();";
  protected final String TEXT_138 = NL + "                        for(int i";
  protected final String TEXT_139 = ");" + NL + "                        }" + NL + "                        result";
  protected final String TEXT_140 = ");" + NL + "                        tempStringB";
  protected final String TEXT_141 = NL + "                        int temp";
  protected final String TEXT_142 = "= (";
  protected final String TEXT_143 = ")/2;" + NL + "                        for(int i";
  protected final String TEXT_144 = "=0;i";
  protected final String TEXT_145 = "<temp";
  protected final String TEXT_146 = ";i";
  protected final String TEXT_147 = ");" + NL + "                        }" + NL + "                        if((temp";
  protected final String TEXT_148 = "+temp";
  protected final String TEXT_149 = ")!=(";
  protected final String TEXT_150 = ")){" + NL + "                            result";
  protected final String TEXT_151 = "       " + NL + "                }" + NL + "                //get  and format output String end" + NL + "    \t\t\tout";
  protected final String TEXT_152 = NL + "              }";
  protected final String TEXT_153 = NL + "              }  ";
  protected final String TEXT_154 = NL + "\t\t\t\t  void setValue_";
  protected final String TEXT_155 = "(final ";
  protected final String TEXT_156 = "Struct ";
  protected final String TEXT_157 = ",StringBuilder sb_";
  protected final String TEXT_158 = ",String tempStringM";
  protected final String TEXT_159 = ",int tempLengthM";
  protected final String TEXT_160 = ")throws IOException,java.io.UnsupportedEncodingException{";
  protected final String TEXT_161 = NL + "\t\t\t\t\t\troutines.system.Dynamic dynamic_map_";
  protected final String TEXT_162 = " =(routines.system.Dynamic)globalMap.get(\"";
  protected final String TEXT_163 = "\");" + NL + "\t\t\t\t\t\troutines.system.Dynamic dynamic_";
  protected final String TEXT_164 = " = ";
  protected final String TEXT_165 = ".";
  protected final String TEXT_166 = ";//" + NL + "\t\t\t\t\t\tint maxColumnCount_";
  protected final String TEXT_167 = " = dynamic_map_";
  protected final String TEXT_168 = ".getColumnCount();" + NL + "\t\t\t\t\t\tString temp_";
  protected final String TEXT_169 = "= \"\";" + NL + "\t\t\t\t\t\tfor (int i=0;i<maxColumnCount_";
  protected final String TEXT_170 = ";i++) {" + NL + "\t\t\t\t\t\t\troutines.system.DynamicMetadata metadata_";
  protected final String TEXT_171 = ".getColumnMetadata(i);" + NL + "\t\t\t\t\t\t\ttemp_";
  protected final String TEXT_172 = " = String.valueOf(dynamic_";
  protected final String TEXT_173 = ".getColumnValue(i));" + NL + "\t\t\t\t\t\t\tString type_";
  protected final String TEXT_174 = " = metadata_";
  protected final String TEXT_175 = ".getType();" + NL + "\t\t\t\t\t\t\tif(\"id_BigDecimal\".equals(type_";
  protected final String TEXT_176 = ")){" + NL + "\t\t\t\t\t\t\t\tint precision_";
  protected final String TEXT_177 = ".getPrecision();" + NL + "\t\t\t\t\t\t\t\tif(precision_";
  protected final String TEXT_178 = " !=0){" + NL + "\t\t\t\t\t\t\t\t\ttemp_";
  protected final String TEXT_179 = " = (new BigDecimal(temp_";
  protected final String TEXT_180 = ")).setScale(precision_";
  protected final String TEXT_181 = ",java.math.RoundingMode.HALF_UP).toPlainString();" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t}";
  protected final String TEXT_182 = "\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\tif(\"id_BigDecimal\".equals(type_";
  protected final String TEXT_183 = ") || \"id_Short\".equals(type_";
  protected final String TEXT_184 = ") || \"id_Integer\".equals(type_";
  protected final String TEXT_185 = ") || \"id_Double\".equals(type_";
  protected final String TEXT_186 = ") || \"id_Float\".equals(type_";
  protected final String TEXT_187 = ") || \"id_Long\".equals(type_";
  protected final String TEXT_188 = ")){" + NL + "\t\t\t\t\t\t\t\ttemp_";
  protected final String TEXT_189 = " = FormatterUtils.format_Number(temp_";
  protected final String TEXT_190 = ", ";
  protected final String TEXT_191 = ");" + NL + "\t\t\t\t\t\t\t}";
  protected final String TEXT_192 = NL + "\t\t\t\t\t\t\tint columnLength_";
  protected final String TEXT_193 = ".getLength();";
  protected final String TEXT_194 = NL + "    \t\t\t\t\t\t\tint temp_length_";
  protected final String TEXT_195 = " = temp_";
  protected final String TEXT_196 = NL + "\t\t\t\t\t\t\tif(temp_length_";
  protected final String TEXT_197 = " < columnLength_";
  protected final String TEXT_198 = NL + "\t\t\t\t\t\t\t\t\tsb_";
  protected final String TEXT_199 = ".append(temp_";
  protected final String TEXT_200 = ");" + NL + "\t\t\t    \t\t\t\t\tfor(int j=0;j<columnLength_";
  protected final String TEXT_201 = "-temp_length_";
  protected final String TEXT_202 = ";j++){" + NL + "\t\t\t    \t\t\t\t\t\tsb_";
  protected final String TEXT_203 = ");" + NL + "\t\t\t    \t\t\t\t\t}";
  protected final String TEXT_204 = NL + "\t\t\t    \t\t\t\t\tfor(int j=0;j<columnLength_";
  protected final String TEXT_205 = ");" + NL + "\t\t\t    \t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\tsb_";
  protected final String TEXT_206 = NL + "\t\t\t\t\t\t\t\t\tint tempNum_";
  protected final String TEXT_207 = " = columnLength_";
  protected final String TEXT_208 = ";" + NL + "\t\t\t\t\t\t\t\t\tfor(int j=0;j<tempNum_";
  protected final String TEXT_209 = "/2;j++){" + NL + "\t\t\t    \t\t\t\t\t\tsb_";
  protected final String TEXT_210 = ");" + NL + "\t\t\t    \t\t\t\t\t}" + NL + "\t\t\t    \t\t\t\t\tsb_";
  protected final String TEXT_211 = ");" + NL + "\t\t\t\t\t\t\t\t\tfor(int j=0;j<tempNum_";
  protected final String TEXT_212 = ");" + NL + "\t\t\t    \t\t\t\t\t}" + NL + "\t\t\t    \t\t\t\t\tif(tempNum_";
  protected final String TEXT_213 = "%2==1){" + NL + "\t\t\t    \t\t\t\t\t\tsb_";
  protected final String TEXT_214 = NL + "\t\t\t\t\t\t\t}else{";
  protected final String TEXT_215 = NL + "\t\t\t                        sb_";
  protected final String TEXT_216 = NL + "\t\t\t                    \t\tbyteArray_";
  protected final String TEXT_217 = ".copyOfRange(temp_";
  protected final String TEXT_218 = "),temp_length_";
  protected final String TEXT_219 = " - columnLength_";
  protected final String TEXT_220 = ",temp_length_";
  protected final String TEXT_221 = ");" + NL + "\t\t\t\t                    \tsb_";
  protected final String TEXT_222 = ".append(new String(byteArray_";
  protected final String TEXT_223 = "));";
  protected final String TEXT_224 = NL + "\t\t\t    \t                    sb_";
  protected final String TEXT_225 = ".substring(temp_length_";
  protected final String TEXT_226 = "-columnLength_";
  protected final String TEXT_227 = NL + "\t\t\t                        int begin";
  protected final String TEXT_228 = "=(temp_length_";
  protected final String TEXT_229 = "+columnLength_";
  protected final String TEXT_230 = "),0,columnLength_";
  protected final String TEXT_231 = ");" + NL + "\t\t\t                    \t\tsb_";
  protected final String TEXT_232 = NL + "\t\t\t\t\t\t\t\t\t\tsb_";
  protected final String TEXT_233 = ".substring(0, columnLength_";
  protected final String TEXT_234 = NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t}";
  protected final String TEXT_235 = NL + "\t\t\t\t//get  and format output String begin" + NL + "    \t\t\ttempStringM";
  protected final String TEXT_236 = "=";
  protected final String TEXT_237 = NL + "\t\t\t\t\tString.valueOf(";
  protected final String TEXT_238 = ")";
  protected final String TEXT_239 = NL + "\t\t\t\t\t(";
  protected final String TEXT_240 = " == null) ? " + NL + "\t\t\t\t\t\"\": ";
  protected final String TEXT_241 = "FormatterUtils.format_Date(";
  protected final String TEXT_242 = "java.nio.charset.Charset.defaultCharset().decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_243 = ")).toString()";
  protected final String TEXT_244 = NL + "        \t\t\t\t\t\t\t";
  protected final String TEXT_245 = NL + "        \t\t\t\t\t\t\tFormatterUtils.format_Number(";
  protected final String TEXT_246 = ".toPlainString(), ";
  protected final String TEXT_247 = ")\t\t\t\t\t" + NL + "        \t\t\t\t\t\t\t";
  protected final String TEXT_248 = NL + "        \t\t\t\t\t\t\tFormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_249 = "), ";
  protected final String TEXT_250 = ")\t\t\t\t\t\t" + NL + "        \t\t\t\t\t\t\t";
  protected final String TEXT_251 = NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_252 = ".toPlainString()\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_253 = "String.valueOf(";
  protected final String TEXT_254 = " ;" + NL + "\t\t\t\t";
  protected final String TEXT_255 = NL + "    \t\t\ttempLengthM";
  protected final String TEXT_256 = "=tempStringM";
  protected final String TEXT_257 = NL + "    \t\t\t" + NL + "            \tif (tempLengthM";
  protected final String TEXT_258 = " >=";
  protected final String TEXT_259 = NL + "                        sb_";
  protected final String TEXT_260 = ".append(tempStringM";
  protected final String TEXT_261 = ".copyOfRange(tempStringM";
  protected final String TEXT_262 = "),tempLengthM";
  protected final String TEXT_263 = ",tempLengthM";
  protected final String TEXT_264 = ");" + NL + "\t                    \tsb_";
  protected final String TEXT_265 = NL + "    \t                    sb_";
  protected final String TEXT_266 = ".substring(tempLengthM";
  protected final String TEXT_267 = "=(tempLengthM";
  protected final String TEXT_268 = ");" + NL + "                    \t\tsb_";
  protected final String TEXT_269 = NL + "                    \t\tsb_";
  protected final String TEXT_270 = NL + "                }else if(tempLengthM";
  protected final String TEXT_271 = "){" + NL + "                   ";
  protected final String TEXT_272 = ");" + NL + "                        for(int i_";
  protected final String TEXT_273 = "=0; i_";
  protected final String TEXT_274 = "-tempLengthM";
  protected final String TEXT_275 = "; i_";
  protected final String TEXT_276 = "++){" + NL + "                            sb_";
  protected final String TEXT_277 = ");" + NL + "                        }" + NL + "                        ";
  protected final String TEXT_278 = NL + "                        for(int i_";
  protected final String TEXT_279 = ");" + NL + "                        }" + NL + "                        sb_";
  protected final String TEXT_280 = ");" + NL + "                        ";
  protected final String TEXT_281 = ")/2;" + NL + "                        for(int i_";
  protected final String TEXT_282 = "=0;i_";
  protected final String TEXT_283 = ";i_";
  protected final String TEXT_284 = ");" + NL + "                        for(int i=temp";
  protected final String TEXT_285 = "+tempLengthM";
  protected final String TEXT_286 = ";i<";
  protected final String TEXT_287 = ";i++){" + NL + "                            sb_";
  protected final String TEXT_288 = ");" + NL + "                        }" + NL + "" + NL + "                        ";
  protected final String TEXT_289 = "       " + NL + "                }" + NL + "                //get  and format output String end\t\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_290 = NL + "                 }";
  protected final String TEXT_291 = NL + "                   }";
  protected final String TEXT_292 = NL + "\t\t" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tPositionUtil_";
  protected final String TEXT_293 = " positionUtil_";
  protected final String TEXT_294 = "=new PositionUtil_";
  protected final String TEXT_295 = "();" + NL + "\t\t";
  protected final String TEXT_296 = NL + "\t\tString fileNewName_";
  protected final String TEXT_297 = ";" + NL + "\t\tjava.io.File createFile";
  protected final String TEXT_298 = " = new java.io.File(fileNewName_";
  protected final String TEXT_299 = ");" + NL + "\t\tboolean isFileGenerated_";
  protected final String TEXT_300 = " = true;" + NL + "\t\tresourceMap.put(\"createFile";
  protected final String TEXT_301 = "\", createFile";
  protected final String TEXT_302 = ");" + NL + "\t\tresourceMap.put(\"isFileGenerated_";
  protected final String TEXT_303 = "\", isFileGenerated_";
  protected final String TEXT_304 = NL + "\t\tif(createFile";
  protected final String TEXT_305 = ".exists()){" + NL + "\t\t\tisFileGenerated_";
  protected final String TEXT_306 = " = false;" + NL + "\t\t\tresourceMap.put(\"isFileGenerated_";
  protected final String TEXT_307 = ");" + NL + "\t\t}";
  protected final String TEXT_308 = NL + "        //create directory only if not exists" + NL + "        java.io.File parentFile_";
  protected final String TEXT_309 = " = createFile";
  protected final String TEXT_310 = ".getParentFile();" + NL + "        if(parentFile_";
  protected final String TEXT_311 = " != null && !parentFile_";
  protected final String TEXT_312 = ".exists()) {" + NL + "            parentFile_";
  protected final String TEXT_313 = ".mkdirs();" + NL + "        }";
  protected final String TEXT_314 = NL + "        String fullName_";
  protected final String TEXT_315 = " = null;" + NL + "        String extension_";
  protected final String TEXT_316 = " = null;" + NL + "        String directory_";
  protected final String TEXT_317 = " = null;" + NL + "        if((fileNewName_";
  protected final String TEXT_318 = ".indexOf(\"/\") != -1)) {" + NL + "            if(fileNewName_";
  protected final String TEXT_319 = ".lastIndexOf(\".\") < fileNewName_";
  protected final String TEXT_320 = ".lastIndexOf(\"/\")) {" + NL + "                fullName_";
  protected final String TEXT_321 = " = fileNewName_";
  protected final String TEXT_322 = ";" + NL + "                extension_";
  protected final String TEXT_323 = " = \"\";" + NL + "            } else {" + NL + "                fullName_";
  protected final String TEXT_324 = ".substring(0, fileNewName_";
  protected final String TEXT_325 = ".lastIndexOf(\".\"));" + NL + "                extension_";
  protected final String TEXT_326 = ".substring(fileNewName_";
  protected final String TEXT_327 = ".lastIndexOf(\".\"));" + NL + "            }           " + NL + "            directory_";
  protected final String TEXT_328 = ".lastIndexOf(\"/\"));            " + NL + "        } else {" + NL + "            if(fileNewName_";
  protected final String TEXT_329 = ".lastIndexOf(\".\") != -1) {" + NL + "                fullName_";
  protected final String TEXT_330 = ".lastIndexOf(\".\"));" + NL + "            } else {" + NL + "                fullName_";
  protected final String TEXT_331 = " = \"\";" + NL + "            }" + NL + "            directory_";
  protected final String TEXT_332 = " = \"\";" + NL + "        }" + NL + "\t\tString zipName_";
  protected final String TEXT_333 = " = fullName_";
  protected final String TEXT_334 = " + \".zip\";" + NL + "\t\tjava.io.File file_";
  protected final String TEXT_335 = " = new java.io.File(zipName_";
  protected final String TEXT_336 = ");" + NL + "\t\tresourceMap.put(\"file_";
  protected final String TEXT_337 = "\", file_";
  protected final String TEXT_338 = ");" + NL + "\t    java.util.zip.ZipOutputStream zipOut_";
  protected final String TEXT_339 = "=new java.util.zip.ZipOutputStream(" + NL + "\t    \t\t\tnew java.io.BufferedOutputStream(new java.io.FileOutputStream(zipName_";
  protected final String TEXT_340 = ")));" + NL + "\t    zipOut_";
  protected final String TEXT_341 = ".putNextEntry(new java.util.zip.ZipEntry(createFile";
  protected final String TEXT_342 = ".getName()));" + NL + "\t\tfinal ";
  protected final String TEXT_343 = " = new ";
  protected final String TEXT_344 = "(new java.io.OutputStreamWriter(zipOut_";
  protected final String TEXT_345 = "));" + NL + "\t\tresourceMap.put(\"out";
  protected final String TEXT_346 = "\", out";
  protected final String TEXT_347 = NL + "\t\tfinal ";
  protected final String TEXT_348 = "(new java.io.OutputStreamWriter(" + NL + "        \t\tnew java.io.FileOutputStream(fileNewName_";
  protected final String TEXT_349 = "),";
  protected final String TEXT_350 = "));" + NL + "        \t\tresourceMap.put(\"out";
  protected final String TEXT_351 = NL + "\t    java.util.zip.ZipOutputStream zipOut_";
  protected final String TEXT_352 = "=new java.util.zip.ZipOutputStream(" + NL + "\t    \t\t\tnew java.io.BufferedOutputStream(";
  protected final String TEXT_353 = "));" + NL + "\t    zipOut_";
  protected final String TEXT_354 = ".putNextEntry(new java.util.zip.ZipEntry(\"TalendOutputPositional\"));" + NL + "\t\tjava.io.OutputStreamWriter outWriter_";
  protected final String TEXT_355 = " = new java.io.OutputStreamWriter(zipOut_";
  protected final String TEXT_356 = ");" + NL + "\t\tresourceMap.put(\"outWriter_";
  protected final String TEXT_357 = "\", outWriter_";
  protected final String TEXT_358 = ");" + NL + "\t\tfinal ";
  protected final String TEXT_359 = "(outWriter_";
  protected final String TEXT_360 = ");" + NL + "\t\tresourceMap.put(\"out";
  protected final String TEXT_361 = NL + "\t\tjava.io.OutputStreamWriter outWriter_";
  protected final String TEXT_362 = " = new java.io.OutputStreamWriter(";
  protected final String TEXT_363 = "); " + NL + "\t\tresourceMap.put(\"out";
  protected final String TEXT_364 = "); ";
  protected final String TEXT_365 = ".length()==0){";
  protected final String TEXT_366 = NL + "    \t\t" + NL + "    \t\tString tempStringB";
  protected final String TEXT_367 = "=null;" + NL + "    \t\tint tempLengthB";
  protected final String TEXT_368 = "=0;";
  protected final String TEXT_369 = NL + "            positionUtil_";
  protected final String TEXT_370 = ".writeHeader_";
  protected final String TEXT_371 = "(tempStringB";
  protected final String TEXT_372 = ",out";
  protected final String TEXT_373 = ",byteArray_";
  protected final String TEXT_374 = ",arrays_";
  protected final String TEXT_375 = NL + "    \t\tout";
  protected final String TEXT_376 = ".write(";
  protected final String TEXT_377 = NL + "    \t}";
  protected final String TEXT_378 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();

List<IMetadataTable> metadatas = node.getMetadataList();
   
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {
    
    	String cid = node.getUniqueName();
    	
    	String encoding = ElementParameterParser.getValue(node, "__ENCODING__");
        if (encoding!=null) {
            if (("").equals(encoding)) {
                encoding = "undef";
            }
        }
        
        String separator = ElementParameterParser.getValue(
            node,
            "__ROWSEPARATOR__"
        );
        
        String filename = ElementParameterParser.getValue(
            node,
            "__FILENAME__"
        );
		
		boolean useByte = ("true").equals(ElementParameterParser.getValue(node, "__USE_BYTE__"));
		
        boolean isIncludeHeader = ("true").equals(ElementParameterParser.getValue(node,"__INCLUDEHEADER__"));

        boolean isAppend = ("true").equals(ElementParameterParser.getValue(node,"__APPEND__"));
        
		boolean useStream = ("true").equals(ElementParameterParser.getValue(node,"__USESTREAM__"));
		String outStream = ElementParameterParser.getValue(node,"__STREAMNAME__");
        
        String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
		boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
		String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
		String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER);        
 
        List<Map<String, String>> formats =
            (List<Map<String,String>>)ElementParameterParser.getObjectValue(
                node,
                "__FORMATS__"
            );
        
        boolean compress = ("true").equals(ElementParameterParser.getValue(node,"__COMPRESS__"));
        
        boolean isInRowMode = ("true").equals(ElementParameterParser.getValue(node,"__ROW_MODE__"));
        String writerClass = null;
        if(isInRowMode){
            writerClass = "routines.system.BufferedOutput";
        }else{
           writerClass = "java.io.BufferedWriter";
        }
        IProcess process = node.getProcess();
        String dynamic = ElementParameterParser.getValue(node, "__DYNAMIC__");
        List<? extends INode> dynamicSchemaNodes = process.getNodesOfType("tSetDynamicSchema");
        boolean guessSchemaFromFile = false;
        for (INode currentNode : dynamicSchemaNodes){
            if (currentNode.getUniqueName().equals(dynamic)){
                guessSchemaFromFile = ("true").equals(ElementParameterParser.getValue(currentNode, "__GUESS_SCHEMA_FROM_FILE__"));
            }
        }

    stringBuffer.append(TEXT_2);
    stringBuffer.append(guessSchemaFromFile);
    stringBuffer.append(TEXT_3);
    
		boolean useExistingDynamic = "true".equals(ElementParameterParser.getValue(node, "__USE_EXISTING_DYNAMIC__"));
        String dyn = dynamic+"_DYNAMIC";
		if(useExistingDynamic){

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(dyn);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    
		}

    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    
		if(useByte){

    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    
		}

    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    
		    List<IMetadataColumn> columns = metadata.getListColumns();
    		int sizeColumns = columns.size();
    		if(isIncludeHeader){
    		for (int i = 0; i < sizeColumns; i++) {
    			IMetadataColumn column = columns.get(i);
    			Map<String, String> format=formats.get(i);
    			if(i%100==0){

    stringBuffer.append(TEXT_22);
    stringBuffer.append(i/100);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(writerClass );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
     if(useByte){ 
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
     } 
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    
                }

    stringBuffer.append(TEXT_31);
    
				if("id_Dynamic".equals(column.getTalendType())){
					if(useExistingDynamic){

    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(dyn);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    
	    					if(useByte){

    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_43);
    
    						}else{

    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    
    						}

    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    
								if (("\'L\'").equals(format.get("ALIGN"))) {

    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(format.get("PADDING_CHAR"));
    stringBuffer.append(TEXT_53);
    
								} else if (("\'R\'").equals(format.get("ALIGN"))) {

    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(format.get("PADDING_CHAR"));
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    
								} else {

    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(format.get("PADDING_CHAR"));
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(format.get("PADDING_CHAR"));
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(format.get("PADDING_CHAR"));
    stringBuffer.append(TEXT_53);
    
								}

    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    
                    			if (("\'A\'").equals(format.get("KEEP"))) {
                    			} else if (("\'R\'").equals(format.get("KEEP"))) {
									if(useByte){

    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_74);
    
                        			}else{

    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    
									}
								} else if (("\'M\'").equals(format.get("KEEP"))) {

    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    
									if(useByte){

    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_74);
    
									}else{

    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    
	                    			}
                    			} else {
                    				if(useByte){

    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_74);
    
                    				}else{

    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    									}
                    			}

    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_97);
    
					}
				}else{//not dynamic begin

    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_100);
    if(useByte){
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_103);
    }else{
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_104);
    }
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_107);
    
                    if (("\'A\'").equals(format.get("KEEP"))) {
                    } else if (("\'R\'").equals(format.get("KEEP"))) {
						if(useByte){

    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_109);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_74);
    
                        }else{

    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_112);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_74);
    
						}
                    } else if (("\'M\'").equals(format.get("KEEP"))) {

    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_112);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_80);
    
						if(useByte){

    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_74);
    
						}else{

    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_117);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_74);
    
	                    }
                    } else {
                    	if(useByte){

    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_119);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_74);
    
                    	}else{

    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_74);
    						}
                    }

    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_124);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_126);
    
                    if (("\'L\'").equals(format.get("ALIGN"))) {

    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_131);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(format.get("PADDING_CHAR"));
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_137);
    
                    } else if (("\'R\'").equals(format.get("ALIGN"))) {

    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_131);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(format.get("PADDING_CHAR"));
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_137);
    
                    } else {

    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_142);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(format.get("PADDING_CHAR"));
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(format.get("PADDING_CHAR"));
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(format.get("PADDING_CHAR"));
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_137);
    
                    } 

    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_74);
    
			}//not dynamic end
	          if((i+1)%100==0){

    stringBuffer.append(TEXT_152);
    
              }
    	}
    		  if(sizeColumns>0&&(sizeColumns%100)>0){

    stringBuffer.append(TEXT_153);
    
              }
        }	

    
	  	List< ? extends IConnection> conns = node.getIncomingConnections();
	    for (IConnection conn : conns) {
		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
           for (int i = 0; i < sizeColumns; i++) {
				IMetadataColumn column = columns.get(i);
				Map<String,String> format=formats.get(i);
				JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
				String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
				if(i%100==0){

    stringBuffer.append(TEXT_154);
    stringBuffer.append(i/100);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(NodeUtil.getPrivateConnClassName(conn) );
    stringBuffer.append(TEXT_156);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid );
     if(useByte){ 
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
     } 
    stringBuffer.append(TEXT_160);
    
                }
                if("id_Dynamic".equals(column.getTalendType())){
					if(useExistingDynamic){

    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_162);
    stringBuffer.append(dyn);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_164);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_165);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    
						if(advancedSeparator){

    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_190);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_191);
    
						}

    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    
							if(useByte){

    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_43);
    
    						}else{

    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    
    						}

    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    
								if (("\'L\'").equals(format.get("ALIGN"))) {

    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(format.get("PADDING_CHAR"));
    stringBuffer.append(TEXT_203);
    
								} else if (("\'R\'").equals(format.get("ALIGN"))) {

    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(format.get("PADDING_CHAR"));
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    
								} else {

    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(format.get("PADDING_CHAR"));
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(format.get("PADDING_CHAR"));
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(format.get("PADDING_CHAR"));
    stringBuffer.append(TEXT_203);
    
								}

    stringBuffer.append(TEXT_214);
    
			                    if (("\'A\'").equals(format.get("KEEP"))) {

    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    
			                    } else if (("\'R\'").equals(format.get("KEEP"))) {
			                    	 if(useByte){

    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_223);
    
			                         }else{

    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_223);
    
			                    	 }
			                    } else if (("\'M\'").equals(format.get("KEEP"))) {

    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    
									if(useByte){

    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_223);
    
									}else{

    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_223);
    
			                    	}
			                    } else {
			                    	if(useByte){

    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_223);
    
			                    	}else{

    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_223);
    
									}
								}

    stringBuffer.append(TEXT_234);
    
					}
				}else{

    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_236);
    				
				if(JavaTypesManager.isJavaPrimitiveType( column.getTalendType(), column.isNullable()) ) {
    stringBuffer.append(TEXT_237);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_165);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_238);
    					
				} else {
    stringBuffer.append(TEXT_239);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_165);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_240);
    
					if(javaType == JavaTypesManager.DATE && patternValue!=null){
					
    stringBuffer.append(TEXT_241);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_165);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_190);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_238);
    
					}else if(javaType == JavaTypesManager.BYTE_ARRAY){
					
    stringBuffer.append(TEXT_242);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_165);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_243);
    
					}else if(javaType == JavaTypesManager.STRING){
					
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_165);
    stringBuffer.append(column.getLabel() );
    
					} else if(advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable())) { 
							
    stringBuffer.append(TEXT_244);
     if(javaType == JavaTypesManager.BIGDECIMAL) {
    stringBuffer.append(TEXT_245);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_246);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_190);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_247);
     } else { 
    stringBuffer.append(TEXT_248);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_165);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_249);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_190);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_250);
     } 
    stringBuffer.append(TEXT_251);
    
					}else if (javaType == JavaTypesManager.BIGDECIMAL) {
					
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_252);
     }else{
					
    stringBuffer.append(TEXT_253);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_165);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_238);
    
					}
				}
    stringBuffer.append(TEXT_254);
    if(useByte){
    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_256);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_103);
    }else{
    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_256);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_104);
    }
    stringBuffer.append(TEXT_257);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_258);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_107);
    
                    if (("\'A\'").equals(format.get("KEEP"))) {
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_74);
    
                    } else if (("\'R\'").equals(format.get("KEEP"))) {
                    	 if(useByte){
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_109);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_263);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_223);
    
                         }else{

    stringBuffer.append(TEXT_265);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_112);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_223);
    
                    	 }
                    } else if (("\'M\'").equals(format.get("KEEP"))) {

    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_112);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_80);
    
						if(useByte){

    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_117);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_223);
    
						}else{

    stringBuffer.append(TEXT_265);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_117);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_223);
    
                    	}
                    } else {
                    	if(useByte){

    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_119);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_223);
    
                    	}else{

    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_223);
    
                    	}
                    }
    stringBuffer.append(TEXT_270);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_124);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_271);
    
                    if (("\'L\'").equals(format.get("ALIGN"))) {
                    
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_272);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_131);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_274);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_275);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_276);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(format.get("PADDING_CHAR"));
    stringBuffer.append(TEXT_277);
    
                    } else if (("\'R\'").equals(format.get("ALIGN"))) {
    stringBuffer.append(TEXT_278);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_131);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_274);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_275);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_276);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(format.get("PADDING_CHAR"));
    stringBuffer.append(TEXT_279);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_280);
    
                    } else {
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_142);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_274);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_282);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_283);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_276);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(format.get("PADDING_CHAR"));
    stringBuffer.append(TEXT_279);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_284);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_285);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_286);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_287);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(format.get("PADDING_CHAR"));
    stringBuffer.append(TEXT_288);
    
                    } 
    stringBuffer.append(TEXT_289);
    
				if((i+1)%100==0){

    stringBuffer.append(TEXT_290);
    
				}
				}//other columns (not dynamic)	end
			}
		}
                if(sizeColumns>0&&(sizeColumns%100)>0){

    stringBuffer.append(TEXT_291);
    
                 }
          }

    stringBuffer.append(TEXT_292);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_293);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_294);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_295);
    
		if(!useStream){// the part of file path

    stringBuffer.append(TEXT_296);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(filename);
    stringBuffer.append(TEXT_297);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_298);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_299);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_300);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_301);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_302);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_303);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    
			if(isAppend){

    stringBuffer.append(TEXT_304);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_305);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_306);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_303);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_307);
    
			}
			if(("true").equals(ElementParameterParser.getValue(node,"__CREATE__"))){

    stringBuffer.append(TEXT_308);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_309);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_310);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_311);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_312);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_313);
    
			}
			if(compress && !isAppend){// compress the dest file

    stringBuffer.append(TEXT_314);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_315);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_316);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_317);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_318);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_319);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_320);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_321);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_322);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_323);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_321);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_324);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_325);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_321);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_326);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_327);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_321);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_324);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_328);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_329);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_321);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_324);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_325);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_321);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_326);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_330);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_321);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_322);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_331);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_332);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_333);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_334);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_335);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_336);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_337);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_338);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_339);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_340);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_341);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_342);
    stringBuffer.append(writerClass );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_343);
    stringBuffer.append(writerClass );
    stringBuffer.append(TEXT_344);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append( encoding);
    stringBuffer.append(TEXT_345);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_346);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_74);
    
			}else{

    stringBuffer.append(TEXT_347);
    stringBuffer.append(writerClass );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_343);
    stringBuffer.append(writerClass );
    stringBuffer.append(TEXT_348);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    stringBuffer.append( isAppend);
    stringBuffer.append(TEXT_349);
    stringBuffer.append( encoding);
    stringBuffer.append(TEXT_350);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_346);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_74);
    
			}
		}else{ //the part of the output stream
			if(compress && !isAppend){// compress the dest output stream

    stringBuffer.append(TEXT_351);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_352);
    stringBuffer.append(outStream );
    stringBuffer.append(TEXT_353);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_354);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_355);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append( encoding);
    stringBuffer.append(TEXT_356);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_357);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_358);
    stringBuffer.append(writerClass );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_343);
    stringBuffer.append(writerClass );
    stringBuffer.append(TEXT_359);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_360);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_346);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_74);
    
			}else{

    stringBuffer.append(TEXT_361);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_362);
    stringBuffer.append(outStream );
    stringBuffer.append(TEXT_73);
    stringBuffer.append( encoding);
    stringBuffer.append(TEXT_356);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_357);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_358);
    stringBuffer.append(writerClass );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_343);
    stringBuffer.append(writerClass );
    stringBuffer.append(TEXT_359);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_363);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_346);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_364);
    
			}
		}
		
		if(isIncludeHeader){      	
			if(!useStream){

    stringBuffer.append(TEXT_304);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_365);
    
			}
			

    stringBuffer.append(TEXT_366);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_367);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_368);
    
    		for (int i = 0; i < sizeColumns; i++) {
    			if(i%100==0){

    stringBuffer.append(TEXT_369);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_370);
    stringBuffer.append(i/100);
    stringBuffer.append(TEXT_371);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_372);
    stringBuffer.append(cid );
     if(useByte){ 
    stringBuffer.append(TEXT_373);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_374);
    stringBuffer.append(cid );
     }
    stringBuffer.append(TEXT_74);
    
                }
            }

    stringBuffer.append(TEXT_375);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_376);
    stringBuffer.append(separator);
    stringBuffer.append(TEXT_74);
    
			if(!useStream){

    stringBuffer.append(TEXT_377);
    
			}
		}
    }
}

    stringBuffer.append(TEXT_378);
    return stringBuffer.toString();
  }
}
