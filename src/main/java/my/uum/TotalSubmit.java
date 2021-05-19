package my.uum;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class is for count total submitted student
 *
 * @author Mohd Shukur Bin Zainol Abidin
 */

public class TotalSubmit {

    private final String linkSubmitList;
    private int total = 0;

    /**
     * This class is for count total submitted student
     *
     * @param linkSubmitList This is the link of Submitted Student.
     */
    TotalSubmit(String linkSubmitList) {
        this.linkSubmitList = linkSubmitList;
    }

    /**
     *
     * @return Total submitted student.
     */
    public int scrapingTotalSubmitStudent() {
        try {
            Document doc2 = Jsoup.connect(linkSubmitList).get();

            // get students who submit github account
            Elements links = doc2.select("p");
            for (Element link : links) {
                String theLink = link.text();
                String submit = "\\d{5,6}";
                Pattern p1 = Pattern.compile(submit);   // the pattern to search for
                Matcher m1 = p1.matcher(theLink);
                if (m1.find()) {
                    total++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return total;
    }

}
