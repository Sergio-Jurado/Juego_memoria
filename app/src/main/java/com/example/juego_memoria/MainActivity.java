package com.example.juego_memoria;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    int cartas[]={R.drawable.azul, R.drawable.amarillo, R.drawable.gris, R.drawable.negro, R.drawable.rojo, R.drawable.rosa};

    Integer[] idCarta = {0,0,1,1,2,2,3,3,4,4,5,5};

    int contador = 0;
    int val;
    int control =-1;
    Bitmap bmp;
    boolean b = true;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniciar();
    }

    public void iniciar(){
        List<Integer> list = Arrays.asList(idCarta);
        Collections.shuffle(list);
        list.toArray(idCarta);

        ImageView c1 = findViewById(R.id.carta1);
        ImageView c2 = findViewById(R.id.carta2);
        ImageView c3 = findViewById(R.id.carta3);
        ImageView c4 = findViewById(R.id.carta4);
        ImageView c5 = findViewById(R.id.carta5);
        ImageView c6 = findViewById(R.id.carta6);
        ImageView c7 = findViewById(R.id.carta7);
        ImageView c8 = findViewById(R.id.carta8);
        ImageView c9 = findViewById(R.id.carta9);
        ImageView c10 = findViewById(R.id.carta10);
        ImageView c11 = findViewById(R.id.carta11);
        ImageView c12 = findViewById(R.id.carta12);

        c1.setImageResource(R.drawable.back);
        c2.setImageResource(R.drawable.back);
        c3.setImageResource(R.drawable.back);
        c4.setImageResource(R.drawable.back);
        c5.setImageResource(R.drawable.back);
        c6.setImageResource(R.drawable.back);
        c7.setImageResource(R.drawable.back);
        c8.setImageResource(R.drawable.back);
        c9.setImageResource(R.drawable.back);
        c10.setImageResource(R.drawable.back);
        c11.setImageResource(R.drawable.back);
        c12.setImageResource(R.drawable.back);

        c1.setEnabled(true);
        c2.setEnabled(true);
        c3.setEnabled(true);
        c4.setEnabled(true);
        c5.setEnabled(true);
        c6.setEnabled(true);
        c7.setEnabled(true);
        c8.setEnabled(true);
        c9.setEnabled(true);
        c10.setEnabled(true);
        c11.setEnabled(true);
        c12.setEnabled(true);
    }

    public void vuelta1(View vista){
        if(b){
            val=R.id.carta1;
        }
        ImageView c1 = findViewById(R.id.carta1);
        controlador(idCarta[0],c1);
    }

    public void vuelta2(View vista){
        if(b){
            val=R.id.carta2;
        }
        ImageView c2 = findViewById(R.id.carta2);
        controlador(idCarta[1],c2);
    }
    public void vuelta3(View vista){
        if(b){
            val=R.id.carta3;
        }
        ImageView c3 = findViewById(R.id.carta3);
        controlador(idCarta[2],c3);
    }
    public void vuelta4(View vista){
        if(b){
            val=R.id.carta4;
        }
        ImageView c4 = findViewById(R.id.carta4);
        controlador(idCarta[3],c4);
    }
    public void vuelta5(View vista){
        if(b){
            val=R.id.carta5;
        }
        ImageView c5 = findViewById(R.id.carta5);
        controlador(idCarta[4],c5);
    }
    public void vuelta6(View vista){
        if(b){
            val=R.id.carta6;
        }
        ImageView c6 = findViewById(R.id.carta6);
        controlador(idCarta[5],c6);
    }
    public void vuelta7(View vista){
        if(b){
            val=R.id.carta7;
        }
        ImageView c7 = findViewById(R.id.carta7);
        controlador(idCarta[6],c7);
    }
    public void vuelta8(View vista){
        if(b){
            val=R.id.carta8;
        }
        ImageView c8 = findViewById(R.id.carta8);
        controlador(idCarta[7],c8);
    }
    public void vuelta9(View vista){
        if(b){
            val=R.id.carta9;
        }
        ImageView c9 = findViewById(R.id.carta9);
        controlador(idCarta[8],c9);
    }
    public void vuelta10(View vista){
        if(b){
            val=R.id.carta10;
        }
        ImageView c10 = findViewById(R.id.carta10);
        controlador(idCarta[9],c10);
    }
    public void vuelta11(View vista){
        if(b){
            val=R.id.carta11;
        }
        ImageView c11 = findViewById(R.id.carta11);
        controlador(idCarta[10],c11);
    }
    public void vuelta12(View vista){
        if(b){
            val=R.id.carta12;
        }
        ImageView c12 = findViewById(R.id.carta12);
        controlador(idCarta[11],c12);
    }

    private void controlador(int i, final ImageView img){
        final ImageView p = findViewById(val);

        bmp = null;
        switch (i){
            case 0:
                bmp = BitmapFactory.decodeResource(getResources(), R.drawable.azul);
            break;

            case 1:
                bmp = BitmapFactory.decodeResource(getResources(), R.drawable.amarillo);
            break;

            case 2:
                bmp = BitmapFactory.decodeResource(getResources(), R.drawable.gris);
            break;

            case 3:
                bmp = BitmapFactory.decodeResource(getResources(), R.drawable.rojo);
            break;

            case 4:
                bmp = BitmapFactory.decodeResource(getResources(), R.drawable.negro);
            break;

            case 5:
                bmp = BitmapFactory.decodeResource(getResources(), R.drawable.rosa);
            break;
        }

        if(control == -1){
            control = i;
            img.setImageBitmap(bmp);
            img.setEnabled(false);
            b= false;
        }else{
            if(control == i){
                img.setImageBitmap(bmp);
                img.setEnabled(false);
                control = -1;
                b= true;
                Toast.makeText(this, "bien", Toast.LENGTH_LONG).show();
                contador++;
            }else{
                b  = true;
                control = -1;

                new CountDownTimer(2000,1000){
                    @Override
                    public void onTick(long arg0){
                        img.setImageBitmap(bmp);
                    }

                    @Override
                    public void onFinish(){
                        p.setImageResource(R.drawable.back);
                        img.setImageResource(R.drawable.back);
                        p.setEnabled(true);
                        img.setEnabled(true);
                    }
                }.start();
                Toast.makeText(this, "Mal", Toast.LENGTH_LONG).show();
            }
        }

        if (contador == 6){
            Toast.makeText(this, "Así me gusta", Toast.LENGTH_LONG).show();
            new CountDownTimer(3000,1000){

                @Override
                public void onTick(long arg0){

                }

                @Override
                public void onFinish(){
                    iniciar();
                }
            }.start();
        }
    }

}