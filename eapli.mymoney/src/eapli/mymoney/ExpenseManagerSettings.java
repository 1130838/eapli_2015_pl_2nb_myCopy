package eapli.mymoney;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A "global" (singleton) class with the application settings.
 *
 * @author Paulo Gandra Sousa
 */
public final class ExpenseManagerSettings {

    private final Properties applicationProperties = new Properties();
    private static ExpenseManagerSettings theInstance;
    //private final static String PROPERTIES_FILENAME = "./res/eapli/mymoney/mymoney.properties";
    private final static String PROPERTIES_RESOURCE = "mymoney.properties";
    private final static String REPOSITORY_FACTORY_KEY = "persistence.repositoryFactory";

    public static ExpenseManagerSettings instance() {
        if (theInstance == null) {
            theInstance = new ExpenseManagerSettings();
        }
        return theInstance;
    }

    private ExpenseManagerSettings() {
        loadProperties();
    }

    public Properties getApplicationProperties() {
        return applicationProperties;
    }

    private void loadProperties() {
        InputStream propertiesStream = null;
        try {
            System.out.println( ExpenseManagerSettings.class.getProtectionDomain().getCodeSource().getLocation().getPath());
            //propertiesStream = new FileInputStream(PROPERTIES_FILENAME);
            propertiesStream = ExpenseManagerSettings.class.getClassLoader()
                    .getResourceAsStream(PROPERTIES_RESOURCE);
            if (propertiesStream != null) {
                applicationProperties.load(propertiesStream);
            } else {
                throw new FileNotFoundException("property file '"
                        + PROPERTIES_RESOURCE + "' not found in the classpath");
            }
        } catch (IOException exio) {
            setDefaultProperties();

            Logger.getLogger(ExpenseManagerSettings.class.getName()).log(
                    Level.SEVERE, null, exio);
        } finally {
            if (propertiesStream != null) {
                try {
                    propertiesStream.close();
                } catch (IOException ex) {
                    Logger.getLogger(ExpenseManagerSettings.class.getName())
                            .log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private void setDefaultProperties() {
        applicationProperties.setProperty(REPOSITORY_FACTORY_KEY,
                "eapli.mymoney.persistence.jpa.JpaRepositoryFactory");
    }

    public String getRepositoryFactory() {
        return applicationProperties.getProperty(REPOSITORY_FACTORY_KEY);
    }
}
