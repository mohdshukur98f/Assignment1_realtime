package my.uum;

import java.util.ArrayList;
/**
 * This class for getting Not Submitted Data.
 *
 * @author Mohd Shukur Bin Zainol Abidin
 */

public class NotSubmit {
    private final String[][] submitStudent;
    private final String[][] studentList;
    private String[][] notSubmit;
    private int i = 0;
    private int j = 0;

    /**
     * This class for getting Not Submitted Data.
     *
     * @param submitStudent This is the list of Submitted Student.
     * @param studentList This is the list of Student.
     */
    NotSubmit(String[][] submitStudent, String[][] studentList) {
        this.submitStudent = submitStudent;
        this.studentList = studentList;
    }

    /**
     *
     * @return This method is for return the list of not submitted student data.
     */
    public String[][] compare() {
        ArrayList<String> comp = new ArrayList<>();
        ArrayList<String> comp1 = new ArrayList<>();

        for (int x = 0; x < studentList.length; x++) {
            comp.add(studentList[x][1]);
        }
        for (int x = 0; x < submitStudent.length; x++) {
            comp.remove(submitStudent[x][0]);
        }
        String[][] notSubmit = new String[comp.size()][];
        for (int x = 0; x < studentList.length; x++) {
            if (comp.contains(studentList[x][1])) {
                notSubmit[i] = studentList[x];
                i++;
            }
        }

        for (int x = 0; x < notSubmit.length; x++) {
            comp1.add(notSubmit[x][2]);
        }
        for (int x = 0; x < submitStudent.length; x++) {
            comp1.remove(submitStudent[x][1]);
        }
        this.notSubmit = new String[comp1.size()][];
        for (int x = 0; x < notSubmit.length; x++) {
            if (comp1.contains(notSubmit[x][2])) {
                this.notSubmit[j] = notSubmit[x];
                j++;
            }

        }

        return this.notSubmit;
    }

    /**
     *
     * @return This method is for return the list of not submitted student data.
     */
    public String[][] getNotSubmitData() {
        return notSubmit;
    }
}
