package student;

public class Eigenschaft {
    public String name;
    public String type;
    public String value1;
    public int value2;
   
    

    public Eigenschaft ( String name, String type ) {
        this.name = name;
        this.type = type;
    }

    public Eigenschaft ( String name, String type, String value1 ) {
        this.name = name;
        this.type = type;
        this.value1 = value1;
    }

    public Eigenschaft ( String name, String type, int value2 ) {
        this.name = name;
        this.type = type;
        this.value2 = value2;
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

    public String getValue1() {
        return this.value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }
    
    public int getValue2() {
        return this.value2;
    }

    public void setValue2( int value2 ) {
        this.value2 = value2;
    }
    

    

    public String toString(){
        return "[" + this.name + "]";
    }
    
}
