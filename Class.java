import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Class {
  private final static int nStudents = 12;
  private final static int gGroups = 6;
  private final static String studentNamesPath = "C:\\Users\\AsianAndyRoo\\CSE 193 Student_Group Project\\studentNames.txt";

  private static int longestName = 0;
  private static boolean pairGroups = false;
  private static String pairGroupsStr = "pair groups";
  private static ArrayList<Student> students = new ArrayList<Student>();

    public static void main(String[] args) {
      readNames(nStudents);
      Collections.shuffle(students);
      assignGroups(nStudents, gGroups);
      sortStudentsAlphabetically();

      char blankSpace = ' ';
      // Prints the students and group numbers out
      for(int i = 0; i < nStudents; i++) {
        int blanks = longestName - students.get(i).getName().length();
        System.out.print("Name: " + students.get(i).getName());
        for(int j = 0; j < blanks; j++) {
          System.out.print(blankSpace);
        }

        System.out.println("   Group: " + students.get(i).getGroupNum());
      }

      if(pairGroups) {
        printPairs();
      }
    }

    /*
     * Will automatically look for the specified filepath. If no file path
     * exists, then it will simply take names from input stream.
     */
    public static void readNames(int names) {
      File file = new File(studentNamesPath);
      Scanner scanner = new Scanner(System.in);
      String currName = "";

      try {
        scanner = new Scanner(file);
      }
      catch (FileNotFoundException e) {
        System.out.println("Sorry, couldn't find the list of students");
      }

      int i = 0;
      while(i < nStudents) {
        currName = scanner.nextLine();
        students.add(new Student(currName, 0));
        if(students.get(i).getName().toLowerCase().compareTo(pairGroupsStr) == 0) {
          students.remove(students.size() - 1);
          pairGroups = true;
          continue;
        }

        if(currName.length() > longestName) {
          longestName = currName.length();
        }
        i++;
      }

      scanner.close();
    }

    public static void assignGroups(int nStudents, int gGroups) {
      int currGroup = 1;
      for(int i = 0; i < nStudents; i++) {
        students.get(i).setGroupNum(currGroup);
        if(currGroup == gGroups) {
          currGroup = 0;
        }
        currGroup++;
      }
    }

    /*
     * This method swaps the students into alphabetical order (Bubble Sort)
     */
    public static void sortStudentsAlphabetically() {
      for(int i = 0; i < nStudents; i++) {
        for(int j = i + 1; j < nStudents; j++) {
          if(students.get(i).getName().compareTo(students.get(j).getName())>0) {
            Student temp = new Student(students.get(i).getName(), students.get(i).getGroupNum());
            students.get(i).setName(students.get(j).getName());
            students.get(i).setGroupNum(students.get(j).getGroupNum());
            students.get(j).setName(temp.getName());
            students.get(j).setGroupNum(temp.getGroupNum());
          }
        }
      }
    }

    public static void printPairs() {
      System.out.println("\nGroup Pairs:");
      ArrayList<Integer> groups = new ArrayList<Integer>();
      for(int i = 0; i < gGroups; i++) {
        groups.add(i + 1);
      }

      Collections.shuffle(groups);
      int currGroup = 0;
      for(int i = 0; i < (gGroups / 2); i++) {
        currGroup = groups.remove(0);
        System.out.print("Group " + currGroup);
        currGroup = groups.remove(0);
        System.out.println(" with Group " + currGroup);
      }
    }
}
