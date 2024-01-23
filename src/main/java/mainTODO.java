public class mainTODO {
    public static void main(String[] args) {
        String username = loginTODO.login();

        while (username == null) {
            System.out.println("User cannot be found, try again.");
            username = loginTODO.login();
        }

        //
        menyTODO.välkomnaAnvändare(username);
        menyTODO.menyalternativ(username);
    }
}
