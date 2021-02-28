package student;

public class StringEigenschaft{
    public String cardName;
    public String propertyName;
    public String value;

    public StringEigenschaft ( String cardName, String propertyName, String value ) {
        this.cardName = cardName;
        this.propertyName = propertyName;
        this.value = value;
    }

    public String getCardName () {
        return this.cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    } 

    public String getPropertyName () {
        return this.propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    } 

    public String getValue () {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    } 
}
