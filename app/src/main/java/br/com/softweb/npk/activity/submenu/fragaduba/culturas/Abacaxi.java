package br.com.softweb.npk.activity.submenu.fragaduba.culturas;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import br.com.softweb.npk.R;
import br.com.softweb.npk.calculo.CalculoGeral;

public class Abacaxi extends AppCompatActivity {
    private float x, y, z, p_meh, k_meh, sat_bases, ctc, prnt;
    private TextView X,Y,Z,P_meh,K_meh,Sat_bases,Ctc,Prnt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abacaxi);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    //dimensoes
    public void preencheDim(){
        this.X = (TextView)findViewById(R.id.dim1);
        this.Y = (TextView)findViewById(R.id.dim2);
        this.Z = (TextView)findViewById(R.id.dim3);
    }
    //analise de solo
    public void preencheAnalise(){

        this.P_meh = (TextView) findViewById(R.id.p_meh);
        this.K_meh = (TextView) findViewById(R.id.k_meh);
        this.Sat_bases = (TextView) findViewById(R.id.sat_bases);
        this.Ctc = (TextView) findViewById(R.id.ctc);
        this.Prnt = (TextView) findViewById(R.id.prnt);
    }
    public void converteToFloat(){
        this.p_meh = Float.parseFloat(P_meh.getText().toString());
        this.k_meh = Float.parseFloat(K_meh.getText().toString());
        this.sat_bases = Float.parseFloat(Sat_bases.getText().toString());
        this.ctc = Float.parseFloat(Ctc.getText().toString());
        this.prnt = Float.parseFloat(Prnt.getText().toString());
    }

    public void calcularPlantio(View v){
        preencheDim();
        preencheAnalise();

        //verificacao de vazio
        if (this.X.getText().toString().isEmpty()|| this.Y.getText().toString().isEmpty()|| this.Z.getText().toString().isEmpty()||
                this.P_meh.getText().toString().isEmpty()|| this.K_meh.getText().toString().isEmpty()||
                this.Sat_bases.getText().toString().isEmpty()|| this.Ctc.getText().toString().isEmpty()|| this.Prnt.getText().toString().isEmpty()){
            Toast.makeText(this,getText( R.string.vazio),Toast.LENGTH_LONG).show();
            return;
        }
        else {

            //aplicação na cova
            TextView superfosfato = (TextView) findViewById(R.id.superfosfato);
            TextView fte = (TextView) findViewById(R.id.fte);
            TextView calagem = (TextView) findViewById(R.id.calagemf12);
            //adubação após plantio
            TextView trintadias = (TextView) findViewById(R.id.trintadias);
            TextView sessentadias = (TextView) findViewById(R.id.sessentadias);
            TextView noventadias = (TextView) findViewById(R.id.noventadias);
            TextView adubo = (TextView) findViewById(R.id.adubo);
            TextView adubo1 = (TextView) findViewById(R.id.adubo1);
            TextView adubo2 = (TextView) findViewById(R.id.adubo2);
            TextView densidade = (TextView) findViewById(R.id.densidade_plantas);


            //convertendo string to float
            this.x = Float.parseFloat(X.getText().toString());
            this.y = Float.parseFloat(Y.getText().toString());
            this.z = Float.parseFloat(Z.getText().toString());
            converteToFloat();
            densidade.setText(" "+(10000/(((x+y)*z)/2))+" ");

            //calculando
            CalculoGeral calculo = new CalculoGeral();
            calculo.setAll(this.x, this.y, this.z, this.p_meh, this.k_meh, 0, this.sat_bases, this.ctc, this.prnt, 60);
            superfosfato.setText(String.valueOf(5*calculo.SSgAbacaxi()));
            fte.setText("2");
            calagem.setText(String.valueOf(calculo.calagem()));
            trintadias.setText("20");
            sessentadias.setText("25");
            noventadias.setText("30");
            adubo.setText(calculo.adubo4parametros(60,120,200,280));
            adubo1.setText(calculo.adubo4parametros(60,120,200,280));
            adubo2.setText(calculo.adubo4parametros(60,120,200,280));

        }


    }
}
