/**
 * Class description
 */

package student;

import ias.Deck;
import ias.GameException;
import ias.Game;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyGame implements Game{

	int LAENGE = 200;
	private String name;

	// definierte Karte in der Arraylist speichern
	private List<Karte> cards = new ArrayList<>(LAENGE);

	//Arraylist zum Speichern von Property
	private List<Eigenschaft> properties = new ArrayList<>(LAENGE);

	//Arraylist zum Speichern von Regel für Property
	private List<EigenschaftRegel> regels = new ArrayList<>(LAENGE);


	public MyGame(String name){
		this.name = name;
	}

	@Override
	public void defineCard(String name) throws GameException{
		if ( name == null || name.trim().equals("")) {
			throw new GameException (" Keine valide Eingabe ");
		}
		else {
			for ( Karte card : cards){
				if ( card.getName().equals(name)) {
					throw new GameException (" Die Karte ist schon definiert ");
				}
			}
			cards.add(new Karte(name));
		}
	}

	@Override
	public void defineProperty(String name, String type) throws GameException{
		if ( name == null || name.trim().equals("") || type == null || type.trim().equals("") ) {
			throw new GameException(" keine valide Eingabe ");
		}
		else {
			if(!type.equals("integer") && !type.equals("string")){
				throw new GameException(" Der type muss entweder string oder integer sein ");
			}
			for ( Eigenschaft property : properties ) {
				if( property.getName().equals(name) ) {
					throw new GameException("Dieser Eigenschaftsname ist schon vergeben");
				}
			}
			properties.add (new Eigenschaft(name, type));
		}
	}

	@Override
	public void setProperty(String cardName, String propertyName, String value) throws GameException{
		if ( cardName == null || cardName.trim().equals("") || propertyName == null || propertyName.trim().equals("") || value == null || value.trim().equals("")) {
			throw new GameException(" keine valide Eingabe ");
		}else{
			// Get the define card
			Karte karte = null;
			for(Karte card: cards){
				if(card.getName().equals(cardName)){
					karte = card;
				}
			}
			if(karte == null){
				throw new GameException(" Card does not exists ");
			}

			// Get the define property
			Eigenschaft eigenschaft = null;
			for (Eigenschaft property: properties){
				if(property.getName().equals(propertyName)){
					eigenschaft = property;
				}
			}
			if(eigenschaft == null){
				throw new GameException(" Property does not exists ");
			}

			// Set the value of the property
			if(eigenschaft.getType().equals("string")){
				if(eigenschaft.getStringValue() != null){
					throw new GameException(" The property has value already ");
				}else{
					eigenschaft.setStringValue(value);
					// Verify that the same card don't have the same property set
					if(karte.getEigenschaft() != null && karte.getEigenschaft().getName().equals(propertyName)){
						throw new GameException(" The card already have that property ");
					}else{
						karte.setEigenschaft(eigenschaft);
					}
				}
			}else{
				throw new GameException(" The value of the property has to be a string ");
			}
		}
	}

	@Override
	public void setProperty(String cardName, String propertyName, int value) throws GameException{
		if ( cardName == null || cardName.trim().equals("") || propertyName == null || propertyName.trim().equals("")) {
			throw new GameException(" keine valide Eingabe ");
		}else{
			// Get the define card
			Karte karte = null;
			for(Karte card: cards){
				if(card.getName().equals(cardName)){
					karte = card;
				}
			}
			if(karte == null){
				throw new GameException(" Card does not exists ");
			}

			// Get the define property
			Eigenschaft eigenschaft = null;
			for (Eigenschaft property: properties){
				if(property.getName().equals(propertyName)){
					eigenschaft = property;
				}
			}
			if(eigenschaft == null){
				throw new GameException(" Property does not exists ");
			}

			// Set the value of the property
			if(eigenschaft.getType().equals("integer")){
				eigenschaft.setIntValue(value);

				// Verify that the same card don't have the same property set
				if(karte.getEigenschaft() != null && karte.getEigenschaft().getName().equals(propertyName)){
					throw new GameException(" The card already have that property ");
				}else{
					karte.setEigenschaft(eigenschaft);
				}
			}else{
				throw new GameException(" The value of the property has to be an integer ");
			}
		}
	}

	@Override
	public void defineRule(String propertyName, String operation) throws GameException{
		if ( propertyName == null ||  propertyName.trim().equals("") || operation == null || operation.trim().equals("") ) {
			throw new GameException(" Keine valide Eingabe ");
		}else {
			// Get the property
			Eigenschaft eigenschaft = null;
			for(Eigenschaft property: properties){
				if(property.getName().equals(propertyName))
					eigenschaft = property;
			}

			if(eigenschaft == null)
				throw new GameException(" No property exists with the name " + propertyName);

			if(eigenschaft.getType().equals("integer")){

				// Verify if rule already exists
				for(EigenschaftRegel eigenschaftRegel: regels){
					if(eigenschaftRegel.getEigenschaft().getName().trim().equals(propertyName) && eigenschaftRegel.getOperation() != null && eigenschaftRegel.getOperation().equals(operation))
						throw new GameException(" This property already have an operation ");
				}
				if(operation.equals("<") || operation.equals(">")){
					regels.add(new EigenschaftRegel(eigenschaft, operation));
				}else {
					throw new GameException(" Invalid operation character ");
				}
			}else{
				throw new GameException(" This operation is applicable only for integer properties ");
			}
		}
	}

	@Override
	public void defineRule(String propertyName, String winningName, String losingName) throws GameException{
		if ( propertyName == null ||  propertyName.trim().equals("") || winningName == null || winningName.trim().equals("") || losingName == null || losingName.trim().equals("") ) {
			throw new GameException(" Keine valide Eingabe ");
		}else {
			// Get the property
			Eigenschaft eigenschaft = null;
			for(Eigenschaft property: properties){
				if(property.getName().equals(propertyName))
					eigenschaft = property;
			}
			if(eigenschaft == null)
				throw new GameException(" No property exists with the name " + propertyName);

			if(eigenschaft.getType().equals("string")){

				// Verify if rule already exists
				for(EigenschaftRegel eigenschaftRegel: regels){
					if(eigenschaftRegel.getEigenschaft().getName().trim().equals(propertyName) && eigenschaftRegel.getWinningName() != null && eigenschaftRegel.getWinningName().trim().equals(winningName) && eigenschaftRegel.getLosingName() != null && eigenschaftRegel.getLosingName().trim().equals(losingName))
						throw new GameException(" This rule has been defined on this property ");
				}
				regels.add(new EigenschaftRegel(eigenschaft, winningName, losingName));
			}else{
				throw new GameException(" This operation is applicable only for string properties ");
			}
		}
	}

	@Override
	public String[] get(String type, String name) throws GameException{
		if ( type == null ||  type.trim().equals("") || name == null || name.trim().equals("")) {
			throw new GameException(" keine valide Eingabe ");
		}else {
			if ( type.equals("game") || type.equals("card") || type.equals("property") || type.equals("rule") ) {
				if ( type.equals("card")) {
					List<String> resultCards = new ArrayList<>();
					if(name.equals("*")){
						for(Karte card: cards){
							resultCards.add(card.getName());
						}
					}else{
						for(Karte card: cards){
							if(card.getName().equals(name))
								resultCards.add(card.getName());
						}
					}
					return resultCards.toArray(new String[0]);
				}else if ( type.equals("property")) {
					List<String> resultProperties = new ArrayList<>();
					if(name.equals("*")){
						for(Eigenschaft property: properties){
							resultProperties.add(property.getName());
						}
					}else{
						for(Eigenschaft property: properties){
							if(property.getName().equals(name))
								resultProperties.add(property.getName());
						}
					}
					return resultProperties.toArray(new String[0]);
				}else if ( type.equals("rule")) {
					List<String> resultRules = new ArrayList<>();
					if(name.equals("*")){
						for(EigenschaftRegel rule: regels){
							if(rule.getOperation() != null){
								resultRules.add(rule.getEigenschaft().getName() + ":" + rule.getOperation());
							}else{
								resultRules.add(rule.getEigenschaft().getName() + ":" + rule.getWinningName() + ">" + rule.getLosingName());
							}
						}
					}else{
						for(EigenschaftRegel rule: regels){
							String propertyName = name.split(":")[0];
							String winningName = (name.split(":")[1]).split(">")[0];
							String losingName = (name.split(":")[1]).split(">")[1];
							if(rule.getEigenschaft().getName().equals(propertyName) && rule.getWinningName().equals(winningName) && rule.getLosingName().equals(losingName))
								resultRules.add(name);
						}
					}
					return resultRules.toArray(new String[0]);
				}else if (type.equals("game")){
					return new String [] {"Test"};
				}else{
					throw new GameException( " The type is not recognized " );
				}
			}
			else {
				throw new GameException( " falscher type! " );
			}
		}
	}

	@Override
	public void saveToFile(String path) throws GameException{
		// TODO: Save game to file
//		try {
//			File file = new File(path);
//			if(file.createNewFile()){
//				FileWriter fw = new FileWriter(file);
//				// Write the first line
//				fw.write("Game: Magic \n");
//
//				// For each card, write it's informations
//				for(Karte card: cards){
//					fw.write("Card: " + card.getName() + "\n");
//					for(Eigenschaft property: properties){
//						// TODO
//					}
//				}
//				fw.close();
//			}else{
//				throw new GameException(" Game file already exists ");
//			}
//		} catch (IOException e) {
//			throw new GameException(" File not found ");
//		}
	}

	@Override
	public Deck createDeck(){
		return new MyDeck(this);
	}

	public Game createGame(String name){
		return new MyGame(name);
	}

	public static Game loadGame(String path) throws GameException {
		// TODO: Read game informations from path
		return new MyGame("Test");
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Karte> getCards() {
		return cards;
	}

	public void setCards(List<Karte> cards) {
		this.cards = cards;
	}

	public List<Eigenschaft> getProperties() {
		return properties;
	}

	public void setProperties(List<Eigenschaft> properties) {
		this.properties = properties;
	}

	public List<EigenschaftRegel> getRegels() {
		return regels;
	}

	public void setRegels(List<EigenschaftRegel> regels) {
		this.regels = regels;
	}
}




	




