package beans;

public class AppPages {

    public static final String HOME_URL = "/";
    public static final String LOGIN = "/login";
    public static final String LIST = "/list";
    public static final String CREATE = "/create-user";
    public static final String USER = "/user";
    private static final String REDIRECT = "redirect:";

    public static String redirect(String page) {
        return REDIRECT + page;
    }
}
