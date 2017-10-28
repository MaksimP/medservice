package org.medservice.repository;


import org.medservice.models.Role;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository("roleRepository")
public interface RoleRepository extends MongoRepository<Role, Long> {
}
