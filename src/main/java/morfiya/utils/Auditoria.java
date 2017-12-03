package morfiya.utils;

import java.time.LocalDate;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.format.datetime.joda.LocalDateParser;

import morfiya.rest.DataFakeRest;


@Aspect
public class Auditoria {

	private final static Logger log = Logger.getLogger(Auditoria.class);
	
	@Around("execution(* morfiya.rest.*.*(..))")
    public Object logAnyApiCall(final ProceedingJoinPoint pjp) throws Throwable {
		LocalDate now = LocalDate.now();
		log.info(now + "Llamando desde APIREST al metodo: " + pjp.getSignature().getName() + " con los siguientes argumentos: ");
		Object[] signatureArgs = pjp.getArgs();
	    for (Object signatureArg : signatureArgs) {
	    	log.info(signatureArg.toString());
	    }
        try {
            return pjp.proceed();
        } finally {
           
        }

    }
	
	
}
