package ias;

import student.MyGame;

public final class Factory {
    public static Game createGame(String name) throws GameException {
        return new MyGame(name) {
            @Override
            public void saveToFile(String path) throws GameException {

            }

            @Override
            public Deck createDeck() {
                return null;
            }
        };
    }

    public static Game loadGame(String path) throws GameException {
        return MyGame.loadGame(path);
    }
}
