package org.talend.designer.codegen.translators.file.input;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.Map;
import java.util.List;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;

public class TFileInputXMLBeginJava
{
  protected static String nl;
  public static synchronized TFileInputXMLBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileInputXMLBeginJava result = new TFileInputXMLBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\t\tlog.debug(\"";
  protected final String TEXT_2 = " - Retrieving records from the datasource.\");" + NL + "\t\t\t";
  protected final String TEXT_3 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_4 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_5 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_6 = " - Retrieved records count: \"+ globalMap.get(\"";
  protected final String TEXT_7 = "_NB_LINE\") + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_8 = " - Written records count: \" + nb_line_";
  protected final String TEXT_9 = NL + "\t\t\t\tfinal StringBuffer log4jSb_";
  protected final String TEXT_10 = " = new StringBuffer();" + NL + "\t\t\t";
  protected final String TEXT_11 = " - Retrieving the record \" + (nb_line_";
  protected final String TEXT_12 = ") + \".\");" + NL + "\t\t\t";
  protected final String TEXT_13 = " - Writing the record \" + nb_line_";
  protected final String TEXT_14 = " + \" to the file.\");" + NL + "\t\t\t";
  protected final String TEXT_15 = " - Processing the record \" + nb_line_";
  protected final String TEXT_16 = " + \".\");" + NL + "\t\t\t";
  protected final String TEXT_17 = " - Processed records count: \" + nb_line_";
  protected final String TEXT_18 = NL + "                log.error(message_";
  protected final String TEXT_19 = ");";
  protected final String TEXT_20 = NL + "                System.err.println(message_";
  protected final String TEXT_21 = NL + "\t";
  protected final String TEXT_22 = NL + "\t\t\trowHelper_";
  protected final String TEXT_23 = ".valueToConn(";
  protected final String TEXT_24 = ", ";
  protected final String TEXT_25 = " ";
  protected final String TEXT_26 = ");" + NL + "\t\t";
  protected final String TEXT_27 = ".valueToConnWithD(";
  protected final String TEXT_28 = ".connToConn(";
  protected final String TEXT_29 = ",";
  protected final String TEXT_30 = NL + "\t\t\t\tclass RowHelper_";
  protected final String TEXT_31 = "{" + NL + "\t\t\t\t";
  protected final String TEXT_32 = NL + "\t\t\t\t\tpublic void valueToConn_";
  protected final String TEXT_33 = "(";
  protected final String TEXT_34 = "Struct ";
  protected final String TEXT_35 = ") throws java.lang.Exception{" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_36 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_37 = NL + "\t\t\t\t\tpublic void valueToConnWithD_";
  protected final String TEXT_38 = ", routines.system.Dynamic ";
  protected final String TEXT_39 = NL + "\t\t\t\t\tpublic void connToConn_";
  protected final String TEXT_40 = NL + "\t\t\t\t\tpublic void valueToConn(";
  protected final String TEXT_41 = ") throws java.lang.Exception{" + NL + "\t\t\t\t";
  protected final String TEXT_42 = NL + "\t\t\t\t\tpublic void valueToConnWithD(";
  protected final String TEXT_43 = NL + "\t\t\t\t\t\tvalueToConn_";
  protected final String TEXT_44 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_45 = NL + "\t\t\t\t\t\tvalueToConnWithD_";
  protected final String TEXT_46 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_47 = NL + "\t\t\t\t\tpublic void connToConn(";
  protected final String TEXT_48 = ") throws java.lang.Exception{" + NL + "\t\t\t\t\t";
  protected final String TEXT_49 = NL + "\t\t\t\t\t\tconnToConn_";
  protected final String TEXT_50 = ");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_51 = NL + "\t\t\t\t}" + NL + "\t\t\t\tRowHelper_";
  protected final String TEXT_52 = " rowHelper_";
  protected final String TEXT_53 = "  = new RowHelper_";
  protected final String TEXT_54 = "();" + NL + "\t\t\t";
  protected final String TEXT_55 = NL;
  protected final String TEXT_56 = NL + "int nb_line_";
  protected final String TEXT_57 = " = 0;" + NL;
  protected final String TEXT_58 = NL + "class IgnoreDTDEntityResolver_";
  protected final String TEXT_59 = " implements org.xml.sax.EntityResolver {" + NL + "" + NL + " public org.xml.sax.InputSource resolveEntity(String publicId, String systemId)" + NL + "   throws org.xml.sax.SAXException, java.io.IOException {" + NL + "        return new org.xml.sax.InputSource(new java.io.ByteArrayInputStream(\"<?xml version='1.0' encoding='UTF-8'?>\".getBytes()));" + NL + " }" + NL + "" + NL + "}";
  protected final String TEXT_60 = NL + "\tString os_";
  protected final String TEXT_61 = " = System.getProperty(\"os.name\").toLowerCase();" + NL + "\tboolean isWindows_";
  protected final String TEXT_62 = "=false;" + NL + "\tif(os_";
  protected final String TEXT_63 = ".indexOf(\"windows\") > -1 || os_";
  protected final String TEXT_64 = ".indexOf(\"nt\") > -1){" + NL + "\t\tisWindows_";
  protected final String TEXT_65 = "=true;" + NL + "\t}";
  protected final String TEXT_66 = NL + "class TalendPrefixResolver_";
  protected final String TEXT_67 = " {" + NL + "" + NL + "    private java.util.Map<String, String> map = new java.util.HashMap<String, String>();" + NL + "    " + NL + "\tprivate java.util.List<String> defualtNSPath = new java.util.ArrayList<String>();" + NL + "\t" + NL + "\tpublic java.util.List<String> getDefualtNSPath() {" + NL + "\t\treturn defualtNSPath;" + NL + "\t}" + NL + "\t" + NL + "    public String getNamespaceURI(String prefix) {" + NL + "        if ((\"xml\").equals(prefix)) {" + NL + "            return \"http://www.w3.org/XML/1998/namespace\";" + NL + "        } else {" + NL + "            return map.get(prefix);" + NL + "        }" + NL + "    }" + NL + "" + NL + "    public boolean countNSMap(org.w3c.dom.Node el) {" + NL + "    \tboolean hasDefaultPrefix = false;" + NL + "        if (el.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE) {" + NL + "            org.w3c.dom.NamedNodeMap attris = el.getAttributes();" + NL + "            for (int i = 0; i < attris.getLength(); i++) {" + NL + "                org.w3c.dom.Node attr = attris.item(i);" + NL + "                String aname = attr.getNodeName();" + NL + "                if (aname.startsWith(\"xmlns\")) {" + NL + "                    int index = aname.indexOf(\":\");" + NL + "                    if(index > 0){" + NL + "                    \taname = aname.substring(index + 1);" + NL + "                    }else{" + NL + "                    \taname = \"pre\"+defualtNSPath.size();" + NL + "                    \thasDefaultPrefix = true;" + NL + "                    \tString path = \"\";" + NL + "                    \torg.w3c.dom.Node elTmp = el;" + NL + "                    \twhile(elTmp!=null && !(elTmp instanceof org.w3c.dom.Document)){" + NL + "\t\t\t\t\t\t\tpath = \"/\"+elTmp.getNodeName()+path;" + NL + "                    \t\telTmp = elTmp.getParentNode();" + NL + "                    \t}" + NL + "                        defualtNSPath.add(path);" + NL + "                    }" + NL + "                    map.put(aname, attr.getNodeValue());" + NL + "                }" + NL + "            }" + NL + "        }" + NL + "        org.w3c.dom.NodeList nodeList = el.getChildNodes();" + NL + "        for (int i = 0; i < nodeList.getLength(); i++) {" + NL + "            hasDefaultPrefix = hasDefaultPrefix | countNSMap(nodeList.item(i));" + NL + "        }" + NL + "        return hasDefaultPrefix;" + NL + "    }" + NL + "    " + NL + "}" + NL + "" + NL + "class XML_API_";
  protected final String TEXT_68 = "{" + NL + "" + NL + "\tjavax.xml.xpath.XPath xpathEvaluator = new net.sf.saxon.xpath.XPathFactoryImpl().newXPath();" + NL + "\t" + NL + "\tString loopPath = null;" + NL + "\tboolean hasDefaultNS = false;" + NL + "\t" + NL + "\tpublic boolean isDefNull(org.w3c.dom.Node node) throws javax.xml.transform.TransformerException {" + NL + "        if (node != null && node.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE) {" + NL + "            return ((org.apache.xerces.xs.ElementPSVI) node).getNil();" + NL + "        }" + NL + "        return false;" + NL + "    }" + NL + "" + NL + "    public boolean isMissing(org.w3c.dom.Node node) throws javax.xml.transform.TransformerException {" + NL + "        return node == null ? true : false;" + NL + "    }" + NL + "" + NL + "    public boolean isEmpty(org.w3c.dom.Node node) throws javax.xml.transform.TransformerException {" + NL + "        if (node != null) {" + NL + "            return node.getTextContent().length() == 0;" + NL + "        }" + NL + "        return false;" + NL + "    }" + NL + "" + NL + "    private final org.talend.xpath.XPathUtil util = new  org.talend.xpath.XPathUtil();" + NL + "" + NL + "    public void initXPath(org.w3c.dom.Node root){" + NL + "        final TalendPrefixResolver_";
  protected final String TEXT_69 = " pr = new TalendPrefixResolver_";
  protected final String TEXT_70 = "();" + NL + "        hasDefaultNS = pr.countNSMap(root);" + NL + "        util.setDefaultNSPath(pr.getDefualtNSPath());" + NL + "        " + NL + "        xpathEvaluator.setNamespaceContext(new javax.xml.namespace.NamespaceContext() {" + NL + "            @Override" + NL + "            public String getNamespaceURI(String prefix) {" + NL + "                return pr.getNamespaceURI(prefix);" + NL + "            }" + NL + "" + NL + "            @Override" + NL + "            public String getPrefix(String namespaceURI) {" + NL + "                return null;" + NL + "            }" + NL + "" + NL + "            @Override" + NL + "            public java.util.Iterator getPrefixes(String namespaceURI) {" + NL + "                return null;" + NL + "            }" + NL + "        });" + NL + "    }" + NL + "" + NL + "//==============add for feature 10753 start================================" + NL + "\tpublic String getNodeString(org.w3c.dom.Node node, String xpath) throws javax.xml.xpath.XPathExpressionException {" + NL + "\t\tjavax.xml.xpath.XPathExpression expression = xpathEvaluator.compile(util.addDefaultNSPrefix(xpath,loopPath));" + NL + "\t\treturn expression.evaluate(node);" + NL + "\t}" + NL + "" + NL + "    public org.w3c.dom.Node getSingleNode(org.w3c.dom.Node node, String xpath) throws javax.xml.xpath.XPathExpressionException {" + NL + "        javax.xml.xpath.XPathExpression expression = xpathEvaluator.compile(util.addDefaultNSPrefix(xpath,loopPath));" + NL + "        Object result = expression.evaluate(node, javax.xml.xpath.XPathConstants.NODESET);" + NL + "        return org.w3c.dom.NodeList.class.cast(result).item(0);" + NL + "    }" + NL + "//=====================end=================================================" + NL + "" + NL + "    public org.w3c.dom.NodeList getNodeList(org.w3c.dom.Node node, String xpath) throws javax.xml.xpath.XPathExpressionException {" + NL + "        javax.xml.xpath.XPathExpression expression = xpathEvaluator.compile(util.addDefaultNSPrefix(xpath));" + NL + "        Object result = expression.evaluate(node, javax.xml.xpath.XPathConstants.NODESET);" + NL + "        return org.w3c.dom.NodeList.class.cast(result);" + NL + "    }" + NL + "    " + NL + "}" + NL;
  protected final String TEXT_71 = NL + "class ContentTool_";
  protected final String TEXT_72 = "{" + NL + "\tpublic String field_separator=\",\";//default value" + NL + "\t" + NL + "\tpublic String getNodeContent(org.w3c.dom.Node node){" + NL + "\t\tString result=getSubNodeContent(node);" + NL + "\t\tif(result.equals(\"\")) return \"\";" + NL + "\t\telse return result.substring(1);" + NL + "\t}" + NL + "\t" + NL + "\tprivate String getSubNodeContent(org.w3c.dom.Node node){" + NL + "\t\tif(node==null) return \"\";" + NL + "\t\t" + NL + "\t\tString tmp=node.getNodeValue();" + NL + "\t\t" + NL + "\t\tif(tmp==null){" + NL + "\t\t\ttmp=\"\";" + NL + "\t\t}else{" + NL + "\t\t\ttmp=field_separator+tmp;" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tif(node.hasChildNodes()){" + NL + "\t\t\torg.w3c.dom.NodeList nodeList = node.getChildNodes();" + NL + "\t\t\tfor(int i=0;i<nodeList.getLength();i++){" + NL + "\t\t\t\torg.w3c.dom.Node tmpNode= nodeList.item(i);\t" + NL + "\t\t\t\ttmp=tmp+getSubNodeContent(tmpNode);" + NL + "" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\treturn tmp;" + NL + "\t}" + NL + "}" + NL + "ContentTool_";
  protected final String TEXT_73 = " contentTool_";
  protected final String TEXT_74 = " = new ContentTool_";
  protected final String TEXT_75 = "();" + NL + "contentTool_";
  protected final String TEXT_76 = ".field_separator=";
  protected final String TEXT_77 = ";";
  protected final String TEXT_78 = NL + NL + "XML_API_";
  protected final String TEXT_79 = " xml_api_";
  protected final String TEXT_80 = " = new XML_API_";
  protected final String TEXT_81 = "();" + NL + "xml_api_";
  protected final String TEXT_82 = ".loopPath=";
  protected final String TEXT_83 = ";" + NL + "org.apache.xerces.parsers.DOMParser parser_";
  protected final String TEXT_84 = " = new org.apache.xerces.parsers.DOMParser();";
  protected final String TEXT_85 = NL + "parser_";
  protected final String TEXT_86 = ".setEntityResolver(new IgnoreDTDEntityResolver_";
  protected final String TEXT_87 = "());";
  protected final String TEXT_88 = ".setProperty(\"http://apache.org/xml/properties/dom/document-class-name\"," + NL + "        \"org.apache.xerces.dom.PSVIDocumentImpl\");" + NL + "parser_";
  protected final String TEXT_89 = ".setFeature(\"http://xml.org/sax/features/validation\", true);" + NL + "parser_";
  protected final String TEXT_90 = ".setFeature(\"http://apache.org/xml/features/validation/schema\", true);" + NL + "parser_";
  protected final String TEXT_91 = ".setFeature(\"http://apache.org/xml/features/validation/schema-full-checking\", true);" + NL + "parser_";
  protected final String TEXT_92 = ".setFeature(\"http://xml.org/sax/features/namespaces\", true);" + NL + "parser_";
  protected final String TEXT_93 = ".setErrorHandler(null);" + NL + "Object filename_";
  protected final String TEXT_94 = " = null;" + NL + "try {" + NL + "\tfilename_";
  protected final String TEXT_95 = " = ";
  protected final String TEXT_96 = ";" + NL + "} catch(java.lang.Exception e) {" + NL + "globalMap.put(\"";
  protected final String TEXT_97 = "_ERROR_MESSAGE\",e.getMessage());" + NL + "\t";
  protected final String TEXT_98 = NL + "\tthrow(e);" + NL + "\t";
  protected final String TEXT_99 = NL + "\t";
  protected final String TEXT_100 = NL + "\t\tlog.error(\"";
  protected final String TEXT_101 = " - \" + e.getMessage());" + NL + "\t";
  protected final String TEXT_102 = NL + "\tSystem.err.println(e.getMessage());" + NL + "\t";
  protected final String TEXT_103 = NL + "}" + NL + "" + NL + "boolean isValidFile_";
  protected final String TEXT_104 = " = true;" + NL + "java.io.Closeable toClose_";
  protected final String TEXT_105 = " = null;" + NL + "try{" + NL + "    if(filename_";
  protected final String TEXT_106 = " != null && filename_";
  protected final String TEXT_107 = " instanceof String && filename_";
  protected final String TEXT_108 = ".toString().startsWith(\"//\")){" + NL + "\t\tif (!isWindows_";
  protected final String TEXT_109 = "){" + NL + "\t\t\tfilename_";
  protected final String TEXT_110 = " = filename_";
  protected final String TEXT_111 = ".toString().replaceFirst(\"//\",\"/\");" + NL + "\t\t}" + NL + "    }" + NL + "    if(filename_";
  protected final String TEXT_112 = " instanceof java.io.InputStream){" + NL + "    \tjava.io.InputStream inputStream_";
  protected final String TEXT_113 = " = (java.io.InputStream)filename_";
  protected final String TEXT_114 = ";" + NL + "    \ttoClose_";
  protected final String TEXT_115 = " = inputStream_";
  protected final String TEXT_116 = ";" + NL + "    \tparser_";
  protected final String TEXT_117 = ".parse(new org.xml.sax.InputSource(inputStream_";
  protected final String TEXT_118 = "));" + NL + "    }else{" + NL + "    \tjava.io.InputStream in_";
  protected final String TEXT_119 = "= new java.io.FileInputStream(String.valueOf(filename_";
  protected final String TEXT_120 = "));" + NL + "    \tjava.io.Reader unicodeReader_";
  protected final String TEXT_121 = " = new UnicodeReader(in_";
  protected final String TEXT_122 = ");" + NL + "    \ttoClose_";
  protected final String TEXT_123 = " = unicodeReader_";
  protected final String TEXT_124 = ";" + NL + "    \torg.xml.sax.InputSource xmlInputSource_";
  protected final String TEXT_125 = " = new org.xml.sax.InputSource(unicodeReader_";
  protected final String TEXT_126 = ");" + NL + "    \tparser_";
  protected final String TEXT_127 = ".parse(xmlInputSource_";
  protected final String TEXT_128 = ");" + NL + "    }" + NL + "}catch(java.lang.Exception e){" + NL + "globalMap.put(\"";
  protected final String TEXT_129 = "_ERROR_MESSAGE\",e.getMessage());";
  protected final String TEXT_130 = NL + "\tthrow(e);";
  protected final String TEXT_131 = NL + "\tSystem.err.println(e.getMessage());" + NL + "\tisValidFile_";
  protected final String TEXT_132 = " = false;";
  protected final String TEXT_133 = NL + "}finally {" + NL + "\tif(toClose_";
  protected final String TEXT_134 = "!=null) {" + NL + "\t\ttoClose_";
  protected final String TEXT_135 = ".close();" + NL + "\t}" + NL + "}" + NL + "if(isValidFile_";
  protected final String TEXT_136 = "){" + NL + "org.w3c.dom.Document doc_";
  protected final String TEXT_137 = " = parser_";
  protected final String TEXT_138 = ".getDocument();" + NL + "" + NL + "xml_api_";
  protected final String TEXT_139 = ".initXPath(doc_";
  protected final String TEXT_140 = ");" + NL + "org.w3c.dom.NodeList nodelist_";
  protected final String TEXT_141 = " = xml_api_";
  protected final String TEXT_142 = ".getNodeList(doc_";
  protected final String TEXT_143 = ");" + NL + "" + NL + "org.w3c.dom.Node node_";
  protected final String TEXT_144 = "  = null;" + NL + "String str_";
  protected final String TEXT_145 = " = null;";
  protected final String TEXT_146 = NL + "for (int i_";
  protected final String TEXT_147 = " = 0; i_";
  protected final String TEXT_148 = " < nodelist_";
  protected final String TEXT_149 = ".getLength(); i_";
  protected final String TEXT_150 = "++) {" + NL + "\torg.w3c.dom.Node tmp_";
  protected final String TEXT_151 = " = nodelist_";
  protected final String TEXT_152 = ".item(i_";
  protected final String TEXT_153 = NL + "class NameSpaceTool_";
  protected final String TEXT_154 = " {" + NL + "" + NL + "    public java.util.HashMap<String, String> xmlNameSpaceMap = new java.util.HashMap<String, String>();" + NL + "    " + NL + "\tprivate java.util.List<String> defualtNSPath = new java.util.ArrayList<String>();" + NL + "" + NL + "    public void countNSMap(org.dom4j.Element el) {" + NL + "        for (org.dom4j.Namespace ns : (java.util.List<org.dom4j.Namespace>) el.declaredNamespaces()) {" + NL + "            if (ns.getPrefix().trim().length() == 0) {" + NL + "                xmlNameSpaceMap.put(\"pre\"+defualtNSPath.size(), ns.getURI());" + NL + "                String path = \"\";" + NL + "                org.dom4j.Element elTmp = el;" + NL + "                while (elTmp != null) {" + NL + "                \tif (elTmp.getNamespacePrefix() != null && elTmp.getNamespacePrefix().length() > 0) {" + NL + "                        path = \"/\" + elTmp.getNamespacePrefix() + \":\" + elTmp.getName() + path;" + NL + "                    } else {" + NL + "                        path = \"/\" + elTmp.getName() + path;" + NL + "                    }" + NL + "                    elTmp = elTmp.getParent();" + NL + "                }" + NL + "                defualtNSPath.add(path);" + NL + "            } else {" + NL + "                xmlNameSpaceMap.put(ns.getPrefix(), ns.getURI());" + NL + "            }" + NL + "" + NL + "        }" + NL + "        for (org.dom4j.Element e : (java.util.List<org.dom4j.Element>) el.elements()) {" + NL + "            countNSMap(e);" + NL + "        }" + NL + "    }" + NL + "    " + NL + "    private final org.talend.xpath.XPathUtil util = new  org.talend.xpath.XPathUtil();" + NL + "    " + NL + "    {" + NL + "    \tutil.setDefaultNSPath(defualtNSPath);" + NL + "    }" + NL + "    " + NL + "\tpublic String addDefaultNSPrefix(String path) {" + NL + "\t\treturn util.addDefaultNSPrefix(path);" + NL + "\t}" + NL + "\t" + NL + "\tpublic String addDefaultNSPrefix(String relativeXpression, String basePath) {" + NL + "\t\treturn util.addDefaultNSPrefix(relativeXpression,basePath);" + NL + "\t}" + NL + "    " + NL + "}" + NL + "" + NL + "class XML_API_";
  protected final String TEXT_155 = "{" + NL + "\tpublic boolean isDefNull(org.dom4j.Node node) throws javax.xml.transform.TransformerException {" + NL + "        if (node != null && node instanceof org.dom4j.Element) {" + NL + "        \torg.dom4j.Attribute attri = ((org.dom4j.Element)node).attribute(\"nil\");" + NL + "        \tif(attri != null && (\"true\").equals(attri.getText())){" + NL + "            \treturn true;" + NL + "            }" + NL + "        }" + NL + "        return false;" + NL + "    }" + NL + "" + NL + "    public boolean isMissing(org.dom4j.Node node) throws javax.xml.transform.TransformerException {" + NL + "        return node == null ? true : false;" + NL + "    }" + NL + "" + NL + "    public boolean isEmpty(org.dom4j.Node node) throws javax.xml.transform.TransformerException {" + NL + "        if (node != null) {" + NL + "            return node.getStringValue().isEmpty();" + NL + "        }" + NL + "        return false;" + NL + "    }" + NL + "}" + NL;
  protected final String TEXT_156 = NL + "\tclass XML_NS_RMV_";
  protected final String TEXT_157 = "{\t" + NL + "" + NL + "\t\tpublic void removeNamespace(org.dom4j.Document reader," + NL + "\t\t\t\torg.dom4j.Document writer) {" + NL + "\t\t\torg.dom4j.Element elemReader = reader.getRootElement();" + NL + "\t\t\torg.dom4j.Element elemTo = writer.addElement(elemReader" + NL + "\t\t\t\t\t.getName());" + NL + "\t\t\tif(elemReader!=null && elemReader.getText()!=null && !\"\".equals(elemReader.getText())){" + NL + "\t\t\t\telemTo.setText(elemReader.getText());" + NL + "\t\t\t}" + NL + "\t\t\tfor (org.dom4j.Attribute attri : (List<org.dom4j.Attribute>) elemReader" + NL + "\t\t\t\t\t.attributes()) {" + NL + "\t\t\t\telemTo.addAttribute(attri.getName(),attri.getText());" + NL + "\t\t\t}" + NL + "\t\t\tremoveSubNamespace(elemReader, elemTo);" + NL + "\t\t}" + NL + "" + NL + "\t\tpublic void removeSubNamespace(org.dom4j.Element elemFrom," + NL + "\t\t\t\torg.dom4j.Element elemTo) {" + NL + "\t\t\tfor (org.dom4j.Element subFrom : (List<org.dom4j.Element>) elemFrom" + NL + "\t\t\t\t\t.elements()) {" + NL + "\t\t\t\torg.dom4j.Element tmpElemTo = elemTo.addElement(subFrom" + NL + "\t\t\t\t\t\t.getName());" + NL + "\t\t\t\tif(subFrom!=null && subFrom.getText()!=null && !\"\".equals(subFrom.getText())){" + NL + "\t\t\t\t\ttmpElemTo.setText(subFrom.getText());" + NL + "\t\t\t\t}" + NL + "\t\t\t\tfor (org.dom4j.Attribute attri : (List<org.dom4j.Attribute>) subFrom" + NL + "\t\t\t\t\t\t.attributes()) {" + NL + "\t\t\t\t\ttmpElemTo.addAttribute(attri.getName(),attri.getText());" + NL + "\t\t\t\t}" + NL + "\t\t\t\tremoveSubNamespace(subFrom, tmpElemTo);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_158 = NL + NL + "org.dom4j.io.SAXReader reader_";
  protected final String TEXT_159 = " = new org.dom4j.io.SAXReader();";
  protected final String TEXT_160 = NL + "reader_";
  protected final String TEXT_161 = NL + "Object filename_";
  protected final String TEXT_162 = NL + "}" + NL + "if(filename_";
  protected final String TEXT_163 = ".toString().startsWith(\"//\")){" + NL + "\tif (!isWindows_";
  protected final String TEXT_164 = "){" + NL + "\t\tfilename_";
  protected final String TEXT_165 = ".toString().replaceFirst(\"//\",\"/\");" + NL + "\t}" + NL + "}" + NL;
  protected final String TEXT_166 = NL + "org.dom4j.Document doc_reader_";
  protected final String TEXT_167 = " = null;" + NL + "org.dom4j.Document doc_tmp_";
  protected final String TEXT_168 = " = org.dom4j.DocumentHelper.createDocument();" + NL + "org.dom4j.io.OutputFormat format_";
  protected final String TEXT_169 = " = org.dom4j.io.OutputFormat.createPrettyPrint();" + NL + "try {" + NL + "\tif(filename_";
  protected final String TEXT_170 = " instanceof java.io.InputStream){" + NL + "\t\tdoc_reader_";
  protected final String TEXT_171 = " = reader_";
  protected final String TEXT_172 = ".read((java.io.InputStream)filename_";
  protected final String TEXT_173 = ");" + NL + "\t}else{" + NL + "\t\tdoc_reader_";
  protected final String TEXT_174 = ".read(new java.io.File(String.valueOf(filename_";
  protected final String TEXT_175 = ")).toURI().toString());" + NL + "\t}" + NL + "\tformat_";
  protected final String TEXT_176 = ".setTrimText(false);" + NL + "\tformat_";
  protected final String TEXT_177 = ".setEncoding(";
  protected final String TEXT_178 = ");" + NL + "\tnew XML_NS_RMV_";
  protected final String TEXT_179 = "().removeNamespace(doc_reader_";
  protected final String TEXT_180 = ",doc_tmp_";
  protected final String TEXT_181 = ");" + NL + "\tdoc_reader_";
  protected final String TEXT_182 = ".clearContent();" + NL + "\tdoc_reader_";
  protected final String TEXT_183 = " = null;" + NL + "\tjava.io.FileOutputStream stream_";
  protected final String TEXT_184 = " = new java.io.FileOutputStream(";
  protected final String TEXT_185 = ");" + NL + "\torg.dom4j.io.XMLWriter output_";
  protected final String TEXT_186 = " = new org.dom4j.io.XMLWriter(stream_";
  protected final String TEXT_187 = ", format_";
  protected final String TEXT_188 = ");" + NL + "\toutput_";
  protected final String TEXT_189 = ".write(doc_tmp_";
  protected final String TEXT_190 = ".close();" + NL + "} catch(java.lang.Exception e) {" + NL + "globalMap.put(\"";
  protected final String TEXT_191 = NL + "} finally {" + NL + "\tif(filename_";
  protected final String TEXT_192 = " instanceof java.io.InputStream && filename_";
  protected final String TEXT_193 = "!=null){" + NL + "\t\t((java.io.InputStream)filename_";
  protected final String TEXT_194 = ").close();" + NL + "\t}" + NL + "}" + NL + "filename_";
  protected final String TEXT_195 = NL + "boolean isValidFile_";
  protected final String TEXT_196 = " = true;" + NL + "org.dom4j.Document doc_";
  protected final String TEXT_197 = " = null;" + NL + "java.io.Closeable toClose_";
  protected final String TEXT_198 = " = null;" + NL + "try{" + NL + "\tif(filename_";
  protected final String TEXT_199 = " instanceof java.io.InputStream){" + NL + "\t\tjava.io.InputStream inputStream_";
  protected final String TEXT_200 = ";" + NL + "\t\ttoClose_";
  protected final String TEXT_201 = ";" + NL + "\t\tdoc_";
  protected final String TEXT_202 = ".read(inputStream_";
  protected final String TEXT_203 = ");" + NL + "\t}else{" + NL + "\t\tjava.io.Reader unicodeReader_";
  protected final String TEXT_204 = " = new UnicodeReader(new java.io.FileInputStream(String.valueOf(filename_";
  protected final String TEXT_205 = ")),";
  protected final String TEXT_206 = ");" + NL + "\t\ttoClose_";
  protected final String TEXT_207 = ";" + NL + "\t\torg.xml.sax.InputSource in_";
  protected final String TEXT_208 = "= new org.xml.sax.InputSource(unicodeReader_";
  protected final String TEXT_209 = ");" + NL + "\t\tdoc_";
  protected final String TEXT_210 = ".read(in_";
  protected final String TEXT_211 = ");" + NL + "\t}" + NL + "}catch(java.lang.Exception e){" + NL + "globalMap.put(\"";
  protected final String TEXT_212 = NL + "} finally {" + NL + "\tif(toClose_";
  protected final String TEXT_213 = "){" + NL + "NameSpaceTool_";
  protected final String TEXT_214 = " nsTool_";
  protected final String TEXT_215 = " = new NameSpaceTool_";
  protected final String TEXT_216 = "();" + NL + "nsTool_";
  protected final String TEXT_217 = ".countNSMap(doc_";
  protected final String TEXT_218 = ".getRootElement());" + NL + "java.util.HashMap<String,String> xmlNameSpaceMap_";
  protected final String TEXT_219 = " = nsTool_";
  protected final String TEXT_220 = ".xmlNameSpaceMap;  " + NL + "" + NL + "org.dom4j.XPath x_";
  protected final String TEXT_221 = " = doc_";
  protected final String TEXT_222 = ".createXPath(nsTool_";
  protected final String TEXT_223 = ".addDefaultNSPrefix(";
  protected final String TEXT_224 = "));  " + NL + "x_";
  protected final String TEXT_225 = ".setNamespaceURIs(xmlNameSpaceMap_";
  protected final String TEXT_226 = "); ";
  protected final String TEXT_227 = NL + "org.jaxen.NamespaceContext namespaceContext_";
  protected final String TEXT_228 = " = new org.jaxen.NamespaceContext() {" + NL + "" + NL + "\tpublic String translateNamespacePrefixToUri(String prefix) { " + NL + "\t\treturn \"\";//ignore prefix in xpath when evaluate" + NL + "\t}" + NL + "\t" + NL + "};" + NL + "x_";
  protected final String TEXT_229 = ".setNamespaceContext(namespaceContext_";
  protected final String TEXT_230 = NL + NL + "java.util.List<org.dom4j.Node> nodeList_";
  protected final String TEXT_231 = " = (java.util.List<org.dom4j.Node>)x_";
  protected final String TEXT_232 = ".selectNodes(doc_";
  protected final String TEXT_233 = ");\t" + NL + "XML_API_";
  protected final String TEXT_234 = "();" + NL + "String str_";
  protected final String TEXT_235 = " = \"\";" + NL + "org.dom4j.Node node_";
  protected final String TEXT_236 = " = null;" + NL + "" + NL + "//init all mapping xpaths" + NL + "java.util.Map<Integer,org.dom4j.XPath> xpaths_";
  protected final String TEXT_237 = "=new java.util.HashMap<Integer,org.dom4j.XPath>();";
  protected final String TEXT_238 = NL + "\tclass XPathUtil_";
  protected final String TEXT_239 = "{" + NL + "\t";
  protected final String TEXT_240 = NL + "\t\t\t   public void initXPaths_";
  protected final String TEXT_241 = "(java.util.Map<Integer,org.dom4j.XPath> xpaths,NameSpaceTool_";
  protected final String TEXT_242 = " nsTool," + NL + "\t\t\t       java.util.HashMap<String,String> xmlNameSpaceMap";
  protected final String TEXT_243 = ",org.jaxen.NamespaceContext namespaceContext";
  protected final String TEXT_244 = "){" + NL + "\t\t\t";
  protected final String TEXT_245 = NL + "\torg.dom4j.XPath xpath_";
  protected final String TEXT_246 = " = org.dom4j.DocumentHelper.createXPath(nsTool.addDefaultNSPrefix(";
  protected final String TEXT_247 = "));" + NL + "\txpath_";
  protected final String TEXT_248 = ".setNamespaceURIs(xmlNameSpaceMap);" + NL + "\t";
  protected final String TEXT_249 = NL + "\txpath_";
  protected final String TEXT_250 = ".setNamespaceContext(namespaceContext);" + NL + "\t";
  protected final String TEXT_251 = NL + "\t\t\txpaths.put(";
  protected final String TEXT_252 = ",xpath_";
  protected final String TEXT_253 = ");" + NL + "\t\t\t";
  protected final String TEXT_254 = NL + "\t         }" + NL + "\t      ";
  protected final String TEXT_255 = NL + "\t     }" + NL + "\t   ";
  protected final String TEXT_256 = NL + "\t      public void initXPaths(java.util.Map<Integer,org.dom4j.XPath> xpaths,NameSpaceTool_";
  protected final String TEXT_257 = " nsTool," + NL + "\t\t\t    java.util.HashMap<String,String> xmlNameSpaceMap";
  protected final String TEXT_258 = "){" + NL + "\t\t\t    ";
  protected final String TEXT_259 = NL + "\t\t\t        initXPaths_";
  protected final String TEXT_260 = "(xpaths,nsTool, xmlNameSpaceMap";
  protected final String TEXT_261 = ",namespaceContext";
  protected final String TEXT_262 = ");" + NL + "\t\t\t    ";
  protected final String TEXT_263 = NL + "\t\t   }" + NL + "\t}" + NL + "\tXPathUtil_";
  protected final String TEXT_264 = " xPathUtil_";
  protected final String TEXT_265 = " = new XPathUtil_";
  protected final String TEXT_266 = "();" + NL + "\txPathUtil_";
  protected final String TEXT_267 = ".initXPaths(xpaths_";
  protected final String TEXT_268 = ", nsTool_";
  protected final String TEXT_269 = ", xmlNameSpaceMap_";
  protected final String TEXT_270 = ", namespaceContext_";
  protected final String TEXT_271 = NL + "\tif(true){" + NL + "\t\tthrow new IllegalArgumentException(\"Min column number of optimize code should be bigger than 0!\");" + NL + "\t}";
  protected final String TEXT_272 = NL + "for (org.dom4j.Node temp_";
  protected final String TEXT_273 = ": nodeList_";
  protected final String TEXT_274 = ") {";
  protected final String TEXT_275 = NL + "class XML_API_";
  protected final String TEXT_276 = "{" + NL + "\tpublic boolean isDefNull(String[] node) throws javax.xml.transform.TransformerException {" + NL + "        if(node[0] != null && node[1]!=null && (\"true\").equals(node[1])){" + NL + "        \treturn true;" + NL + "        }" + NL + "        return false;" + NL + "    }" + NL + "" + NL + "    public boolean isMissing(String[] node) throws javax.xml.transform.TransformerException {" + NL + "        return node[0] == null ? true : false;" + NL + "    }" + NL + "" + NL + "    public boolean isEmpty(String[] node) throws javax.xml.transform.TransformerException {" + NL + "        if(node[0]!=null ){" + NL + "        \treturn node[0].length() == 0;" + NL + "        }" + NL + "        return false;" + NL + "    }" + NL + "}" + NL + "XML_API_";
  protected final String TEXT_277 = "();" + NL + "" + NL + "String[] queryPaths_";
  protected final String TEXT_278 = " = new String[]{";
  protected final String TEXT_279 = "\t" + NL + "\t";
  protected final String TEXT_280 = "\t\t" + NL + "\t,";
  protected final String TEXT_281 = "+\"/@xsi:nil\"";
  protected final String TEXT_282 = NL + "};" + NL + "" + NL + "boolean[] asXMLs_";
  protected final String TEXT_283 = " = new boolean[]{";
  protected final String TEXT_284 = "\t\t" + NL + "\t,false";
  protected final String TEXT_285 = NL + "};" + NL + "" + NL + "String str_";
  protected final String TEXT_286 = " = \"\";" + NL + "String[] node_";
  protected final String TEXT_287 = " = null;" + NL + "org.talend.xml.sax.SAXLooper looper_";
  protected final String TEXT_288 = " = new org.talend.xml.sax.SAXLooper(";
  protected final String TEXT_289 = ",queryPaths_";
  protected final String TEXT_290 = ",asXMLs_";
  protected final String TEXT_291 = NL + "looper_";
  protected final String TEXT_292 = ".setIgnoreDTD(true);";
  protected final String TEXT_293 = ");" + NL + "Object filename_";
  protected final String TEXT_294 = NL + "\tlog.error(\"";
  protected final String TEXT_295 = " - \" + e.getMessage());" + NL + "\t\t";
  protected final String TEXT_296 = ".toString().replaceFirst(\"//\",\"/\");" + NL + "\t}" + NL + "}" + NL + "if(filename_";
  protected final String TEXT_297 = " instanceof java.io.InputStream){" + NL + "\tlooper_";
  protected final String TEXT_298 = ".parse((java.io.InputStream)filename_";
  protected final String TEXT_299 = ");" + NL + "}else{" + NL + "\tlooper_";
  protected final String TEXT_300 = ".parse(String.valueOf(filename_";
  protected final String TEXT_301 = "));" + NL + "}" + NL + "java.util.Iterator<java.util.Map<String, String>> it_";
  protected final String TEXT_302 = "  = looper_";
  protected final String TEXT_303 = ".iterator();";
  protected final String TEXT_304 = NL + "while (it_";
  protected final String TEXT_305 = ".hasNext()) {" + NL + "\tjava.util.Map<String, String> row_";
  protected final String TEXT_306 = " = it_";
  protected final String TEXT_307 = ".next();";
  protected final String TEXT_308 = NL + "\tif (nb_line_";
  protected final String TEXT_309 = ">=";
  protected final String TEXT_310 = ") {" + NL + "\t";
  protected final String TEXT_311 = NL + "\t\t\tlooper_";
  protected final String TEXT_312 = ".stopRead();" + NL + "\t";
  protected final String TEXT_313 = NL + "\t\tbreak;" + NL + "\t}";
  protected final String TEXT_314 = NL + "\t\tnb_line_";
  protected final String TEXT_315 = "++;" + NL + "\t\t";
  protected final String TEXT_316 = " = null;\t\t\t";
  protected final String TEXT_317 = NL + "\ttry {" + NL + "\t\tnode_";
  protected final String TEXT_318 = ".getSingleNode(tmp_";
  protected final String TEXT_319 = NL + "    \tif(node_";
  protected final String TEXT_320 = "!=null && node_";
  protected final String TEXT_321 = ".getNodeType()==org.w3c.dom.Node.ELEMENT_NODE && node_";
  protected final String TEXT_322 = ".hasChildNodes()){" + NL + "    \t\tstr_";
  protected final String TEXT_323 = " = contentTool_";
  protected final String TEXT_324 = ".getNodeContent(node_";
  protected final String TEXT_325 = ");" + NL + "    \t}else{" + NL + "    \t\tstr_";
  protected final String TEXT_326 = " = node_";
  protected final String TEXT_327 = "!=null?node_";
  protected final String TEXT_328 = ".getTextContent():\"\";" + NL + "    \t}";
  protected final String TEXT_329 = NL + "\t\tstr_";
  protected final String TEXT_330 = ".getTextContent():\"\";";
  protected final String TEXT_331 = NL + "\t} catch (javax.xml.xpath.XPathExpressionException xee) {" + NL + "\t\tnode_";
  protected final String TEXT_332 = " = tmp_";
  protected final String TEXT_333 = ";" + NL + "\t\tstr_";
  protected final String TEXT_334 = ".getNodeString(tmp_";
  protected final String TEXT_335 = ");" + NL + "\t}";
  protected final String TEXT_336 = NL + "\tif(true) {" + NL + "\t\tthrow new RuntimeException(\"Error Config: \\\"Get Nodes\\\" should be checked when type is \\\"Document\\\"\");" + NL + "\t}";
  protected final String TEXT_337 = NL + "    Object obj";
  protected final String TEXT_338 = "_";
  protected final String TEXT_339 = " = xpaths_";
  protected final String TEXT_340 = ".get(";
  protected final String TEXT_341 = ").evaluate(temp_";
  protected final String TEXT_342 = ");" + NL + "    if(obj";
  protected final String TEXT_343 = " == null) {" + NL + "    \tnode_";
  protected final String TEXT_344 = NL + "    \tstr_";
  protected final String TEXT_345 = " = \"\";";
  protected final String TEXT_346 = NL + "    \t" + NL + "    } else if(obj";
  protected final String TEXT_347 = " instanceof org.dom4j.Node) {" + NL + "    \tnode_";
  protected final String TEXT_348 = " = (org.dom4j.Node)obj";
  protected final String TEXT_349 = ".asXML();";
  protected final String TEXT_350 = " = org.jaxen.function.StringFunction.evaluate(node_";
  protected final String TEXT_351 = ",org.jaxen.dom4j.DocumentNavigator.getInstance());";
  protected final String TEXT_352 = NL + "    } else if(obj";
  protected final String TEXT_353 = " instanceof String || obj";
  protected final String TEXT_354 = " instanceof Number){" + NL + "    \tnode_";
  protected final String TEXT_355 = " = temp_";
  protected final String TEXT_356 = ";" + NL + "    \tstr_";
  protected final String TEXT_357 = " = String.valueOf(obj";
  protected final String TEXT_358 = ");" + NL + "    } else if(obj";
  protected final String TEXT_359 = " instanceof java.util.List){" + NL + "    \tjava.util.List<org.dom4j.Node> nodes_";
  protected final String TEXT_360 = " = (java.util.List<org.dom4j.Node>)obj";
  protected final String TEXT_361 = ";" + NL + "    \tnode_";
  protected final String TEXT_362 = " = nodes_";
  protected final String TEXT_363 = ".size()>0 ? nodes_";
  protected final String TEXT_364 = ".get(0) : null;";
  protected final String TEXT_365 = "==null?null:node_";
  protected final String TEXT_366 = "==null?\"\":org.jaxen.function.StringFunction.evaluate(node_";
  protected final String TEXT_367 = NL + "\t}";
  protected final String TEXT_368 = NL + "\tstr_";
  protected final String TEXT_369 = " = row_";
  protected final String TEXT_370 = NL + "\tnode_";
  protected final String TEXT_371 = " = new String[]{str_";
  protected final String TEXT_372 = ",row_";
  protected final String TEXT_373 = "+\"/@xsi:nil\")};";
  protected final String TEXT_374 = ",null};";
  protected final String TEXT_375 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_376 = ".";
  protected final String TEXT_377 = " = ParserUtils.parseTo_Document(str_";
  protected final String TEXT_378 = " = str_";
  protected final String TEXT_379 = NL + "\t\t\t\t\t\t\t\t\tif(xml_api_";
  protected final String TEXT_380 = ".isDefNull(node_";
  protected final String TEXT_381 = ")){" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_382 = " =null;" + NL + "\t\t\t\t\t\t\t\t\t}else if(xml_api_";
  protected final String TEXT_383 = ".isEmpty(node_";
  protected final String TEXT_384 = ")){" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_385 = " =\"\";" + NL + "\t\t\t\t\t\t\t\t\t}else if(xml_api_";
  protected final String TEXT_386 = ".isMissing(node_";
  protected final String TEXT_387 = " )){ " + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_388 = " =";
  protected final String TEXT_389 = ";" + NL + "\t\t\t\t\t\t\t\t\t}else{";
  protected final String TEXT_390 = "\t" + NL + "\t\t\t\t\t\t\t\t\t\tif(xml_api_";
  protected final String TEXT_391 = " =null;" + NL + "\t\t\t\t\t\t\t\t\t\t}else if(xml_api_";
  protected final String TEXT_392 = ") || xml_api_";
  protected final String TEXT_393 = "=";
  protected final String TEXT_394 = ";" + NL + "\t\t\t\t\t\t\t\t\t\t}else{";
  protected final String TEXT_395 = NL + "\t\t\t\t\t\t\t\t\t\tif(xml_api_";
  protected final String TEXT_396 = NL + "\t\t";
  protected final String TEXT_397 = " = ParserUtils.parseTo_Date(str_";
  protected final String TEXT_398 = ",false);";
  protected final String TEXT_399 = "\t\t\t\t\t\t\t" + NL + "\t\t";
  protected final String TEXT_400 = ".getBytes(";
  protected final String TEXT_401 = " = ParserUtils.parseTo_";
  protected final String TEXT_402 = "(ParserUtils.parseTo_Number(str_";
  protected final String TEXT_403 = "));";
  protected final String TEXT_404 = "(str_";
  protected final String TEXT_405 = NL + "    \t\t\t\t";
  protected final String TEXT_406 = NL + "\tboolean whetherReject_";
  protected final String TEXT_407 = " = false;" + NL + "\t";
  protected final String TEXT_408 = " = new ";
  protected final String TEXT_409 = "Struct();" + NL + "\ttry{";
  protected final String TEXT_410 = " = null; ";
  protected final String TEXT_411 = NL + "\t\t\t" + NL + "    } catch (java.lang.Exception e) {" + NL + "globalMap.put(\"";
  protected final String TEXT_412 = "_ERROR_MESSAGE\",e.getMessage());" + NL + "        whetherReject_";
  protected final String TEXT_413 = " = true;";
  protected final String TEXT_414 = NL + "            throw(e);";
  protected final String TEXT_415 = NL + "\t\t\t\tlog.error(\"";
  protected final String TEXT_416 = " - \" + e.getMessage());" + NL + "\t\t\t";
  protected final String TEXT_417 = NL + "                    ";
  protected final String TEXT_418 = "Struct();";
  protected final String TEXT_419 = NL + "                ";
  protected final String TEXT_420 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_421 = NL + "                System.err.println(e.getMessage());";
  protected final String TEXT_422 = NL + "            \t";
  protected final String TEXT_423 = NL + "    }";
  protected final String TEXT_424 = "if(!whetherReject_";
  protected final String TEXT_425 = ") { ";
  protected final String TEXT_426 = "      " + NL + "             if(";
  protected final String TEXT_427 = " == null){ " + NL + "            \t ";
  protected final String TEXT_428 = "Struct();" + NL + "             }";
  protected final String TEXT_429 = NL + "\t    \t ";
  protected final String TEXT_430 = ";    \t\t\t\t";
  protected final String TEXT_431 = " } ";
  protected final String TEXT_432 = "\t";
  protected final String TEXT_433 = NL + "\t\t\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
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
			
    stringBuffer.append(TEXT_1);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_2);
    
			}
		}
		
		public void retrievedDataNumberInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
			}
		}
		
		public void retrievedDataNumberInfoFromGlobalMap(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    
			}
		}
		
		//for all tFileinput* components 
		public void retrievedDataNumberInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
			}
		}
		
		public void writeDataFinishInfo(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    
			}
		}
		
 		//TODO delete it and remove all log4jSb parameter from components
		public void componentStartInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node,boolean hasIncreased) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(hasIncreased?"":"+1");
    stringBuffer.append(TEXT_12);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node) {
			debugRetriveData(node,true);
		}
		
		//TODO rename or delete it
		public void debugWriteData(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    
			}
		}
		
		public void logCurrentRowNumberInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    
			}
		}
		
		public void logDataCountInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    
			}
		}

        public void logErrorMessage() {
            if(isLog4jEnabled){
            
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
            } else {
            
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
            }
        }
	}
	
	final DefaultLog4jFileUtil log4jFileUtil = new DefaultLog4jFileUtil((INode)(((org.talend.designer.codegen.config.CodeGeneratorArgument)argument).getArgument()));
	
    stringBuffer.append(TEXT_21);
    
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
		
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(targetConnName);
    stringBuffer.append(TEXT_25);
    stringBuffer.append((varsStr!=null?varsStr.toString():""));
    stringBuffer.append(TEXT_26);
    
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
		
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(targetConnName);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(dynamicName);
    stringBuffer.append(TEXT_25);
    stringBuffer.append((varsStr!=null?varsStr.toString():""));
    stringBuffer.append(TEXT_26);
    
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
		
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(sourceConnName);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(targetConnName);
    stringBuffer.append(TEXT_26);
    
			}else{
				codeForConnToConn(node, C2CMetadata, C2CSourceConnName, C2CTargetConnName, 0, columnListSize);
			}
		}
		
		
		public void generateClass(){
		  	if(isOptimizeCode){
				cid = node.getUniqueName();
				int methodNum=(columnListSize%schemaOptNum==0?columnListSize/schemaOptNum:(columnListSize/schemaOptNum)+1);
				
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    
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
					
    stringBuffer.append(TEXT_32);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(V2CSourceValueClass);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(V2CSourceValueName);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(V2CTargetConnName);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(V2CTargetConnName);
    stringBuffer.append(TEXT_25);
    stringBuffer.append((parmsStr!=null?parmsStr.toString():""));
    stringBuffer.append(TEXT_35);
    codeForValueToConn(node, V2CMetadata, V2CSourceValueClass, V2CSourceValueName, V2CTargetConnName, start, end);
    stringBuffer.append(TEXT_36);
    	
					}
					if(useV2CWithD){
					
    stringBuffer.append(TEXT_37);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(V2CWithDSourceValueClass);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(V2CWithDSourceValueName);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(V2CWithDTargetConnName);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(V2CWithDTargetConnName);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(V2CWithDDynamicName);
    stringBuffer.append(TEXT_25);
    stringBuffer.append((parmsStr!=null?parmsStr.toString():""));
    stringBuffer.append(TEXT_35);
    this.isBehindDynamic = codeForValueToConnWithD(node, V2CWithDMetadata, V2CWithDSourceValueClass, V2CWithDSourceValueName, V2CWithDTargetConnName, V2CWithDDynamicName, start, end);
    stringBuffer.append(TEXT_36);
    		
					}
					if(useC2C){
					
    stringBuffer.append(TEXT_39);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(C2CSourceConnName);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(C2CSourceConnName);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(C2CTargetConnName);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(C2CTargetConnName);
    stringBuffer.append(TEXT_35);
    codeForConnToConn(node, C2CMetadata, C2CSourceConnName, C2CTargetConnName, start, end);
    stringBuffer.append(TEXT_36);
    
					}
				}
				if(useV2C){//Call all split methods in one method
				
    stringBuffer.append(TEXT_40);
    stringBuffer.append(V2CSourceValueClass);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(V2CSourceValueName);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(V2CTargetConnName);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(V2CTargetConnName);
    stringBuffer.append(TEXT_25);
    stringBuffer.append((parmsStr!=null?parmsStr.toString():""));
    stringBuffer.append(TEXT_41);
    	
				}
				if(useV2CWithD){
				
    stringBuffer.append(TEXT_42);
    stringBuffer.append(V2CWithDSourceValueClass);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(V2CWithDSourceValueName);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(V2CWithDTargetConnName);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(V2CWithDTargetConnName);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(V2CWithDDynamicName);
    stringBuffer.append(TEXT_25);
    stringBuffer.append((parmsStr!=null?parmsStr.toString():""));
    stringBuffer.append(TEXT_41);
    
				}
				for(int i=0;i<methodNum;i++){
					if(useV2C){
					
    stringBuffer.append(TEXT_43);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(V2CSourceValueName);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(V2CTargetConnName);
    stringBuffer.append(TEXT_25);
    stringBuffer.append((varsStr!=null?varsStr.toString():""));
    stringBuffer.append(TEXT_44);
    
					}
					if(useV2CWithD){
					
    stringBuffer.append(TEXT_45);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(V2CWithDSourceValueName);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(V2CWithDTargetConnName);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(V2CWithDDynamicName);
    stringBuffer.append(TEXT_25);
    stringBuffer.append((varsStr!=null?varsStr.toString():""));
    stringBuffer.append(TEXT_44);
    
					}
				}
				if(useV2C || useV2CWithD){
				
    stringBuffer.append(TEXT_46);
    
				}
				if(useC2C){
				
    stringBuffer.append(TEXT_47);
    stringBuffer.append(C2CSourceConnName);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(C2CSourceConnName);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(C2CTargetConnName);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(C2CTargetConnName);
    stringBuffer.append(TEXT_48);
    
					for(int i=0;i<methodNum;i++){
						if(useC2C){
						
    stringBuffer.append(TEXT_49);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(C2CSourceConnName);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(C2CTargetConnName);
    stringBuffer.append(TEXT_50);
    
						}
					}
					
    stringBuffer.append(TEXT_46);
    
				}
				
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    
		  	}
		}
	}
	
    stringBuffer.append(TEXT_55);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();

