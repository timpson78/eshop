import model.items.*;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.item.ItemCategoryServiceImp;

import java.util.Arrays;

public class MainSpring {

    public static void main(String[] args) throws Exception {

        try (ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/spring-app-test.xml","spring/spring-db.xml")) {
            System.out.println("Bean definition names: " + Arrays.toString(appCtx.getBeanDefinitionNames()));
            //appCtx.getBeanDefinitionNames();
          //  UserServiceImp myUserServ = appCtx.getBean(UserServiceImp.class);
             ItemCategoryServiceImp itemCategoryService = appCtx.getBean(ItemCategoryServiceImp.class);
         //   User user=myUserServ.create(new User(null, "digital2@mail.ru", "12345", "first", "+7918-188-55-35", new Date(), true, Role.ROLE_USER));
        //    User user= myUserServ.findByEmail("digital2@mail.ru");

            //Item item = itemService.get(31);

            //List<ItemImage> images=item.getImages();
//             Item item = new Item(0, "myTitle", "MyShortDescription", "MyDescription", null,"MyUrlSeo", new BigDecimal("4.01"), 2, new ItemMesure(null, "MyItemMesureName"),
//                       12, "MyPartNumber", new BigDecimal("10.01"), new ItemBrand(null,"MyItemBrandName") , new ItemCategory(null, 1, 10,  0, "MyCategoryName"),
//                     true, true, false, true, new SeoMetaData(null, "MySeoTitle","MySeoKeywords","MySeoDescription")) ;
//
//
//               item.addImages(new ArrayList<ItemImage>(Arrays.asList(new ItemImage(null,"srcImage1"), new ItemImage(null,"srcImage2"))));
//               itemService.create(item);

           // ItemCategory rootitemCategory = new ItemCategory(null,1,2,0,"root", null);
            ItemCategory rootitemCategory = itemCategoryService.get(45);
            //ItemCategory itemCategory = new ItemCategory(null,3,4,0,"root", rootitemCategory);
            itemCategoryService.delete(100);
            //itemCategoryService.addChildAsLast(rootitemCategory,"One node yet at LAst");
               System.out.println("edee: ");

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
