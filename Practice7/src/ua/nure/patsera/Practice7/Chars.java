//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.08.15 at 04:28:49 PM EEST 
//


package ua.nure.patsera.Practice7;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Chars complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Chars">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="turnNumber" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="transparency">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;pattern value="\d\skkal$"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="filtered" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="nutritional�alue">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;pattern value="\\d\\s%$"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="spill" type="{http://www.example.com/Beers}Spill"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Chars", propOrder = {

})
public class Chars {

    @XmlElement(required = true)
    protected BigDecimal turnNumber;
    @XmlElement(required = true)
    protected String transparency;
    protected boolean filtered;
    @XmlElement(required = true)
    protected String nutritional�alue;
    @XmlElement(required = true)
    protected Spill spill;

    /**
     * Gets the value of the turnNumber property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTurnNumber() {
        return turnNumber;
    }

    /**
     * Sets the value of the turnNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTurnNumber(BigDecimal value) {
        this.turnNumber = value;
    }

    /**
     * Gets the value of the transparency property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransparency() {
        return transparency;
    }

    /**
     * Sets the value of the transparency property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransparency(String value) {
        this.transparency = value;
    }

    /**
     * Gets the value of the filtered property.
     * 
     */
    public boolean isFiltered() {
        return filtered;
    }

    /**
     * Sets the value of the filtered property.
     * 
     */
    public void setFiltered(boolean value) {
        this.filtered = value;
    }

    /**
     * Gets the value of the nutritional�alue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNutritional�alue() {
        return nutritional�alue;
    }

    /**
     * Sets the value of the nutritional�alue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNutritional�alue(String value) {
        this.nutritional�alue = value;
    }

    /**
     * Gets the value of the spill property.
     * 
     * @return
     *     possible object is
     *     {@link Spill }
     *     
     */
    public Spill getSpill() {
        return spill;
    }

    /**
     * Sets the value of the spill property.
     * 
     * @param value
     *     allowed object is
     *     {@link Spill }
     *     
     */
    public void setSpill(Spill value) {
        this.spill = value;
    }

}
