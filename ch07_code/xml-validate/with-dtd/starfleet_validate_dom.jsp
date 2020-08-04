<%@page language="java" contentType="text/html"%>
<%@page import="javax.xml.parsers.DocumentBuilderFactory"%>
<%@page import="javax.xml.parsers.DocumentBuilder"%>
<%@page import="org.xml.sax.InputSource"%>
<%@page import="org.apache.commons.text.StringEscapeUtils"%>
<%@page import="myPkg.ParsingExceptionHandler"%>
<html><head><title>Starfleet validation (DOM - DTD)</title></head><body>
<%
  DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
  factory.setValidating(true);
  DocumentBuilder parser = factory.newDocumentBuilder();
  InputSource inputSource = new InputSource("webapps/xml-validate/xml/enterprises.xml");
  ParsingExceptionHandler handler = new ParsingExceptionHandler();
  parser.setErrorHandler(handler);
  try { parser.parse(inputSource); }
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
