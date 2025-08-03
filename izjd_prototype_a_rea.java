import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class izjd_prototype_a_rea {
    // IoT Device Class
    public static class IoTDevice {
        String id;
        String type;
        String sensorData;

        public IoTDevice(String id, String type) {
            this.id = id;
            this.type = type;
        }

        public void generateSensorData() {
            Random rand = new Random();
            int num = rand.nextInt(100);
            sensorData = "Sensor Data: " + num;
        }

        public String toString() {
            return "ID: " + id + ", Type: " + type + ", Sensor Data: " + sensorData;
        }
    }

    // IoT Device Generator Class
    public static class IoTDeviceGenerator {
        List<IoTDevice> devices;
        int deviceCount;

        public IoTDeviceGenerator(int deviceCount) {
            this.deviceCount = deviceCount;
            this.devices = new ArrayList<>();
            generateDevices();
        }

        private void generateDevices() {
            for (int i = 0; i < deviceCount; i++) {
                IoTDevice device = new IoTDevice("Device-" + i, getRandomType());
                device.generateSensorData();
                devices.add(device);
            }
        }

        private String getRandomType() {
            String[] types = {"Temperature", "Humidity", "Light"};
            Random rand = new Random();
            return types[rand.nextInt(types.length)];
        }

        public void printDevices() {
            for (IoTDevice device : devices) {
                System.out.println(device.toString());
            }
        }
    }

    public static void main(String[] args) {
        IoTDeviceGenerator generator = new IoTDeviceGenerator(10);
        generator.printDevices();
    }
}