package pay2park.model.entityFromDB;

import javax.persistence.*;

@Entity
@Table(name = "end_users")
public class EndUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "end_user_id", nullable = false)
    private Integer id;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(name = "gender", nullable = false)
    private Integer gender;

    @Column(name = "phone", nullable = false, length = 10)
    private String phone;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "zalopay_id", length = 100)
    private String zalopayId;

    public String getZalopayId() {
        return zalopayId;
    }

    public void setZalopayId(String zalopayId) {
        this.zalopayId = zalopayId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EndUser() {}

    public EndUser(String zalopayID, String firstName, String lastName) {
        this.zalopayId = zalopayID;
        this.email = "NaN";
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = "NaN";
        this.gender = 1;
    }
}