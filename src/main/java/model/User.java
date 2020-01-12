package model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="users")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column
    private String first_name;
    @Column
    private String last_name;
    @Column(nullable = false, unique = true)
    private String password;
    @Column(nullable = false, unique = true)
    private String username;

    public User(String first_name, String last_name, String password, String username) {
        this.first_name = first_name;
        this.last_name =last_name;
        this.password =password;
        this.username = username;
    }

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="users_known_sources",
    joinColumns = {@JoinColumn(name="user_id")},
    inverseJoinColumns = {@JoinColumn(name="source_id")}
    )
    private Set<Source> sources;

    public Set<Source> getSources() { return sources; }

    public void setSources(Set<Source> sources) { this.sources = sources; }

    public Long getId() { return id; }

    public String getFirst_name() { return first_name; }

    public void setFirst_name(String first_name) { this.first_name = first_name; }

    public String getLast_name() { return last_name; }

    public void setLast_name(String last_name) { this.last_name = last_name; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id) &&
                first_name.equals(user.first_name) &&
                last_name.equals(user.last_name) &&
                password.equals(user.password) &&
                username.equals(user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, first_name, last_name, password, username);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
