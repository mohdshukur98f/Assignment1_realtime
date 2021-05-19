package my.uum;

/**
 * This class is for Scrapping data to find Submitted GitHub Account(Issue 1) and NOT Submitting GitHub Account.
 *
 * @author Mohd Shukur Bin Zainol Abidin
 */

public class App {

    /**
     * This class is for Scrapping data to find Submitted GitHub Account(Issue 1) and NOT Submitting GitHub Account.
     *
     * @param args This is main class
     */
    public static void main(String[] args) {

        CheckData check = new CheckData();
        check.run();
    }

    /**
     * This class is for extend class CheckData.
     */
    public static class CheckData {
        final String linkStudentList = "https://github.com/STIW3054-A202/Main-Data/wiki/List_of_Student";
        final String linkSubmitList = "https://github.com/STIW3054-A202/Main-Data/issues/1";

        TotalStudent totalStudent;
        TotalSubmit totalSubmit;
        StudentData studentData;
        SubmitData submitData;
        NotSubmit notSubmit;
        Display printData;
        MatchStudent submitStudent;
        Database insertData;

        /**
         * This method is for run CheckData.
         */
        public void run() {

            totalStudent = new TotalStudent(linkStudentList);
            totalSubmit = new TotalSubmit(linkSubmitList);
            //Find number of list
            studentData = new StudentData(linkStudentList, totalStudent.scrapingTotalStudent());
            submitData = new SubmitData(linkSubmitList, totalSubmit.scrapingTotalSubmitStudent());
            //Load Data
            submitData.scrapingSubmitStudent();
            studentData.scrapingStudentList();
            //Compare Data
            submitStudent = new MatchStudent(submitData.getAcc(), studentData.getList());
            submitStudent.check2();

            notSubmit = new NotSubmit(submitStudent.getCompare(), studentData.getList());
            printData = new Display(submitStudent.getCompare(), notSubmit.compare());
            printData.start();

            insertData = new Database(submitStudent.getCompare(), notSubmit.getNotSubmitData());
            insertData.insert();
        }
    }
}


