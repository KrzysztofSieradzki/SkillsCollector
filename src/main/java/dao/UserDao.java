package dao;

import model.Skill;
import model.Source;
import model.User;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;

import java.util.*;

public class UserDao extends BaseDao {
    public UserDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public User get(Long id){
        return super.produceInTransaction(session -> session.get(User.class, id));
    }

    public void save(User user){
        super.executeInTransaction(session -> session.save(user));
    }
    public void updade(User user){
        super.executeInTransaction(session -> session.update(user));
    }
    public void delete(User user){
        super.executeInTransaction(session -> session.delete(user));
    }

    public Boolean isUsernameAvailable(String username) {
        return super.produceInTransaction(
                session -> session.createQuery("SELECT count(u) FROM User u WHERE u.username = :username", Long.class)
                        .setParameter("username", username)
                        .getSingleResult() <= 0
        );
    }

    public List<User> getAll() {
        return super.produceInTransaction(
                session -> session.createQuery("SELECT u FROM User u", User.class)
                        .getResultList());
    }

    public List<User> getAllByUsername(String username) {
        return super.produceInTransaction(
                session -> session.createQuery("SELECT u FROM User u WHERE u.username = :username", User.class)
                        .setParameter("username", username)
                        .getResultList());
    }

    public List<User> getAllByUsernameAndPassword(String username, String password) {
        return super.produceInTransaction(
                session -> session.createQuery("SELECT u FROM User u WHERE u.username = :username AND u.password = :password", User.class)
                        .setParameter("username", username)
                        .setParameter("password", password)
                        .getResultList());
    }
    public List<Skill> getAllSkills(String username){
        return super.produceInTransaction(session -> session.createQuery("select so from User u " +
                "join u.sources sr JOIN sr.skills so WHERE u.username = :username",Skill.class)
                .setParameter("username", username)
                .getResultList());
    }

    public List<Source> getWithSources(String username){
        return super.produceInTransaction(session -> session.createQuery("SELECT sc from User u " +
                "JOIN u.sources sc WHERE u.username = :username",Source.class)
                .setParameter("username",username)
                .getResultList());
    }

    public void confirmSource(String username, Long id){
        super.executeInTransaction(session -> {
            User user = session.createQuery("SELECT u from User u WHERE u.username=:username",User.class)
                    .setParameter("username",username).getSingleResult();
            Source source = session.get(Source.class,id);
            user.getSources().add(source);
        });
    }



}
