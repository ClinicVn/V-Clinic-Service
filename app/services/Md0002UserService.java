package services;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import models.Md0002User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.inject.*;

import play.api.Play;
import play.db.jpa.JPA;
import play.db.jpa.JPAApi;

public class Md0002UserService {
    final static Logger logger = LoggerFactory.getLogger(Md0002UserService.class);

    private JPAApi jpaApi;

    public Md0002User findByAuthToken(String authToken) {
        this.jpaApi = Play.current().injector().instanceOf(JPAApi.class);
        try {
            return jpaApi.withTransaction(() -> {
                Query q = JPA.em().createQuery("FROM Md0002User WHERE auth_token LIKE ?1")
                        .setParameter(1, authToken);
                try {
                    return (Md0002User) q.getSingleResult();
                } catch(NoResultException ex) {
                    return null;
                }
            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return null;
        }
    }

    /**
     * Create an Md0002User
     *
     * @param Md0002User data
     *
     * @return Md0002User
     */
    public static Md0002User create(Md0002User data) {
        data.setUserPwd(getSha512(data.getUserPwd()));
        return CoreServices.create(data);
    }

    /**
     * Update an Md0002User
     *
     * @param Md0002User data
     *
     * @return Md0002User
     */
    public static Md0002User update(Md0002User data) {
        return CoreServices.update(data);
    }


    /**
     * Find an Md0002User by id
     *
     * @param Integer id
     *
     * @return Md0002User
     */
    public static Md0002User find(Long id) {
        return CoreServices.find(Md0002User.class,id);
    }

    /**
     * Delete an Md0002User by id
     *
     * @param Integer id
     */
    public static Boolean delete(Long id) {
        Md0002User Md0002User = CoreServices.find(Md0002User.class,id);
        if (Md0002User != null) {
            CoreServices.delete(Md0002User.class,id);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Get all Md0002Users
     *
     * @return List<Md0002User>
     */
    public static List<Md0002User> all() {
        return CoreServices.all(Md0002User.class);
    }

    /**
     * Get the page of Md0002Users
     *
     * @param Integer page
     * @param Integer size
     *
     * @return List<Md0002User>
     */
    public static List<Md0002User> paginate(Integer page, Integer size) {
        return CoreServices.paginate(Md0002User.class,page, size);
    }

    /**
     * Get the number of total of Md0002Users
     *
     * @return Long
     */
    public static Long count() {
        return CoreServices.count(Md0002User.class);
    }


    // Another services
    public static String getSha512(String value) {
        if(StringUtils.isEmpty(value)){
            return null;
        }
        try {
            byte byteData[] = MessageDigest.getInstance("SHA-512").digest(value.getBytes("UTF-8"));
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < byteData.length; i++) {
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }
            return sb.toString();
        }
        catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}