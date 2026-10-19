public class RideDepositHold {
    private String gatewayID;
    private User user;
    public RideDepositHold(User user, Vehicle vehicle){
        this.gatewayID = GatewayHandler.generateGatewayID();
        vehicle.setDepositHold(this);
    }
}
