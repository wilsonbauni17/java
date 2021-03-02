package student;

public class Karte{
    private String name;
    private Eigenschaft eigenschaft;

    public Karte ( String name ) {
        this.name = name;
    }

    public Karte ( String name, Eigenschaft eigenschaft){
        this.name = name;
        this.eigenschaft = eigenschaft;
    }

    public String getName() {
        return this.name;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    public Eigenschaft getEigenschaft() {
        return this.eigenschaft;
    }

    public void setEigenschaft ( Eigenschaft eigenschaft) {
        this.eigenschaft = eigenschaft;
    }

    public String toString() {
        return "[" + this.name + "]";
    }
}



