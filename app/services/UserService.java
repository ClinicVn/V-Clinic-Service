package services;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.persistence.NoResultException;

import models.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import play.db.jpa.JPA;

public class UserService {
    final static Logger logger = LoggerFactory.getLogger(UserService.class);
    /**
     * Create an User
     *
     * @param User data
     *
     * @return User
     */
    public static User create(User data) {
        return CoreServices.create(data);
    }

    /**
     * Update an User
     *
     * @param User data
     *
     * @return User
     */
    public static User update(User data) {
        return CoreServices.update(data);
    }

    /**
     * Find an User by id
     *
     * @param Integer id
     *
     * @return User
     */
    public static User find(Integer id) {
        return CoreServices.find(User.class,id);
    }

    /**
     * Delete an User by id
     *
     * @param Integer id
     */
    public static Boolean delete(Integer id) {
        User User = CoreServices.find(User.class,id);
        if (User != null) {
            CoreServices.delete(User.class,id);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Get all Users
     *
     * @return List<User>
     */
    public static List<User> all() {
        return CoreServices.all(User.class);
    }

    /**
     * Get the page of Users
     *
     * @param Integer page
     * @param Integer size
     *
     * @return List<User>
     */
    public static List<User> paginate(Integer page, Integer size) {
        return CoreServices.paginate(User.class,page, size);
    }

    /**
     * Get the number of total of Users
     *
     * @return Long
     */
    public static Long count() {
        return CoreServices.count(User.class);
    }


    // Another services

    public static User findByAuthToken(String authToken) {
        if (authToken == null) {
            return null;
        }

        User user = new User();
        try  {
            //            return find.where().eq("authToken", authToken).findUnique();
            user = (User) JPA.em().createQuery("SELECT m FROM User m WHERE m.authToken LIKE :authToken")
                    .setParameter("authToken", authToken)
                    .getSingleResult();
        }
        catch (NoResultException e) {
            return null;
        }
        return user;
    }

    public static String getSha512(String value) {
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

    public static User findByAccountAndPassword(String account, String password) {
        User user = new User();
        try{
            user = (User) JPA.em().createQuery("SELECT m FROM User m WHERE m.code LIKE :ac AND m.password LIKE :pw")
                    .setParameter("ac", account)
                    .setParameter("pw", getSha512(password))
                    .getSingleResult();
        }catch (NoResultException nre){
            logger.error("NoResultException");
            return null;
        }
        return user;
    }

    public static User updateAuthToken(String value) {
        if(StringUtils.isEmpty(value)){
            return null;
        }
        User user = findByAuthToken(value);
        if(user != null){
            user.setAuthToken(value);
            user = update(user);
        }
        return user;
    }
}