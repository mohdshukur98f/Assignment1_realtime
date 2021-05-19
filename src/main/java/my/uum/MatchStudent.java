package my.uum;

import java.util.ArrayList;
/**
 * This class for matching submitted Students with the list of Students.
 *
 * @author Mohd Shukur Bin Zainol Abidin
 */

public class MatchStudent {

    private final String[][] submitStudent;
    private final String[][] studentList;
    private String[][] studentCompare;
    int i = 0;

    /**
     * This class for matching submitted Students with the list of Students.
     *
     * @param submitStudent This is the list of Submitted Student.
     * @param studentList This is the list of Student.
     */
    MatchStudent(String[][] submitStudent, String[][] studentList) {
        this.submitStudent = submitStudent;
        this.studentList = studentList;
    }

    /**
     * This method is for compare between Submitted Student with the list of Student.
     */
    public void check2() {

        ArrayList<String> compare = new ArrayList<>();
        ArrayList<String> compare1 = new ArrayList<>();

        for (int x = 0; x < submitStudent.length; x++) {
            compare.add(submitStudent[x][0]);
        }
        for (int x = 0; x < studentList.length; x++) {
            compare.remove(studentList[x][1]);
        }
        String[][] studentComment = new String[compare.size()][];
        for (int x = 0; x < submitStudent.length; x++) {
            if (compare.contains(submitStudent[x][0])) {
                studentComment[i] = submitStudent[x];
                i++;
            }
        }

        for (int x = 0; x < studentComment.length; x++) {
            compare1.add(studentComment[x][1]);
        }
        for (int x = 0; x < studentList.length; x++) {
            compare1.remove(studentList[x][2]);
        }

        studentCompare = new String[(submitStudent.length - compare1.size())][];
        int k = 0;
        for (int x = 0; x < submitStudent.length; x++) {
            if (!compare1.contains(submitStudent[x][1])) {
                studentCompare[k] = submitStudent[x];
                k++;
            }
        }
    }

    /**
     *
     * @return The matching data between Submitted Students and The list of Students
     */
    public String[][] getCompare() {
        return studentCompare;
    }
}