String cid = node.getUniqueName();
        
List<Map<String, String>> mapping = (List<Map<String,String>>)ElementParameterParser.getObjectValueXML(node, "__MAPPING__");
String encoding = ElementParameterParser.getValue(node, "__ENCODING__");
String loopQuery = ElementParameterParser.getValue(node, "__LOOP_QUERY__"); 

String filename = ElementParameterParser.getValue(node, "__FILENAME__");

boolean ignore_NS="true".equals(ElementParameterParser.getValue(node, "__IGNORE_NS__"));
String tmp_filename = ElementParameterParser.getValue(node, "__TMP_FILENAME__");

String useSeparator = ElementParameterParser.getValue(node, "__USE_SEPARATOR__");
String fieldSeparator = ElementParameterParser.getValue(node, "__FIELD_SEPARATOR__");

String limit = ElementParameterParser.getValue(node, "__LIMIT__");
if (("").equals(limit)) {
	limit = "-1";
}

String dieOnErrorStr = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
boolean dieOnError = (dieOnErrorStr!=null&&!("").equals(dieOnErrorStr))?("true").equals(dieOnErrorStr):false;


boolean ignoreDTD="true".equals(ElementParameterParser.getValue(node, "__IGNORE_DTD__"));

String mode = ElementParameterParser.getValue(node, "__GENERATION_MODE__");

