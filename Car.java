public class Car extends Wehicle{
    public Car() {
        super("car");
    }
    public void wehicleArraiv() {
        System.out.println(this.getClass().getName() + " Arraived to washer");
    }

    @Override
    public void wehicleEnter_washer() {
        System.out.println(this.getClass().getName() + " Entered wash station");
    }

    @Override
    public void wehicle_finish() {
        System.out.println(this.getClass().getName() + " Washed");
    }
}
