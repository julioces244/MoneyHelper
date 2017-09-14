package com.apaza.app.moneyhelper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import im.dacer.androidcharts.BarView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private static final int REGISTER_FORM_REQUEST = 100;
    private TextView textViewA;
    private TextView textViewC;
    private TextView textViewE;
    private ProgressBar progressBar1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textViewA = (TextView)findViewById(R.id.textViewAhorro);
        textViewC = (TextView)findViewById(R.id.textViewCredito);
        textViewE = (TextView)findViewById(R.id.textViewEfectivo);
        progressBar1 = (ProgressBar)findViewById(R.id.progressBar);
        BarView barView = (BarView)findViewById(R.id.bar_view2);
        ArrayList<String> barview = new ArrayList<>();
        barview.add("gola");
        barview.add("gola2");
        barview.add("gola3");

        barView.setBottomTextList(barview);
        ArrayList<Integer> barview2 = new ArrayList<>();
        barview2.add(32);
        barview2.add(50);
        barview2.add(80);

        barView.setDataList(barview2,100);
    }

    public void addItem(View view){
        startActivityForResult(new Intent(this, RegisterActivity.class), REGISTER_FORM_REQUEST);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // refresh data


        TransferenciaRepository transferenciaRepository = TransferenciaRepository.getInstance();
        double acumula2=0;
        double acumulac=0;
        double acumulae=0;
        double acumulatotal=0;

        List<Transferencias> transferencias = transferenciaRepository.getTransferencia();
        for (Transferencias transferencia : transferencias) {
            Toast.makeText(this, "Transacción finalizada "+transferencia.getTipocuenta(), Toast.LENGTH_SHORT).show();


        if(transferencia.getTipotransferencia() == 1) {
            if (transferencia.getTipocuenta().equals("Ahorro")) {
                double acumula = transferencia.getMonto();
                acumula2 = acumula + acumula2;
                acumulatotal = acumula + acumulatotal;
                textViewA.setText(Double.toString(acumula2));
                int myInt = (int) acumulatotal/100;
                progressBar1.setProgress(myInt);

            } else if (transferencia.getTipocuenta().equals("Tarjeta de Credito")) {
                double acumula = transferencia.getMonto();
                acumulac = acumula + acumulac;
                acumulatotal = acumula + acumulatotal;
                textViewC.setText(Double.toString(acumulac));
                int myInt = (int) acumulatotal/100;
                progressBar1.setProgress(myInt);

            } else if (transferencia.getTipocuenta().equals("Efectivo")) {
                double acumula = transferencia.getMonto();
                acumulae = acumula + acumulae;
                acumulatotal = acumula + acumulatotal;
                textViewE.setText(Double.toString(acumulae));
                int myInt = (int) acumulatotal/100;
                progressBar1.setProgress(myInt);
            }
        }else if(transferencia.getTipotransferencia()==2){
            if (transferencia.getTipocuenta().equals("Ahorro")) {
                double acumula = transferencia.getMonto();
                acumula2 = acumula2 - acumula;
                acumulatotal = acumulatotal - acumula;
                textViewA.setText(Double.toString(acumula2));
                int myInt = (int) acumulatotal/100;
                progressBar1.setProgress(myInt);

            } else if (transferencia.getTipocuenta().equals("Tarjeta de Credito")) {
                double acumula = transferencia.getMonto();
                acumulac = acumulac - acumula;
                acumulatotal = acumulatotal - acumula;
                textViewC.setText(Double.toString(acumulac));
                int myInt = (int) acumulatotal/100;
                progressBar1.setProgress(myInt);

            } else if (transferencia.getTipocuenta().equals("Efectivo")) {
                double acumula = transferencia.getMonto();
                acumulae = acumulae - acumula;
                acumulatotal = acumulatotal - acumula;
                textViewE.setText(Double.toString(acumulae));
                int myInt = (int) acumulatotal/100;
                progressBar1.setProgress(myInt);
            }
        }
        }


    }


}
