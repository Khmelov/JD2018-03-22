<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html" encoding="utf-8"/>
    <xsl:template match="/Users">
        <html>
        <head/>
        <body>
        <table border="1">
            <tr><td>Email</td><td>NickName</td><td>Password</td><td>Cart</td></tr>
            <xsl:apply-templates/>
        </table>
        </body>
        </html>
    </xsl:template>


    <xsl:template match="/Users/User">
        <tr><xsl:apply-templates/></tr>
    </xsl:template>

    <xsl:template match="/Users/User/Email">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/Users/User/Nickname">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/Users/User/Password">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/Users/User/Cart">
        <td><xsl:apply-templates/></td>
        <!--<tr>-->
        <!--<td><xsl:template match="Name"/></td>-->
        <!--<td><xsl:template match="Type"/></td>-->
        <!--<td><xsl:template match="Description"/></td>-->
        <!--<td><xsl:template match="Price"/></td>-->
        <!--<td><xsl:template match="Price"/></td>-->
        <!--</tr>-->
    </xsl:template>



</xsl:stylesheet>