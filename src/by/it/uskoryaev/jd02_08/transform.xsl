<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html" encoding="utf-8"/>
    <xsl:template match="/BaseFace">
        <html>
            <head>
                <body>
                    <table border = "1">
                        <tr>
                            <td>
                                nickName
                            </td>
                            <td>
                                email
                            </td>
                            <td>
                                password
                            </td>
                            <td>chooseCar</td>
                        </tr>
                        <xsl:apply-templates/>
                    </table>
                </body>
            </head>
        </html>
    </xsl:template>

    <xsl:template match="/BaseFace/User">
        <tr>
            <xsl:apply-templates/>
        </tr>
    </xsl:template>

    <xsl:template match="/BaseFace/User/nickName">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template> <xsl:template match="/BaseFace/User/emal">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template> <xsl:template match="/BaseFace/User/password">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>
    <xsl:template match="/BaseFace/User/ChooseCar">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>
</xsl:stylesheet>

