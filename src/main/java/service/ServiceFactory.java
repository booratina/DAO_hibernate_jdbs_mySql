package service;

/**
 * Created by User on 12.03.2017.
 */
public abstract class ServiceFactory {

    public static UserService getService() throws Exception {

        return UserService.createService();
    }
}
