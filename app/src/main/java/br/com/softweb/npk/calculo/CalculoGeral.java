package br.com.softweb.npk.calculo;

/**
 * Created by User on 27/12/2016.
 */

public class CalculoGeral {

    private float x, y, z, p, k, mat, sat, ctc, prnt;
    int cte1;
    public CalculoGeral (){
    }
    public void setAll(float x, float y, float z, float p, float k,float mat, float sat, float ctc, float prnt, int cte1){
        this.x = x;
        this.y = y;
        this.z = z;
        this.p = p;
        this.k = k;
        this.mat = mat;
        this.sat = sat;
        this.ctc = ctc;
        this.prnt = prnt;
        this.cte1 = cte1;
    }
    public void setSimples(float p, float k,float mat, float sat, float ctc, float prnt , int cte1){
        this.p = p;
        this.k= k;
        this.mat = mat;
        this.sat = sat;
        this.ctc = ctc;
        this.prnt = prnt;
        this.cte1 = cte1;
    }
    public void setBasic(float p, float k){
        this.p = p;
        this.k= k;
    }
    public void setCalagem(int cte1,float sat, float ctc, float prnt){
        this.sat = sat;
        this.ctc = ctc;
        this.prnt = prnt;
        this.cte1 = cte1;
    }

    public float volumeCova(){
        return ((x*y*z)/1000);
    }


    public float esterco(){
        if(mat<1)return 15;
        else if(mat>=1 && mat<3)return 10;
        else if (mat>=3 && mat<5)return 7;
        else return 5;
    }

    public float SSg(){
        double ssg =(((((80-p)/0.2)*volumeCova())/1000)*2.3*5);
        if(ssg>0) {
            return (float) ssg;
        }
        return 0;
    }

    public float SSgAbacaxi(){
        float ssg;
        if(p<20)ssg=10;
        else if (p>=20 && p<40)ssg=5;
        else if (p>=40 && p<60)ssg=3;
        else ssg=0;
        if(ssg>0) {
            return ssg;
        }
        return 0;
    }

    public float SSgAbobRaste(){
        float ssg;
        if(p<20)ssg=230;
        else if (p>=20 && p<60)ssg=180;
        else if (p>=60 && p<100)ssg=130;
        else if (p>100 && p<150)ssg=80;
        else ssg=0;
        if(ssg>0) {
            return ssg;
        }
        return 0;
    }

    public float SSgBatata(){
        float ssg;
        if(p<20)ssg=140;
        else if (p>=20 && p<60)ssg=100;
        else if (p>=60 && p<100)ssg=60;
        else if (p>100 && p<150)ssg=30;
        else ssg=0;
        if(ssg>0) {
            return ssg;
        }
        return 0;
    }

    public float SSgBatataDoce(){
        float ssg;
        if(p<10)ssg=100;
        else if (p>=10 && p<20)ssg=80;
        else if (p>=20 && p<100)ssg=60;
        else if (p>100 && p<200)ssg=50;
        else ssg=0;
        if(ssg>0) {
            return ssg;
        }
        return 0;
    }

    public float SSgBerinjela(){
        float ssg;
        if(p<20)ssg=150;
        else if (p>=20 && p<60)ssg=100;
        else if (p>=60 && p<100)ssg=80;
        else if (p>100 && p<150)ssg=50;
        else ssg=0;
        if(ssg>0) {
            return ssg;
        }
        return 0;
    }
    public float SSgBrocolos(){
        float ssg;
        if(p<20)ssg=400;
        else if (p>=20 && p<60)ssg=300;
        else if (p>=60 && p<100)ssg=100;
        else if (p>100 && p<150)ssg=50;
        else ssg=0;
        if(ssg>0) {
            return ssg;
        }
        return 0;
    }

    public float SSgAbobMoita(){
        float ssg;
        if(p<20)ssg=100;
        else if (p>=20 && p<60)ssg=80;
        else if (p>=60 && p<100)ssg=60;
        else if (p>100 && p<150)ssg=40;
        else ssg=0;
        if(ssg>0) {
            return ssg;
        }
        return 0;
    }

    public float SSgArrozInundado(){
        float ssg;
        if(p<10)ssg=90;
        else if (p>=10 && p<20)ssg=60;
        else if (p>=20 && p<100)ssg=30;
        else ssg=0;
        return  (((ssg/densidadeArroz())*1000)*5);
    }

    public float SSgArrozSequeiro(){
        float ssg;
        if(p<10)ssg=75;
        else if (p>=10 && p<20)ssg=50;
        else if (p>=20 && p<100)ssg=25;
        else ssg=0;
        return  (((ssg/densidadeArroz())*1000)*5);
    }

    public float densidadeArroz(){
        return ((100/(x/100))*100);
    }

    public float qtdArroz(int c){
        return ((c/densidadeArroz())*5000);
    }

    public  float SSgAlgodao(){
        float ssg;
        if(p<10)ssg=100;
        else if(p>=10 && p<20)ssg=70;
        else if(p>=20 && p<100)ssg=40;
        else if(p>=100 && p<200)ssg=20;
        else ssg=0;
        ssg = (ssg/10)*5;
        return ssg;
    }

    public float calcarioTha(){
        return (((cte1-sat)*ctc)/prnt);
    }

    public float calcarioGcova(){
        float x = ((calcarioTha()/2)*volumeCova());
        if(x>0) return x;
        return 0;
    }

    public float calagem(){
        float x = (((cte1-sat)*ctc)/prnt);
        if(x>0)return x;
        return 0;
    }

    public String aduboAbacate(){
        if (k<60)return "20-00-20";
        else if (k>=60 && k<120) return "20-00-15";
        else if (k>=120 && k<220) return "20-00-10";
        else return "Sulfato de Amônio";
    }
    public float fosforoAmeixa(){
        if (p<10)return 100;
        else if(p>=10 && p<20)return 80;
        else if(p>=20 && p<40)return 40;
        else if(p>=40 && p<60)return 20;
        else return 0;
    }
    public float fosforo(){
        if (p<10)return 100;
        else if(p>=10 && p<20)return 80;
        else if(p>=20 && p<50)return 40;
        else return 0;
    }
    public String adubo4parametros(int a, int b, int c, int d){
        if(k<a)return "20-00-30";
        else if(k>=a && k<b) return "20-00-20";
        else if (k>=b && k<c)return "20-00-15";
        else if (k>=c && k<d)return "20-00-10";
        else return "Sulfato de Amônio";

    }
}
