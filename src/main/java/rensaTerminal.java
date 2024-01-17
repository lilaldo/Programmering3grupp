public class rensaTerminal {

    public static void rensa() {
        // ANSI escape-kod för att rensa terminalen.
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}