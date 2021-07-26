package hiber;

import java.sql.SQLException;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);
        User user = new User("User1", "Lastname1", "user1@mail.ru");
        user.setCar(new Car("model1", 154789));
        userService.add(user);
        User user2 = new User("User2", "Lastname2", "user2@mail.ru");
        user2.setCar(new Car("model2", 784579));
        userService.add(user2);
        User user3 = new User("User3", "Lastname3", "user3@mail.ru");
        user3.setCar(new Car("model3", 784968));
        userService.add(user3);
        User user4 = new User("User4", "Lastname4", "user4@mail.ru");
        user4.setCar(new Car("model4", 635779));
        userService.add(user4);

        List<User> users = userService.listUsers();
        System.out.println(users);
        for (User userl : users) {
            System.out.println("Id = " + userl.getId());
            System.out.println("First Name = " + userl.getFirstName());
            System.out.println("Last Name = " + userl.getLastName());
            System.out.println("Email = " + userl.getEmail());
            System.out.println("Car = " + userl.getCar().toString());
            System.out.println();
        }

        System.out.println("Find user by car : " + userService.getUserByCar(new Car("model4", 635779)));

        context.close();
    }
}
