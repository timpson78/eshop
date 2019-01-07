import model.Role;
import model.User;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import repository.UserRepositoryImp;
import service.UserServiceImp;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class MainSpring {

    public static void main(String[] args) {

        try (ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/spring-app.xml", "spring/spring-db.xml")) {
            System.out.println("Bean definition names: " + Arrays.toString(appCtx.getBeanDefinitionNames()));
            appCtx.getBeanDefinitionNames();
            UserServiceImp myUserServ = appCtx.getBean(UserServiceImp.class);
          //  UserRepositoryImp userRepo = appCtx.getBean(UserRepositoryImp.class);
         //   User user=myUserServ.create(new User(null, "digital2@mail.ru", "12345", "first", "+7918-188-55-35", new Date(), true, Role.ROLE_USER));
        //    User user= myUserServ.findByEmail("digital2@mail.ru");
               User user= myUserServ.findById(11);
               System.out.println("edee: "+user);

            // User user = myUserServ.get(9);
            //System.out.println("edee"+user);


//            UserRepositoryImp myUserRep = appCtx.getBean(UserRepositoryImp.class);
//            myUserRep.save(new User(null, "digital@mail.ru", null, null, null, null));

//            AdminRestController adminUserController = appCtx.getBean(AdminRestController.class);
//            adminUserController.create(new User(null, "userName", "email@mail.ru", "password", Role.ROLE_ADMIN))
//                System.out.println();
//
//                MealRestController mealController = appCtx.getBean(MealRestController.class);
//                List<MealWithExceed> filteredMealsWithExceeded =
//                        mealController.getBetween(
//                                LocalDate.of(2015, Month.MAY, 30), LocalTime.of(7, 0),
//                                LocalDate.of(2015, Month.MAY, 31), LocalTime.of(11, 0));
//                filteredMealsWithExceeded.forEach(System.out::println);

        }

    }
}
