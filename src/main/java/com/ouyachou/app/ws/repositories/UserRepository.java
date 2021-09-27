package com.ouyachou.app.ws.repositories;

import com.ouyachou.app.ws.Entites.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

}
