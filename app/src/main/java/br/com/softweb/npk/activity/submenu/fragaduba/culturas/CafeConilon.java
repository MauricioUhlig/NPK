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
    import br.com.softweb.npk.activity.submenu.repetentes.FragmentCafeArabicaRecepado;
    import br.com.softweb.npk.activity.submenu.repetentes.FragmentProducaoCafe;
    import br.com.softweb.npk.activity.submenu.repetentes.Fragment_PlantioCafe;
    import br.com.softweb.npk.activity.submenu.repetentes.ObservacoesCafeArabica;
    import br.com.softweb.npk.activity.submenu.repetentes.ObservacoesCafeConilon;
    import br.com.softweb.npk.activity.submenu.repetentes.Substrato;
    import br.com.softweb.npk.calculo.CalculoGeral;


    public class CafeConilon extends AppCompatActivity {
        private float x, y, z, p_meh, k_meh, mat_org, sat_bases, ctc, prnt;
        private Toolbar toolbar;
        private TabLayout tabLayout;
        private ViewPager viewPager;
        private TextView X,Y,Z,P_meh,K_meh,Mat_org,Sat_bases,Ctc,Prnt;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_cafe_arabica);

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
            adapter.addFrag(new Fragment_PlantioCafe(), getText(R.string.plantio_formacao).toString());
            adapter.addFrag(new FragmentProducaoCafe(),getText(R.string.producao).toString());
            adapter.addFrag(new ObservacoesCafeConilon(),getText(R.string.tit_obs).toString());
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
        //dimensoes
        public void preencheDim(){
            this.X = (TextView)findViewById(R.id.dim1);
            this.Y = (TextView)findViewById(R.id.dim2);
            this.Z = (TextView)findViewById(R.id.dim3);
        }
        //analise de solo
        public void preencheAnalise(){
            this.Mat_org = (TextView) findViewById(R.id.mat_org);
            this.P_meh = (TextView) findViewById(R.id.p_meh);
            this.K_meh = (TextView) findViewById(R.id.k_meh);
            this.Sat_bases = (TextView) findViewById(R.id.sat_bases);
            this.Ctc = (TextView) findViewById(R.id.ctc);
            this.Prnt = (TextView) findViewById(R.id.prnt);
        }
        public void converteToFloat(){
            this.mat_org = Float.parseFloat(Mat_org.getText().toString());
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
                    this.P_meh.getText().toString().isEmpty()|| this.K_meh.getText().toString().isEmpty()|| this.Mat_org.getText().toString().isEmpty()||
                    this.Sat_bases.getText().toString().isEmpty()|| this.Ctc.getText().toString().isEmpty()|| this.Prnt.getText().toString().isEmpty()){
                Toast.makeText(this,getText( R.string.vazio),Toast.LENGTH_SHORT).show();
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
                TextView setembro = (TextView) findViewById(R.id.setembro);
                TextView novembro = (TextView) findViewById(R.id.novembro);
                TextView janeiro = (TextView) findViewById(R.id.janeiro);
                TextView adubo = (TextView) findViewById(R.id.adubo);
                TextView adubo1 = (TextView) findViewById(R.id.adubo1);
                TextView adubo2 = (TextView) findViewById(R.id.adubo2);
                TextView adubo_setembro = (TextView) findViewById(R.id.adubo_setembro);
                TextView adubo_novembro = (TextView) findViewById(R.id.adubo_novembro);
                TextView adubo_janeiro = (TextView) findViewById(R.id.adubo_janeiro);



                //convertendo string to float
                this.x = Float.parseFloat(X.getText().toString());
                this.y = Float.parseFloat(Y.getText().toString());
                this.z = Float.parseFloat(Z.getText().toString());
                converteToFloat();

                //calculando
                CalculoGeral calculo = new CalculoGeral();
                calculo.setAll(this.x, this.y, this.z, this.p_meh, this.k_meh, this.mat_org, this.sat_bases, this.ctc, this.prnt, 60);
                esterco.setText(String.valueOf(calculo.esterco()));
                superfosfato.setText(String.valueOf(calculo.SSg()));
                calcario.setText(String.valueOf(calculo.calcarioGcovaCafe(80)));
                fte.setText("20");
                calagem.setText(String.valueOf(calculo.calagem()));
                trintadias.setText("25");
                sessentadias.setText("30");
                noventadias.setText("40");
                setembro.setText("60");
                novembro.setText("80");
                janeiro.setText("100");
                String stradubo = calculo.aduboAbacate();
                adubo.setText(stradubo);
                adubo1.setText(stradubo);
                adubo2.setText(stradubo);
                adubo_setembro.setText(stradubo);
                adubo_novembro.setText(stradubo);
                adubo_janeiro.setText(stradubo);

            }


        }

        public void calcularProducao(View v){
            this.X = (TextView) findViewById(R.id.espa1);
            this.Y = (TextView) findViewById(R.id.espa2);
            TextView densidade = (TextView) findViewById(R.id.densidade_plantas);
            this.Z = (TextView) findViewById(R.id.produtividade);
            this.P_meh = (TextView) findViewById(R.id.p_mehP);
            this.K_meh = (TextView) findViewById(R.id.k_mehP);
            this.Sat_bases = (TextView) findViewById(R.id.sat_basesP);
            this.Ctc = (TextView) findViewById(R.id.ctcP);
            this.Prnt = (TextView) findViewById(R.id.prntP);
            this.Mat_org = (TextView) findViewById(R.id.MO);
            TextView P_rem = (TextView) findViewById(R.id.p_rem);
            if (P_rem.getText().toString().isEmpty() || this.X.getText().toString().isEmpty()|| this.Y.getText().toString().isEmpty()|| this.Z.getText().toString().isEmpty()||
                    this.P_meh.getText().toString().isEmpty()|| this.K_meh.getText().toString().isEmpty()
                    ||this.Sat_bases.getText().toString().isEmpty()|| this.Ctc.getText().toString().isEmpty()|| this.Prnt.getText().toString().isEmpty()
                    || this.Mat_org.getText().toString().isEmpty()  ){
                Toast.makeText(this,getText( R.string.vazio),Toast.LENGTH_SHORT).show();
                return ;
            }
            converteToFloat();
            float p_rem= Float.parseFloat(P_rem.getText().toString());
            this.x = Float.parseFloat(X.getText().toString());
            this.y = Float.parseFloat(Y.getText().toString());
            this.z = Float.parseFloat(Z.getText().toString());
            int dens = (int) (10000/(x*y));
            densidade.setText("= "+dens+" ");
            CalculoGeral calcula = new CalculoGeral();
            calcula.setAll(this.x, this.y, this.z, this.p_meh, this.k_meh, this.mat_org, this.sat_bases, this.ctc, this.prnt, 60);

            TextView gramasCV1 = (TextView) findViewById(R.id.gramasCV1);
            TextView gramasCV1_2 = (TextView) findViewById(R.id.gramasCV1_2);
            TextView gramasCV3 = (TextView) findViewById(R.id.gramasCV3);
            TextView calagem = (TextView) findViewById(R.id.calagemP);
            TextView qtdN = (TextView) findViewById(R.id.qtd_n);
            TextView qtdP = (TextView) findViewById(R.id.qtd_p2o5);
            TextView qtdK = (TextView) findViewById(R.id.qtd_k2o);

            int qtdAdubo = (int)((((qtdN()*100)/10)/dens)*1000);
            String qtdSulfato = ""+(int)(1000*((qtdP(p_rem)*5)/dens));
            String qtdop13 = ""+ qtdAdubo/2;

            gramasCV1.setText(qtdSulfato);
            gramasCV1_2.setText(qtdop13);
            gramasCV3.setText(qtdop13);
            calagem.setText(""+calcula.calagem());
            qtdN.setText(""+(int)qtdN());
            qtdP.setText(""+(int)qtdP(p_rem));
            qtdK.setText(""+(int)qtdK());

            TextView aduboCV1 = (TextView) findViewById(R.id.aduboCV1_2);
            TextView aduboCV3 = (TextView) findViewById(R.id.aduboCV3);
            String adubo1 = ""+(int)((qtdK()*100)/((qtdN()*100)/20));
            aduboCV1.setText("20-00-"+adubo1);
            aduboCV3.setText("20-"+(int)(qtdP(p_rem)*100/((qtdN()*100)/20))+"-"+adubo1);

        }
        public double qtdN(){
            double n;
            n = this.mat_org;
            if(n > 10)n = 10;
            n = ((226.417+(2.465*this.z))-(10.975*n));
            if(n<0) n = 0;
            return n*0.9;
        }
        public double qtdP(float p_rem){
            double n;
            n = this.mat_org;
            if(n > 10)n = 10;
            n = (189+(0.537*this.z)-(8.26*this.p_meh)-(2.1*p_rem))-(2*n);
            if(n<0) n = 0;
            return n*0.8;
        }
        public double qtdK(){
            double n;
            if(this.mat_org <= 10)n = this.mat_org;
            else n = 10;
            n = (236.47+(2.381*this.z)-(1.21*this.k_meh))-(3*n);
            if(n<0) n = 0;
            return n*0.9;
        }
    }
