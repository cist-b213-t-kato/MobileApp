package jp.wings.nikkeibp.omikuji;

/**
 * Created by Etude on 2015/12/05.
 */
public enum Result{
    DAIKICHI("大吉", R.drawable.result1),
    CHUKICHI("中吉", R.drawable.result1),
    KICHI("吉", R.drawable.result2),
    KYO("凶", R.drawable.result3),
    DAIKYO("大凶", R.drawable.result3);
    public final String label;
    public final int type;
    private Result(String l, int r){
        label = l;
        type = r;
    }
};
