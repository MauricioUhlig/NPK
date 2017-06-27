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
    import br.com.softweb.npk.activity.submenu.repetentes.FragmentUmaDoisAnos;
    import br.com.softweb.npk.activity.submenu.repetentes.Fragment_Plantio2V70;
    import br.com.softweb.npk.activity.submenu.repetentes.Observacoes;
    import br.com.softweb.npk.activity.submenu.repetentes.Substrato;
    import br.com.softweb.npk.calculo.CalculoGeral;


    public class Acerola extends AppCompatActivity {
        private float x, y, z, p_meh, k_meh, mat_org, sat_bases, ctc, prnt;
        private Toolbar toolbar;
        private TabLayout tabLayout;
        private ViewPager viewPager;
        private TextView X,Y,Z,P_meh,K_meh,Mat_org,Sat_bases,Ctc,Prnt;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_acerola);

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
            adapter.addFrag(new Observacoes(),getText(R.string.tit_obs).toString());
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
        public void preencheAnalise(int x){
            if(x==0) {
                this.P_meh = (TextView) findViewById(R.id.p_meh);
                this.K_meh = (TextView) findViewById(R.id.k_meh);
                this.Mat_org = (TextView) findViewById(R.id.mat_org);
                this.Sat_bases = (TextView) findViewById(R.id.sat_bases);
                this.Ctc = (TextView) findViewById(R.id.ctc);
                this.Prnt = (TextView) findViewById(R.id.prnt);
            }else if(x==1){
                this.P_meh = (TextView) findViewById(R.id.p_meh1);
                this.K_meh = (TextView) findViewById(R.id.k_meh1);
            }
            else if(x==2){
                this.P_meh = (TextView) findViewById(R.id.p_meh2);
                this.K_meh = (TextView) findViewById(R.id.k_meh2);
            }
            else if(x==3){
                this.Sat_bases = (TextView) findViewById(R.id.sat_bases1);
                this.Ctc = (TextView) findViewById(R.id.ctc1);
                this.Prnt = (TextView) findViewById(R.id.prnt1);
            }
            else if(x==4){
                this.P_meh = (TextView) findViewById(R.id.p_meh3);
                this.K_meh = (TextView) findViewById(R.id.k_meh3);
            }
            else if(x==5){
                this.P_meh = (TextView) findViewById(R.id.p_meh4);
                this.K_meh = (TextView) findViewById(R.id.k_meh4);
            }
            else if(x==6){
                this.Sat_bases = (TextView) findViewById(R.id.sat_bases2);
                this.Ctc = (TextView) findViewById(R.id.ctc2);
                this.Prnt = (TextView) findViewById(R.id.prnt2);
            }
            else if(x==7){
                this.Sat_bases = (TextView) findViewById(R.id.sat_basesP);
                this.Ctc = (TextView) findViewById(R.id.ctcP);
                this.Prnt = (TextView) findViewById(R.id.prntP);
            }
        }
        public void converteToFloat(int x){
            if (x==0){
                this.p_meh = Float.parseFloat(P_meh.getText().toString());
                this.k_meh = Float.parseFloat(K_meh.getText().toString());
                this.mat_org = Float.parseFloat(Mat_org.getText().toString());
                this.sat_bases = Float.parseFloat(Sat_bases.getText().toString());
                this.ctc = Float.parseFloat(Ctc.getText().toString());
                this.prnt = Float.parseFloat(Prnt.getText().toString());
            }
            if (x==1){
                this.p_meh = Float.parseFloat(P_meh.getText().toString());
                this.k_meh = Float.parseFloat(K_meh.getText().toString());
            }
            if (x==2){
                this.sat_bases = Float.parseFloat(Sat_bases.getText().toString());
                this.ctc = Float.parseFloat(Ctc.getText().toString());
                this.prnt = Float.parseFloat(Prnt.getText().toString());
            }
        }


        public void calcularPlantio(View v){
            preencheDim();
            preencheAnalise(0);

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
                converteToFloat(0);

                //calculando
                CalculoGeral calculo = new CalculoGeral();
                calculo.setAll(this.x, this.y, this.z, this.p_meh, this.k_meh, this.mat_org, this.sat_bases, this.ctc, this.prnt, 70);
                esterco.setText(String.valueOf(calculo.esterco()));
                superfosfato.setText(String.valueOf(calculo.SSg()));
                calcario.setText(String.valueOf(calculo.calcarioGcova()));
                fte.setText("20");
                calagem.setText(String.valueOf(calculo.calagem()));
                trintadias.setText("25");
                sessentadias.setText("30");
                noventadias.setText("40");
                adubo.setText(calculo.aduboAbacate());
                adubo1.setText(calculo.aduboAbacate());
                adubo2.setText(calculo.aduboAbacate());

            }


        }
        public void calcularUmano(View v){
            preencheAnalise(1);
            //verificacao de vazio
           if (this.P_meh.getText().toString().isEmpty()|| this.K_meh.getText().toString().isEmpty()
                  // ||this.Sat_bases.getText().toString().isEmpty()|| this.Ctc.getText().toString().isEmpty()|| this.Prnt.getText().toString().isEmpty()
            ){
                Toast.makeText(this,getText( R.string.vazio),Toast.LENGTH_SHORT).show();
                return;
            }
            converteToFloat(1);
            CalculoGeral calcula = new CalculoGeral();
            calcula.setBasic(p_meh,k_meh);
          //  calcula.setSimples(this.p_meh, this.k_meh, this.mat_org, this.sat_bases, this.ctc, this.prnt, 70);
            //primeiro ano
            TextView gramasf12L1 = (TextView) findViewById(R.id.gramasf12L1);
            gramasf12L1.setText("50");
            TextView gramasf12L2 = (TextView) findViewById(R.id.gramasf12L2);
            gramasf12L2.setText("70");
            TextView gramasf12L3 = (TextView) findViewById(R.id.gramasf12L3);
            gramasf12L3.setText("100");
            String adubo = "20-00-20";
            TextView adubof12L1 = (TextView) findViewById(R.id.adubof12L1);
            TextView adubof12L2 = (TextView) findViewById(R.id.adubof12L2);
            TextView adubof12L3 = (TextView) findViewById(R.id.adubof12L3);
            adubof12L1.setText(adubo);
            adubof12L2.setText(adubo);
            adubof12L3.setText(adubo);


        }
        public void calcularDoisano(View v){
            preencheAnalise(2);
            //verificacao de vazio
            if (this.P_meh.getText().toString().isEmpty()|| this.K_meh.getText().toString().isEmpty()
                // ||this.Sat_bases.getText().toString().isEmpty()|| this.Ctc.getText().toString().isEmpty()|| this.Prnt.getText().toString().isEmpty()
                    ){
                Toast.makeText(this,getText( R.string.vazio),Toast.LENGTH_SHORT).show();
                return;
            }
            converteToFloat(1);
            CalculoGeral calcula = new CalculoGeral();
            calcula.setBasic(p_meh,k_meh);
            //  calcula.setSimples(this.p_meh, this.k_meh, this.mat_org, this.sat_bases, this.ctc, this.prnt, 70);
            //primeiro ano
            TextView gramasf2L1 = (TextView) findViewById(R.id.gramasf2L1);
            gramasf2L1.setText(""+5*calcula.fosforo());
            TextView gramasf2L2 = (TextView) findViewById(R.id.gramasf2L2);
            gramasf2L2.setText("200");
            String adubo = calcula.adubo4parametros(60,120,200,280);
            TextView adubof2L1 = (TextView) findViewById(R.id.adubof2L1);
            TextView adubof2L2 = (TextView) findViewById(R.id.adubof2L2);
            adubof2L1.setText("Superfosfato simples");
            adubof2L2.setText(adubo);
        }
        public void calcularCalagem(View v){
            preencheAnalise(3);
            //verificacao de vazio
            if (this.Sat_bases.getText().toString().isEmpty()|| this.Ctc.getText().toString().isEmpty()|| this.Prnt.getText().toString().isEmpty()
                    ){
                Toast.makeText(this,getText( R.string.vazio),Toast.LENGTH_SHORT).show();
                return;
            }
            converteToFloat(2);
            CalculoGeral calcula = new CalculoGeral();
            calcula.setCalagem(60, sat_bases, ctc, prnt);
            TextView calagem = (TextView) findViewById(R.id.calagemf12);
            calagem.setText(""+calcula.calagem());
        }
        public float fosforo(){
            if(p_meh<10)return 150;
            else if(p_meh>=10 && p_meh<20)return 100;
            else if (p_meh>=20 && p_meh<50)return 80;
            else return 0;
        }
        public void calcularTresano(View v){
            preencheAnalise(4);
            //verificacao de vazio
            if (this.P_meh.getText().toString().isEmpty()|| this.K_meh.getText().toString().isEmpty()
                // ||this.Sat_bases.getText().toString().isEmpty()|| this.Ctc.getText().toString().isEmpty()|| this.Prnt.getText().toString().isEmpty()
                    ){
                Toast.makeText(this,getText( R.string.vazio),Toast.LENGTH_SHORT).show();
                return;
            }
            converteToFloat(1);
            CalculoGeral calcula = new CalculoGeral();
            calcula.setBasic(p_meh,k_meh);
            //  calcula.setSimples(this.p_meh, this.k_meh, this.mat_org, this.sat_bases, this.ctc, this.prnt, 70);
            TextView gramasf3L1 = (TextView) findViewById(R.id.gramasf3L1);
            gramasf3L1.setText(""+5*fosforo());
            TextView gramasf3L2 = (TextView) findViewById(R.id.gramasf3L2);
            gramasf3L2.setText("300");
            String adubo = calcula.adubo4parametros(60,120,200,280);
            TextView adubof3L1 = (TextView) findViewById(R.id.adubof3L1);
            TextView adubof3L2 = (TextView) findViewById(R.id.adubof3L2);
            adubof3L1.setText("Superfosfato simples");
            adubof3L2.setText(adubo);
        }
        public void calcularQuartoano(View v){
            preencheAnalise(5);
            //verificacao de vazio
            if (this.P_meh.getText().toString().isEmpty()|| this.K_meh.getText().toString().isEmpty()
                // ||this.Sat_bases.getText().toString().isEmpty()|| this.Ctc.getText().toString().isEmpty()|| this.Prnt.getText().toString().isEmpty()
                    ){
                Toast.makeText(this,getText( R.string.vazio),Toast.LENGTH_SHORT).show();
                return;
            }
            converteToFloat(1);
            CalculoGeral calcula = new CalculoGeral();
            calcula.setBasic(p_meh,k_meh);
            //  calcula.setSimples(this.p_meh, this.k_meh, this.mat_org, this.sat_bases, this.ctc, this.prnt, 70);
            TextView gramasf4L1 = (TextView) findViewById(R.id.gramasf4L1);
            gramasf4L1.setText(""+5*fosforo());
            TextView gramasf4L2 = (TextView) findViewById(R.id.gramasf4L2);
            gramasf4L2.setText("300");
            String adubo = calcula.adubo4parametros(60,120,200,280);
            TextView adubof4L1 = (TextView) findViewById(R.id.adubof4L1);
            TextView adubof4L2 = (TextView) findViewById(R.id.adubof4L2);
            adubof4L1.setText("Superfosfato simples");
            adubof4L2.setText(adubo);
        }
        public void calcularCalagem2(View v){
            preencheAnalise(6);
            //verificacao de vazio
            if (this.Sat_bases.getText().toString().isEmpty()|| this.Ctc.getText().toString().isEmpty()|| this.Prnt.getText().toString().isEmpty()
                    ){
                Toast.makeText(this,getText( R.string.vazio),Toast.LENGTH_SHORT).show();
                return;
            }
            converteToFloat(2);
            CalculoGeral calcula = new CalculoGeral();
            calcula.setCalagem(60, sat_bases, ctc, prnt);
            TextView calagem = (TextView) findViewById(R.id.calagemf34);
            calagem.setText(""+calcula.calagem());
        }

        public void calcularProducao(View v){
            this.X = (TextView) findViewById(R.id.espa1);
            this.Y = (TextView) findViewById(R.id.espa2);
            TextView densidade = (TextView) findViewById(R.id.densidade_plantas);
            this.Z = (TextView) findViewById(R.id.produtividade);
            this.P_meh = (TextView) findViewById(R.id.p_mehP);
            this.K_meh = (TextView) findViewById(R.id.k_mehP);
            if (this.X.getText().toString().isEmpty()|| this.Y.getText().toString().isEmpty()|| this.Z.getText().toString().isEmpty()||
                    this.P_meh.getText().toString().isEmpty()|| this.K_meh.getText().toString().isEmpty()
                // ||this.Sat_bases.getText().toString().isEmpty()|| this.Ctc.getText().toString().isEmpty()|| this.Prnt.getText().toString().isEmpty()
                    ){
                Toast.makeText(this,getText( R.string.vazio),Toast.LENGTH_SHORT).show();
                return;
            }
            converteToFloat(1);
            this.x = Float.parseFloat(X.getText().toString());
            this.y = Float.parseFloat(Y.getText().toString());
            this.z = Float.parseFloat(Z.getText().toString());
            densidade.setText("= "+(10000/(x*y))+" ");
            float var;
            if (p_meh<10)var=100;
            else if (p_meh>=10 && p_meh<20)var=80;
            else if (p_meh>=20 && p_meh<50)var= 40;
            else var=0;
            var=(1000*((5*var)/(10000/(x*y))));
            TextView gramaPl1 = (TextView) findViewById(R.id.gramasPL1);
            gramaPl1.setText(""+var);
            if (z<15)var=50;
            else if(z>=15 && z<20)var = 70;
            else if (z>=20 && z<30)var=90;
            else var = 130;
            var= ((1000*((var*5)/(10000/(x*y))))/3);
            TextView gramasPl2 = (TextView) findViewById(R.id.gramasPL2);
            gramasPl2.setText(""+var);
            TextView aduboPl1 = (TextView)findViewById(R.id.aduboPL1);
            aduboPl1.setText("Superfosfato simples");
            TextView aduboPl2 = (TextView)findViewById(R.id.aduboPL2);
            CalculoGeral calculoGeral = new CalculoGeral();
            calculoGeral.setBasic(p_meh,k_meh);
            aduboPl2.setText(calculoGeral.adubo4parametros(60,120,200,280));


        }
        public void calcularCalagemP(View v){
            preencheAnalise(7);
            //verificacao de vazio
            if (this.Sat_bases.getText().toString().isEmpty()|| this.Ctc.getText().toString().isEmpty()|| this.Prnt.getText().toString().isEmpty()
                    ){
                Toast.makeText(this,getText( R.string.vazio),Toast.LENGTH_SHORT).show();
                return;
            }
            converteToFloat(2);
            CalculoGeral calcula = new CalculoGeral();
            calcula.setCalagem(70, sat_bases, ctc, prnt);
            TextView calagem = (TextView) findViewById(R.id.calagemP);
            calagem.setText(""+calcula.calagem());
        }
    }
