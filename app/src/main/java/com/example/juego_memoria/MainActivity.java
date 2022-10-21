package com.example.juego_memoria;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.Collections;


public class MainActivity extends AppCompatActivity {
    ImageButton carta1, carta2, carta3, carta4, carta5, carta6, carta7, carta8;


    int imagenes[];
    ImageButton [] botonera = new ImageButton[8];

    int fondo;


    ArrayList<Integer> arrayBarajado;

    ImageButton primero;
    int numeroPrimero, numeroSegundo;

    boolean bloqueo = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cargarImagenes();
        iniciar();
    }

    public void cargarImagenes(){
        imagenes = new int[]{
                R.drawable.opcion1,
                R.drawable.opcion2,
                R.drawable.opcion3,
                R.drawable.opcion4,
        };

        fondo = R.drawable.back;
    }

    public ArrayList<Integer> barajar(int longitud) {
        ArrayList resultadoA = new ArrayList<Integer>();
        for(int i=0; i<longitud; i++)
            resultadoA.add(i % longitud/2);
        Collections.shuffle(resultadoA);
        return  resultadoA;
    }

    public void cargarBotones(){
        carta1 = (ImageButton) findViewById(R.id.carta1);
        botonera[0] = carta1;
        carta2 = (ImageButton) findViewById(R.id.carta2);
        botonera[1] = carta2;
        carta3 = (ImageButton) findViewById(R.id.carta3);
        botonera[3] = carta3;
        carta4 = (ImageButton) findViewById(R.id.carta4);
        botonera[4] = carta4;
        carta5 = (ImageButton) findViewById(R.id.carta5);
        botonera[5] = carta5;
        carta6 = (ImageButton) findViewById(R.id.carta6);
        botonera[6] = carta6;
        carta7 = (ImageButton) findViewById(R.id.carta7);
        botonera[7] = carta7;
        carta8 = (ImageButton) findViewById(R.id.carta8);
        botonera[8] = carta8;

    }
    public void comprobar(int i, final ImageButton imgb){
        if(primero==null){
            primero = imgb;

            primero.setScaleType(ImageView.ScaleType.CENTER_CROP);
            primero.setImageResource(imagenes[arrayBarajado.get(i)]);
            primero.setEnabled(false);

            numeroPrimero=arrayBarajado.get(i);
        }else{
            bloqueo=true;
            imgb.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imgb.setImageResource(imagenes[arrayBarajado.get(i)]);
            imgb.setEnabled(false);
            numeroSegundo=arrayBarajado.get(i);
            if(numeroPrimero==numeroSegundo){
                primero=null;
                bloqueo=false;

            }else{
                primero.setScaleType(ImageView.ScaleType.CENTER_CROP);
                primero.setImageResource(R.drawable.back);
                imgb.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imgb.setImageResource(R.drawable.back);
                primero.setEnabled(true);
                imgb.setEnabled(true);
                primero = null;
                bloqueo = false;
                }
            }
        }

    public void iniciar(){
        arrayBarajado = barajar(imagenes.length*2);
        cargarBotones();

        for(int i=0; i<botonera.length; i++) {
            botonera[i].setScaleType(ImageView.ScaleType.CENTER_CROP);
            botonera[i].setImageResource(imagenes[arrayBarajado.get(i)]);
        }


        for(int i=0; i <arrayBarajado.size(); i++){
            final int j=i;
            botonera[i].setEnabled(true);
            botonera[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(!bloqueo)
                        comprobar(j, botonera[j]);
                }
            });
        }
    }
}