<%@page language="java" contentType="text/html"%>
<%@page import="javax.xml.parsers.SAXParserFactory"%>
<%@page import="javax.xml.parsers.SAXParser"%>
<%@page import="org.xml.sax.InputSource"%>
<%@page import="org.apache.commons.text.StringEscapeUtils"%>
<%@page import="myPkg.ParsingExceptionHandler"%>
<html><head><title>Starfleet validation (SAX - schema)</title></head><body>
<%
  SAXParserFactory factory = SAXParserFactory.newInstance();
  factory.setValidating(true);
  factory.setNamespaceAware(true);
  factory.setFeature("http://apache.org/xml/features/validation/schema", true);
  SAXParser parser = factory.newSAXParser();
  InputSource inputSource = new InputSource("webapps/xml-validate/xml/enterprises_schema.xml");
  ParsingExceptionHandler handler = new ParsingExceptionHandler();
  try { parser.parse(inputSource, handler); }
  catch (Exception e) { }
  if (handler.errorLevel == null) {
    out.println("The document is valid.");
    }
  else {
    out.println(
        "*** Validation " + handler.errorLevel + ": "
      + StringEscapeUtils.escapeHtml4(handler.parsingException.toString())
      );
    }
  %>
</body></html>
