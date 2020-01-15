package dao;

import model.Skill;
import model.Source;
import model.User;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Set;

public class SourceDao extends BaseDao {
    public SourceDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public Source get(Long id){
        return super.produceInTransaction(session -> session.get(Source.class,id));
    }
    public void save(Source source){
        super.executeInTransaction(session -> session.save(source));
    }
    public void delete(Source source){
        super.executeInTransaction(session -> session.delete(source));
    }
    public void update(Source source){
        super.executeInTransaction(session -> session.update(source));
    }

    public List<Source> getAll(){
        return super.produceInTransaction(session -> session.createQuery("select sc from Source sc",Source.class)
                .getResultList());
    }
    public String showMeMySkills(String name){

        return super.produceInTransaction(session -> {
            Source source = session.createQuery("Select sc from Source sc Where sc.name =:name",Source.class)
                    .setParameter("name",name).getSingleResult();
            Set<Skill> skills = source.getSkills();
            String output="";
            for(Skill s : skills) {
                Skill skill = session.get(Skill.class, s.getId());
                output = output+ skill.getName() + ". <br>";
            }

            return output;
        } );
    }


}
