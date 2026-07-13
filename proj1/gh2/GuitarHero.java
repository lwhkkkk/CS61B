package gh2;

import edu.princeton.cs.algs4.StdAudio;
import edu.princeton.cs.algs4.StdDraw;

public class GuitarHero {
    private static final  String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";

    public static void main(String[] args){
        GuitarString[] strings = new GuitarString[37];

        for(int i = 0 ; i < 37 ;i++){
        double frequency = 440.0 * Math.pow (2.0,(i - 24.0)/12.0);
           strings[i] =   new GuitarString(frequency);
        }

        while (true){
            if (StdDraw.hasNextKeyTyped()){
                char key = StdDraw.nextKeyTyped();
                int number = keyboard.indexOf(key);
                if (number != -1){
                    strings[number].pluck();
                }

            }
            double sample =0.0;
            for ( int i =0; i< 37 ;i++){
                sample = sample + strings [i].sample() ;
            }
              StdAudio.play(sample);

            for(int i =0; i < 37; i++){
                strings[i].tic();
            }
        }
    }
}
