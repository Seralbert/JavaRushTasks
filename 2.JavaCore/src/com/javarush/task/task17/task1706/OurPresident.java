package com.javarush.task.task17.task1706;

public class OurPresident {
    private static OurPresident president; //1

    private OurPresident() { //3
    }

    static { //4
        if(president == null){
            synchronized (OurPresident.class){
                if (president == null){
                    president = new OurPresident(); //5
                }
            }
        }
    }

    public static OurPresident getOurPresident() { //2
    /*
    не катит
    if(president == null){
            synchronized (OurPresident.class){
                if (president == null){
                    president = new OurPresident();
                }
            }
        }*/

        return president;
    }
}
