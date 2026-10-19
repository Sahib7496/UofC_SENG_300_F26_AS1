import java.util.UUID;

public interface GatewayHandler {
    static String generateGatewayID(){
        return UUID.randomUUID().toString();
    };
}
