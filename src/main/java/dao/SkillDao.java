package dao;

import model.Skill;
import model.Source;
import org.hibernate.SessionFactory;

import java.util.List;

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
    public List<String> getAllBySource(Long id){
        return super.produceInTransaction(session -> session.createQuery("SELECT sk.name FROM Source sc " +
                "JOIN sc.skills sk WHERE sc.id = :id",String.class))
                .setParameter("id",id)
                .getResultList();
    }
}
