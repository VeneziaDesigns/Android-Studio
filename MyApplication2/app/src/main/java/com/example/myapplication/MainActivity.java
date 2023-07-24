package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.VoiceInteractor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

        int num1;
        int num2;
        int op;
        TextView resultado;



    View.OnClickListener pulsar = new View.OnClickListener() {
        @Override


        public void onClick(View view) {

            String anterior = String.valueOf(resultado.getText());

            switch (view.getId()) {

                case R.id.button1:
                    resultado.setText(anterior + "1");
                    break;

                case R.id.button2:
                    resultado.setText(anterior + "2");
                    break;

                case R.id.button3:
                    resultado.setText(anterior + "3");
                    break;

                case R.id.button4:
                    resultado.setText(anterior + "4");
                    break;

                case R.id.button5:
                    resultado.setText(anterior + "5");
                    break;

                case R.id.button6:
                    resultado.setText(anterior + "6");
                    break;

                case R.id.button7:
                    resultado.setText(anterior + "7");
                    break;

                case R.id.button8:
                    resultado.setText(anterior +"8");
                    break;

                case R.id.button9:
                    resultado.setText(anterior + "9");
                    break;

                case R.id.button0:
                    resultado.setText(anterior + "0");
                    break;

                case R.id.buttonC:
                    resultado.setText("");
                    break;

                case R.id.buttonCe:
                 String nueva = anterior.substring(0,anterior.length()-1);
                    resultado.setText(nueva);
                    break;

                case R.id.suma:
                    num1 = Integer.parseInt(String.valueOf(resultado.getText()));
                    op = 1;
                    resultado.setText("");
                    break;

                case R.id.resta:
                    num1 = Integer.parseInt(String.valueOf(resultado.getText()));
                    op = 2;
                    resultado.setText("");
                    break;

                case R.id.multiplicacion:
                    num1 = Integer.parseInt(String.valueOf(resultado.getText()));
                    op = 3;
                    resultado.setText("");
                    break;

                case R.id.division:
                    num1 = Integer.parseInt(String.valueOf(resultado.getText()));
                    op = 4;
                    resultado.setText("");
                    break;

                    case R.id.igual:
                    num2 = Integer.parseInt(String.valueOf(resultado.getText()));
                    operacion(num1,num2,op);
                    break;




            }
        }
    };




    public void operacion (int op1,int op2,int op) {

        int resultados;

        switch (op) {
            case 1:
                resultados = num1 + num2;
                resultado.setText(String.valueOf(resultados));
                break;

            case 2:
                resultados = num1 - num2;
                resultado.setText(String.valueOf(resultados));
                break;

            case 3:
                resultados = num1 * num2;
                resultado.setText(String.valueOf(resultados));
                break;

            case 4:
                resultados = num1 / num2;
                resultado.setText(String.valueOf(resultados));
                break;

        }


        }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(pulsar);

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(pulsar);

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(pulsar);

        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(pulsar);

        Button button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(pulsar);

        Button button6 = (Button) findViewById(R.id.button6);
        button6.setOnClickListener(pulsar);

        Button button7 = (Button) findViewById(R.id.button7);
        button7.setOnClickListener(pulsar);

        Button button8 = (Button) findViewById(R.id.button8);
        button8.setOnClickListener(pulsar);

        Button button9 = (Button) findViewById(R.id.button9);
        button9.setOnClickListener(pulsar);

        Button button0 = (Button) findViewById(R.id.button0);
        button0.setOnClickListener(pulsar);

        Button buttonC = (Button) findViewById(R.id.buttonC);
        buttonC.setOnClickListener(pulsar);

        Button buttonCe = (Button) findViewById(R.id.buttonCe);
        buttonCe.setOnClickListener(pulsar);

        Button igual = (Button) findViewById(R.id.igual);
        igual.setOnClickListener(pulsar);

        Button suma = (Button) findViewById(R.id.suma);
        suma.setOnClickListener(pulsar);

        Button resta = (Button) findViewById(R.id.resta);
        resta.setOnClickListener(pulsar);

        Button multiplicacion = (Button) findViewById(R.id.multiplicacion);
        multiplicacion.setOnClickListener(pulsar);

        Button division = (Button) findViewById(R.id.division);
        division.setOnClickListener(pulsar);

        resultado = (TextView) findViewById(R.id.resultado);
    }
}