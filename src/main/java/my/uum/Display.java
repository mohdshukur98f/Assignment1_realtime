package my.uum;
/**
 * This class is for Printing the table of Report data.
 *
 * @author Mohd Shukur Bin Zainol Abidin
 */
public class Display extends Thread {

    final String[][] submitStudent;
    final String[][] notSubmit;

    /**
     *
     * This class is for Printing the table of Report data.
     * @param submitStudent This is the list of Submitted Student.
     * @param notSubmit This is the list of Not Submitted Student.
     */
    Display(String[][] submitStudent, String[][] notSubmit) {
        this.submitStudent = submitStudent;
        this.notSubmit = notSubmit;
    }

    @Override
    /**
     * This method is for Printing the table of Report data.
     */
    public void run() {
        System.out.println();
        System.out.println("List of students who have submitted the GitHub account:");
        System.out.println("|----|--------|-------------------------------------|----------------------------------------|");
        System.out.println("|No. | Matric | Name                                | GitHub Link                            |");
        System.out.println("|----|--------|-------------------------------------|----------------------------------------|");
        for (int x = 0; x < submitStudent.length; x++) {
            System.out.printf("|%-4s| %-7s|%-37s|%-40s|\n", x+1,submitStudent[x][0], submitStudent[x][1], submitStudent[x][2]);
        }
        System.out.println("|----|--------|-------------------------------------|-----------------------------------------|");
        System.out.println(" ");

        System.out.println("List of students who have not submitted the GitHub account:");
        System.out.println("|----|-------|-------------------------------------|");
        System.out.println("|No. |Matric | Name                                |");
        System.out.println("|----|-------|-------------------------------------|");
        for (int y = 0; y < notSubmit.length; y++) {
            System.out.printf("|%-4s|%-7s|%-37s|\n", y + 1, notSubmit[y][1], notSubmit[y][2]);
        }
        System.out.println("|----|-------|-------------------------------------|");
        System.out.println(" ");


    }
}