int schemaOptNum=100;
String schemaOptNumStr=ElementParameterParser.getValue(node, "__SCHEMA_OPT_NUM__");
if(schemaOptNumStr!=null && !"".equals(schemaOptNumStr) && !"\"\"".equals(schemaOptNumStr)){
	schemaOptNum  = Integer.parseInt(schemaOptNumStr);
}

boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
		
/* -------------------------- */

    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    
      if(ignoreDTD){

    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    
	}

    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    
// *** Xerces *** //
if(("Xerces").equals(mode)){

    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    if("true".equals(useSeparator)){
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(fieldSeparator );
    stringBuffer.append(TEXT_77);
    }
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(loopQuery);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    
      if(ignoreDTD){

    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    
      }

    stringBuffer.append(TEXT_85);
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    if (dieOnError) {
    stringBuffer.append(TEXT_98);
    }else{
    stringBuffer.append(TEXT_99);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    }
    stringBuffer.append(TEXT_102);
    }
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    if (dieOnError) {
    stringBuffer.append(TEXT_130);
    }else{
    stringBuffer.append(TEXT_99);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    }
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_132);
    }
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(loopQuery);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    log4jFileUtil.startRetriveDataInfo();
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    
// *** Dom4j *** //
}else if(("Dom4j").equals(mode)){

    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    
	if(ignore_NS){

    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_157);
    
	}

    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    
      if(ignoreDTD){

    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    
      }

    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    if (dieOnError) {
    stringBuffer.append(TEXT_98);
    }else{
    stringBuffer.append(TEXT_99);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    }
    stringBuffer.append(TEXT_102);
    }
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_165);
    
	if(ignore_NS){

    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_177);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_184);
    stringBuffer.append(tmp_filename );
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    if (dieOnError) {
    stringBuffer.append(TEXT_98);
    }else{
    stringBuffer.append(TEXT_99);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    }
    stringBuffer.append(TEXT_102);
    }
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(tmp_filename );
    stringBuffer.append(TEXT_77);
    
	}

    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_205);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    if (dieOnError) {
    stringBuffer.append(TEXT_130);
    }else{
    stringBuffer.append(TEXT_99);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    }
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_132);
    }
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(loopQuery);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_226);
    if(ignore_NS){
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    }
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_237);
    
