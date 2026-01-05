
// A Precondition must be statisfied before a method can be executed.
// Sub classes can weaken the precondition but cannot strengthen it.

class User {
    // Precondition: Password must be at least 8 characters long
    public void setPassword(String password) {
        if (password.length() < 8) {
            throw new IllegalArgumentException("Password must be at least 8 characters long!");
        }
        System.out.println("Password set successfully");
    }
}

class AdminUser extends User {
    // Precondition: Password must be at least 6 characters
    @Override
    public void setPassword(String password) {
        if (password.length() < 6) {
            throw new IllegalArgumentException("Password must be at least 6 characters long!");
        }
        System.out.println("Password set successfully");
    }
}

public class lspGuidelines_methodRule_precondition {
    public static void main(String[] args) {
        User normalUser = new User();
        User user = new AdminUser();

        normalUser.setPassword("1234567"); // Exception/Error: For normal users more than 8 characters are needed

        user.setPassword("1234567");  // Works fine: AdminUser allows shorter passwords
    }
}
