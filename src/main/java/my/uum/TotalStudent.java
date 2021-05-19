package my.uum;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class is for count total student.
 *
 * @author Mohd Shukur Bin Zainol Abidin
 */

public class TotalStudent {
    private final String linkStudentList;
    private int total = 0;

    /**
     * This class is for count total student.
     *
     * @param linkStudentList This is the link of Student list.
     */
    TotalStudent(String linkStudentList) {
        this.linkStudentList = linkStudentList;
    }

    /**

     *
     * @return Total Student
     */
    public int scrapingTotalStudent() {
        try {
            Document doc = Jsoup.connect(linkStudentList).get();

            // get students who submit github account
            Elements links = doc.select("tr");
            for (Element link : links) {
                String theLink = link.text();
                String noSubmit = "\\d{6}";
                Pattern p1 = Pattern.compile(noSubmit);   // the pattern to search for
                Matcher m1 = p1.matcher(theLink);
                if (m1.find()) {

                    total++;
//                    System.out.println(total);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return total;
    }
}
