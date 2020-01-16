package dao;

import model.Skill;
import model.Source;
import model.User;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Set;

public class SkillDao extends BaseDao {
    public SkillDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public Skill get(Long id){
        return super.produceInTransaction(session -> session.get(Skill.class,id));
    }
    public void save(Skill skill){
        super.executeInTransaction(session -> session.save(skill));
    }
    public void delete(Skill skill){
        super.executeInTransaction(session -> session.delete(skill));
    }
    public void update(Skill skill){
        super.executeInTransaction(session -> session.update(skill));
    }

    public List<Skill> getAll(){
        return super.produceInTransaction(session -> session.createQuery("select sk from Skill sk",Skill.class)
                .getResultList());
    }

    public Integer numberOfUsersPerSkill(String name){
        return super.produceInTransaction(session -> session.createQuery("select u.sources.size From Skill sk " +
                "join sk.sources sc join sc.users u where sk.name =:name",Integer.class)
                .setParameter("name",name).getSingleResult());
    }

    public Integer numb (String name){
        return super.produceInTransaction(session -> {
            Skill skill = session.createQuery("SELECT sk from Skill sk Where sk.name = :name",Skill.class)
                    .setParameter("name",name).getSingleResult();
            Set<Source> sources = skill.getSources();
            Integer output = 0;
            for(Source s : sources){
                Set<User> user = s.getUsers();
                output+= user.size();
            }
            return output;
        });
    }

}
