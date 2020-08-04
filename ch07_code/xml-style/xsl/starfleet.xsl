<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html" version="4.0" encoding="UTF-8" indent="yes"/>
<xsl:template match="/">
<html><head>
  <title>Styling starfleet.xml</title>
  <style>th {text-align:left}</style>
  </head>
<body>
<h2>The Most Famous Starships in the Fleet</h2>
<table border="1">
  <tr><th>Name</th><th>S/N</th><th>Class</th><th>Commissioned</th><th>Captain</th></tr>
  <xsl:for-each select="starfleet/starship">
    <xsl:sort select="class/@commissioned"/>
    <tr>
      <td><xsl:value-of select="@name"/></td>
      <td><xsl:value-of select="@sn"/></td>
      <td><xsl:value-of select="class"/></td>
      <td><xsl:value-of select="class/@commissioned"/></td>
      <td><xsl:value-of select="captain"/></td>
      </tr>
    </xsl:for-each>
  </table>
</body>
</html>
</xsl:template>
</xsl:stylesheet>