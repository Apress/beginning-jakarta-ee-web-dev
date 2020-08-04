<%@page language="java" contentType="text/html"%>
<%@page import="java.io.File"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="javax.xml.transform.TransformerFactory"%>
<%@page import="javax.xml.transform.Transformer"%>
<%@page import="javax.xml.transform.Source"%>
<%@page import="javax.xml.transform.SourceLocator"%>
<%@page import="javax.xml.transform.TransformerException"%>
<%@page import="javax.xml.transform.Result"%>
<%@page import="javax.xml.transform.stream.StreamSource"%>
<%@page import="javax.xml.transform.stream.StreamResult"%>
<%@page import="myPkg.TransformerExceptionHandler"%>
<%
  File inFile = new File("webapps/xml-style/xsl/starfleet.xml");
  File xslFile = new File("webapps/xml-style/xsl/enterprises.xsl");
  String outFilename = "webapps/xml-style/out/enterprises_out.xml";
  TransformerExceptionHandler handler = new TransformerExceptionHandler();
  try {
    TransformerFactory factory = TransformerFactory.newInstance();
    Transformer transformer = factory.newTransformer(new StreamSource(xslFile));
    transformer.setErrorListener(handler);
    Source source = new StreamSource(inFile);
    Result result = new StreamResult(new FileOutputStream(outFilename));
    transformer.transform(source, result);
    }
  catch (TransformerException e) {
    }
  if (handler.errorLevel == null) {
    out.println("Transformation completed.");
    }
  else {
    out.println(
        "*** Transformation " + handler.errorLevel + ": "
      + handler.transformationException
      );
    }
  %>