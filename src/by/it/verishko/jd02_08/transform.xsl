<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>
    <xsl:template match="/Persons">
        <table border="1">
            <tr>
                <td>
                    Email
                </td>
                <td>
                    Nickname
                </td>
                <td>
                    Password
                </td>
                <td>Goods</td>
            </tr>
            <xsl:apply-templates/>
        </table>
    </xsl:template>

    <xsl:template match="/Persons/Person">
        <tr>
            <xsl:apply-templates/>
        </tr>
    </xsl:template>

    <xsl:template match="/Persons/Person/Email">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>
    <xsl:template match="/Persons/Person/Nickname">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>
    <xsl:template match="/Persons/Person/Password">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>
    <xsl:template match="/Persons/Person/Goods">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>


</xsl:stylesheet>