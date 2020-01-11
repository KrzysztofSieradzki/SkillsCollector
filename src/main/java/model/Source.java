package model;

import javax.jws.soap.SOAPBinding;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

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
    @JoinTable(name="sources_attached_skills",
            joinColumns = {@JoinColumn(name = "source_id")},
            inverseJoinColumns = {@JoinColumn(name="skill_id")}
    )
    private Set<Skill> skills;

    @ManyToMany(mappedBy = "sources")
    private Set<User> users;

    public Set<Skill> getSkills() { return skills; }

    public void setSkills(Set<Skill> skills) { this.skills = skills; }

    public Long getId() { return id; }


    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Set<User> getUsers() { return users; }

    public void setUsers(Set<User> users) { this.users = users; }

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
