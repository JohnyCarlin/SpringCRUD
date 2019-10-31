package beans.entity;

import javax.persistence.*;

@Entity
@Table(name = "ROLE")
public class Role {

    @Id
    @Column(name = "ROLE")
    private String role;

    @ManyToMany
    @JoinColumn(name = "NAME")
    private User user;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
