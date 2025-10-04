// Bridge Pattern Example: Smartphone and Operating System
// Demonstrates Clean Code principles (SRP, OCP, meaningful naming, readability)

interface OperatingSystem {
    void boot();
    void installApp(String appName);
}

class AndroidOS implements OperatingSystem {
    @Override
    public void boot() {
        System.out.println("Booting Android OS...");
    }

    @Override
    public void installApp(String appName) {
        System.out.println("Installing " + appName + " from Google Play Store.");
    }
}

class IOS implements OperatingSystem {
    @Override
    public void boot() {
        System.out.println("Booting iOS...");
    }

    @Override
    public void installApp(String appName) {
        System.out.println("Installing " + appName + " from the App Store.");
    }
}

// Abstraction
abstract class Smartphone {
    protected OperatingSystem os;

    public Smartphone(OperatingSystem os) {
        this.os = os;
    }

    public abstract void showDetails();

    public void startPhone() {
        os.boot();
    }

    public void downloadApp(String appName) {
        os.installApp(appName);
    }
}

// Refined Abstractions
class Samsung extends Smartphone {
    public Samsung(OperatingSystem os) {
        super(os);
    }

    @Override
    public void showDetails() {
        System.out.println("Samsung Galaxy Smartphone");
    }
}

class Apple extends Smartphone {
    public Apple(OperatingSystem os) {
        super(os);
    }

    @Override
    public void showDetails() {
        System.out.println("Apple iPhone");
    }
}

// Client Code
public class Main {
    public static void main(String[] args) {
        OperatingSystem android = new AndroidOS();
        OperatingSystem ios = new IOS();

        Smartphone samsung = new Samsung(android);
        Smartphone iphone = new Apple(ios);

        System.out.println("=== Samsung Phone ===");
        samsung.showDetails();
        samsung.startPhone();
        samsung.downloadApp("YouTube");

        System.out.println("\n=== iPhone ===");
        iphone.showDetails();
        iphone.startPhone();
        iphone.downloadApp("Instagram");
    }
}
