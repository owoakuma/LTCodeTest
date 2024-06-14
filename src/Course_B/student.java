package Course_B;
public class student {
    long stu_ID=0;
    String name="0";
    int age=0;
    String gender="0";
    int year=0;
    short month=0;
    short day=0;
    String address="0";
    String phoneNumber="0";
    student(){
  stu_ID=0;
name="0";
age=0;
gender="0";
year=0;
 month=0;
day=0;
address="0";
 phoneNumber="0";
    };

    @Override
    public String toString() {
        return "student{" +
                "stu_ID=" + stu_ID +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", birthday=" + year +
                "," + month +
                "," + day +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
