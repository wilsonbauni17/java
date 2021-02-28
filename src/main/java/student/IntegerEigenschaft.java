package student;

public class IntegerEigenschaft{
    public String cardName;
    public String propertyName;
    public int value;

    public IntegerEigenschaft ( String cardName, String propertyName, int value ) {
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

    public int getValue () {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    } 
}