if(schemaOptNum>0){

    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_239);
    
	   int mappingSize=mapping.size();
		for (int i=0;i<mappingSize;i++) {
			String query = mapping.get(i).get("QUERY");
			if(i%schemaOptNum==0){
			
    stringBuffer.append(TEXT_240);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_242);
    if(ignore_NS){
    stringBuffer.append(TEXT_243);
    }
    stringBuffer.append(TEXT_244);
    
			}
	      
    stringBuffer.append(TEXT_245);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_246);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(loopQuery);
    stringBuffer.append(TEXT_247);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_248);
    
			if(ignore_NS){
	
    stringBuffer.append(TEXT_249);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_250);
    
			}
			
    stringBuffer.append(TEXT_251);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_252);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_253);
    
			if((i+1)%schemaOptNum==0){
	      
    stringBuffer.append(TEXT_254);
    
	      }
		}
		if(mappingSize>0&&(mappingSize%schemaOptNum)>0){
	   
    stringBuffer.append(TEXT_255);
    
	   }
	   
    stringBuffer.append(TEXT_256);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_257);
    if(ignore_NS){
    stringBuffer.append(TEXT_243);
    }
    stringBuffer.append(TEXT_258);
    
			    for (int i=0;i<=((mappingSize-1)/schemaOptNum);i++) {
			    
    stringBuffer.append(TEXT_259);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_260);
    if(ignore_NS){
    stringBuffer.append(TEXT_261);
    }
    stringBuffer.append(TEXT_262);
    
			    }
			    
    stringBuffer.append(TEXT_263);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_265);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid);
    if(ignore_NS){
    stringBuffer.append(TEXT_270);
    stringBuffer.append(cid);
    }
    stringBuffer.append(TEXT_19);
    
}else{

    stringBuffer.append(TEXT_271);
    
}

    log4jFileUtil.startRetriveDataInfo();
    stringBuffer.append(TEXT_272);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_274);
    
