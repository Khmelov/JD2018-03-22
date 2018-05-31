//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0-b170531.0717 
//         See <a href="https://jaxb.java.net/">https://jaxb.java.net/</a> 
//         Any modifications to this file will be lost upon recompilation of the source schema. 
//         Generated on: 2018.05.30 at 11:08:32 PM MSK 
//


package by.it.lyukovich.jd_02_09;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for BookSysInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected         content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BookSysInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="BookID" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="BookCategoryID" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="BookDateUploaded" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BookSysInfo", propOrder = {
    "bookID",
    "bookCategoryID",
    "bookDateUploaded"
})
public class BookSysInfo {

    @XmlElement(name = "BookID")
    protected int bookID;
    @XmlElement(name = "BookCategoryID")
    protected int bookCategoryID;

    @Override
    public String toString() {
        return "BookSysInfo{" +
                "bookID=" + bookID +
                ", bookCategoryID=" + bookCategoryID +
                ", bookDateUploaded=" + bookDateUploaded +
                '}';
    }

    @XmlElement(name = "BookDateUploaded", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar bookDateUploaded;

    /**
     * Gets the value of the bookID property.
     * 
     */
    public int getBookID() {
        return bookID;
    }

    /**
     * Sets the value of the bookID property.
     * 
     */
    public void setBookID(int value) {
        this.bookID = value;
    }

    /**
     * Gets the value of the bookCategoryID property.
     * 
     */
    public int getBookCategoryID() {
        return bookCategoryID;
    }

    /**
     * Sets the value of the bookCategoryID property.
     * 
     */
    public void setBookCategoryID(int value) {
        this.bookCategoryID = value;
    }

    /**
     * Gets the value of the bookDateUploaded property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getBookDateUploaded() {
        return bookDateUploaded;
    }

    /**
     * Sets the value of the bookDateUploaded property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setBookDateUploaded(XMLGregorianCalendar value) {
        this.bookDateUploaded = value;
    }

}
