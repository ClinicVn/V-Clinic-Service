package services;

import java.util.List;

import play.db.jpa.JPA;

public class CoreServices {
    public static <T> T create (T model) {
//    	model.emptyToNull();
    	JPA.em().persist(model);
    	// Flush and refresh for check
    	JPA.em().flush();
    	JPA.em().refresh(model);
    	return model;
    }

    public static <T> T find(Class<T> t, Integer id) {
        return JPA.em().find(t, id);
    }

    public static <T> T update(T model) {
        return JPA.em().merge(model);
    }

    public static <T> void delete(Class<T> t, Integer id) {
    	T model = JPA.em().getReference(t, id);
    	JPA.em().remove(model);
    }

    public static <T> List<T> all(Class<T> t) {
        return (List<T>) JPA.em().createQuery("SELECT m FROM " + t.getSimpleName() + " m ORDER BY id").getResultList();
    }

    public static <T> List<T> paginate(Class<T> t, Integer page, Integer size) {
        return (List<T>) JPA.em().createQuery("SELECT m FROM " + t.getSimpleName() + " m ORDER BY id").setFirstResult(page*size).setMaxResults(size).getResultList();
    }

    public static <T> Long count(Class<T> t) {
        return (Long) JPA.em().createQuery("SELECT count(m) FROM " + t.getSimpleName() + " m").getSingleResult();
    }
}