package sgsits.cse.dis.user.message.response;

import java.util.Date;

public class SideNavigationData {
  private String username;
  private Date lastLoggedIn;
  private String name;
  private String currentDesignation;

  public SideNavigationData() {
    super();
  }

  public SideNavigationData(String username, Date lastLoggedIn, String name,
          String currentDesignation) {
    super();
    this.username = username;
    this.lastLoggedIn = lastLoggedIn;
    this.name = name;
    this.currentDesignation = currentDesignation;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public Date getLastLoggedIn() {
    return lastLoggedIn;
  }

  public void setLastLoggedIn(Date lastLoggedIn) {
    this.lastLoggedIn = lastLoggedIn;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCurrentDesignation() {
    return currentDesignation;
  }

  public void setCurrentDesignation(String currentDesignation) {
    this.currentDesignation = currentDesignation;
  }
}