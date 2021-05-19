package my.uum;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
/**
 *This class for scraping Submitted Data
 *
 * @author Mohd Shukur Bin Zainol Abidin
 */

public class SubmitData {

    private final String linkSubmitList;
    private final String[] totalSubmit;
    private final String[][] totalSubmit1;
    private String[][] totalSubmit2;


    /**
     *This class for scraping Submitted Data
     *
     * @param linkSubmitList This is the link for scraping data Submitted data.
     * @param total This is the total of Submitted Students.
     */
    SubmitData(String linkSubmitList, int total) {
        this.linkSubmitList = linkSubmitList;
        totalSubmit = new String[total];
        totalSubmit1 = new String[totalSubmit.length][];
    }

    /**
     * This method is for scraping the list of submitted students.
     */
    public void scrapingSubmitStudent() {
        try {

            int i = 0;
            Document doc1 = Jsoup.connect(linkSubmitList).get();

            // get students who submit github account
            Elements links = doc1.select("p");
            for (Element link : links) {
                String theLink = link.text();
                String comment = "\\d{5,6}";
                Pattern p1 = Pattern.compile(comment);   // the pattern to search for
                Matcher m1 = p1.matcher(theLink);
                if (m1.find()) {

                    totalSubmit[i] = theLink.trim();
                    i++;
                }
            }

            for (int j = 0; j < totalSubmit.length; j++) {
                totalSubmit1[j] = totalSubmit[j].trim().split("Matric:|Name:|Link:|Matric :|Name :|Link :|matrix :|name :|link:|Matric No :|Name|Matric no:");
            }
            for (int a = 0; a < totalSubmit1.length; a++) {
                for (int b = 0; b < totalSubmit1[a].length; b++) {
                    if ((b + 1) < totalSubmit1[a].length) {
                        totalSubmit1[a][b] = totalSubmit1[a][b + 1];
                    }
                }
            }

            for (int o = 0; o < totalSubmit1.length; o++) {
                if (totalSubmit1[o][0].length() > 8) {
                    if (totalSubmit1[o][1].length() >= 5 && totalSubmit1[o][1].length() <= 8) {
                        String str = totalSubmit1[o][0];
                        totalSubmit1[o][0] = totalSubmit1[o][1];
                        totalSubmit1[o][1] = str;
                    }
                }
            }

            for (int x = 0; x < totalSubmit1.length; x++) {
                for (int y = 0; y < totalSubmit1[x].length; y++) {
                    totalSubmit1[x][y] = totalSubmit1[x][y].trim();
                }
            }

            totalSubmit2 = new String[totalSubmit1.length][totalSubmit1[0].length - 1];
            for (int x = 0; x < totalSubmit1.length; x++) {
                for (int y = 0; y < (totalSubmit1[x].length - 1); y++) {
                    totalSubmit2[x][y] = totalSubmit1[x][y];
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @return The data of submitted student
     */
    public String[][] getAcc() {
        return totalSubmit2;

    }
}
