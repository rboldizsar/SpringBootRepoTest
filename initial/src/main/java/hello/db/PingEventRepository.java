package hello.db;

import org.springframework.data.repository.Repository;

public interface PingEventRepository extends Repository<PingEvent, Long> {
	PingEvent save(PingEvent entity);
    
	PingEvent findOne(Long primaryKey);
    
	Iterable<PingEvent> findAll();

	Long count();

	void delete(PingEvent entity);
	
	boolean exists(Long primaryKey);
}
