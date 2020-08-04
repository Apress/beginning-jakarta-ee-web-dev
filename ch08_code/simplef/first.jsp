<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<html><head><title>First Page</title></head><body>
<f:view>
  <h:form>
    <h:outputText value="Type something here: "/>
    <h:inputText value="#{aStringBean.str}" />
    <h:commandButton action="goOn" value="Submit" />
    </h:form>
  </f:view>
</body></html>
