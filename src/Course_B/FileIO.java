package Course_B;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class FileIO {
    static List<student> fileInput(String address) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(address));
        List<student> students=new LinkedList<>();
        String line;
        while ((line = br.readLine()) != null) {
            student stu=new student();
            String[] s = line.split(" ");
            stu.stu_ID=Long.parseLong(s[0]);
            stu.name=s[1];
            stu.age=Integer.parseInt(s[2]);
            stu.gender=s[3];
            String[] split = s[4].split("/");
            stu.year=Integer.parseInt(split[0]);
            stu.month=Short.parseShort(split[1]);
            stu.day=Short.parseShort(split[2]);
            stu.address=s[5];
            stu.phoneNumber=s[6];
            students.add(stu);
        }
        return students;
    }

    static void fileOutput(String address, List<student> students) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(address));
        for (student s : students) {
            bw.write(s.stu_ID + " " + s.name + " " + s.age + " " + s.gender + " " + s.year + "/" + s.month + "/" + s.day + " " + s.address + " " + s.phoneNumber);
            bw.newLine();
            bw.flush();
        }
    }
}
