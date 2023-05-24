import iaik.pkcs.pkcs11.Module;

import java.io.IOException;

import iaik.pkcs.pkcs11.Info;
import iaik.pkcs.pkcs11.TokenException;

public class PKCS11LibraryInfo {

    public static void main(String[] args) throws IOException, TokenException {
        String libraryPath = "D:/Java/java/pr/win-x86_64/release/pkcs11wrapper.dll"; // Укажите путь к вашей библиотеке PKCS#11
        Module pkcs11Module = Module.getInstance(libraryPath);
            pkcs11Module.initialize(null);

            Info libraryInfo = pkcs11Module.getInfo();
            System.out.println("Library Description: " + libraryInfo.getLibraryDescription());
            System.out.println("Library Version: " + libraryInfo.getLibraryVersion());

            pkcs11Module.finalize(null);
    }
}
