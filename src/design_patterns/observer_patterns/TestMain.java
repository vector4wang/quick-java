package design_patterns.observer_patterns;

/**
 * @author vector
 * @date: 2018/11/19 0019 10:44
 */
public class TestMain {
    public static void main(String[] args) {

        Subject boss = new Boss();


        Subject xiaoMei = new Secretary();

        Observer sob = new StockObserver("小股民", xiaoMei);
        Observer loser = new NBAObserver("NBA魯什", xiaoMei);
        // 沒人通知的情況下，小員工直接被老闆抓包
        System.out.println("小股民看股票中，NBA魯什看NBA中---老闆突然回來了");
        boss.attach(sob);
        boss.attach(loser);
        boss.doNotify("上班不上班，等等來辦公室找我");

        System.out.println("=============拜託櫃台小姐通知老闆回來了=============");
        xiaoMei.attach(sob);
        xiaoMei.attach(loser);
        // 報明牌失準，小美表示不想通知小股民了
        xiaoMei.detach(sob);
        xiaoMei.doNotify("老闆回來拉!!!");

    }
}
