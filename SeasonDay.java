package JFrameTest;

import java.util.Date;

/**
 * Created by LTL on 2018-07-04.
 */
public class SeasonDay {
    public int season;
    public int day;
    private static Date firstDay =new Date(118,3,10);//2018.4.11
    private static final int firstSeason = 66;
    public SeasonDay(int season, int day){
        this.season = season;
        this.day = day;
    }
    public SeasonDay(Date date){
        this.day = (int)((date.getTime() - firstDay.getTime())/86400000);
        this.season = firstSeason;
        while(this.day < 0) {
            this.day += 98;
            this.season--;
        }
        while (this.day >98) {
            this.day -= 98;
            this.season++;
        }

    }
}
