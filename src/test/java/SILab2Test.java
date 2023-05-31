import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SILab2Test {


    @Test
    void everyBranchTest(){
        System.out.println("Testing using every branch method");
        List<User> userList = new ArrayList<User>();
        for(int i = 0; i<5; i++){
            userList.add(new User(String.format("user%d",i), String.format("password%d",i), String.format("user@email%d.com",i)));
        }
        userList.forEach(user -> System.out.println(user.email));
        System.out.println("User, password and email are null/not null");
        List<RuntimeException> exceptions = new ArrayList<RuntimeException>();
        exceptions.add(Assertions.assertThrows(RuntimeException.class, () -> SILab2.function(null, userList)));
        exceptions.add(Assertions.assertThrows(RuntimeException.class, () -> SILab2.function(new User("test",null,"user@gmail.com"), userList)));
        exceptions.add(Assertions.assertThrows(RuntimeException.class, () -> SILab2.function(new User("test","password123",null), userList)));
        exceptions.stream().forEach(ex -> {
            Assertions.assertTrue(ex.getMessage().contains("Mandatory information missing!"));
        });
        User ideal = new User("UsernameTest", "password123", "user@email2.com");
        Assertions.assertDoesNotThrow(()->SILab2.function(ideal,userList));
        System.out.println("Success!");

        System.out.println("Null/non-Null Username");
        User testuser = new User(null, "pass", "useremail1.com");
        SILab2.function(testuser,userList);
        Assertions.assertEquals(testuser.getUsername(), testuser.getEmail());

        testuser = new User("UsernameTest", "password123", "user@email2.com");
        SILab2.function(testuser,userList);
        Assertions.assertNotEquals(testuser.getUsername(), testuser.getEmail());
        System.out.println("Success!");

        System.out.println("User email contains/doesn't contain @ and .");
        testuser = new User(null, "abcdefghj123", "usermail");
        Assertions.assertFalse(SILab2.function(testuser,userList));

        testuser = new User(null, "aRR5", "user@mail.com");
        Assertions.assertFalse(SILab2.function(testuser,userList));

        System.out.println("Success!");

        System.out.println("User list is emtpy/not empty");
        testuser = new User(null, "arr5511223$#", "damjan.avramovski@gmail.com");
        Assertions.assertTrue(SILab2.function(testuser, new ArrayList<User>()));

        testuser = new User(null, "aRRR33001", "user@email1.com");
        Assertions.assertFalse(SILab2.function(testuser, userList));

        System.out.println("Success!");

        System.out.println("Existing/No existing user with an identical email");
        testuser = new User(null, "arr51$321", "user@email2.com");
        Assertions.assertFalse(SILab2.function(testuser,userList));

        testuser = new User(null, "arr513215", "uniquemail1234@gmail.com");
        Assertions.assertFalse(SILab2.function(testuser,userList));

        System.out.println("Success!");

        System.out.println("Existing/No existing user with an identical username");
        testuser = new User("user1", "arr51321", "userunique@emailunique.com");
        Assertions.assertFalse(SILab2.function(testuser,userList));

        testuser = new User("UniqueUser", "arr", "user@email2.com");
        Assertions.assertFalse(SILab2.function(testuser,userList));

        System.out.println("Success!");

        System.out.println("Password contains/doesn't contain username and is shorter/longer than 8 chars");
        testuser = new User(null,"abcdefgh12345", "damjan.avramovski@gmail.com");
        Assertions.assertFalse(SILab2.function(testuser,userList));

        testuser = new User("userpass", "userpass", "damjan.avramovski@gmail.com");
        Assertions.assertFalse(SILab2.function(testuser,userList));

        testuser = new User(null,"abc", "user@email3.com");
        Assertions.assertFalse(SILab2.function(testuser,userList));
        System.out.println("Success!");

        System.out.println("Password contains/doesn't contain space");
        testuser = new User("Unikatno", "abcdefgh", "user@email4.com");
        Assertions.assertFalse(SILab2.function(testuser,userList));

        testuser = new User("Unique", "abce foo", "user@email3.com");
        Assertions.assertFalse(SILab2.function(testuser,userList));
        System.out.println("Success!");

        System.out.println("Password contains/doesn't contain special characters");
        testuser = new User("user1", "abcdeftg#", "user1@email2.com");
        Assertions.assertFalse(SILab2.function(testuser,userList));

        testuser = new User("user2", "abcdfeg123", "user3@email3.com");
        Assertions.assertFalse(SILab2.function(testuser,userList));
        System.out.println("Success!");

        System.out.println("Every branch testing complete");
    }

    @Test
    void multipleConditionsTest(){
        System.out.println("Testing using multiple conditions criteria");
        List<User> userList = new ArrayList<User>();
        for(int i = 0; i<5; i++){
            userList.add(new User(String.format("user%d",i), String.format("password%d",i), String.format("user@email%d.com",i)));
        }
        User ideal = new User("UsernameTest", "password123", "user@email2.com");
        Assertions.assertDoesNotThrow(()->SILab2.function(ideal,userList));

        User test = new User("UsernameTest", "password123", null);
        User finalTest = test;
        Assertions.assertThrows(RuntimeException.class,()->SILab2.function(finalTest,userList));

        test = new User("UsernameTest", null, "damjan.avramovski@gmail.com");
        User finalTest1 = test;
        Assertions.assertThrows(RuntimeException.class,()->SILab2.function(finalTest1,userList));

        test = new User(null, "password123", "damjan.avramovski@gmail.com");
        User finalTest2 = test;
        Assertions.assertThrows(RuntimeException.class,()->SILab2.function(finalTest2,userList));

        System.out.println("Multiple conditions test complete");
    }
}
