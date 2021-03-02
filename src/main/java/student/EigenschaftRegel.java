package student;

public class EigenschaftRegel {
    private Eigenschaft eigenschaft;
    private String operation;
    private String winningName;
    private String losingName;

    public EigenschaftRegel ( Eigenschaft eigenschaft, String operation) {
        this.eigenschaft = eigenschaft;
        this.operation = operation;
    }

    public EigenschaftRegel ( Eigenschaft eigenschaft, String winningName, String losingName) {
        this.eigenschaft = eigenschaft;
        this.winningName = winningName;
        this.losingName  = losingName;
    }

    public Eigenschaft getEigenschaft() {
        return this.eigenschaft;
    }

    public void setEigenschaft( Eigenschaft eigenschaft) {
        this.eigenschaft = eigenschaft;
    }

    public String getOperation() {
        return this.operation;
    }

    public void setOperation( String operation) {
        this.operation = operation;
    }

    public String getWinningName() {
        return this.winningName;
    }

    public void setWinningName(String winningName) {
        this.winningName = winningName;
    }

    public String getLosingName() {
        return this.losingName;
    }

    public void setLosingName(String losingName) {
        this.losingName = losingName;
    }


}
