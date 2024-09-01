public class Main {
    public static void main(String[] args) {

        IdsPasswords idsPasswords = new IdsPasswords();

        LoginPage loginPage = new LoginPage(idsPasswords.getLoginInfo());
    }
}
