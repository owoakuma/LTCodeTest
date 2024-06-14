public class person implements Comparable<person> {
    String name;
    int age;

    @Override
    public int compareTo(person o) {
        return this.age-o.age;
    }
}