// *** SAX *** //
}else if(("SAX").equals(mode)){

    stringBuffer.append(TEXT_275);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_276);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_277);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_278);
    
	boolean first = true;
	for(Map<String,String> path:mapping){

    stringBuffer.append(TEXT_279);
    stringBuffer.append(first?"":",");
    stringBuffer.append(path.get("QUERY"));
    
		String query = path.get("QUERY");
		if(query!=null && query.indexOf("@")<0){

    stringBuffer.append(TEXT_280);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_281);
    
		}
		first=false;
	}

    stringBuffer.append(TEXT_282);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_283);
    
	first = true;
	for(Map<String,String> path:mapping){

    stringBuffer.append(TEXT_279);
    stringBuffer.append(first?"":",");
    stringBuffer.append("true".equals(path.get("NODECHECK"))? "true":"false" );
    
		String query = path.get("QUERY");
		if(query!=null && query.indexOf("@")<0){

    stringBuffer.append(TEXT_284);
    
		}
		first=false;
	}

    stringBuffer.append(TEXT_285);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_286);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_287);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_288);
    stringBuffer.append(loopQuery);
    stringBuffer.append(TEXT_289);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_290);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    if(ignoreDTD){
    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_292);
    }
    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_293);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    if (dieOnError) {
    stringBuffer.append(TEXT_98);
    }else{
		if(isLog4jEnabled){
    stringBuffer.append(TEXT_294);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_295);
    }
    stringBuffer.append(TEXT_102);
    }
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_296);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_297);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_298);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_299);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_300);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_301);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_302);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_303);
    log4jFileUtil.startRetriveDataInfo();
    stringBuffer.append(TEXT_304);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_305);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_306);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_307);
    
}
			// limit
		if (limit.compareTo("-1")!=0) {

    stringBuffer.append(TEXT_308);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_309);
    stringBuffer.append(limit );
    stringBuffer.append(TEXT_310);
    if(("SAX").equals(mode)) {
    stringBuffer.append(TEXT_311);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_312);
    }
    stringBuffer.append(TEXT_313);
     
		}
		
    stringBuffer.append(TEXT_314);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_315);
    
