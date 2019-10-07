<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" 
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/people">
<html>
<body>
	<xsl:for-each select="person">
		<xsl:value-of select="first_name"/>
		<xsl:value-of select="surname"/>
		<xsl:value-of select="name"/>
		<br></br>
	</xsl:for-each>
</body>
</html>
</xsl:template>
</xsl:stylesheet>