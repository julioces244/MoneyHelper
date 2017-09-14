package com.apaza.app.moneyhelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alumno on 11/09/2017.
 */

public class TransferenciaRepository {

    private static TransferenciaRepository _INSTANCE = null;

    private TransferenciaRepository(){}

    public static TransferenciaRepository getInstance(){
        if(_INSTANCE == null)
            _INSTANCE = new TransferenciaRepository();
        return _INSTANCE;
    }

    private List<Transferencias> transferencia = new ArrayList<>();

    public List<Transferencias> getTransferencia() {
        return this.transferencia;
    }

    public void agregarTransferencia(Transferencias transferencia){
        this.transferencia.add(transferencia);
    }

}
