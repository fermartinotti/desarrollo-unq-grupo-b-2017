package morfiya.utils;

import java.time.LocalDate;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.format.datetime.joda.LocalDateParser;


@Aspect
public class Auditoria {

	private final static Logger log = Logger.getLogger(Auditoria.class);
	
	@Around("execution(* morfiya.rest.*.*(..))")
    public Object aroundGreeting(final ProceedingJoinPoint pjp) throws Throwable {
		LocalDate now = LocalDate.now();
		System.out.print(now + " Metodo: " + pjp.getSignature().getName() + " argumentos: ");
		Object[] signatureArgs = pjp.getArgs();
	    for (Object signatureArg : signatureArgs) {
	    	System.out.print(signatureArg.toString());
	        //logger.info("###### Arguments: {} ", signatureArg.toString());
	    }
	    System.out.println(""); // Solamente por legivilidad CAMBIAR
        log.info("Mensaje");
        try {
            return pjp.proceed();
        } finally {
           
        }

    }
}
