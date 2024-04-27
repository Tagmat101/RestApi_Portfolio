package org.group.portfolio.Respository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.group.portfolio.Entities.Certification;

@Repository

public interface CertRepository extends MongoRepository<Certification, String>{

}
