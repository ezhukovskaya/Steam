package pageObjects.forms;

public class Genres {

    public Genres goToGenre(String genre) {
        Genres genres = null;
        if(genre.equals("BROWSING_ACTION"))
            genres = new Action();
        if(genre.equals("BROWSING_INDIE"))
            genres = new Indie();
        return genres;
    }
}
