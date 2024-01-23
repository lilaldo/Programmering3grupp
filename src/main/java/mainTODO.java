public class mainTODO {
    public static void main(String[] args) {
        String username = loginTODO.login();

        while (username == null) {
            username = loginTODO.login();
        }

        //
        menyTODO.välkomnaAnvändare(username);
        menyTODO.menyalternativ(username);
    }
}
