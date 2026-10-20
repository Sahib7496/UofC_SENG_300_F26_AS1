package admin;

import payment.PaymentType;
import station.Zone;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ZoneConfigLoader {
    private ZoneConfigurator configurator;

    // Constructor
    public ZoneConfigLoader(ZoneConfigurator configurator) {
        this.configurator = configurator;
    }

    public boolean loadZone(Zone zone, String fileName) {
        String colour = null;
        String logoPath = null;
        ArrayList<PaymentType> payments = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new File(fileName));

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                String[] parts = line.split("=");
                if (parts.length != 2) {
                    continue;
                }

                String key = parts[0].trim();
                String value = parts[1].trim();

                if (key.equals("colour")) {
                    colour = value;
                } else if (key.equals("logo")) {
                    logoPath = value;
                } else if (key.equals("payments")) {
                    for (String name : value.split(",")) {
                        try {
                            payments.add(PaymentType.valueOf(name.trim()));
                        } catch (IllegalArgumentException e) {
                            System.out.println("Skipping unknown payment type: " + name.trim());
                        }
                    }
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Config file not found: " + fileName);
            return false;
        }

        return configurator.configureZone(zone, payments, colour, logoPath);
    }
}
