package android.learn.simplethread;

import android.os.AsyncTask;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;


/**
 * Created by Fajri on 06/11/2017.
 */

public class RandomTask extends AsyncTask<Void,Integer, Void> {
    private TextView tvHello1,tvHello2,tvHello3;
    ArrayList <ImageLib> listImage;
    Boolean stat1,stat2,stat3;
    int angka1,angka2,angka3;
    String prize;
    int thePrize;
    private ImageView ivSpin1,ivSpin2,ivSpin3;
    public RandomTask (ImageView ivSpin1,ImageView ivSpin2,ImageView ivSpin3){
//        this.tvHello1 = tvHello1;
//        this.tvHello2 = tvHello2;
//        this.tvHello3 = tvHello3;
        this.ivSpin1 = ivSpin1;
        this.ivSpin2 = ivSpin2;
        this.ivSpin3 = ivSpin3;
        this.listImage = new ArrayList<>();
        this.prize = "";
        this.thePrize=0;



        listImage.add(new ImageLib(1, R.drawable.asset1));
        listImage.add(new ImageLib(2, R.drawable.asset2));
        listImage.add(new ImageLib(3, R.drawable.asset3));
        listImage.add(new ImageLib(4, R.drawable.asset4));
        listImage.add(new ImageLib(5, R.drawable.asset5));
        listImage.add(new ImageLib(6, R.drawable.asset6));
        listImage.add(new ImageLib(7, R.drawable.asset7));
        listImage.add(new ImageLib(8, R.drawable.asset8));
        listImage.add(new ImageLib(9, R.drawable.asset9));

    }

    public void setPrize(String prize){
        this.prize = prize;
    }
    public String getPrize(){
        if(angka1==angka2||angka1==angka3||angka2==angka3){
            if(angka1==angka2&&angka2==angka3&&angka3==angka1){
                setPrize("Big Prize : 50 Points");
                this.thePrize = 50;
            }
            else {
                setPrize("Normal Prize : 10 Points");
                this.thePrize = 10;
            }
        }
        else{
            setPrize("You Lose");
            this.thePrize = 0;
        }
        return this.prize;
    }
    public int getThePrize(){
        return this.thePrize;
    }
    public void setStat(Boolean stat1,Boolean stat2,Boolean stat3){
        this.stat1=stat1;
        this.stat2=stat2;
        this.stat3=stat3;
    }
    @Override
    protected Void doInBackground(Void... params) {
        try{
            while(true){
                if(stat1==true){
                angka1 = (int) ((Math.random()*9));
                }
                if(stat2==true){
                    angka2 = (int) ((Math.random()*9));
                }
                if(stat3==true){
                    angka3 = (int) ((Math.random()*9));
                }
                publishProgress(angka1,angka2,angka3);

                Thread.sleep(120);
            }
        }catch (Exception ex){}
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        int angka1 = values[0];
        ivSpin1.setImageResource(listImage.get(angka1).fileLoc);
        int angka2 = values[1];
        ivSpin2.setImageResource(listImage.get(angka2).fileLoc);
        int angka3 = values[2];
        ivSpin3.setImageResource(listImage.get(angka3).fileLoc);

    }
}
