package com.apaza.app.moneyhelper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import im.dacer.androidcharts.BarView;

public class RegisterActivity extends AppCompatActivity {


    private EditText monto;
    private Spinner spntipo;
    private RadioButton rbtcuenta, rbtcuenta2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        monto = (EditText)findViewById(R.id.editTextMonto);
        spntipo = (Spinner)findViewById(R.id.spinnerTipo);
        rbtcuenta = (RadioButton)findViewById(R.id.radioButton);
        rbtcuenta2 = (RadioButton)findViewById(R.id.radioButton2);

    }

    public void register(View view){
        String monto2 = monto.getText().toString();
        String spntipo3 = (String)spntipo.getSelectedItem();
        int spntipo2 = spntipo.getSelectedItemPosition();
        int rbtingresar, rbtegresar;

        if(rbtcuenta.isChecked()){
            rbtingresar=1;

            Transferencias transferencias = new Transferencias(Double.parseDouble(monto2), spntipo3,rbtingresar);
            TransferenciaRepository transferenciaRepository = TransferenciaRepository.getInstance();
            transferenciaRepository.agregarTransferencia(transferencias);
            finish();

        }else if(rbtcuenta2.isChecked()){
            rbtegresar=2;

            Transferencias transferencias = new Transferencias(Double.parseDouble(monto2), spntipo3,rbtegresar);
            TransferenciaRepository transferenciaRepository = TransferenciaRepository.getInstance();
            transferenciaRepository.agregarTransferencia(transferencias);
            finish();

        }

        if(spntipo3.isEmpty() || monto2.isEmpty()){
            Toast.makeText(this, "Debes completar estos campos", Toast.LENGTH_SHORT).show();
            return;
        }

        //Intent intent =new Intent(this,MainActivity.class);
        //intent.putExtra("spntipo3",spntipo3);
        //startActivity(intent);




    }
}
