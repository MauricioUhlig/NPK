package br.com.softweb.npk.activity.submenu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import br.com.softweb.npk.R;


public class RecomendacaoGesso extends AppCompatActivity {
    private float gessoAlCx;
    private float gessoCaCx;
    private float gessoHAlCx;
    private float gessoKCx;
    private float gessoMgCx;
    private float resultado;


    public RecomendacaoGesso() {
        this.resultado = 0.0f;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_recomendacao_gesso);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    public void calcularGessagem(View v) {
        TextView gessoK = (TextView) findViewById(R.id.gessoKCx);
        TextView gessoCa = (TextView) findViewById(R.id.gessoCaCx);
        TextView gessoMg = (TextView) findViewById(R.id.gessoMgCx);
        TextView gessoAl = (TextView) findViewById(R.id.gessoAlCx);
        TextView gessoH = (TextView) findViewById(R.id.gessoHAlCx);
        TextView lbl_gesso = (TextView) findViewById(R.id.lbl_gesso);
        if (gessoK.getText().toString().isEmpty() || gessoCa.getText().toString().isEmpty() || gessoMg.getText().toString().isEmpty() || gessoAl.getText().toString().isEmpty() || gessoH.getText().toString().isEmpty()) {
            Toast.makeText(this,getText( R.string.vazio),Toast.LENGTH_LONG).show();
            return;
        }
        this.gessoKCx = Float.parseFloat(gessoK.getText().toString());
        this.gessoCaCx = Float.parseFloat(gessoCa.getText().toString());
        this.gessoMgCx = Float.parseFloat(gessoMg.getText().toString());
        this.gessoAlCx = Float.parseFloat(gessoAl.getText().toString());
        this.gessoHAlCx = Float.parseFloat(gessoH.getText().toString());
        float gesso = (float) ((((double) ((((((this.gessoKCx / 390.0f) + this.gessoCaCx) + this.gessoMgCx) + this.gessoHAlCx)
                * (60.0f - (((((this.gessoKCx / 390.0f) + this.gessoCaCx) + this.gessoMgCx) /
                ((((this.gessoKCx / 390.0f) + this.gessoCaCx) + this.gessoMgCx) + this.gessoHAlCx))
                * 100.0f))) / 100.0f)) * 0.3d) * 1000.0d);
        if (((double) this.gessoCaCx) < 0.5d || ((double) this.gessoAlCx) > 0.5d) {
            lbl_gesso.setText(Float.toString(gesso));
        } else {
            lbl_gesso.setText(Float.toString(0.0f));
        }
    }

}
