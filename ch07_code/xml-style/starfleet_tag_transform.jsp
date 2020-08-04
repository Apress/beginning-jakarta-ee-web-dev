<%@page language="java" contentType="text/html"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<c:import url="/xsl/starfleet.xml" var="xml"/>
<c:import url="/xsl/starfleet.xsl" var="xsl"/>
<x:transform doc="${xml}" xslt="${xsl}"/>
