<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>
    <xsl:template match="/">
        <html>
            <body>
                <h2>Dictionaries</h2>
                <table border="1">
                    <tr bgcolor="#9acd32">
                        <th>Name</th>
                        <th>Nick</th>
                        <th>Password</th>
                        <th>E-mail</th>
                        <th>Words</th>
                    </tr>
                    <xsl:apply-templates/>
                </table>
            </body>
        </html>
    </xsl:template>

    <xsl:template match="users/user">
        <tr>
            <xsl:apply-templates/>
        </tr>
    </xsl:template>

    <xsl:template match="name">
        <td><xsl:apply-templates/></td>
    </xsl:template>
    <xsl:template match="password">
        <td><xsl:apply-templates/></td>
    </xsl:template>
    <xsl:template match="email">
        <td><xsl:apply-templates/></td>
    </xsl:template>
    <xsl:template match="dictionary">
        <td><xsl:apply-templates/></td>
    </xsl:template>
    <xsl:template match="nickName">
        <td><xsl:apply-templates/></td>
    </xsl:template>
</xsl:stylesheet>

