package Course_B;

import java.util.Comparator;
import java.util.List;

public class Sort{
    private List<student> students;
    public Sort(List<student> students){this.students=students;}
    public void sortByID(){
        students.sort((o1, o2) -> {
            if (o2.stu_ID < o1.stu_ID)
                return 1;
            else
                return -1;
        });
        for(student s:students){
            System.out.println(s);
        }
    }
    public void sortByName(){
        students.sort(Comparator.comparing(o -> o.name));
        for(student s:students){
            System.out.println(s);
        }
    }
}
