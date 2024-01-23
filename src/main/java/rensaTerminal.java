/*
* Ska inte fungera i intellij idea skärm!
* måste köras från terminalen
* java -jar <full path till .jar fil>
*/

public class rensaTerminal {

    public static void rensa() {
        try {
            String operatingSystem = System.getProperty("os.name").toLowerCase();

            ProcessBuilder pb;

            if (operatingSystem.contains("win")) {
                pb = new ProcessBuilder("cmd", "/c", "cls");
            } else if (operatingSystem.contains("nix") || operatingSystem.contains("nux") || operatingSystem.contains("mac")) {
                pb = new ProcessBuilder("clear");
            } else {
                // Handle unsupported operating systems
                System.out.println("Unsupported operating system");
                return;
            }

            Process startProcess = pb.inheritIO().start();
            startProcess.waitFor();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

