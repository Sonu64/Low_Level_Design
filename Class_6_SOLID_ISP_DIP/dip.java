// DIP (Dependency Inversion Principle) states that high-level modules should not depend on low-level modules; both should depend on abstractions (interfaces).

// In simpler terms: "Depend upon abstractions, not concretions."

interface Database {
    public void save(String data);
}

class SQL_DB implements Database {
@Override
    public void save(String data) {
        System.out.println(
            "Executing SQL Query: INSERT INTO users VALUES('" 
            + data + "');"
        );
    }
}

class MongoDB_DB implements Database {
    @Override
    public void save(String data) {
        System.out.println(
            "Executing MongoDB Function: db.users.insert({name: '" 
            + data + "'})"
        );
    }
}

class UserService {
    private Database userDatabase;
    public UserService(Database db) {
        this.userDatabase = db;
    }
    public void storeUser(String username) {
        userDatabase.save(username);
    }
}


public class dip {
    public static void main(String[] args) {
        SQL_DB sql_db_object = new SQL_DB();
        MongoDB_DB mongo_db_object = new MongoDB_DB();

        // The user may choose where to store the data, or by default we create seperate services for the seperate Databases and then call the same method - .storeUser() --> which ultimately calls .save() for that specific Db Type

        // When a new DB type will be introduced we just need to add 1 or 2 lines of code
        // 1. UserService newDatabaseService = new UserService(new_db_object), new_db_object method .save() will be called when we now call --->
        // 2. newDatabaseService.storeUser(username)
        // We don't even need to Open up and edit/see the UserService class, which is responsible for storing users.

        UserService sqlUserService = new UserService(sql_db_object);
        UserService mongoUserService = new UserService(mongo_db_object);

        sqlUserService.storeUser("Sourakanti");
        mongoUserService.storeUser("Paramita");
    }
}
