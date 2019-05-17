package Table;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "USER", schema = "Graduation")
public class User {
    private String account;
    private String password;
    private String student;

    @Id
    @Column(name = "ACCOUNT")
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Basic
    @Column(name = "PASSWORD")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "STUDENT")
    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(account, user.account) &&
                Objects.equals(password, user.password) &&
                Objects.equals(student, user.student);
    }

    @Override
    public int hashCode() {
        return Objects.hash(account, password, student);
    }
}
