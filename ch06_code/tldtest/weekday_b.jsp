<%@page language="java" contentType="text/html"%>
<%@taglib uri="/WEB-INF/tlds/wow.tld" prefix="wow"%>
<html><head><title>weekday bodied tag</title></head><body>
weekdayBody today: <wow:weekdayBody></wow:weekdayBody><br/>
weekdayBody ${param.d}: <wow:weekdayBody>${param.d}</wow:weekdayBody><br/>
</body></html>
