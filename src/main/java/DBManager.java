import org.telegram.abilitybots.api.db.DBContext;

import java.util.*;
import java.util.List;

public class DBManager {
    private List<Food> foodList=Arrays.asList(new Food(1,"Борщ",FoodType.DINNER,CousinType.RUSSIAN,
            "Шаг1: положить мяос в большую кастрюлю, залить тремя литрами воды, довести до кипения, " +
                    "варить волтора часа. \n " +
                    "Шаг 2: нарезать перец. \n " +
                    "Шаг 3: Морковь натереть на терке, лук нарезать мелкими кубиками, обжарит до золотистости. \n " +
                    "Шаг 4: через 10 минут добавить нарезанную картошку \n " +
                    "Шаг 5: все остальное тоже на нашинковать \n" +
                    " Шаг 6:варить 30 минут, снять с огня и дать настояться \n "),
            new Food(2,"Борщ",FoodType.DINNER,CousinType.RUSSIAN,"Шаг1: положить мяос в большую кастрюлю, залить тремя литрами воды, довести до кипения, варить волтора часа." +
                    " \n Шаг 2: нарезать перец. \n" +
                    " Шаг 3: Морковь натереть на терке, лук нарезать мелкими кубиками, обжарит до золотистости. \n" +
                    " Шаг 4: через 10 минут добавить нарезанную картошку \n" +
                    " Шаг 5: все остальное тоже на нашинковать \n" +
                    " Шаг 6:варить 30 минут, снять с огня и дать настояться \n "),
            new Food(3,"Чизкейк класический",FoodType.DESERT,CousinType.AMERICAN,
                    "Шаг 1: застелить протвень пекарской бумагой. Тесто выложить в поставленное на него кулинарное кольцо диаметром 30см. Разогреть духовку до 180 градусов \n" +
                            " Шаг 2: смешать сыр и 150 г сахара, выскрести в смесь заернышки из струыка ванили \n " +
                            "Шаг 3: для глазури взять желатин и замочить в воде на 5 минут \n" +
                            " Шаг 4: залить глазурью осташийся чизкейк \n" +
                            " шаг 5: все готово (если бы) \n"),
            new Food(4,"Пшеная каша",FoodType.DINNER,CousinType.RUSSIAN,
                    "Шаг 1: возьмите кашу \n" +
                            " Шаг 2:бросьте ее в подсоленую воду \n" +
                            " Шаг 3: Накройте крышкой и ждите 20 минут \n" +
                            " Шаг 4: подавать кашку лучше с маслом"),
            new Food(5,"Мясо по французски",FoodType.SUPPER,CousinType.RUSSIAN,
                    "Шаг 1: купите мяса \n" +
                            " Шаг 2 : Обработайте мясо специями по вкусу \n" +
                            " Шаг 3 : разогрейте сковородку и положите туда сливочное масло с чесноком \n" +
                            " Шаг 4: накройте крышко и ждите пока мясо приготовиться"),
            new Food(7,"Киевские котлеты",FoodType.SUPPER,CousinType.RUSSIAN,
                    "Шаг 1: купите мясо \n " +
                            "Шаг 2 : сделайте из него котлеты \n" +
                            " Шаг 3 : котлеты готовы"),
            new Food(6,"Картовельное пюре",FoodType.DINNER,CousinType.RUSSIAN,
                    "Шаг 1: возьмите картофель \n" +
                            " Шаг 2 : сварите картофель \n" +
                            " Шаг 3 : добавьте молока и пюре готово"),
            new Food(8,"Ольвье",FoodType.SUPPER,CousinType.RUSSIAN,
                    "Шаг 1: все ингридиенты нарезать кубиками \n" +
                            " Шаг 2 : залить соусом на выбор \n" +
                            " Шаг 3 : подавать с зеленью"),
            new Food(9,"Солянка",FoodType.DINNER,CousinType.RUSSIAN,
                    "Шаг 1: нарежьте кубиками все виды колбас \n " +
                            "Шаг 2 : обжарьте морковь , лук и чеснок на медленном огне \n" +
                            " Шаг 3 : варить на среднем огне 30 минут"),
            new Food(10,"Солянка",FoodType.DINNER,CousinType.RUSSIAN,
                    "Шаг 1: нарежьте кубиками все виды колбас \n " +
                            "Шаг 2 : обжарьте морковь , лук и чеснок на медленном огне \n" +
                            " Шаг 3 : варить на среднем огне 30 минут")
            );
    Map<Integer,Food> mapFood=new HashMap<>();
    Map<String,Food> NameFood=new HashMap<>();
    DBManager(DBContext db){
         for (Food food:foodList){
            mapFood.put(food.getID(),food);
        }
        for (Food food:foodList){
            NameFood.put(food.getName(),food);
        }
  }

    public List<Food> searchByType(String type){
        List<Food> result=new ArrayList<>();
        result.addAll(foodList);
        result.removeIf(food->(!food.getType().toString().equals(type)));
        return result;
    }

    public List<Food> searchByCousin (String cousin){
        List<Food> result=new ArrayList<>();
        result.addAll(foodList);
        result.removeIf(food->(!food.getCousin().toString().equals(cousin)));
        return result;
    }

    public Food searchByName (String name) {
        return NameFood.get(name);
    }
    }

