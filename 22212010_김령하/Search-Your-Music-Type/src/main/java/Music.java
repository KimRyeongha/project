public class Music {
    private String title;
    private String artist;
    private String genre;
    private String mood;

    public Music(String title, String artist, String genre, String mood) {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.mood = mood;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getGenre() {
        return genre;
    }

    public String getMood() {
        return mood;
    }
}
