<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html" encoding="windows-1251"/>
    <xsl:template match="/Books">
    <style type="text/css">
        th {
            Text-color: #6699ff;
            text-align: center;
            border-style: solid;
            font-size: 12px;
            border-width: 0.1px;
            width: 10%;

        }
        tr, td {

            background-color: white;
            border-style: dotted;
            border-color: black;
            border-width: 1px;
            empty-cells: show;
            vertical-align: center;
            text-align: center;
            text-color: grey;
            font-size: 12px;
        }
    </style>
        <xsl:variable name='newline'><br></br></xsl:variable>
        <xsl:for-each select="Book">
            <table align="center" width="60%">
                <tr>
                    <xsl:variable name="imglink"><xsl:value-of select="BookImgName" /></xsl:variable>
                    <th>
                        <img src ="{$imglink}" heigh="150" width="100"></img>
                    </th>
                    <td>
                        <table>

                            <tr>
                                <th>Название</th>
                                <td><xsl:value-of select="BookName"/></td>
                            </tr>
                            <tr>
                                <th>Язык</th>
                                <td><xsl:value-of select="BookLanguage"/></td>
                            </tr>
                            <tr>
                                <th>Авторы</th>
                                <xsl:variable name="authors"/>
                                <td>
                                    <xsl:for-each select="BookAuthors/BookAuthor">
                                        <xsl:if test="not(position() = last())">
                                            <xsl:value-of select="concat($authors, AuthorName, ', ')"/>
                                        </xsl:if>

                                        <xsl:if test="position() = last()">
                                            <xsl:value-of select="AuthorName"/>
                                        </xsl:if>
                                    </xsl:for-each>
                                </td>
                            </tr>
                            <tr>
                                <th>Страна</th>
                                <td><xsl:value-of select="BookCountry"/></td>
                            </tr>
                            <tr>
                                <th>Описание</th>
                                <td><xsl:value-of select="BookDescription"/></td>
                            </tr>
                            <tr>
                                <th>Формат книги</th>
                                <td><xsl:value-of select="BookFormat"/></td>
                            </tr>
                            <tr>
                                <th>Ссылка</th>
                                <xsl:variable name="hyperlink"><xsl:value-of select="BookFileName" /></xsl:variable>
                                <td>
                                    <a name = "link" href="{$hyperlink}" >Скачать</a>
                                </td>

                            </tr>

                        </table>
                    </td>
                </tr>
            </table>



            <br/>
            <br/>
            <br/>

        </xsl:for-each>



    </xsl:template>

</xsl:stylesheet>
