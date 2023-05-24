import java.io.IOException;
import iaik.pkcs.pkcs11.*;
import iaik.pkcs.pkcs11.Module;
import iaik.pkcs.pkcs11.wrapper.*;

public class PKCS11LibraryInfo {

    private static final String PKCS11_LIBRARY_PATH = "d:/Java/java/project1/myProject2/kekv/iaikPkcs11Wrapper.jar";

    public static void main(String[] args) throws IOException, TokenException {
        try {
            // Initialize the PKCS#11 library
            Module pkcs11Module = Module.getInstance(PKCS11_LIBRARY_PATH);
            pkcs11Module.initialize(null);

            // Get the library information
            Info libraryInfo = pkcs11Module.getInfo();

            // Convert the manufacturer ID to a string
            String manufacturer = libraryInfo.getManufacturerID().trim();

            // Convert the library version to a string
            String version = libraryInfo.getLibraryVersion().getMajor() + "." + libraryInfo.getLibraryVersion().getMinor();

            // Print the library information
            System.out.println("Library information:");
            System.out.println("  Manufacturer: " + manufacturer);
            System.out.println("  Version: " + version);

            // Finalize the PKCS#11 library
            pkcs11Module.finalize(null);
        } catch (PKCS11Exception e) {
            e.printStackTrace();
        }
    }
}
