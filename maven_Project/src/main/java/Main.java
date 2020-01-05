import org.fusesource.jansi.AnsiConsole;

import java.awt.*;
import java.util.Scanner;

import static java.awt.Color.*;
import static org.fusesource.jansi.Ansi.ansi;

/**
 * @PackageName: PACKAGE_NAME
 * @ClassName: Main
 * @Description:
 * @author: 呆呆
 * @date: 2020/1/5
 */
public class Main {
    private static final String[] fo = {
            "                   ooOoo",
            "                 o8888888o",
            "                 88\" . \"88",
            "                 (| -_- |)",
            "                  O\\ = /O",
            "              ____/`---'\\" ,
            "             .   ' \\\\| |// `.",
            "             / \\\\||| : |||// \\",
            "           / _||||| -:- |||||- \\",
            "             | | \\\\\\ - /// | |",
            "           | \\_| ''\\---/'' | |",
            "             \\ .-\\__ `-` ___/-. /",
            "         ___`. .' /--.--\\ `. . __",
            "       .\"\" '< `.___\\_<|>_/___.' >'\"\".",
            "     | | : `- \\`.;`\\ _ /`;.`/ - ` : | |",
            "       \\ \\ `-. \\_ __\\ /__ _/ .-` / /",
            "======`-.____`-.___\\_____/___.-`____.-'======" ,
            "                   `=---='"
    };

    private static void printFO(Color color) {
        System.out.println(ansi().eraseScreen());
        for (String line : fo) {
            System.out.println(ansi().a(line).reset());
        }
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
public static void main(String[] args) {
        AnsiConsole.systemInstall();
        printFO(RED);
        printFO(BLUE);
        printFO(YELLOW);
        printFO(GREEN);
        printFO(CYAN);
        printFO(WHITE);
        AnsiConsole.systemUninstall();
    }
}
