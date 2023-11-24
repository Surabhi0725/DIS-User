package sgsits.cse.dis.user.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sgsits.cse.dis.user.model.UserAddress;

import java.util.List;

@Repository()
public interface UserAddressRepository extends CrudRepository<UserAddress, Long> {

  List<UserAddress> findByUserId(String id);
}
