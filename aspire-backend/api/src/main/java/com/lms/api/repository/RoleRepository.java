package com.lms.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.lms.api.model.Role;

public interface RoleRepository extends MongoRepository<Role, String> {

	Role findByRole(String role);
}
