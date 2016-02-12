package monapp.services;

import javax.ejb.Remote;

@Remote
public interface IAuthenticator {
   boolean login(String mail, String pwd);

   void logout();
}