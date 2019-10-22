import java.util.*;
public class Student {
  String name;
  int groupNum;

  public Student(String name, int groupNum) {
    this.name = name;
    this.groupNum = groupNum;
  }

  public String getName() {
    return this.name;
  }

  public int getGroupNum() {
    return this.groupNum;
  }

  public void setName(String Vname) {
    this.name = Vname;
  }

  public void setGroupNum(int VgroupNum) {
    this.groupNum = VgroupNum;
  }
}
