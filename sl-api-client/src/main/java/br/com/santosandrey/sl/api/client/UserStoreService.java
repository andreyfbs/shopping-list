package br.com.santosandrey.sl.api.client;

/**
 * User Store
 */
public interface UserStoreService {

    Long retrieveUserId(String token);

    boolean isUserLogged(Long id, String token);

    String getUserDetails(Long userId);

}
