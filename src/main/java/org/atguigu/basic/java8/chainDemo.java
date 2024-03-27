package org.atguigu.basic.java8;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

public class chainDemo {
    public static void main(String[] args) {

        Student student = new Student();
        student.setId(1);
        student.setStudenName("l");
        student.setMajor("cs");

        student.setId(2).setStudenName("w").setMajor("ts");
    }
}




@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)  // chain
class Student{
    private Integer id;
    private String studenName;
    private String major;


}
