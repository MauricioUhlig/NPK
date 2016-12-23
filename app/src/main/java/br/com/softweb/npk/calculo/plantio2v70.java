package br.com.softweb.npk.calculo;

/**
 * Created by User on 22/12/2016.
 */

public class plantio2v70 {

    private float x, y, z, p, k, mat, sat, ctc, prnt;
    public plantio2v70 (float x, float y, float z, float p, float k,float mat, float sat, float ctc, float prnt){
        this.x = x;
        this.y = y;
        this.z = z;
        this.p = p;
        this.k = k;
        this.mat = mat;
        this.sat = sat;
        this.ctc = ctc;
        this.prnt = prnt;
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
}
