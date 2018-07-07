package JFrameTest;

import mapper.PlayersMapper;
import mapper.TransfersMapper;
import mapper.YouthMapper;
import model.MzPlayerModel;
import model.Players;
import model.Transfers;
import model.Youth;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.*;
import java.sql.PreparedStatement;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by LTL on 2018-07-02.
 */
public class Main {
    private static SqlSession sqlSession;
    private static PlayersMapper playersMapper;
    private static TransfersMapper transfersMapper;
    private static YouthMapper youthMapper;
    public static void main(String[] args) throws Exception{
//        Frame frame = new Frame("MzPlayers");
        init();
//        Mz frame = new Mz();
//        frame.showPanel();
//        addPlayers();
        addTransfers();
//        addYouth();
        sqlSession.commit();
        sqlSession.close();

//        System.out.println(players.getName());

//        //自定义查询，这就用到了ItemsExample类了，里面有个Criteria内部类，专门用来封装自定义查询条件的
//        PlayersMapper itemsExample = new PlayersMapper();
//        PlayersMapper.Criteria criteria = itemsExample.createCriteria();
//        //andNameEqualTo相当于在sql中拼接一个“AND name='背包'”
//        //还有其他很多方法，都是用来自定义查询条件的，可以自己看一下不同的方法
//        criteria.andNameEqualTo("背包");
//        List<Players> itemsList = itemsMapper.selectAll();
//        System.out.println(itemsList);
    }


