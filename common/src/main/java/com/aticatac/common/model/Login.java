package com.aticatac.common.model;

import com.aticatac.common.model.Updates.Response;

/**
 * The type Login.
 */
public class Login extends Model {
  private Response authenticated;
  private int mapID;
  private String multicast;

  /**
   * Instantiates a new Model.
   *
   * @param id the id
   */
  public Login(String id) {
    super(id);
  }

  /**
   * Gets multicast.
   *
   * @return the multicast
   */
  public String getMulticast() {
    return multicast;
  }

  /**
   * Sets multicast.
   *
   * @param multicast the multicast
   */
  public void setMulticast(String multicast) {
    this.multicast = multicast;
  }

  /**
   * Gets map id.
   *
   * @return the map id
   */
  public int getMapID() {
    return mapID;
  }

  /**
   * Sets map id.
   *
   * @param mapID the map id
   */
  public void setMapID(int mapID) {
    this.mapID = mapID;
  }

  /**
   * Is authenticated boolean.
   *
   * @return the boolean
   */
  public Response isAuthenticated() {
    return authenticated;
  }

  /**
   * Sets authenticated.
   *
   * @param authenticated the authenticated
   */
  public void setAuthenticated(Response authenticated) {
    this.authenticated = authenticated;
  }
}
