package com.bdqn.ssm4.entity;

/**
 * Created by 佳 on 2017/12/14.
 */
public class Student4 {
    /**
     FieldTypeComment
     idint(11) NOT NULL
     grade_idint(11) NULL班级id
     student_namevarchar(10) NULL学生姓名
     gendervarchar(2) NULL性别
     ageint(11) NULL年龄
     student_numvarchar(20) NULL学号
     */
    private Integer id;
    private String studentName;
    private String gender;
    private Integer age;
    private String studentNum;
    private Grade4 grade4;

    @Override
    public String toString() {
        return "Student4{" +
                "id=" + id +
                ", studentName='" + studentName + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", studentNum='" + studentNum + '\'' +
                ", grade4=" + grade4 +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(String studentNum) {
        this.studentNum = studentNum;
    }

    public Grade4 getGrade4() {
        return grade4;
    }

    public void setGrade4(Grade4 grade4) {
        this.grade4 = grade4;
    }
}
