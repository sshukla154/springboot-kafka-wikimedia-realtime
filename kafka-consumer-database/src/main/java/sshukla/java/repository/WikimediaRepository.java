package sshukla.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sshukla.java.entity.WikimediaData;

/**
 * @author 'Seemant Shukla' on '08/10/2022'
 */

@Repository
public interface WikimediaRepository extends JpaRepository<WikimediaData, Long> {
}
