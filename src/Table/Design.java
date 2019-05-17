package Table;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "DESIGN", schema = "Graduation")
public class Design {
    private String student;
    private String topic;
    private String college;

    @Id
    @Column(name = "STUDENT")
    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    @Basic
    @Column(name = "TOPIC")
    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    @Basic
    @Column(name = "COLLEGE")
    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Design design = (Design) o;
        return Objects.equals(student, design.student) &&
                Objects.equals(topic, design.topic) &&
                Objects.equals(college, design.college);
    }

    @Override
    public int hashCode() {
        return Objects.hash(student, topic, college);
    }
}
