<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="xml" version="1.0" encoding="UTF-8" indent="yes"/>
<xsl:template match="/">
  <starfleet>
    <title>The two most famous starships in the fleet</title>
    <xsl:for-each select="starfleet/starship">
      <xsl:if test="@sn='NCC-1701' or @sn='NCC-1701-D'">
        <xsl:element name="starship">
          <xsl:attribute name="name">
            <xsl:value-of select="@name"/>
            </xsl:attribute>
          <xsl:attribute name="sn">
            <xsl:value-of select="@sn"/>
            </xsl:attribute>
          <xsl:element name="class">
            <xsl:attribute name="name">
              <xsl:value-of select="class"/>
              </xsl:attribute>
            </xsl:element>
          <xsl:copy-of select="captain"/>
        </xsl:element>
      </xsl:if>
    </xsl:for-each>
    </starfleet>
  </xsl:template>
</xsl:stylesheet>