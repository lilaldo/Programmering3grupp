import java.util.List;

public class UserData {
    private String username;
    private List<String> tasks;

    public UserData(String username, List<String> tasks) {
        this.username = username;
        this.tasks = tasks;
    }

    public String getUsername() {
        return username;
    }

    public List<String> getTasks() {
        return tasks;
    }

    public void setTasks(List<String> tasks) {
        this.tasks = tasks;
    }
}
