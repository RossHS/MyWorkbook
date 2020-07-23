import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Ross Khapilov
 * @version 1.0 22.11.2018
 */
public class parserForWiki {
    public static void main(String[] args) {
        String[] s = ("![plus](https://user-images.githubusercontent.com/30704653/50674916-6e1b4680-0ffb-11e9-88f7-566fe2dcb658.png)\n" +
                "![default](https://user-images.githubusercontent.com/30704653/50674917-6e1b4680-0ffb-11e9-93d1-ad8fa82f8731.png)\n").split("\n");
        Pattern p = Pattern.compile("https://.+\\.png");
        for (int i = 0; i < s.length; i++) {
            Matcher m = p.matcher(s[i]);
            if (m.find()) {
                System.out.println("<img src=\"" + m.group() + "\" width=\"200\">");
            }
        }
    }
}
