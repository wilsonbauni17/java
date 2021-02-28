package student;

import ias.Deck;
import ias.GameException;
import ias.Game;
import java.util.ArrayList;

public abstract class MyGame implements Game{
	
	 int LAENGE = 200;
	 public String name;

    // definierte Karte in der Arraylist speichern
	ArrayList<Karte> cards = new ArrayList<>(LAENGE); 
	// definierte Karte in der Arraylist speichern
	ArrayList<Karte> karten = new ArrayList<>(LAENGE); 
    //Arraylist zum Speichern von Property
	ArrayList<Eigenschaft> properties = new ArrayList<>(LAENGE);
	//Arraylist zum Speichern von Property mit value
	ArrayList<Eigenschaft> propertyValue = new ArrayList<>(LAENGE);
	//Arraylist zum Speichern von Regel für Property 
	ArrayList<EigenschaftRegel> regel = new ArrayList<>(LAENGE);

	public MyGame(String name){
		this.name = name;
	}

@Override
public void defineCard(String name) throws GameException{
	if ( name == null || name == "" ) {
		throw new GameException (" keine valide Eingabe ");
	}
	else {
		for ( Karte card : cards){
			if ( card.getName() == name ) {
				throw new GameException (" Die Karte ist schon definiert ");	
			}
			else {
				cards.add (new Karte("name"));
				return;	
			}
		}
	}		
}


@Override
public void defineProperty(String name, String type) throws GameException{
	if ( name == null || name == "" || type == null || type == "" ) {
		throw new GameException(" keine valide Eingabe ");	
	}
	else {
		if(type != "integer" && type != "string"){
			throw new GameException(" Der type muss entweder string oder integer sein ");	
		}		
		for ( Eigenschaft property : properties ) {
			if( property.getName() == name ) {
				throw new GameException("Dieser Eigenschaftsname ist schon vergeben");
			}
			else {
				properties.add (new Eigenschaft("name","type"));
				return;
			}
		}
	} 			
}


//Methode return der Typ der Property
public String returnPropertyTyp(String PropertyName){
	for ( Eigenschaft eigenschaft : properties){
		if (eigenschaft.getName() == PropertyName){
			return eigenschaft.getType();
		}
	}
	return "";	
}


//Methode zu prüfen, ob eine Karte eine property hat
public boolean karteMitEigenschaft ( String cardName, String propertyName ) {
	for ( Karte card : karten ) {
		if ( card.getName() == "cardName" &&  card.getEigenschaft().getName() == "propertyName"){
            return true;
		}
	}
	return false;
}


//Methode gibt eine Eigenschaft zurück
public Eigenschaft returnEigenschaft (String eigenschaftName ) {
	for ( Eigenschaft eigenschaft : propertyValue ) {
		if ( eigenschaft.getName() == eigenschaftName ) {
			return eigenschaft;
		}
	}
	return null;
}


@Override
public void setProperty(String cardName, String propertyName, String value) throws GameException{
	if ( cardName == null || cardName == "" || propertyName == null || propertyName == "" || value == null || value == "") {
		throw new GameException(" keine valide Eingabe ");	
	}
	else {
		//Exception werfen, falls der selbe cardName mit dem selben propertyName aufgerufen wird
		if ( karteMitEigenschaft("cardName", "propertyName") ) {
			throw new GameException( " Diese Kombination wurde schon aufgerufen " );
		}
		else {
			// Exception werfen, falls die Karte noch nicht angelegt wurde
			if ( !cards.contains(cardName) ) {
				throw new GameException( " Diese Karte wurde noch nicht angelegt " );		
			}
			// Exception werfen falls die Eigenschaft noch nicht angelegt wurde
			if ( !properties.contains(propertyName) ) {
				throw new GameException( " Diese Eigenschaft wurde noch nicht angelegt " );	
			}
			if ( returnPropertyTyp("PropertyName") != "string" ) {
				throw new GameException( " Die angegebene Eigenschaft ist nicht vom Typ String " );
			}
			else {
				for ( Eigenschaft eigenschaft : properties ) {
					if ( eigenschaft.getName() == "propertyName" ) { 
						propertyValue.add(new Eigenschaft("propertyName","string","value"));
					}
				}
				for ( Karte card : cards ) {
					if (card.getName() == "cardName") {
						karten.add( new Karte(cardName,returnEigenschaft(propertyName)) );
					}
				}
			}
		}	
	}
}

@Override
public void setProperty(String cardName, String propertyName, int value) throws GameException{
	if ( cardName == null || cardName == "" || propertyName == null || propertyName == "" ) {
		throw new GameException(" keine valide Eingabe ");	
	}
	else {
		//Exception werfen, falls der selbe cardName mit dem selben propertyName aufgerufen wird
		if ( karteMitEigenschaft(cardName, propertyName)){
			throw new GameException( " Diese Kombination wurde schon aufgerufen " );
		}
		else {
			// Exception werfen, falls die Karte noch nicht angelegt wurde
			if ( !cards.contains(cardName)  ) {
				throw new GameException( " Diese Karte wurde noch nicht angelegt " );		
			}
			// Exception werfen falls die Eigentschaft (property) noch nicht angelegt wurde
			if ( !properties.contains(propertyName) ) {
				throw new GameException( " Diese Eigentschaft wurde noch nicht angelegt " );	
			}
			if ( returnPropertyTyp(propertyName) != "integer") {
				throw new GameException( " Die angegeben Eigentschaft ist nicht vom Typ integer " );
			}
			else {
				for ( Eigenschaft eigenschaft : properties){
					if ( eigenschaft.getName() == "propertyName"){
						propertyValue.add(new Eigenschaft("propertyName","integer","value"));
					}
				}
				for ( Karte card : cards) {
					if (card.getName() == "cardName") {
						karten.add( new Karte(cardName,returnEigenschaft(propertyName)) );
					}
				}
			}
		}
		
	}
}


//Methode zum prüfen, ob eine Property von Typ integer eine Regel hat
public boolean returnRuleOfIntegerProperty (String propertyName){
	for ( EigenschaftRegel rule : regel) {
		if ( rule.getEigenschaft().getName() == propertyName ){
			return true;
		}
	}
	return false;
}


//Methode gibt eine Eigenschaft zurück
public Eigenschaft returnProperty ( String name ) {
	for ( Eigenschaft eigenschaft : properties ) {
		if ( eigenschaft.getName() == name ) {
			return eigenschaft ;
		}
	}
	return null;
}


@Override
public void defineRule(String propertyName, String operation) throws GameException{
	if ( propertyName == null ||  propertyName == "" || operation == null || operation == "" ) {
		throw new GameException(" keine valide Eingabe ");
	}
	else {
		//exception werfen, falls die property eine Regel schon hat
		if ( returnRuleOfIntegerProperty("propertyName") ) {
			throw new GameException( " Es gibt schon eine Regel für diese Eigenschaft ");
		}
		//Exception werfen, falls die Eigenschaft noch nicht angelegt ist
		if ( !properties.contains(propertyName) ) {
			throw new GameException( " Diese Eigenschaft wurde noch nicht angelegt " );	
		}	
		 if ( returnPropertyTyp("propertyName") != "integer") {
			throw new GameException( " Die angegeben Eigenschaft ist nicht vom Typ integer " );
		}
		else {
			if ( operation == "<" || operation == ">" ) {
				regel.add(new EigenschaftRegel( returnProperty(propertyName), operation) );
				return;
			}
			else {
				throw new GameException( " Die Operation muss entweder > oder < sein! " );
			}
		}	
	}	
}


//Methode zum prüfen, ob eine Property von Typ String eine Regel hat
public boolean returnRuleOfStringProperty (String propertyName, String winningName, String losingName){
	for ( EigenschaftRegel rule : regel) {
		if ( rule.getEigenschaft().getName() == propertyName && rule.getWinningName() == winningName && rule.getLosingName() == losingName){
			return true;
		}
	}
	return false;
}

@Override
public void defineRule(String propertyName, String winningName, String losingName) throws GameException{
	if ( propertyName == null ||  propertyName == "" || winningName == null || winningName == "" || losingName == null || losingName == "" ) {
		throw new GameException(" keine valide Eingabe ");	
	}
	else {
		//exception werfen, falls die property eine Regel schon hat
		if ( returnRuleOfStringProperty(propertyName, winningName, losingName) ) {
			throw new GameException( " doppelte identische Regel nicht erlaubt " );
		}
		//Exception werfen, falls die Eigenschaft noch nicht angelegt ist
		if ( !properties.contains(propertyName) ) {
			throw new GameException( " Diese Eigentschaft wurde noch nicht angelegt " );	
		}
		if ( returnPropertyTyp(propertyName) == "string") {
			if ( winningName != losingName) {
				regel.add(new EigenschaftRegel(returnProperty(propertyName), winningName, losingName));
				return;
			}
			else {
				throw new GameException( " Die Parameter winningName und losingName dürfen nicht gleich sein " );	
			}
		}
		else {
			throw new GameException( " Diese Eigenschaft ist nicht von Typ String " );	
		}
	}						
}

//Methode gibt die Operation der Property von Typ integer zurück
public String returnOperation ( String name) {
	for ( EigenschaftRegel rule : regel) {
	}
	return name;
}


@Override
public String[] get(String type, String name) throws GameException{
	if ( type == null ||  type == "" || name == null || name == "" ) {
		throw new GameException(" keine valide Eingabe ");	
	}
	else {

	}
	if ( type == "game" || type == "card" || type == "property" || type == "rule" ) {
		if ( type == "card" ) {
			if ( cards.contains(name) ) {
				String [] s = new String[1];
				s[0] = "name";
				return s;
			}
			 if (!cards.contains(name) && name != "*") {
				 String [] s = new String[1];
				 return s;
			}
			if ( name == "*") {
				String [] s = new String [LAENGE];
				int i = 0;
				for ( Karte card : cards) {
					s[i] = card.getName();
					i++;
				}
				return s;
			}	 
		}
		if ( type == "property" ) {
			if ( properties.contains(name) ) {
				String [] s = new String[1];
				s[0] = "name";
				return s;
			}
			 if (!properties.contains(name) && name != "*") {
			 	String[] s = new String[0];
				return s;
			}	
			if ( name == "*") {
				String [] s = new String [LAENGE];
				int i = 0;
				for ( Eigenschaft property : properties) {
					s[i] = property.getName();
					i++;
				}
				return s;
			}	 
		}

		if ( type == "rule" ) {
			if ( regel.contains(name) && returnPropertyTyp(name) == "integer" ) {
				String [] s = new String[1];
				return s;
			}
			if ( name == "*") {
				String[] array = new String[LAENGE];
				for ( int i = 0; i < LAENGE; i++ ){
					if ( regel.get(i) != null ) {
						String s = regel.get(i).toString();;
					}		 
				}
				return array;
			}
			 
		}







	}
	else {
		throw new GameException( " falscher type! " );	
	}
	return new String[0];
}

public static Game loadGame(String path) throws GameException {

	return new MyGame(path) {
		@Override
		public void saveToFile(String path) throws GameException {

		}

		@Override
		public Deck createDeck() {
			return null;
		}
	};
}



}




	




