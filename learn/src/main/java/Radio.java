public class Radio implements ElectricityConsumer{

    public void play() {
        System.out.println("Радио играет");
    }
    @Override
    public void electricityOn() {
        play();
    }

}
