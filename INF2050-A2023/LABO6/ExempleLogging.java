import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ExempleLogging {

    private static Log log = LogFactory.getLog(ExempleLogging.class);

    public static void main (String[] args){
        log.info("Info dans le main");
        log.error("Erreur dans le main");

        System.out.println(args[0]+" "+args[1]);
    }
}