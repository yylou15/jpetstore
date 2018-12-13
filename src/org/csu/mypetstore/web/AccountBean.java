package org.csu.mypetstore.web;

public class AccountBean {
    private boolean Authenticated = false ;

    public boolean isAuthenticated() {
        return Authenticated;
    }

    public void setAuthenticated(boolean authenticated) {
        Authenticated = authenticated;
    }
}
