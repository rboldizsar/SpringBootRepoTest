package hello;

import java.util.Iterator;
import java.util.Set;

import hello.db.PingEvent;
import hello.db.PingEventRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

	@Autowired
	PingEventRepository repository; 
	
    @RequestMapping("/")
    public String index() {
    	System.out.println("test from spring boot");
        
        System.out.println(repository);
        
        repository.save(new PingEvent("desc1"));
        repository.save(new PingEvent("desc2"));
        repository.save(new PingEvent("desc3"));
        repository.save(new PingEvent("desc4"));
        repository.save(new PingEvent("desc5"));
        
        Iterator<PingEvent> it = repository.findAll().iterator();
        
        String events = "";
        
        while(it.hasNext()){
        	PingEvent pe = it.next();
        	events += "\nevent " + pe.getEventId() + " - " + pe.getDescription();
        }
        
        return "Greetings from Spring Boot! " + events;
    }
    
}
