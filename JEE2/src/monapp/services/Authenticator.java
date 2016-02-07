package monapp.services;

import javax.ejb.Remote;

@Remote
public interface Authenticator {
   boolean login(String mail, String pwd);

   void logout();
}