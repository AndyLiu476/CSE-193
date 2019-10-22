import java.util.*;

public class main {
private final static int n = 10;
private final static int g = 2;
public static ArrayList<Student> students = new ArrayList<Student>();

    public static void main(String[] args) {
      readNames(n);
      Collections.shuffle(students);
      assignGroups(n, g);
      sortStudentsAlphabetically();
      for(int i = 0; i < n; i++) {
        System.out.println("Name: " + students.get(i).getName() + "   Group Number: " + students.get(i).getGroupNum());
      }
    }

    public static void readNames(int names) {
      Scanner scanner = new Scanner(System.in);
      int i = 0;
      int count = 0;
      while(i < n) {
        students.add(new Student(scanner.nextLine(), 0));
        count++;
        i++;
      }

      scanner.close();
      return;
    }

    public static void assignGroups(int n, int g) {
      int currGroup = 1;
      for(int i = 0; i < n; i++) {
        students.get(i).setGroupNum(currGroup);
        if(currGroup == (n / g)) {
          currGroup = 1;
        }
        currGroup++;
      }
    }

    public static void sortStudentsAlphabetically() {
      for(int i = 0; i < n; i++) {
        for(int j = i + 1; j < n; j++) {
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
}
