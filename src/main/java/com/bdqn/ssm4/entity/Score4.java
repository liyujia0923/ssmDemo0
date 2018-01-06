package com.bdqn.ssm4.entity;

/**
 * Created by 佳 on 2018/1/5.
 */
public class Score4 {
    /**
     FieldTypeComment
     idint(11) NOT NULL成绩id
     student_idint(11) NULL学生id
     course_idint(11) NULL课程id
     scoredouble NULL成绩
     */
    private Integer id;
    private Double score;
    private Student4 student4;
    private Course4 course4;

    @Override
    public String toString() {
        return "Score4{" +
                "id=" + id +
                ", score=" + score +
                ", student4=" + student4 +
                ", course4=" + course4 +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Student4 getStudent4() {
        return student4;
    }

    public void setStudent4(Student4 student4) {
        this.student4 = student4;
    }

    public Course4 getCourse4() {
        return course4;
    }

    public void setCourse4(Course4 course4) {
        this.course4 = course4;
    }
}
