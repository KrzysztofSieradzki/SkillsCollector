package dao;

import model.Source;
import org.hibernate.SessionFactory;

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

}