List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
String firstConnName = "";
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
	IMetadataTable metadata = metadatas.get(0);
	if (metadata!=null) {
		if (conns!=null) {
//************ add for reject start*****************
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
			for (int i=0;i<conns.size();i++) {
				IConnection connTemp = conns.get(i);
				if (connTemp.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_99);
    stringBuffer.append(connTemp.getName() );
    stringBuffer.append(TEXT_316);
    
				}
    		}
//***************************end********************
			Map<String,String> varsMap=new java.util.HashMap<String,String>();
			varsMap.put("xml_api_"+cid,"XML_API_"+cid);
			if("true".equals(useSeparator)){
				varsMap.put("contentTool_"+cid,"ContentTool_"+cid);
			}
			if(("Xerces").equals(mode)){
				varsMap.put("tmp_"+cid,"org.w3c.dom.Node");
				varsMap.put("node_"+cid,"org.w3c.dom.Node");
			}
			if(("Dom4j").equals(mode)){
				varsMap.put("node_"+cid,"org.dom4j.Node");
				varsMap.put("nsTool_"+cid,"NameSpaceTool_"+cid);
				varsMap.put("xmlNameSpaceMap_"+cid,"java.util.HashMap<String,String>");
				varsMap.put("temp_"+cid,"org.dom4j.Node");
				if(ignore_NS){
					varsMap.put("namespaceContext_"+cid,"org.jaxen.NamespaceContext");
				}
				varsMap.put("xpaths_"+cid,"java.util.Map<Integer,org.dom4j.XPath>");
			}
			if(("SAX").equals(mode)){
				varsMap.put("row_"+cid,"java.util.Map<String, String>");
				varsMap.put("node_"+cid,"String[]");
			}
			class RowUtil extends DefaultRowUtil{
				public void codeForValueToConn(INode node, IMetadataTable metadata, String sourceValueClass, String sourceValueName, String targetConnName, int start , int end){
					cid = node.getUniqueName();
					boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
					List<Map<String, String>> mapping = (List<Map<String,String>>)ElementParameterParser.getObjectValueXML(node, "__MAPPING__");
					List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
					IConnection conn = conns.get(0);
					String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
					boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
					String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
					String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER);
					
					String checkDateStr = ElementParameterParser.getValue(node,"__CHECK_DATE__");
					boolean checkDate = (checkDateStr!=null&&!("").equals(checkDateStr))?("true").equals(checkDateStr):false;
					boolean ignoreDTD="true".equals(ElementParameterParser.getValue(node, "__IGNORE_DTD__"));
					String encoding = ElementParameterParser.getValue(node, "__ENCODING__");
					
					String useSeparator = ElementParameterParser.getValue(node, "__USE_SEPARATOR__");
					
					String mode = ElementParameterParser.getValue(node, "__GENERATION_MODE__");
					
					for (int i=start;i<end;i++) { // S_for_a_1_0
						String query = mapping.get(i).get("QUERY");
						String nodeCheck = mapping.get(i).get("NODECHECK");
						if(("Xerces").equals(mode)){

    stringBuffer.append(TEXT_317);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_318);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_19);
    
							if("true".equals(useSeparator)){

    stringBuffer.append(TEXT_319);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_320);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_321);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_322);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_323);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_324);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_325);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_326);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_327);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_328);
    
							}else{

    stringBuffer.append(TEXT_329);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_326);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_327);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_330);
    
							}

    stringBuffer.append(TEXT_331);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_332);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_333);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_334);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_335);
    
						}else if(("Dom4j").equals(mode)){
							//TDI-18498
							boolean isWrongConfig = false;
							
							for(IMetadataColumn column:metadata.getListColumns()) {
								if (mapping.get(i).get("SCHEMA_COLUMN")!=null) {
									if (column.getLabel().compareTo(mapping.get(i).get("SCHEMA_COLUMN"))==0) {
										if("id_Document".equals(column.getTalendType()) && "false".equals(nodeCheck)) {
											isWrongConfig = true;
											break;
										}
									}
								}
							}
							
							if(isWrongConfig) {

    stringBuffer.append(TEXT_336);
    
							}

    stringBuffer.append(TEXT_337);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_338);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_339);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_340);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_341);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_342);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_338);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_343);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    
							if(("true").equals(nodeCheck)){

    stringBuffer.append(TEXT_329);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_145);
    
							
							}else{

    stringBuffer.append(TEXT_344);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_345);
    
						}

    stringBuffer.append(TEXT_346);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_338);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_347);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_348);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_338);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    
							if(("true").equals(nodeCheck)){

    stringBuffer.append(TEXT_329);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_326);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_349);
    
							
							}else{

    stringBuffer.append(TEXT_344);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_350);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_351);
    
							}

    stringBuffer.append(TEXT_352);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_338);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_353);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_338);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_354);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_355);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_356);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_357);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_338);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_358);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_338);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_359);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_360);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_338);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_361);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_362);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_363);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_364);
    
							if(("true").equals(nodeCheck)){

    stringBuffer.append(TEXT_329);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_326);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_365);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_349);
    
							
							}else{

    stringBuffer.append(TEXT_344);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_326);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_366);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_351);
    
							}

    stringBuffer.append(TEXT_367);
    
						}else if(("SAX").equals(mode)){

    stringBuffer.append(TEXT_368);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_369);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_340);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_19);
    
							if(query!=null && query.indexOf("@")<0){

    stringBuffer.append(TEXT_370);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_371);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_372);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_340);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_373);
    
							}else{

    stringBuffer.append(TEXT_370);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_371);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_374);
    
							}
						}
						for(IMetadataColumn column:metadata.getListColumns()) {  // S_for_0_1
							if (mapping.get(i).get("SCHEMA_COLUMN")!=null) { // S_if_0_2
								if (column.getLabel().compareTo(mapping.get(i).get("SCHEMA_COLUMN"))==0) { // S_if_0_3
									String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
									JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
									String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
									
									boolean isNotSetDefault = false;
									String defaultValue=column.getDefault();
									if(defaultValue!=null){
										isNotSetDefault = defaultValue.length()==0;
									}else{
										isNotSetDefault=true;
									}
									if(("Dom4j").equals(mode) && ("true").equals(nodeCheck)){
										if("id_Document".equals(column.getTalendType())) {

    stringBuffer.append(TEXT_375);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_376);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_377);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(ignoreDTD);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_19);
    
										} else {

    stringBuffer.append(TEXT_375);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_376);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_378);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_77);
    
										}
										continue;
									}
									if(javaType == JavaTypesManager.STRING){
										if(column.isNullable()){

    stringBuffer.append(TEXT_379);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_380);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_381);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_376);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_382);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_383);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_384);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_376);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_385);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_386);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_387);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_376);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_388);
    stringBuffer.append(isNotSetDefault?null:column.getDefault());
    stringBuffer.append(TEXT_389);
    
										}else{ // column.isNullable()

    stringBuffer.append(TEXT_379);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_383);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_384);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_376);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_385);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_386);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_387);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_376);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_388);
    stringBuffer.append(isNotSetDefault?JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate):column.getDefault());
    stringBuffer.append(TEXT_389);
    
										}
									}else{ // other type
										if(column.isNullable()){

    stringBuffer.append(TEXT_390);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_380);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_381);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_376);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_391);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_383);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_392);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_386);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_381);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_376);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_393);
    stringBuffer.append(isNotSetDefault?null:column.getDefault());
    stringBuffer.append(TEXT_394);
    
								  		}else{ // column.isNullable()

    stringBuffer.append(TEXT_395);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_386);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_392);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_383);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_381);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_376);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_388);
    stringBuffer.append(isNotSetDefault?JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate):column.getDefault());
    stringBuffer.append(TEXT_394);
    
										}
									}
									if (javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {

    stringBuffer.append(TEXT_396);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_376);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_378);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_77);
    
									} else if (javaType == JavaTypesManager.DATE) {
										if(checkDate) {

    stringBuffer.append(TEXT_396);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_376);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_397);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_398);
      
										} else {

    stringBuffer.append(TEXT_396);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_376);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_397);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_19);
    
										}
									} else if(javaType == JavaTypesManager.BYTE_ARRAY){ 

    stringBuffer.append(TEXT_399);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_376);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_378);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_400);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_19);
    
									} else if(advancedSeparator && JavaTypesManager.isNumberType(javaType)) { 

    stringBuffer.append(TEXT_396);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_376);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_401);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_402);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_24);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_403);
    
									} else {

    stringBuffer.append(TEXT_396);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_376);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_401);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_404);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    
									}

    stringBuffer.append(TEXT_367);
    
								} //S_if_1_2
							} // S_if_1_1
						} // S_for_1_0
					} // S_for_a_1_0
				}
				
				public void codeForConnToConn(INode node, IMetadataTable metadata, String sourceConnName, String targetConnName, int start , int end){
	    			for(int colNum=start;colNum<end;colNum++) {
	    				IMetadataColumn column=metadata.getListColumns().get(colNum);

    stringBuffer.append(TEXT_405);
    stringBuffer.append(targetConnName);
    stringBuffer.append(TEXT_376);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_95);
    stringBuffer.append(sourceConnName);
    stringBuffer.append(TEXT_376);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_77);
    
					}
				}
			}//class defined end
			RowUtil rowUtil = new RowUtil(); 
			if (conns.size()>0) { // S_if_a_0_0	
				IConnection conn = conns.get(0);
				firstConnName = conn.getName();
			    if (conns.size()>0 && firstConnName != null && firstConnName.length()>0) {
			    	rowUtil.genVarsParmsStr(varsMap);
					rowUtil.prepareValueToConn(node, metadata, "String", "str_"+cid, firstConnName, schemaOptNum);
					if(!("").equals(rejectConnName)&&!rejectConnName.equals(firstConnName)&&rejectColumnList != null && rejectColumnList.size() > 0) {
						rowUtil.prepareConnToConn(metadata, firstConnName, rejectConnName);
					}
					rowUtil.generateClass();
				}
				if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) { // add for reject

    stringBuffer.append(TEXT_406);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_407);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_408);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_409);
    
	rowUtil.callValueToConn("str_"+cid, firstConnName);

     log4jFileUtil.debugRetriveData(node); 
    stringBuffer.append(TEXT_25);
    if(rejectConnName.equals(firstConnName)) {
    stringBuffer.append(TEXT_25);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_410);
    }
    stringBuffer.append(TEXT_411);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_412);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_413);
    
        if (dieOnError) {
            
    stringBuffer.append(TEXT_414);
    
        } else {
			if(isLog4jEnabled){
    stringBuffer.append(TEXT_415);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_416);
    }
            if(!("").equals(rejectConnName)&&!rejectConnName.equals(firstConnName)&&rejectColumnList != null && rejectColumnList.size() > 0) {

                
    stringBuffer.append(TEXT_417);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_408);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_418);
    
                rowUtil.callConnToConn(firstConnName, rejectConnName);
                
    stringBuffer.append(TEXT_419);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_420);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(TEXT_419);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_145);
    
            } else if(("").equals(rejectConnName)){
                
    stringBuffer.append(TEXT_421);
    stringBuffer.append(TEXT_419);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_145);
    
            } else if(rejectConnName.equals(firstConnName)){
    stringBuffer.append(TEXT_422);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_420);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_77);
    }
		}
        
    stringBuffer.append(TEXT_423);
    
				} //if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))
			} // S_if_a_1_1

