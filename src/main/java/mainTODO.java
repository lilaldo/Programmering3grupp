public class mainTODO {
    public static void main(String[] args) {
        String username = loginTODO.login();    // 1. programet startas, välj login eller reg?

        // om användaren inte hittas så startas while-loopen. (behöver fixas då allt är godkänt just nu).
        while (username == null) {
            System.out.println("Hittade inte användaren, var god försök igen.");
            username = loginTODO.login();
        }

        menyTODO.välkomnaAnvändare(username);   // 2. välkomsttext.
        menyTODO.menyalternativ();              // 3. menyn körs.
    }
}
