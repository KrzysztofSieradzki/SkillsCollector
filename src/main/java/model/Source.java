package model;

import javax.jws.soap.SOAPBinding;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="sources")
public class Source {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String description;
    @Column(nullable = false, unique = true)
    private String name;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="skills_id",
            joinColumns = {@JoinColumn(name = "source_id")},
            inverseJoinColumns = {@JoinColumn(name="skill_id")}
    )
    private List<Skill> skills = new ArrayList<>();

    @ManyToMany(mappedBy = "sources")
    private List<User> users = new ArrayList<>();

    public List<Skill> getSkills() { return skills; }

    public void setSkills(List<Skill> skills) { this.skills = skills; }

    public Long getId() { return id; }


    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public List<User> getUsers() { return users; }

    public void setUsers(List<User> users) { this.users = users; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Source source = (Source) o;
        return id.equals(source.id) &&
                description.equals(source.description) &&
                name.equals(source.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, name);
    }

    @Override
    public String toString() {
        return "Source{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
