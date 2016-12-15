package br.com.softweb.npk.activity.submenu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import br.com.softweb.npk.R;


public class RecomendacaoMicronutrientes extends AppCompatActivity {
    private float extrBCx;
    private float extrCuCx;
    private float extrMnCx;
    private float extrZnCx;
    private float soloBCx;
    private float soloCuCx;
    private float soloMnCx;
    private float soloZnCx;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recomendacao_micronutrientes);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void calcularMicronutrientes(View v) {
        doseZn();
        doseB();
        doseCu();
        doseMn();
    }

    public void doseZn() {
        TextView edtTexto = (TextView) findViewById(R.id.lbl_doseZn);
        TextView edtTexto1 = (TextView) findViewById(R.id.extrZnCx);
        TextView edtTexto5 = (TextView) findViewById(R.id.soloZnCx);
        if (edtTexto1.getText().toString().isEmpty() || edtTexto5.getText().toString().isEmpty()) {
            edtTexto.setText("Inválido");
            return;
        }
        this.extrZnCx = Float.parseFloat(edtTexto1.getText().toString());
        this.soloZnCx = Float.parseFloat(edtTexto5.getText().toString());
        if (this.extrZnCx == 1.0f) {
            if (this.soloZnCx < 2.0f) {
                edtTexto.setText(Float.toString(6.0f));
            } else if (this.soloZnCx >= 2.0f && this.soloZnCx < 4.0f) {
                edtTexto.setText(Float.toString(4.0f));
            } else if (this.soloZnCx < 4.0f || this.soloZnCx >= 6.0f) {
                edtTexto.setText(Float.toString(0.0f));
            } else {
                edtTexto.setText(Float.toString(2.0f));
            }
        } else if (this.extrZnCx != 2.0f) {
            edtTexto.setText("Inválido");
        } else if (( this.soloZnCx) < 0.7d) {
            edtTexto.setText(Float.toString(6.0f));
        } else if (( this.soloZnCx) >= 0.7d && (this.soloZnCx) < 1.1d) {
            edtTexto.setText(Float.toString(4.0f));
        } else if (( this.soloZnCx) < 1.1d || (this.soloZnCx) >= 1.5d) {
            edtTexto.setText(Float.toString(0.0f));
        } else {
            edtTexto.setText(Float.toString(2.0f));
        }
    }

    public void doseB() {
        TextView edtTexto = (TextView) findViewById(R.id.lbl_doseB);
        TextView edtTexto2 = (TextView) findViewById(R.id.extrBCx);
        TextView edtTexto6 = (TextView) findViewById(R.id.soloBCx);
        if (edtTexto2.getText().toString().isEmpty() || edtTexto6.getText().toString().isEmpty()) {
            edtTexto.setText("Inválido");
            return;
        }
        this.soloBCx = Float.parseFloat(edtTexto6.getText().toString());
        this.extrBCx = Float.parseFloat(edtTexto2.getText().toString());
        if (this.extrBCx == 1.0f) {
            if (( this.soloBCx) < 0.3d) {
                edtTexto.setText(Float.toString(3.0f));
            } else if (( this.soloBCx) >= 0.3d && ( this.soloBCx) < 0.7d) {
                edtTexto.setText(Float.toString(2.0f));
            } else if (( this.soloBCx) < 0.7d || this.soloBCx >= 1.0f) {
                edtTexto.setText(Float.toString(0.0f));
            } else {
                edtTexto.setText(Float.toString(1.0f));
            }
        } else if (this.extrBCx != 3.0f) {
        } else {
            if (( this.soloBCx) < 0.2d) {
                edtTexto.setText(Float.toString(3.0f));
            } else if (( this.soloBCx) >= 0.2d && ( this.soloBCx) < 0.4d) {
                edtTexto.setText(Float.toString(2.0f));
            } else if (( this.soloBCx) < 0.4d || ( this.soloBCx) >= 0.6d) {
                edtTexto.setText(Float.toString(0.0f));
            } else {
                edtTexto.setText(Float.toString(1.0f));
            }
        }
    }

    public void doseCu() {
        TextView edtTexto3 = (TextView) findViewById(R.id.extrCuCx);
        TextView edtTexto = (TextView) findViewById(R.id.lbl_doseCu);
        TextView edtTexto7 = (TextView) findViewById(R.id.soloCuCx);
        if (edtTexto3.getText().toString().isEmpty() || edtTexto7.getText().toString().isEmpty()) {
            edtTexto.setText("Inválido");
            return;
        }
        this.soloCuCx = Float.parseFloat(edtTexto7.getText().toString());
        this.extrCuCx = Float.parseFloat(edtTexto3.getText().toString());
        if (this.extrCuCx == 1.0f) {
            if (( this.soloCuCx) < 0.5d) {
                edtTexto.setText(Float.toString(3.0f));
            } else if (( this.soloCuCx) >= 0.5d && this.soloCuCx < 1.0f) {
                edtTexto.setText(Float.toString(2.0f));
            } else if (this.soloCuCx < 1.0f || ( this.soloCuCx) >= 1.5d) {
                edtTexto.setText(Float.toString(0.0f));
            } else {
                edtTexto.setText(Float.toString(1.0f));
            }
        } else if (this.extrCuCx != 2.0f) {
            edtTexto.setText("Inválido");
        } else if (( this.soloCuCx) < 0.3d) {
            edtTexto.setText(Float.toString(3.0f));
        } else if (( this.soloCuCx) >= 0.3d && ( this.soloCuCx) < 0.6d) {
            edtTexto.setText(Float.toString(2.0f));
        } else if (( this.soloCuCx) < 0.6d || this.soloCuCx >= 1.0f) {
            edtTexto.setText(Float.toString(0.0f));
        } else {
            edtTexto.setText(Float.toString(1.0f));
        }
    }

    public void doseMn() {
        TextView edtTexto4 = (TextView) findViewById(R.id.extrMnCx);
        TextView edtTexto8 = (TextView) findViewById(R.id.soloMnCx);
        TextView edtTexto = (TextView) findViewById(R.id.lbl_doseMn);
        if (edtTexto4.getText().toString().isEmpty() || edtTexto8.getText().toString().isEmpty()) {
            edtTexto.setText("Inválido");
            return;
        }
        this.extrMnCx = Float.parseFloat(edtTexto4.getText().toString());
        this.soloMnCx = Float.parseFloat(edtTexto8.getText().toString());
        if (this.extrMnCx == 1.0f) {
            if (this.soloMnCx < 5.0f) {
                edtTexto.setText(Float.toString(15.0f));
            } else if (this.soloMnCx >= 5.0f && this.soloMnCx < 10.0f) {
                edtTexto.setText(Float.toString(10.0f));
            } else if (this.soloMnCx < 10.0f || this.soloMnCx >= 15.0f) {
                edtTexto.setText(Float.toString(0.0f));
            } else {
                edtTexto.setText(Float.toString(5.0f));
            }
        } else if (this.extrMnCx != 2.0f) {
            edtTexto.setText("Inválido");
        } else if (this.soloMnCx < 1.0f) {
            edtTexto.setText(Float.toString(15.0f));
        } else if (this.soloCuCx >= 1.0f && ( this.soloCuCx) < 2.5d) {
            edtTexto.setText(Float.toString(10.0f));
        } else if (( this.soloCuCx) < 2.5d || this.soloCuCx >= 5.0f) {
            edtTexto.setText(Float.toString(0.0f));
        } else {
            edtTexto.setText(Float.toString(5.0f));
        }
    }
}