//***********************************
			if (conns.size()>0) {	
				boolean isFirstEnter = true;
				for (int i=0;i<conns.size();i++) {
					IConnection tmpconn = conns.get(i);
					if ((tmpconn.getName().compareTo(firstConnName)!=0)&&(tmpconn.getName().compareTo(rejectConnName)!=0)&&(tmpconn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))) {

    stringBuffer.append(TEXT_396);
     if(isFirstEnter) {
    stringBuffer.append(TEXT_424);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_425);
     isFirstEnter = false; } 
    stringBuffer.append(TEXT_426);
    stringBuffer.append(tmpconn.getName() );
    stringBuffer.append(TEXT_427);
    stringBuffer.append(tmpconn.getName() );
    stringBuffer.append(TEXT_408);
    stringBuffer.append(tmpconn.getName() );
    stringBuffer.append(TEXT_428);
    
			    	 	for (IMetadataColumn column: metadata.getListColumns()) {

    stringBuffer.append(TEXT_429);
    stringBuffer.append(tmpconn.getName() );
    stringBuffer.append(TEXT_376);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_376);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_430);
    
				 		}
					}
				}

    stringBuffer.append(TEXT_396);
     if(!isFirstEnter) {
    stringBuffer.append(TEXT_431);
     } 
    stringBuffer.append(TEXT_432);
    
			}
//***********************************

		} // if(conn!=null)
		

	}// if (metadata!=null)
} //if ((metadatas!=null)&&(metadatas.size()>0))

    stringBuffer.append(TEXT_433);
    stringBuffer.append(TEXT_55);
    return stringBuffer.toString();
  }
}
