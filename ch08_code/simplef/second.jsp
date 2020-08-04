<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<html><head><title>Second page</title></head><body>
<f:view>
  <h:form>
    <h:outputText value="&quot;#{aStringBean.str}&quot; "/>
    <h:commandButton action="goBack" value="Another" />
    </h:form>
</f:view>
</body></html>
