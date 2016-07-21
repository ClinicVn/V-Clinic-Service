package services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;

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

    // Find by id
    public static <T> T find(Class<T> t, Long id) {
        return JPA.em().find(t, id);
    }

    // Find by multi field
    @SuppressWarnings("unchecked")
    public static <T> List<T>  findByFields(Class<T> t, HashMap<String, Object> params) {
        int count = 1, total = params.size();
        if(total == 0) {
            return null;
        }

        String sql = "SELECT m FROM " + t.getSimpleName() + " m WHERE" ;


        for (Map.Entry<String, Object> entry : params.entrySet()) {
            if(count < total){
                sql += " m." + entry.getKey() + " LIKE ?" +count+ " AND";
            }else{
                sql += " m." + entry.getKey() + " LIKE ?"+ count;
            }
            count++;
        }

        Query query = JPA.em().createQuery(sql);

        count = 1;
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            query.setParameter(count++, entry.getValue());
        }

        return  query.getResultList();
    }


    public static <T> T update(T model) {
        return JPA.em().merge(model);
    }

    public static <T> void delete(Class<T> t, Long id) {
        T model = JPA.em().getReference(t, id);
        JPA.em().remove(model);
    }

    @SuppressWarnings("unchecked")
    public static <T> List<T> all(Class<T> t) {
        return JPA.em().createQuery("SELECT m FROM " + t.getSimpleName() + " m ORDER BY id").getResultList();
    }

    @SuppressWarnings("unchecked")
    public static <T> List<T> paginate(Class<T> t, Integer page, Integer size) {
        return JPA.em().createQuery("SELECT m FROM " + t.getSimpleName() + " m ORDER BY id").setFirstResult(page*size).setMaxResults(size).getResultList();
    }

    public static <T> Long count(Class<T> t) {
        return (Long) JPA.em().createQuery("SELECT count(m) FROM " + t.getSimpleName() + " m").getSingleResult();
    }
}