<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>
    <xsl:template match="/Manufacturer">
        <table border="2"  >
        <thead>Managers</thead>
            <xsl:apply-templates/>
        </table>
    </xsl:template>

    <xsl:template match="/Manufacturer/Managers/Manager">
            <tr>
                <td bgcolor="black">
                    <font color="white"><b>FullName</b></font>
                </td>
                <td bgcolor="black">
                    <font color="white"><b>  Email</b></font>
                </td>
            </tr>
            <xsl:apply-templates/>
    </xsl:template>
    <xsl:template match="/Manufacturer/Managers/Manager/FullName">
        <td>
            <font><i><xsl:apply-templates/></i></font>
        </td>
    </xsl:template>

    <xsl:template match="/Manufacturer/Managers/Manager/Email">
        <td>
            <i><xsl:apply-templates/></i>
        </td>
    </xsl:template>


    <xsl:template match="/Manufacturer/Managers/Manager/Contracts">
        <tr>
            <xsl:apply-templates/>
        </tr>
    </xsl:template>
    <xsl:template match="/Manufacturer/Managers/Manager/Contracts/Contract">
        <tr>
          <td>
              <b>Client</b>
          </td>
            <td>
                <b>ContractNumber</b>
            </td>
        </tr>
        <xsl:apply-templates/>
    </xsl:template>
    <xsl:template match="/Manufacturer/Managers/Manager/Contracts/Contract/Client">
        <td>
            <i><xsl:apply-templates/></i>
        </td>
    </xsl:template>
    <xsl:template match="/Manufacturer/Managers/Manager/Contracts/Contract/ContractNumber">
        <td>
           <i> <xsl:apply-templates/></i>
        </td>
        <tr>
            <td><b>Type</b></td>
            <td><b>Price</b></td>
            <td><b>Quantity</b></td>
            <td><b>HDemention</b></td>
            <td><b>VDemention</b></td>
            <td><b>Opening</b></td>
            <td><b>Color</b></td>
        </tr>
    </xsl:template>
    <xsl:template match="/Manufacturer/Managers/Manager/Contracts/Contract/Door">
        <tr>
            <i><xsl:apply-templates/></i>
        </tr>
    </xsl:template>
    <xsl:template match="/Manufacturer/Managers/Manager/Contracts/Contract/Door/Type">
    <td>
        <i><xsl:apply-templates/></i>
    </td>
    </xsl:template>
    <xsl:template match="/Manufacturer/Managers/Manager/Contracts/Contract/Door/Price">
        <td>
            <i><xsl:apply-templates/></i>
        </td>
    </xsl:template>
    <xsl:template match="/Manufacturer/Managers/Manager/Contracts/Contract/Door/Quantity">
        <td>
            <i><xsl:apply-templates/></i>
        </td>
    </xsl:template>
    <xsl:template match="/Manufacturer/Managers/Manager/Contracts/Contract/Door/HDemention">
        <td>
            <i><xsl:apply-templates/></i>
        </td>
    </xsl:template>
    <xsl:template match="/Manufacturer/Managers/Manager/Contracts/Contract/Door/VDemention">
        <td>
            <i><xsl:apply-templates/></i>
        </td>
    </xsl:template>
    <xsl:template match="/Manufacturer/Managers/Manager/Contracts/Contract/Door/Opening">
        <td>
            <i><xsl:apply-templates/></i>
        </td>
    </xsl:template>
    <xsl:template match="/Manufacturer/Managers/Manager/Contracts/Contract/Door/Color">
        <td>
            <i><xsl:apply-templates/></i>
        </td>
    </xsl:template>



</xsl:stylesheet>