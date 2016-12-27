package br.com.softweb.npk.calculo;

/**
 * Created by User on 27/12/2016.
 */

public class CalculoGeral {

    private float x, y, z, p, k, mat, sat, ctc, prnt;
    int cte1, cte2, cte3;
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
    public void setSimples(float p, float k, float sat, float ctc, float prnt , int cte1, int cte2, int cte3){
        this.p = p;
        this.k= k;
        this.sat = sat;
        this.ctc = ctc;
        this.prnt = prnt;
        this.cte1 = cte1;
        this.cte2 = cte2;
        this.cte3 = cte3;
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
}
