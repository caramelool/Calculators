package com.example.logonrm.calculators.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.logonrm.calculators.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class IMCFragment extends Fragment {

    Button btCalcular;
    EditText etPeso;
    EditText etAltura;
    ImageView ivImagem;
    TextView tvPeso;

    public IMCFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_imc, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btCalcular = (Button) view.findViewById(R.id.bt_calcular);
        etPeso = (EditText) view.findViewById(R.id.et_peso);
        etAltura = (EditText) view.findViewById(R.id.et_altura);
        ivImagem = (ImageView) view.findViewById(R.id.imageUser);
        tvPeso = (TextView) view.findViewById(R.id.tv_ideal);

        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double valorPeso = 0;
                double valorAltura = 0;
                if(!etPeso.getText().toString().trim().isEmpty())
                    valorPeso = Double.parseDouble(etPeso.getText().toString().trim().replace(",","."));
                if(!etAltura.getText().toString().trim().isEmpty())
                    valorAltura = Double.parseDouble(etAltura.getText().toString().trim().replace(",","."));

                double calculo = (valorPeso/(valorAltura*valorAltura));
                if (calculo > 30 ) {
                    ivImagem.setImageResource(R.drawable.obesidade);
                    tvPeso.setText("GORDO DO CARALHO!");
                } else if (calculo > 25 ) {
                    ivImagem.setImageResource(R.drawable.sobre);
                    tvPeso.setText("TA ENGORANDO VIADO");
                } else  if (calculo > 18.5) {
                    ivImagem.setImageResource(R.drawable.ideal);
                    tvPeso.setText("MULEQUE DELICIA");
                } else if (calculo > 17) {
                    ivImagem.setImageResource(R.drawable.abaixo);
                    tvPeso.setText("EITA SÓ O PÓ DA RABIOLA");
                } else {
                    ivImagem.setImageResource(R.drawable.magreza);
                    tvPeso.setText("E AI RAIO-X");

                }
            }
        });

    }
}
