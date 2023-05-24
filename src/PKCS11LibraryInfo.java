import iaik.pkcs.pkcs11.*;
import iaik.pkcs.pkcs11.wrapper.*;
import iaik.pkcs.pkcs11.provider.*;;

public class PKCS11LibraryInfo {
    public static void main(String[] args) {
        try {
            String pkcs11LibraryPath = "C:\\path\\to\\pkcs11\\library.dll"; // Path to the PKCS#11 library for eToken

            // Load the PKCS#11 library
            Module pkcs11Module = Module.getInstance(pkcs11LibraryPath);

            // Initialize the PKCS#11 module
            pkcs11Module.initialize(null);

            // Get the PKCS#11 provider
            PKCS11Provider pkcs11Provider = new PKCS11Provider(pkcs11Module);

            // Get the PKCS11 object
            PKCS11 pkcs11 = PKCS11.getInstance(pkcs11Provider.getName(), null, null, true);

            // Get the library info
            CK_INFO libraryInfo = pkcs11.C_GetInfo();

            // Print library information
            System.out.println("Library Description: " + new String(libraryInfo.manufacturerID));
            System.out.println("Library Version: " + libraryInfo.libraryVersion.major + "." + libraryInfo.libraryVersion.minor);

            // Finalize and unload the PKCS#11 module
            pkcs11Module.finalize(null);

        } catch (PKCS11Exception e) {
            e.printStackTrace();
        }
    }
}
