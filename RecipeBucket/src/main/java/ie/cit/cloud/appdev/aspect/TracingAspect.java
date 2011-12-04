package ie.cit.cloud.appdev.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TracingAspect {

    Log log = LogFactory.getLog(TracingAspect.class);

    @Before("execution(* (@org.springframework.stereotype.Repository ie.cit..*).*(..)) && target(repository)")
    public void trace(JoinPoint jp, Object repository) {
	String className = repository.getClass().getName();
	String method = jp.getSignature().getName();
	log.trace("method invoked:" + className + "#" + method);
    }
    
    
}