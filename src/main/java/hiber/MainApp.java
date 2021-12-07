package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

//      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
//      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
//      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
//      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

      User user1 = new User("Юлия", "Привалихина", "user1@mail.ru");
      User user2 = new User("Алена", "Мецкер", "user2@mail.ru");
      User user3 = new User("Елена", "Косенкова", "user3@mail.ru");
      User user4 = new User("Ирина", "Крюкова", "user4@mail.ru");
      Car car1 = new Car("Lexus", 470);
      Car car2 = new Car("Honda", 660);
      Car car3 = new Car("Suzuki", 90);
      Car car4 = new Car("Nissan", 350);

      userService.add(user1.addCar(car1).addUser(user1));
      userService.add(user2.addCar(car2).addUser(user2));
      userService.add(user3.addCar(car3).addUser(user3));
      userService.add(user4.addCar(car4).addUser(user4));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println(user);
         System.out.println(user.getCar());
//         System.out.println("Id = "+user.getId());
//         System.out.println("First Name = "+user.getFirstName());
//         System.out.println("Last Name = "+user.getLastName());
//         System.out.println("Email = "+user.getEmail());
      }
      System.out.println(userService.getUerByCar(car3.getModel(), car3.getSeries()));
      context.close();
   }
}
