package br.com.softweb.npk.activity.submenu.fragaduba.culturas;



import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.softweb.npk.R;

import br.com.softweb.npk.activity.submenu.fragaduba.culturas.abacate.FragmentDoisaTresAnos;
import br.com.softweb.npk.activity.submenu.fragaduba.culturas.abacate.FragmentProducao;
import br.com.softweb.npk.activity.submenu.fragaduba.culturas.abacate.FragmentUmaDoisAnos;
import br.com.softweb.npk.activity.submenu.repetentes.Substrato;
import br.com.softweb.npk.activity.submenu.repetentes.Fragment_Plantio2V70;
import br.com.softweb.npk.calculo.plantio2v70;


public class Abacate extends AppCompatActivity {
    private float x, y, z, p_meh, k_meh, mat_org, sat_bases, ctc, prnt;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abacate);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new Substrato(), getText(R.string.substrato).toString());
        adapter.addFrag(new Fragment_Plantio2V70(), getText(R.string.plantio).toString());
        adapter.addFrag(new FragmentUmaDoisAnos(),getText(R.string.umadois_anos).toString());
        adapter.addFrag(new FragmentDoisaTresAnos(),getText(R.string.doisatres_anos).toString());
        adapter.addFrag(new FragmentProducao(),getText(R.string.producao).toString());
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    public void calcularPlantio(View v){
        //dimensoes
        TextView X = (TextView)findViewById(R.id.dim1);
        TextView Y = (TextView)findViewById(R.id.dim2);
        TextView Z = (TextView)findViewById(R.id.dim3);
        //analise de solo
        TextView P_meh = (TextView)findViewById(R.id.p_meh);
        TextView K_meh = (TextView)findViewById(R.id.k_meh);
        TextView Mat_org = (TextView)findViewById(R.id.mat_org);
        TextView Sat_bases = (TextView)findViewById(R.id.sat_bases);
        TextView Ctc = (TextView)findViewById(R.id.ctc);
        TextView Prnt = (TextView)findViewById(R.id.prnt);

        //verificacao de vazio
        if (X.getText().toString().isEmpty()|| Y.getText().toString().isEmpty()|| Z.getText().toString().isEmpty()||
                P_meh.getText().toString().isEmpty()|| K_meh.getText().toString().isEmpty()|| Mat_org.getText().toString().isEmpty()||
                Sat_bases.getText().toString().isEmpty()|| Ctc.getText().toString().isEmpty()|| Prnt.getText().toString().isEmpty()){
            Toast.makeText(this,getText( R.string.vazio),Toast.LENGTH_LONG).show();
            return;
        }
        else {

            //aplicação na cova
            TextView esterco = (TextView) findViewById(R.id.esterco);
            TextView superfosfato = (TextView) findViewById(R.id.superfosfato);
            TextView calcario = (TextView) findViewById(R.id.calcario);
            TextView fte = (TextView) findViewById(R.id.fte);
            TextView calagem = (TextView) findViewById(R.id.calagem);
            //adubação após plantio
            TextView trintadias = (TextView) findViewById(R.id.trintadias);
            TextView sessentadias = (TextView) findViewById(R.id.sessentadias);
            TextView noventadias = (TextView) findViewById(R.id.noventadias);
            TextView adubo = (TextView) findViewById(R.id.adubo);
            TextView adubo1 = (TextView) findViewById(R.id.adubo1);
            TextView adubo2 = (TextView) findViewById(R.id.adubo2);


            //convertendo string to float
            this.x = Float.parseFloat(X.getText().toString());
            this.y = Float.parseFloat(Y.getText().toString());
            this.z = Float.parseFloat(Z.getText().toString());
            this.p_meh = Float.parseFloat(P_meh.getText().toString());
            this.k_meh = Float.parseFloat(K_meh.getText().toString());
            this.mat_org = Float.parseFloat(Mat_org.getText().toString());
            this.sat_bases = Float.parseFloat(Sat_bases.getText().toString());
            this.ctc = Float.parseFloat(Ctc.getText().toString());
            this.prnt = Float.parseFloat(Prnt.getText().toString());

            //calculando
            plantio2v70 calculo = new plantio2v70(this.x, this.y, this.z, this.p_meh, this.k_meh, this.mat_org, this.sat_bases, this.ctc, this.prnt);
            esterco.setText(String.valueOf(calculo.esterco()));
            superfosfato.setText(String.valueOf(calculo.SSg()));
            calcario.setText(String.valueOf(calculo.calcarioGcova()));
            fte.setText("20");
            calagem.setText(String.valueOf(calculo.calagem()));
            trintadias.setText("40");
            sessentadias.setText("50");
            noventadias.setText("60");
            adubo.setText(calculo.adubo());
            adubo1.setText(calculo.adubo());
            adubo2.setText(calculo.adubo());

        }
    }
}
