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
    import br.com.softweb.npk.activity.submenu.repetentes.FragmentDoisaTresAnos;
    import br.com.softweb.npk.activity.submenu.repetentes.FragmentProducao;
    import br.com.softweb.npk.activity.submenu.repetentes.FragmentProducaoBanana;
    import br.com.softweb.npk.activity.submenu.repetentes.FragmentUmaDoisAnos;
    import br.com.softweb.npk.activity.submenu.repetentes.Fragment_Plantio2V70;
    import br.com.softweb.npk.activity.submenu.repetentes.Fragment_PlantioBanana;
    import br.com.softweb.npk.activity.submenu.repetentes.Observacoes;
    import br.com.softweb.npk.activity.submenu.repetentes.ObservacoesBanana;
    import br.com.softweb.npk.activity.submenu.repetentes.Substrato;
    import br.com.softweb.npk.calculo.CalculoGeral;


    public class Banana extends AppCompatActivity {
        private float x, y, z, p_meh, k_meh, mat_org, sat_bases, ctc, prnt;
        private Toolbar toolbar;
        private TabLayout tabLayout;
        private ViewPager viewPager;
        private TextView X,Y,Z,P_meh,K_meh,Mat_org,Sat_bases,Ctc,Prnt;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_banana);

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
            adapter.addFrag(new Fragment_PlantioBanana(), getText(R.string.plantio).toString());
            adapter.addFrag(new FragmentProducaoBanana(),getText(R.string.producao).toString());
            adapter.addFrag(new ObservacoesBanana(),getText(R.string.tit_obs).toString());
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
            this.P_meh = (TextView) findViewById(R.id.p_meh);
            this.K_meh = (TextView) findViewById(R.id.k_meh);
            this.Mat_org = (TextView) findViewById(R.id.mat_org);
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
                TextView adubo = (TextView) findViewById(R.id.adubo);
                TextView adubo1 = (TextView) findViewById(R.id.adubo1);
                TextView adubo2 = (TextView) findViewById(R.id.adubo2);


                //convertendo string to float
                this.x = Float.parseFloat(X.getText().toString());
                this.y = Float.parseFloat(Y.getText().toString());
                this.z = Float.parseFloat(Z.getText().toString());
                converteToFloat();

                //calculando
                CalculoGeral calculo = new CalculoGeral();
                calculo.setAll(this.x, this.y, this.z, this.p_meh, this.k_meh, this.mat_org, this.sat_bases, this.ctc, this.prnt, 80);
                esterco.setText(String.valueOf(calculo.esterco()));
                superfosfato.setText(String.valueOf(calculo.SSg()));
                calcario.setText(String.valueOf(calculo.calcarioGcova()));
                fte.setText("20");
                calagem.setText(String.valueOf(calculo.calagem()));
                trintadias.setText("100");
                sessentadias.setText("200");
                noventadias.setText("400");
                String tipo_adubo = calculo.adubo4parametros(60,150,300,500);
                adubo.setText(tipo_adubo);
                adubo1.setText(tipo_adubo);
                adubo2.setText(tipo_adubo);

            }


        }
        public int comum(){
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
            if (this.X.getText().toString().isEmpty()|| this.Y.getText().toString().isEmpty()|| this.Z.getText().toString().isEmpty()||
                    this.P_meh.getText().toString().isEmpty()|| this.K_meh.getText().toString().isEmpty()
                    ||this.Sat_bases.getText().toString().isEmpty()|| this.Ctc.getText().toString().isEmpty()|| this.Prnt.getText().toString().isEmpty()
                    || this.Mat_org.getText().toString().isEmpty()  ){
                Toast.makeText(this,getText( R.string.vazio),Toast.LENGTH_SHORT).show();
                return -1;
            }
            converteToFloat();
            this.x = Float.parseFloat(X.getText().toString());
            this.y = Float.parseFloat(Y.getText().toString());
            this.z = Float.parseFloat(Z.getText().toString());
            int dens = (int) (10000/(x*y));
            densidade.setText("= "+dens+" ");
            return dens;
        }
        public void calcularIrrigada(View v){
            int dens  = comum();
            if(dens<0) return;
            CalculoGeral calcula = new CalculoGeral();
            calcula.setAll(this.x, this.y, this.z, this.p_meh, this.k_meh, this.mat_org, this.sat_bases, this.ctc, this.prnt, 70);

            TextView gramasCV1 = (TextView) findViewById(R.id.gramasCV1);
            TextView gramasCV1_2 = (TextView) findViewById(R.id.gramasCV1_2);
            TextView gramasCV2 = (TextView) findViewById(R.id.gramasCV2);
            TextView gramasCV2_2 = (TextView) findViewById(R.id.gramasCV2_2);
            TextView gramasCV3 = (TextView) findViewById(R.id.gramasCV3);
            TextView gramasCV4 = (TextView) findViewById(R.id.gramasCV4);
            TextView calagem = (TextView) findViewById(R.id.calagemP);
            TextView qtdN = (TextView) findViewById(R.id.qtd_n);
            TextView qtdP = (TextView) findViewById(R.id.qtd_p2o5);
            TextView qtdK = (TextView) findViewById(R.id.qtd_k2o);

            int qtdAdubo = (int)((((qtdN()*100)/10)/dens)*1000);
            String qtdSulfato = ""+(int)(1000*((qtdP()*5)/dens));
            String qtdop13 = ""+ qtdAdubo/2;
            String qtdop24 = ""+ qtdAdubo;

            gramasCV1.setText(qtdSulfato);
            gramasCV1_2.setText(qtdop13);
            gramasCV2.setText(qtdSulfato);
            gramasCV2_2.setText(qtdop24);
            gramasCV3.setText(qtdop13);
            gramasCV4.setText(qtdop24);
            calagem.setText(""+calcula.calagem());
            qtdN.setText(""+(int)qtdN());
            qtdP.setText(""+(int)qtdP());
            qtdK.setText(""+(int)qtdK());

            TextView aduboCV1 = (TextView) findViewById(R.id.aduboCV1_2);
            TextView aduboCV2 = (TextView) findViewById(R.id.aduboCV2_2);
            TextView aduboCV3 = (TextView) findViewById(R.id.aduboCV3);
            TextView aduboCV4 = (TextView) findViewById(R.id.aduboCV4);
            String adubo13 = ""+(int) ((qtdK()/(qtdAdubo/2))*100);
            String adubo24 = ""+(int)((qtdK()/(qtdAdubo))*100);
            aduboCV1.setText("20-00-"+adubo13);
            aduboCV2.setText("10-00-"+adubo24);
            aduboCV3.setText("20-"+(int)((qtdP()/(qtdAdubo/2))*100)+"-"+adubo13);
            aduboCV4.setText("10-"+(int)((qtdP()/(qtdAdubo))*100)+"-"+adubo24);

        }
        public double qtdN(){
            double n;
            if(this.mat_org <= 10)n = this.mat_org;
            else n = 10;
            n = (0.68+(7.73*this.z))-(10*n);
            if(n<0) n = 0;
            return n;
        }
        public double qtdP(){
            double n;
            if(this.mat_org <= 10)n = this.mat_org;
            else n = 10;
            n = (75.07+(2.97*this.z)-(3.996*this.p_meh))-(2*n);
            if(n<0) n = 0;
            return n;
        }
        public double qtdK(){
            double n;
            if(this.mat_org <= 10)n = this.mat_org;
            else n = 10;
            n = (138.35+(9.188*this.z)-(0.72*this.k_meh))-(5*n);
            if(n<0) n = 0;
            return n;
        }
        public double qtdNn(){
            double n;
            if(this.mat_org <= 10)n = this.mat_org;
            else n = 10;
            n = (7.73+(7.77*this.z))-(10*n);
            if(n<0) n = 0;
            return n;
        }
        public double qtdPn(){
            double n;
            if(this.mat_org <= 10)n = this.mat_org;
            else n = 10;
            n = (50+(1.8*this.z)-(1.45*this.p_meh))-(2*n);
            if(n<0) n = 0;
            return n;
        }
        public double qtdKn(){
            double n;
            if(this.mat_org <= 10)n = this.mat_org;
            else n = 10;
            n = (77.1+(12.43*this.z)-(0.435*this.k_meh))-(5*n);
            if(n<0) n = 0;
            return n;
        }
        public void calcularNaoIrrigada(View v){
            int dens  = comum();
            if(dens<0) return;
            CalculoGeral calcula = new CalculoGeral();
            calcula.setAll(this.x, this.y, this.z, this.p_meh, this.k_meh, this.mat_org, this.sat_bases, this.ctc, this.prnt, 70);

            TextView gramasCV1 = (TextView) findViewById(R.id.gramasCV1);
            TextView gramasCV1_2 = (TextView) findViewById(R.id.gramasCV1_2);
            TextView gramasCV2 = (TextView) findViewById(R.id.gramasCV2);
            TextView gramasCV2_2 = (TextView) findViewById(R.id.gramasCV2_2);
            TextView gramasCV3 = (TextView) findViewById(R.id.gramasCV3);
            TextView gramasCV4 = (TextView) findViewById(R.id.gramasCV4);
            TextView calagem = (TextView) findViewById(R.id.calagemP);
            TextView qtdN = (TextView) findViewById(R.id.qtd_n);
            TextView qtdP = (TextView) findViewById(R.id.qtd_p2o5);
            TextView qtdK = (TextView) findViewById(R.id.qtd_k2o);

            int qtdAdubo = (int)((((qtdNn()*100)/10)/dens)*1000);
            String qtdSulfato = ""+(int)(1000*((qtdPn()*5)/dens));
            String qtdop13 = ""+ qtdAdubo/2;
            String qtdop24 = ""+ qtdAdubo;

            gramasCV1.setText(qtdSulfato);
            gramasCV1_2.setText(qtdop13);
            gramasCV2.setText(qtdSulfato);
            gramasCV2_2.setText(qtdop24);
            gramasCV3.setText(qtdop13);
            gramasCV4.setText(qtdop24);
            calagem.setText(""+calcula.calagem());
            qtdN.setText(""+(int)qtdNn());
            qtdP.setText(""+(int)qtdPn());
            qtdK.setText(""+(int)qtdKn());

            TextView aduboCV1 = (TextView) findViewById(R.id.aduboCV1_2);
            TextView aduboCV2 = (TextView) findViewById(R.id.aduboCV2_2);
            TextView aduboCV3 = (TextView) findViewById(R.id.aduboCV3);
            TextView aduboCV4 = (TextView) findViewById(R.id.aduboCV4);
            String adubo13 = ""+(int) ((qtdKn()/(qtdAdubo/2))*100-3);
            String adubo24 = ""+(int)((qtdKn()/(qtdAdubo))*100);
            aduboCV1.setText("20-00-"+adubo13);
            aduboCV2.setText("10-00-"+adubo24);
            aduboCV3.setText("20-"+(int)((qtdPn()/(qtdAdubo/2))*100)+"-"+adubo13);
            aduboCV4.setText("10-"+(int)((qtdPn()/(qtdAdubo))*100)+"-"+adubo24);

        }
    }
