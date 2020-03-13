import org.telegram.abilitybots.api.db.DBContext;
import org.telegram.abilitybots.api.objects.Ability;
import org.telegram.abilitybots.api.objects.Locality;
import org.telegram.abilitybots.api.objects.Privacy;
import org.telegram.abilitybots.api.sender.SilentSender;
import org.telegram.abilitybots.api.util.AbilityExtension;

public class MyAbilityExtension implements AbilityExtension {
    private SilentSender silent;
    private DBContext db;
    private DBManager dbManager;

    public MyAbilityExtension(SilentSender silent, DBContext db) {
        this.silent=silent;
        this.db=db;
        dbManager=new DBManager(db);
    }

    public Ability start(){
        return Ability
                .builder()
                .name("start")
                .info("start+help")
                .locality(Locality.ALL)
                .privacy(Privacy.PUBLIC)
                .action(ctx -> {

                    silent.send("/typefilter - фильтр содержит три типа: Завтрак, Обед, Ужин и Десерт" +
                            "\n/cousinfilter - фильтр содержит четыре типа: italian, american, japanese, russian" +
                            "\n/namefilter - фильтр по названию блюда" +"\nTo find nearest place in some area just send a point on map", ctx.chatId());
                })
                .build();
    }
    public Ability filterByType() {
        return Ability
                .builder()
                .name("typefilter")
                .info("filter food by type")
                .input(1)
                .locality(Locality.ALL)
                .privacy(Privacy.PUBLIC)
                .action(ctx->{
                    dbManager.searchByType(ctx.firstArg().toUpperCase());
                    for (Food food : dbManager.searchByType(ctx.firstArg().toUpperCase())){
                        silent.send(food.getName()+"\nCuisine: " +food.getCousin().toString().toLowerCase()+food.getDescription(),ctx.chatId());

                    }

                })
                .build();
    }

    public Ability filterByCousin() {
        return Ability
                .builder()
                .name("cousinfilter")
                .info("filter food by cousin")
                .input(1)
                .locality(Locality.ALL)
                .privacy(Privacy.PUBLIC)
                .action(ctx->{
                    dbManager.searchByCousin(ctx.firstArg().toUpperCase());
                    for (Food food : dbManager.searchByCousin(ctx.firstArg().toUpperCase())){
                        silent.send(food.getName()+"\nCuisine: " +food.getCousin().toString().toLowerCase()+"\n"+food.getType()+food.getDescription(),ctx.chatId());

                    }
                })
                .build();
    }
    public Ability filterByName() {
        return Ability
                .builder()
                .name("namefilter")
                .info("filter food by name")
                .input(1)
                .locality(Locality.ALL)
                .privacy(Privacy.PUBLIC)
                .action(ctx->{
                    dbManager.searchByName(ctx.firstArg().toUpperCase());
                    for (Food food : dbManager.searchByName(ctx.firstArg().toUpperCase())){
                        silent.send(food.getName()+"\nCuisine: " +food.getCousin().toString().toLowerCase()+"\n"+food.getType()+food.getDescription(),ctx.chatId());

                    }
                })
                .build();
    }

}
