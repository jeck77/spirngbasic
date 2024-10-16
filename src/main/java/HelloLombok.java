import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.print.attribute.standard.SheetCollate;

@Getter
@Setter
@ToString
public class HelloLombok {
    private String name;
    private int age;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setName("trest");
        
        String name = helloLombok.getName();
        System.out.println("name = " + name);
        System.out.println(helloLombok.toString());
    }
}
