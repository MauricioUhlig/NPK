package br.com.softweb.npk.activity.submenu.fragaduba.culturas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import br.com.softweb.npk.R;
import br.com.softweb.npk.calculo.CalculoGeral;

public class ArrozSequeiro extends AppCompatActivity {

    private float x, p_meh, k_meh, sat_bases, ctc, prnt;
    private TextView X,P_meh,K_meh,Sat_bases,Ctc,Prnt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arroz_sequeiro);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
    //dimensoes
    public void preencheDim(){
        this.X = (TextView)findViewById(R.id.espa1);
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
        if (this.X.getText().toString().isEmpty()||
                this.P_meh.getText().toString().isEmpty()|| this.K_meh.getText().toString().isEmpty()||
                this.Sat_bases.getText().toString().isEmpty()|| this.Ctc.getText().toString().isEmpty()|| this.Prnt.getText().toString().isEmpty()){
            Toast.makeText(this,getText( R.string.vazio),Toast.LENGTH_SHORT).show();
            return;
        }
        else {

            //aplicação na cova
            TextView superfosfato = (TextView) findViewById(R.id.superfosfato);
            TextView fte = (TextView) findViewById(R.id.fte);
            TextView calagem = (TextView) findViewById(R.id.calagemf12);
            //adubação após plantio
            TextView trintadias = (TextView) findViewById(R.id.trintadias);
          //  TextView sessentadias = (TextView) findViewById(R.id.sessentadias);
            TextView adubo_plantio = (TextView) findViewById(R.id.adubo_plantio);
            TextView adubo = (TextView) findViewById(R.id.adubo);
            TextView adubo1 = (TextView) findViewById(R.id.adubo1);
           // TextView adubo2 = (TextView) findViewById(R.id.adubo2);



            //convertendo string to float
            this.x = Float.parseFloat(X.getText().toString());
            converteToFloat();

            //calculando
            CalculoGeral calculo = new CalculoGeral();
            calculo.setAll(this.x, 0, 0, this.p_meh, this.k_meh, 0, this.sat_bases, this.ctc, this.prnt, 60 );
            adubo_plantio.setText(""+(calculo.qtdArroz(75)*0.33));
            superfosfato.setText(String.valueOf(calculo.SSgArrozSequeiro()));
            fte.setText(""+((40/calculo.densidadeArroz())*1000));
            calagem.setText(String.valueOf(calculo.calagem()));
            trintadias.setText(""+(calculo.qtdArroz(75)*0.66));
            aduboText = calculo.adubo4parametros(0,60,60,200);
            adubo.setText(aduboText);
            adubo1.setText(aduboText);

        }


    }
}
