package com.ouyachou.app.ws.repositories;

import com.ouyachou.app.ws.Entites.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

}
