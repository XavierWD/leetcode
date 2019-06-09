package proxy;

public class RealObject implements InterfaceObject {
    @Override
    public String who() {
        System.out.println("call me !");
        return "real name ";
    }
}
