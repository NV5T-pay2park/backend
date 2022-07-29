package pay2park.util;

import java.io.InputStream;
import java.util.Scanner;

public class InputHelper {
    private final Scanner in;

    public InputHelper(InputStream input) {
        this.in = new Scanner(input);
    }
    public String input() {
        return in.nextLine();
    }
}