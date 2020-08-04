package havadurumu;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Weather {

    static String Find(int i) throws IOException {
        switch (i) {
            case 0:
                Document d1 = Jsoup.connect("https://weather.com/weather/today/l/55978b07b5896876b3e85a5e9f7c4ad76e09d99f2fd742302c584475d06931e9").get();
                Element e1 = d1.selectFirst("div[class=\"_-_-components-src-organism-CurrentConditions-CurrentConditions--primary--2DOqs\"]");
                String text1 = e1.selectFirst("span").toString();
                int degree1 = Integer.parseInt(text1.substring(text1.indexOf(">", 1) + 1, text1.indexOf("<", 1) - 1));
                return "Ankara : " + FAHRENHEIT_TO_CELSIUS(degree1) + "°";
            case 1:
                Document d2 = Jsoup.connect("https://weather.com/weather/today/l/33d1e415eb66f3e1ab35c3add45fccf4512715d329edbd91c806a6957e123b49").get();
                Element e2 = d2.selectFirst("div[class=\"_-_-components-src-organism-CurrentConditions-CurrentConditions--primary--2DOqs\"]");
                String text2 = e2.selectFirst("span").toString();
                int degree2 = Integer.parseInt(text2.substring(text2.indexOf(">", 1) + 1, text2.indexOf("<", 1) - 1));
                return "İstanbul : " + FAHRENHEIT_TO_CELSIUS(degree2) + "°";
            case 2:
                Document d3 = Jsoup.connect("https://weather.com/weather/today/l/732c4167ec6f3fd504700f6577eb289823a305bbb62a2912e5a2adebc88877e0").get();
                Element e3 = d3.selectFirst("div[class=\"_-_-components-src-organism-CurrentConditions-CurrentConditions--primary--2DOqs\"]");
                String text3 = e3.selectFirst("span").toString();
                int degree3 = Integer.parseInt(text3.substring(text3.indexOf(">", 1) + 1, text3.indexOf("<", 1) - 1));
                return "İzmir : " + FAHRENHEIT_TO_CELSIUS(degree3) + "°";
        }
        return "";
    }

    static int FAHRENHEIT_TO_CELSIUS(int value) {
        double value2 = (value - 32) * (0.5556);
        return (int) Math.round(value2);
    }

    public static void main(String[] args) throws IOException {
        Screen s = new Screen();
        s.setVisible(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        s.setLocation(dim.width - s.getWidth(), 0); 
    }
}
