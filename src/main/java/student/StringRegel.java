package student;

public class StringRegel{
    public String propertyName;
    public String winningName;
    public String losingName;
    public StringRegel ( String propertyName, String winningName, String losingName ){
        this.propertyName = propertyName;
        this.winningName = winningName;
        this.losingName = losingName;
    }

    public String getPropertyName(){
        return this.propertyName;
    }

    public void setPropertyName( String propertyName){
       this.propertyName = propertyName;
    }

    public String getWinningName(){
        return this.winningName;
    }

    public void setWinningName( String winningName){
        this.winningName = winningName;
    }

      public String getLosingName(){
        return this.losingName;
    }

    public void setLosingName( String losingName){
         this.losingName = losingName;
    }
}
