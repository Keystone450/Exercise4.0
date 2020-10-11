import java.util.*;
import java.security.*;
import javax.crypto.*;
import java.nio.file.*;

public class CryptoApp {

   public static void main(String[] args) throws Exception {

Crypto crypto = new BasicCrypto();

       String welcome = "Hello 2043-er's! Let's try this again :-)";
System.out.println(welcome);

// First, where are we?
//Let's print out our current working directory
       Path cwd = FileSystems.getDefault().getPath("").toAbsolutePath();
System.out.println("Current Working Directory: " + cwd);

// Read in our file to encrypt
   byte[] originalData = Files.readAllBytes(Paths.get(System.getProperty("user.home"), "C-2044-Sample/Crypto/src/encrypt.txt"));
// Encrypt it and save into a byte array
byte[] encryptedData = crypto.encrypt(originalData);
       // Decrypt it and save it into another byte array
byte[] decryptedData = crypto.decrypt(encryptedData);

// Write the encrypted text into the original file

Files.write(Paths.get(System.getProperty("user.home"), "test"), encryptedData);
try {
        //statements in which exception could occur
// Write the decrypted text into the decrypted text file
   Files.write(Paths.get(System.getProperty("user.home"), "C-2044-Sample/Crypto/src/decrypt.txt"), decryptedData);
}
catch(NoSuchFileException e)
{
        //staments to handle exception 
        //for e.g
        System.out.println(e);
}
finally {
        // code that must execute in both cases no matter whether exception occurs or not.
        String sendoff = "It's a wrap!";
        System.out.println(sendoff);

}

   }
  
}
Syntax of the try/catch/finally should be:

try{

//code in which exception might occur

}

catch(exception e)

{

//code to handle the exceptio

}

finally{

//code that must always run