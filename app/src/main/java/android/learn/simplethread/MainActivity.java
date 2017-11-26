package android.learn.simplethread;

import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btStartStop;
    private TextView tvHello1,tvHello2,tvHello3;
    private int angka;
    private Handler handler = new Handler();
    private ImageView ivSpin1,ivSpin2,ivSpin3;
    private TextView tvScore;
    private TextView winInfo;
    private ImageView sign1,sign2,sign3;
    int score =0;

//    private Runnable uiRunnable = new Runnable(){
//
//        @Override
//        public void run() {
//            tvHello.setText(angka + "");
//        }
//    };
//    private Runnable bgRunnable = new Runnable() {
//        @Override
//        public void run() {
//            try {
//                while(true){
//                    angka=(int)(Math.random()*10);
//                    Thread.sleep(100);
//                    handler.post(uiRunnable);
//
//                }
//            } catch (Exception e) {}
//        }
//    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.btStartStop = (Button) this.findViewById(R.id.btStartStop);
        this.ivSpin1 = (ImageView) this.findViewById(R.id.imageOne);
        this.ivSpin2 = (ImageView) this.findViewById(R.id.imageTwo);
        this.ivSpin3 = (ImageView) this.findViewById(R.id.imageThree);
        this.tvScore = (TextView) this.findViewById(R.id.tvScore);
        this.winInfo =(TextView) this.findViewById(R.id.winInfo);
        this.sign1 =(ImageView) this.findViewById(R.id.sign1);
        this.sign2 =(ImageView) this.findViewById(R.id.sign2);
        this.sign3 =(ImageView) this.findViewById(R.id.sign3);
        this.btStartStop.setOnClickListener(this);
        score=0;
    }

    Thread t;
    RandomTask randomTask1,randomTask2,randomTask3;

    @Override
    public void onClick(View v) {
        if(randomTask1==null || randomTask1.getStatus()== AsyncTask.Status.FINISHED){
            randomTask1 = new RandomTask(this.ivSpin1,this.ivSpin2,this.ivSpin3);
            randomTask1.setStat(true,true,true);
            randomTask1.execute();
            this.btStartStop.setText("Stop (3)");
            this.winInfo.setVisibility(View.INVISIBLE);
            this.sign2.setVisibility(View.INVISIBLE);
            this.sign3.setVisibility(View.INVISIBLE);
            this.sign1.setVisibility(View.VISIBLE);

        }

        else if(randomTask1.stat1==true&&randomTask1.stat2==true&&randomTask1.stat3==true){
            randomTask1.setStat(false,true,true);
            this.btStartStop.setText("Stop (2)");
            this.sign1.setVisibility(View.INVISIBLE);
            this.sign3.setVisibility(View.INVISIBLE);
            this.sign2.setVisibility(View.VISIBLE);
        }
        else if(randomTask1.stat1==false&&randomTask1.stat2==true&&randomTask1.stat3==true){
            randomTask1.setStat(false,false,true);
            this.btStartStop.setText("Stop (1)");
            this.sign1.setVisibility(View.INVISIBLE);
            this.sign2.setVisibility(View.INVISIBLE);
            this.sign3.setVisibility(View.VISIBLE);
        }
        else if(randomTask1.stat1==false&&randomTask1.stat2==false&&randomTask1.stat3==true){
            randomTask1.setStat(false,false,false);
            randomTask1.cancel(true);
            this.winInfo.setText(randomTask1.getPrize());
            this.score+=randomTask1.getThePrize();
            this.winInfo.setVisibility(View.VISIBLE);
            this.tvScore.setText(this.score+"");
            this.sign1.setVisibility(View.VISIBLE);
            this.sign3.setVisibility(View.VISIBLE);
            this.sign2.setVisibility(View.VISIBLE);
            this.btStartStop.setText("  Start  ");
        }


//ini untuk thread biasa
//        if(t==null|| !t.isAlive()) {
//            t = new Thread(bgRunnable);
//            t.start();
//        }else if (t.isAlive()){
//            t.interrupt();
//        }
    }
}
