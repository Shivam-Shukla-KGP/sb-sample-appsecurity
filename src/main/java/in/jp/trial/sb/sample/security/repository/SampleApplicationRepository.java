package in.jp.trial.sb.sample.security.repository;

import in.jp.trial.sb.sample.security.entity.SampleApplicationEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SampleApplicationRepository extends CrudRepository<SampleApplicationEntity, Integer> {
}
