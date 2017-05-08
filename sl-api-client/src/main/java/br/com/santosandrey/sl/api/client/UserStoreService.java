package br.com.santosandrey.sl.api.client;

public interface UserStoreService {

    Long retrieveUserId(String token);

    boolean isUserLogged(Long id, String token);

    String getUserDetails(Long userId);

}
