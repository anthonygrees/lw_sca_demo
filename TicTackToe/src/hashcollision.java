// Hash collisions occur when two different inputs produce the same hash value. This can create a security vulnerability in applications that rely on cryptographic hash functions, such as password hashing or digital signatures.
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashCollisionExample {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String input1 = "password1";
        String input2 = "password2";

        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] hash1 = md.digest(input1.getBytes());
        byte[] hash2 = md.digest(input2.getBytes());

        System.out.println("Hash1: " + new String(hash1));
        System.out.println("Hash2: " + new String(hash2));
    }
}
