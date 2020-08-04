<%@page language="java" contentType="text/html"%>
<%@page import="org.apache.xerces.parsers.SAXParser"%>
<%@page import="org.apache.commons.text.StringEscapeUtils"%>
<%@page import="myPkg.ParsingExceptionHandler"%>
<html><head><title>Starfleet validation (Xerces - schema)</title></head><body>
<%
  ParsingExceptionHandler handler = new ParsingExceptionHandler();
  SAXParser parser = new SAXParser();
  parser.setFeature("http://xml.org/sax/features/validation", true);
  parser.setFeature("http://apache.org/xml/features/validation/schema", true);
  parser.setFeature(
    "http://apache.org/xml/features/validation/schema-full-checking", true);
  parser.setErrorHandler(handler);
  try { parser.parse("webapps/xml-validate/xml/enterprises_schema.xml"); }
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
