package sgsits.cse.dis.user.service;

import sgsits.cse.dis.user.message.response.SideNavigationData;

public interface SideNavigationService {
  SideNavigationData getSideNavigationDetails(String username);
}
