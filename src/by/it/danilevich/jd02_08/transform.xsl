<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html" encoding="utf-8"/>
    <xsl:template match="/WorkPlan">
        <html>
            <head/>
            <body>
                <table border="1">
                    <tr>
                        <td>
                            Заказчик
                        </td>
                        <td>
                            Адрес
                        </td>
                        <td>
                            Вид работы
                        </td>
                        <td>
                            Стоимость
                        </td>
                    </tr>
                    <xsl:apply-templates/>
                </table>
            </body>
        </html>
    </xsl:template>

    <xsl:template match="/WorkPlan/Order">
        <tr>
            <xsl:apply-templates/>
        </tr>
    </xsl:template>

    <xsl:template match="/WorkPlan/Order/user">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>
    <xsl:template match="/WorkPlan/Order/kindOfWorks">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>
    <xsl:template match="/WorkPlan/Order/adress">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>
    <xsl:template match="/WorkPlan/Order/totalMoneyOrder">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>


</xsl:stylesheet>