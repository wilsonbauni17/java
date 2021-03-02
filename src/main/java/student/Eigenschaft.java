package student;

public class Eigenschaft {
    private String name;
    private String type;
    private String stringValue;
    private int intValue;

    public Eigenschaft (String name, String type) {
        this.name = name;
        this.type = type;
    }

    public Eigenschaft (String name, String type, String stringValue) {
        this.name = name;
        this.type = type;
        this.stringValue = stringValue;
    }

    public Eigenschaft (String name, String type, int intValue) {
        this.name = name;
        this.type = type;
        this.intValue = intValue;
    }
    
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    } 

    public String getType () {
        return this.type;
    }

    public void setType ( String type) {
        this.type = type;
    }

    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

    public int getIntValue() {
        return intValue;
    }

    public void setIntValue(int intValue) {
        this.intValue = intValue;
    }

    public String toString(){
        return "[" + this.name + "]";
    }
    
}
