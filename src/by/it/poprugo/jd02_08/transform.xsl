<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>
    <xsl:template match="/Orders">
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
                <td>
                    Contract
                </td>
            </tr>
            <xsl:apply-templates/> <!--все остальные (?)в одну ячейку?-->
        </table>
    </xsl:template>

    <xsl:template match = "Orders/Person">
        <tr>
            <xsl:apply-templates/>
        </tr>
    </xsl:template>

    <xsl:template match = "Orders/Person/Email">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match = "Orders/Person/Nickname">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match = "Orders/Person/Password">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>
    <xsl:template match="/Orders/Person/Contract">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

</xsl:stylesheet>