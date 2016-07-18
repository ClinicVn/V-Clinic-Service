package services;

import java.util.List;

import models.Md0003Menu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Md0003MenuService {
    final static Logger logger = LoggerFactory.getLogger(Md0003MenuService.class);

    /**
     * Create an Md0003Menu
     *
     * @param Md0003Menu data
     *
     * @return Md0003Menu
     */
    public static Md0003Menu create(Md0003Menu data) {
        return CoreServices.create(data);
    }

    /**
     * Update an Md0003Menu
     *
     * @param Md0003Menu data
     *
     * @return Md0003Menu
     */
    public static Md0003Menu update(Md0003Menu data) {
        return CoreServices.update(data);
    }

    /**
     * Find an Md0003Menu by id
     *
     * @param Integer id
     *
     * @return Md0003Menu
     */
    public static Md0003Menu find(Long id) {
        return CoreServices.find(Md0003Menu.class,id);
    }

    /**
     * Delete an Md0003Menu by id
     *
     * @param Integer id
     */
    public static Boolean delete(Long id) {
        Md0003Menu Md0003Menu = CoreServices.find(Md0003Menu.class,id);
        if (Md0003Menu != null) {
            CoreServices.delete(Md0003Menu.class,id);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Get all Md0003Menus
     *
     * @return List<Md0003Menu>
     */
    public static List<Md0003Menu> all() {
        return CoreServices.all(Md0003Menu.class);
    }

    /**
     * Get the page of Md0003Menus
     *
     * @param Integer page
     * @param Integer size
     *
     * @return List<Md0003Menu>
     */
    public static List<Md0003Menu> paginate(Integer page, Integer size) {
        return CoreServices.paginate(Md0003Menu.class,page, size);
    }

    /**
     * Get the number of total of Md0003Menus
     *
     * @return Long
     */
    public static Long count() {
        return CoreServices.count(Md0003Menu.class);
    }

}