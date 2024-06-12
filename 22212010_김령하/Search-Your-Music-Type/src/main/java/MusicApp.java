import java.util.ArrayList;
import java.util.List;
public class MusicApp {
    private List<User> users;
    private List<Music> musicList;
    private User loggedInUser;

    public MusicApp() {
        users = new ArrayList<>();
        musicList = new ArrayList<>();
        addSampleMusic();
    }

    private void addSampleMusic() {
        musicList.add(new Music("Love wins all", "IU", "Ballad", "Calm"));
        musicList.add(new Music("Dry Flower", "Yuuri", "Acoustic", "Calm"));
        musicList.add(new Music("Horizon", "Jaehyun", "POP", "Groovy"));
        musicList.add(new Music("Is it A Crime?", "No Guidnce", "POP", "Groovy"));
        musicList.add(new Music("Love", "Keyshia Cole", "POP", "Groovy"));
        musicList.add(new Music("we can't be friends(wait for your love)", "Ariana Grande", "POP", "Groovy"));
        musicList.add(new Music("Yes or No", "JungKook", "POP", "Groovy"));
        musicList.add(new Music("Fabulous", "TAEYEON", "POP", "Groovy"));
        musicList.add(new Music("Water", "Tyla", "POP", "Groovy"));
        musicList.add(new Music("Saturn", "SZA", "POP", "Groovy"));
        musicList.add(new Music("Oui", "Jeremih", "POP", "Party"));
        musicList.add(new Music("vampire", "Olivia Rodrigo", "POP", "Calm"));
        musicList.add(new Music("Cruel Summer", "Taylor Swift", "POP", "Funky"));
        musicList.add(new Music("Bubble Gum", "NewJeans", "POP", "Funky"));
        musicList.add(new Music("Honestly", "RIIZE", "R&B", "Groovy"));
        musicList.add(new Music("little bit", "CODE KUNST", "R&B", "Groovy"));
        musicList.add(new Music("DIE 4 YOU", "DEAN", "R&B", "Groovy"));
        musicList.add(new Music("Do It For Love", "TAHAMA", "R&B", "Groovy"));
        musicList.add(new Music("Supernova", "aespa", "Dance", "Funky"));
        musicList.add(new Music("Armageddon", "aespa", "Dance", "Dark"));        
        musicList.add(new Music("3 2 1", "JAEHA", "Hip-hop", "Funky"));
        musicList.add(new Music("No Guidance", "Skinny Brown", "Hip-hop", "Groovy"));
        musicList.add(new Music("Pure Water", "Mustared & Migos", "Hip-hop", "Groovy"));
    }

    public boolean registerUser(String nickname, String id, String password) {
        // ID가 이미 존재하는지 확인
        for (User user : users) {
            if (user.getUsername().equals(id)) {
                return false;
            }
        }
        // 새 사용자 등록
        users.add(new User(nickname, id, password));
        return true;
    }

    public User login(String id, String password) {
        for (User user : users) {
            if (user.getUsername().equals(id) && user.getPassword().equals(password)) {
                loggedInUser = user;
                return user;
            }
        }
        return null;
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }

    public void addMusic(Music music) {
        musicList.add(music);
    }

    public List<Music> getMusicList() {
        return musicList;
    }
}
