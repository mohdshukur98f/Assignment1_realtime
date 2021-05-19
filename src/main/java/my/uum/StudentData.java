package my.uum;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * This class for scrapping data The list of Students
 *
 * @author Mohd Shukur Bin Zainol Abidin
 */

public class StudentData {
    private final String linkStudentList;
    private final String[] totalStudent;
    private final String[][] studentList;

    /**
     * This class for scrapping The list of Students
     *
     * @param linkStudentList This is the link for scraping data (Wiki GitHub)
     * @param total This is the total of student.
     */
    public StudentData(String linkStudentList, int total) {
        this.linkStudentList = linkStudentList;
        totalStudent = new String[total];
        studentList = new String[totalStudent.length][];
    }

    /**
     * This method is for scrapping the list of students.
     */
    public void scrapingStudentList() {
        try {
            int i = 0;
            Document document = Jsoup.connect(linkStudentList).get();

            // get list of student
            Elements links = document.select("tr");
            for (Element link : links) {
                String theLink = link.text();
                String list = "\\d{6}";
                Pattern p1 = Pattern.compile(list);   // the pattern to search for
                Matcher m1 = p1.matcher(theLink);
                if (m1.find()) {

                    totalStudent[i] = theLink;
                    i++;
//
                }
            }

            for (int j = 0; j < totalStudent.length; j++) {
                studentList[j] = totalStudent[j].split(" ", 3);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @return The list of students
     */
    public String[][] getList() {
        return studentList;
    }
}