    private static void init() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);//创建完就应该释放，从这里开始配置mybatis
        sqlSession = sqlSessionFactory.openSession();//每次请求申请一个session
        playersMapper = sqlSession.getMapper(PlayersMapper.class);//每次业务处理使用一个mapper，用完释放
        transfersMapper = sqlSession.getMapper(TransfersMapper.class);
        youthMapper = sqlSession.getMapper(YouthMapper.class);
    }

    public static void addPlayers(){
        String filePath = "C:/Users/LTL/Desktop/player.txt";
        try {
            File file = new File(filePath);
            if (file.isFile() && file.exists()) {
                InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "utf-8");
                BufferedReader br = new BufferedReader(isr);
                String lineTxt = null;
                Players player = null;
                while ((lineTxt = br.readLine()) != null) {
                    if(lineTxt.contains("id")){
                        //System.out.println(player);
                        if(player != null)
                            insertPlayer(player);
//                            playersMapper.insert(player);
                        String[] tmp = lineTxt.split("id:");
                        player = new Players();
                        player.setName(tmp[0].split(" ")[1].trim());
                        player.setPid(Integer.parseInt(tmp[1].trim()));
                        continue;
                    }
                    //region 读取属性
                    if(lineTxt.contains("出生"))
                        player.setBirthseason(Integer.parseInt(lineTxt.split(":")[1].trim()));
                    if(lineTxt.contains("国籍"))
                        player.setNationality(lineTxt.split(":")[1].trim());
                    if(lineTxt.contains("价值"))
                        player.setValue(getIntFromStr(lineTxt));
                    if(lineTxt.contains("周薪"))
                        player.setSalary(getIntFromStr(lineTxt));

                    if(lineTxt.contains("速度:"))
                        player.setSpeed(Integer.parseInt(lineTxt.split(":")[1].split("\t")[0].trim()));
                    if(lineTxt.contains("耐力:"))
                        player.setStamina(Integer.parseInt(lineTxt.split(":")[1].split("\t")[0].trim()));
                    if(lineTxt.contains("意识:"))
                        player.setItg(Integer.parseInt(lineTxt.split(":")[1].split("\t")[0].trim()));
                    if(lineTxt.contains("传球:"))
                        player.setPass(Integer.parseInt(lineTxt.split(":")[1].split("\t")[0].trim()));
                    if(lineTxt.contains("射门:"))
                        player.setShoot(Integer.parseInt(lineTxt.split(":")[1].split("\t")[0].trim()));
                    if(lineTxt.contains("头球:"))
                        player.setHead(Integer.parseInt(lineTxt.split(":")[1].split("\t")[0].trim()));
                    if(lineTxt.contains("守门:"))
                        player.setKeep(Integer.parseInt(lineTxt.split(":")[1].split("\t")[0].trim()));
                    if(lineTxt.contains("控球:"))
                        player.setControl(Integer.parseInt(lineTxt.split(":")[1].split("\t")[0].trim()));
                    if(lineTxt.contains("抢断:"))
                        player.setTackl(Integer.parseInt(lineTxt.split(":")[1].split("\t")[0].trim()));
                    if(lineTxt.contains("传中:"))
                        player.setaPass(Integer.parseInt(lineTxt.split(":")[1].split("\t")[0].trim()));
                    if(lineTxt.contains("定位:"))
                        player.setSetPalys(Integer.parseInt(lineTxt.split(":")[1].split("\t")[0].trim()));
                    if(lineTxt.contains("经验:"))
                        player.setExperience(Integer.parseInt(lineTxt.split(":")[1].split("\t")[0].trim()));
                    //endregion
                }
                insertPlayer(player);
//                playersMapper.insert(player);
//                System.out.println(player);
                br.close();
            } else {
                System.out.println("文件不存在!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("文件读取错误!");
        }
    }
    public static void addTransfers(){
        String filePath = "C:/Users/LTL/Desktop/transfer.txt";
        try {
            File file = new File(filePath);
            if (file.isFile() && file.exists()) {
                InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "utf-8");
                BufferedReader br = new BufferedReader(isr);
                String lineTxt = null;
                Transfers player = null;
                while ((lineTxt = br.readLine()) != null) {
                    if(lineTxt.contains("(转会市场)")){
                        //System.out.println(player);
                        if(player != null)
                            insertTransfer(player);
//                            transfersMapper.insert(player);
                        int pointIndex = lineTxt.indexOf('.');
                        lineTxt = lineTxt.substring(pointIndex+1);
                        String[] tmp = lineTxt.split("\\(转会市场\\) id:");
                        player = new Transfers();
                        player.setName(tmp[0].split(" ")[1].trim());
                        player.setPid(Integer.parseInt(tmp[1].trim()));
                        continue;
                    }
                    //region 读取属性
                    setPlayerAblilty(player, lineTxt);
                    if(lineTxt.contains("截止时间")){
                        String[] tmp = lineTxt.split(" ");
                        String[] d = tmp[1].split("-");
                        String[] t = tmp[2].split(":");
                        int y = Integer.parseInt(d[0])-1900;
                        Date date = new Date(y, Integer.parseInt(d[1])-1, Integer.parseInt(d[2]));
                        Date time = new Date(0,0,0, Integer.parseInt(t[0]), Integer.parseInt(t[1]));

                        player.setDlSeasonDay(new SeasonDay(date).day);
                        player.setDlDate(date);
                        player.setDlTime(time);
                    }
                    if(lineTxt.contains("挂牌价"))
                        player.setAskingPrice(getIntFromStr(lineTxt));
                    if(lineTxt.contains("最新出价"))
                        player.setLatestBid(getIntFromStr(lineTxt.split("MM")[0]));
                    //endregion
                }
                insertTransfer(player);
//                transfersMapper.insert(player);
//                System.out.println(player);
                br.close();
            } else {
                System.out.println("文件不存在!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("文件读取错误!");
        }
    }
    public static void addYouth(){
        String filePath = "C:/Users/LTL/Desktop/youth.txt";
        try {
            File file = new File(filePath);
            if (file.isFile() && file.exists()) {
                InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "utf-8");
                BufferedReader br = new BufferedReader(isr);
                String lineTxt = null;
                Youth player = null;
                while ((lineTxt = br.readLine()) != null) {
                    if(lineTxt.contains("id")){
                        if(player != null)
                            insertYouth(player);
//                            transfersMapper.insert(player);
                        String[] tmp = lineTxt.split("id:");
                        player = new Youth();
                        player.setName(tmp[0].split(" ")[1].trim());
                        player.setPid(Integer.parseInt(tmp[1].trim()));
                        continue;
                    }
                    //region 读取属性
                    if(lineTxt.contains("出生"))
                        player.setBirthseason(Integer.parseInt(lineTxt.split(":")[1].trim()));
                    if(lineTxt.contains("国籍"))
                        player.setNationality(lineTxt.split(":")[1].trim());
                    if(lineTxt.contains("价值"))
                        player.setValue(getIntFromStr(lineTxt));

                    setPlayerAblilty(player, lineTxt);
                    if(lineTxt.contains("潜力"))
                        player.setPotential(lineTxt.split("潜力")[1]);
                    //endregion
                }
                insertYouth(player);
//                transfersMapper.insert(player);
//                System.out.println(player);
                br.close();
            } else {
                System.out.println("文件不存在!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("文件读取错误!");
        }
    }

    public static void setPlayerAblilty(MzPlayerModel player, String lineTxt){
        if(lineTxt.contains("出生"))
            player.setBirthseason(Integer.parseInt(lineTxt.split(":")[1].trim()));
        if(lineTxt.contains("国籍"))
            player.setNationality(lineTxt.split(":")[1].trim());
        if(lineTxt.contains("价值"))
            player.setValue(getIntFromStr(lineTxt));
        if(lineTxt.contains("周薪"))
            player.setSalary(getIntFromStr(lineTxt));

        if(lineTxt.contains("速度:"))
            player.setSpeed(Integer.parseInt(lineTxt.split(":")[1].split("\t")[0].trim()));
        if(lineTxt.contains("耐力:"))
            player.setStamina(Integer.parseInt(lineTxt.split(":")[1].split("\t")[0].trim()));
        if(lineTxt.contains("意识:"))
            player.setItg(Integer.parseInt(lineTxt.split(":")[1].split("\t")[0].trim()));
        if(lineTxt.contains("传球:"))
            player.setPass(Integer.parseInt(lineTxt.split(":")[1].split("\t")[0].trim()));
        if(lineTxt.contains("射门:"))
            player.setShoot(Integer.parseInt(lineTxt.split(":")[1].split("\t")[0].trim()));
        if(lineTxt.contains("头球:"))
            player.setHead(Integer.parseInt(lineTxt.split(":")[1].split("\t")[0].trim()));
        if(lineTxt.contains("守门:"))
            player.setKeep(Integer.parseInt(lineTxt.split(":")[1].split("\t")[0].trim()));
        if(lineTxt.contains("控球:"))
            player.setControl(Integer.parseInt(lineTxt.split(":")[1].split("\t")[0].trim()));
        if(lineTxt.contains("抢断:"))
            player.setTackl(Integer.parseInt(lineTxt.split(":")[1].split("\t")[0].trim()));
        if(lineTxt.contains("传中:"))
            player.setaPass(Integer.parseInt(lineTxt.split(":")[1].split("\t")[0].trim()));
        if(lineTxt.contains("定位:"))
            player.setSetPalys(Integer.parseInt(lineTxt.split(":")[1].split("\t")[0].trim()));
        if(lineTxt.contains("经验:"))
            player.setExperience(Integer.parseInt(lineTxt.split(":")[1].split("\t")[0].trim()));
    }

    public static int getIntFromStr(String str){
        String regEx="[^0-9]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return Integer.parseInt(m.replaceAll("").trim());
    }


    public static double saleTax(Transfers tIn, Transfers tOut){
        Date out = tOut.getDlDate();
        Date in = tIn.getDlDate();
        try {
            int days = (int)((out.getTime() - in.getTime())/86400000);
            if(days < 3)
                return 2;
            else if(days<=28)
                return 0.95;
            else if(days<=70)
                return 0.5;
            else
                return 0.15;
        } catch (Exception e) {
            System.out.println(tIn.getName()+" "+tIn.getPid()+"缺少日期数据");
            return 0;
        }
    }
    public static double saleTax(Youth youth){
        SeasonDay sd=new SeasonDay(new Date());
        int age = sd.season - youth.getBirthseason();
        if(age<19)
            return 2;
        else if(age==19)
            return 0.25;
        else if(age == 20)
            return 0.2;
        else
            return 0.15;
    }

    public static void insertPlayer(Players players){
        if(playersMapper.selectByPlayerId(players.getPid()) != null)
            playersMapper.updateByPlayerId(players);
        else
            playersMapper.insert(players);
    }
    public static void insertTransfer(Transfers transfers){
        Transfers t = transfersMapper.selectLastedByPlayerId(transfers.getPid());
        if(t != null && saleTax(t,transfers) >1)
            transfersMapper.updateByPlayerId(transfers);
        else
            transfersMapper.insert(transfers);
    }
    public static void insertYouth(Youth players){
        if(youthMapper.selectByPlayerId(players.getPid()) != null)
            System.out.println(players.getName()+"("+players.getPid()+") 已存在!!");
        else
            youthMapper.insert(players);
    }
}