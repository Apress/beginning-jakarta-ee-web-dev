<%@page language="java" contentType="text/html"%>
<%@page import="javax.xml.parsers.SAXParserFactory"%>
<%@page import="javax.xml.parsers.SAXParser"%>
<%@page import="org.xml.sax.InputSource"%>
<%@page import="org.apache.commons.text.StringEscapeUtils"%>
<%@page import="myPkg.ParsingExceptionHandler"%>
<html><head><title>Starfleet validation (SAX - DTD)</title></head><body>
<%
  SAXParserFactory factory = SAXParserFactory.newInstance();
  factory.setValidating(true);
  SAXParser parser = factory.newSAXParser();
  InputSource inputSource = new InputSource("webapps/xml-validate/xml/enterprises.xml");
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
