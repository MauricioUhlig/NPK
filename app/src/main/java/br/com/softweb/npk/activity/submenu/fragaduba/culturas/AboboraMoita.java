package br.com.softweb.npk.activity.submenu.fragaduba.culturas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import br.com.softweb.npk.R;
import br.com.softweb.npk.calculo.CalculoGeral;

public class AboboraMoita extends AppCompatActivity {

    private float x, y, p_meh, k_meh, sat_bases, ctc, prnt;
    private TextView X,Y,P_meh,K_meh,Sat_bases,Ctc,Prnt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abobora_moita);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
    //dimensoes
    public void preencheDim(){
        this.X = (TextView)findViewById(R.id.espa1);
        this.Y = (TextView)findViewById(R.id.espa2);
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

    public void calcularAbobRast(View v){
        preencheDim();
        preencheAnalise();
        String aduboText;

        //verificacao de vazio
        if (this.X.getText().toString().isEmpty()|| this.Y.getText().toString().isEmpty()||
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
            TextView adubo3 = (TextView) findViewById(R.id.adubo3);
            TextView densidade = (TextView) findViewById(R.id.densidade_plantas);


            //convertendo string to float
            this.x = Float.parseFloat(X.getText().toString());
            this.y = Float.parseFloat(Y.getText().toString());
            converteToFloat();
            densidade.setText(" "+(10000/(x*y))+" ");

            //calculando
            CalculoGeral calculo = new CalculoGeral();
            calculo.setAll(this.x, this.y, 0, this.p_meh, this.k_meh, 0, this.sat_bases, this.ctc, this.prnt, 80);
            superfosfato.setText(String.valueOf(calculo.SSgAbobMoita()));
            fte.setText("5");
            calagem.setText(String.valueOf(calculo.calagem()));
            trintadias.setText("15");
            sessentadias.setText("20");
            noventadias.setText("25");
            aduboText = calculo.adubo4parametros(80,150,200,280);
            adubo.setText(aduboText);
            adubo1.setText(aduboText);
            adubo2.setText(aduboText);
            adubo3.setText(aduboText);

        }


    }
}
