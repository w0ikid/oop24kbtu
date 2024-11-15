interface Configurations {
    int MAX_SIZE = 100;
    String DEFAULT_NAME = "Unnamed";
    
    void displayConfig();
}

class SystemConfig implements Configurations {
    @Override
    public void displayConfig() {
        System.out.println("Max size: " + MAX_SIZE);
        System.out.println("Default name: " + DEFAULT_NAME);
    }
}