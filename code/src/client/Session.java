package client;

public class Session {

    private static int role_id;
    private static String username;

    public static int getRole_id() {
        return role_id;
    }

    public static void setRole_id(int role_id) {
        Session.role_id = role_id;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        Session.username = username;
    }
}
